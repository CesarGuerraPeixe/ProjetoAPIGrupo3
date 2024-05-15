package br.org.serratec.projetofly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetofly.entities.Perfil;
import br.org.serratec.projetofly.repositories.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	PerfilRepository perfilRepository;
	
	public List<Perfil> findAll () {
		return perfilRepository.findAll();
	}
	
	public Perfil findById(Integer id) {
		return perfilRepository.findById(id).orElse(null);
	}
	
	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	public Perfil update(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	public void delete(Perfil perfil) {
		perfilRepository.delete(perfil);
	}
	public void deleteById(Integer id) {
		perfilRepository.deleteById(id);
	}
	
	public long count() {
		return perfilRepository.count();
	}
	
	public boolean deleteById2(Integer id) {
        if (perfilRepository.existsById(id)) {
            perfilRepository.deleteById(id);
            Perfil perfilDeletado = perfilRepository.findById(id).orElse(null);
            if(perfilDeletado == null) {
            	return true;
            } else {
            	return false;
            }
        } else {
            return false;
        }
    }
	
}
