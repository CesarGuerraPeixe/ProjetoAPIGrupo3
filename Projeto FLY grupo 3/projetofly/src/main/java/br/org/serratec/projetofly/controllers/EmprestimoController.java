package br.org.serratec.projetofly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.org.serratec.projetofly.entities.Emprestimo;
import br.org.serratec.projetofly.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    
    @Autowired
    EmprestimoService emprestimoService;
    
    @GetMapping
    public ResponseEntity<List<Emprestimo>> findAll() {
        List<Emprestimo> emprestimos = emprestimoService.findAll();
        if (emprestimos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(emprestimos, HttpStatus.OK);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Integer id) {
        Emprestimo emprestimo = emprestimoService.findById(id);
        if (emprestimo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        }
    }
    
    @PostMapping
    public ResponseEntity<Emprestimo> save(@RequestBody Emprestimo emprestimo) {
        return new ResponseEntity<>(emprestimoService.save(emprestimo), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> update(@RequestBody Emprestimo emprestimo) {
            return new ResponseEntity<>(emprestimoService.update(emprestimo), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmprestimoById(@PathVariable Integer id) {
        boolean deleted = emprestimoService.deleteById2(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }    
}