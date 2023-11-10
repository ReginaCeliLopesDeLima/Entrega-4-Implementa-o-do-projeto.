package br.com.model.persistence.dao;

import br.com.model.persistence.Aula;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;

public class AulaDAOTest {
    private int idAula;

    @Before
    public void setUp() {
        idAula = 1;
    }

    @Test
    public void testConsultarDaTabelaAula() throws SQLException {

        Aula aula = AulaDAO.lerDadosAula(idAula);

        Assert.assertEquals("Danca", aula.getNomeAula());
        Assert.assertEquals(Timestamp.valueOf("2023-10-29 14:00:00"), aula.getDiaHorarioAula());
        Assert.assertEquals(992, aula.getMatriculaInstrutor());
    }
}