package br.com.fiap.bo;

import br.com.fiap.dao.FeedbackDAO;
import br.com.fiap.to.FeedbackTO;

import java.util.ArrayList;

public class FeedbackBO {
    //atributos
    private FeedbackDAO feedbackDAO;
    //metodos particulares
    public ArrayList<FeedbackTO> findAll(){
        feedbackDAO = new FeedbackDAO();
        return feedbackDAO.findAll();
    }
    public FeedbackTO findById(Long id){
        feedbackDAO = new FeedbackDAO();
        return feedbackDAO.findById(id);
    }
    public FeedbackTO save(FeedbackTO feedback){
        feedbackDAO = new FeedbackDAO();
        return feedbackDAO.save(feedback);
    }
    public boolean delete(Long id){
        feedbackDAO = new FeedbackDAO();
        return feedbackDAO.delete(id);
    }
    public FeedbackTO update(FeedbackTO feedback){
        feedbackDAO = new FeedbackDAO();
        return feedbackDAO.update(feedback);
    }
}
