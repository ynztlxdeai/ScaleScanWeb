package com.moyansz.vo;

import java.io.Serializable;

public class Account implements Serializable {
	/** */ 
	private static final long serialVersionUID = 2572160444424822301L;
	/** */ 
	// id
	private Integer uid;
	// '注册通行证账号名'
	private String acc;

	// '登录密码',//大写样式32位md5值
	private String pwd;

	// '绑定手机号码'
	private String phone;

	// '绑定密保邮箱'
	private String email;

	// '手机验证码'
	private String code;

	// 注册来源(1=网站,2=移动设备)
	private Integer src;

	// （1=后台产生,2=输入uid有效）
	private Integer genid;

	// (1=无验证码无手机号，2=有验证码有手机号,3=无验证码有手机号）
	private Integer ncd;

	// (1=无邮箱,2=邮箱默认激活,3=邮箱默认不激活）
	private Integer acmail;
	// 头像图片url
	private String img_url;
	// 个性签名
	private String sign;
	// 性别(1=男,2=女,0=未设)
	private Integer sex;
	// 真实姓名
	private String rname;
	// 身份证号
	private String idcard;
	// 昵称
	private String nick;
	
	private Integer reg_sys;
	/**
	 * 是否是VIP
	 */
	private Integer[] vip;
	
	/**
	 * 升级vip时传参  格式为：vips:{1,2}
	 */
	private String vips;
	
	/**
	 * 邮箱激活状态(1=无,2=激活,3=未激活）
	 */
	private Integer st_mail;
	/**
	 * 手机激活状态(1=无,2=激活,3=未激活）
	 */
	private Integer st_ph;
	/**
	 * 锁定时间 秒为单位
	 */
	
	private Integer life;
	private Integer regtime;
	private Integer st_use;
	/**
	 * 用户信息最近一次更新时间戳秒数
	 */
	private Integer update;
	/**
	 * 登陆输入密码错误剩余次数，由网关服务端提供
	 */
	private Integer rest_cnt;
	// 系统业务编号
	private Integer sys_id;
	private String bus_seq;
	private String ip;
	//用户操作的终端设备物理网卡地址
	private String mac;
	private Integer dev;
	// 1=验证后验证码失效，2=验证后验证码保留有效性
	private Integer del;
	
	
	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Integer getDev() {
		return dev;
	}

	public void setDev(Integer dev) {
		this.dev = dev;
	}

	public String getBus_seq() {
		return bus_seq;
	}

	public void setBus_seq(String bus_seq) {
		this.bus_seq = bus_seq;
	}

	public Integer getSys_id() {
		return sys_id;
	}

	public void setSys_id(Integer sys_id) {
		this.sys_id = sys_id;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSrc() {
		return src;
	}

	public void setSrc(Integer src) {
		this.src = src;
	}

	public Integer getGenid() {
		return genid;
	}

	public void setGenid(Integer genid) {
		this.genid = genid;
	}
	
  
	public String getVips() {
		return vips;
	}

	public void setVips(String vips) {
		this.vips = vips;
	}

	/**   
	 * reg_sys   
	 *   
	 * @return  the reg_sys   
	 * @since   1.0.0   
	 */
	
	public Integer getReg_sys() {
		return reg_sys;
	}

	/**   
	 * @param reg_sys the reg_sys to set   
	 */
	public void setReg_sys(Integer reg_sys) {
		this.reg_sys = reg_sys;
	}

	public Integer getNcd() {
		return ncd;
	}

	public void setNcd(Integer ncd) {
		this.ncd = ncd;
	}

	public Integer getAcmail() {
		return acmail;
	}

	public void setAcmail(Integer acmail) {
		this.acmail = acmail;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	
	/**   
	 * st_use   
	 *   
	 * @return  the st_use   
	 * @since   1.0.0   
	 */
	
	public Integer getSt_use() {
		return st_use;
	}

	/**   
	 * @param st_use the st_use to set   
	 */
	public void setSt_use(Integer st_use) {
		this.st_use = st_use;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**   
	 * life   
	 *   
	 * @return  the life   
	 * @since   1.0.0   
	 */
	
	public Integer getLife() {
		return life;
	}

	/**   
	 * @param life the life to set   
	 */
	public void setLife(Integer life) {
		this.life = life;
	}

	/**   
	 * st_mail   
	 *   
	 * @return  the st_mail   
	 * @since   1.0.0   
	 */
	
	public Integer getSt_mail() {
		return st_mail;
	}

	/**   
	 * @param st_mail the st_mail to set   
	 */
	public void setSt_mail(Integer st_mail) {
		this.st_mail = st_mail;
	}

	/**   
	 * st_ph   
	 *   
	 * @return  the st_ph   
	 * @since   1.0.0   
	 */
	
	public Integer getSt_ph() {
		return st_ph;
	}

	
	/**   
	 * regtime   
	 *   
	 * @return  the regtime   
	 * @since   1.0.0   
	 */
	
	public Integer getRegtime() {
		return regtime;
	}

	/**   
	 * @param regtime the regtime to set   
	 */
	public void setRegtime(Integer regtime) {
		this.regtime = regtime;
	}

	/**   
	 * @param st_ph the st_ph to set   
	 */
	public void setSt_ph(Integer st_ph) {
		this.st_ph = st_ph;
	}

	/**   
	 * rest_cnt   
	 *   
	 * @return  the rest_cnt   
	 * @since   1.0.0   
	 */
	
	public Integer getRest_cnt() {
		return rest_cnt;
	}

	/**   
	 * @param rest_cnt the rest_cnt to set   
	 */
	public void setRest_cnt(Integer rest_cnt) {
		this.rest_cnt = rest_cnt;
	}

	public Account(Integer uid, String acc, String pwd, String phone, String email, String code, Integer src, Integer genid, Integer ncd, Integer acmail, String img_url, String sign, Integer sex, String rname, String idcard, String nick, Integer reg_sys, Integer st_mail, Integer st_ph, Integer life, Integer regtime, Integer st_use, Integer rest_cnt) {
		super();
		this.uid = uid;
		this.acc = acc;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
		this.code = code;
		this.src = src;
		this.genid = genid;
		this.ncd = ncd;
		this.acmail = acmail;
		this.img_url = img_url;
		this.sign = sign;
		this.sex = sex;
		this.rname = rname;
		this.idcard = idcard;
		this.nick = nick;
		this.reg_sys = reg_sys;
		this.st_mail = st_mail;
		this.st_ph = st_ph;
		this.life = life;
		this.regtime = regtime;
		this.st_use = st_use;
		this.rest_cnt = rest_cnt;
	}
	public Account(){}

	/**   
	 * update   
	 *   
	 * @return  the update   
	 * @since   1.0.0   
	 */
	
	public Integer getUpdate() {
		return update;
	}

	/**   
	 * @param update the update to set   
	 */
	public void setUpdate(Integer update) {
		this.update = update;
	}

	
	public Integer[] getVip()
	{
		return vip;
	}

	
	public void setVip(Integer[] vip)
	{
		this.vip = vip;
	}

	


}
