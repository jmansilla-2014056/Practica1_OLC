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
import java.util.Collections;
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
    
    ArrayList<ArrayList<Integer>> lstHojas = new ArrayList<ArrayList<Integer>>();
    ArrayList<Node> listNode = new ArrayList<>();
    ArrayList<Tokens> lista;
    public Node raiz = null;
     public String nombreArbol;
    int contadorHoja =-1;
    int index =0;
    String fileName;
    Node aux;
    
    
    public boolean esVacio(){
        return raiz == null;
    }

    public Tree(ArrayList<Tokens> lista, String nombreArbol)throws IOException, InterruptedException {
        this.lista = lista;
        raiz = operar();
        this.nombreArbol = nombreArbol;
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
                nodoPor.setAnulable(true);
                nodoPor.getPrimeros().addAll(izqPor.getPrimeros());
                nodoPor.getUltimos().addAll(izqPor.getUltimos());
                for (int x: izqPor.getUltimos()) {
                    for (int y: izqPor.getPrimeros()) {
                    lstHojas.get(x).add(y);
                }
                }
                return nodoPor;
            case 43:
                //+
                Node nodoMas = new Node(lista.get(index));
                index ++;
                Node izqMas = operar();
                nodoMas.setLeft(izqMas);
                if(izqMas.isAnulable()){
                    nodoMas.setAnulable(true);
                }else{
                    nodoMas.setAnulable(false);
                }
                nodoMas.getPrimeros().addAll(izqMas.getPrimeros());
                nodoMas.getUltimos().addAll(izqMas.getUltimos());
                for (int x: izqMas.getUltimos()) {
                    for (int y: izqMas.getPrimeros()) {
                    lstHojas.get(x).add(y);
                }
                }
                return nodoMas;
            case 46:
                //.
                Node nodoPunto = new Node(lista.get(index));
                index++;
                Node izqPunto = operar();
                Node derPunto = operar();
                nodoPunto.setLeft(izqPunto);
                nodoPunto.setRight(derPunto);
                if (izqPunto.isAnulable() && derPunto.isAnulable()) {
                    nodoPunto.setAnulable(true);
                }else{
                    nodoPunto.setAnulable(false);
                }
                if (izqPunto.isAnulable()) {
                    nodoPunto.getPrimeros().addAll(izqPunto.getPrimeros());
                    nodoPunto.getPrimeros().addAll(derPunto.getPrimeros());
                }else{
                    nodoPunto.getPrimeros().addAll(izqPunto.getPrimeros());
                }
                if (derPunto.isAnulable()) {
                nodoPunto.getUltimos().addAll(izqPunto.getUltimos());
                nodoPunto.getUltimos().addAll(derPunto.getUltimos());
                }else{
                    nodoPunto.getUltimos().addAll(derPunto.getUltimos());
                }
                for (int x: izqPunto.getUltimos()) {
                    for (int y: derPunto.getPrimeros()) {
                    lstHojas.get(x).add(y);
                }
                }
                nodoPunto.noDuplicar();
                return nodoPunto;
            case 63:
                //?
                Node nodoInt = new Node(lista.get(index));
                index++;
                Node izqInt = operar(); 
                nodoInt.setLeft(izqInt);
                nodoInt.setAnulable(true);
                nodoInt.getPrimeros().addAll(izqInt.getPrimeros());
                nodoInt.getUltimos().addAll(izqInt.getUltimos());
                return nodoInt;
                //|
            case 124:
                Node nodoOr = new Node(lista.get(index));
                index++;
                Node izqOr = operar();
                Node derOr = operar();
                nodoOr.setLeft(izqOr);
                nodoOr.setRight(derOr);
                if (izqOr.isAnulable() || derOr.isAnulable()) {
                    nodoOr.setAnulable(true);
                }else{
                    nodoOr.setAnulable(false);
                }
                nodoOr.getPrimeros().addAll(izqOr.getPrimeros());
                nodoOr.getPrimeros().addAll(derOr.getPrimeros());
                nodoOr.getUltimos().addAll(izqOr.getUltimos());
                nodoOr.getUltimos().addAll(derOr.getUltimos());
                nodoOr.noDuplicar();
                return nodoOr;
                //Identificador
            case 32:
                Node nodeId = new Node(lista.get(index));
                nodeId.setAnulable(false);
                contadorHoja++;
                nodeId.setNumeracion(contadorHoja);
                nodeId.setPrimeros(nodeId.getNumeracion());
                nodeId.setUltimos(nodeId.getNumeracion());
                index++;
                nodeId.noDuplicar();
                lstHojas.add(new ArrayList<Integer>()); //*
                listNode.add(nodeId);
                return nodeId;
                //Texto
            case 31:
                Node nodeCadena = new Node(lista.get(index));
                nodeCadena.setAnulable(false);
                
                index++;
                contadorHoja++;
                nodeCadena.setNumeracion(contadorHoja);
                nodeCadena.setPrimeros(nodeCadena.getNumeracion());
                nodeCadena.setUltimos(nodeCadena.getNumeracion());
                lstHojas.add(new ArrayList<Integer>()); //*
                nodeCadena.noDuplicar();
                listNode.add(nodeCadena);
                return nodeCadena;
            default:
                return null;
        }
        
    }
    
    public void graficar(){
                System.out.println(lstHojas.toString());
            System.out.println("--------------------------------------}*****************************************-----------------------------------------------------");
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
                         pw.println("\""+current.toString()+"\""+"[shape = record, label=\"{"+ "\\" +  current.getValue().getLexema()
                                 +"|P:"+current.getPrimeros().toString()
                                 +"|U:"+current.getUltimos().toString()
                                 
                                 + "|" + current.getValue().getTipo()+"; Anulavidad:"+current.isAnulable() +"}\"]");
                    }else{
                        pw.println("\""+current.toString()+"\""+"[shape = record, label=\"{"+ current.getValue().getLexema()
                                +"|P:"+current.getPrimeros().toString()
                                +"|U:"+current.getUltimos().toString()
                                +"|" + current.getValue().getTipo()+"; Anulavidad:"+current.isAnulable() +"}\"]");
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
    
        
    
    public void follows(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {

        File miDir = new File (".");
        fileName = new SimpleDateFormat("yyyyMMddHHmmss''").format(new Date());
        fichero = new FileWriter(miDir.getAbsolutePath() + "//" + fileName + ".txt");
        pw = new PrintWriter(fichero);


            pw.println("digraph test {\n" +
                    "    graph [ratio=fill];\n" +
                    "    node [label=\"\\N\", fontsize=15, shape=plaintext];\n" +
                    "    arset [label=<\n" +
                    "        <TABLE ALIGN=\"LEFT\">\n" +
                    "            <TR>\n" +
                    "                <TD>Hoja</TD>\n" +
                    "                <TD>#Hoja</TD>\n" +
                    "\t      <TD>Siguientes</TD>\n" +
                    "            </TR>");

            int count = -1;
            for(ArrayList<Integer> u: this.lstHojas){
                count++;
                
                    pw.println("<TR>");
                    pw.println("<TD>");

                        pw.println(this.listNode.get(count).getValue().getLexema().replaceAll(">", "&#62;").replaceAll("<","&#60;"));

                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println(String.valueOf(count));
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println(u.toString());
                    pw.println("</TD>");
                    pw.println("</TR>");
              
                   
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