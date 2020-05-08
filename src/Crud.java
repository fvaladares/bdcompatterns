import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud {

    private MyConnection conexao;
    public Crud() {
        conexao = new MyConnection();
    }

    public boolean cadastrarAluno( String nome, int idade, String ra) {
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(
                    "INSERT INTO cadastro.aluno(nome, idade, ra) VALUES (?,?,?)"
            );
            comando.setString(1, nome);
            comando.setInt(2, idade);
            comando.setString(3,ra);
//            conexao.closeConection();
            return comando.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha na execução SQL durante a inserção.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet carregarAlunos(){
        ResultSet dados = null;
        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement(
                    "SELECT * FROM aluno"
            );
            dados = comando.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha na execução SQL durante a carga de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
        return dados;
    }

    public boolean atualizarAluno (int codigo,
                                   String nome,
                                   int idade,
                                   String ra){
        try {
            PreparedStatement comando =
                    conexao.getConexao().prepareStatement(
                            "UPDATE cadastro.aluno SET nome = ?, idade=?, ra=? WHERE id_aluno = ?"
            );
            comando.setString(1,nome);
            comando.setInt(2, idade);
            comando.setString(3,ra);
            comando.setInt(4,codigo);
            return comando.execute();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha na execução SQL durante a atualização de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();

            return false;
        }
    }


    public boolean excluirAluno(int codigo){
        try {
            PreparedStatement comando =
                    conexao.getConexao().prepareStatement(
                            "DELETE FROM aluno WHERE id_aluno=?"
                    );
            comando.setInt(1, codigo);
            return comando.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Falha na execução SQL durante a exclusão carga de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
}
