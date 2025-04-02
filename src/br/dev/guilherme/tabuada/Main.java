package br.dev.guilherme.tabuada;

import br.dev.guilherme.tabuada.model.Tabuada;

public class Main {

	public static void main(String[] args) {
		
		Tabuada tabuada = new Tabuada();
		tabuada.setMultiplicando(8);
		tabuada.setMinimoMultiplicador(14);
		tabuada.setMaximoMultiplicador(20);
		tabuada.mostrarTabuada();
		
		
		Tabuada tabuada2 = new Tabuada();
		tabuada2.setMultiplicando(457);
		tabuada2.setMinimoMultiplicador(47);
		tabuada2.setMaximoMultiplicador(23);
		tabuada2.mostrarTabuada();
		
		System.out.println(tabuada2.getMultiplicando());
		double mult1 = tabuada2.getMultiplicando();
		
		if (mult1 % 2 == 0) {
			System.out.println("O multiplicando " + mult1 + "é PAR!");
		} else {
			System.out.println("O multiplicando " + mult1 + "é ÍMPAR!");
		}

	}

}
