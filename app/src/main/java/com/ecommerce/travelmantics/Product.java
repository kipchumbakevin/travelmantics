package com.ecommerce.travelmantics;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity public class Product {
    @Id long id;

    String category,name,price,description,imageUri;

    //  int image;

    public Product(String category, String name, String price, String description, String image) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = image;
    }

    public Product() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return imageUri;
    }

    public void setImage(String image) {
        this.imageUri = image;
    }

}

