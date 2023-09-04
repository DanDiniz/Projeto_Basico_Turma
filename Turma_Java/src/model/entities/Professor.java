package model.entities;

import java.util.Date;

import model.Exception.DomainException;

public class Professor extends Colaborador{
	
	private String formacao;
	
	
	public Professor(String nome, Date data_nascimento, String formacao,String formacao1) throws DomainException {
		super(nome, data_nascimento, formacao1);
		this.formacao = formacao1;
		
	}


	public String getFormacao() {
		return formacao;
	}


	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	

}
