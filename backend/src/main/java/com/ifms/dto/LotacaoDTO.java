package com.ifms.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.ifms.entities.Cidade;
import com.ifms.entities.Lotacao;
import com.ifms.entities.Veiculo;

public class LotacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private String endereco;
	private String email;
	private String site;
	private String telefone;
	private Cidade cidade;
	Set<Veiculo> veiculos = new HashSet<>();
	
	public LotacaoDTO() {
	}

	public LotacaoDTO(Long id, String descricao, String endereco, String email, String site, String telefone,
			Cidade cidade, Set<Veiculo> veiculos) {
		this.id = id;
		this.descricao = descricao;
		this.endereco = endereco;
		this.email = email;
		this.site = site;
		this.telefone = telefone;
		this.cidade = cidade;
		this.veiculos = veiculos;
	}
	
	public LotacaoDTO(Lotacao entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.endereco = entity.getEndereco();
		this.email = entity.getEmail();
		this.site = entity.getSite();
		this.telefone = entity.getTelefone();
		this.cidade = entity.getCidade();
		this.veiculos = entity.getVeiculos();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Set<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Set<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	
}
