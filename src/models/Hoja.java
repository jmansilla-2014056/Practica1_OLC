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
public class Hoja {
    private Node nodo;
    private ArrayList<Integer> follows;

    public Hoja(){
        follows = new ArrayList<>();
    }
    
    public Node getNodo() {
        return nodo;
    }

    public void setNodo(Node nodo) {
        this.nodo = nodo;
    }

    public ArrayList<Integer> getFollows() {
        return follows;
    }

    public void setFollows(ArrayList<Integer> follows) {
        this.follows = follows;
    }
    
    
    
    
}
