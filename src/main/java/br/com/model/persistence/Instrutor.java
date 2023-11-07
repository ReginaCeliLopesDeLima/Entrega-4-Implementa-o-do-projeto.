package br.com.model.persistence;

public class Instrutor {
    private int matriculaInstrutor;
    private String nomeInstrutor;

    public int getMatriculaInstrutor() {
        return matriculaInstrutor;
    }

    public void setMatriculaInstrutor(int matriculaInstrutor) {
        this.matriculaInstrutor = matriculaInstrutor;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    @Override
    public String toString() {
        return "Instrutor: " + "\n" +
                "matricula: " + matriculaInstrutor + "\n" +
                "nome: '" + nomeInstrutor + '\'';
    }
}
