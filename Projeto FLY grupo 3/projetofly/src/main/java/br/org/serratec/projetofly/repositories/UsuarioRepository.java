package br.org.serratec.projetofly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetofly.entities.Usuario;

public interface UsuarioRepository 
	extends JpaRepository<Usuario,Integer>{
	
}

