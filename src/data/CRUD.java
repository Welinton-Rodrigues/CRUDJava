package data;

import model.UsuarioModel;

import java.util.ArrayList;

public interface CRUD {

    public boolean incluir(UsuarioModel usuario)throws Exception;
    public boolean editar(UsuarioModel usuario) throws Exception;
    public boolean excluir(int id)throws Exception;
    public ArrayList<UsuarioModel> pesquisar(String pesquisa) throws Exception;

}

