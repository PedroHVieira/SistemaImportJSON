package com.wk.teste.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wk.teste.model.Candidatos;
import com.wk.teste.model.MyUserDetails;
import com.wk.teste.repository.CandidatosRepository;

@Controller
@RequestMapping("/relatorio")
public class RelatoriosController {
	
	@Autowired
	private CandidatosRepository candidatosRepo;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView abrir(@AuthenticationPrincipal MyUserDetails user) {
		ModelAndView view = new ModelAndView("relatorio/relatorio");
		
		return view.addObject("user", user);
	}
	
	@GetMapping("/buscar_obesidade")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Float[]> buscarObesidade(@AuthenticationPrincipal MyUserDetails user) {
		List<Candidatos> homens = candidatosRepo.findBySexo("Masculino");
		List<Candidatos> mulheres = candidatosRepo.findBySexo("Feminino");
		List<Candidatos> obesosHomens = new ArrayList<Candidatos>();
		List<Candidatos> obesosMulheres = new ArrayList<Candidatos>();
		
		for(int i = 0; i < homens.size(); i++) {
			//imc = peso / altura^2 
			Float peso = Float.parseFloat(homens.get(i).getPeso());
			Float altura = Float.parseFloat(homens.get(i).getAltura());
			Float imc = peso / (altura * altura);
			
			if(imc > 30) {
				obesosHomens.add(homens.get(i));
			}
		}
		
		for(int i = 0; i < mulheres.size(); i++) {
			//imc = peso / altura^2 
			Float peso = Float.parseFloat(mulheres.get(i).getPeso());
			Float altura = Float.parseFloat(mulheres.get(i).getAltura());
			Float imc = peso / (altura * altura);
			
			if(imc > 30) {
				obesosMulheres.add(mulheres.get(i));
			}
		}
		
		Float percentHomensObesos =  obesosHomens.size() / (float) homens.size();
		Float percentMulheresObesos = (float) obesosMulheres.size() / (float) mulheres.size();
		
		Float[] retorno = new Float[] {percentHomensObesos, percentMulheresObesos};
		
		return new ResponseEntity<Float[]>(retorno,HttpStatus.OK);
	}
	
	@GetMapping("/buscar_faixa")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Float[]> buscarFaixaIdade(@AuthenticationPrincipal MyUserDetails user) throws ParseException {
		List<Candidatos> todosCandidatos = candidatosRepo.findAll();
		
		//LISTAS PARA FAIXA DE IDADES
		List<Float[]> listaFaixa = new ArrayList<Float[]>();
		
		Float[] contador1 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador2 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador3 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador4 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador5 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador6 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador7 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador8 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador9 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador10 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		Float[] contador11 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};
		
		listaFaixa.add(contador1);
		listaFaixa.add(contador2);
		listaFaixa.add(contador3);
		listaFaixa.add(contador4);
		listaFaixa.add(contador5);
		listaFaixa.add(contador6);
		listaFaixa.add(contador7);
		listaFaixa.add(contador8);
		listaFaixa.add(contador9);
		listaFaixa.add(contador10);
		listaFaixa.add(contador11);
		
		for(int i = 0; i < todosCandidatos.size(); i++) {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date data = formato.parse(todosCandidatos.get(i).getData_nasc());			
			Integer idade = getIdade(data);		
			
			//imc = peso / altura^2 
			Float peso = Float.parseFloat(todosCandidatos.get(i).getPeso());
			Float altura = Float.parseFloat(todosCandidatos.get(i).getAltura());
			Float imc = peso / (altura * altura);
			
			if(idade < 10) {
				listaFaixa.get(0)[0] = listaFaixa.get(0)[0] + imc;
				listaFaixa.get(0)[1] =  listaFaixa.get(0)[1] + 1;
			}else if(idade >= 11 && idade < 20){
				listaFaixa.get(1)[0] = listaFaixa.get(1)[0] + imc;
				listaFaixa.get(1)[1] =  listaFaixa.get(1)[1] + 1;
			}else if(idade >= 21 && idade < 30){
				listaFaixa.get(2)[0] = listaFaixa.get(2)[0] + imc;
				listaFaixa.get(2)[1] =  listaFaixa.get(2)[1] + 1;
			}else if(idade >= 31 && idade < 40){
				listaFaixa.get(3)[0] = listaFaixa.get(3)[0] + imc;
				listaFaixa.get(3)[1] =  listaFaixa.get(3)[1] + 1;
			}else if(idade >= 41 && idade < 50){
				listaFaixa.get(4)[0] = listaFaixa.get(4)[0] + imc;
				listaFaixa.get(4)[1] =  listaFaixa.get(4)[1] + 1;
			}else if(idade >= 51 && idade < 60){
				listaFaixa.get(5)[0] = listaFaixa.get(5)[0] + imc;
				listaFaixa.get(5)[1] =  listaFaixa.get(5)[1] + 1;
			}else if(idade >= 61 && idade < 70){
				listaFaixa.get(6)[0] = listaFaixa.get(6)[0] + imc;
				listaFaixa.get(6)[1] =  listaFaixa.get(6)[1] + 1;
			}else if(idade >= 71 && idade < 80){
				listaFaixa.get(7)[0] = listaFaixa.get(7)[0] + imc;
				listaFaixa.get(7)[1] =  listaFaixa.get(7)[1] + 1;
			}else if(idade >= 81 && idade < 90){
				listaFaixa.get(8)[0] = listaFaixa.get(8)[0] + imc;
				listaFaixa.get(8)[1] =  listaFaixa.get(8)[1] + 1;
			}else if(idade >= 91 && idade < 100){
				listaFaixa.get(9)[0] = listaFaixa.get(9)[0] + imc;
				listaFaixa.get(9)[1] =  listaFaixa.get(9)[1] + 1;
			}else if(idade >= 101 && idade < 110){
				listaFaixa.get(10)[0] = listaFaixa.get(10)[0] + imc;
				listaFaixa.get(10)[1] =  listaFaixa.get(10)[1] + 1;
			}
		}
		
