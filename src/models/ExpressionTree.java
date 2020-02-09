/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack; 
import static manejador.CrearDiagrama.creacionDibujo;
/**
 *
 * @author User
 */
public class ExpressionTree {
    String fileName;
     // A utility function to check if 'c' 
    // is an operator 
  
    boolean isOperator(char c) { 
        if (c == '+' || c == '*'|| c == '.' || c == '?'|| c == '|') { 
            return true; 
        } 
        return false; 
    } 
  
    // Utility function to do inorder traversal 
    void inorder(Node t) { 
        if (t != null) { 
            inorder(t.left); 
            System.out.print(t.value + " "); 
            inorder(t.right); 
        } 
    } 
  
    
    public void graficar(Node t){
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
            Node current = t;
            while(true){
                if(current != null){
                    stack.push(current);
                    current = current.left;
                }else if(!stack.empty()){
                    current = (Node) stack.pop();
                    pw.println("\""+current.value+"\""+"[shape = record, label=\"{"+current.value+ "}\"]");
                    if(current.right!=null){
                        pw.println("\""+current.getArchivo().getNombreArchivo()+"\""+"->"+"\""+current.getHojaDerecha().getArchivo().getNombreArchivo()+"\"");           
                    }
                    if(current.getHojaIzquierda()!=null){
                        pw.println("\""+current.getArchivo().getNombreArchivo()+"\""+"->"+"\""+current.getHojaIzquierda().getArchivo().getNombreArchivo()+"\"");           
                    }
                    current = current.getHojaDerecha();
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
    
    
    // Returns root of constructed tree for given 
    // postfix expression 
    Node constructTree(char postfix[]) { 
        Stack<Node> st = new Stack(); 
        Node t, t1, t2; 
  
        // Traverse through every character of 
        // input expression 
        for (int i = 0; i < postfix.length; i++) { 
  
            // If operand, simply push into stack 
            if (!isOperator(postfix[i])) { 
                t = new Node(postfix[i]); 
                st.push(t); 
            } else // operator 
            { 
                t = new Node(postfix[i]); 
  
                // Pop two top nodes 
                // Store top 
                t1 = st.pop();      // Remove top 
                t2 = st.pop(); 
  
                //  make them children 
                t.right = t1; 
                t.left = t2; 
  
                // System.out.println(t1 + "" + t2); 
                // Add this subexpression to stack 
                st.push(t); 
            } 
        } 
  
        //  only element will be root of expression 
        // tree 
        t = st.peek(); 
        st.pop(); 
  
        return t; 
    }
}
