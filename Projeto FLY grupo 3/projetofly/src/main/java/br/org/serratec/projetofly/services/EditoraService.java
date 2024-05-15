package br.org.serratec.projetofly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetofly.entities.Editora;
import br.org.serratec.projetofly.repositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository editoraRepository;

	public List<Editora> findAll() {
		return editoraRepository.findAll();
	}

	public Optional<Editora> findById(Long id) {
		return editoraRepository.findById(id);
	}

	public Editora save(Editora editora) {
		return editoraRepository.save(editora);
	}

	public void deleteById(Long id) {
		editoraRepository.deleteById(id);
	}
}
