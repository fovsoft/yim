package com.fovsoft.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * table name:  ym_family_base
 * author name: ryo
 * create time: 2019-11-02 21:47:54FamilyService
 */
@Entity
@Table(name = "ym_family_base")
public class YmFamilyBase implements Serializable {

    @Id
    @JsonProperty(value = "baseid")
    private int id;
    private int city;
    private int county;
    private int town;
    private String avillage;
    private String nvillage;
    private String tel;
    @Column(name = "dpst_bk")
    @JsonProperty(value = "dpst_bk")
    private int dpstBk;
    @Column(name = "bk_num")
    @JsonProperty(value = "bk_num")
    private String bkNum;
    @Column(name = "family_attr")
    @JsonProperty(value = "family_attr")
    private int familyAttr;
    @Column(name = "poverty_relief_tm")
    @JsonProperty(value = "poverty_relief_tm")
    private int povertyReliefTm;
    @Column(name = "poverty_rtn_tm")
    @JsonProperty(value = "poverty_rtn_tm")
    private int povertyRtnTm;
    @Column(name = "poverty_rtn_rsn")
    @JsonProperty(value = "poverty_rtn_rsn")
    private String povertyRtnRsn;
    @Column(name = "is_martyrsfamily")
    @JsonProperty(value = "is_martyrsfamily")
    private int isMartyrsfamily;
    @Column(name = "is_relocated")
    @JsonProperty(value = "is_relocated")
    private int isRelocated;
    @Column(name = "relocated_way")
    @JsonProperty(value = "relocated_way")
    private String relocatedWay;
    @Column(name = "relocated_addr")
    @JsonProperty(value = "relocated_addr")
    private String relocatedAddr;
    @Column(name = "add_time")
    @JsonProperty(value = "add_time")
    private Timestamp addTime;
    @Column(name = "update_time")
    @JsonProperty(value = "update_time")
    private Date updateTime;
    private int uid;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getCity() {
        return city;
    }

    public void setCounty(int county) {
        this.county = county;
    }

    public int getCounty() {
        return county;
    }

    public void setTown(int town) {
        this.town = town;
    }

    public int getTown() {
        return town;
    }

    public void setAvillage(String avillage) {
        this.avillage = avillage;
    }

    public String getAvillage() {
        return avillage;
    }

    public void setNvillage(String nvillage) {
        this.nvillage = nvillage;
    }

    public String getNvillage() {
        return nvillage;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setDpstBk(int dpstBk) {
        this.dpstBk = dpstBk;
    }

    public int getDpstBk() {
        return dpstBk;
    }

    public void setBkNum(String bkNum) {
        this.bkNum = bkNum;
    }

    public String getBkNum() {
        return bkNum;
    }

    public void setFamilyAttr(int familyAttr) {
        this.familyAttr = familyAttr;
    }

    public int getFamilyAttr() {
        return familyAttr;
    }

    public void setPovertyReliefTm(int povertyReliefTm) {
        this.povertyReliefTm = povertyReliefTm;
    }

    public int getPovertyReliefTm() {
        return povertyReliefTm;
    }

    public void setPovertyRtnTm(int povertyRtnTm) {
        this.povertyRtnTm = povertyRtnTm;
    }

    public int getPovertyRtnTm() {
        return povertyRtnTm;
    }

    public void setPovertyRtnRsn(String povertyRtnRsn) {
        this.povertyRtnRsn = povertyRtnRsn;
    }

    public String getPovertyRtnRsn() {
        return povertyRtnRsn;
    }

    public void setIsMartyrsfamily(int isMartyrsfamily) {
        this.isMartyrsfamily = isMartyrsfamily;
    }

    public int getIsMartyrsfamily() {
        return isMartyrsfamily;
    }

    public void setIsRelocated(int isRelocated) {
        this.isRelocated = isRelocated;
    }

    public int getIsRelocated() {
        return isRelocated;
    }

    public void setRelocatedWay(String relocatedWay) {
        this.relocatedWay = relocatedWay;
    }

    public String getRelocatedWay() {
        return relocatedWay;
    }

    public void setRelocatedAddr(String relocatedAddr) {
        this.relocatedAddr = relocatedAddr;
    }

    public String getRelocatedAddr() {
        return relocatedAddr;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }
}

