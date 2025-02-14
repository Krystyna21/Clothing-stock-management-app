/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clothingstockmanagementapplication;


/**
 *
 * @author MA-MBI
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ClothingStockGUI extends JFrame{
    private JTextField idField, nameField, categoryField, sizeField, colorField, quantityField, priceField;
    private JButton addButton, viewButton;
    private JTextArea outputArea;
    private int id;
    public ClothingStockGUI() {
       setTitle("Clothing Stock Management");
       setSize(700, 400);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout( new BorderLayout());
       
       JPanel inputPanel = new JPanel(new GridLayout(7,2));
       inputPanel.add(new JLabel("ID:"));
       idField = new JTextField();
       inputPanel.add(idField);
       
       inputPanel.add(new JLabel("Name:"));
       nameField = new JTextField();
       inputPanel.add(nameField);
              
       inputPanel.add(new JLabel("Category:"));
       categoryField = new JTextField();
       inputPanel.add(categoryField);
              
       inputPanel.add(new JLabel("Size:"));
       sizeField = new JTextField();
       inputPanel.add(sizeField);
               
       inputPanel.add(new JLabel("Color:"));
       colorField = new JTextField();
       inputPanel.add(colorField);
               
       inputPanel.add(new JLabel("Quantity:"));
       quantityField = new JTextField();
       inputPanel.add(quantityField);
               
       inputPanel.add(new JLabel("Price:"));
       priceField = new JTextField();
       inputPanel.add(priceField);
               
       addButton = new JButton("Add Item");
       viewButton = new JButton("View Stock");
               
       outputArea = new JTextArea();
       outputArea.setEditable(false);
               
       add(inputPanel, BorderLayout.NORTH);
       add(new JScrollPane(outputArea),BorderLayout.CENTER);
       JPanel buttonPanel = new JPanel();
       buttonPanel.add(addButton);
       buttonPanel.add(viewButton);
       add(buttonPanel, BorderLayout.SOUTH);
               
       addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             addItem();
           }
       });
        viewButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStock();
            }
        });
}
    private void addItem() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String category = categoryField.getText();
        String size = sizeField.getText();
        String color = colorField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());
        
        try(Connection conn = DatabaseConnection.getConnection()){
            String query = "INSERT INTO clothing_stock (id, name, category, size, color, quantity, price) VALUES (?,?, ?, ?, ?, ?, ?)";
                     PreparedStatement pstmt = conn.prepareStatement(query);
                     pstmt.setInt(1, id);   
                     pstmt.setString(2, name);
                     pstmt.setString(3, category);
                     pstmt.setString(4, size);
                     pstmt.setString(5, color);
                     pstmt.setInt(6, quantity);
                     pstmt.setDouble(7, price);
                     pstmt.executeUpdate();
                     JOptionPane.showMessageDialog(this, "Item added successfully!");
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     private void viewStock() {
         outputArea.setText("");
         try (Connection conn = DatabaseConnection.getConnection()){
                 String query = "SELECT * FROM clothing_stock";
                 PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery();
                           while (rs.next()){
                               outputArea.append("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Category: " + rs.getString("category") + ", Size: " + rs.getString("size") + ", Color: " + rs.getString("color") + ", Quantity: " + rs.getInt("quantity")+ ", Price: $" + rs.getDouble("price") + "\n");
         }
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
}
   public static void main(String[] args)
   {
       SwingUtilities.invokeLater(()->
       {
           new ClothingStockGUI().setVisible(true);
       });
   }        

    private ActionListener newActionListener() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
