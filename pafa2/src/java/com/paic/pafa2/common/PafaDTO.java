package com.paic.pafa2.common;

import java.io.Serializable;

public class PafaDTO implements Serializable{
	
	private int varAmount=3;
	
	private String[] varName;
	private String[] varValue;
	private int Key=0;
	
	public String getKeyValue(){
		return this.varValue[Key];
	}
		
	public PafaDTO(int varAmount) {
		this.varAmount=varAmount;
		this.varName=new String[varAmount];
		this.varValue=new String[varAmount];
		for(int i=0;i<this.varAmount;i++){
			varName[i]="";
			varValue[i]="";
		}
	}
	
	public PafaDTO() {
		this.varName=new String[varAmount];
		this.varValue=new String[varAmount];
		for(int i=0;i<this.varAmount;i++){
			varName[i]="";
			varValue[i]="";
		}
	}
	

	public String toString(){
		String ss="";
		for(int i=0;i<varAmount;i++){
			ss+=varName[i]+":"+varValue[i];
		}
		return ss;
	}

	public String getVarValue(int line) {
		return varValue[line];
	}
	public String getVarValue(String name) {
		for(int i=0;i<this.varAmount;i++){
			if(this.varName[i].equals(name)){
				return this.varValue[i];
			}
		}
		return null;
	}
	
	public void setVarValue(int i,String var) {
		this.varValue[i] = var;
	}
	
	public String getVarName(int line) {
		return varName[line];
	}

	public void setVarName(int i,String var) {
		this.varName[i] = var;
	}

	public int getVarAmount() {
		return varAmount;
	}

	public void setVarAmount(int varAmount) {
		this.varAmount = varAmount;
		this.varName=new String[varAmount];
		this.varValue=new String[varAmount];
	}
	
}
