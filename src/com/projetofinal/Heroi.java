package com.projetofinal;

public class Heroi extends Personagem{
	
	//valores dos dados entre 0 a 100
	private int valorDado1 =(int)(Math.random()*101.0);
	private int valorDado2 =(int)(Math.random()*101.0);
	
	private int potenciaAtaque;
	
	 public Heroi(String nome, int pontosVida, int armadura, String tipo) {
		
		super(nome, pontosVida, armadura, tipo);
	}
	
	
	
	public int lancarDados(){
		
		this.potenciaAtaque = Math.max(this.valorDado1, this.valorDado2);
		return this.potenciaAtaque;
	}
	
	public int getValorDado1() {
		return this.valorDado1;
	}
	
	public void setValorDado1(int valorDado1) {
		this.valorDado1 = valorDado1;
	}
	
	public int getValorDado2() {
		return this.valorDado2;
	}
	
	public void setValorDado2(int valorDado2) {
		this.valorDado2 = valorDado2;
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


