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
 * Cygoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cygoods", catalog = "cyporj")
@Proxy(lazy = false)
public class Cygoods implements java.io.Serializable {

	// Fields

	private Integer cygid;
	private Cyclassd cyclassd;
	private Cyusers cyusers;
	private String cygtitle;
	private String cygdep;
	private String cygphoto;
	private Integer cygview;
	private Integer cyprice;
	private Integer cygstats;
	private String cygdate;
	private Set<Cycarts> cycartses = new HashSet<Cycarts>(0);

	// Constructors

	/** default constructor */
	public Cygoods() {
	}

	/** full constructor */
	public Cygoods(Cyclassd cyclassd, Cyusers cyusers, String cygtitle,
			String cygdep, String cygphoto, Integer cygview, Integer cyprice,
			Integer cygstats, String cygdate, Set<Cycarts> cycartses) {
		this.cyclassd = cyclassd;
		this.cyusers = cyusers;
		this.cygtitle = cygtitle;
		this.cygdep = cygdep;
		this.cygphoto = cygphoto;
		this.cygview = cygview;
		this.cyprice = cyprice;
		this.cygstats = cygstats;
		this.cygdate = cygdate;
		this.cycartses = cycartses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cygid", unique = true, nullable = false)
	public Integer getCygid() {
		return this.cygid;
	}

	public void setCygid(Integer cygid) {
		this.cygid = cygid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cycdid")
	public Cyclassd getCyclassd() {
		return this.cyclassd;
	}

	public void setCyclassd(Cyclassd cyclassd) {
		this.cyclassd = cyclassd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cyuid")
	public Cyusers getCyusers() {
		return this.cyusers;
	}

	public void setCyusers(Cyusers cyusers) {
		this.cyusers = cyusers;
	}

	@Column(name = "cygtitle", length = 50)
	public String getCygtitle() {
		return this.cygtitle;
	}

	public void setCygtitle(String cygtitle) {
		this.cygtitle = cygtitle;
	}

	@Column(name = "cygdep", length = 150)
	public String getCygdep() {
		return this.cygdep;
	}

	public void setCygdep(String cygdep) {
		this.cygdep = cygdep;
	}

	@Column(name = "cygphoto", length = 150)
	public String getCygphoto() {
		return this.cygphoto;
	}

	public void setCygphoto(String cygphoto) {
		this.cygphoto = cygphoto;
	}

	@Column(name = "cygview")
	public Integer getCygview() {
		return this.cygview;
	}

	public void setCygview(Integer cygview) {
		this.cygview = cygview;
	}

	@Column(name = "cyprice")
	public Integer getCyprice() {
		return this.cyprice;
	}

	public void setCyprice(Integer cyprice) {
		this.cyprice = cyprice;
	}

	@Column(name = "cygstats")
	public Integer getCygstats() {
		return this.cygstats;
	}

	public void setCygstats(Integer cygstats) {
		this.cygstats = cygstats;
	}

	@Column(name = "cygdate", length = 50)
	public String getCygdate() {
		return this.cygdate;
	}

	public void setCygdate(String cygdate) {
		this.cygdate = cygdate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cygoods")
	public Set<Cycarts> getCycartses() {
		return this.cycartses;
	}

	public void setCycartses(Set<Cycarts> cycartses) {
		this.cycartses = cycartses;
	}

}