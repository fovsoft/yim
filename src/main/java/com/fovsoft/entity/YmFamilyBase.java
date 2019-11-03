package com.fovsoft.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * table name:  ym_family_base
 * author name: ryo
 * create time: 2019-11-02 21:47:54
 */
public class YmFamilyBase implements Serializable {

    private int id;
    private int city;
    private int county;
    private int town;
    private int avillage;
    private String nvillage;
    private String tel;
    private int dpstBk;
    private String bkNum;
    private int familyAttr;
    private int povertyReliefTm;
    private int povertyRtnTm;
    private String povertyRtnRsn;
    private int isMartyrsfamily;
    private int isRelocated;
    private String relocatedWay;
    private String relocatedAddr;
    private Date addTime;
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

    public void setAvillage(int avillage) {
        this.avillage = avillage;
    }

    public int getAvillage() {
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

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getAddTime() {
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

