package com.hp.publish.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class User_Role {

	@Id
	@GeneratedValue
	@Column(name="identifier")
	private Integer identifier;
	
	@Column(name="u_id")
	private Integer uId;
	
	@Column(name="r_id")
	private Integer rId;
	

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}
	
	
}
