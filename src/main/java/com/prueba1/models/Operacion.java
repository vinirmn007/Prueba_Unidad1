package com.prueba1.models;

import com.prueba1.stack.Stack;

public class Operacion {
    private Integer id;
    private String expresion1;
    private String expresion2;

    public Operacion() {
        this.id = 0;
        this.expresion1 = "";
        this.expresion2 = "";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpresion1() {
        return this.expresion1;
    }

    public void setExpresion1(String expresion1) {
        this.expresion1 = expresion1;
    }

    public String getExpresion2() {
        return this.expresion2;
    }

    public void setExpresion2(String expresion2) {
        this.expresion2 = expresion2;
    }

}
