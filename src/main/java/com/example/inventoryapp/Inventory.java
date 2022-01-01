package com.example.inventoryapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();




    public void addPart(Part newPart) {
        allParts.add(newPart);
    }
    public void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }
    public Part lookupPart(int partId) {
        for(Part p: allParts) {
            if (p.getId() == partId) {
                return p;
            }
        }
        return null;
    }
    public Product lookupProduct(int productId) {
        for(Product p: allProducts) {
            if(p.getId() == productId) {
                return p;
            }
        }
        return null;
    }
    public ObservableList<Part> lookupPart(String partName) {
        return allParts.filtered(part -> part.getName().contains(partName));
    }
    public ObservableList<Product> lookupProduct(String productName) {
        return allProducts.filtered(product -> product.getName().contains(productName));
    }
    public void updatePart(int index, Part selectedPart) {
        allParts.set(index,selectedPart);
        return;
    }
    public void updateProduct(int index, Product newProduct) {
        allProducts.set(index,newProduct);
        return;
    }
    public boolean deletePart(Part selectedPart) {
        return allParts.remove(selectedPart);
    }
    public boolean deleteProduct(Product selectedProduct) {
        return allProducts.remove(selectedProduct);
    }
    public ObservableList<Part> getAllParts() { return allParts; }
    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }


}
