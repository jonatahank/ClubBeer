package PessoaJuritica;

import Cadastro.Cadastro;


public class PessoaJuridica extends Cadastro{
    private String cnpj;
    private String nomeFantasia;
    private int id;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String toString(){
		return this.getNome();
	}
}
