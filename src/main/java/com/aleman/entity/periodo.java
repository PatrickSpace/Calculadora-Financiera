package com.aleman.entity;

public class periodo {

	private int periodo; 
	private double S; //saldo
	private double CU; //cuota
	private double I; // interes
	private double CA; //capital amortizado
	private double CP;// capital pendiente
	private double FE; //flujo emisor
	private double FB; //flujo bonista
	private double valornocmabia; // para el frances
	
	public double getValornocmabia() {
		return valornocmabia;
	}
	public void setValornocmabia(double valornocmabia) {
		this.valornocmabia = valornocmabia;
	}
	public double getFE() {
		return FE;
	}
	public void setFE(double fE) {
		FE = fE;
	}
	public double getFB() {
		return FB;
	}
	public void setFB(double fB) {
		FB = fB;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public double getS() {
		return S;
	}
	public void setS(double s) {
		S = s;
	}
	public double getCU() {
		return CU;
	}
	public void setCU(double cU) {
		CU = cU;
	}
	public double getI() {
		return I;
	}
	public void setI(double i) {
		I = i;
	}
	public double getCA() {
		return CA;
	}
	public void setCA(double cA) {
		CA = cA;
	}
	public double getCP() {
		return CP;
	}
	public void setCP(double cP) {
		CP = cP;
	}
	public periodo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public periodo(int periodo, double s, double cU, double i, double cA, double cP, double fE, double fB) {
		super();
		this.periodo = periodo;
		S = s;
		CU = cU;
		I = i;
		CA = cA;
		CP = cP;
		FE = fE;
		FB = fB;
	}
	

	
	
	
	
}
