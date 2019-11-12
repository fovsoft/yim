package com.fovsoft.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * table name:  ym_family_base_condition
 * author name: ryo
 * create time: 2019-11-11 22:16:28
 */ 
public class YmFamilyBaseCondition{

	@Id
	@JsonProperty(value = "conditionid")
	private int id;
	private int fid;
	@Column(name = "area_cultivated")
	@JsonProperty(value = "area_cultivated")
	private BigDecimal areaCultivated;
	@Column(name = "area_woodland")
	@JsonProperty(value = "area_woodland")
	private BigDecimal areaWoodland;
	@Column(name = "area_turninto")
	@JsonProperty(value = "area_turninto")
	private BigDecimal areaTurninto;
	@Column(name = "area_fruit")
	@JsonProperty(value = "area_fruit")
	private BigDecimal areaFruit;
	@Column(name = "area_foragegrass")
	@JsonProperty(value = "area_foragegrass")
	private BigDecimal areaForagegrass;
	@Column(name = "area_waters")
	@JsonProperty(value = "area_waters")
	private BigDecimal areaWaters;
	@Column(name = "is_cooperative")
	@JsonProperty(value = "is_cooperative")
	private int isCooperative;
	@Column(name = "get_leaded")
	@JsonProperty(value = "get_leaded")
	private int getLeaded;
	@Column(name = "get_pioneer")
	@JsonProperty(value = "get_pioneer")
	private int getPioneer;
	@Column(name = "get_electric")
	@JsonProperty(value = "get_electric")
	private int getElectric;
	@Column(name = "get_television")
	@JsonProperty(value = "get_television")
	private int getTelevision;
	@Column(name = "get_potablewater")
	@JsonProperty(value = "get_potablewater")
	private int getPotablewater;
	@Column(name = "get_toilet")
	@JsonProperty(value = "get_toilet")
	private int getToilet;
	@Column(name = "distance_mainroad")
	@JsonProperty(value = "distance_mainroad")
	private BigDecimal distanceMainroad;
	@Column(name = "type_road")
	@JsonProperty(value = "type_road")
	private int typeRoad;
	@Column(name = "area_housing")
	@JsonProperty(value = "area_housing")
	private BigDecimal areaHousing;
	@Column(name = "is_dilapidated")
	@JsonProperty(value = "is_dilapidated")
	private int isDilapidated;
	@Column(name = "level_dilapidated")
	@JsonProperty(value = "level_dilapidated")
	private int levelDilapidated;
	@Column(name = "year_reform")
	@JsonProperty(value = "year_reform")
	private int yearReform;
	@Column(name = "type_fuel")
	@JsonProperty(value = "type_fuel")
	private int typeFuel;
	@Column(name = "type_fuel_other")
	@JsonProperty(value = "type_fuel_other")
	private String typeFuelOther;




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
	public void setAreaCultivated(BigDecimal areaCultivated){
		this.areaCultivated=areaCultivated;
	}
	public BigDecimal getAreaCultivated(){
		return areaCultivated;
	}
	public void setAreaWoodland(BigDecimal areaWoodland){
		this.areaWoodland=areaWoodland;
	}
	public BigDecimal getAreaWoodland(){
		return areaWoodland;
	}
	public void setAreaTurninto(BigDecimal areaTurninto){
		this.areaTurninto=areaTurninto;
	}
	public BigDecimal getAreaTurninto(){
		return areaTurninto;
	}
	public void setAreaFruit(BigDecimal areaFruit){
		this.areaFruit=areaFruit;
	}
	public BigDecimal getAreaFruit(){
		return areaFruit;
	}
	public void setAreaForagegrass(BigDecimal areaForagegrass){
		this.areaForagegrass=areaForagegrass;
	}
	public BigDecimal getAreaForagegrass(){
		return areaForagegrass;
	}
	public void setAreaWaters(BigDecimal areaWaters){
		this.areaWaters=areaWaters;
	}
	public BigDecimal getAreaWaters(){
		return areaWaters;
	}
	public void setIsCooperative(int isCooperative){
		this.isCooperative=isCooperative;
	}
	public int getIsCooperative(){
		return isCooperative;
	}
	public void setGetLeaded(int getLeaded){
		this.getLeaded=getLeaded;
	}
	public int getGetLeaded(){
		return getLeaded;
	}
	public void setGetPioneer(int getPioneer){
		this.getPioneer=getPioneer;
	}
	public int getGetPioneer(){
		return getPioneer;
	}
	public void setGetElectric(int getElectric){
		this.getElectric=getElectric;
	}
	public int getGetElectric(){
		return getElectric;
	}
	public void setGetTelevision(int getTelevision){
		this.getTelevision=getTelevision;
	}
	public int getGetTelevision(){
		return getTelevision;
	}
	public void setGetPotablewater(int getPotablewater){
		this.getPotablewater=getPotablewater;
	}
	public int getGetPotablewater(){
		return getPotablewater;
	}
	public void setGetToilet(int getToilet){
		this.getToilet=getToilet;
	}
	public int getGetToilet(){
		return getToilet;
	}
	public void setDistanceMainroad(BigDecimal distanceMainroad){
		this.distanceMainroad=distanceMainroad;
	}
	public BigDecimal getDistanceMainroad(){
		return distanceMainroad;
	}
	public void setTypeRoad(int typeRoad){
		this.typeRoad=typeRoad;
	}
	public int getTypeRoad(){
		return typeRoad;
	}
	public void setAreaHousing(BigDecimal areaHousing){
		this.areaHousing=areaHousing;
	}
	public BigDecimal getAreaHousing(){
		return areaHousing;
	}
	public void setIsDilapidated(int isDilapidated){
		this.isDilapidated=isDilapidated;
	}
	public int getIsDilapidated(){
		return isDilapidated;
	}
	public void setLevelDilapidated(int levelDilapidated){
		this.levelDilapidated=levelDilapidated;
	}
	public int getLevelDilapidated(){
		return levelDilapidated;
	}
	public void setYearReform(int yearReform){
		this.yearReform=yearReform;
	}
	public int getYearReform(){
		return yearReform;
	}
	public void setTypeFuel(int typeFuel){
		this.typeFuel=typeFuel;
	}
	public int getTypeFuel(){
		return typeFuel;
	}
	public void setTypeFuelOther(String typeFuelOther){
		this.typeFuelOther=typeFuelOther;
	}
	public String getTypeFuelOther(){
		return typeFuelOther;
	}
}

