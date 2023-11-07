package br.com.model.persistence.dao;

import br.com.model.persistence.AgendamentoAula;
import br.com.model.persistence.Aluno;
import br.com.model.persistence.Aula;
import br.com.model.persistence.BdConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoAulaDAO {

    public static void agendarAula(int idAula, int matriculaAluno) throws SQLException {

        try {
            Aula aula = AulaDAO.lerDadosAulas(idAula);

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

    public List<AgendamentoAula> mostrarAgendamentos() throws SQLException {
        List<AgendamentoAula> agendamentos = new ArrayList<>();

        try {
            BdConnection.ConectarBD();
            ResultSet resultSet = BdConnection.st.executeQuery("SELECT DIA_HORARIO_AGENDADO, NOME_AULA " +
                    "FROM TB_AGENDAMENTO_AULA");

            while (resultSet.next()) {
                AgendamentoAula agendamentoAula = new AgendamentoAula();
                agendamentoAula.setDiaHorarioAgendado(resultSet.getTimestamp("DIA_HORARIO_AGENDADO"));
                agendamentos.add(agendamentoAula);

            }
            System.out.println(agendamentos);

            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler os dados do agendamento: " + e.getMessage());
        } finally {
            BdConnection.DesconectarBD();
        }
        return agendamentos;
    }
}


