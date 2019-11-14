package com.fovsoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class YmFamilyBaseAndHouseHolder {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="poverty_rtn_tm")
    private String fpnd;
    @Column(name="is_relocated")
    private Integer sfydbqh;
    @Column(name="family_attr")
    private Integer pkhsx;
    @Column(name="poverty_relief_tm")
    private Integer jhtpnd;

    @Column(name="member_name")
    private String hzxm;
    @Column(name="id_num")
    private String zjhm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getHzxm() {
        return hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
    }

    public Integer getJhtpnd() {
        return jhtpnd;
    }

    public void setJhtpnd(Integer jhtpnd) {
        this.jhtpnd = jhtpnd;
    }

    public String getFpnd() {
        return fpnd;
    }

    public void setFpnd(String fpnd) {
        this.fpnd = fpnd;
    }

    public Integer getPkhsx() {
        return pkhsx;
    }

    public void setPkhsx(Integer pkhsx) {
        this.pkhsx = pkhsx;
    }

    public Integer getSfydbqh() {
        return sfydbqh;
    }

    public void setSfydbqh(Integer sfydbqh) {
        this.sfydbqh = sfydbqh;
    }
}
