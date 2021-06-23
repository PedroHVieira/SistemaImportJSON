package com.wk.teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "candidatos")
public class Candidatos {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotNull
//	@Column(name = "cand_id")
//	private Long id;
	
	@Id
	@NotNull
	@Column(name = "cand_cpf")
	private String cpf;
	
	@NotNull
	@Column(name = "cand_nome")
	private String nome;
		
	@NotNull
	@Column(name = "cand_rg")
	private String rg;
	
	@NotNull
	@Column(name = "cand_dt_nasc")
	private String data_nasc;

	@NotNull
	@Column(name = "cand_sexo")
	private String sexo;
	
	@NotNull
	@Column(name = "cand_mae")
	private String mae;
	
	@NotNull
	@Column(name = "cand_pai")
	private String pai;
	
	@NotNull
	@Column(name = "cand_email")
	private String email;
	
	@NotNull
	@Column(name = "cand_cep")
	private String cep;
	
	@NotNull
	@Column(name = "cand_endereco")
	private String endereco;
	
	@NotNull
	@Column(name = "cand_numero")
	private String numero;
	
	@NotNull
	@Column(name = "cand_bairro")
	private String bairro;
	
	@NotNull
	@Column(name = "cand_cidade")
	private String cidade;
	
	@NotNull
	@Column(name = "cand_estado")
	private String estado;
	
	@NotNull
	@Column(name = "cand_telefone")
	private String telefone_fixo;
	
	@NotNull
	@Column(name = "cand_celular")
	private String celular;
	
	@NotNull
	@Column(name = "cand_altura")
	private String altura;
	
	@NotNull
	@Column(name = "cand_peso")
	private String peso;
	
	@NotNull
	@Column(name = "cand_tipo_sangue")
	private String tipo_sanguineo;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getTelefone_fixo() {
		return telefone_fixo;
	}

	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}

	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}

	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}
	
	
}
