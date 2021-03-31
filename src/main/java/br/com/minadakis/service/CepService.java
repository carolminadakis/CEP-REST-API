package br.com.minadakis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.minadakis.model.Cep;
import br.com.minadakis.repository.CepRepository;

@Service
public class CepService {

	@Autowired
	CepRepository cr;
	

	public List<Cep> buscaTodos() {
		return cr.findAll();
	}
	
	public Cep buscaPorCep(String cep) {
		return cr.findById(cep).orElseThrow((
				) -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não cadastrado."));
	}
	
	public Cep salva(Cep cep) {
		return cr.save(cep);
	}
	
	public void deleta(String cep) {
		cr.deleteById(cep);
	}
}
