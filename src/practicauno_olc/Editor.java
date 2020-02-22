/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicauno_olc;

import automatas.Tree;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import manejador.CrearHtml;
import manejador.ManejarToken;
import models.Biblioteca;
import models.Tokens;
import models.Trampa;

/**
 *
 * @author User
 */
public class Editor extends javax.swing.JFrame {
    static String temporal = " ";
    static String cadena = null;
    ArrayList<Tree> treeList = new ArrayList<>();
    
    public static void addError(Tokens t, String espera) {
        listaErrores.add(new Trampa(t.getLexema(), espera , t.getFila(),t.getColumna()));
    }
    
    Highlighter h;
    String concatenar="";
    int estado;
    int contador = 0;
    ArrayList<Tokens> listaTokens = new ArrayList<>();
    ArrayList<Biblioteca> listaPalabras = new ArrayList<>();
    public static Collection<Trampa> listaErrores = new ArrayList<>();   
    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jText = new javax.swing.JTextArea();
        jAceptar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboER = new javax.swing.JComboBox<>();
        jButtonA = new javax.swing.JButton();
        jButtonF = new javax.swing.JButton();
        jButtonT = new javax.swing.JButton();
        jAbout = new javax.swing.JMenuBar();
        jNuevo = new javax.swing.JMenu();
        jNew = new javax.swing.JMenuItem();
        jAbrir = new javax.swing.JMenuItem();
        jGuardar = new javax.swing.JMenuItem();
        jGuardarC = new javax.swing.JMenuItem();
        jSalir = new javax.swing.JMenuItem();
        jHelp = new javax.swing.JMenu();
        jMenuAbout = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jText.setColumns(20);
        jText.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jText.setRows(5);
        jScrollPane2.setViewportView(jText);

