package br.com.model.persistence.dao;

import br.com.controller.AngendamentoAulaResponse;
import br.com.model.persistence.*;
import br.com.view.EntradaDados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgendamentoAulaDAO {

    public static void agendarAula(int idAula, int matriculaAluno) throws SQLException {

        try {
            Aula aula = AulaDAO.lerDadosAula(idAula);

            AgendamentoAula agendamentoAula = new AgendamentoAula();
            agendamentoAula.setDiaHorarioAgendado(aula.getDiaHorarioAula());
            agendamentoAula.setIdAula(idAula);
            agendamentoAula.setMatriculaAluno(matriculaAluno);

            BdConnection.ConectarBD();

            BdConnection.st.executeUpdate("INSERT INTO TB_AGENDAMENTO_AULA (DIA_HORARIO_AGENDADO, ID_AULA, MATRICULA_ALUNO) " +
                    "VALUES (TO_TIMESTAMP('" + agendamentoAula.getDiaHorarioAgendado() + "', 'yyyy-MM-dd HH24:MI:SS.FF'), " +
                    agendamentoAula.getIdAula() + ", " + agendamentoAula.getMatriculaAluno() + ")");

            System.out.println("Aula agendada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados do agendamento: " + e.getMessage());
        }
    }

    public void mostrarAgendamentos() throws SQLException {
        AngendamentoAulaResponse angendamentoAulaResponse = new AngendamentoAulaResponse();
        int matriculaAluno = EntradaDados.mostrarAgendamentoAluno();

        try {
            BdConnection.ConectarBD();
            ResultSet resultSet = BdConnection.st.executeQuery("SELECT A.MATRICULA, A.NOME, B.DIA_HORARIO_AGENDADO, C.NOME_AULA, D.NOME_INSTRUTOR " +
                                                                    "FROM TB_ALUNO A " +
                                                                    "JOIN TB_AGENDAMENTO_AULA B ON A.MATRICULA = B.MATRICULA_ALUNO " +
                                                                    "JOIN TB_AULA C ON C.ID_AULA = B.ID_AULA " +
                                                                    "JOIN TB_INSTRUTOR D ON D.MATRICULA_INSTRUTOR = C.MATRICULA_INSTRUTOR " +
                                                                    "WHERE A.MATRICULA = " + matriculaAluno);

            while (resultSet.next()) {
                angendamentoAulaResponse.setMatriculaAluno((resultSet.getInt("MATRICULA")));
                angendamentoAulaResponse.setNomeAluno(resultSet.getString("NOME"));
                angendamentoAulaResponse.setDiaHorarioAgendado(resultSet.getTimestamp("DIA_HORARIO_AGENDADO"));
                angendamentoAulaResponse.setAula(resultSet.getString("NOME_AULA"));
                angendamentoAulaResponse.setNomeInstrutor((resultSet.getString("NOME_INSTRUTOR")));

            }
            if(angendamentoAulaResponse.getDiaHorarioAgendado() == null){
                System.out.println("Este aluno aluno não possui aulas agendas.");
            }else{
                System.out.println(angendamentoAulaResponse);
            }

            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler os dados do agendamento: " + e.getMessage());
        } finally {
            BdConnection.DesconectarBD();
        }

    }
}
