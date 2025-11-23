package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    public ArrayList<UsuarioTO> findAll() {
        ArrayList<UsuarioTO> usuarios = new ArrayList<>();
        String sql = "select * from t_wmd_usuario order by id_usuario";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioTO usuario = new UsuarioTO();
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setEmail(rs.getString("nm_email"));
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setIdade(rs.getInt("nr_idade"));
                usuario.setGenero(rs.getString("nm_genero"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return usuarios;
    }

    public UsuarioTO findById(Long id) {
        UsuarioTO usuario = new UsuarioTO();
        String sql = "select * from t_wmd_usuario where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setEmail(rs.getString("nm_email"));
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setIdade(rs.getInt("nr_idade"));
                usuario.setGenero(rs.getString("nm_genero"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuário: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return usuario;
    }

    public UsuarioTO save(UsuarioTO usuario) {
        String sql = "insert into t_wmd_usuario (nm_email, nm_usuario, nr_idade, nm_genero) values (?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getNome());
            ps.setInt(3, usuario.getIdade());
            ps.setString(4, usuario.getGenero());
            if (ps.executeUpdate() > 0) {
                return usuario;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "delete from t_wmd_usuario where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public UsuarioTO update(UsuarioTO usuario) {
        String sql = "update t_wmd_usuario set nm_email = ?, nm_usuario = ?, nr_idade = ?, nm_genero = ? where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getNome());
            ps.setInt(3, usuario.getIdade());
            ps.setString(4, usuario.getGenero());
            ps.setLong(5, usuario.getIdUsuario());
            if (ps.executeUpdate() > 0) {
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
