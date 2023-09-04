package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	
	private Curso curso;
	private List <Aluno> alunos = new ArrayList<>();
	private List <Professor> professores = new ArrayList<>();
	
	
	public Turma() {
		
	}

	public Turma(Curso curso) {
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}
	
	public void addProfessor(Professor professor) {
		professores.add(professor);
	}
	
	public void removeProfessor(Professor professor) {
		professores.remove(professor);
	}
	
	public String ListaAlunos() {
		StringBuilder sc = new StringBuilder();
		
		for(Colaborador c : alunos) {
			System.out.println("NOME - "+ c.getNome());
		}
		
		return sc.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("----------------------------------\n");
		sb.append("NOVO CURSO CADASTRADO !\n");
		sb.append("----------------------------------\n");
		sb.append("NOME CURSO - " + curso.getNome() +"\n");
		sb.append("DURAÇÃO - " + curso.getDuracao() +"ANOS \n");
		sb.append("SEMESTRES - " + curso.getSemestres() +" SEMESTRES\n");
		sb.append("----------------------------------------\n");
		for(Professor p : professores) {
			sb.append("PROFESSORES \n");
			sb.append("----------------------------------------\n");
			sb.append("NOME - "+ p.getNome()+"\n");
			sb.append("IDADE - "+ p.calculaIdade()+" ANOS\n");
			sb.append("FORMAÇÃO - "+p.getFormacao()+"\n");
		
		}
		
		sb.append("----------------------------------------\n");
		
		for(Aluno a : alunos) {
			sb.append("ALUNOS \n");
			sb.append("----------------------------------------\n");
			sb.append("NOME - "+ a.getNome()+"\n");
			sb.append("IDADE - "+ a.calculaIdade()+"ANOS \n");
			sb.append("FORMAÇÃO - "+a.getSituacao()+"\n");
		}
		
		sb.append("----------------------------------------\n");
		
		
		return sb.toString();
	}
}
