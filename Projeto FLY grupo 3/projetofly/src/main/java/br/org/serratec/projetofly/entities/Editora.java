package br.org.serratec.projetofly.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editora")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "editoraId",
		scope = Editora.class
)
public class Editora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "editora_id")
	private Long editoraId;
	
	@Column(name = "nome")
	private String editoraNome;
	
	@Column(name = "imagem_nome")
	private String imagemNome;
	
	@Column(name = "imagem_filename")
	private String imagemFileName;
	
	@Column(name = "imagem_url")
	private String imagemUrl;
	
	@OneToMany(mappedBy = "editora")
	private List<Livro> livros;
	
	public Editora() {
	}

	public Editora(Long editoraId, String editoraNome, String imagemNome, String imagemFileName, String imagemUrl,
			List<Livro> livros) {
		super();
		this.editoraId = editoraId;
		this.editoraNome = editoraNome;
		this.imagemNome = imagemNome;
		this.imagemFileName = imagemFileName;
		this.imagemUrl = imagemUrl;
		this.livros = livros;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Long getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(Long editoraId) {
		this.editoraId = editoraId;
	}

	public String getEditoraNome() {
		return editoraNome;
	}

	public void setEditoraNome(String editoraNome) {
		this.editoraNome = editoraNome;
	}

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemFileName() {
		return imagemFileName;
	}

	public void setImagemFileName(String imagemFileName) {
		this.imagemFileName = imagemFileName;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	@Override
	public String toString() {
		return "Editora [editoraId=" + editoraId + ", editoraNome=" + editoraNome + ", imagemNome=" + imagemNome
				+ ", imagemFileName=" + imagemFileName + ", imagemUrl=" + imagemUrl + ", livros=" + livros
				+ ", getLivros()=" + getLivros() + ", getEditoraId()=" + getEditoraId() + ", getEditoraNome()="
				+ getEditoraNome() + ", getImagemNome()=" + getImagemNome() + ", getImagemFileName()="
				+ getImagemFileName() + ", getImagemUrl()=" + getImagemUrl() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}