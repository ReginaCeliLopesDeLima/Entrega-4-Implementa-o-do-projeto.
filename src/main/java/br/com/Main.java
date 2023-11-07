package br.com;

import br.com.model.dto.AlunoDTO;
import br.com.model.persistence.AgendamentoAula;
import br.com.model.persistence.dao.AgendamentoAulaDAO;
import br.com.model.persistence.dao.AlunoDAO;
import br.com.model.persistence.dao.AulaDAO;
import br.com.model.persistence.dao.InstrutorDAO;
import br.com.model.utils.EntradaDados;

import java.sql.SQLException;

import static br.com.model.utils.EntradaDados.opcao;

public class Main {

	public static void main(String[] args) throws SQLException {

		AlunoDAO alunoDao = new AlunoDAO();

		//EntradaDados.inserirDadosAluno();
		//EntradaDados.atualizarDadosAluno();
		//EntradaDados.deletarDadosAluno();
		//EntradaDados.lerDadosAluno();

		//alunoDao.inserirAluno();
		//alunoDao.atualizarDadosAluno(EntradaDados.opcao);

		//alunoDao.deletarDadosAluno();
		//alunoDao.lerDados();

		//INTRUTOR
		InstrutorDAO instrutorDao = new InstrutorDAO();

		//EntradaDados.inserirInstrutor();
		//EntradaDados.atualizarDadosInstrutor();
		//EntradaDados.deletarDadosInstrutor();
		//EntradaDados.lerDadosInstrutor();


		//instrutorDao.inserirInstrutor();
		//instrutorDao.atualizarDadosInstrutor();
		//instrutorDao.deletarDadosInstrutor();
		//instrutorDao.lerDadosInstrutor();

		//Aula
		AulaDAO aulaDao = new AulaDAO();

		//EntradaDados.inserirAula();
		//EntradaDados.atualizarDadosAula();
		//EntradaDados.deletarDadosAula();
		//EntradaDados.lerDadosAula();

		//aulaDao.inserirAula();
//		aulaDao.atualizarDadosAula(EntradaDados.opcao);
		//aulaDao.deletarDadosAula();
		//aulaDao.lerDadosAulas();

		//AGENDAMENTO AULA
		AgendamentoAulaDAO agendamentoAulaDAO = new AgendamentoAulaDAO();

		EntradaDados.agendarAulas();

		agendamentoAulaDAO.agendarAula(EntradaDados.idAula, EntradaDados.matriculaAluno);
		//agendamentoAulaDAO.mostrarAgendamentos();

	}

}
