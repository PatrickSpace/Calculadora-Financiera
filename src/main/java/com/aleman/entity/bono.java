package com.aleman.entity;

import java.util.ArrayList;
import java.util.List;

public class bono {

	private int n;
	private float capital;
	private float tep;

	public List<periodo> flujodecaja() {
		List<periodo> flujo = new ArrayList<periodo>();
		float ca1 = this.capital / this.n;
		float cpaux = 0;
		for (int i = 1; i < n + 1; i++) {
			periodo p = new periodo();
			p.setCA(ca1);
			p.setS(cpaux);
			if (i == 1) {
				p.setS(this.capital);
			}
			p.setPeriodo(i);
			p.setI(p.getS() * this.tep);
			p.setCU(p.getI() + p.getCA());
			p.setCP(p.getS() - p.getCA());
			cpaux = p.getCP();
			flujo.add(p);
		}
		return flujo;
	}

	public float getInterestotal() {
		float interes = 0;
			
			List<periodo> flujo = this.flujodecaja();
			for(periodo p:flujo) {
				interes = interes + p.getI();
			}
		
		return interes;
	}
	public float getPagototal() {
		float pago = 0;

			List<periodo> flujo = this.flujodecaja();
			for(periodo p:flujo) {
				pago = pago + p.getCU();
			}
		
		return pago;
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
