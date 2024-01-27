package com.projetofinal;

public abstract class Personagem {
	
	//atributos de todas as personagens
	protected String nome;
	protected int pontosVida;
	protected int armadura;
	protected String tipo;
	
	
	
	
	
	
	public Personagem(String nome, int pontosVida, int armadura, String tipo) {
		this.nome = nome;
		this.pontosVida = pontosVida;
		this.armadura = armadura;
		this.tipo = tipo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPontosVida() {
		return this.pontosVida;
	}
	
	public void setPontosVida(int pontosVida) {
		this.pontosVida = pontosVida;
	}
	
	public int getArmadura() {
		return this.armadura;
	}
	
	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}
	
	
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
