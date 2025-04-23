package br.dev.guilherme.tabuada.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.dev.guilherme.tabuada.model.Tabuada;

public class TelaTabuada {

	private JLabel labelMultiplicando;
	private JLabel labelMinMultiplicador;
	private JLabel labelmaxMultiplicador;
	private JTextField textMultiplicando;
	private JTextField textMinMultiplicador;
	private JTextField textMaxMultiplicador;
	private JButton buttonCalcular;
	private JButton buttonLimpar;
	private JList listTabuada;
	private JScrollPane scrollTabuada;
	private String tituloDaTela;

	public void criarTela(String tituloDaTela) {
		this.tituloDaTela = tituloDaTela;
		JFrame tela = new JFrame();
		tela.setTitle(this.tituloDaTela);
		tela.setSize(265, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null); // quando nos mesmos que vamos selecionar onde os objetos estão temos que
								// colocar o set,Layout nulo

		// Obtendo a referência do painel de conteúdo da tela
		Container container = tela.getContentPane();

		// criar o label Multiplicando
		labelMultiplicando = new JLabel();
		labelMultiplicando.setText("Multiplicando:");
		labelMultiplicando.setBounds(20, 20, 150, 30); // selecionando onde vai estar pelo plano carteziano
		
		// Criar o textField multiplicando
		textMultiplicando = new JTextField();
		textMultiplicando.setBounds(180, 20, 50, 30);
		
		// Criar o label MinMultiplicador
		labelMinMultiplicador = new JLabel();
		labelMinMultiplicador.setText("Mínimo multiplicador: ");
		labelMinMultiplicador.setBounds(20, 60, 150, 30);
		
		textMinMultiplicador = new JTextField();
		textMinMultiplicador.setBounds(180, 60, 50, 30);
		
		// Criar o label MaxMultiplicador
		labelmaxMultiplicador = new JLabel();
		labelmaxMultiplicador.setText("Maximo multiplicador: ");
		labelmaxMultiplicador.setBounds(20, 100, 150, 30);
		
		textMaxMultiplicador = new JTextField();
		textMaxMultiplicador.setBounds(180, 100, 50, 30);
		
		// Criar o botão
		buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular");
		buttonCalcular.setBounds(20, 140, 100, 30);
		
		buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setBounds(130, 140, 100, 30);
		
		// Criar o JList na tela
		listTabuada = new JList();
		
		// Criar o ScrollPane
		scrollTabuada = new JScrollPane(listTabuada);
		scrollTabuada.setBounds(20, 190, 210, 350);

		// Adicionando os componentes no painel de conteúdo do JFrame
		container.add(labelMultiplicando);
		container.add(textMultiplicando);
		container.add(labelMinMultiplicador);
		container.add(textMinMultiplicador);
		container.add(labelmaxMultiplicador);
		container.add(textMaxMultiplicador);
		container.add(buttonCalcular);
		container.add(buttonLimpar);
		container.add(scrollTabuada);
		
		// Adicionar ouvintes de ação aos botões
		buttonCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String multiplicando = textMultiplicando.getText();
				String min = textMinMultiplicador.getText();
				String max = textMaxMultiplicador.getText();
				
				// Convertendo valores de string para double
				double multiplicandoDouble = Double.parseDouble(multiplicando);
				double minDouble = Double.parseDouble(min);
				double maxDouble = Double.parseDouble(max);
				
				
				Tabuada tabuada = new Tabuada();
				tabuada.setMultiplicando(multiplicandoDouble);
				tabuada.setMinimoMultiplicador(minDouble);
				tabuada.setMaximoMultiplicador(maxDouble);
				
				String[] tabuadaResult = tabuada.mostrarTabuada();
				
				listTabuada.setListData(tabuadaResult);
				
			}
		});
		
		// para esse botão de limpar funcionar é só colocar para inserir um texto vazio quando for apertado
		buttonLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textMultiplicando.setText(null); // pode usar o null ou o "" para representar o vazio/nada
				textMinMultiplicador.setText("");
				textMaxMultiplicador.setText("");
			    listTabuada.setListData(new String[0]); //é possivel apagar os resultados da tabuada passando um vetor vazio
				textMultiplicando.requestFocus();
			}
		});

		// tornar a tela visivel "DEVE!" ser a última instrução
		tela.setVisible(true);

	}

	private void exibirTabuada() {

	}

	private void limparTabuada() {

	}

}
