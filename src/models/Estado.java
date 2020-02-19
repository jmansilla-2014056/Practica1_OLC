/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author User
 */
public class Estado {
    
    private Node terminal;
    private ArrayList<Integer> estadoActual;
    
    private ArrayList<Integer> EstadoSiguiente;
   
    private boolean aceptacion;

    public Estado(){
        estadoActual = new ArrayList<>();
         EstadoSiguiente = new ArrayList<>();
        aceptacion = false;
    }
    
    public ArrayList<Integer> getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(ArrayList<Integer> estadoActual) {
        this.estadoActual = estadoActual;
    }

    public ArrayList<Integer> getEstadoSiguiente() {
        return EstadoSiguiente;
    }

    public void setEstadoSiguiente(ArrayList<Integer> EstadoSiguiente) {
        this.EstadoSiguiente = EstadoSiguiente;
    }

    

    public Node getTerminal() {
        return terminal;
    }

    public void setTerminal(Node terminal) {
        this.terminal = terminal;
    }

    public boolean isAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(boolean aceptacion) {
        this.aceptacion = aceptacion;
    }
    
    
    public void noDuplicarYOrdenar() {
        Set<Integer> cualquiernombre = new HashSet<>(this.EstadoSiguiente);
        this.EstadoSiguiente.clear();
        this.EstadoSiguiente.addAll(cualquiernombre);
        Collections.sort(this.EstadoSiguiente); 
    }
    
}
