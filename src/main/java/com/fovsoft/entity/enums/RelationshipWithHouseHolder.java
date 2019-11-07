package com.fovsoft.entity.enums;

/**
 * 与户主关系
 *
 */
public enum RelationshipWithHouseHolder {
    HouseHolder("户主"),
    Father("之父"),
    Mother("之母"),
    Son("之子"),
    Daughter("之女");


    private String value;

    RelationshipWithHouseHolder(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
