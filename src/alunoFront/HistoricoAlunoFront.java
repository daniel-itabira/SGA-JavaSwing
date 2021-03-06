package alunoFront;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class HistoricoAlunoFront extends JFrame {
	
	/**
	 *  @author Daniel de Souza Rodrigues 18.2.8112
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> list;
	private JLabel label;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricoAlunoFront frame = new HistoricoAlunoFront();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HistoricoAlunoFront() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 269, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 234, 207);
		contentPane.add(scrollPane);

		list = new JList<String>();
		scrollPane.setViewportView(list);

		JButton btnVoltar = new JButton("Voltar <<");
		btnVoltar.setForeground(new Color(255, 0, 0));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblFaltas = new JLabel("Faltas:");
		lblFaltas.setBounds(10, 88, 46, 14);
		contentPane.add(lblFaltas);

		label = new JLabel("----");
		label.setBounds(66, 88, 46, 14);
		contentPane.add(label);

		JLabel lblHistrico = new JLabel("HIST\u00D3RICO ");
		lblHistrico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHistrico.setBounds(74, 54, 149, 23);
		contentPane.add(lblHistrico);
	}

	/*
	 * Imprime na interface grafica todas as notas
	 * 
	 * @param notas
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public void mostrarListaNotas(String[] notas) {

		DefaultListModel<String> ls = new DefaultListModel<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String st[] = notas;

		for (int i = 0; i < st.length; i++) {

			ls.addElement(st[i]);
		}

		list.setModel(ls);

	}
	/*
	 * Imprime todas as faltas
	 * 
	 * @param faltas
	 * 
	 * @author Daniel de Souza Rodrigues 18.2.8112
	 */

	public void mostrarFaltas(String faltas) {

		getLabel().setText(faltas);

	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
}
