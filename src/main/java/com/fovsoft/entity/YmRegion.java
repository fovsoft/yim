package com.fovsoft.entity;

/**
 * table name:  ym_region
 * author name: ryo
 * create time: 2019-11-03 17:32:58
 */ 
public class YmRegion{

	private int id;
	private int pid;
	private String name;
	private String code;
	private int enable;

	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setPid(int pid){
		this.pid=pid;
	}
	public int getPid(){
		return pid;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setCode(String code){
		this.code=code;
	}
	public String getCode(){
		return code;
	}
	public void setEnable(int enable){
		this.enable=enable;
	}
	public int getEnable(){
		return enable;
	}
}