        jAceptar.setText("Analizar");
        jAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAceptarActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar Colores");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboER.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jButtonA.setText("Arbol");
        jButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAActionPerformed(evt);
            }
        });

        jButtonF.setText("Follows");
        jButtonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFActionPerformed(evt);
            }
        });

        jButtonT.setText("Transiciones");
        jButtonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTActionPerformed(evt);
            }
        });

        jNuevo.setText("File");

        jNew.setText("Nuevo");
        jNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewActionPerformed(evt);
            }
        });
        jNuevo.add(jNew);

        jAbrir.setText("Abrir");
        jAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAbrirActionPerformed(evt);
            }
        });
        jNuevo.add(jAbrir);

        jGuardar.setText("Guardar");
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });
        jNuevo.add(jGuardar);

        jGuardarC.setText("Guardar Como");
        jGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarCActionPerformed(evt);
            }
        });
        jNuevo.add(jGuardarC);

        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });
        jNuevo.add(jSalir);

        jAbout.add(jNuevo);

        jHelp.setText("Help");

        jMenuAbout.setText("About");
        jMenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAboutActionPerformed(evt);
            }
        });
        jHelp.add(jMenuAbout);

        jAbout.add(jHelp);

        setJMenuBar(jAbout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonF, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jButtonA, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jComboER, 0, 136, Short.MAX_VALUE)
                    .addComponent(jButtonT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboER, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonF, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButtonT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void jAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAceptarActionPerformed
     listaPalabras.clear();
     //Llenar biblioteca con palabras reservadas   
     listaPalabras.add(new Biblioteca(1,"CONJ",Color.CYAN));
                     
     //limpiar       
       concatenar = "";
       contador=0; 
       h = jText.getHighlighter();
       h.removeAllHighlights();
       listaTokens.clear();
       listaErrores.clear();
       
     //Empieza a analizar     
    generador();    
    
    // ArrayList<Pokedex> arraypokedex= ManejarToken.HacerNiveles(listaTokens);
    ManejarToken mt = new ManejarToken();
    this.treeList = mt.Parser(listaTokens);
 
    if(listaErrores.size()>0){        
        CrearHtml.ErroresHtml((ArrayList<Trampa>) listaErrores);    
    }else{
            CrearHtml.tokensHtml(listaTokens);
            
            for(Tree t : this.treeList){
               this.jComboER.addItem(t.nombreArbol);
            }
            
    }    
        
    }//GEN-LAST:event_jAceptarActionPerformed
    
    //Acccion guardar
    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        guardarM();
    }//GEN-LAST:event_jGuardarActionPerformed

    //Accion limpiar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        h.removeAllHighlights();
    }//GEN-LAST:event_jButton1ActionPerformed

    //Accion Abrir
    private void jAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAbrirActionPerformed
         FileNameExtensionFilter filtro = new FileNameExtensionFilter(null, "er");
                    JFileChooser buscador = new JFileChooser();
                    buscador.setFileFilter(filtro); 
                    buscador.addChoosableFileFilter(filtro);
                    buscador.showOpenDialog(buscador);    
                    
                    String patch  = buscador.getSelectedFile().getAbsolutePath();
                    if(patch.endsWith(".er") | patch.endsWith(".ER") ){
                        try {
                        FileReader archivo = new FileReader(patch);
                        BufferedReader br = new BufferedReader(archivo);
                       String line = br.readLine();                     
                       jText.setText(null);
                        while(line != null){
                            try{
                                jText.setText(jText.getText()+"\n"+line);
                                line = br.readLine();
                            }catch(IOException x){
                                 JOptionPane.showMessageDialog(null, "No se pudo agregar: " + x);
                            }
                        }
                       jText.setText(jText.getText().replaceFirst("\n", ""));
                       cadena = patch;
                       temporal = jText.getText();
                    } catch (FileNotFoundException ex) {
                                        
                    } catch (IOException ex) {
                        
                    } 
            }else{
                        JOptionPane.showMessageDialog(null, "No se puedo leer el archivo, verfique la ");
                    }        
    }//GEN-LAST:event_jAbrirActionPerformed

    //Guardar Como
    private void jGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarCActionPerformed
       guardarC();
    }//GEN-LAST:event_jGuardarCActionPerformed

    //Accion Nuevo
    private void jNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewActionPerformed
        if(!temporal.equals(jText.getText())){
                    int x =  JOptionPane.showConfirmDialog(null, "Deseas guardar los cambios?");
                    if(x == 0){
                        guardarM();
                        cadena = null;
                        jText.setText(null);
                    }else if(x==1){
                        cadena = null;
                        jText.setText(null);
                    }
                    }else{
                        cadena = null;
                        jText.setText(null);
                }
    }//GEN-LAST:event_jNewActionPerformed

    //salir
    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
         if(!temporal.equals(jText.getText())){
                    int x =  JOptionPane.showConfirmDialog(null, "Deseas guardar los cambios?");
                    if(x == 0){
                        guardarM();
                        cadena = null;
                        jText.setText(null);
                    }else if(x==1){
                        cadena = null;
                        jText.setText(null);
                    }
                    }else{
                        cadena = null;
                        jText.setText(null);
                }
         System.exit(0);
    }//GEN-LAST:event_jSalirActionPerformed

    private void jMenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAboutActionPerformed
        JOptionPane.showMessageDialog(null,"Universidad de San Carlos de Guatemala"+"\n"+"Febrero 2020"+ "\n" + "OCL1" + "\n"+ "Seccion A" + "\n" +"Jesús Alejandro Mansilla Villatoro" + "\n" + "201709396" );                
    }//GEN-LAST:event_jMenuAboutActionPerformed

    private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAActionPerformed
        try{
            this.treeList.get(this.jComboER.getSelectedIndex()).graficar();
        }catch(Exception x){
            
        }
        
    }//GEN-LAST:event_jButtonAActionPerformed

    private void jButtonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFActionPerformed
          try{
            this.treeList.get(this.jComboER.getSelectedIndex()).follows();
        }catch(Exception x){
            
        }
    }//GEN-LAST:event_jButtonFActionPerformed

    private void jButtonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTActionPerformed
         this.treeList.get(this.jComboER.getSelectedIndex()).transiciones.reporte();
    }//GEN-LAST:event_jButtonTActionPerformed
 
    
    //Concatenar hasta encontrar un espacio, un espacio o dos puntos
    private void generador(){
        jText.setText(jText.getText() + " ");
        boolean aceptado = false;
        
        char[] analizar = jText.getText().toCharArray(); 
        for(int x = 0; x < analizar.length; x++){
         switch(analizar[x]){
             //Salto de linea: no importa solo paso al siguiente
             case '\n':
                  contador++;
                  x = contador;
                  break;
             //Espacio: no importa solo paso al siguiente     
             case ' ':
                  contador++;
                  x = contador;
                  break;
             case '\t':
                 contador++;
                 x = contador;                 
                 break;
             //Guardar 2 puntos y pintar signo   
             case '>':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],">", "Mayor", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.BLUE);
                 break;
              case '<':          
                 contador = x;
                 if(analizar[x+1] == '!'){
                     try{
                         pintar(contador,contador+1, Color.GRAY);
                         pintar(contador,contador+2, Color.GRAY);
                         contador=contador+2;
                         comentario();            
                         pintar(contador,contador+1, Color.GRAY);
                         pintar(contador-1,contador+1, Color.GRAY);
                        x=contador;
                        break;
                     }catch(Exception p){ 
                        System.out.println("cccccc");
                        listaErrores.add(new Trampa(concatenar,"No pertenece al lenguaje",obtenerFila(contador-1),obtenerColumna(contador-1)));            
                        concatenar="";  
                        contador--;                     
                    }
                        
                 }else{
                    listaTokens.add(new Tokens((int) analizar[x],"<", "Menor", obtenerFila(contador), obtenerColumna(contador)));            
                    pintar(contador,contador+1, Color.MAGENTA);
                 }
                 contador++;
                 break;
              case '{':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],"{", "Abrir Llaves", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break;
              case '}':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],"}", "Cerrar Llaves", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break;
              case '/':          
                     contador = x;
                 if(analizar[x+1] == '/'){
                     try{
                         pintar(contador,contador+1, Color.GRAY);
                        contador=contador +2;
                        comentarioL();            
                        pintar(contador,contador+1, Color.GRAY);
                        x=contador;
                        break;
                     }catch(Exception p){ 
                        System.out.println("cccccc");
                        listaErrores.add(new Trampa(concatenar,"No pertenece al lenguaje",obtenerFila(contador-1),obtenerColumna(contador-1)));            
                        concatenar="";  
                        contador--;                     
                    }
                        
                 }else{
                    listaTokens.add(new Tokens((int) analizar[x],"/", "barra", obtenerFila(contador), obtenerColumna(contador)));            
                    pintar(contador,contador+1, Color.MAGENTA);
                 }
                 contador++;
                 break;
              case '.':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],".", "Punto", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break;         
            //Guardar comilla y pintar
             case '"':
                 contador = x;
              //   listaTokens.add(new Tokens(23, "\"", "Comillas", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.GREEN);
                 contador++;
                 cadena();
              //   listaTokens.add(new Tokens(23,"\"", "Comillas", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.GREEN);
                 x=contador;
                 break;
                 
             case '|':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],"|", "OR", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break;   
             case ',':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],",", "Coma", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break;   
              
             case '%':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],"%", "Porcentaje", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break;
             case '+':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],"+", "Mas", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break; 
             case '-':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],"-", "Menos", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break; 
             case '*':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],"*", "Asterisco", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break; 
             case '?':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],"?", "Interrogacion", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break; 
             case '~':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],"~", "Virgulilla", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break; 
             case ':':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],":", "Dos Puntos", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break; 
             case ';':          
                 contador = x;
                 listaTokens.add(new Tokens((int) analizar[x],";", "Punto y coma", obtenerFila(contador), obtenerColumna(contador)));            
                 pintar(contador,contador+1, Color.MAGENTA);
                 break; 

             case '0':
             case '1':
             case '2':
             case '3':
             case '4':
             case '5':
             case '6':
             case '7':
             case '8':
             case '9':
                 contador = x;
                 numero();
                 x=contador;
                 break;
             case 'a':
             case 'b':
             case 'c':
             case 'd':
             case 'e':
             case 'f':
             case 'g':
             case 'h':
             case 'i':
             case 'j':
             case 'k':
             case 'l':
             case 'm':
             case 'n':
             case 'o':
             case 'p':
             case 'q':
             case 'r':
             case 's':
             case 't':
             case 'u':
             case 'v':
             case 'w':
             case 'x':
             case 'y':
             case 'z':
             case 'A':
             case 'B':
             case 'C':
             case 'D':
             case 'E':
             case 'F':
             case 'G':
             case 'H':
             case 'I':
             case 'J':
             case 'K':
             case 'L':
             case 'M':
             case 'N':
             case 'O':
             case 'P':
             case 'Q':
             case 'R':
             case 'S':
             case 'T':
             case 'U':
             case 'V':
             case 'W':
             case 'X':
             case 'Y':
             case 'Z':    
                 contador = x;
                 palabra();
                 x=contador;
                 break;
             default:
                 if((int) analizar[x] >= 33 && (int) analizar[x] <=  125 ){
                       contador=x;
                       listaTokens.add(new Tokens((int) analizar[x],String.valueOf(analizar[x]), "Simbolo", obtenerFila(contador), obtenerColumna(contador)));            
                       pintar(contador,contador+1, Color.MAGENTA);
                 }else{
                     System.out.println("aaaaa");
                     contador=x;
                     listaErrores.add(new Trampa(String.valueOf(analizar[x]),"No pertenece al lenguaje",obtenerFila(contador),obtenerColumna(contador)));
                 }
                 
            }           
        }
    }
    
    //Capturar palabras que pertenecen y palabras que no, un try catch capturaria un error sintactico
    private void palabra(){
        try{
        if(Character.isLetter(jText.getText().charAt(contador)) || Character.isDigit(jText.getText().charAt(contador))){
            concatenar = concatenar + String.valueOf(jText.getText().charAt(contador));
            contador++;
            palabra();
        }else{
            Biblioteca palabra = listaPalabras.stream().filter(p -> p.getPalabra().toLowerCase().equals(concatenar.toLowerCase())).findAny().orElse(null);
            if(palabra!=null){
                listaTokens.add(new Tokens(palabra.getId(), palabra.getPalabra(), "Palabra Reservada", obtenerFila(contador-1), obtenerColumna(contador-1)));
                pintar(contador-concatenar.length(),contador, palabra.getColor());
            }else{
                System.out.println("bbbbb");
                listaTokens.add(new Tokens(32, concatenar, "Identificador", obtenerFila(contador-1), obtenerColumna(contador-1)));
                pintar(contador-concatenar.length(),contador, Color.ORANGE);
            }
            concatenar = "";
            contador--;
        }
        }catch(Exception x){ 
            System.out.println("cccccc");
            listaErrores.add(new Trampa(concatenar,"No pertenece al lenguaje",obtenerFila(contador-1),obtenerColumna(contador-1)));            
            concatenar="";  
            contador--;
            
        }
    }
    //Metodo para obtener cadenas  //Un try catch aqui , donde nunca viene " seria un error sintactico
    private void cadena() {
        try{
        if(jText.getText().charAt(contador) != '"'){
            concatenar = concatenar + String.valueOf(jText.getText().charAt(contador));
            contador++;
            cadena();
        }else{
            //Agregar y pintar: Se resta uno por que estamos en las comillas que cierran.
            listaTokens.add(new Tokens(31,concatenar, "Texto", obtenerFila(contador-1), obtenerColumna(contador-1)));            
            //pintar el texto: A este contador no se suma uno porque queremos agarrar el ultimo caracter antes de la comilla
            pintar(contador-concatenar.length()-1,contador, Color.GREEN);
            concatenar="";    
        }  
        }catch(Exception x){        
            System.out.println("eeeeeee");
            listaErrores.add(new Trampa(concatenar,"Ocurrio un error con una cadena",obtenerFila(contador-1),obtenerColumna(contador-1)));            
            concatenar="";   
            contador--;
        }
    } 
    
    private void comentarioL() {
        try{
        if(jText.getText().charAt(contador) != '\n'){
            concatenar = concatenar + String.valueOf(jText.getText().charAt(contador));
            contador++;
            comentarioL();
        }else{
            //Agregar y pintar: Se resta uno por que estamos en las comillas que cierran.
            // listaTokens.add(new Tokens(31,concatenar, "Texto", obtenerFila(contador-1), obtenerColumna(contador-1)));            
            //pintar el texto: A este contador no se suma uno porque queremos agarrar el ultimo caracter antes de la comilla
            pintar(contador-concatenar.length()-1,contador, Color.GRAY);
            concatenar="";    
        }  
        }catch(Exception x){        
            System.out.println("eeeeeee");
            listaErrores.add(new Trampa(concatenar,"Ocurrio un error con un comentario",obtenerFila(contador-1),obtenerColumna(contador-1)));            
            concatenar="";   
            contador--;
        }
    } 
    
    private void comentario() {
        try{
        if(jText.getText().charAt(contador) != '!'){
            concatenar = concatenar + String.valueOf(jText.getText().charAt(contador));
            contador++;
            comentario();
        }else{
            if(jText.getText().charAt(contador+1) == '>'){
                //pintar: Se resta uno por que estamos en !.
                pintar(contador-concatenar.length()-1,contador, Color.GRAY);
                contador++;
                concatenar=""; 
            }else{
                contador++;
                comentario();
            }
               
        }  
        }catch(Exception x){        
            System.out.println("eeeeeee");
            listaErrores.add(new Trampa(concatenar,"Ocurrio un error en un comentario",obtenerFila(contador-1),obtenerColumna(contador-1)));            
            concatenar="";   
            contador--;
        }
    } 
     //Metodo para obetener numeros, un try catch  
    private void numero(){        
        if(Character.isDigit(jText.getText().charAt(contador))){
        concatenar = concatenar + String.valueOf(jText.getText().charAt(contador));
        contador++;
        numero();
        }else{            
            listaTokens.add(new Tokens(30,concatenar, "Numero", obtenerFila(contador-1), obtenerColumna(contador-1)));            
            //pintar el texto: A este contador no se suma uno porque queremos agarrar el ultimo caracter antes de la comilla
            pintar(contador-concatenar.length(),contador, Color.RED);
            concatenar="";
            contador--;
        }
    }
    
     private int obtenerFila(int index){
         int x = -1;
         int y = 0;
     for(char c: jText.getText().toCharArray()){
         x++;
         if(c == '\n' & index > x){
                y++;                
            }         
        }
     return y;
     }
     
     private int obtenerColumna(int index){         
        int x = 0;
        int y = 0;
     for(char c: jText.getText().toCharArray()){
         x++;

         if(c == '\n' &  index+1 > x){
                y = x;
            }
         
         
        }
         
     return index-y;
     }
     
     public void pintar(int inicio, int fin, Color c){
        try {
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(c);        
            h.addHighlight(inicio, fin, highlightPainter);
        } catch (BadLocationException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }         
     }
       
     void guardarC(){
         try {
                FileWriter fichero1 = null;
                PrintWriter pw1 = null;
                JFileChooser buscador1 = new JFileChooser();
                buscador1.showSaveDialog(null);
                String ruta = buscador1.getSelectedFile().getAbsolutePath();
                fichero1 = new FileWriter(ruta.replace(".er","")+".er");
                cadena = ruta.replace(".er","")+".er";
                pw1 = new PrintWriter(fichero1);                
                String[] escribe = jText.getText().split("\n");
                    for(String  e: escribe){
                        pw1.println(e);
                    }
                    fichero1.close();
                    temporal = jText.getText();
                    Path path = Paths.get(cadena);
                } catch (IOException ex) {
                    
                }
    }
    
     void guardarM(){
              if(cadena != null){
                try {
                    FileWriter fichero2 = new FileWriter(cadena);
                    PrintWriter pw2 = null;
                    pw2 = new PrintWriter(fichero2);
                    String[] escribe2 = jText.getText().split("\n");
                    for(String  e: escribe2){
                    pw2.println(e);
                            }
                        fichero2.close();
                        JOptionPane.showMessageDialog(null, "Se realizaron los cambios");
                        temporal = jText.getText();
                           } catch (IOException ex) {
                             
                           }
            }else{
                guardarC();
        }        
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Editor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jAbout;
    private javax.swing.JMenuItem jAbrir;
    private javax.swing.JButton jAceptar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonF;
    private javax.swing.JButton jButtonT;
    private javax.swing.JComboBox<String> jComboER;
    private javax.swing.JMenuItem jGuardar;
    private javax.swing.JMenuItem jGuardarC;
    private javax.swing.JMenu jHelp;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuItem jNew;
    private javax.swing.JMenu jNuevo;
    private javax.swing.JMenuItem jSalir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jText;
    // End of variables declaration//GEN-END:variables

   
    
}
