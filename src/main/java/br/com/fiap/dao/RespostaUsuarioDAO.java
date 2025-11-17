package br.com.fiap.dao;

import br.com.fiap.to.RespostaUsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RespostaUsuarioDAO {
    public ArrayList<RespostaUsuarioTO> findAll() {
        ArrayList<RespostaUsuarioTO> respostas = new ArrayList<>();
        String sql = "select * from t_wmd_resposta_usuario order by id_resposta";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    RespostaUsuarioTO resposta = new RespostaUsuarioTO();
                    resposta.setIdResposta(rs.getLong("id_resposta"));
                    resposta.setIdUsuario(rs.getLong("id_usuario"));
                    resposta.setIdHabito(rs.getLong("id_habito"));
                    resposta.setResposta(rs.getInt("vl_resposta"));
                    resposta.setObservacoes(rs.getString("ds_observacoes"));
                    respostas.add(resposta);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return respostas;
    }
    public RespostaUsuarioTO findById(Long id) {
        RespostaUsuarioTO resposta = new RespostaUsuarioTO();
        String sql = "select * from t_wmd_resposta_usuario where id_resposta = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resposta.setIdUsuario(rs.getLong("id_usuario"));
                resposta.setIdResposta(rs.getLong("id_resposta"));
                resposta.setIdHabito(rs.getLong("id_habito"));
                resposta.setResposta(rs.getInt("vl_resposta"));
                resposta.setObservacoes(rs.getString("ds_observacoes"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return resposta;
    }
    
    
    public RespostaUsuarioTO save(RespostaUsuarioTO respostaUsuario){
        String sql = "insert into t_wmd_resposta_usuario (id_usuario, id_habito, vl_resposta, ds_observacoes) values(?,?,?,?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, respostaUsuario.getIdUsuario());
            ps.setLong(2, respostaUsuario.getIdHabito());
            ps.setInt(3, respostaUsuario.getResposta());
            ps.setString(4, respostaUsuario.getObservacoes());
            if (ps.executeUpdate() > 0) {
                return respostaUsuario;
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "delete from t_wmd_resposta_usuario where id_resposta = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());

        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }
    public RespostaUsuarioTO update(RespostaUsuarioTO resposta) {
        String sql = "update t_wmd_resposta_usuario set id_usuario = ?, id_habito = ?, vl_resposta = ?, ds_observacoes = ? where id_resposta = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, resposta.getIdUsuario());
            ps.setLong(2, resposta.getIdHabito());
            ps.setInt(3, resposta.getResposta());
            ps.setString(4, resposta.getObservacoes());
            ps.setLong(5, resposta.getIdResposta());
            if (ps.executeUpdate() > 0) {
                return resposta;
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

}
