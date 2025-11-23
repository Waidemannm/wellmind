package br.com.fiap.to;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RespostaUsuarioTO {
    private Long idResposta;
    @NotNull
    private Long idUsuario;
    @NotNull
    private Long idHabito;


    private int resposta;
    private String observacoes;

    public RespostaUsuarioTO() {

    }

    public RespostaUsuarioTO(Long idResposta, Long idUsuario, Long idHabito, int resposta, String observacoes) {
        this.idResposta = idResposta;
        this.idUsuario = idUsuario;
        this.idHabito = idHabito;
        this.resposta = resposta;
        this.observacoes = observacoes;
    }

    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdHabito() {
        return idHabito;
    }

    public void setIdHabito(Long idHabito) {
        this.idHabito = idHabito;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
