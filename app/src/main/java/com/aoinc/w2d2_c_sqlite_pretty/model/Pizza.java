package com.aoinc.w2d2_c_sqlite_pretty.model;

public class Pizza {
    private String pizzaFlavor;
    private double pizzaPrice;
    private int calories;
    private String ingredients;
    private String imageURL;

    public Pizza(String pizzaFlavor, double pizzaPrice, int calories, String ingredients, String imageURL) {
        this.pizzaFlavor = pizzaFlavor;
        this.pizzaPrice = pizzaPrice;
        this.calories = calories;
        this.ingredients = ingredients;
        this.imageURL = imageURL;
    }

    public String getPizzaFlavor() {
        return pizzaFlavor;
    }
    public void setPizzaFlavor(String pizzaFlavor) {
        this.pizzaFlavor = pizzaFlavor;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }
    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
