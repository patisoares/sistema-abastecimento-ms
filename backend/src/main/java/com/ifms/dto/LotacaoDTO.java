package com.ifms.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ifms.entities.Cidade;
import com.ifms.entities.Lotacao;

public class LotacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@Size(min = 10, max = 150)
	@NotBlank(message = "O campo é obrigatório")
	private String descricao;
	@NotBlank(message = "O campo é obrigatório")
	private String endereco;
	@Email
	private String email;
	private String site;
	@NotBlank(message = "O campo é obrigatório")
	private String telefone;
	private Cidade cidade;
	
	
	public LotacaoDTO() {
	}

	public LotacaoDTO(Long id, String descricao, String endereco, String email, String site, String telefone,
			Cidade cidade) {
		this.id = id;
		this.descricao = descricao;
		this.endereco = endereco;
		this.email = email;
		this.site = site;
		this.telefone = telefone;
		this.cidade = cidade;
		
	}
	
	public LotacaoDTO(Lotacao entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.endereco = entity.getEndereco();
		this.email = entity.getEmail();
		this.site = entity.getSite();
		this.telefone = entity.getTelefone();
		this.cidade = entity.getCidade();
		
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

		
}
