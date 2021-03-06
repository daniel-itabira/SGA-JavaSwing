package systemBack;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import academicoBack.Curso;
import academicoBack.Departamento;
import membros.Aluno;
import membros.Professor;

public class Base {

	/**
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private ArrayList<Departamento> DepartamentosDoInstituto;
	private LinkedList<Curso> CursosDoInstituto;
	private LinkedList<Aluno> AlunosDoInstituto;
	private LinkedList<Professor> ProfessoresDoInstituto;

	private LinkedList<String> cpfAlunos;
	private LinkedList<String> codProfessores;
	private LinkedList<String> cpfProfessores;

	public Base() {

		this.CursosDoInstituto = new LinkedList<Curso>();
		this.AlunosDoInstituto = new LinkedList<Aluno>();
		this.ProfessoresDoInstituto = new LinkedList<Professor>();
		this.cpfAlunos = new LinkedList<String>();
		this.DepartamentosDoInstituto = new ArrayList<Departamento>();
		this.setCodProfessores(new LinkedList<String>());
		this.cpfProfessores = new LinkedList<String>();
	}

	/*
	 * Armazena em um Array todos os dados dos alunos presentes na base
	 * 
	 * @return String[]
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public String[] ImprimeAlunosInstituto() {

		String[] alunos = new String[AlunosDoInstituto.size()];
		for (int i = 0; i < AlunosDoInstituto.size(); i++) {

			alunos[i] = "MATRICULA: " + AlunosDoInstituto.get(i).getMatricula() + " NOME: "
					+ AlunosDoInstituto.get(i).getNome() + " CURSO: " + AlunosDoInstituto.get(i).getNomeCursoCursado()
					+ " STATUS: " + AlunosDoInstituto.get(i).getStatus();

		}

		return alunos;
	}

	/*
	 * Remove aluno da institu��o
	 * 
	 * @param dadosDoAluno
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void removeAlunoDoInstituto(String dadosDoAluno) {

		String st = "";

		for (int i = 0; i < AlunosDoInstituto.size(); i++) {

			st = "MATRICULA: " + AlunosDoInstituto.get(i).getMatricula() + " NOME: "
					+ AlunosDoInstituto.get(i).getNome() + " CURSO: " + AlunosDoInstituto.get(i).getNomeCursoCursado()
					+ " STATUS: " + AlunosDoInstituto.get(i).getStatus();

			if (st.equals(dadosDoAluno)) {

				if (AlunosDoInstituto.get(i).getStatus() == false) {

					AlunosDoInstituto.remove(i);
					break;
				} else {

					JOptionPane.showMessageDialog(null,
							"N�o � possivel remover o aluno, pois ele esta com um curso em andamento");
					break;
				}

			}

		}

	}

	/*
	 * Procura materia existete na base
	 * 
	 * @param codCurso
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void ProcuraMateriasCurso(String codCurso) {

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			CursosDoInstituto.get(i).getNomeCurso().equals(codCurso);

		}
	}

	/*
	 * Adiciona aluno na base
	 * 
	 * @param aluno
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean addAlunoBase(Aluno aluno) {

		if (cpfProfessores.contains(aluno.getCpf()) == true) {

			return false;
		} else {

			if (cpfAlunos.contains(aluno.getCpf()) == true) {

				return false;
			} else {

				AlunosDoInstituto.add(aluno);
				cpfAlunos.add(aluno.getCpf());
				return true;
			}

		}

	}
	/*
	 * Adiciona professor na base
	 * 
	 * @param professor
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public Boolean addProfessorBase(Professor professor) {

		Boolean testa = true;

		if (cpfAlunos.contains(professor.getCpf()) == true) {

			return false;
		} else {

			for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

				if (ProfessoresDoInstituto.get(i).getCpf().equals(professor.getCpf()) == true) {

					testa = false;
					break;
				}
			}

			if (testa == true) {

				ProfessoresDoInstituto.add(professor);
				cpfProfessores.add(professor.getCpf());
				codProfessores.add(professor.getCodProfessor());

				return true;
			} else {
				return false;
			}

		}
	}
	/*
	 * Adiciona curso na base
	 * 
	 * @param curso
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public Boolean addCursoBase(Curso curso) {

		Boolean testa = true;

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			if (CursosDoInstituto.get(i).getNomeCurso().equals(curso.getNomeCurso()) == true) {

				testa = false;
				break;

			}

		}

		if (testa == true) {

			CursosDoInstituto.add(curso);
			return true;
		} else {

			return false;
		}

	}

	/*
	 * Busca curso na base
	 * 
	 * @param nomecurso
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean buscarCursoBase(String nomecurso) {

		Boolean testa = false;

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			if (CursosDoInstituto.get(i).getNomeCurso().equals(nomecurso) == true) {

				testa = true;
				break;

			}

		}

		if (testa == true) {

			return true;

		} else {

			return false;
		}

	}

	/*
	 * Remove aluno da turma de uma disciplina na base
	 * 
	 * @param cpfAluno
	 * 
	 * @param identificadorCodigo
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean removeAlunoNaTurmaDaDisciplinaBASE(String cpfAluno, String identificadorCodigo) {

		String st = "";
		Boolean testa = false;

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			for (int j = 0; j < CursosDoInstituto.get(i).getMATERIAS().size(); j++) {

				st = CursosDoInstituto.get(i).getMATERIAS().get(j).getCodDisciplina() + " "
						+ CursosDoInstituto.get(i).getMATERIAS().get(j).getNomeDisciplina();

				if (st.equals(identificadorCodigo)) {

					for (int k = 0; k < CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().size(); k++) {

						for (int l = 0; l < CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().get(k)
								.getAlunosTurma().size(); l++) {

							if (CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().get(k).getAlunosTurma().get(l)
									.getCpf().equals(cpfAluno) == true) {

								CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().get(k).getAlunosTurma()
										.remove(l);

								CursosDoInstituto.get(i).getMATERIAS().get(j).getCodAlunosParticipantes()
										.remove(identificadorCodigo);
								testa = true;
								break;
							}

						}

					}

				}
			}
		}

		if (testa == true) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * Adiciona aluno em uma turma na base
	 * 
	 * @param nomeDisciplina
	 * 
	 * @param indexTurma
	 * 
	 * @param aluno
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean adiconarAlunoNaTurmaDaDisciplinaBASE(String nomeDisciplina, int indexTurma, Aluno aluno) {

		Boolean testa = false;
		String st = "";

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			for (int j = 0; j < CursosDoInstituto.get(i).getMATERIAS().size(); j++) {

				st = CursosDoInstituto.get(i).getMATERIAS().get(j).getCodDisciplina() + " "
						+ CursosDoInstituto.get(i).getMATERIAS().get(j).getNomeDisciplina();

				if (st.equals(nomeDisciplina)) {

					CursosDoInstituto.get(i).getMATERIAS().get(j).getTURMAS().get(indexTurma).addAluno(aluno);
					testa = true;
					break;
				}
			}
		}

		if (testa == true) {

			return true;
		} else {

			JOptionPane.showMessageDialog(null, "ERRO - Base - LINHA 172 - N�O ADICIONADO!");
			return false;
		}

	}

	/*
	 * Remove materia de um professor da base
	 * 
	 * @param codProfessor
	 * 
	 * @param codMateria
	 * 
	 * @param codDepartamentoResponsavel
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean removeMateriaDoProf(String codProfessor, String codMateria, String codDepartamentoResponsavel) {

		Boolean testa = false;

		for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

			if (ProfessoresDoInstituto.get(i).getCodProfessor().equals(codProfessor) == true) {

				ProfessoresDoInstituto.get(i).removeMateria(codMateria);

				for (int j = 0; j < DepartamentosDoInstituto.size(); j++) {

					if (DepartamentosDoInstituto.get(j).getCodigo().equals(codDepartamentoResponsavel) == true) {

						for (int k = 0; k < DepartamentosDoInstituto.get(j).getPROFESSORES().size(); k++) {

							if (DepartamentosDoInstituto.get(j).getPROFESSORES().get(k).getCodProfessor()
									.equals(ProfessoresDoInstituto.get(i).getCodProfessor()) == true) {

								DepartamentosDoInstituto.get(j).getPROFESSORES().get(k).removeMateria(codMateria);

								testa = true;
								break;
							}

						}

					}

				}

				break;
			}

		}

		if (testa == true) {

			return true;
		} else {
			return false;
		}

	}

	/*
	 * Remove um professor
	 * 
	 * @param codProf
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean removeProf(String codProf) {

		Boolean testa = false;

		for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

			String st = ProfessoresDoInstituto.get(i).getCodProfessor();

			if (st.equals(codProf) == true) {

				for (int j = 0; j < ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().size(); j++) {

					ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).setCodMinistrador("");
					ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).setStatusDisciplina(false);

				}

				cpfProfessores.remove(ProfessoresDoInstituto.get(i).getCpf());
				codProfessores.remove(codProf);

				testa = true;

				ProfessoresDoInstituto.remove(i);

				break;

			}
		}

		if (testa == true) {

			return true;
		} else {
			return false;
		}

	}
	/*
	 * Remove Curso
	 * 
	 * @param nomeCurso
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public Boolean removeCurso(String nomeCurso) {

		Boolean testa = false;

		for (int i = 0; i < CursosDoInstituto.size(); i++) {

			if (CursosDoInstituto.get(i).getNomeCurso().equals(nomeCurso)) {

				for (int j = 0; j < CursosDoInstituto.get(i).getALUNOS().size(); j++) {

					CursosDoInstituto.get(i).getALUNOS().get(j).setNomeCursoCursado("");
					CursosDoInstituto.get(i).getALUNOS().get(j).setStatus(false);
					CursosDoInstituto.get(i).getALUNOS().get(j).removeALLDisciplina();

				}

				for (int k = 0; k < CursosDoInstituto.get(i).getMATERIAS().size(); k++) {

					buscarMateriaProf(CursosDoInstituto.get(i).getMATERIAS().get(k).getCodMinistrador(),
							CursosDoInstituto.get(i).getMATERIAS().get(k).getCodDisciplina());

				}

				CursosDoInstituto.remove(i);
				testa = true;
				break;
			}
		}

		if (testa == true) {
			return true;
		} else {

			return false;
		}

	}

	/*
	 * Busca materia de um professor da base
	 * 
	 * @param codProfessor
	 * 
	 * @param codMateria
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void buscarMateriaProf(String codProfessor, String codMateria) {

		for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

			for (int j = 0; j < ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().size(); j++) {

				if (ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).getCodDisciplina()
						.equals(codMateria) == true) {

					if (ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).getCodMinistrador()
							.equals(codProfessor) == true) {

						for (int k = 0; k < ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(j).getTURMAS()
								.size(); k++) {

							ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().get(k).getTURMAS().remove(k);
						}

						ProfessoresDoInstituto.get(i).getMINISTRA().remove(codMateria);

						ProfessoresDoInstituto.get(i).getMATERIASMINISTRADAS().remove(j);

					}
				}
			}

		}

	}

	/*
	 * Muda a senha de um usuario na base
	 * 
	 * @param cpfMudador
	 * 
	 * @param senhaAtual
	 * 
	 * @param novaSenha
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean mudarSenha(String cpfMudador, String senhaAtual, String novaSenha) {

		Boolean testa = false;

		if (cpfAlunos.contains(cpfMudador) == true) {

			for (int i = 0; i < AlunosDoInstituto.size(); i++) {

				if (AlunosDoInstituto.get(i).getCpf().equals(cpfMudador) == true) {

					if (AlunosDoInstituto.get(i).getUSUARIO().getSenha().equals(senhaAtual) == true) {

						AlunosDoInstituto.get(i).getUSUARIO().setSenha(novaSenha);
						testa = true;
						break;
					}
				}
			}

		} else {

			for (int i = 0; i < ProfessoresDoInstituto.size(); i++) {

				if (ProfessoresDoInstituto.get(i).getCpf().equals(cpfMudador) == true) {

					if (ProfessoresDoInstituto.get(i).getUSUARIO().getSenha().equals(senhaAtual) == true) {

						ProfessoresDoInstituto.get(i).getUSUARIO().setSenha(novaSenha);
						testa = true;
						break;
					}
				}
			}

		}

		if (testa == true) {
			return true;

		} else {
			return false;
		}

	}

	public void addDepartamento(Departamento departamento) {

		DepartamentosDoInstituto.add(departamento);

	}

	public LinkedList<Aluno> getAlunosDoInstituto() {
		return AlunosDoInstituto;
	}

	public void setAlunosDoInstituto(LinkedList<Aluno> alunosDoInstituto) {
		AlunosDoInstituto = alunosDoInstituto;
	}

	public LinkedList<String> getCpfAlunos() {
		return cpfAlunos;
	}

	public void setCpfAlunos(LinkedList<String> cpfAlunos) {
		this.cpfAlunos = cpfAlunos;
	}

	public LinkedList<Curso> getCursosDoInstituto() {
		return CursosDoInstituto;
	}

	public void setCursosDoInstituto(LinkedList<Curso> cursosDoInstituto) {
		CursosDoInstituto = cursosDoInstituto;
	}

	public LinkedList<Professor> getProfessoresDoInstituto() {
		return ProfessoresDoInstituto;
	}

	public void setProfessoresDoInstituto(LinkedList<Professor> professoresDoInstituto) {
		ProfessoresDoInstituto = professoresDoInstituto;
	}

	public ArrayList<Departamento> getDepartamentosDoInstituto() {
		return DepartamentosDoInstituto;
	}

	public void setDepartamentosDoInstituto(ArrayList<Departamento> departamentosDoInstituto) {
		DepartamentosDoInstituto = departamentosDoInstituto;
	}

	public LinkedList<String> getCodProfessores() {
		return codProfessores;
	}

	public void setCodProfessores(LinkedList<String> codProfessores) {
		this.codProfessores = codProfessores;
	}

	public LinkedList<String> getCpfProfessores() {
		return cpfProfessores;
	}

	public void setCpfProfessores(LinkedList<String> cpfProfessores) {
		this.cpfProfessores = cpfProfessores;
	}

}
