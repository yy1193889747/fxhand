package com.cyporj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * Cymsg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cymsg", catalog = "cyporj")
@Proxy(lazy = false)
public class Cymsg implements java.io.Serializable {

	// Fields

	private Integer msgid;
	private Cyusers cyusers;
	private String msgstr;
	private String msgdata;

	// Constructors

	/** default constructor */
	public Cymsg() {
	}

	/** full constructor */
	public Cymsg(Cyusers cyusers, String msgstr, String msgdata) {
		this.cyusers = cyusers;
		this.msgstr = msgstr;
		this.msgdata = msgdata;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "msgid", unique = true, nullable = false)
	public Integer getMsgid() {
		return this.msgid;
	}

	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cyuid")
	public Cyusers getCyusers() {
		return this.cyusers;
	}

	public void setCyusers(Cyusers cyusers) {
		this.cyusers = cyusers;
	}

	@Column(name = "msgstr", length = 150)
	public String getMsgstr() {
		return this.msgstr;
	}

	public void setMsgstr(String msgstr) {
		this.msgstr = msgstr;
	}

	@Column(name = "msgdata", length = 50)
	public String getMsgdata() {
		return this.msgdata;
	}

	public void setMsgdata(String msgdata) {
		this.msgdata = msgdata;
	}

}