/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import static manejador.CrearDiagrama.creacionDibujo;
import models.Node;
import models.Tokens;

/**
 *
 * @author User
 */
public class Tree {
    String fileName;
    Node aux;
    public Node raiz = null;
    int index =0;
    ArrayList<Tokens> lista;
    
    public boolean esVacio(){
        return raiz == null;
    }

    public Tree(ArrayList<Tokens> lista)throws IOException, InterruptedException {
        this.lista = lista;
        raiz = operar();
     //   abb_report();
        
    }
    
    Node operar(){
        switch(lista.get(index).getId()){
            case 42:
                //*
                Node nodoPor = new Node(lista.get(index));
                index++;
                Node izqPor = operar();
                nodoPor.setLeft(izqPor);
                return nodoPor;
            case 43:
                //+
                Node nodoMas = new Node(lista.get(index));
                index ++;
                Node izqMas = operar();
                nodoMas.setLeft(izqMas);
                return nodoMas;
            case 46:
                //.
                Node nodoPunto = new Node(lista.get(index));
                index++;
                Node izqPunto = operar();
                Node derPunto = operar();
                nodoPunto.setLeft(izqPunto);
                nodoPunto.setRight(derPunto);
                return nodoPunto;
            case 63:
                //?
                Node nodoInt = new Node(lista.get(index));
                index++;
                Node izqInt = operar(); 
                nodoInt.setLeft(izqInt);
                return nodoInt;
                //|
            case 124:
                Node nodoOr = new Node(lista.get(index));
                index++;
                Node izqOr = operar();
                Node derOr = operar();
                nodoOr.setLeft(izqOr);
                nodoOr.setRight(derOr);
                return nodoOr;
                //Identificador
            case 32:
                Node nodeId = new Node(lista.get(index));
                index++;
                return nodeId;
                //Texto
            case 31:
                Node nodeCadena = new Node(lista.get(index));
                index++;
                return nodeCadena;
            default:
                return null;
        }
    }
    
    public void graficar(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {

            File miDir = new File (".");
            fileName = new SimpleDateFormat("yyyyMMddHHmmss''").format(new Date());
            fichero = new FileWriter(miDir.getAbsolutePath() + "//" + fileName+".txt");
            pw = new PrintWriter(fichero);

            pw.println("digraph {");
            pw.println("node [shape = rectangle, height=0.5, width=1.2];");
            
            Stack stack  = new Stack();
            Node current = this.raiz;
            while(true){
                if(current != null){
                    stack.push(current);
                    current = current.getLeft();
                }else if(!stack.empty()){
                    current = (Node) stack.pop();
                    int idea = 30;
                    if(current.getValue().getLexema().equals("|") || current.getValue().getLexema().equals(">")){
                         pw.println("\""+current.toString()+"\""+"[shape = record, label=\"{"+ "\\" +  current.getValue().getLexema() + "|" + current.getValue().getTipo() +"}\"]");
                    }else{
                        pw.println("\""+current.toString()+"\""+"[shape = record, label=\"{"+ current.getValue().getLexema() + "|" + current.getValue().getTipo() +"}\"]");
                    }
                    
                    
                    if(current.getRight()!=null){
                        pw.println("\""+current.toString()+"\""+"->"+"\""+current.getRight().toString()+"\"");           
                    }
                    if(current.getLeft()!=null){
                        pw.println("\""+current.toString()+"\""+"->"+"\""+current.getLeft().toString()+"\"");           
                    }
                    current = current.getRight();
                }else{
                    pw.println("}");
                    break;
                }
            }
            
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