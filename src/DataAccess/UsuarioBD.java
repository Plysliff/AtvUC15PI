
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Usuario;

public class UsuarioBD {
    
    private static final String URL = "jdbc:mysql://localhost:3306/projetochar"; //Nome da base de dados
    private static final String USER = "root"; //nome do usuário do MySQL
    // O Java vai buscar essa informação nas variáveis do Windows
    private static final String PASSWORD = System.getenv("MYSQL_SENHA");
    
    // Método que tenta realizar uma conexão com o banco de dados
    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    // Método que busca no banco de dados uma combinação que bata com o login e senha enviados, e retorna o resto dos dados caso encontre
    public static Usuario validarUsuario(Usuario usuario) {
        
        // Criando consulta
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null; // objeto do tipo Usuário que seguirá null caso não seja encontrado
        
        // Tenta realizar uma conexão usando o método "getConexao()" e preparar a consulta "sql"
        try (Connection conexao = getConexao();
            PreparedStatement statement = conexao.prepareStatement(sql)) {
            
            // Atribuindo os valores na consulta (os "?"), aos atributos informados pelo usuário
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
            
            // posiciona a leitura do banco para antes da primeira linha, para os atributos serem comparados com os do banco em uma 'varredura'
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) { // Avança para a próxima linha do banco até não haver mais, como um scanner
                    usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setId(rs.getInt("id"));
                    usuarioEncontrado.setNome(rs.getString("nome"));
                    usuarioEncontrado.setLogin(rs.getString("login"));
                    usuarioEncontrado.setSenha(rs.getString("senha"));
                } // Se algo for encontrado, usuarioEncontrado deixará de ser null, e portará as informações do banco
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro na validação: " + ex.getMessage());
        }
        
        return usuarioEncontrado;
    }
    
    
    
    
    
}
