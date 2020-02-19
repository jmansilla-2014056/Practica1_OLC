/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import models.Estado;
import models.Hoja;
import models.Node;

/**
 *
 * @author User
 */
public class Transiciones {
     
    Node raiz = new Node();
    ArrayList<Node> terminales = new ArrayList<>();
    ArrayList<Estado> estados = new ArrayList<>();
    ArrayList<Hoja> listHojas =  new ArrayList<>();
    ArrayList<ArrayList<Integer>> filtro = new ArrayList<>();
    
    public Transiciones(ArrayList<ArrayList<Integer>> lstHojas, ArrayList<Node> listNode, Node raiz){
        
        for(Node n: listNode){
            System.out.println("---------------------------------------------------------------------------");
            boolean agregar = terminales.stream().anyMatch(x -> x.getValue().getId() == n.getValue().getId() && x.getValue().getLexema().equals(n.getValue().getLexema()));
            if(!agregar){
                terminales.add(n);
            }
        }
        
        int contador = 0;
        for(ArrayList<Integer> siguietes: lstHojas){
            Hoja hoja = new Hoja();
            hoja.setNodo(listNode.get(contador));
            hoja.setFollows(siguietes);
            listHojas.add(hoja);
            contador++;
        }
        //Se inicia llenando transicion con los primeros de la raiz
        Estado estado1 = new Estado();
        estado1.setEstadoActual(raiz.getPrimeros());
        buscarTerminales(estado1);
        sacarTabla();  
       // System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
       // for(Estado estado: estados){
       //     System.out.println(estado.getEstadoActual() +"->" + estado.getEstadoSiguiente() +" con :" + estado.getTerminal().getValue().getLexema());
       // }
        
    }
    
    void buscarTerminales(Estado e){
        // Para cada estado sacamos todas las transiciones para cada terminal
        
        boolean pasar = estados.stream().anyMatch(x-> x.getEstadoActual().toString().equals(e.getEstadoActual().toString()));
        
        if(!pasar){
            
        ArrayList<Estado> matris = new ArrayList<>();
        
        for(Node n: terminales){
            Estado estado = new Estado();
            estado.setEstadoActual(e.getEstadoActual());
            estado.setTerminal(n);
            matris.add(estado);
        }
        
        for(Estado estado: matris){
                for(Integer i: estado.getEstadoActual()){
                    for(Hoja hoja : listHojas){
                        
                        if(i==hoja.getNodo().getNumeracion() 
                                && estado.getTerminal().getValue().getLexema().equals(hoja.getNodo().getValue().getLexema()) 
                                && estado.getTerminal().getValue().getId() == hoja.getNodo().getValue().getId() ){
                            
                            if(hoja.getNodo().getValue().getId()==35){
                                estado.setAceptacion(true);
                            }
                            
                            estado.getEstadoSiguiente().addAll(hoja.getFollows());
                            estado.noDuplicarYOrdenar();
    
                        }                   
                    }
                    estados.add(estado);
                    if(!estado.getEstadoSiguiente().isEmpty()){
                        Estado aux = new Estado();
                        aux.setEstadoActual(estado.getEstadoSiguiente());
                        buscarTerminales(aux);
                    }
                   
                }
            }
                              
        }
        
    }   
    
    public void sacarTabla(){
        for(Estado estado: estados){
            boolean agregar = filtro.stream().anyMatch(x -> x.toString().equals(estado.getEstadoActual().toString()));
            if(!agregar){
                filtro.add(estado.getEstadoActual());
            }
        }
        
        Estado[][] transiciones = new Estado[filtro.size()+1][terminales.size()+1];
        
        int x = 0;
        int y = 0;
       
        for(ArrayList<Integer> xx: filtro){
            y=0;
            for(Node yy: terminales){
                
                for(Estado es: estados){
                    if(xx.toString().equals(es.getEstadoActual().toString()) && yy.getValue().getLexema().equals(es.getTerminal().getValue().getLexema()) && yy.getValue().getId()==es.getTerminal().getValue().getId()){
                        transiciones[x][y]=es;
                        System.out.println( x + "," + y + " Estado:" + es.getEstadoActual().toString()+ " Estado siguiente:" + es.getEstadoSiguiente().toString() + ";"+ es.getTerminal().getValue().getLexema());
                        break;
                    }
                }
                
                y++;
            }
            x++;
        }
        
        
    }
    
    
    
    
    
}
