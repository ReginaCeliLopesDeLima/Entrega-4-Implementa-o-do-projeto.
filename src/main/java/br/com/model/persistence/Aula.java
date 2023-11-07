package br.com.model.persistence;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aula {

    private int idAula;
    private String nomeAula;
    private Timestamp diaHorarioAula;
    private int matriculaInstrutor;

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public Timestamp getDiaHorarioAula() {
        return diaHorarioAula;
    }

    public void setDiaHorarioAula(Timestamp diaHorarioAula) {
        this.diaHorarioAula = diaHorarioAula;
    }

    public int getMatriculaInstrutor() {
        return matriculaInstrutor;
    }

    public void setMatriculaInstrutor(int matriculaInstrutor) {
        this.matriculaInstrutor = matriculaInstrutor;
    }

    @Override
    public String toString() {
        return "Aulas: " + "\n" +
                "idAula: " + idAula + "\n" +
                "nomeAula: " + nomeAula + "\n" +
                "diaHorarioAula: '" + diaHorarioAula + '\'' + "\n" +
                "matriculaInstrutor: " + matriculaInstrutor;
    }
}
