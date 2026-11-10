
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Item;

public class ItemDAO {
    
    // Método que retorna uma lista de itens, que recebe um ID para filtrar os itens de um personagem
    public ArrayList<Item> listarPorPersonagem(int _idPersonagem) {
        
        // Preparando comando SQL
        String sql = "SELECT * FROM Itens WHERE Personagens_id = ?";
        
        // Cria uma lista para guardar os objetos do tipo Personagem
        ArrayList<Item> lista = new ArrayList<>();
        
        // Abre a conexão com o banco e prepara o comando SQL
        try (Connection conn = UsuarioBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui o primeiro ? do comando SQL pelo ID do personagem selecionado
            ps.setInt(1, _idPersonagem);
            
            // Executa o SELECT no banco e guarda o resultado no rs (ResultSet)
            try (ResultSet rs = ps.executeQuery()) {
                
                // Um laço de repetição. Ele avança para a próxima linha do resultado até não haver mais
                    while (rs.next()) {

                        // Para cada linha do banco, cria um objeto Personagem vazio, e o preenche os campos
                        Item i = new Item();
                        i.setId(rs.getInt("id"));
                        i.setPersonagens_id(rs.getInt("Personagens_id"));
                        i.setItem(rs.getString("item"));
                        i.setTipo(rs.getString("tipo"));
                        lista.add(i); // E adiciona esse objeto à lista.
                    }
                }
                
        } catch (SQLException ex) {
            System.out.println("Erro ao listar personagens: " + ex.getMessage());
        }
            
        // Retorna a lista de itens do banco, apenas com os itens do usuário
        return lista;
        
    }
    
    // Método para salvar um novo item
    public boolean cadastrarItem(Item item) {
        String sql = "INSERT INTO Itens (Personagens_id, item, tipo) VALUES (?, ?, ?)";
        
        try (Connection conn = UsuarioBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, item.getPersonagens_id());
            ps.setString(2, item.getItem());
            ps.setString(3, item.getTipo());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar item: " + e.getMessage());
            return false;
        }
    }
    
    // Método para excluir o item selecionado (o item de ID enviado com o método)
    public boolean excluirItem(int idItem) {
        
        // Prepara a base do comando SQL
        String sql = "DELETE FROM Itens WHERE id = ?";
        
        // Realiza conexão e envio da base do comando sql
        try (Connection conn = UsuarioBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idItem); // Define a primeira interrogação de "sql" como idItem
            ps.executeUpdate(); // Envia o comando sql ao banco
            
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir item: " + e.getMessage());
            
            return false;
        }
        
    }
    
    
}
