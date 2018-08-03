package br.com.wm.springmvccombeanvalidation.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.wm.springmvccombeanvalidation.model.Cliente;
import br.com.wm.springmvccombeanvalidation.model.Sexo;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@GetMapping("/novo")
	public ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject("sexos", Arrays.asList(Sexo.values()));
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cliente);
		}
		
		ModelAndView mv = new ModelAndView("redirect:/clientes/novo");
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso.");
		return mv;
	}
	
}