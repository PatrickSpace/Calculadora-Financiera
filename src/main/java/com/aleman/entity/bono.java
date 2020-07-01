package com.aleman.entity;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class bono {

	private double n;
	private double capital;
	private double tep;

    //valores de entrada 
	private double valorn;// capital
	private double valorc;
	private double tiempo_anios;// para n
	private double frecuencia;// para n
	private double tea;// tep
//////////////////////////////////////////

	// ALEMAN
	public List<periodo> flujodecajaAleman() {
		List<periodo> flujo = new ArrayList<periodo>();

		this.n = this.tiempo_anios * 360 / this.frecuencia;
		this.capital = this.valorn;
		double base = 1 + this.tea / 100;
		this.tep = Math.pow(base, this.frecuencia / 360) - 1;

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
			p.setI(p.getS() * this.tep);
			p.setCU(p.getI() + p.getCA());
			p.setFE(p.getCU()*-1);
			p.setFB(p.getCU());
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
			
			String fe = df.format(var.getFE());
			var.setFE(Double.valueOf(fe));
			
			String fb = df.format(var.getFB());
			var.setFB(Double.valueOf(fb));
			
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

		this.n = this.tiempo_anios * 360 / this.frecuencia;
		this.capital = this.valorn;
		double base = 1 + this.tea / 100;
		this.tep = Math.pow(base, this.frecuencia / 360) - 1;

		List<periodo> flujoamer = new ArrayList<periodo>();
		double aux = 0;
		double i1 = this.capital * (this.tep);

		for (int i = 1; i < n + 1; i++) {
			periodo p = new periodo();
			if (i == 1) {
				p.setS(this.capital);
				p.setCU(aux);
				p.setI(aux);
				p.setCA(aux);
			}
			p.setCU(i1);
			if (i == n) {
				p.setCU(this.capital + i1);
			}
			p.setI(i1);
			p.setCA(p.getCU() - p.getI());
			p.setS(this.capital - p.getCA());
			p.setPeriodo(i);
			p.setCP(p.getS() - p.getCA());
			if (p.getCP() < 0) {
				p.setCP(0);
			}
			
			p.setFE(p.getCU()*-1);
			p.setFB(p.getCU());
			flujoamer.add(p);
		}
		return flujoamer;
	}

	// FRANCES
	public List<periodo_f> flujodecajaFrances() {

		List<periodo_f> flujofranc = new ArrayList<periodo_f>();
		periodo_f per = new periodo_f();
		per.setValorc(valorc);
		per.setValorn(valorn);
		per.setTiempo_anios(tiempo_anios);
		per.setTea(tea);
		per.setFrecuencia(frecuencia);

		double aux = 0;
		double auxcont = per.totalPeriodo();
		double r = per.getValorn();
		for (int cont = 1; cont < auxcont + 1; cont++) {

			if (cont == 0) {

			}
			if (cont == 1) {
				per.setValornNocambia(r);
			} else {
				per = new periodo_f();
				per.setValorn(aux);
				per.setTiempo_anios(tiempo_anios);
				per.setTea(tea);
				per.setFrecuencia(frecuencia);
				per.setValornNocambia(r);
			}

			per.setI((-1) * (per.getValorn() * per.tep_tea()));
			per.setPeriodo(cont * 100 / 100);
			per.setAmortizacion((per.cuota_R() - per.getI()));
			per.setFlujoemisor((per.getValorn() + per.getAmortizacion()));
			per.setFlujobonista(per.cuota_R()*-1);
			if (cont == auxcont) {
				per.setFlujoemisor(0);
			}
			
			per.dosdecimales();
			flujofranc.add(per);

			aux = (per.getValorn() + per.getAmortizacion()) * 100 / 100;

		}
		return flujofranc;
	}
/////////////

	public String getInterestotal_F(List<periodo_f> flujo1) {
		double interes = 0;
		String inter = "";
		List<periodo_f> flujo = flujo1;
		for (periodo_f p : flujo) {
			interes = interes + p.getI();
		}
		interes = interes * (-1.0);
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		inter = df.format(interes);
		return inter;
	}

	public String getPagototal_F(List<periodo_f> flujo1) {
		double pago = 0;
		String pago1 = "";
		List<periodo_f> flujo = flujo1;
		for (periodo_f p : flujo) {
			pago = pago + p.cuota_R();
		}
		pago = pago * (-1.0);
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		pago1 = df.format(pago);
		return pago1;
	}
/////////////     RESULTADOS

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
	
	public String getTEPacortado() {
		String tep;
		double tepn = this.tep*100;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		tep = df.format(tepn) + "%";
		return tep;
	}
	public String precioactual() {
		return "";
	}
	public String utilidadoperdida() {
		return "";
	}
	public String tceaemisor() {
		return "";
	}
	public String treabonista() {
		return "";
	}
	

	public bono() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getN() {
		return n;
	}

	public void setN(double n) {
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

	public bono(double valorn, double valorc, double tiempo_anios, double frecuencia, double tea) {
		super();

		this.valorn = valorn;
		this.valorc = valorc;
		this.tiempo_anios = tiempo_anios;
		this.frecuencia = frecuencia;
		this.tea = tea;

	}

	public double getValorn() {
		return valorn;
	}

	public void setValorn(double valorn) {
		this.valorn = valorn;
	}

	public double getValorc() {
		return valorc;
	}

	public void setValorc(double valorc) {
		this.valorc = valorc;
	}

	public double getTiempo_anios() {
		return tiempo_anios;
	}

	public void setTiempo_anios(double tiempo_anios) {
		this.tiempo_anios = tiempo_anios;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}

	public double getTea() {
		return tea;
	}

	public void setTea(double tea) {
		this.tea = tea;
	}

}
