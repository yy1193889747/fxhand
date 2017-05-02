package com.cyporj.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

/**
 * Cyclassg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cyclassg", catalog = "cyporj")
@Proxy(lazy = false)
public class Cyclassg implements java.io.Serializable {

	// Fields

	private Integer cgid;
	private String cgname;
	private Set<Cyclassd> cyclassds = new HashSet<Cyclassd>(0);

	// Constructors

	/** default constructor */
	public Cyclassg() {
	}

	/** full constructor */
	public Cyclassg(String cgname, Set<Cyclassd> cyclassds) {
		this.cgname = cgname;
		this.cyclassds = cyclassds;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cgid", unique = true, nullable = false)
	public Integer getCgid() {
		return this.cgid;
	}

	public void setCgid(Integer cgid) {
		this.cgid = cgid;
	}

	@Column(name = "cgname", length = 50)
	public String getCgname() {
		return this.cgname;
	}

	public void setCgname(String cgname) {
		this.cgname = cgname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cyclassg")
	@OrderBy(clause = "cdid asc")
	public Set<Cyclassd> getCyclassds() {
		return this.cyclassds;
	}

	public void setCyclassds(Set<Cyclassd> cyclassds) {
		this.cyclassds = cyclassds;
	}

}