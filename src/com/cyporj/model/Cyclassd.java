package com.cyporj.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * Cyclassd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cyclassd", catalog = "cyporj")
@Proxy(lazy = false)
public class Cyclassd implements java.io.Serializable {

	// Fields

	private Integer cdid;
	private Cyclassg cyclassg;
	private String cdname;
	private Set<Cygoods> cygoodses = new HashSet<Cygoods>(0);

	// Constructors

	/** default constructor */
	public Cyclassd() {
	}

	/** minimal constructor */
	public Cyclassd(Cyclassg cyclassg) {
		this.cyclassg = cyclassg;
	}

	/** full constructor */
	public Cyclassd(Cyclassg cyclassg, String cdname, Set<Cygoods> cygoodses) {
		this.cyclassg = cyclassg;
		this.cdname = cdname;
		this.cygoodses = cygoodses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cdid", unique = true, nullable = false)
	public Integer getCdid() {
		return this.cdid;
	}

	public void setCdid(Integer cdid) {
		this.cdid = cdid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cgid", nullable = false)
	public Cyclassg getCyclassg() {
		return this.cyclassg;
	}

	public void setCyclassg(Cyclassg cyclassg) {
		this.cyclassg = cyclassg;
	}

	@Column(name = "cdname", length = 50)
	public String getCdname() {
		return this.cdname;
	}

	public void setCdname(String cdname) {
		this.cdname = cdname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cyclassd")
	public Set<Cygoods> getCygoodses() {
		return this.cygoodses;
	}

	public void setCygoodses(Set<Cygoods> cygoodses) {
		this.cygoodses = cygoodses;
	}

}