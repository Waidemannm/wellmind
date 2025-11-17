package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FeedbackTO {
    @NotNull
    private Long idFeedback;
    @NotNull
    private Long idUsuario;
    @NotNull
    private Long idResposta;
    @NotBlank
    private String mensagem;

    public FeedbackTO(){

    }

    public FeedbackTO(Long idFeedback, Long idUsuario, Long idResposta, String mensagem) {
        this.idFeedback = idFeedback;
        this.idUsuario = idUsuario;
        this.idResposta = idResposta;
        this.mensagem = mensagem;
    }

    public Long getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Long idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
