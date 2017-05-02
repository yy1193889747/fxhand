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
 * Cycarts entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cycarts", catalog = "cyporj")
@Proxy(lazy = false)
public class Cycarts implements java.io.Serializable {

	// Fields

	private Integer cycartid;
	private Cygoods cygoods;
	private Cyusers cyusers;

	// Constructors

	/** default constructor */
	public Cycarts() {
	}

	/** full constructor */
	public Cycarts(Cygoods cygoods, Cyusers cyusers) {
		this.cygoods = cygoods;
		this.cyusers = cyusers;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cycartid", unique = true, nullable = false)
	public Integer getCycartid() {
		return this.cycartid;
	}

	public void setCycartid(Integer cycartid) {
		this.cycartid = cycartid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cygid", nullable = false)
	public Cygoods getCygoods() {
		return this.cygoods;
	}

	public void setCygoods(Cygoods cygoods) {
		this.cygoods = cygoods;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cyuid", nullable = false)
	public Cyusers getCyusers() {
		return this.cyusers;
	}

	public void setCyusers(Cyusers cyusers) {
		this.cyusers = cyusers;
	}

}