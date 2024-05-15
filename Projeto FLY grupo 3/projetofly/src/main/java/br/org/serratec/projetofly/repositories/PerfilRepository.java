package br.org.serratec.projetofly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetofly.entities.Perfil;

public interface PerfilRepository 
	extends JpaRepository<Perfil,Integer>{

}
