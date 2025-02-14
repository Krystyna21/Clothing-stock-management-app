/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clothingstockmanagementapplication;

/**
 *
 * @author MA-MBI
 */
public class ClothingStockManagement {
   private int id;
    private String name;
    private String category;
    private String size;
    private String color;
    private int quantity;
    private double price; 
    
    public ClothingStockManagement (int id, String name, String category, String size, String color,int quantitu, double price){
        this.id = id;
        this.name = name;
        this.category =category;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    
    }
}
