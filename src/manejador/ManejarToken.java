/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.util.ArrayList;
import jdk.nashorn.internal.parser.Token;
import models.Tokens;
import practicauno_olc.Editor;

/**
 *
 * @author User
 */
public class ManejarToken {
    static ArrayList<Tokens> listaTokens = new ArrayList<>();
    int x=-1;
    Tokens token;
    
    public void MetodoArbol(ArrayList<Tokens> LT) {
        listaTokens = LT; 
         LLavesI(consumir());
            
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
            Conj(consumir());
        }else{
            Editor.addError(t, "Se esperaba {");
        }        
    }
  
    void Conj(Tokens t){
        if(t.getId()==1){
            dosPuntosPosConj(consumir());
        }else{
            Editor.addError(t, "Se esperaba CONJ");
        }
    }
            
    
    void dosPuntosPosConj(Tokens t){
        if(t.getId() == 58){
            identificador(consumir(),t);
        }else{
            Editor.addError(t, "Se esperaban :");
        }    
    }
    
    void identificador(Tokens t, Tokens a){
        if(t.getId() == 32){
            switch(a.getId()){
            //Caso de que el anterior fueran :
                case 58:
                    guion(consumir());
                    break;
                case 62:
                    virgulillaOcoma(consumir());
                    break;
            //Caso de que el anterior fuera >
            }
        }else{
            Editor.addError(t, "Se esperaba un identificador");
        }   
    }
    
    void guion(Tokens t){
         if(t.getId() == 45){
            mayor(consumir());
        }else{
            Editor.addError(t, "Se esperaba -");
        }   
    }
    
    void mayor(Tokens t){
        if(t.getId() == 62){
            identificador(consumir(),t);
        }else{
            Editor.addError(t, "Se esperaba >");
        } 
    }
    
    void virgulillaOcoma(Tokens t){
        
    }
     
   
     
}
