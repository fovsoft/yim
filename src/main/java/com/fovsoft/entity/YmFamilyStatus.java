package com.fovsoft.entity;

import java.io.Serializable;

/**
 * @Author by tpc
 * @Date 2019/10/17 22:28
 * description: 致贫原因及家庭基本条件表
 **/

public class YmFamilyStatus implements Serializable {

    private int        jtzkbh       ;          // '家庭状况编号',
    private int        jtbh         ;          // '家庭编号，对应家庭表',
    private String     zpyy1        ;     // '致贫原因1（必填）',
    private String     zpyy2        ;     // '致贫原因2（选填）',
    private String     zpyy3        ;     // '致贫原因3（选填）',
    private int        ncjtrks      ;          // '年初家庭人口数',
    private int        ndjtrks      ;          // '年底家庭人口数',
    private float      gdmj         ;          // '耕地面积（亩）',
    private float      yxggmj       ;          // '有效灌溉面积（亩）',
    private float      ldmj         ;          // '林地面积（亩）',
    private float      tghlmj       ;          // '退耕还林面积（亩）',
    private float      lgmj         ;          // '林果面积（亩）',
    private float      smmj         ;          // '水面面积（亩）',
    private float      mcdmj        ;          // '牧草地面积（亩）',
    private String     sfyltqydd    ;         // '是否有龙头企业带动',
    private String     sfycyzfdtrdd ;         // '是否有创业致富带头人带动',
    private String     sftscyd      ;         // '是否通生产用电',
    private String     sftshyd      ;         // '是否通生活用电',
    private String     sftgbds      ;         // '是否通广播电视',
    private String     yssfkn       ;         // '饮水是否困难',
    private String     yssfaq       ;         // '饮水是否安全',
    private float      zfmj         ;          // '住房面积（平方米）',
    private String     ywwscs       ;         // '有无卫生厕所',
    private String     sfwfh        ;         // '是否危房户',
    private String     wfdj         ;     // '危房等级',
    private String     wgnd         ;     // '危改年度',
    private String     zfjg         ;     // '住房结构',
    private String     sfjrnmzyhzs  ;        // '是否加入农民专业合作社',
    private float      yczgljl      ;          // '与村主干路距离（公里）',
    private String     rhllx        ;     // '入户路类型',
    private String     zyrllx       ;     // '主要燃料类型',
    private String     bgqksm       ;    // '变更情况说明'


    public int getJtzkbh() {
        return jtzkbh;
    }

    public void setJtzkbh(int jtzkbh) {
        this.jtzkbh = jtzkbh;
    }

    public int getJtbh() {
        return jtbh;
    }

    public void setJtbh(int jtbh) {
        this.jtbh = jtbh;
    }

    public String getZpyy1() {
        return zpyy1;
    }

    public void setZpyy1(String zpyy1) {
        this.zpyy1 = zpyy1;
    }

    public String getZpyy2() {
        return zpyy2;
    }

    public void setZpyy2(String zpyy2) {
        this.zpyy2 = zpyy2;
    }

    public String getZpyy3() {
        return zpyy3;
    }

    public void setZpyy3(String zpyy3) {
        this.zpyy3 = zpyy3;
    }

    public int getNcjtrks() {
        return ncjtrks;
    }

    public void setNcjtrks(int ncjtrks) {
        this.ncjtrks = ncjtrks;
    }

    public int getNdjtrks() {
        return ndjtrks;
    }

    public void setNdjtrks(int ndjtrks) {
        this.ndjtrks = ndjtrks;
    }

    public float getGdmj() {
        return gdmj;
    }

    public void setGdmj(float gdmj) {
        this.gdmj = gdmj;
    }

    public float getYxggmj() {
        return yxggmj;
    }

    public void setYxggmj(float yxggmj) {
        this.yxggmj = yxggmj;
    }

    public float getLdmj() {
        return ldmj;
    }

    public void setLdmj(float ldmj) {
        this.ldmj = ldmj;
    }

    public float getTghlmj() {
        return tghlmj;
    }

    public void setTghlmj(float tghlmj) {
        this.tghlmj = tghlmj;
    }

    public float getLgmj() {
        return lgmj;
    }

    public void setLgmj(float lgmj) {
        this.lgmj = lgmj;
    }

    public float getSmmj() {
        return smmj;
    }

    public void setSmmj(float smmj) {
        this.smmj = smmj;
    }

    public float getMcdmj() {
        return mcdmj;
    }

    public void setMcdmj(float mcdmj) {
        this.mcdmj = mcdmj;
    }

    public String getSfyltqydd() {
        return sfyltqydd;
    }

    public void setSfyltqydd(String sfyltqydd) {
        this.sfyltqydd = sfyltqydd;
    }

    public String getSfycyzfdtrdd() {
        return sfycyzfdtrdd;
    }

    public void setSfycyzfdtrdd(String sfycyzfdtrdd) {
        this.sfycyzfdtrdd = sfycyzfdtrdd;
    }

    public String getSftscyd() {
        return sftscyd;
    }

    public void setSftscyd(String sftscyd) {
        this.sftscyd = sftscyd;
    }

    public String getSftshyd() {
        return sftshyd;
    }

    public void setSftshyd(String sftshyd) {
        this.sftshyd = sftshyd;
    }

    public String getSftgbds() {
        return sftgbds;
    }

    public void setSftgbds(String sftgbds) {
        this.sftgbds = sftgbds;
    }

    public String getYssfkn() {
        return yssfkn;
    }

    public void setYssfkn(String yssfkn) {
        this.yssfkn = yssfkn;
    }

    public String getYssfaq() {
        return yssfaq;
    }

    public void setYssfaq(String yssfaq) {
        this.yssfaq = yssfaq;
    }

    public float getZfmj() {
        return zfmj;
    }

    public void setZfmj(float zfmj) {
        this.zfmj = zfmj;
    }

    public String getYwwscs() {
        return ywwscs;
    }

    public void setYwwscs(String ywwscs) {
        this.ywwscs = ywwscs;
    }

    public String getSfwfh() {
        return sfwfh;
    }

    public void setSfwfh(String sfwfh) {
        this.sfwfh = sfwfh;
    }

    public String getWfdj() {
        return wfdj;
    }

    public void setWfdj(String wfdj) {
        this.wfdj = wfdj;
    }

    public String getWgnd() {
        return wgnd;
    }

    public void setWgnd(String wgnd) {
        this.wgnd = wgnd;
    }

    public String getZfjg() {
        return zfjg;
    }

    public void setZfjg(String zfjg) {
        this.zfjg = zfjg;
    }

    public String getSfjrnmzyhzs() {
        return sfjrnmzyhzs;
    }

    public void setSfjrnmzyhzs(String sfjrnmzyhzs) {
        this.sfjrnmzyhzs = sfjrnmzyhzs;
    }

    public float getYczgljl() {
        return yczgljl;
    }

    public void setYczgljl(float yczgljl) {
        this.yczgljl = yczgljl;
    }

    public String getRhllx() {
        return rhllx;
    }

    public void setRhllx(String rhllx) {
        this.rhllx = rhllx;
    }

    public String getZyrllx() {
        return zyrllx;
    }

    public void setZyrllx(String zyrllx) {
        this.zyrllx = zyrllx;
    }

    public String getBgqksm() {
        return bgqksm;
    }

    public void setBgqksm(String bgqksm) {
        this.bgqksm = bgqksm;
    }
}
