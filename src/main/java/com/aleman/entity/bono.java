package com.aleman.entity;

import java.util.ArrayList;
import java.util.List;

public class bono {

	private int n;
	private float capital;
	private float tep;

	public List<periodo> flujodecaja() {
		List<periodo> flujo = new ArrayList<periodo>();
		periodo p = new periodo();
		float ca1 = this.capital / this.n;
		p.setCA(ca1);
		p.setS(this.capital);

		for (int i = 1; i > n + 1; i++) {
			p.setPeriodo(i);
			p.setI(p.getS() * this.tep);
			p.setCU(p.getI() + p.getCA());
			p.setCP(p.getS() - p.getCA());
			flujo.add(p);
			p.setS(p.getCP());
		}
		return flujo;
	}

	public bono() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bono(int n, float capital, float tep) {
		super();
		this.n = n;
		this.capital = capital;
		this.tep = tep;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public float getCapital() {
		return capital;
	}

	public void setCapital(float capital) {
		this.capital = capital;
	}

	public float getTep() {
		return tep;
	}

	public void setTep(float tep) {
		this.tep = tep;
	}

}
