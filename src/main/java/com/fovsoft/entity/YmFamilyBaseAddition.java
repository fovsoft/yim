package com.fovsoft.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * table name:  ym_family_base_addition
 * author name: ryo
 * create time: 2019-11-11 17:22:53
 */
public class YmFamilyBaseAddition{

	@Id
	@JsonProperty(value = "additionid")
	private int id;
	private int fid;
	@Column(name = "poverty_causes1")
	@JsonProperty(value = "poverty_causes1")
	private int povertyCauses1;
	@Column(name = "poverty_causes2")
	@JsonProperty(value = "poverty_causes2")
	private int povertyCauses2;
	@Column(name = "poverty_causes3")
	@JsonProperty(value = "poverty_causes3")
	private int povertyCauses3;
	@Column(name = "household_num_Jan")
	@JsonProperty(value = "household_num_Jan")
	private int householdNumJan;
	@Column(name = "household_num_Dec")
	@JsonProperty(value = "household_num_Dec")
	private int householdNumDec;

	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setFid(int fid){
		this.fid=fid;
	}
	public int getFid(){
		return fid;
	}
	public void setPovertyCauses1(int povertyCauses1){
		this.povertyCauses1=povertyCauses1;
	}
	public int getPovertyCauses1(){
		return povertyCauses1;
	}
	public void setPovertyCauses2(int povertyCauses2){
		this.povertyCauses2=povertyCauses2;
	}
	public int getPovertyCauses2(){
		return povertyCauses2;
	}
	public void setPovertyCauses3(int povertyCauses3){
		this.povertyCauses3=povertyCauses3;
	}
	public int getPovertyCauses3(){
		return povertyCauses3;
	}
	public void setHouseholdNumJan(int householdNumJan){
		this.householdNumJan=householdNumJan;
	}
	public int getHouseholdNumJan(){
		return householdNumJan;
	}
	public void setHouseholdNumDec(int householdNumDec){
		this.householdNumDec=householdNumDec;
	}
	public int getHouseholdNumDec(){
		return householdNumDec;
	}
}

