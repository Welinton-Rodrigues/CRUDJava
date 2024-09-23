package data;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class Conexao {
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }
    public Conexao() throws Exception{
        String url = "jdbc:sqlserver://localhost:1433;databaseName=bdRapaziada;trustServerCertificate=true;encrypt=false";;
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String usuario="sa";
        String senha ="Whrc1306@";
        Class.forName(driver);
        conexao = DriverManager.getConnection(url, usuario, senha);
    }
}
