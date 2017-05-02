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

import org.hibernate.annotations.Proxy;

/**
 * Cyusers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cyusers", catalog = "cyporj")
@Proxy(lazy = false)
public class Cyusers implements java.io.Serializable {

	// Fields

	private Integer cyuid;
	private String cyuname;
	private String cyuphone;
	private String cyupwd;
	private String cyrdate;
	private String cyemail;
	private String cyuqq;
	private String cyuaddress;
	private String cyuphoto;
	private String cyustat;
	private Set<Cycarts> cycartses = new HashSet<Cycarts>(0);
	private Set<Cywant> cywants = new HashSet<Cywant>(0);
	private Set<Cymsg> cymsgs = new HashSet<Cymsg>(0);
	private Set<Cygoods> cygoodses = new HashSet<Cygoods>(0);

	// Constructors

	/** default constructor */
	public Cyusers() {
	}

	/** full constructor */
	public Cyusers(String cyuname, String cyuphone, String cyupwd,
			String cyrdate, String cyemail, String cyuqq, String cyuaddress,
			String cyuphoto, String cyustat, Set<Cycarts> cycartses,
			Set<Cywant> cywants, Set<Cymsg> cymsgs, Set<Cygoods> cygoodses) {
		this.cyuname = cyuname;
		this.cyuphone = cyuphone;
		this.cyupwd = cyupwd;
		this.cyrdate = cyrdate;
		this.cyemail = cyemail;
		this.cyuqq = cyuqq;
		this.cyuaddress = cyuaddress;
		this.cyuphoto = cyuphoto;
		this.cyustat = cyustat;
		this.cycartses = cycartses;
		this.cywants = cywants;
		this.cymsgs = cymsgs;
		this.cygoodses = cygoodses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cyuid", unique = true, nullable = false)
	public Integer getCyuid() {
		return this.cyuid;
	}

	public void setCyuid(Integer cyuid) {
		this.cyuid = cyuid;
	}

	@Column(name = "cyuname", length = 50)
	public String getCyuname() {
		return this.cyuname;
	}

	public void setCyuname(String cyuname) {
		this.cyuname = cyuname;
	}

	@Column(name = "cyuphone", length = 11)
	public String getCyuphone() {
		return this.cyuphone;
	}

	public void setCyuphone(String cyuphone) {
		this.cyuphone = cyuphone;
	}

	@Column(name = "cyupwd", length = 50)
	public String getCyupwd() {
		return this.cyupwd;
	}

	public void setCyupwd(String cyupwd) {
		this.cyupwd = cyupwd;
	}

	@Column(name = "cyrdate", length = 50)
	public String getCyrdate() {
		return this.cyrdate;
	}

	public void setCyrdate(String cyrdate) {
		this.cyrdate = cyrdate;
	}

	@Column(name = "cyemail", length = 50)
	public String getCyemail() {
		return this.cyemail;
	}

	public void setCyemail(String cyemail) {
		this.cyemail = cyemail;
	}

	@Column(name = "cyuqq", length = 50)
	public String getCyuqq() {
		return this.cyuqq;
	}

	public void setCyuqq(String cyuqq) {
		this.cyuqq = cyuqq;
	}

	@Column(name = "cyuaddress", length = 50)
	public String getCyuaddress() {
		return this.cyuaddress;
	}

	public void setCyuaddress(String cyuaddress) {
		this.cyuaddress = cyuaddress;
	}

	@Column(name = "cyuphoto", length = 100)
	public String getCyuphoto() {
		return this.cyuphoto;
	}

	public void setCyuphoto(String cyuphoto) {
		this.cyuphoto = cyuphoto;
	}

	@Column(name = "cyustat", length = 50)
	public String getCyustat() {
		return this.cyustat;
	}

	public void setCyustat(String cyustat) {
		this.cyustat = cyustat;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cyusers")
	public Set<Cycarts> getCycartses() {
		return this.cycartses;
	}

	public void setCycartses(Set<Cycarts> cycartses) {
		this.cycartses = cycartses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cyusers")
	public Set<Cywant> getCywants() {
		return this.cywants;
	}

	public void setCywants(Set<Cywant> cywants) {
		this.cywants = cywants;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cyusers")
	public Set<Cymsg> getCymsgs() {
		return this.cymsgs;
	}

	public void setCymsgs(Set<Cymsg> cymsgs) {
		this.cymsgs = cymsgs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cyusers")
	public Set<Cygoods> getCygoodses() {
		return this.cygoodses;
	}

	public void setCygoodses(Set<Cygoods> cygoodses) {
		this.cygoodses = cygoodses;
	}

}