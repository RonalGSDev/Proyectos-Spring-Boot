package com.sesion5.clase.Model;

public class PaisModel {
    
    private  String code;
    private String pais;

    public PaisModel(String code, String pais) {
        this.code = code;
        this.pais = pais;
    }

    public PaisModel() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
