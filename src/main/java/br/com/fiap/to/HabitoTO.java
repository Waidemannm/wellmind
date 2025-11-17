package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HabitoTO {
    @NotNull
    private Long idHabito;
    @NotBlank
    //fazer regra de negocio na BO de check
    private String tipo;
    @NotBlank
    private String descricao;
    @NotBlank
    //fazer regra de negocio na BO de check
    private String unidade;

    public HabitoTO() {
    }

    public HabitoTO(Long idHabito, String tipo, String descricao, String unidade) {
        this.idHabito = idHabito;
        this.tipo = tipo;
        this.descricao = descricao;
        this.unidade = unidade;
    }

    public Long getIdHabito() {
        return idHabito;
    }

    public void setIdHabito(Long idHabito) {
        this.idHabito = idHabito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
