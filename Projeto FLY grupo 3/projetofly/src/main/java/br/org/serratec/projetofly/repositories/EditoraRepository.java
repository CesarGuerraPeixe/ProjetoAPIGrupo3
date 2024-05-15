package br.org.serratec.projetofly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.projetofly.entities.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
}