/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudtiendita;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author chris
 */
public class clsArticulo {
    
    private String codigo;
    private String descripcion;
    private Double precio;
    private String cantidad;
    private Double venta;
    
    public clsArticulo(String codigo, String descripcion, Double precio, String cantidad, Double precioventa){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.venta = precioventa;
    }
    
    public String aTexto(){
        String articulo = this.codigo + "|" + this.descripcion + "|" + this.precio + "|" + this.cantidad + "|" + this.venta;
        return articulo;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public void guardar(){
        mArticulo article = new mArticulo();
        article.insertar(this.aTexto());
        System.out.println(this.aTexto());
    }
    
    public DefaultListModel<String> llenarLista(){
        mArticulo mArticle = new mArticulo();
        ArrayList<String> datos = mArticle.consultar();
        
        DefaultListModel<String> modelLista = new DefaultListModel<>();
        
        for (String registro: datos){
            modelLista.addElement(registro);
        }
        
        return modelLista;
    }
    
    public void actualizar(String newCodigo, String newDescripcion, String newPrecio){
        
        String nuevaLinea = newCodigo + "|" + newDescripcion + "|" + newPrecio;
        String lineaOriginal = this.codigo + "|" + this.descripcion + "|" + this.precio + "|" + this.cantidad + "|" + this.venta;
        
        System.out.println("Nuevos valores:" + nuevaLinea);
        System.out.println("Valores Originales:" + lineaOriginal);
        
        mArticulo mArticle = new mArticulo();
        mArticle.update(lineaOriginal, nuevaLinea, "Articulos.txt");
    }
    
    public void eliminar(){
        
        String lineaOriginal = this.codigo + "|" + this.descripcion + "|" + this.precio + "|" + this.cantidad + "|" + this.venta;
        
        System.out.println("Valores Originales:" + lineaOriginal);
        
        mArticulo mArticle = new mArticulo();
        mArticle.delete(lineaOriginal, "Articulos.txt");
    }  
}
    

