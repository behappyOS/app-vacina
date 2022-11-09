package br.com.vacina.model;

public class Vacinas {
		
	private int idVacinas;
	private String nome_posto;
	private String telefone;
	private String bairro;
	private int numero;
	private String cep;
	private String complemento;
	private String rua;	
	private Double latitude, longitude;
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public void setIdVacinas(int idVacinas) {
		this.idVacinas = idVacinas;
	}
	public String getNome_posto() {
		return nome_posto;
	}
	public void setNome_posto(String nome_posto) {
		this.nome_posto = nome_posto;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getIdVacinas() {
		return idVacinas;
	}		
}
