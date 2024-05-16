package br.org.serratec.projetofly.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "livro")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "livroId",
		scope = Livro.class
)
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_id")
	private Integer livroId;
	
	@Column(name = "nome_livro")
	private String nomeLivro;
	
	@Column(name = "nome_autor")
	private String nomeAutor;
	
	@Column(name = "data_lancamento")
	private LocalDate dataLancamento;
	
	@Column(name = "codigoIsbn")
	private Integer codigoIsbn;
	
	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> emprestimos;
	
	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;
	
	public Livro() {
	}
	
	public Livro(Integer livroId, String nomeLivro, String nomeAutor, LocalDate dataLancamento, Integer codigoIsbn,
			List<Emprestimo> emprestimo, Editora editora) {
		super();
		this.livroId = livroId;
		this.nomeLivro = nomeLivro;
		this.nomeAutor = nomeAutor;
		this.dataLancamento = dataLancamento;
		this.codigoIsbn = codigoIsbn;
		this.emprestimos = emprestimo;
		this.editora = editora;
	}

	public List<Emprestimo> getEmprestimo() {
		return emprestimos;
	}

	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimos = emprestimo;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public String getnomeLivro() {
		return nomeLivro;
	}

	public void setnomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getnomeAutor() {
		return nomeAutor;
	}

	public void setnomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public LocalDate getdataLancamento() {
		return dataLancamento;
	}

	public void setdataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getcodigoIsbn() {
		return codigoIsbn;
	}

	public void setcodigoIsbn(Integer codigoIsbn) {
		this.codigoIsbn = codigoIsbn;
	}

	@Override
	public String toString() {
		return "Livro [livroId=" + livroId + ", nomeLivro=" + nomeLivro + ", nomeAutor=" + nomeAutor
				+ ", dataLancamento=" + dataLancamento + ", codigoIsbn=" + codigoIsbn + ", emprestimos=" + emprestimos
				+ ", editora=" + editora + ", getEmprestimo()=" + getEmprestimo() + ", getEditora()=" + getEditora()
				+ ", getLivroId()=" + getLivroId() + ", getnomeLivro()=" + getnomeLivro() + ", getnomeAutor()="
				+ getnomeAutor() + ", getdataLancamento()=" + getdataLancamento() + ", getcodigoIsbn()="
				+ getcodigoIsbn() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


}