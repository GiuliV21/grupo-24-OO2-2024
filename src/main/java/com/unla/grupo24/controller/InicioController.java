package com.unla.grupo24.controller;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo24.helpers.ViewRouteHelper;

@Controller
@RequestMapping("")

public class InicioController {

	//Cuando abris el localhost aparezcas en el inicio
	@GetMapping("")
	public String inicio() {
		return ViewRouteHelper.INDEX;
	}
	
	//Para poder volver atras desde la navbar
		@GetMapping("/index")
		public String inicio3() {
			return ViewRouteHelper.INDEX;
		}

	//Para poder volver atras desde la navbar
	@GetMapping("/inicio")
	public String inicio2() {
		return ViewRouteHelper.INDEX;
	}
	
}