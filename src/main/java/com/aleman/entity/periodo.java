package com.aleman.entity;

public class periodo {

	private int periodo; 
	private float S; //saldo
	private float CU; //cuota
	private float I; // interes
	private float CA; //capital amortizado
	private float CP;// capital pendiente
	
	public periodo(int periodo, float s, float cU, float i, float cA, float cP) {
		super();
		this.periodo = periodo;
		S = s;
		CU = cU;
		I = i;
		CA = cA;
		CP = cP;
	}
	public periodo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public float getS() {
		return S;
	}
	public void setS(float s) {
		S = s;
	}
	public float getCU() {
		return CU;
	}
	public void setCU(float cU) {
		CU = cU;
	}
	public float getI() {
		return I;
	}
	public void setI(float i) {
		I = i;
	}
	public float getCA() {
		return CA;
	}
	public void setCA(float cA) {
		CA = cA;
	}
	public float getCP() {
		return CP;
	}
	public void setCP(float cP) {
		CP = cP;
	}
	
	
	
	
	
}
