package com.aleman.entity;

public class tasa {

	private double tasa; // la tasa en si en porcentaje
	private int p;// tipo de tasa nominal
	private int pc;// periodo de capitalizacion
	private int te;// tipo de tasa efectiva requerida

	public double calculoTEP() {
		
		double p1 = this.p;
		double pc1= this.pc;
		double te1=this.te;
		
		double m = p1 / pc1;
		double n = te1 / pc1;
		double newtasa = this.tasa / 100;
		double interes = newtasa / m;
		double base = (1 + interes);
		double resultado = (double) Math.pow(base, n);
		double auxtep = resultado - 1;// retorna el nuevo tep
		return auxtep;
	}

	public tasa(double tasa, int p, int pc, int te) {
		super();
		this.tasa = tasa;
		this.p = p;
		this.pc = pc;
		this.te = te;
	}

	public tasa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + p;
		result = prime * result + pc;
		long temp;
		temp = Double.doubleToLongBits(tasa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + te;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tasa other = (tasa) obj;
		if (p != other.p)
			return false;
		if (pc != other.pc)
			return false;
		if (Double.doubleToLongBits(tasa) != Double.doubleToLongBits(other.tasa))
			return false;
		if (te != other.te)
			return false;
		return true;
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

	public int getTe() {
		return te;
	}

	public void setTe(int te) {
		this.te = te;
	}

}
