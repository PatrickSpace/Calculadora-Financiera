package com.aleman.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aleman.entity.bono;
import com.aleman.entity.periodo;

@RequestMapping("/bono")
@Controller
public class bonoController {

	@GetMapping("/")
	public String mostrarbono(Model model) {
		model.addAttribute("bono", new bono());
		model.addAttribute("lista", new ArrayList<periodo>());
		model.addAttribute("mensaje", "Aun no se ha calculado nada");
		return "/bono";
	}

	@PostMapping("/save")
	public String guardar(bono bono, Model model) {
		float interestotal = 0;
		float pagottotal = 0;
		List<periodo> flujo = bono.flujodecaja();
		interestotal = bono.getInterestotal();
		pagottotal= bono.getPagototal();
		bono bono1 = new bono();
		bono1 = bono;
		model.addAttribute("bono", bono1);
		model.addAttribute("lista", flujo);
		model.addAttribute("interes", interestotal);
		model.addAttribute("pago", pagottotal);
		if (flujo.isEmpty()) {
			model.addAttribute("mensaje", "La lista está vacia");
		}
		return "/bono";
	}
}
