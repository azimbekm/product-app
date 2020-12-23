package com;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ProgramController {
    @FXML
    TextField productNameField;
    @FXML
    Label status;
    @FXML
    Label product1;
    @FXML
    Label product2;
    @FXML
    Label product3;
    @FXML
    Label product4;


    public void deleteAll(){
        DatabaseConnect databaseConnect = new DatabaseConnect();
        databaseConnect.resetDatabase();
        fetch();
        status.setText("Deleted all products from Database");
    }
    public void fetch(){
        DatabaseConnect databaseConnect = new DatabaseConnect();
        List<Product> products= databaseConnect.fetchProducts();
        try{
            product1.setText(products.get(0).getName());
            product2.setText(products.get(1).getName());
            product3.setText(products.get(2).getName());
            product4.setText(products.get(3).getName());
        }
        catch (IndexOutOfBoundsException ex){
            switch (products.size()){
                case 0: product1.setText("");
                case 1: product2.setText("");
                case 2: product3.setText("");
                case 3: product4.setText("");
            }
        }
    }
    public void addItem(){
        DatabaseConnect databaseConnect = new DatabaseConnect();
        databaseConnect.addProduct(new Product(productNameField.getText()));
        status.setText("Created new Product(" + productNameField.getText() + ")");
        fetch();
    }
}
