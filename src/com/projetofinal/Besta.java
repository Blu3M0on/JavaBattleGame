package com.projetofinal;

public class Besta extends Personagem {
	
	private int potenciaAtaque;
	public Besta(String nome, int pontosVida, int armadura, String tipo) {
		super(nome, pontosVida, armadura, tipo);
	}
	
	
	public int lancarDado(){
		potenciaAtaque = (int) (Math.random()*101.0);
		return this.potenciaAtaque;
	}
	
	
	public int getPotenciaAtaque() {
		return this.potenciaAtaque;
	}
	
	public void setPotenciaAtaque(int potenciaAtaque) {
		this.potenciaAtaque = potenciaAtaque;
	}
	
	
	
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getTipo() + "(" + this.getPontosVida()+ ", " + this.getArmadura() +")";
		
	}
}
