/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ZERO
 */
public class Leer {

    public static String lectura() {
        String contenido = "";
        int c;
        try {
            FileReader fr = new FileReader("C:\\Users\\ZERO\\Documents\\pruebas\\documento.txt");
            while ((c = fr.read()) != -1) {
                contenido += (char) c;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\nel contenido es: " + contenido);
        return contenido;
    }

    public static String lectura2() {
        String content = null;
        try {
            content = FileUtils.readFileToString(new File("C:\\Users\\ZERO\\Documents\\pruebas\\doc.txt"), "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return content;
    }

    public static String escritura(String text) {

        try {
            List<String> lines = new ArrayList<String>();
            lines.add(text);
            FileUtils.writeLines(new File("C:\\Users\\ZERO\\Documents\\pruebas\\doc.txt"), lines, true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;
    }

    public static String escritura2(String text1) {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\ZERO\\Documents\\pruebas\\documento.txt");
            byte codigos[] = text1.getBytes();
            fos.write(codigos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text1;
    }

    public static void copiar() {
        try {
            File archivo1 = new File("C:\\Users\\ZERO\\Documents\\pruebas\\documento.txt");
            File subcarpeta = new File("C:\\Users\\ZERO\\Documents\\pruebas\\sub");
            FileUtils.copyFileToDirectory(archivo1, subcarpeta);
            System.out.println("copiado");
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void eliminar (){
        try {
        FileUtils.deleteDirectory(new File ("C:\\Users\\ZERO\\Documents\\pruebas\\sub"));
        System.out.println("eliminado");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
