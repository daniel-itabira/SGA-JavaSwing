package professorFront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academicoBack.Disciplina;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;

public class SCAProf extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> list;
	private JComboBox<String> comboBox;
	private JLabel labelCodDisciplina;
	private JLabel labelcodMinistrador;
	private JLabel labelDisciplina;
	private Disciplina materiaMinistrada;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCAProf frame = new SCAProf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SCAProf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 535);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 205, 285, 262);
		contentPane.add(scrollPane);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		JLabel lblAlunos = new JLabel("Alunos");
		lblAlunos.setBounds(131, 180, 48, 14);
		contentPane.add(lblAlunos);

		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setBounds(115, 11, 74, 14);
		contentPane.add(lblDisciplina);

		labelDisciplina = new JLabel("----");
		labelDisciplina.setBounds(195, 11, 48, 14);
		contentPane.add(labelDisciplina);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 43, 48, 14);
		contentPane.add(lblCodigo);

		JLabel lblNome = new JLabel("Nome Professor:");
		lblNome.setBounds(10, 68, 94, 14);
		contentPane.add(lblNome);

		labelCodDisciplina = new JLabel("----");
		labelCodDisciplina.setBounds(56, 43, 48, 14);
		contentPane.add(labelCodDisciplina);

		labelcodMinistrador = new JLabel("----");
		labelcodMinistrador.setBounds(118, 68, 48, 14);
		contentPane.add(labelcodMinistrador);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		btnVoltar.setBounds(10, 7, 89, 23);
		contentPane.add(btnVoltar);

		comboBox = new JComboBox<String>();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBounds(10, 133, 186, 23);
		contentPane.add(comboBox);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBox.getSelectedIndex() >= 0) {
						
					mostrarLista(comboBox.getSelectedIndex());
				}

			}
		});
		btnSelecionar.setBackground(new Color(255, 255, 255));
		btnSelecionar.setBounds(206, 133, 89, 23);
		contentPane.add(btnSelecionar);

		JLabel lblTurmas = new JLabel("Turmas");
		lblTurmas.setBounds(73, 108, 48, 14);
		contentPane.add(lblTurmas);

	}

	public Disciplina getMateriaMinistrada() {
		return materiaMinistrada;
	}

	public void imprimeturmasMateria() {

		if (materiaMinistrada.imprimeTURMA().length >= 0) {

			String[] st = materiaMinistrada.imprimeTURMA();

			for (int i = 0; i < materiaMinistrada.imprimeTURMA().length; i++) {

				comboBox.addItem(st[i]);

			}

		}

	}
	
	public void mostrarLista(int index) {

		if (materiaMinistrada.getTURMAS().size() >= 0) {

			ListModel<String> ls = new DefaultListModel<String>();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			String[] st = materiaMinistrada.getTURMAS().get(index).imprimeAlunosTurma();

			for (int i = 0; i < st.length; i++) {

				((DefaultListModel<String>) ls).addElement(st[i]);
			}

			list.setModel(ls);

		}
	}

	public void setMateriaMinistrada(Disciplina materiaMinistrada) {
		this.materiaMinistrada = materiaMinistrada;
		this.labelCodDisciplina.setText(materiaMinistrada.getCodDisciplina());
		this.labelDisciplina.setText(materiaMinistrada.getNomeDisciplina());
		this.labelcodMinistrador.setText(materiaMinistrada.getCodMinistrador());
		imprimeturmasMateria();
	}

}
