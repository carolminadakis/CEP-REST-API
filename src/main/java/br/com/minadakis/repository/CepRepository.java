package br.com.minadakis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minadakis.model.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, String>{

}
