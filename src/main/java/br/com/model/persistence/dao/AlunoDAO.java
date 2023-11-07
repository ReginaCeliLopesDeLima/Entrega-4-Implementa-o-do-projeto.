package br.com.model.persistence.dao;

import br.com.model.dto.AlunoDTO;
import br.com.model.persistence.Aluno;
import br.com.model.persistence.BdConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.sql.SQLException;

public class AlunoDAO {


    public void inserirAluno() throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setMatricula(AlunoDTO.matricula);
        aluno.setCpf(AlunoDTO.cpf);
        aluno.setNome(AlunoDTO.nome);
        aluno.setIdade(AlunoDTO.idade);

        try {
            BdConnection.ConectarBD();
            BdConnection.st.executeQuery("INSERT INTO TB_ALUNO(MATRICULA, CPF,NOME,IDADE) \n" +
                    "VALUES ('" + aluno.getMatricula() + "','" + aluno.getCpf() + "','" + aluno.getNome() + "','" + aluno.getIdade() + "')");
        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados de aluno: " + e.getMessage());
        }
    }

    public void atualizarDadosAluno(int opcao) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setMatricula(AlunoDTO.matricula);
        aluno.setCpf(AlunoDTO.cpf);
        aluno.setNome(AlunoDTO.nome);
        aluno.setIdade(AlunoDTO.idade);

        try {
            BdConnection.ConectarBD();
            switch (opcao) {
                case 1:
                    BdConnection.st.executeUpdate("UPDATE TB_ALUNO SET CPF = '" + aluno.getCpf() + "'" +
                            " WHERE MATRICULA = '" + aluno.getMatricula() + "'");
                    break;
                case 2:
                    BdConnection.st.executeUpdate("UPDATE TB_ALUNO SET NOME = '" + aluno.getNome() + "'" +
                            " WHERE MATRICULA = '" + aluno.getMatricula() + "'");
                    break;
                case 3:
                    BdConnection.st.executeUpdate("UPDATE TB_ALUNO SET IDADE = '" + aluno.getIdade() + "'" +
                            " WHERE MATRICULA = '" + aluno.getMatricula() + "'");
                    break;
                default:
                    BdConnection.st.executeUpdate("UPDATE TB_ALUNO SET CPF = '" + aluno.getCpf() + "'," +
                            "                                             NOME = '" + aluno.getNome() + "'," +
                            "                                             IDADE = '" + aluno.getIdade() + "'" +
                            " WHERE MATRICULA = '" + aluno.getMatricula() + "'");
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar os dados de aluno: " + e.getMessage());
        }
    }

    public void deletarDadosAluno() throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setMatricula(AlunoDTO.matricula);
        aluno.setCpf(AlunoDTO.cpf);
        aluno.setNome(AlunoDTO.nome);
        aluno.setIdade(AlunoDTO.idade);

        BdConnection.ConectarBD();

        try {
            BdConnection.st.executeUpdate("DELETE FROM TB_ALUNO\n" +
                    "WHERE MATRICULA = '" + aluno.getMatricula() + "'");
        } catch (Exception e) {
            System.out.println("Erro ao deletar os dados de aluno: " + e.getMessage());
        }
    }
    public static List<Aluno> lerDadosAlunos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();

        try {
            BdConnection.ConectarBD();
            ResultSet resultSet = BdConnection.st.executeQuery("SELECT * FROM TB_ALUNO");

            while (resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(resultSet.getInt("MATRICULA"));
                aluno.setCpf(resultSet.getString("CPF"));
                aluno.setNome(resultSet.getString("NOME"));
                aluno.setIdade(resultSet.getInt("IDADE"));
                alunos.add(aluno);

            }

            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler os dados de aluno: " + e.getMessage());
        } finally {

        }

        return alunos;
    }
}
