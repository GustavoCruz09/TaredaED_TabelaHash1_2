package model;

public class morador {
	
	public int numap;
	public String nome;
	public String modelo;
	public String cor;
	public String placa;
	
	public int getNumap() {
		return numap;
	}
	public void setNumap(int numap) {
		this.numap = numap;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		return "Morador " + nome + " do apartamento " + numap + " do carro " + modelo + " (" + cor + ") da placa " + placa + "\n";
	}
	
	

}
