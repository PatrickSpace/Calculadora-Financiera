package com.aleman.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aleman.entity.bono;
import com.aleman.entity.periodo;


@RequestMapping("/bono")
@Controller
public class bonoController {

	@GetMapping("/{moneda}/{tipo}/new")
	public String mostrarbonoAmericano(Model model, @PathVariable(name = "moneda") int moneda,
			@PathVariable(name = "tipo") int tipo) {
		if (moneda == 0) {
			model.addAttribute("moneda", "S/. ");
			model.addAttribute("tm", "0");
		}
		if (moneda == 1) {
			model.addAttribute("moneda", "US$ ");
			model.addAttribute("tm", "1");
		}

		if (tipo == 1) { // americano = 1
			model.addAttribute("tipo", "Americano");
			model.addAttribute("tt", 1);
		}
		if (tipo == 2) { // aleman = 2
			model.addAttribute("tipo", "Aleman");
			model.addAttribute("tt", 2);
		}
		if (tipo == 3) { // frances = 3
			model.addAttribute("tipo", "Frances");
			model.addAttribute("tt", 3);
		}
		model.addAttribute("bono", new bono());
		model.addAttribute("lista", new ArrayList<periodo>());
		return "bono";
	}

	@PostMapping("/{moneda}/{tipo}/save")
	public String guardar(bono bono, Model model, @PathVariable(name = "moneda") int moneda,
			@PathVariable(name = "tipo") int tipo) {
		String tcea = "";
		String precioactual = "";
		String utilidad = "";
		String cok = "";
		String tir = "";

		if (moneda == 0) {
			model.addAttribute("moneda", "S/. ");
			model.addAttribute("tm", "0");
		}
		if (moneda == 1) {
			model.addAttribute("moneda", "US$ ");
			model.addAttribute("tm", "1");
		}

		List<periodo> flujo = new ArrayList<periodo>();

		if (tipo == 1) { // americano = 1
			model.addAttribute("tipo", "Americano");
			model.addAttribute("tt", 1);
			flujo = bono.flujodecajaAmericano();
		}
		if (tipo == 2) { // aleman = 2
			model.addAttribute("tipo", "Aleman");
			model.addAttribute("tt", 2);
			flujo = bono.flujodecajaAleman();
		}
		if (tipo == 3) { // frances = 3
			model.addAttribute("tipo", "Frances");
			model.addAttribute("tt", 3);
			flujo = bono.flujodecajaFrances();

			////////////////////////////////
			/*
			 * model.addAttribute("lista", flujo); bono bono11 = new bono(); bono11 = bono;
			 * model.addAttribute("bono", bono11); tcea = bono.tceaemisor(flujo);
			 * precioactual = bono.precioactual(flujo); utilidad =
			 * bono.utilidadoperdida(flujo); cok = bono.cokstring(); tir = bono.tir(flujo);
			 * model.addAttribute("tcea", tcea); model.addAttribute("pa", precioactual);
			 * model.addAttribute("uop", utilidad); model.addAttribute("cok", cok);
			 * model.addAttribute("tir", tir); ////////////////////////////////
			 * 
			 * 
			 * return "/bonoF";
			 */
		}

		/////////
		tcea = bono.tceaemisor(flujo);
		precioactual = bono.precioactual(flujo);
		utilidad = bono.utilidadoperdida(flujo);
		cok = bono.cokstring();
		tir = bono.tir(flujo);
		/////////
		List<periodo> flujochico = new ArrayList<periodo>();
		flujochico = bono.flujoacortado(flujo);
		model.addAttribute("lista", flujochico);
		/////////
		bono bono1 = new bono();
		bono1 = bono;
		model.addAttribute("bono", bono1);
		model.addAttribute("tcea", tcea);
		model.addAttribute("pa", precioactual);
		model.addAttribute("uop", utilidad);
		model.addAttribute("cok", cok);
		model.addAttribute("tir", tir);

		if (flujo.isEmpty()) {
			model.addAttribute("mensaje", "La lista está vacia");
		}

		return "bono";

	}

}
