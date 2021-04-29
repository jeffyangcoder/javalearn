package com.ecc.javalanguage.dbconnect.preparedstatement.bean;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/4/29-15:44
 */
public class OrderItems {
    private int id;
    private int count;
    private double amount;
    private String title ;
    private String author;
    private double price;
    private String imgPath;
    private String orderId;

    public OrderItems() {
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "id=" + id +
                ", count=" + count +
                ", amount=" + amount +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", imgPath='" + imgPath + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderItems(int id, int count, double amount, String title, String author, double price, String imgPath, String orderId) {
        this.id = id;
        this.count = count;
        this.amount = amount;
        this.title = title;
        this.author = author;
        this.price = price;
        this.imgPath = imgPath;
        this.orderId = orderId;
    }
}
