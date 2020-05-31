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
	public String guardar(bono bono,Model model) {
		List<periodo> flujo = bono.flujodecaja();
		model.addAttribute("bono", bono);
		model.addAttribute("lista", flujo);
		return "/bono";
	}
}
