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
public class Node {
    Tokens value; 
    
    Node left, right; 
    ArrayList<Integer> primeros;
    ArrayList<Integer> ultimos;

    public ArrayList<Integer> getPrimeros() {
        return primeros;
    }

    public void setPrimeros(ArrayList<Integer> primeros) {
        this.primeros = primeros;
    }

    public ArrayList<Integer> getUltimos() {
        return ultimos;
    }

    public void setUltimos(ArrayList<Integer> ultimos) {
        this.ultimos = ultimos;
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
    
  
  
    public Node(Tokens item) { 
        value = item; 
        left = right = null; 
        primeros = new ArrayList<>();
        ultimos = new ArrayList<>();
    } 

    public Node() {
       
    }

  
}
