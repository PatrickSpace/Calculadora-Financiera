package com.aleman.entity;

public class periodo_f {

	private double periodo = 1;
	private double valornNocambia = 0;

	public double getValornNocambia() {
		return valornNocambia;
	}

	public void setValornNocambia(double valornNocambia) {
		this.valornNocambia = valornNocambia;
	}

	public void setPeriodo(double periodo) {
		this.periodo = periodo;
	}

	private double valorn = 0;
	private double valorc = 0;
	private double tiempo_anios = 0;
	private double frecuencia = 0;
	private double tea = 0;
	private double I; // interes

	private double amortizacion;
	private double flujoemisor = 0;
	private double flujobonista = 0;
	

	public void dosdecimales() {

		valorn = Math.round(valorn * 100.0) / 100.0;
		I = Math.round(I * 100.0) / 100.0;
		flujoemisor = Math.round(flujoemisor * 100.0) / 100.0;
		flujobonista = Math.round(flujobonista * 100.0) / 100.0;
		amortizacion = Math.round(amortizacion * 100.0) / 100.0;
	}

	
	public double getFlujobonista() {
		return flujobonista;
	}

	public void setFlujobonista(double flujobonista) {
		this.flujobonista = flujobonista;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public double nroPeriodoxAnio() {
		return 360 / frecuencia;
	}

	public double totalPeriodo() {

		return tiempo_anios * nroPeriodoxAnio();
	}

	public double tep_tea() {
		return ((Math.pow((1 + (tea / 100)), (1 / nroPeriodoxAnio()))) - 1);
	}

	public double cuota_R() {
		double r;

		r = valornNocambia * (tep_tea() * Math.pow((1 + tep_tea()), totalPeriodo()))
				/ ((Math.pow((1 + tep_tea()), totalPeriodo()) - 1));
		r = r * (-1);
		r = Math.round(r * 100.0) / 100.0;

		return r;

	}

	public double getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
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

	public double getI() {
		return I;
	}

	public void setI(double i) {
		I = i;
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

	public periodo_f() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getFlujoemisor() {
		return flujoemisor;
	}

	public void setFlujoemisor(double flujoemisor) {
		this.flujoemisor = flujoemisor;
	}

	public periodo_f(double periodo, double valorn, double valorc, double i, double tiempo_anios, double frecuencia,
			double tea, double amort, double flujoe, double valornocambia) {
		super();
		nroPeriodoxAnio();
		totalPeriodo();
		tep_tea();
		cuota_R();
		this.periodo = periodo;
		this.valorn = valorn;
		this.valorc = valorc;
		I = i;
		this.tiempo_anios = tiempo_anios;
		this.frecuencia = frecuencia;
		this.tea = tea;
		this.amortizacion = amort;
		this.flujoemisor = flujoe;
		this.valornNocambia = valornocambia;
	}

}
