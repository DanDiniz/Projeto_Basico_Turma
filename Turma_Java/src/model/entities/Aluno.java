package model.entities;

import java.util.Date;

import model.Exception.DomainException;
import model.enumeration.situacao;



public class Aluno extends Colaborador{
	
	private situacao situacao;

	public Aluno(String nome, Date data_nascimento, String cpf, model.enumeration.situacao situacao)
			throws DomainException {
		super(nome, data_nascimento, cpf);
		this.situacao = situacao;
	}

	public situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(situacao situacao) {
		this.situacao = situacao;
	}
	
	
		
}