		Float[] retorno = new Float[] {listaFaixa.get(0)[0] / listaFaixa.get(0)[1],
				listaFaixa.get(1)[0] / listaFaixa.get(1)[1],
				listaFaixa.get(2)[0] / listaFaixa.get(2)[1],
				listaFaixa.get(3)[0] / listaFaixa.get(3)[1],
				listaFaixa.get(4)[0] / listaFaixa.get(4)[1],
				listaFaixa.get(5)[0] / listaFaixa.get(5)[1],
				listaFaixa.get(6)[0] / listaFaixa.get(6)[1],
				listaFaixa.get(7)[0] / listaFaixa.get(7)[1],
				listaFaixa.get(8)[0] / listaFaixa.get(8)[1],
				listaFaixa.get(9)[0] / listaFaixa.get(9)[1],
				listaFaixa.get(10)[0] / listaFaixa.get(10)[1],
				};
		
		return new ResponseEntity<Float[]>(retorno,HttpStatus.OK);
	}
	
	@GetMapping("/buscar_sangue")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Float[]> buscarHpPorIdade(@AuthenticationPrincipal MyUserDetails user) throws ParseException {
		List<Candidatos> todosCandidatos = candidatosRepo.findAll();
		
		//LISTAS TIPO SANGUÍNEOS
		List<Float[]> listaFaixa = new ArrayList<Float[]>();
		
		Float[] contador1 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};//A+
		Float[] contador2 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};//A
		Float[] contador3 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};//B+
		Float[] contador4 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};//B-
		Float[] contador5 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};//AB+
		Float[] contador6 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};//AB-
		Float[] contador7 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};//O+
		Float[] contador8 = new Float[] {Float.parseFloat("0"), Float.parseFloat("0")};//O-
		
		listaFaixa.add(contador1);
		listaFaixa.add(contador2);
		listaFaixa.add(contador3);
		listaFaixa.add(contador4);
		listaFaixa.add(contador5);
		listaFaixa.add(contador6);
		listaFaixa.add(contador7);
		listaFaixa.add(contador8);
		
		for(int i = 0; i < todosCandidatos.size(); i++) {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date data = formato.parse(todosCandidatos.get(i).getData_nasc());			
			Integer idade = getIdade(data);		
			
			String tipoHp = todosCandidatos.get(i).getTipo_sanguineo();
			
			if(tipoHp.equals("A+")) {
				listaFaixa.get(0)[0] = listaFaixa.get(0)[0] + idade;
				listaFaixa.get(0)[1] =  listaFaixa.get(0)[1] + 1;
			}else if(tipoHp.equals("A-")){
				listaFaixa.get(1)[0] = listaFaixa.get(1)[0] + idade;
				listaFaixa.get(1)[1] =  listaFaixa.get(1)[1] + 1;
			}else if(tipoHp.equals("B+")){
				listaFaixa.get(2)[0] = listaFaixa.get(2)[0] + idade;
				listaFaixa.get(2)[1] =  listaFaixa.get(2)[1] + 1;
			}else if(tipoHp.equals("B-")){
				listaFaixa.get(3)[0] = listaFaixa.get(3)[0] + idade;
				listaFaixa.get(3)[1] =  listaFaixa.get(3)[1] + 1;
			}else if(tipoHp.equals("AB+")){
				listaFaixa.get(4)[0] = listaFaixa.get(4)[0] + idade;
				listaFaixa.get(4)[1] =  listaFaixa.get(4)[1] + 1;
			}else if(tipoHp.equals("AB-")){
				listaFaixa.get(5)[0] = listaFaixa.get(5)[0] + idade;
				listaFaixa.get(5)[1] =  listaFaixa.get(5)[1] + 1;
			}else if(tipoHp.equals("O+")){
				listaFaixa.get(6)[0] = listaFaixa.get(6)[0] + idade;
				listaFaixa.get(6)[1] =  listaFaixa.get(6)[1] + 1;
			}else {
				listaFaixa.get(7)[0] = listaFaixa.get(7)[0] + idade;
				listaFaixa.get(7)[1] =  listaFaixa.get(7)[1] + 1;
			}
		}
		
		Float[] retorno = new Float[] {
				listaFaixa.get(0)[0] / listaFaixa.get(0)[1],
				listaFaixa.get(1)[0] / listaFaixa.get(1)[1],
				listaFaixa.get(2)[0] / listaFaixa.get(2)[1],
				listaFaixa.get(3)[0] / listaFaixa.get(3)[1],
				listaFaixa.get(4)[0] / listaFaixa.get(4)[1],
				listaFaixa.get(5)[0] / listaFaixa.get(5)[1],
				listaFaixa.get(6)[0] / listaFaixa.get(6)[1],
				listaFaixa.get(7)[0] / listaFaixa.get(7)[1]
				};
		
		return new ResponseEntity<Float[]>(retorno,HttpStatus.OK);
	}
	
	@GetMapping("/buscar_doador")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Float[]> buscarDoador(@AuthenticationPrincipal MyUserDetails user) throws ParseException {
		List<Candidatos> todosCandidatos = candidatosRepo.findByPesoMaior50();
		
		//LISTAS PARA TIPO SANGUÍNEOS
		List<Float[]> listaFaixa = new ArrayList<Float[]>();
		
		Float[] contador1 = new Float[] {Float.parseFloat("0")};//A+
		Float[] contador2 = new Float[] {Float.parseFloat("0")};//A
		Float[] contador3 = new Float[] {Float.parseFloat("0")};//B+
		Float[] contador4 = new Float[] {Float.parseFloat("0")};//B-
		Float[] contador5 = new Float[] {Float.parseFloat("0")};//AB+
		Float[] contador6 = new Float[] {Float.parseFloat("0")};//AB-
		Float[] contador7 = new Float[] {Float.parseFloat("0")};//O+
		Float[] contador8 = new Float[] {Float.parseFloat("0")};//O-
		
		listaFaixa.add(contador1);
		listaFaixa.add(contador2);
		listaFaixa.add(contador3);
		listaFaixa.add(contador4);
		listaFaixa.add(contador5);
		listaFaixa.add(contador6);
		listaFaixa.add(contador7);
		listaFaixa.add(contador8);
		
		for(int i = 0; i < todosCandidatos.size(); i++) {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date data = formato.parse(todosCandidatos.get(i).getData_nasc());			
			Integer idade = getIdade(data);		
			
			String tipoHp = todosCandidatos.get(i).getTipo_sanguineo();
			
			if(idade >= 16 && idade <= 69 ) {
				if(tipoHp.equals("A+")) {
					listaFaixa.get(0)[0] =  listaFaixa.get(0)[0] + 1;
				}else if(tipoHp.equals("A-")){
					listaFaixa.get(1)[0] =  listaFaixa.get(1)[0] + 1;
				}else if(tipoHp.equals("B+")){
					listaFaixa.get(2)[0] =  listaFaixa.get(2)[0] + 1;
				}else if(tipoHp.equals("B-")){
					listaFaixa.get(3)[0] =  listaFaixa.get(3)[0] + 1;
				}else if(tipoHp.equals("AB+")){
					listaFaixa.get(4)[0] =  listaFaixa.get(4)[0] + 1;
				}else if(tipoHp.equals("AB-")){
					listaFaixa.get(5)[0] =  listaFaixa.get(5)[0] + 1;
				}else if(tipoHp.equals("O+")){
					listaFaixa.get(6)[0] =  listaFaixa.get(6)[0] + 1;
				}else {
					listaFaixa.get(7)[0] =  listaFaixa.get(7)[0] + 1;
				}
			}
		}
		
		Float[] retorno = new Float[] {
				listaFaixa.get(0)[0] + listaFaixa.get(1)[0] + listaFaixa.get(6)[0] + listaFaixa.get(7)[0],//A+
				listaFaixa.get(1)[0] + listaFaixa.get(7)[0],//A-
				listaFaixa.get(2)[0] + listaFaixa.get(3)[0] + listaFaixa.get(6)[0] + listaFaixa.get(7)[0],//B+
				listaFaixa.get(3)[0] + listaFaixa.get(7)[0],//B-
				listaFaixa.get(0)[0] + listaFaixa.get(2)[0] + listaFaixa.get(6)[0] + listaFaixa.get(4)[0] + listaFaixa.get(1)[0] + listaFaixa.get(3)[0] + listaFaixa.get(7)[0] + listaFaixa.get(5)[0],//AB+
				listaFaixa.get(1)[0] + listaFaixa.get(3)[0] + listaFaixa.get(7)[0] + listaFaixa.get(5)[0],//AB-
				listaFaixa.get(6)[0] + listaFaixa.get(7)[0],//O+
				listaFaixa.get(7)[0]//O-
				};
		
		return new ResponseEntity<Float[]>(retorno,HttpStatus.OK);
	}
	
	public static Integer getIdade(Date data) {
		Calendar cData = Calendar.getInstance();
		Calendar cHoje= Calendar.getInstance();
		cData.setTime(data);
		cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));
		int idade = cData.after(cHoje) ? -1 : 0;
		cData.setTime(data);
		idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);
		return idade;
	}
}
