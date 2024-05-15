package br.org.serratec.projetofly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetofly.entities.Aluno;

public interface AlunoRepository 
	extends JpaRepository<Aluno,Integer> {

}