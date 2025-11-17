package br.com.fiap.dao;

import br.com.fiap.to.FeedbackTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackDAO {

    public ArrayList<FeedbackTO> findAll() {
        ArrayList<FeedbackTO> feedbacks = new ArrayList<>();
        String sql = "select * from t_wmd_feedback order by id_feedback";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedbackTO feedback = new FeedbackTO();
                feedback.setIdFeedback(rs.getLong("id_feedback"));
                feedback.setIdUsuario(rs.getLong("id_usuario"));
                feedback.setIdResposta(rs.getLong("id_resposta"));
                feedback.setMensagem(rs.getString("ds_mensagem"));
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar feedbacks: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return feedbacks;
    }

    public FeedbackTO findById(Long id) {
        FeedbackTO feedback = new FeedbackTO();
        String sql = "select * from t_wmd_feedback where id_feedback = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                feedback.setIdFeedback(rs.getLong("id_feedback"));
                feedback.setIdUsuario(rs.getLong("id_usuario"));
                feedback.setIdResposta(rs.getLong("id_resposta"));
                feedback.setMensagem(rs.getString("ds_mensagem"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar feedback: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return feedback;
    }

    public FeedbackTO save(FeedbackTO feedback) {
        String sql = "insert into t_wmd_feedback (id_usuario, id_resposta, ds_mensagem) values (?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, feedback.getIdUsuario());
            ps.setLong(2, feedback.getIdResposta());
            ps.setString(3, feedback.getMensagem());
            if (ps.executeUpdate() > 0) {
                return feedback;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar feedback: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "delete from t_wmd_feedback where id_feedback = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar feedback: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public FeedbackTO update(FeedbackTO feedback) {
        String sql = "update t_wmd_feedback set id_usuario = ?, id_resposta = ?, ds_mensagem = ? where id_feedback = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, feedback.getIdUsuario());
            ps.setLong(2, feedback.getIdResposta());
            ps.setString(3, feedback.getMensagem());
            ps.setLong(4, feedback.getIdFeedback());
            if (ps.executeUpdate() > 0) {
                return feedback;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar feedback: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
