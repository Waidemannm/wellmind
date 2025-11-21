package br.com.fiap.bo;

import br.com.fiap.dao.HabitoDAO;
import br.com.fiap.to.HabitoTO;

import java.util.ArrayList;
import java.util.List;

public class HabitoBO {
    //atributos
    private HabitoDAO habitoDAO;
    //metodos particulares
    public ArrayList<HabitoTO> findAll(){
        habitoDAO = new HabitoDAO();
        return habitoDAO.findAll();
    }
    public HabitoTO findById(Long id){
        habitoDAO = new HabitoDAO();
        return habitoDAO.findById(id);
    }
    public HabitoTO save(HabitoTO habito){
        habitoDAO = new HabitoDAO();
        String tipo = habito.getTipo().trim().toUpperCase();
        String unidade = habito.getUnidade().trim().toUpperCase();
        List<String> tiposValidos = List.of(
                "SONO",
                "HIDRATAÇÃO",
                "ALIMENTAÇÃO",
                "HUMOR E ENERGIA",
                "ESTRESSE E FOCO",
                "OBSERVAÇÕES"
        );
        if (!tiposValidos.contains(tipo)) {
            throw new RuntimeException("Tipo de hábito inválido. Valores aceitos: " + tiposValidos);
        }
        List<String> unidadesValidas = List.of(
                "HORAS",
                "LITROS",
                "REFEIÇÕES",
                "ESCALA",
                "TEXTO LIVRE"
        );
        if (!unidadesValidas.contains(unidade)) {
            throw new RuntimeException("Unidade inválida. Valores aceitos: " + unidadesValidas);
        }
        habito.setTipo(tipo);
        habito.setUnidade(unidade);
        return habitoDAO.save(habito);
    }
    public boolean delete(Long id){
        habitoDAO = new HabitoDAO();
        return habitoDAO.delete(id);
    }
    public HabitoTO update(HabitoTO habito){
        habitoDAO = new HabitoDAO();
        return habitoDAO.update(habito);
    }
}
