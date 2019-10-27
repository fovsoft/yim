package com.fovsoft.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author by tpc
 * @Date 2019/10/17 22:29
 * description: 移民贫困人员信息表
 **/

public class YmPerson implements Serializable {
    private int       rybh    ;//人员编号
    private int       jtbh    ;//'家庭编号，对应家庭表',
    private String    xm      ;//'姓名',
    private String    sex     ;//'性别',
    private String    sfzmhm  ;//'身份证明号码',
    private String    qfjg    ;//'身份证签发机关',
    private Date      sfzyxqs ;//身份证有效期始',
    private Date      sfzyxqz ;//身份证有效期止',
    private String    yhzgx   ;//'与户主关系',
    private String    mz      ;//'民族',
    private Date      csrq    ;//'出生日期',
    private String    zzmm    ;//'政治面貌',
    private String    whcd    ;//'文化程度',
    private String    zxsqk   ;//'在校生情况'
    private String    sxhcxyy ;//'失学或辍学原因'
    private String    jkqk    ;//'健康情况',
    private String    ldjn    ;//'劳动技能情况'
    private String    sfhjpth ;//'是否会讲普通话'
    private String    sfxyjr  ;//'是否现役军人',
    private String    sfcjylbx1;//'是否参加城乡居民基本医疗保险'
    private String    sfcjsybx;//'是否参加商业补充医疗保险'
    private String    sfxsdb  ;//'是否享受低保',
    private String    sfcjylbx2;//'是否参加城乡居民基本养老保险',
    private String    sfxsywbxbt;//'是否享受人身意外保险补贴
    private String    lxdh    ;//'联系电话'


    public int getRybh() {
        return rybh;
    }

    public void setRybh(int rybh) {
        this.rybh = rybh;
    }

    public int getJtbh() {
        return jtbh;
    }

    public void setJtbh(int jtbh) {
        this.jtbh = jtbh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSfzmhm() {
        return sfzmhm;
    }

    public void setSfzmhm(String sfzmhm) {
        this.sfzmhm = sfzmhm;
    }

    public String getQfjg() {
        return qfjg;
    }

    public void setQfjg(String qfjg) {
        this.qfjg = qfjg;
    }

    public Date getSfzyxqs() {
        return sfzyxqs;
    }

    public void setSfzyxqs(Date sfzyxqs) {
        this.sfzyxqs = sfzyxqs;
    }

    public Date getSfzyxqz() {
        return sfzyxqz;
    }

    public void setSfzyxqz(Date sfzyxqz) {
        this.sfzyxqz = sfzyxqz;
    }

    public String getYhzgx() {
        return yhzgx;
    }

    public void setYhzgx(String yhzgx) {
        this.yhzgx = yhzgx;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    public String getWhcd() {
        return whcd;
    }

    public void setWhcd(String whcd) {
        this.whcd = whcd;
    }

    public String getZxsqk() {
        return zxsqk;
    }

    public void setZxsqk(String zxsqk) {
        this.zxsqk = zxsqk;
    }

    public String getSxhcxyy() {
        return sxhcxyy;
    }

    public void setSxhcxyy(String sxhcxyy) {
        this.sxhcxyy = sxhcxyy;
    }

    public String getJkqk() {
        return jkqk;
    }

    public void setJkqk(String jkqk) {
        this.jkqk = jkqk;
    }

    public String getLdjn() {
        return ldjn;
    }

    public void setLdjn(String ldjn) {
        this.ldjn = ldjn;
    }

    public String getSfhjpth() {
        return sfhjpth;
    }

    public void setSfhjpth(String sfhjpth) {
        this.sfhjpth = sfhjpth;
    }

    public String getSfxyjr() {
        return sfxyjr;
    }

    public void setSfxyjr(String sfxyjr) {
        this.sfxyjr = sfxyjr;
    }

    public String getSfcjylbx1() {
        return sfcjylbx1;
    }

    public void setSfcjylbx1(String sfcjylbx1) {
        this.sfcjylbx1 = sfcjylbx1;
    }

    public String getSfcjsybx() {
        return sfcjsybx;
    }

    public void setSfcjsybx(String sfcjsybx) {
        this.sfcjsybx = sfcjsybx;
    }

    public String getSfxsdb() {
        return sfxsdb;
    }

    public void setSfxsdb(String sfxsdb) {
        this.sfxsdb = sfxsdb;
    }

    public String getSfcjylbx2() {
        return sfcjylbx2;
    }

    public void setSfcjylbx2(String sfcjylbx2) {
        this.sfcjylbx2 = sfcjylbx2;
    }

    public String getSfxsywbxbt() {
        return sfxsywbxbt;
    }

    public void setSfxsywbxbt(String sfxsywbxbt) {
        this.sfxsywbxbt = sfxsywbxbt;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }
}
