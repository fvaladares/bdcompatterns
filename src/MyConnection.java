import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private Connection conexao;
    private String URLDB = "jdbc:mysql://172.17.0.2:3306/cadastro";
    private String user = "fabricio";
    private String password = "senha.123";
    private  static String status;


    public MyConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URLDB,user,password);
            if (conexao != null)
                status = "Conectado com sucesso.";
            else status = "Não conectou.";
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("Driver do BD não encontrado!");
        }
    }

    public Connection getConexao(){
        return conexao;
    }

    public static String getStatus () {
        return status;
    }

    public boolean fecharConexao() {
        try {
            this.conexao.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


    public void closeConection() throws SQLException {
        conexao.close();
    }
}

