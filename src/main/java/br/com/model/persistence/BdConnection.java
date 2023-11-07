package br.com.model.persistence;

import java.sql.*;

public class BdConnection {

    public static Statement st = null; //Responsável por realizar as consultas no banco de dados.
    public static Connection con = null; //Responsável por realizar a conexão com o banco de dados.
    public static ResultSet rs = null; //Responsável por armazenar o resultado de uma pesquisa que foi passada para o statemente.
    private static final String driver = "oracle.jdbc.OracleDriver";
    private static final String caminho = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String usuario = "SYSTEM";
    private static final String senha = "123";

    public static void ConectarBD(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            st = con.createStatement();
//            System.out.println("Conexão com o banco de dados realizada com sucesso!");
        }catch (Exception ex) {
            System.out.println("Erro ao se conectar com o banco de dados: " + ex);
        }
    }

    public static void DesconectarBD(){
        try {
            con.close();
//            System.out.println( "O banco de dados foi desconectado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Falha ao fechar conexão com o banco de dados: " + ex);
        }
    }

    //MÉTODOS DE STATEMENT (QUERYS)
//    public static void incluir(Cliente cliente) throws Exception{
//        st.executeUpdate("INSERT INTO CLIENTES VALUES ('"+3+"','"+cliente.getCPF()+"',"+null+",'"+cliente.getNome()+"')");
//    }
//
//    public static void excluir(Cliente cliente) throws Exception{
//         st.executeUpdate("DELETE FROM CADASTRO_CLIENTE WHERE CPF = '" +cliente.getCPF()+"'");
//    }
//
//    public static void alterar(Cliente cliente) throws Exception{
//        st.executeUpdate("UPDATE CADASTRO_CLIENTE SET NOME = '"+cliente.getNome()+"' WHERE CPF = '"+cliente.getCPF()+"'");
//    }
//
//    public static Cliente consultar(Cliente cliente) throws Exception{
//        return null;
//    }

}
