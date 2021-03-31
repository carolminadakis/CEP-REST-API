package br.com.minadakis.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Cep implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 
	@NotBlank(message = "Campo obrigatório!")
	@Id 
	private String cep;
	 
	@NotBlank(message = "Campo obrigatório!")
	private String endereco;	
	 
	@NotBlank(message = "Campo obrigatório!")
	private String bairro;
	 
	@NotBlank(message = "Campo obrigatório!")
	private String cidade;
	
	@NotBlank(message = "Campo obrigatório!")
	private String estado;

	
	public Cep() {
	}


	public Cep(@NotBlank String cep, @NotBlank String endereco, @NotBlank String bairro,
			@NotBlank String cidade, @NotBlank String estado) {
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cep other = (Cep) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		return true;
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
}

