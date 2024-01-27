package com.projetofinal;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		batalhaFinalForm form = new batalhaFinalForm();
		form.setVisible(true);
		List<Heroi> herois = new ArrayList<>();
		List<Besta> bestas = new ArrayList<>();
		
		//adicionar todas as personagens "herois" ao array list
		Elfo legolas = new Elfo("Legolas", 150, 30, "Elfo");
		Humano aragorn = new Humano("Aragorn", 150, 50, "Humano");
		Hobbit frodo = new Hobbit("Frodo", 20, 10, "Hobbit");
		Humano gandalf = new Humano("Gandalf", 300, 30, "Humano");
		Elfo pippins = new Elfo("Pippins", 100, 40, "Elfo");
		herois.add(legolas);
		herois.add(aragorn);
		herois.add(frodo);
		herois.add(gandalf);
		herois.add(pippins);
		
		//adicionar todas as personagens "bestas" ao array list
		Orque lurtz = new Orque("Lurtz", 200, 60, "Orque");
		Troll ugluk = new Troll("Uglúk", 120, 30, "Troll");
		Orque shagrat = new Orque("Shagrat", 220, 50, "Orque");
		Troll mauhur = new Troll("Mauhúr", 100, 30, "Troll");
		bestas.add(lurtz);
		bestas.add(ugluk);
		bestas.add(shagrat);
		bestas.add(mauhur);
		
		Luta.fight(herois, bestas);
	}
}