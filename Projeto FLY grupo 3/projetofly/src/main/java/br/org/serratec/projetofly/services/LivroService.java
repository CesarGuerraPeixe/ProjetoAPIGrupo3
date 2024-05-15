package br.org.serratec.projetofly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetofly.entities.Livro;
import br.org.serratec.projetofly.repositories.LivroRepository;

@Service

public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> findAll() {
		return livroRepository.findAll();
		
	}
	
	public Livro findById(Integer id) {
		return livroRepository.findById(id).orElse(null);
	}
	
	public Livro save (Livro livro) {
		return livroRepository.save(livro);
		
	}
	
	public Livro update (Livro livro) {
		return livroRepository.save(livro);
		
	}

	public long count() {
		return livroRepository.count();
	}
	
	public boolean delete2 (Integer id) {
		if(livroRepository.existsById(id)) {
			livroRepository.deleteById(id);
			Livro livroDeletado = livroRepository.findById(id).orElse(null);
			if (livroDeletado == null) {
				return true;
			} else {
				return false;
			}}
			else {
				return false;
			}
			
	}
}