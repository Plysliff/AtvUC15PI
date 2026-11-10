
package model;

public class Personagem {
    
    int id;
    int Usuarios_id;
    String nome;
    private byte[] foto;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarios_id() {
        return Usuarios_id;
    }

    public void setUsuarios_id(int Usuarios_id) {
        this.Usuarios_id = Usuarios_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public byte[] getFoto() {
        return foto;
    }
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    
}
