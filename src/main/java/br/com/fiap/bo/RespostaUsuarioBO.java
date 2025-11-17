package br.com.fiap.bo;


import br.com.fiap.dao.RespostaUsuarioDAO;
import br.com.fiap.to.RespostaUsuarioTO;

import java.util.ArrayList;

public class RespostaUsuarioBO {
    //atributos
    private RespostaUsuarioDAO respostaUsuarioDAO;
    //metodos particulares
    public ArrayList<RespostaUsuarioTO> findAll(){
        respostaUsuarioDAO = new RespostaUsuarioDAO();
        return respostaUsuarioDAO.findAll();
    }
    public RespostaUsuarioTO findById(Long id){
        respostaUsuarioDAO = new RespostaUsuarioDAO();
        return respostaUsuarioDAO.findById(id);
    }
    public RespostaUsuarioTO save(RespostaUsuarioTO respostaUsuario){
        respostaUsuarioDAO = new RespostaUsuarioDAO();
        return respostaUsuarioDAO.save(respostaUsuario);
    }
    public boolean delete(Long id){
        respostaUsuarioDAO = new RespostaUsuarioDAO();
        return respostaUsuarioDAO.delete(id);
    }
    public RespostaUsuarioTO update(RespostaUsuarioTO respostaUsuario){
        respostaUsuarioDAO = new RespostaUsuarioDAO();
        return respostaUsuarioDAO.update(respostaUsuario);
    }
}
