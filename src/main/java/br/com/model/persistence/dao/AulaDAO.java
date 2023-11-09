package br.com.model.persistence.dao;

import br.com.model.dto.AulaDTO;
import br.com.model.persistence.Aula;
import br.com.model.persistence.BdConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AulaDAO {

    public static void inserirAula() throws SQLException {
        Aula aula = new Aula();
        aula.setIdAula(AulaDTO.idAula);
        aula.setNomeAula(AulaDTO.nomeAula);
        aula.setDiaHorarioAula(AulaDTO.diaHorarioAula);
        aula.setMatriculaInstrutor(AulaDTO.matriculaInstrutor);

        try {
            BdConnection.ConectarBD();
            BdConnection.st.executeQuery("INSERT INTO TB_AULA(ID_AULA, NOME_AULA, DIA_HORARIO_AULA, MATRICULA_INSTRUTOR) \n" +
                                        "VALUES ('" + aula.getIdAula() + "','" + aula.getNomeAula() + "', TO_TIMESTAMP('" + aula.getDiaHorarioAula() + "', 'yyyy-MM-dd HH24:MI:SS.FF'), '" + aula.getMatriculaInstrutor() + "')");
        } catch (Exception e) {
        System.out.println("Erro ao inserir os dados da aula: " + e.getMessage());
    }
    }
public static void atualizarDadosAula(int opcao) throws SQLException {
        Aula aula = new Aula();
        aula.setIdAula(AulaDTO.idAula);
        aula.setNomeAula(AulaDTO.nomeAula);
        aula.setDiaHorarioAula(AulaDTO.diaHorarioAula);
        aula.setMatriculaInstrutor(AulaDTO.matriculaInstrutor);

    try {
        BdConnection.ConectarBD();
        switch (opcao) {
            case 1:
                BdConnection.st.executeUpdate("UPDATE TB_AULA SET NOME_AULA = '" + aula.getNomeAula() + "'" +
                        " WHERE ID_AULA = '" + aula.getIdAula() + "'");
                break;
            case 2:
                BdConnection.st.executeUpdate("UPDATE TB_ALUNO SET DIA_HORARIO_AULA = '" + aula.getDiaHorarioAula() + "'" +
                        " WHERE ID_AULA = '" + aula.getIdAula() + "'");
                break;
            case 3:
                BdConnection.st.executeUpdate("UPDATE TB_ALUNO SET MATRICULA_INSTRUTOR = '" + aula.getMatriculaInstrutor() + "'" +
                        " WHERE ID_AULA = '" + aula.getIdAula() + "'");
                break;
            default:
                BdConnection.st.executeUpdate("UPDATE TB_AULA SET NOME_AULA = '" + aula.getNomeAula() + "'," +
                        "                                             DIA_HORARIO_AULA = '" + aula.getDiaHorarioAula() + "'," +
                        "                                             MATRICULA_INSTRUTOR = '" + aula.getMatriculaInstrutor() + "'" +
                        " WHERE MATRICULA = '" + aula.getIdAula() + "'");
        }

    } catch (Exception e) {
        System.out.println("Erro ao atualizar os dados de aluno: " + e.getMessage());
    }

}
    public static void deletarDadosAula() throws SQLException {

        Aula aula = new Aula();
        aula.setNomeAula(AulaDTO.nomeAula);
        aula.setDiaHorarioAula(AulaDTO.diaHorarioAula);
        aula.setMatriculaInstrutor(AulaDTO.matriculaInstrutor);

        try {
            BdConnection.ConectarBD();
            BdConnection.st.executeUpdate("DELETE FROM TB_AULA\n" +
                    "WHERE ID_AULA = '" + aula.getIdAula() + "'");
        } catch (Exception e) {
            System.out.println("Erro ao deletar os dados da aula: " + e.getMessage());
        }
    }
    public static List<Aula> lerDadosAulas() throws SQLException {
        List<Aula> aulas = new ArrayList<>();

        try {
            BdConnection.ConectarBD();
            ResultSet resultSet = BdConnection.st.executeQuery("SELECT * FROM TB_AULA");

            while (resultSet.next()) {
                Aula aula = new Aula();
                aula.setIdAula(resultSet.getInt("ID_AULA"));
                aula.setNomeAula(resultSet.getString("NOME_AULA"));
                aula.setDiaHorarioAula(resultSet.getTimestamp("DIA_HORARIO_AULA"));
                aula.setMatriculaInstrutor(resultSet.getInt("MATRICULA_INSTRUTOR"));
                aulas.add(aula);

            }

            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler os dados da aula: " + e.getMessage());
        } finally {
            BdConnection.DesconectarBD();
        }

        return aulas;
    }

    public static Aula lerDadosAula(int idAula) throws SQLException {
        Aula aula = new Aula();

        try {
            BdConnection.ConectarBD();
            ResultSet resultSet = BdConnection.st.executeQuery("SELECT * FROM TB_AULA WHERE ID_AULA = " + idAula);

            while (resultSet.next()) {
                aula.setIdAula(resultSet.getInt("ID_AULA"));
                aula.setNomeAula(resultSet.getString("NOME_AULA"));
                aula.setDiaHorarioAula(resultSet.getTimestamp("DIA_HORARIO_AULA"));
                aula.setMatriculaInstrutor(resultSet.getInt("MATRICULA_INSTRUTOR"));
            }

            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler os dados da aula: " + e.getMessage());
        } finally {
            BdConnection.DesconectarBD();
        }

        return aula;
    }
}
