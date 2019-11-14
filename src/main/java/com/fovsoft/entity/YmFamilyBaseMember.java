package com.fovsoft.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * table name:  ym_family_base_member
 * author name: ryo
 * create time: 2019-11-14 00:54:50
 */ 
public class YmFamilyBaseMember{

	@Id
	@JsonProperty(value = "memberid")
	private int id;
	private int fid;
	@Column(name = "member_name")
	@JsonProperty(value = "member_name")
	private String memberName;
	private int sex;
	@Column(name = "id_num")
	@JsonProperty(value = "id_num")
	private String idNum;
	private int relation;
	private int nation;
	@Column(name = "political_exp")
	@JsonProperty(value = "political_exp")
	private int politicalExp;
	@Column(name = "level_edu")
	@JsonProperty(value = "level_edu")
	private int levelEdu;
	@Column(name = "school_status")
	@JsonProperty(value = "school_status")
	private int schoolStatus;
	@Column(name = "stopedu_rsn")
	@JsonProperty(value = "stopedu_rsn")
	private int stopeduRsn;
	@Column(name = "healthy_status")
	@JsonProperty(value = "healthy_status")
	private int healthyStatus;
	@Column(name = "labor_skill")
	@JsonProperty(value = "labor_skill")
	private int laborSkill;
	@Column(name = "can_mandarin")
	@JsonProperty(value = "can_mandarin")
	private int canMandarin;
	@Column(name = "medical_insurance")
	@JsonProperty(value = "medical_insurance")
	private int medicalInsurance;
	@Column(name = "business_insurance")
	@JsonProperty(value = "business_insurance")
	private int businessInsurance;
	@Column(name = "basic_allowances")
	@JsonProperty(value = "basic_allowances")
	private int basicAllowances;
	@Column(name = "endowment_insurance")
	@JsonProperty(value = "endowment_insurance")
	private int endowmentInsurance;
	@Column(name = "accident_insurance")
	@JsonProperty(value = "accident_insurance")
	private int accidentInsurance;
	private String tel;

//	private int id;
//	private int fid;
//	private String memberName;
//	private int sex;
//	private String idNum;
//	private int relation;
//	private int nation;
//	private int politicalExp;
//	private int levelEdu;
//	private int schoolStatus;
//	private int stopeduRsn;
//	private int healthyStatus;
//	private int laborSkill;
//	private int canMandarin;
//	private int medicalInsurance;
//	private int businessInsurance;
//	private int basicAllowances;
//	private int endowmentInsurance;
//	private int accidentInsurance;
//	private String tel;

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
	public void setMemberName(String memberName){
		this.memberName=memberName;
	}
	public String getMemberName(){
		return memberName;
	}
	public void setSex(int sex){
		this.sex=sex;
	}
	public int getSex(){
		return sex;
	}
	public void setIdNum(String idNum){
		this.idNum=idNum;
	}
	public String getIdNum(){
		return idNum;
	}
	public void setRelation(int relation){
		this.relation=relation;
	}
	public int getRelation(){
		return relation;
	}
	public void setNation(int nation){
		this.nation=nation;
	}
	public int getNation(){
		return nation;
	}
	public void setPoliticalExp(int politicalExp){
		this.politicalExp=politicalExp;
	}
	public int getPoliticalExp(){
		return politicalExp;
	}
	public void setLevelEdu(int levelEdu){
		this.levelEdu=levelEdu;
	}
	public int getLevelEdu(){
		return levelEdu;
	}
	public void setSchoolStatus(int schoolStatus){
		this.schoolStatus=schoolStatus;
	}
	public int getSchoolStatus(){
		return schoolStatus;
	}
	public void setStopeduRsn(int stopeduRsn){
		this.stopeduRsn=stopeduRsn;
	}
	public int getStopeduRsn(){
		return stopeduRsn;
	}
	public void setHealthyStatus(int healthyStatus){
		this.healthyStatus=healthyStatus;
	}
	public int getHealthyStatus(){
		return healthyStatus;
	}
	public void setLaborSkill(int laborSkill){
		this.laborSkill=laborSkill;
	}
	public int getLaborSkill(){
		return laborSkill;
	}
	public void setCanMandarin(int canMandarin){
		this.canMandarin=canMandarin;
	}
	public int getCanMandarin(){
		return canMandarin;
	}
	public void setMedicalInsurance(int medicalInsurance){
		this.medicalInsurance=medicalInsurance;
	}
	public int getMedicalInsurance(){
		return medicalInsurance;
	}
	public void setBusinessInsurance(int businessInsurance){
		this.businessInsurance=businessInsurance;
	}
	public int getBusinessInsurance(){
		return businessInsurance;
	}
	public void setBasicAllowances(int basicAllowances){
		this.basicAllowances=basicAllowances;
	}
	public int getBasicAllowances(){
		return basicAllowances;
	}
	public void setEndowmentInsurance(int endowmentInsurance){
		this.endowmentInsurance=endowmentInsurance;
	}
	public int getEndowmentInsurance(){
		return endowmentInsurance;
	}
	public void setAccidentInsurance(int accidentInsurance){
		this.accidentInsurance=accidentInsurance;
	}
	public int getAccidentInsurance(){
		return accidentInsurance;
	}
	public void setTel(String tel){
		this.tel=tel;
	}
	public String getTel(){
		return tel;
	}
}

