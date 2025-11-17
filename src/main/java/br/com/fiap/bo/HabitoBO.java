package br.com.fiap.bo;

import br.com.fiap.dao.HabitoDAO;
import br.com.fiap.to.HabitoTO;

import java.util.ArrayList;

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
