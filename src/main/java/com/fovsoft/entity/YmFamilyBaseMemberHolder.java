package com.fovsoft.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class YmFamilyBaseMemberHolder {

    @Id
    @Column(name = "memberid")
    private int id;
    private int fid;
    @Column(name = "member_name")
    private String memberName;
    private int sex;
    @Column(name = "id_num")
    private String idNum;
    private int relation;
    private int nation;
    @Column(name = "political_exp")
    private int politicalExp;
    @Column(name = "level_edu")
    @JsonProperty(value = "level_edu")
    private int levelEdu;
    @Column(name = "school_status")
    private int schoolStatus;
    @Column(name = "stopedu_rsn")
    private int stopeduRsn;
    @Column(name = "healthy_status")
    private int healthyStatus;
    @Column(name = "labor_skill")
    @JsonProperty(value = "labor_skill")
    private int laborSkill;
    @Column(name = "can_mandarin")
    private int canMandarin;
    @Column(name = "medical_insurance")
    private int medicalInsurance;
    @Column(name = "business_insurance")
    private int businessInsurance;
    @Column(name = "basic_allowances")
    @JsonProperty(value = "basic_allowances")
    private int basicAllowances;
    @Column(name = "endowment_insurance")
    private int endowmentInsurance;
    @Column(name = "accident_insurance")
    private int accidentInsurance;
    private String tel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }

    public int getPoliticalExp() {
        return politicalExp;
    }

    public void setPoliticalExp(int politicalExp) {
        this.politicalExp = politicalExp;
    }

    public int getLevelEdu() {
        return levelEdu;
    }

    public void setLevelEdu(int levelEdu) {
        this.levelEdu = levelEdu;
    }

    public int getSchoolStatus() {
        return schoolStatus;
    }

    public void setSchoolStatus(int schoolStatus) {
        this.schoolStatus = schoolStatus;
    }

    public int getStopeduRsn() {
        return stopeduRsn;
    }

    public void setStopeduRsn(int stopeduRsn) {
        this.stopeduRsn = stopeduRsn;
    }

    public int getHealthyStatus() {
        return healthyStatus;
    }

    public void setHealthyStatus(int healthyStatus) {
        this.healthyStatus = healthyStatus;
    }

    public int getLaborSkill() {
        return laborSkill;
    }

    public void setLaborSkill(int laborSkill) {
        this.laborSkill = laborSkill;
    }

    public int getCanMandarin() {
        return canMandarin;
    }

    public void setCanMandarin(int canMandarin) {
        this.canMandarin = canMandarin;
    }

    public int getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(int medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public int getBusinessInsurance() {
        return businessInsurance;
    }

    public void setBusinessInsurance(int businessInsurance) {
        this.businessInsurance = businessInsurance;
    }

    public int getBasicAllowances() {
        return basicAllowances;
    }

    public void setBasicAllowances(int basicAllowances) {
        this.basicAllowances = basicAllowances;
    }

    public int getEndowmentInsurance() {
        return endowmentInsurance;
    }

    public void setEndowmentInsurance(int endowmentInsurance) {
        this.endowmentInsurance = endowmentInsurance;
    }

    public int getAccidentInsurance() {
        return accidentInsurance;
    }

    public void setAccidentInsurance(int accidentInsurance) {
        this.accidentInsurance = accidentInsurance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
