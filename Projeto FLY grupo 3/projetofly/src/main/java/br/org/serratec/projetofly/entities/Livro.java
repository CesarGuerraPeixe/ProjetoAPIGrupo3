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
	private String nomelivro;
	@Column(name = "nome_autor")
	private String nomeautor;
	@Column(name = "data_lancamento")
	private LocalDate datalancamento;
	@Column(name = "codigo_isbn")
	private Integer codigo_isbn;
	
	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> emprestimos;
	
	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;
	
	public Livro() {
	}
	
	public Livro(Integer livroId, String nomelivro, String nomeautor, LocalDate datalancamento, Integer codigo_isbn,
			List<Emprestimo> emprestimo, Editora editora) {
		super();
		this.livroId = livroId;
		this.nomelivro = nomelivro;
		this.nomeautor = nomeautor;
		this.datalancamento = datalancamento;
		this.codigo_isbn = codigo_isbn;
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

	public String getNomelivro() {
		return nomelivro;
	}

	public void setNomelivro(String nomelivro) {
		this.nomelivro = nomelivro;
	}

	public String getNomeautor() {
		return nomeautor;
	}

	public void setNomeautor(String nomeautor) {
		this.nomeautor = nomeautor;
	}

	public LocalDate getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(LocalDate datalancamento) {
		this.datalancamento = datalancamento;
	}

	public Integer getCodigo_isbn() {
		return codigo_isbn;
	}

	public void setCodigo_isbn(Integer codigo_isbn) {
		this.codigo_isbn = codigo_isbn;
	}

	@Override
	public String toString() {
		return "Livro [livroId=" + livroId + ", nomelivro=" + nomelivro + ", nomeautor=" + nomeautor
				+ ", datalancamento=" + datalancamento + ", codigo_isbn=" + codigo_isbn + ", emprestimos=" + emprestimos
				+ ", editora=" + editora + ", getEmprestimo()=" + getEmprestimo() + ", getEditora()=" + getEditora()
				+ ", getLivroId()=" + getLivroId() + ", getNomelivro()=" + getNomelivro() + ", getNomeautor()="
				+ getNomeautor() + ", getDatalancamento()=" + getDatalancamento() + ", getCodigo_isbn()="
				+ getCodigo_isbn() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


}