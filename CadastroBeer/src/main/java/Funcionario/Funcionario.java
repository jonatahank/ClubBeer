package Funcionario;

import PessoaFisica.PessoaFisica;


public class Funcionario extends PessoaFisica {
    private String funcao;
    private String salario;
    private String estadoCivil;
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String toString(){
		return this.getNome();
	}
}
