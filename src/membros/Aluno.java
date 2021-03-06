package membros;

import java.util.ArrayList;

import academicoBack.HistoricoAluno;
import systemBack.Usuario;

public class Aluno extends Pessoa {
	
	/**
	 *  @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private int matricula;
	private Usuario USUARIO;
	private Boolean status;
	private String nomeCursoCursado;
	private ArrayList<String> CURSANDO;
	private ArrayList<HistoricoAluno> NOTAS;

	public Aluno(String nome, String cpf, String sexo, String endereco) {
		super(nome, cpf, sexo, endereco);
		this.CURSANDO = new ArrayList<String>();
		this.NOTAS = new ArrayList<HistoricoAluno>();
		this.nomeCursoCursado = "";
		this.USUARIO = new Usuario(getCpf(), "123");
		this.status = true;
	}
	/*
	 * Adiciona disciplina ao aluno
	 * 
	 * @param codigo
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public Boolean addDisciplina(String codigo) {

		if (CURSANDO.contains(codigo) == true) {
			return false;
		} else {

			CURSANDO.add(codigo);
			HistoricoAluno x = new HistoricoAluno(codigo);
			x.setCodDisciplina(codigo);
			NOTAS.add(x);
			return true;
		}
	}

	/*
	 * Remove disciplina do Aluno
	 * 
	 * @param codigo
	 * 
	 * @return boolean
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public Boolean removeDisciplina(String codigo) {

		if (CURSANDO.contains(codigo)) {

			CURSANDO.remove(codigo);
			for (int i = 0; i > NOTAS.size(); i++) {
				if (NOTAS.get(i).getCodDisciplina() == codigo) {
					NOTAS.remove(i);
					break;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Remove todas as disciplinas do aluno
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */
	public void removeALLDisciplina() {

		for (int i = 0; i < CURSANDO.size(); i++) {

			CURSANDO.remove(i);
			NOTAS.remove(i);
		}
	}
	/*
	 * Armazena todas as disciplinas do aluno a um Array
	 * 
	 * @return String[]
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public String[] imprimeCursando() {

		String[] st = new String[CURSANDO.size()];

		for (int i = 0; i < st.length; i++) {

			st[i] = CURSANDO.get(i);
		}

		return st;

	}

	public ArrayList<HistoricoAluno> getNOTAS() {
		return NOTAS;
	}

	public void setNOTAS(ArrayList<HistoricoAluno> nOTAS) {
		NOTAS = nOTAS;
	}

	public void setCURSANDO(ArrayList<String> cURSANDO) {
		CURSANDO = cURSANDO;
	}

	public ArrayList<String> getCURSANDO() {
		return CURSANDO;
	}

	public String getNomeCursoCursado() {
		return nomeCursoCursado;
	}

	public void setNomeCursoCursado(String nomeCursoCursado) {
		this.nomeCursoCursado = nomeCursoCursado;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Usuario getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(Usuario uSUARIO) {
		USUARIO = uSUARIO;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
