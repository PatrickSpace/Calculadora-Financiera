package com.aleman.entity;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class bono {

	private int n;
	private double capital;
	private double tep;


	


	// ALEMAN
	public List<periodo> flujodecajaAleman() {
		List<periodo> flujo = new ArrayList<periodo>();

		double ca1 = this.capital / this.n;
		double cpaux = 0;
		for (int i = 1; i < n + 1; i++) {
			periodo p = new periodo();
			p.setCA(ca1);
			p.setS(cpaux);
			if (i == 1) {
				p.setS(this.capital);
			}
			p.setPeriodo(i);
			p.setI(p.getS() * this.tep / 100);
			p.setCU(p.getI() + p.getCA());
			p.setCP(p.getS() - p.getCA());
			if (p.getCP() < 0) {
				p.setCP(0);
			}
			cpaux = p.getCP();
			flujo.add(p);
		}
		return flujo;
	}

	// acortado
	public List<periodo> flujoacortado(List<periodo> flujo) {
		List<periodo> flujo1 = new ArrayList<periodo>();
		flujo1 = flujo;
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		for (periodo var : flujo1) {
			String ca = df.format(var.getCA());
			var.setCA(Double.valueOf(ca));

			String cp = df.format(var.getCP());
			var.setCP(Double.valueOf(cp));

			String cu = df.format(var.getCU());
			var.setCU(Double.valueOf(cu));

			String s = df.format(var.getS());
			var.setS(Double.valueOf(s));

			String i = df.format(var.getI());
			var.setI(Double.valueOf(i));
		}

		return flujo1;
	}

	// AMERICANO
	public List<periodo> flujodecajaAmericano() {
		List<periodo> flujoamer = new ArrayList<periodo>();
		double aux = 0;
		double i1 = this.capital * (this.tep / 100);

		for (int i = 1; i < n + 1; i++) {
			periodo p = new periodo();
			if (i == 1) {
				p.setS(this.capital);
				p.setCU(aux);
				p.setI(aux);
				p.setCA(aux);
			}
			if (i == n) {
				p.setCU(this.capital + i1);
			}
			p.setI(i1);
			p.setCU(i1);
			p.setCA(p.getCU() - p.getI());
			p.setS(this.capital - p.getCA());
			p.setPeriodo(i);
			p.setCP(p.getS() - p.getCA());
			if (p.getCP() < 0) {
				p.setCP(0);
			}
			flujoamer.add(p);
		}
		return flujoamer;
	}

	// FRANCES
	public List<periodo> flujodecajaFrances() {

		List<periodo> flujofranc = new ArrayList<periodo>();

		/// COLOQUEN AQUI EL CODIGO

		return flujofranc;
	}

	public String getInterestotal(List<periodo> flujo1) {
		double interes = 0;
		String inter = "";
		List<periodo> flujo = flujo1;
		for (periodo p : flujo) {
			interes = interes + p.getI();
		}
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		inter = df.format(interes);
		return inter;
	}

	public String getPagototal(List<periodo> flujo1) {
		double pago = 0;
		String pago1 = "";
		List<periodo> flujo = flujo1;
		for (periodo p : flujo) {
			pago = pago + p.getCU();
		}
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		pago1 = df.format(pago);
		return pago1;
	}

	public bono() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public double getTep() {
		return tep;
	}

	public void setTep(double tep) {
		this.tep = tep;
	}

	public bono(int n, double capital, double tep) {
		super();
		this.n = n;
		this.capital = capital;
		this.tep = tep;
	}




}
