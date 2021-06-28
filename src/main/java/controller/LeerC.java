/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import services.Leer;

/**
 *
 * @author ZERO
 */
@Named(value = "LeerC")
@SessionScoped
public class LeerC implements Serializable{
    private String resultado="";
    private String resultado2="";
    private String ingresos;
    private String text;
    private String text1;
    public LeerC(){
    }
    public void leee(){
        resultado=Leer.lectura();
    }
    public void lee2(){
        resultado2=Leer.lectura2();
    }
    public void escribir(){
        Leer.escritura(text);
    }
    public void escribir2(){
        Leer.escritura2(text1);
    }
    public void copiar(){
        Leer.copiar();
    }
    public void eliminar(){
        Leer.eliminar();
    }
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    public void limpiarDoc(){
        Leer.limpiarDoc();
    }
    public void limpiarDocumento(){
        Leer.limpiarDocumento();
    }
    public String getResultado2() {
        return resultado2;
    }

    public void setResultado2(String resultado2) {
        this.resultado2 = resultado2;
    }

    public String getIngresos() {
        return ingresos;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }
    
}
