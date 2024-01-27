package com.projetofinal;

import javax.swing.*;
import java.util.List;

public class Luta {
	
	public static void fight (List<Heroi> herois, List<Besta> bestas){
		
		
		int turno = 1;
		
		while (true) {
			System.out.println("Turno " + turno + ":");
			
			for (int i = 0; i < herois.size() && i < bestas.size(); i++) {
				Heroi heroi = herois.get(i);
				Besta besta = bestas.get(i);
				int valorDadosHeroi = heroi.lancarDados();
				int valorDadosBesta = besta.lancarDado();
				System.out.println("Luta entre " + heroi.getNome() + " (Vida=" + heroi.getPontosVida() +
						" Armadura=" + heroi.getArmadura() + ") e " +
						besta.getNome() + " (Vida=" + besta.getPontosVida() +
						" Armadura=" + besta.getArmadura() + ")");
				
				
				//Casos especiais, Hobbit vs Troll, hobbit perde 5 de ataque.
				if (heroi.getTipo().equals("Hobbit") && besta.getTipo().equals("Troll")) {
					heroi.setPotenciaAtaque(heroi.getPotenciaAtaque() - 5);
				}
				// Elfo vs Orque, elfo ganha 10 de ataque
				if (heroi.getTipo().equals("Elfo") && besta.getTipo().equalsIgnoreCase("Orque")) {
					heroi.setPotenciaAtaque(heroi.getPotenciaAtaque() -10);
				}
				
				//Orque tira 10% da armadura do adversario
				if (besta.getTipo().equals("Orque")) {
					double reducaoArmadura = heroi.getArmadura() * 0.1;
					heroi.setArmadura((int) (heroi.getArmadura() - reducaoArmadura));
					if (heroi.getArmadura() < 0) {
						heroi.setArmadura(0);
					}
				}
				
				
				System.out.println(heroi.getNome() + " saca " + valorDadosHeroi +
						" e tira " + heroi.getPotenciaAtaque() + " de vida a " + besta.getNome());
				
				System.out.println(besta.getNome() + " saca " + valorDadosBesta +
						" e tira " + besta.getPotenciaAtaque() + " de vida a " + heroi.getNome());
				
						
				if (besta.getArmadura() > 0) {
					//se tiver armadura, tira primeiro à armadura.
					// Se a armadura chegar a 0, tira o resto aos pontos de vida
					int potenciaAtaqueRestante = heroi.getPotenciaAtaque() - besta.getArmadura();
					besta.setArmadura(besta.getArmadura() - heroi.getPotenciaAtaque());
					if (besta.getArmadura() <= 0 ){
						besta.setArmadura(0);
						besta.setPontosVida(besta.getPontosVida() - potenciaAtaqueRestante);
						
						//se tirar totalmente a armadura e os pontos de vida
						// , a personagem morre, sai a lista e o turno encerra;
						if (besta.getPontosVida() <= 0){
							System.out.println("Morre o(a) " + besta.getNome() + "!");
							bestas.remove(i);
							break;
						}
					}
					//se a armadura ja iniciar a 0, tira tudo do potencial de ataque
					// aos pontos de vida
				} else if (besta.getArmadura() <= 0) {
					besta.setArmadura(0);
					besta.setPontosVida(besta.getPontosVida() - heroi.getPotenciaAtaque());
					
					//se os pontos de vida chegarem a 0, a personagem morre, sai da lista
					// e passa para o proximo turno
					if (besta.getPontosVida() <= 0) {
						System.out.println("Morre o(a) " + besta.getNome() + "!");
						bestas.remove(i);
						break;
					}
				}
				
				if (heroi.getArmadura() > 0) {
					//se tiver armadura, tira primeiro à armadura.
					// Se a armadura chegar a 0, tira o resto aos pontos de vida
					int potenciaAtaqueRestante = besta.getPotenciaAtaque() - heroi.getArmadura();
					heroi.setArmadura(heroi.getArmadura()-besta.getPotenciaAtaque());
					if( heroi.getArmadura() <= 0){
						heroi.setArmadura(0);
						heroi.setPontosVida(heroi.getPontosVida() - potenciaAtaqueRestante);
						//se tirar totalmente a armadura e os pontos de vida
						// , a personagem morre, sai a lista e o turno encerra;
						if(heroi.getPontosVida() <= 0){
							System.out.println("Morre o(a) " + heroi.getNome() + "!");
							herois.remove(i);
							break;
						}
						
					}
					//se a armadura ja iniciar a 0, tira tudo aos pontos de vida
				} else if (heroi.getArmadura() <= 0) {
					heroi.setArmadura(0);
					heroi.setPontosVida(heroi.getPontosVida() - besta.getPotenciaAtaque());
					//se os pontos de vida chegarem a 0, a personagem morre, sai da lista
					// e passa para o proximo turno
					if (heroi.getPontosVida() <= 0) {
						System.out.println("Morre o(a) " + heroi.getNome() + "!");
						herois.remove(i);
						break;
					}
				}
			}
			
			//se uma lista estiver vazia, ganha o adversário
			if (bestas.isEmpty()) {
				System.out.println("VITÓRIA DOS HERÓIS!!");
				break;
				
			} else if (herois.isEmpty()) {
				System.out.println("VITÓRIA DAS BESTAS!!");
				break;
			}
			//turno encerrado se alguem morrer ou se percorrer alguma lista na totalidade
			turno++;
		}
	}


	
	public static void fight (List<Heroi> herois, List<Besta> bestas, JTextArea infoTextArea) {
		
		
		
		int turno = 1;
		
		while (true) {
			infoTextArea.append("\nTurno " + turno + ": \n\n");
			boolean turnoEncerrado = false;
			
			
			for (int i = 0; i < herois.size() && i < bestas.size(); i++) {
				Heroi heroi = herois.get(i);
				Besta besta = bestas.get(i);
				int valorDadosHeroi = heroi.lancarDados();
				int valorDadosBesta = besta.lancarDado();
				infoTextArea.append("Luta entre " + heroi.getNome() + " (Vida=" + heroi.getPontosVida() +
						" Armadura=" + heroi.getArmadura() + ") e " +
						besta.getNome() + " (Vida=" + besta.getPontosVida() +
						" Armadura=" + besta.getArmadura() + ")\n");
				
				
				//Casos especiais, Hobbit vs Troll, hobbit perde 5 de ataque.
				if (heroi.getTipo().equals("Hobbit") && besta.getTipo().equals("Troll")) {
					heroi.setPotenciaAtaque(heroi.getPotenciaAtaque() - 5);
				}
				// Elfo vs Orque, elfo ganha 10 de ataque
				if (heroi.getTipo().equals("Elfo") && besta.getTipo().equalsIgnoreCase("Orque")) {
					heroi.setPotenciaAtaque(heroi.getPotenciaAtaque() -10);
				}
				//Orque tira 10% da armadura do adversario
				if (besta.getTipo().equals("Orque")) {
					double reducaoArmadura = heroi.getArmadura() * 0.1;
					heroi.setArmadura((int) (heroi.getArmadura() - reducaoArmadura));
					if (heroi.getArmadura() < 0) {
						heroi.setArmadura(0);
					}
				}
				
				
				infoTextArea.append(heroi.getNome() + " saca " + valorDadosHeroi +
						" e tira " + heroi.getPotenciaAtaque() + " de vida a " + besta.getNome() + "\n");
				
				infoTextArea.append(besta.getNome() + " saca " + valorDadosBesta +
						" e tira " + besta.getPotenciaAtaque() + " de vida a " + heroi.getNome() +"\n");
				
				
				
				if (besta.getArmadura() > 0) {
					//se tiver armadura, tira primeiro à armadura.
					// Se a armadura chegar a 0, tira o resto aos pontos de vida
					int potenciaAtaqueRestante = heroi.getPotenciaAtaque() - besta.getArmadura();
					besta.setArmadura(besta.getArmadura() - heroi.getPotenciaAtaque());
					if (besta.getArmadura() <= 0 ){
						besta.setArmadura(0);
						besta.setPontosVida(besta.getPontosVida() - potenciaAtaqueRestante);
						//se tirar totalmente a armadura e os pontos de vida
						// , a personagem morre, sai a lista e o turno encerra;
						if (besta.getPontosVida() <= 0){
							infoTextArea.append("Morre o(a) " + besta.getNome() + "!\n");
							bestas.remove(i);
							break;
						}
					}
					//se a armadura ja iniciar a 0, tira tudo do potencial de ataque
					// aos pontos de vida
				} else if (besta.getArmadura() <= 0) {
					besta.setArmadura(0);
					besta.setPontosVida(besta.getPontosVida() - heroi.getPotenciaAtaque());
					//se os pontos de vida chegarem a 0, a personagem morre, sai da lista
					// e passa para o proximo turno
					if (besta.getPontosVida() <= 0) {
						infoTextArea.append("Morre o(a) " + besta.getNome() + "!\n");
						bestas.remove(i);
						break;
					}
				}
				
				
				if (heroi.getArmadura() > 0) {
					//se tiver armadura, tira primeiro à armadura.
					// Se a armadura chegar a 0, tira o resto aos pontos de vida
					int potenciaAtaqueRestante = besta.getPotenciaAtaque() - heroi.getArmadura();
					heroi.setArmadura(heroi.getArmadura()-besta.getPotenciaAtaque());
					if( heroi.getArmadura() <= 0){
						heroi.setArmadura(0);
						heroi.setPontosVida(heroi.getPontosVida() - potenciaAtaqueRestante);
						//se tirar totalmente a armadura e os pontos de vida
						// , a personagem morre, sai a lista e o turno encerra;
						if (heroi.getPontosVida() <= 0){
							infoTextArea.append("Morre o(a) " + heroi.getNome() + "!\n");
							herois.remove(i);
							break;
						}
						
					}
					
					//se a armadura ja iniciar a 0, tira tudo aos pontos de vida
					
				} else if (heroi.getArmadura() <= 0) {
					heroi.setArmadura(0);
					heroi.setPontosVida(heroi.getPontosVida() - besta.getPotenciaAtaque());
					//se os pontos de vida chegarem a 0, a personagem morre, sai da lista
					// e passa para o proximo turno
					if (heroi.getPontosVida() <= 0) {
						infoTextArea.append("Morre o(a) " + heroi.getNome() + "!\n");
						herois.remove(i);
						break;
					}
				}
			}
			
			//se uma lista estiver vazia, ganha o adversário
			if (bestas.isEmpty()) {
				infoTextArea.append("\nVITÓRIA DOS HERÓIS!!\n");
				break;
				
			} else if (herois.isEmpty()) {
				infoTextArea.append("\nVITÓRIA DAS BESTAS!!\n");
				break;
			}
			//turno encerrado se alguem morrer ou se percorrer alguma lista na totalidade
			turno++;
		}
	}
}
