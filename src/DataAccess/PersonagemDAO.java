
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Personagem;

public class PersonagemDAO {
    
    // Criando um método que retorna uma lista de personagens, que recebe um ID para filtrar os personagens de uma conta
    public ArrayList<Personagem> listarPorUsuario(int _idUsuario) {
        
        // Preparando comando SQL
        String sql = "SELECT * FROM Personagens WHERE Usuarios_id = ?";
        
        // Cria uma lista para guardar os objetos do tipo Personagem
        ArrayList<Personagem> lista = new ArrayList<>();
        
        // Abre a conexão com o banco e prepara o comando SQL
        try (Connection conn = UsuarioBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui o primeiro ? do comando SQL pelo ID do usuário logado
            ps.setInt(1, _idUsuario);
            
            // Executa o SELECT no banco e guarda o resultado no rs (ResultSet)
            try (ResultSet rs = ps.executeQuery()) {
                
                // Um laço de repetição. Ele avança para a próxima linha do resultado até não haver mais
                while (rs.next()) {
                    
                    // Para cada linha do banco, cria um objeto Personagem vazio, e o preenche os campos
                    Personagem p = new Personagem();
                    p.setId(rs.getInt("id"));
                    p.setUsuarios_id(rs.getInt("Usuarios_id"));
                    p.setNome(rs.getString("nome"));
                    p.setFoto(rs.getBytes("foto"));
                    lista.add(p); // E adiciona esse objeto à lista.
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao listar personagens: " + ex.getMessage());
        }
        
        // Retorna a lista de personagens do banco, apenas com os personagens do usuário
        return lista;
    }
    
    // 
    public boolean cadastrarPersonagem(Personagem personagem) {
        
        String sql = "INSERT INTO Personagens (Usuarios_id, nome, foto) VALUES (?, ?, ?)";

        try (Connection conn = UsuarioBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, personagem.getUsuarios_id());
            ps.setString(2, personagem.getNome());
            
            if (personagem.getFoto() != null) {
                ps.setBytes(3, personagem.getFoto());
            } else {
                ps.setNull(3, java.sql.Types.BLOB); // Se não tiver foto, salva como null no banco
            }   // Depois, um resultado null de foto no banco resultará em uma imagem 'default'
            
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar personagem: " + e.getMessage());
            return false;
        }
    }
    
    
}
