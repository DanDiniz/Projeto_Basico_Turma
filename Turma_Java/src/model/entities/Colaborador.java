package model.entities;

import java.util.Date;

import model.Exception.DomainException;

public class Colaborador {
	

	private String nome;
	private Date data_nascimento;
	private String cpf;
	
	public Colaborador() {
		
	}
	
	

	public Colaborador(String nome, Date data_nascimento, String cpf) throws DomainException {
		Date dataatual = new Date();
		this.nome = nome;
		
		if(data_nascimento.after(dataatual)) {
			throw new DomainException("ERROR: INFORME UMA DATA VÁLIDA");
		} else {
			
			this.data_nascimento = data_nascimento;
			this.cpf = cpf;;
			
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int calculaIdade() {
		
		Date dataatual = new Date();
		
		return dataatual.getYear() - data_nascimento.getYear();
	}

}
