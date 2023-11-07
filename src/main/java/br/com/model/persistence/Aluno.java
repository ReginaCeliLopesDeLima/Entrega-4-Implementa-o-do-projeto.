package br.com.model.persistence;

public class Aluno {
    private int matricula;
    private String cpf;
    private String nome;
    private int idade;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Aluno: " +
                "matricula: " + matricula + "\n" +
                "cpf: '" + cpf + '\'' + "\n" +
                "nome: '" + nome + '\'' + "\n" +
                "idade: " + idade + "\n";
    }
}
