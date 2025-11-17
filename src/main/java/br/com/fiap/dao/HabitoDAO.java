package br.com.fiap.dao;

import br.com.fiap.to.HabitoTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabitoDAO {

    public ArrayList<HabitoTO> findAll() {
        ArrayList<HabitoTO> habitos = new ArrayList<>();
        String sql = "select * from t_wmd_habito order by id_habito";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HabitoTO habito = new HabitoTO();
                habito.setIdHabito(rs.getLong("id_habito"));
                habito.setTipo(rs.getString("nm_tipo"));
                habito.setDescricao(rs.getString("ds_habito"));
                habito.setUnidade(rs.getString("vl_unidade"));
                habitos.add(habito);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar hábitos: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return habitos;
    }

    public HabitoTO findById(Long id) {
        HabitoTO habito = new HabitoTO();
        String sql = "select * from t_wmd_habito where id_habito = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                habito.setIdHabito(rs.getLong("id_habito"));
                habito.setTipo(rs.getString("nm_tipo"));
                habito.setDescricao(rs.getString("ds_habito"));
                habito.setUnidade(rs.getString("vl_unidade"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar hábito: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return habito;
    }

    public HabitoTO save(HabitoTO habito) {
        String sql = "insert into t_wmd_habito (nm_tipo, ds_habito, vl_unidade) values (?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, habito.getTipo());
            ps.setString(2, habito.getDescricao());
            ps.setString(3, habito.getUnidade());
            if (ps.executeUpdate() > 0) {
                return habito;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar hábito: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "delete from t_wmd_habito where id_habito = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar hábito: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public HabitoTO update(HabitoTO habito) {
        String sql = "update t_wmd_habito set nm_tipo = ?, ds_habito = ?, vl_unidade = ? where id_habito = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, habito.getTipo());
            ps.setString(2, habito.getDescricao());
            ps.setString(3, habito.getUnidade());
            ps.setLong(4, habito.getIdHabito());
            if (ps.executeUpdate() > 0) {
                return habito;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar hábito: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
