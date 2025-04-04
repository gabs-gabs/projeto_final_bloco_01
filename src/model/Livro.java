package model;

import java.math.BigDecimal;

public class Livro extends Produto {
    private int stock;
    private String author, description;

    public Livro(int stock, String name, String author, String description, BigDecimal price) {
        super(name, price);
        this.stock = stock;
        this.author = author;
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "Nome='" + getName() + '\'' +
                ", Autor='" + author + '\'' +
                ", Descrição='" + description + '\'' +
                ", Preço=" + getPrice() +
                ", Estoque=" + stock +
                '}';
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void updateStock(int quantity, boolean reset) {
        if (reset) {
            this.stock = quantity;
        } else {
            this.stock += quantity;
            if (this.stock < 0) {
                this.stock = 0;
            }
        }
    }

    public boolean hasName(String name) {
        return this.getName().equalsIgnoreCase(name);
    }

    @Override
    public void displayDetails() {
        System.out.println(this.toString());
    }
}