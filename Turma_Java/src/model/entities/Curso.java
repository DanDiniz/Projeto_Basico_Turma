package model.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Exception.DomainException;
import model.enumeration.tipoCurso;

public class Curso {
	
	private String nome;
	private tipoCurso tipo;
	private Date data_inicio;
	private Date data_termino;

	private long duracao;
	private Integer semestres;
	private List <String> materia = new ArrayList<>(); 
	
	public Curso(String nome, tipoCurso tipo, Date data_inicio, Date data_termino) throws DomainException {

		this.nome = nome;
		this.tipo = tipo;
		
		if(data_inicio.after(data_termino)) {
			throw new DomainException("ERROR : TEMPO DAS DATAS ESTA INVALIDO!!");
		} else {
		
			long diferenca_em_tempo = data_termino.getTime() - data_inicio.getTime();
			
			this.data_inicio = data_inicio;
			this.data_termino = data_termino;
			this.duracao  = (diferenca_em_tempo / (1000l * 60 * 60 * 24 * 365));
			this.semestres = (int) (duracao * 2);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public tipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(tipoCurso tipo) {
		this.tipo = tipo;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_termino() {
		return data_termino;
	}

	public void setData_termino(Date data_termino) {
		this.data_termino = data_termino;
	}


	public long getDuracao() {
		return duracao;
	}

	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}

	public Integer getSemestres() {
		return semestres;
	}

	public void setSemestres(Integer semestres) {
		this.semestres = semestres;
	}
	
	private void addMateria(String nomeMateria) {
		materia.add(nomeMateria);
	}
	
	private void removeMateria(String nomeMateria) {
		materia.remove(nomeMateria);
	}
}
