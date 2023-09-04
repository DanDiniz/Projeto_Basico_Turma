package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Exception.DomainException;
import model.entities.Aluno;
import model.entities.Colaborador;
import model.entities.Curso;
import model.entities.Professor;
import model.entities.Turma;
import model.enumeration.situacao;
import model.enumeration.tipoCurso;

public class Program {
	public static void main(String args[]) {
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner input = new Scanner(System.in);

		try {

			System.out.println("-----------------------------------");
			System.out.println("INSTITUTO DE CIÊNCIA E TECNOLOGIA");
			System.out.println("-----------------------------------");
			System.out.println("CADASTRE SUA TURMA : ");
			System.out.println();
			System.out.print("DIGITE O CURSO DA TURMA - ");
			String nomeCurso = input.nextLine();

			System.out.println("-----------------------------------");
			System.out.println(" TIPO DE CURSO");
			System.out.println("-----------------------------------");
			System.out.println("[1] - GRADUACAO");
			System.out.println("[2] - TECNOLOGO");
			System.out.println("[3] - TECNICO");
			System.out.print("SELEÇÃO - ");
			Integer selecaoCurso = input.nextInt();

			String tipoDeCurso = null;

			switch (selecaoCurso) {
			case 1:

				tipoDeCurso = "GRADUACAO";

				break;
			case 2:

				tipoDeCurso = "TECNOLOGO";

				break;
			case 3:

				tipoDeCurso = "TECNICO";

				break;
			default:

				System.out.println("DIGITE UM VALOR VÁLIDO!");

				break;
			}
			
			System.out.println("-----------------------------------");
			System.out.println("DURAÇÃO");
			System.out.println("-----------------------------------");
			System.out.println("DIGITE A DATA DE INICIO (dd/mm/yyyy) - ");
			Date datainicio = sdf.parse(input.next());
			System.out.println("DIGITE A DATA DE TERMINO (dd/mm/yyyy) - ");
			Date dataTermino = sdf.parse(input.next());
			
			Curso curso = new Curso(nomeCurso, tipoCurso.valueOf(tipoDeCurso),datainicio,dataTermino);
			Turma registraTurma = new Turma(curso);
			
			
			
			System.out.println();
			
			for(int i = 0; i < curso.getDuracao(); i++) { 
				
				/* 
				 * OBS: COLOQUEI CADASTRO DE PROFESSOR POR SEMESTRE
				 * PARA O USUARIO NÃO TER DE CADASTRAR UMA QUANTIDADE MASSIVA
				 * DE PROFESSORES E MATERIAS ASSIM NÃO DEIXAR O PROGRAMA CHATO
				 * NO FUTURO MELHORO ESSA IMPLEMENTAÇÃO.
				 */
				
				System.out.println("-----------------------------------");
				System.out.println("FUNCIONARIOS");
				System.out.println("-----------------------------------");
				System.out.print("PROFESSOR : ");
				System.out.println();
				System.out.print("NOME: ");
				String nomeProfessor = input.nextLine();
				input.nextLine();
				System.out.print("DATA DE NASCIMENTO : ");
				Date dataNascimentoP = sdf.parse(input.next());
				System.out.print("CPF: ");
				String cpfP = input.nextLine();
				input.nextLine();
				System.out.print("FORMAÇÃO (CURSO): ");
				String formacao = input.nextLine();
				
				
				registraTurma.addProfessor(new Professor(nomeProfessor,dataNascimentoP,cpfP,formacao));
			}
			
			
			
			int loop = 1;
			
			while(loop != 0) {
			
				System.out.println("DESEJA CADASTRAR ALUNOS NO CURSO ? [S/N]: ");
				String cadastraAluno = input.next();
				
				if(cadastraAluno.charAt(0) == 'S') {
					
					
					System.out.println("-----------------------------------");
					System.out.println("TURMA");
					System.out.println("-----------------------------------");
					System.out.print("CADASTRA ALUNO : ");
					System.out.println();
					System.out.print("NOME: ");
					String nomeAluno = input.nextLine();
					input.nextLine();
					System.out.print("DATA DE NASCIMENTO : ");
					Date dataNascimentoA = sdf.parse(input.next());
					System.out.print("CPF: ");
					String cpfA = input.nextLine();
					input.nextLine();
					
					System.out.println("-----------------------------------");
					System.out.println(" SITUAÇÃO ALUNO ");
					System.out.println("-----------------------------------");
					System.out.println("[1] - CURSANDO");
					System.out.println("[2] - TRANCADO");
					System.out.println("[3] - FORMADO");
					System.out.print("SELEÇÃO - ");
					Integer menuSituacao = input.nextInt();

					String situacaoAluno = null;

					switch (menuSituacao) {
					case 1:

						situacaoAluno = "CURSANDO";

						break;
					case 2:

						situacaoAluno = "TRANCADO";
						break;
					case 3:

						situacaoAluno= "FORMADO";

						break;
					default:

						System.out.println("DIGITE UM VALOR VÁLIDO!");

						break;
					}
					
			
					registraTurma.addAluno(new Aluno(nomeAluno,dataNascimentoA,cpfA,situacao.valueOf(situacaoAluno)));
					
					System.out.println("LISTA DE ALUNOS - ");
					System.out.println(" "+ registraTurma.ListaAlunos());
					
				} else if(cadastraAluno.charAt(0) == 'N'){
					
					System.out.println("SESSÃO ENCERRADA!");
					loop = 0;
				} 
			
			}
			
			
			System.out.println();
			System.out.println(registraTurma.toString());
			
			input.close();
			
			
		}catch(DomainException e) {
			
		System.out.println(e.getMessage());
			
		} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
}
		
