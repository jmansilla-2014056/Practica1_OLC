/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author User
 */
public class Node {
    Tokens value; 
    int numeracion;
    Node left, right; 
    ArrayList<Integer> primeros;
    ArrayList<Integer> ultimos;
    boolean anulable;

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }
    

    public ArrayList<Integer> getPrimeros() {
        return primeros;
    }

    public void setPrimeros(int a) {
        this.primeros.add(a);
    }

    public ArrayList<Integer> getUltimos() {
        return ultimos;
    }

    public void setUltimos(int a) {
        this.ultimos.add(a);
    }
   
    
    
    public Tokens getValue() {
        return value;
    }

    public void setValue(Tokens value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    public void noDuplicar() {
        Set<Integer> cualquiernombre = new HashSet<>(this.primeros);
        Set<Integer> cualquiernombre2 = new HashSet<>(this.ultimos);
        this.primeros.clear();
        this.primeros.addAll(cualquiernombre);
        this.ultimos.clear();
        this.ultimos.addAll(cualquiernombre2);
    }
  
    public Node(Tokens item) { 
        value = item; 
        left = right = null; 
        primeros = new ArrayList<>();
        ultimos = new ArrayList<>();
    } 

    public Node() {
       
    }

  
}