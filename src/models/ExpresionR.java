/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ExpresionR {

    private String nombre;
    private ArrayList<Tokens> tokens;
    
    public ExpresionR() {
        tokens = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tokens> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Tokens> tokens) {
        this.tokens = tokens;
    }
    
    
    
    
}
