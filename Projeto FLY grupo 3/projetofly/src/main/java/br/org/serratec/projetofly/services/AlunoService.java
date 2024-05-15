package br.org.serratec.projetofly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetofly.entities.Aluno;
import br.org.serratec.projetofly.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
			
		}
	
	public Aluno findById(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	public Aluno update(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	public Aluno update(Aluno aluno, Integer id) {
		Aluno existenteAluno = findById(id);
		existenteAluno.setAlunoMatricula(aluno.getAlunoMatricula ());
		existenteAluno.setNome(aluno.getNome ());
		existenteAluno.setDataNascimento(aluno.getDataNascimento ());
		existenteAluno.setCpf(aluno.getCpf ());
		existenteAluno.setLogradouro(aluno.getLogradouro ());
		existenteAluno.setNumeroLogradouro(aluno.getNumeroLogradouro ());
		existenteAluno.setComplemento(aluno.getComplemento ());
		existenteAluno.setBairro(aluno.getBairro ());
		existenteAluno.setCidade(aluno.getCidade ());
		
		return alunoRepository.save(existenteAluno);
	}

	public long count () {
		return alunoRepository.count();

		}
	
	public boolean deleteById2(Integer id) {
        if (alunoRepository.existsById(id)) {
        	alunoRepository.deleteById(id);
            Aluno alunoDeletado = alunoRepository.findById(id).orElse(null);
            if(alunoDeletado == null) {
            	return true;
            } else {
          
            	return false;
            }
        } else {
            return false;
        }
    }
	
}