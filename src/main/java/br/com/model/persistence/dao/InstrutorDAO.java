package br.com.model.persistence.dao;

import br.com.model.dto.InstrutorDTO;
import br.com.model.persistence.Aluno;
import br.com.model.persistence.BdConnection;
import br.com.model.persistence.Instrutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDAO {

    public void inserirInstrutor () throws SQLException {
        Instrutor instrutor = new Instrutor();

        instrutor.setMatriculaInstrutor(InstrutorDTO.matriculaInstrutor);;
        instrutor.setNomeInstrutor(InstrutorDTO.nomeInstrutor);

        BdConnection.ConectarBD();

        try {
            BdConnection.st.executeQuery("INSERT INTO TB_INSTRUTOR(MATRICULA_INSTRUTOR,NOME_INSTRUTOR) \n" +
                    "VALUES ('" + instrutor.getMatriculaInstrutor() + "','" + instrutor.getNomeInstrutor() + "')");
        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados do instrutor: " + e.getMessage());
        }
        }
    public void atualizarDadosInstrutor () throws SQLException {
        Instrutor instrutor = new Instrutor();

        instrutor.setMatriculaInstrutor(InstrutorDTO.matriculaInstrutor);
        instrutor.setNomeInstrutor(InstrutorDTO.nomeInstrutor);

        BdConnection.ConectarBD();

        try {
            BdConnection.st.executeQuery("UPDATE TB_INSTRUTOR SET NOME_INSTRUTOR = '" + instrutor.getNomeInstrutor() + "'" +
                    " WHERE MATRICULA_INSTRUTOR = '" + instrutor.getMatriculaInstrutor() + "'");
        }catch (Exception e) {
            System.out.println("Erro ao atualizar os dados do instrutor: " + e.getMessage());
        }
    }
    public void deletarDadosInstrutor() throws SQLException {
        Instrutor instrutor = new Instrutor();
        instrutor.setMatriculaInstrutor(InstrutorDTO.matriculaInstrutor);

        try {
            BdConnection.ConectarBD();
            BdConnection.st.executeQuery("DELETE FROM TB_INSTRUTOR WHERE MATRICULA_INSTRUTOR = "+ instrutor.getMatriculaInstrutor());
        }catch (Exception e){
            System.out.println("Erro ao deletar os dados do instrutor: " + e.getMessage());
        }
    }
    public List<Instrutor> lerDadosInstrutor() throws SQLException {
        List<Instrutor> instrutores = new ArrayList<>();

        BdConnection.ConectarBD();

        try {
            ResultSet resultSet = BdConnection.st.executeQuery("SELECT * FROM TB_INSTRUTOR");

            while (resultSet.next()) {
                Instrutor instrutor = new Instrutor();

                instrutor.setMatriculaInstrutor(resultSet.getInt("MATRICULA_INSTRUTOR"));
                instrutor.setNomeInstrutor(resultSet.getString("NOME_INSTRUTOR"));
                instrutores.add(instrutor);

            }
            System.out.println(instrutores);

            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler os dados do instrutor: " + e.getMessage());
        } finally {
            BdConnection.DesconectarBD();
        }

        return instrutores;
    }
        }

