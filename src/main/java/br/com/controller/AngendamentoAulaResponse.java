package br.com.controller;

import java.sql.Timestamp;

public class AngendamentoAulaResponse {
    private int matriculaAluno;
    private String nomeAluno;
    private String aula;
    private Timestamp diaHorarioAgendado;


    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Timestamp getDiaHorarioAgendado() {
        return diaHorarioAgendado;
    }

    public void setDiaHorarioAgendado(Timestamp diaHorarioAgendado) {
        this.diaHorarioAgendado = diaHorarioAgendado;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    private String nomeInstrutor;

    public String toString() {
        return "Aluno: " +
                "matriculaAluno: " + matriculaAluno + "\n" +
                "nomeAluno: '" + nomeAluno + '\'' + "\n" +
                "aula: '" + aula + '\'' + "\n" +
                "diaHorarioAgendado: " + diaHorarioAgendado + "\n";
    }


}
