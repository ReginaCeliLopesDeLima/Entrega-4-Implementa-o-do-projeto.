package br.com.model.persistence;

import java.sql.Timestamp;
import java.util.Date;

public class AgendamentoAula {
    private int idAgendamento;

    private Timestamp diaHorarioAgendado;

    private int idAula;

    private int matriculaAluno;

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Timestamp getDiaHorarioAgendado() {
        return diaHorarioAgendado;
    }

    public void setDiaHorarioAgendado(Timestamp diaHorarioAgendado) {
        this.diaHorarioAgendado = diaHorarioAgendado;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    @Override
    public String toString() {
        return "Agendamento aula " + "\n" +
                "Dia horario agendado: " + diaHorarioAgendado;
    }
}
