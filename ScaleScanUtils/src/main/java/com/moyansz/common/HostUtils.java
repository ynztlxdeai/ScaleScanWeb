
package com.moyansz.common;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.log4j.Logger;

/**
 * 主机工具类
 * 
 * @author lilong
 * 
 */
public final class HostUtils {
    private static Logger logger = Logger.getLogger(HostUtils.class);

    private static Set<String> localCache = new CopyOnWriteArraySet<String>();
    private static Set<String> remoteCache = new CopyOnWriteArraySet<String>();

    static {
	localCache.add("0.0.0.0");
	localCache.add("localhost");
	localCache.add("127.0.0.1");
	try {
	    InetAddress local = InetAddress.getLocalHost();
	    localCache.add(local.getHostAddress());
	    localCache.add(local.getHostName());
	} catch (UnknownHostException localUnknownHostException) {
	    logger.warn("Failed to getLocalHost");
	}
    }

    /**
     * 是否为本机IP地址
     * 
     * @param host
     * @return
     */
    public static final boolean isLocalAddress(String host) {
	if (localCache.contains(host)) {
	    return true;
	}
	if (remoteCache.contains(host)) {
	    return false;
	}
	synchronized (HostUtils.class) {
	    for (int i = 0; i < 5; i++) {
		ServerSocket ss = null;
		try {
		    InetAddress net = InetAddress.getByName(host);
		    ss = new ServerSocket(50000 + i, 1, net);
		    ss.setReuseAddress(true);

		    localCache.add(host);

		    if (ss != null)
			try {
			    ss.close();
			} catch (IOException e) {
			    e.getMessage();
			}
		    return true;
		} catch (UnknownHostException e) {
		    e.getMessage();
		} catch (IOException e) {
		    e.getMessage();
		} finally {
		    if (ss != null) {
			try {
			    ss.close();
			} catch (IOException e) {
			    e.getMessage();
			}
		    }
		}
	    }
	}
	remoteCache.add(host);
	return false;
    }

    /**
     * 端口是否被占用
     * 
     * @param port
     * @return
     */
    public static final boolean isFreePort(int port) {
	ServerSocket ss = null;
	boolean free = false;
	try {
	    ss = new ServerSocket(port);
	    ss.setReuseAddress(true);
	    free = true;
	} catch (IOException localIOException1) {
	    free = false;

	    if (ss != null)
		try {
		    ss.close();
		} catch (IOException e) {
		    e.getMessage();
		}
	} finally {
	    if (ss != null) {
		try {
		    ss.close();
		} catch (IOException e) {
		    e.getMessage();
		}
	    }
	}
	return free;
    }

    /**
     * 由主机名得到IP
     * 
     * @param host
     * @return
     */
    public static final String hostIP(String host) {
	InetAddress ip = hostAddress(host);
	if (ip != null) {
	    return ip.getHostAddress();
	}
	return null;
    }

    public static final InetAddress hostAddress(String host) {
	InetAddress net = null;
	try {
	    net = InetAddress.getByName(host);
	} catch (UnknownHostException e) {
	    e.getMessage();
	}
	return net;
    }

    public static final int randomFreePort() {
	return randomFreePort(1024);
    }

    public static final int randomFreePort(int start) {
	int port = start;

	if (start <= 0)
	    port = 1024;
	while (true) {
	    if (isFreePort(port)) {
		return port;
	    }
	    port++;
	}
    }
}
