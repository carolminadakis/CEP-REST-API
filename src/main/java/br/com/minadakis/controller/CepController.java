package br.com.minadakis.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.minadakis.model.Cep;
import br.com.minadakis.service.CepService;


@RestController
@RequestMapping("/cep")
public class CepController {

	@Autowired
	CepService cs;
	
//LISTA TODOS OS CEPS CADASTRADOS
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cep> listaTodos() {
		return cs.buscaTodos();
	}
	
	//BUSCA POR CEP NO BANCO DE DADOS
	@GetMapping("/{cep}")
	@ResponseStatus(HttpStatus.OK)
	public Cep buscaCep(@PathVariable @Valid @RequestBody String cep) {
		return cs.buscaPorCep(cep);
	}
	
	//FAZ O CADASTRAMENTO NO BANCO DE DADOS
	@PostMapping			
	@ResponseStatus(HttpStatus.CREATED)
	public Cep salvaCadastro(@Valid @RequestBody Cep cep) {
		return cs.salva(cep);
	}
	
	//ALTERA AS INFORMAÇÕES DE CADASTRO EXISTENTE
	@PutMapping("/{cep}")
	@ResponseStatus(HttpStatus.OK)
	public Cep atualizaCadastro(@PathVariable String cep, @Valid @RequestBody Cep cepAtual) {
			
		Cep cepEncontrado = cs.buscaPorCep(cep);
		BeanUtils.copyProperties(cepAtual, cepEncontrado, "cep");
		return cs.salva(cepEncontrado);
	}
	
	//DELETA CADASTRO E RETORNA NO CONTENT COMO CONFIRMAÇÃO
	@DeleteMapping("/{cep}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletaCadastro(@PathVariable String cep) {
		cs.deleta(cep);
	}
}
