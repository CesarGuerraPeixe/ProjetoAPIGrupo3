package br.org.serratec.projetofly.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projetofly.entities.Editora;
import br.org.serratec.projetofly.services.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	private EditoraService editoraService;

	@GetMapping
	public List<Editora> getAllEditoras() {
		return editoraService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Editora> getEditoraById(@PathVariable Long id) {
		Optional<Editora> editora = editoraService.findById(id);
		return editora.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Editora createEditora(@RequestBody Editora editora) {
		return editoraService.save(editora);
	}

	@PutMapping
	public ResponseEntity<Editora> updateEditora(@RequestBody Editora editoraDetails) {
		Optional<Editora> editora = editoraService.findById(editoraDetails.getEditoraId());
		if (editora.isPresent()) {
			Editora updatedEditora = editora.get();
			updatedEditora.setEditoraNome(editoraDetails.getEditoraNome());
			editoraService.save(updatedEditora);
			return ResponseEntity.ok(updatedEditora);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEditora(@PathVariable Long id) {
		if (editoraService.findById(id).isPresent()) {
			editoraService.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}