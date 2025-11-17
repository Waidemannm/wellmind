package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UsuarioTO {
    @NotNull
    @Positive
    private Long idUsuario;
    @NotBlank
    private String nome;
    @NotNull
    @Positive
    private int idade;
    @NotBlank
    //fazer regra de negocio na BO de check
    private String genero;
    @NotBlank
    //fazer regra de negocio tmb
    private String email;

    public UsuarioTO() {
    }

    public UsuarioTO(Long idUsuario, String nome, int idade, String genero, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.email = email;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
