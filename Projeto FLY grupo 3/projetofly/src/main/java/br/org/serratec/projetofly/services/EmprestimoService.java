package br.org.serratec.projetofly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetofly.entities.Emprestimo;
import br.org.serratec.projetofly.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	EmprestimoRepository emprestimoRepository;

	public List<Emprestimo> findAll () {
		return emprestimoRepository.findAll();
	}
	
	public Emprestimo findById(Integer id) {
		return emprestimoRepository.findById(id).orElse(null);
	}
	
	public Emprestimo save(Emprestimo Emprestimo) {
		return emprestimoRepository.save(Emprestimo);
	}
	
	public Emprestimo update(Emprestimo Emprestimo) {
		return emprestimoRepository.save(Emprestimo);
	}
	
	public void delete(Emprestimo Emprestimo) {
		emprestimoRepository.delete(Emprestimo);
	}
	public void deleteById(Integer id) {
		emprestimoRepository.deleteById(id);
	}
	
	public long count() {
		return emprestimoRepository.count();
	}
	
	public boolean deleteById2(Integer id) {
        if (emprestimoRepository.existsById(id)) {
            emprestimoRepository.deleteById(id);
            Emprestimo EmprestimoDeletado = emprestimoRepository.findById(id).orElse(null);
            if(EmprestimoDeletado == null) {
            	return true;
            } else {
            	return false;
            }
        } else {
            return false;
        }
    }
}
