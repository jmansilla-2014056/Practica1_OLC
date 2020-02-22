/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import automatas.Tree;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.ExpresionR;
import models.Tokens;
import practicauno_olc.Editor;

/**
 *
 * @author User
 */
public class ManejarToken {
    static ArrayList<Tokens> listaTokens = new ArrayList<>();
    ArrayList<Tokens> arbol = new ArrayList<>();
    ArrayList<Tree> treeList = new ArrayList<>();;
    String nombreEr="";
    int y=0;
    int x=-1;
    Tokens token;
    
    public ArrayList<Tree> Parser(ArrayList<Tokens> LT) {
        listaTokens = LT; 
         LLavesI(consumir());
         return treeList;
    }
    
    public Tokens consumir(){
        x++;
        if(x <= listaTokens.size()){
            return listaTokens.get(x);
        }else{
            return null;
        }
        
    } 
    
    void LLavesI(Tokens t){
        if(t.getId() == 123){
            ConjOrId(consumir());
        }
        else{
            Editor.addError(t, "Se esperaba {");
        }        
    }
  
    void ConjOrId(Tokens t){
        if(t.getId()==1){
            dosPuntos(consumir());
        }else if(t.getId()==32){
            this.nombreEr = t.getLexema();
            guionE(consumir());
        }
        else if(t.getId()==37){
            y=1;
            virg(consumir());
            
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        else{
            Editor.addError(t, "Se esperaba CONJ, Identificador o %");
        }
    }
    
    
    void virg(Tokens t){       
        if(y==4){
            val();
        }else{
            if(t.getId()==37){
            y++;
            virg(consumir());
            
            }else{
                Editor.addError(t, "Se esperaba %");
            }
        }
        
    }
    
    void val(){
        while(true){
            Tokens t = consumir();
            if(t.getLexema().equals("}")){
                break;
            }else{
                if(t.getLexema().equals(";")){
                    Random rd = new Random();
                  JOptionPane.showMessageDialog(null, "lexema " + String.valueOf(rd.nextBoolean()));   
                }
            }
        }
    }
    
    void guionE (Tokens t){
        if(t.getId() == 45){
            mayorE(consumir());
        }else{
            Editor.addError(t, "Se esperaban >");
        }    
    }
    
    void mayorE (Tokens t){
        if(t.getId() == 62){
            arbol.add(new Tokens(46,".", "Punto", 0, 0));
            expresion(consumir());
        }else{
            Editor.addError(t, "Se esperaban :");
        }    
    }
    
    void expresion(Tokens t){
        while(t.getId() != 59){
            if(t.getId() != 123){
                if(t.getId() != 125){
                    arbol.add(t);                   
                }
            }
            t=consumir();
        }
            arbol.add(new Tokens(35,"#", "Numeral", 0, 0));
      //  arbol.add(0,new Tokens(46,".", "Punto", 0,0));
      //  arbol.add(new Tokens(35,"\"#\"","acpetacion",0,0));
            for(Tokens a: this.arbol){
                System.out.println(a.getLexema());
            }
            
       
        Tree tree;
        try {
            tree = new Tree(arbol,this.nombreEr);
          //  tree.graficar();
            ExpresionR er = new ExpresionR();
            
            er.setNombre(nombreEr);
            er.setTokens(arbol);
            this.treeList.add(tree);
            arbol.clear();
        } catch (IOException ex) {
            Logger.getLogger(ManejarToken.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ManejarToken.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.out.println("-----------------------------------------------------");
        ConjOrId(consumir());
    }
            
    void dosPuntos(Tokens t){
        if(t.getId() == 58){
            id(consumir());
        }else{
            Editor.addError(t, "Se esperaban :");
        }    
    }
    
    void id(Tokens t){
        if(t.getId() == 32){
            guion(consumir());
        }else{
            Editor.addError(t, "Se esperaban id");
        }    
    }
    
    void guion(Tokens t){
        if(t.getId() == 45){
            mayor(consumir());
        }else{
            Editor.addError(t, "Se esperaban -");
        }    
    }
    
    void mayor(Tokens t){
        if(t.getId() == 62){
            idOrNumOrSymbol(consumir());
        }else{
            Editor.addError(t, "Se esperaban >");
        }    
    }
    
     void  idOrNumOrSymbol(Tokens t){
        if(t.getId() == 32){
            VirOrComaOrPunto0(consumir());
        }else if(t.getId() == 30){
            VirOrComaOrPunto1(consumir());
        }else if(t.getId() >= 33 && t.getId() <= 125){
            VirOrComaOrPunto2(consumir());
        }
        else{
            Editor.addError(t, "Se esperaban id o numero o simbolos validos");
        }    
    }
     
     void VirOrComaOrPunto0(Tokens t){
        //viene punto y coma?
        if(t.getId() == 59){
            ConjOrId(consumir());
        //Viene ,?    
        }else if(t.getId() == 44){
            id1(consumir());
        //Viene ~?
        }else if(t.getId() == 126){
            id2(consumir());
        }
        else{
            Editor.addError(t, "Se esperaban >");
        }    
    }
     
     void VirOrComaOrPunto1(Tokens t){
        //viene punto y coma?
        if(t.getId() == 59){
            ConjOrId(consumir());
        //Viene ,?    
        }else if(t.getId() == 44){
            num1(consumir());
        //Viene ~?
        }else if(t.getId() == 126){
            num2(consumir());
        }
        else{
            Editor.addError(t, "Se esperaban >");
        }    
    }
     
     
     void VirOrComaOrPunto2(Tokens t){
        //viene punto y coma?
        if(t.getId() == 59){
            ConjOrId(consumir());
        //Viene ,?    
        }else if(t.getId() == 44){
           symbol1(consumir());
        //Viene ~?
        }else if(t.getId() == 126){
           symbol2(consumir());
        }
        else{
            Editor.addError(t, "Se esperaban >");
        }    
    }
     
     
     void comaOrPunto0(Tokens t){
        //viene punto y coma?
        if(t.getId() == 59){
            ConjOrId(consumir());
        //Viene ,?    
        }else if(t.getId() == 44){
            id1(consumir());
        }else{
            Editor.addError(t, "Se esperaban , o ;");
        }    
    }
     
    void comaOrPunto1(Tokens t){
        //viene punto y coma?
        if(t.getId() == 59){
            ConjOrId(consumir());
        //Viene ,?    
        }else if(t.getId() == 44){
            num1(consumir());
       
        }else{
            Editor.addError(t, "Se esperaban , o ;");
        }    
    } 
    
     void comaOrPunto2(Tokens t){
        //viene punto y coma?
        if(t.getId() == 59){
            ConjOrId(consumir());
        //Viene ,?    
        }else if(t.getId() == 44){
            symbol1(consumir());
       
        }else{
            Editor.addError(t, "Se esperaban , o ;");
        }    
    } 
     
    void id1(Tokens t){
        if(t.getId() == 32){
             comaOrPunto0(consumir());
        }else{
            Editor.addError(t, "Se esperaban id");
        }    
    }
    
    void id2(Tokens t){
        if(t.getId() == 32){
             puntoYcoma(consumir());
        }else{
            Editor.addError(t, "Se esperaban id");
        }    
    }
    
    void num1(Tokens t){
        if(t.getId() == 30){
             comaOrPunto1(consumir());
        }else{
            Editor.addError(t, "Se esperaban numero");
        }    
    }
    
    void num2(Tokens t){
        if(t.getId() == 30){
             puntoYcoma(consumir());
        }else{
            Editor.addError(t, "Se esperaban numero");
        }    
    }
    
    void symbol1(Tokens t){
        if(t.getId() >= 33 && t.getId() <= 125){
             comaOrPunto2(consumir());
        }else{
            Editor.addError(t, "Se esperaban simbolo valido");
        }    
    }
    
    void symbol2(Tokens t){
        if(t.getId() >= 33 && t.getId() <= 125){
             puntoYcoma(consumir());
        }else{
            Editor.addError(t, "Se esperaban simbolo valido");
        }    
    }
    
     void puntoYcoma(Tokens t){
        if(t.getId() == 59){
             ConjOrId(consumir());
        }else{
            Editor.addError(t, "Se esperaba ;");
        }    
    }
     
     
}
