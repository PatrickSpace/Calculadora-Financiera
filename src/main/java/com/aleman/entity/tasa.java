package com.aleman.entity;

public class tasa {

	private double tasa; // la tasa en si en porcentaje
	private int p;// tipo de tasa nominal
	private int pc;// periodo de capitalizacion
	

	public double calculoTEA() {
		
		double p1 = this.p;
		double pc1= this.pc;
		double te1=360;
		
		double m = p1 / pc1;
		double n = te1 / pc1;
		double newtasa = this.tasa / 100;
		double interes = newtasa / m;
		double base = (1 + interes);
		double resultado = (double) Math.pow(base, n);
		double auxtep = resultado - 1;// retorna el nuevo tep
		return auxtep;
	}

	public tasa(double tasa, int p, int pc) {
		super();
		this.tasa = tasa;
		this.p = p;
		this.pc = pc;
		
	}

	public tasa() {
		super();
		// TODO Auto-generated constructor stub
	}



	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}



}
