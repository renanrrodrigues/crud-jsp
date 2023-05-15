package dao;

import bean.Usuario;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    // dao = data access object 'responsável por acessar os dados' e fazer a manipulação dos dados (regras de negócio)

    // CRUD = Create, Read, Update, Delete

    // Read = Ler

    public static List<Usuario> getAllUsuarios() {

        List<Usuario> usuarios = new ArrayList<Usuario>();

        String sql = "SELECT * FROM crudjspjava.usuario";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {

            // criando uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();


            // Criando um statement para executar as instruções SQL
            assert conn != null;
            pstm = conn.prepareStatement(sql);

            // Executando a instrução SQL
            rset = pstm.executeQuery();

            // Enquanto existir dados no banco de dados, faça
            while (rset.next()){
                Usuario usuario = new Usuario();

                // Recuperando o valor de cada coluna e atribuindo a uma variável
                usuario.setId(rset.getInt("id"));
                usuario.setNome(rset.getString("nome"));
                usuario.setPassword(rset.getString("password"));
                usuario.setEmail(rset.getString("email"));
                usuario.setSexo(rset.getString("sexo"));
                usuario.setPais(rset.getString("pais"));

                // Adicionando o usuário na lista
                usuarios.add(usuario);

            }


        }
        catch (Exception e){
            e.printStackTrace(); // Imprimindo o erro
        }
        finally {
            try{
                if (pstm != null){
                    pstm.close(); // Fechando o statement
                }
                if (conn != null){
                    conn.close(); // Fechando a conexão com o banco
                }
            }
            catch (Exception e){
                e.printStackTrace(); // Imprimindo o erro
            }
        }

        return usuarios;
    }

    // Read
    public static Usuario getUsuarioById(int id) {

        Usuario usuario = new Usuario();

        String sql = "SELECT * FROM crudjspjava.usuario WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{

            // criando uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();


            // Criando um statement para executar as instruções SQL
            assert conn != null;
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            // Executando a instrução SQL
            rset = pstm.executeQuery();

            // Enquanto existir dados no banco de dados, faça
            while (rset.next()){

                // Recuperando o valor de cada coluna e atribuindo a uma variável
                usuario.setId(rset.getInt("id"));
                usuario.setNome(rset.getString("nome"));
                usuario.setPassword(rset.getString("password"));
                usuario.setEmail(rset.getString("email"));
                usuario.setSexo(rset.getString("sexo"));
                usuario.setPais(rset.getString("pais"));

            }

            return usuario;


        } catch (Exception e) {
            e.printStackTrace(); // Imprimindo o erro
        } finally {
            try {
                if (pstm != null) {
                    pstm.close(); // Fechando o statement
                }
                if (conn != null) {
                    conn.close(); // Fechando a conexão com o banco
                }
            } catch (Exception e) {
                e.printStackTrace(); // Imprimindo o erro
            }
        }

        return usuario;
    }

    // Update
    public static int updateUsuario(Usuario usuario) {

        String sql = "UPDATE crudjspjava.usuario SET nome = ?, password = ?, email = ?, sexo = ?, pais = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        int status = 0;

        try {

            // criando uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();


            // Criando um statement para executar as instruções SQL
            assert conn != null;
            pstm = conn.prepareStatement(sql);


            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getPassword());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getSexo());
            pstm.setString(5, usuario.getPais());
            pstm.setInt(6, usuario.getId());

            // Executando a instrução SQL
            status = pstm.executeUpdate();

            return status;

        } catch (Exception e) {
            e.printStackTrace(); // Imprimindo o erro
        } finally {
            try {
                if (pstm != null) {
                    pstm.close(); // Fechando o statement
                }
                if (conn != null) {
                    conn.close(); // Fechando a conexão com o banco
                }
            } catch (Exception e) {
                e.printStackTrace(); // Imprimindo o erro
            }
        }

        return status;
    }

    // Add
    public static int addUsuario(Usuario usuario) {

        String sql = "INSERT INTO crudjspjava.usuario (nome, password, email, sexo, pais) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        int status = 0;

        try {

            // criando uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            // Criando um statement para executar as instruções SQL
            assert conn != null;
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getPassword());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getSexo());
            pstm.setString(5, usuario.getPais());

            // Executando a instrução SQL
            status = pstm.executeUpdate();

            return status;

        } catch (Exception e) {
            e.printStackTrace(); // Imprimindo o erro
        } finally {
            try {
                if (pstm != null) {
                    pstm.close(); // Fechando o statement
                }
                if (conn != null) {
                    conn.close(); // Fechando a conexão com o banco
                }
            } catch (Exception e) {
                e.printStackTrace(); // Imprimindo o erro
            }
        }

        return status;

    }

    // Delete
    public static void deletarUsuario(int id) {

        String sql = "DELETE FROM crudjspjava.usuario WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            // criando uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            // Criando um statement para executar as instruções SQL
            assert conn != null;
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            // Executando a instrução SQL
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(); // Imprimindo o erro
        } finally {
            try {
                if (pstm != null) {
                    pstm.close(); // Fechando o statement
                }
                if (conn != null) {
                    conn.close(); // Fechando a conexão com o banco
                }
            } catch (Exception e) {
                e.printStackTrace(); // Imprimindo o erro
            }
        }
    }

    public static void main(String[] args) {
        /*List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = UsuarioDao.getAllUsuarios();

        for (Usuario usuario : listaUsuarios){
            System.out.println(usuario.getNome());
        }*/

        Usuario usuario = new Usuario();
        usuario = UsuarioDao.getUsuarioById(1);
        System.out.println(usuario.getNome());
    }
}
