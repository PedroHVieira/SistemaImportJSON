package com.wk.teste.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wk.teste.model.Candidatos;
import com.wk.teste.model.MyUserDetails;
import com.wk.teste.model.ResponseJson;
import com.wk.teste.repository.CandidatosRepository;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private CandidatosRepository candidatosRepo;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView index(@AuthenticationPrincipal MyUserDetails user) {
		ModelAndView view = new ModelAndView("index");
		List<Candidatos> lista = candidatosRepo.findAll();
		
		String total = "Total de Candidatos: "+lista.size();
		
		return view.addObject("user", user)
				.addObject("total", total);
	}
	
	@GetMapping("/modal")
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView modal(@AuthenticationPrincipal MyUserDetails user) {
		ModelAndView view = new ModelAndView("index/modal");	
		
		return view.addObject("user", user.getUser());
	}
	
	@GetMapping("/buscar_uf")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object[]> buscarQtPorUf(@AuthenticationPrincipal MyUserDetails user) {
		List<Candidatos> listaGroupByUfs = candidatosRepo.findGroupByUf();
		List<String> ufs = new ArrayList<String>();
		List<Integer> qtPorUfs = new ArrayList<Integer>();
		
		for(int i = 0; i < listaGroupByUfs.size(); i++) {
			ufs.add(listaGroupByUfs.get(i).getEstado());
		}
		
		for(int i = 0; i < ufs.size(); i++) {
			List<Candidatos> litaUfs = candidatosRepo.findByUf(ufs.get(i));
			qtPorUfs.add(litaUfs.size());
		}
		
		Object[] retorno = new Object[] {ufs,qtPorUfs};	
		
		return new ResponseEntity<Object[]>(retorno,HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ResponseJson> salvarJSON(@AuthenticationPrincipal MyUserDetails usuarioSistema,
			@RequestBody List<Candidatos> candidatos) {
		ResponseJson response = new ResponseJson();
		
		try {		
			candidatosRepo.saveAll(candidatos);
			
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
