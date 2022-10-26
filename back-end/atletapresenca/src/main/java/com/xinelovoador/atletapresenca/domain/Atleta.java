package com.xinelovoador.atletapresenca.domain;

import java.util.Date;

public class Atleta {
    private int id;
    private String nomeCompleto;
    private Date dataNasciento;
    private String email;
    private String celular;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNasciento() {
        return dataNasciento;
    }

    public void setDataNasciento(Date dataNasciento) {
        this.dataNasciento = dataNasciento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
