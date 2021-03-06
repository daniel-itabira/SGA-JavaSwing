package academicoBack;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import membros.Professor;
import systemBack.Base;

public class Departamento {
	
	/**
	 *  @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private String nome;
	private String codigo;
	private Base BASE;
	public ArrayList<Curso> CURSOS;
	public LinkedList<Professor> PROFESSORES;

	/*
	 * Armazena todos os cursos do departamento em um Array
	 * 
	 * @return String[]
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public String[] imprimeCursos() {
		String[] st = new String[CURSOS.size()];

		for (int i = 0; i < st.length; i++) {

			st[i] = CURSOS.get(i).getNomeCurso();
		}

		return st;
	}

	/*
	 * Armazena todos os professores do departamento em um Array
	 * 
	 * @return String[]
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public String[] imprimeProfessores() {
		String[] st = new String[PROFESSORES.size()];

		for (int i = 0; i < st.length; i++) {

			st[i] = PROFESSORES.get(i).getCodProfessor() + "    " + PROFESSORES.get(i).getNome();
		}

		return st;
	}
	/*
	 * Adiciona um curso ao departamento
	 * 
	 * @param nome
	 * 
	 * @param codDPresponsavel
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 * 
	 */

	public boolean addCurso(String nome, String codDPresponsavel) {

		Boolean testa = true;

		for (int i = 0; i < CURSOS.size(); i++) {
			if (CURSOS.get(i).getNomeCurso().equals(nome)) {
				testa = false;
				break;
			}
		}

		if (testa == true) {
			Curso crs = new Curso(nome);
			crs.setCodDepartamentoResponsavel(codDPresponsavel);
			CURSOS.add(crs);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Remove um Curso do Departamento baseado no nome
	 * 
	 * @param nome
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public boolean removeCurso(String nome) {
		Boolean testa = false;

		for (int i = 0; i < CURSOS.size(); i++) {
			if (CURSOS.get(i).getNomeCurso().equals(nome)) {

				BASE.removeCurso(nome);
				CURSOS.remove(i);
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
	 * Adiciona professor ao departamento
	 * 
	 * @param nome
	 * 
	 * @param cpf
	 * 
	 * @param sexo
	 * 
	 * @param endereco
	 * 
	 * @param codProf
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public boolean addProfessor(String nome, String cpf, String sexo, String endereco, String codProf,
			String codDepartamento) {

		Boolean testa = true;

		for (int i = 0; i < PROFESSORES.size(); i++) {
			if (PROFESSORES.get(i).getCpf().equals(cpf) == true) {

				testa = false;
				break;
			}
		}

		if (testa == true) {
			Professor prof = new Professor(nome, cpf, sexo, endereco, codProf, codDepartamento);
			PROFESSORES.add(prof);

			return true;
		} else {
			return false;
		}

	}
	/*
	 * Remove professor do departamento baseado e um codProf
	 * 
	 * @param codProf
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public boolean removeProfessor(String codProf) {

		Boolean testa = false;

		JOptionPane.showMessageDialog(null, codProf);
		for (int i = 0; i < PROFESSORES.size(); i++) {

			if (PROFESSORES.get(i).getCodProfessor().equals(codProf) == true) {

				if (getBASE().removeProf(codProf) == true) {

					JOptionPane.showMessageDialog(null, "REMOVIDO DA BASE");

				} else {
					JOptionPane.showMessageDialog(null, "FALHA REMOVIDO DA BASE");
				}

				PROFESSORES.remove(i);

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
	 * Busca um professor baseado no index
	 * 
	 * @param index
	 * 
	 * @return Professor
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public Professor getProfIndex(int index) {

		if (PROFESSORES.size() >= index) {

			return PROFESSORES.get(index);
		} else {

			return null;
		}

	}

	public Departamento(String nome, String codigo) {

		this.CURSOS = new ArrayList<Curso>();
		this.PROFESSORES = new LinkedList<Professor>();
		this.nome = nome;
		this.codigo = codigo;
		this.BASE = new Base();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LinkedList<Professor> getPROFESSORES() {
		return PROFESSORES;
	}

	public void setPROFESSORES(LinkedList<Professor> pROFESSORES) {
		PROFESSORES = pROFESSORES;
	}

	public ArrayList<Curso> getCURSOS() {
		return CURSOS;
	}

	public void setCURSOS(ArrayList<Curso> cURSOS) {
		CURSOS = cURSOS;
	}

	public Base getBASE() {
		return BASE;
	}

	public void setBASE(Base bASE) {
		BASE = bASE;
	}
}
