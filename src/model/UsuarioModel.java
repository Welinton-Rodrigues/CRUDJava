package model;

public class UsuarioModel {
    private int Id;
    private String nome;
    private String email;
    private String senha;

    public UsuarioModel() {
    }

    public UsuarioModel(int id, String nome, String email, String senha) {
        Id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String toString(){
        return"Id Usuario:" + this.Id + "\nNome de Usuario" + this.nome + "\n" + "Email:" + this.email + "\n";
    }
}
