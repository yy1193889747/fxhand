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
 * Cywant entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cywant", catalog = "cyporj")
@Proxy(lazy = false)
public class Cywant implements java.io.Serializable {

	// Fields

	private Integer cywid;
	private Cyusers cyusers;
	private String cywtitle;
	private String cywstr;
	private Integer cywprice;
	private String cywdate;

	// Constructors

	/** default constructor */
	public Cywant() {
	}

	/** full constructor */
	public Cywant(Cyusers cyusers, String cywtitle, String cywstr,
			Integer cywprice, String cywdate) {
		this.cyusers = cyusers;
		this.cywtitle = cywtitle;
		this.cywstr = cywstr;
		this.cywprice = cywprice;
		this.cywdate = cywdate;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cywid", unique = true, nullable = false)
	public Integer getCywid() {
		return this.cywid;
	}

	public void setCywid(Integer cywid) {
		this.cywid = cywid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cyuid")
	public Cyusers getCyusers() {
		return this.cyusers;
	}

	public void setCyusers(Cyusers cyusers) {
		this.cyusers = cyusers;
	}

	@Column(name = "cywtitle", length = 50)
	public String getCywtitle() {
		return this.cywtitle;
	}

	public void setCywtitle(String cywtitle) {
		this.cywtitle = cywtitle;
	}

	@Column(name = "cywstr", length = 150)
	public String getCywstr() {
		return this.cywstr;
	}

	public void setCywstr(String cywstr) {
		this.cywstr = cywstr;
	}

	@Column(name = "cywprice")
	public Integer getCywprice() {
		return this.cywprice;
	}

	public void setCywprice(Integer cywprice) {
		this.cywprice = cywprice;
	}

	@Column(name = "cywdate", length = 50)
	public String getCywdate() {
		return this.cywdate;
	}

	public void setCywdate(String cywdate) {
		this.cywdate = cywdate;
	}

}