package com.ifms.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.ifms.entities.AutoPosto;
import com.ifms.entities.Cidade;

public class AutoPostoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@Size(min = 8, max = 120, message = "O tamanho mínimo é de 8 e máximo 120 caracteres")
	@NotBlank(message = "O campo é obrigatório")
	private String nomeFantasia;
	@NotBlank(message = "O campo é obrigatório")
	private String telefone;
	@Email
	private String email;
	@CNPJ(message = "O CNPJ está incorreto")
	private String CNPJ;	
	private String endereco;
	private Cidade cidade;
	
	public AutoPostoDTO() {
	}

	public AutoPostoDTO(Long id, String nomeFantasia, String telefone, String email, String cNPJ, String endereco,
			Cidade cidade) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		this.email = email;
		this.CNPJ = cNPJ;
		this.endereco = endereco;
		this.cidade = cidade;
	}
	
	
	public AutoPostoDTO(AutoPosto entity) {
		this.id = entity.getId();
		this.nomeFantasia = entity.getNomeFantasia();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
		this.CNPJ = entity.getCNPJ();
		this.endereco = entity.getEndereco();
		this.cidade = entity.getCidade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
