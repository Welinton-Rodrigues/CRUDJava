package data;

import model.UsuarioModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioData extends Conexao implements CRUD {

    public UsuarioData() throws Exception {
        super();
    }

    @Override
    public boolean incluir(UsuarioModel usuario) throws Exception {
        String sql = "INSERT INTO tbUsuarios (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        if (ps.executeUpdate()>0)
            return true;
        else return false;
    }

    @Override
    public boolean editar(UsuarioModel usuario) throws Exception {
        String sql = "UPDATE tbUsuarios SET nome = ?, email = ?, senha = ? WHERE id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        ps.setInt(4, usuario.getId());
        if (ps.executeUpdate()>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean excluir(int id) throws Exception {
        String sql = "DELETE FROM tbUsuarios WHERE id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        if (ps.executeUpdate()>0)
            return true;
        else
            return false;
    }

    @Override
    public ArrayList<UsuarioModel> pesquisar(String pesquisa)throws Exception {
        ArrayList<UsuarioModel> dados = new ArrayList<>();
        String sql = "SELECT * FROM tbUsuarios WHERE nome LIKE ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, pesquisa+"%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            UsuarioModel usuarioLista = new UsuarioModel();
            usuarioLista.setId(rs.getInt("id"));
            usuarioLista.setNome(rs.getString("nome"));
            usuarioLista.setEmail(rs.getString("email"));
            usuarioLista.setSenha(rs.getString("senha"));
            dados.add(usuarioLista);
        }
        return dados;
    }
}