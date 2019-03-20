package cn.kgc.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/3/20 0020.
 */
public class TableToObject implements Serializable{
	//多方所有字段
	private Integer sid;
	private String sname;
	private String password;
	private String subject;
	private Integer cid;
	//异常除了主键的所有字段
	private String cname;


	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "TableToObject{" +
				"sid=" + sid +
				", sname='" + sname + '\'' +
				", password='" + password + '\'' +
				", subject='" + subject + '\'' +
				", cid=" + cid +
				", cname='" + cname + '\'' +
				'}';
	}

	public TableToObject(Integer sid, String sname, String password, String subject, Integer cid, String cname) {
		this.sid = sid;
		this.sname = sname;
		this.password = password;
		this.subject = subject;
		this.cid = cid;
		this.cname = cname;
	}

	public TableToObject() {

	}

	public TableToObject(Integer sid) {
		this.sid = sid;
	}
}
