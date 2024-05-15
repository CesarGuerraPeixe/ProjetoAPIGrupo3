package br.org.serratec.projetofly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetofly.entities.Livro;

public interface LivroRepository 
extends JpaRepository<Livro,Integer>{

}