/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static manejador.CrearDiagrama.creacionDibujo;
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
    Estado[][] matris = null;
    
    String fileName = "";
    
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
                            
                            estado.getEstadoSiguiente().addAll(hoja.getFollows());
                            
                            if(estado.getEstadoSiguiente().toString().contains(String.valueOf(listHojas.size()-1))){
                                estado.setAceptacion(true);
                            }
                            
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
        
        Estado[][] transiciones = new Estado[filtro.size()][terminales.size()];
        
        int x = 0;
        int y = 0;
       
        //FILTRO ES ARRAYLIST DE ENTEROS DE TODOS LOS ESTADOS POSIBLES
        for(ArrayList<Integer> xx: filtro){
            y=0;
            // ES UNA LISTA DE LOS TERMINALES 
            for(Node yy: terminales){
                // ES UNA LISTA DEL ESTADO ACTAUAL ; SIGUIENTE Y SU TERMINAL
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
       matris = transiciones;
        
    }
    
    public void reporte(){
        Graficartable(matris);
    }
    
     public void Graficartable(Estado[][] transiciones){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            
        File miDir = new File (".");
        fileName = new SimpleDateFormat("yyyyMMddHHmmss''").format(new Date());
        fichero = new FileWriter(miDir.getAbsolutePath() + "//" + fileName + ".txt");
        pw = new PrintWriter(fichero);

            String filas="<TD>\n Estado </TD>\n";
            for(Node yy: terminales){
                if(yy.getValue().getId()!=35){
                    filas = filas + "<TD>\n"+yy.getValue().getLexema().replaceAll(">", "&#62;").replaceAll("<","&#60;")+"</TD>\n";
                }
                
            }
        
        
            pw.println("digraph test {\n" +
                    "    graph [ratio=fill];\n" +
                    "    node [label=\"\\N\", fontsize=15, shape=plaintext];\n" +
                    "    arset [label=<\n" +
                    "        <TABLE ALIGN=\"LEFT\">\n" +
                    "            <TR>\n" +
                    
                    filas +
                              
                    "            </TR>");

            int count = -1;
            for(int x=0; x<transiciones.length; x++){
                pw.println("<TR>\n");
                count++;
                    pw.println("<TD>");
                    pw.println(transiciones[x][0].getEstadoActual().toString());
                    pw.println("</TD>");
                for(int y=0; y<transiciones[x].length-1; y++){
                    Estado estado = new Estado();
                    System.out.println(x+","+y);
                    estado.setEstadoSiguiente(transiciones[x][y].getEstadoSiguiente());
                    estado.setAceptacion(transiciones[x][y].isAceptacion());
                    pw.println("<TD>");
                    if(estado.isAceptacion()){
                          pw.println(estado.getEstadoSiguiente().toString().replaceAll("[.]","-")+"*");
                    }else{
                          pw.println(estado.getEstadoSiguiente().toString().replaceAll("[.]","-"));
                    }
                  
                    pw.println("</TD>");
                }
                    
                    
                pw.println("</TR>\n");
              
                   
            }

            pw.println(" </TABLE>\n" +
                    "    >, ];\n" +
                    "}");


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero)
                        fichero.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            //Llamar a la funcion que sacara la grafica del codigo ejecutado
            creacionDibujo(fileName);
        }
    
    
    
    
    
}
