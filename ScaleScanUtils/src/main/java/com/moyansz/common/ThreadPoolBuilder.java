
package com.moyansz.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程池工具类
 * 
 * @author 李珑
 * 
 */
public final class ThreadPoolBuilder {
	private static final AtomicInteger POOL_COUNTER = new AtomicInteger(0);

	private int minCount = Runtime.getRuntime().availableProcessors();

	private int maxCount = 2147483647;

	private long aliveMillis = 60000L;

	private String groupName = "oms";

	private boolean daemon = false;

	private RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

	public static final ThreadPoolBuilder newBuilder() {
		return new ThreadPoolBuilder();
	}

	public ThreadPoolBuilder coreSize(int core) {
		this.minCount = core;
		return this;
	}

	public ThreadPoolBuilder maxSize(int max) {
		this.maxCount = max;
		return this;
	}

	public ThreadPoolBuilder aliveMillis(long alive) {
		this.aliveMillis = alive;
		return this;
	}

	public ThreadPoolBuilder group(String group) {
		this.groupName = group;
		return this;
	}

	public ThreadPoolBuilder daemon(boolean isDaemon) {
		this.daemon = isDaemon;
		return this;
	}

	public ThreadPoolBuilder rejectedHandler(RejectedExecutionHandler h) {
		this.handler = h;
		return this;
	}

	public ExecutorService build(String prefixName) {
		ThreadFactory f = new NMSSThreadFactory(this.groupName, prefixName, this.daemon);
		ExecutorService pool = new ThreadPoolExecutor(this.minCount, this.maxCount, this.aliveMillis,
				TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), f, this.handler);
		return pool;
	}

	public static class NMSSThreadFactory implements ThreadFactory {
		private final AtomicLong counter = new AtomicLong(0L);
		private final int poolId;
		private final ThreadGroup group;
		private final String prefix;
		private final boolean daemon;

		public NMSSThreadFactory(String groupName, String prefix, boolean daemon) {
			this.poolId = ThreadPoolBuilder.POOL_COUNTER.incrementAndGet();
			this.group = new ThreadGroup(groupName);
			this.prefix = prefix;
			this.daemon = daemon;
		}

		public Thread newThread(Runnable r) {
			String name = String.format("Pool-%d-%s-%d", new Object[] { Integer.valueOf(this.poolId), this.prefix,
					Long.valueOf(this.counter.incrementAndGet()) });
			Thread thread = new Thread(this.group, r, name);
			thread.setDaemon(this.daemon);
			return thread;
		}
	}
}
