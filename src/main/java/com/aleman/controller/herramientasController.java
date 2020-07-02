package com.aleman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aleman.entity.tasa;

@Controller
@RequestMapping("/herramientas")
public class herramientasController {

	@GetMapping("/tnpatep")
	public String tnpatep(Model model) {
		double tnp = 0;
		double tep = 0;
		model.addAttribute("tasa", new tasa());
		model.addAttribute("tnp", tnp);
		model.addAttribute("tep", tep);
	
		return "/tasas";
	}

	@PostMapping("/calcular")
	public String calcular(Model model, tasa tasa) {

		double tep = tasa.calculoTEA();
		double p1 = tasa.getP();
		double pc1 = tasa.getPc();
		double te1 = 360;
		double m = p1 / pc1;
		double n = te1 / pc1;
		String formatTEP="";
		double newtep = tep *100;
		formatTEP = String.valueOf(newtep) + "%";
		model.addAttribute("m", m);
		model.addAttribute("n", n);
		model.addAttribute("tep", formatTEP);
		return "/tasas";
	}
}
