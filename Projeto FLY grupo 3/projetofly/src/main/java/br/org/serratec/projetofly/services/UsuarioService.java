package br.org.serratec.projetofly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetofly.entities.Usuario;
import br.org.serratec.projetofly.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll () {
		return usuarioRepository.findAll();
	}

	public Usuario FindById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);
	}
	
	public long count() {
		return usuarioRepository.count();
	}
	
	public boolean deleteById2(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            Usuario usuarioDeletado = usuarioRepository.findById(id).orElse(null);
            if(usuarioDeletado == null) {
            	return true;
            } else {
            	return false;
            }
        } else {
            return false;
        }
    }

}
