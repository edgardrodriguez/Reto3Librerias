/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

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

            File archivo2 = new File("C:\\Users\\ZERO\\Documents\\pruebas\\doc.txt");
            File subcarpeta2 = new File("C:\\Users\\ZERO\\Documents\\pruebas\\sub");
            FileUtils.copyFileToDirectory(archivo2, subcarpeta2);
            System.out.println("copiado");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminar() {
        try {
            FileUtils.deleteDirectory(new File("C:\\Users\\ZERO\\Documents\\pruebas\\sub"));
            System.out.println("eliminado");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void limpiarDoc() {
        try {
            FileOutputStream writer = new FileOutputStream("C:\\Users\\ZERO\\Documents\\pruebas\\doc.txt");
            writer.write(("").getBytes());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void limpiarDocumento() {
        try {
            FileOutputStream writer = new FileOutputStream("C:\\Users\\ZERO\\Documents\\pruebas\\documento.txt");
            writer.write(("").getBytes());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String usingFilenameUtils(String text) {
        String path = "C:\\Users\\ZERO\\Documents\\pruebas\\documento.txt";
        text = "\nDireccion completa: " + FilenameUtils.getFullPath(path)
                + "\nDireccion relativa: " + FilenameUtils.getPath(path)
                + "\nPrefijo: " + FilenameUtils.getPrefix(path)
                + "\nExtension: " + FilenameUtils.getExtension(path)
                + "\nBase: " + FilenameUtils.getBaseName(path)
                + "\nNombre: " + FilenameUtils.getName(path);
        return text;
    }

    public static String usingLastModifiedFileComparator(String text) {
        //get the current directory
        File currentDirectory = new File("C:\\Users\\ZERO\\Documents\\pruebas");
        LastModifiedFileComparator comparator = new LastModifiedFileComparator();
        File[] sortedFiles = comparator.sort(currentDirectory.listFiles((FileFilter) FileFileFilter.FILE));
        System.out.println("Ordenado por fecha de última modificación: ");
        for (File file : sortedFiles) {
            System.out.println(file.getName() + ", Modificado en: " + new Date(file.lastModified()));
            text = file.getName() + ", Modificado en: " + new Date(file.lastModified());
        }
        return text;
    }
}
