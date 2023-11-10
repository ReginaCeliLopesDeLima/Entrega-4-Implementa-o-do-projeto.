package br.com.view;

import br.com.model.dto.AlunoDTO;
import br.com.model.dto.AulaDTO;
import br.com.model.dto.InstrutorDTO;
import br.com.model.persistence.Aluno;
import br.com.model.persistence.Aula;
import br.com.model.persistence.dao.AlunoDAO;
import br.com.model.persistence.dao.AulaDAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class EntradaDados {

    public static int opcao;
    public static int idAula;
    public static int matriculaAluno;

    public static void inserirDadosAluno(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a matrícula do aluno: ");
        if (sc.hasNextInt()) {
            AlunoDTO.matricula = sc.nextInt();
        } else {
            System.out.println("Entrada inválida para matrícula.");
            sc.close();
        }

        sc.nextLine();

        System.out.println("Digite o CPF do aluno: ");
        AlunoDTO.cpf = sc.next();

        sc.nextLine();

        System.out.println("Digite o nome do aluno: ");
        AlunoDTO.nome = sc.next();

        sc.nextLine();

        System.out.println("Digite a idade do aluno: ");
        if (sc.hasNextInt()) {
            AlunoDTO.idade = sc.nextInt();
        } else {
            System.out.println("Entrada inválida para idade.");
            sc.close();
        }

        sc.close();
    }

    public static void atualizarDadosAluno() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a matrícula do aluno que deseja atualizar: ");
        if (sc.hasNextInt()) {
            AlunoDTO.matricula = sc.nextInt();
        } else {
            System.out.println("Entrada inválida para matrícula.");
            sc.close();
        }

        sc.nextLine();

        System.out.println("Qual informacao deseja atualizar?: (1) - CPF \n (2) - Nome \n (3) - Idade ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo CPF: ");
                AlunoDTO.cpf = sc.next();
                sc.nextLine();
                sc.close();
                break;
            case 2:
                System.out.println("Digite o novo Nome: ");
                AlunoDTO.nome = sc.next();
                sc.nextLine();
                sc.close();
                break;
            case 3:
                System.out.println("Digite a nova Idade: ");
                if (sc.hasNextInt()) {
                    AlunoDTO.idade = sc.nextInt();
                } else {
                    System.out.println("Entrada inválida para idade.");
                    sc.close();
                }
                sc.nextLine();
                sc.close();
                break;
            default:
                System.out.println("Entrada inválida");
        }
    }

        public static void deletarDadosAluno(){
            Scanner sc = new Scanner(System.in);

            System.out.println("ATENÇÃO: Você irá deletar todos os dados deste aluno!");
            System.out.println("Digite a matrícula do aluno que deseja deletar: ");
            if (sc.hasNextInt()) {
                AlunoDTO.matricula = sc.nextInt();
            } else {
                System.out.println("Entrada inválida para matrícula.");
                sc.close();
            }

    }
    public static void lerDadosAluno(){
        System.out.println("Aqui está todos os alunos cadastrados");
    }

    // ENTRADA DE DADOS DO INSTRUTOR
    public static void inserirInstrutor(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a matricula do novo instrutor");
        if (sc.hasNextInt()) {
            InstrutorDTO.matriculaInstrutor = sc.nextInt();
        } else {
            System.out.println("Entrada inválida para matrícula");
            sc.close();
        }
        sc.nextLine();
        System.out.println("Digite o nome do instrutor ");
        InstrutorDTO.nomeInstrutor = sc.next();

        sc.close();

    }
    public static void atualizarDadosInstrutor(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a matrícula do instrutor que deseja atualizar: ");
        if (sc.hasNextInt()) {
            InstrutorDTO.matriculaInstrutor = sc.nextInt();
        } else {
            System.out.println("Entrada inválida para matrícula.");
            sc.close();
        }
        sc.nextLine();
        System.out.println("Digite o novo Nome: ");
        InstrutorDTO.nomeInstrutor = sc.next();
        sc.close();
    }

    public static void deletarDadosInstrutor(){
        Scanner sc = new Scanner(System.in);

        System.out.println("ATENÇÃO: Você irá deletar todos os dados deste instrutor!");
        System.out.println("Digite a matrícula do instrutor que deseja deletar: ");
        if (sc.hasNextInt()) {
            InstrutorDTO.matriculaInstrutor = sc.nextInt();
        } else {
            System.out.println("Entrada inválida para matrícula.");
            sc.close();
        }
    }
    public static void lerDadosInstrutor(){
        System.out.println("Aqui está todos os instrutores cadastrados");
    }

    // ENTRADA DE DADOS AULA
    public static void inserirAula(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um id_aula");
        AulaDTO.idAula = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o nome da aula");
        AulaDTO.nomeAula = sc.next();
        sc.nextLine();

        System.out.println("Digite a data e horario no formato 'yyyy-MM-dd HH:mm:ss': ");
        AulaDTO.diaHorarioAula = Timestamp.valueOf(sc.nextLine());


        System.out.println("Digite a matricula do instrutor");

        AulaDTO.matriculaInstrutor = sc.nextInt();
        sc.close();
    }
    public static void atualizarDadosAula() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o id da aula que deseja atualizar: ");
        if (sc.hasNextInt()) {
            AulaDTO.idAula = sc.nextInt();
        } else {
            System.out.println("Entrada inválida para id.");
            sc.close();
        }

        sc.nextLine();

        System.out.println("Qual informacao deseja atualizar?: (1) - Nome_Aula \n (2) - Dia_Horario_Aula \n (3) - Matricula_Instrutor ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo nome da aula: ");
                AulaDTO.nomeAula = sc.next();
                sc.nextLine();
                sc.close();
                break;
            case 2:
                System.out.println("Digite o novo dia e horario da aula: ");
                AulaDTO.diaHorarioAula = Timestamp.valueOf(sc.nextLine());
                sc.nextLine();
                sc.close();
                break;
            case 3:
                System.out.println("Digite a nova matricula do instrutor: ");
                if (sc.hasNextInt()) {
                    AulaDTO.matriculaInstrutor = sc.nextInt();
                } else {
                    System.out.println("Entrada inválida para matricula instrutor.");
                    sc.close();
                }
                sc.nextLine();
                sc.close();
                break;
            default:
                System.out.println("Entrada inválida");
        }
    }
    public static void deletarDadosAula(){
        Scanner sc = new Scanner(System.in);

        System.out.println("ATENÇÃO: Você irá deletar todos os dados da aula!");
        System.out.println("Digite o id da aula que deseja deletar: ");
        if (sc.hasNextInt()) {
            AulaDTO.idAula = sc.nextInt();
        } else {
            System.out.println("Entrada inválida para id.");
            sc.close();
        }
    }

    public static void agendarAulas() throws SQLException {

        List<Aula> aulas = AulaDAO.lerDadosAulas();
        List<Aluno> alunos = AlunoDAO.lerDadosAlunos();
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual aula deseja agendar ?");

        for (int i = 0; i <= aulas.size() - 1; i++) {
            System.out.println("[" + aulas.get(i).getIdAula() + "] " + aulas.get(i).getNomeAula());
        }
        idAula = sc.nextInt();

        System.out.println("Qual sua matricula?");
        matriculaAluno = sc.nextInt();

        boolean alunoEncontrado = false;

        for (int i = 0; i <= alunos.size() - 1; i++) {
            if (alunos.get(i).getMatricula() == matriculaAluno) {
                alunoEncontrado = true;
            }
        }

        if (!alunoEncontrado) {
            System.out.println("Não foi possível agendar aula, pois esse aluno não está cadastrado!");
        }
    }
    public static int mostrarAgendamentoAluno(){
        System.out.println("Digite a matricula do aluno: ");
        Scanner sc = new Scanner(System.in);
        int matriculaAluno = sc.nextInt();

        return matriculaAluno;
    }
    }


