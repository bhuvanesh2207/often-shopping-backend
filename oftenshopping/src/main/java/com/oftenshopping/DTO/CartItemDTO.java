package com.oftenshopping.DTO;

public class CartItemDTO {

    private Long id; // cart_item id
    private Long productId; // product id
    private String customerName;
    private String productName;
    private String productImage;
    private double price;
    private int quantity;

    // Default constructor
    public CartItemDTO() {
        super();
    }

    // Parameterized constructor
    public CartItemDTO(Long id, Long productId, String customerName, String productName, String productImage,
                       double price, int quantity) {
        super();
        this.id = id;
        this.productId = productId; // Initialize productId
        this.customerName = customerName;
        this.productName = productName;
        this.productImage = productImage;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItemDTO [id=" + id + ", productId=" + productId + ", customerName=" + customerName
                + ", productName=" + productName + ", productImage=" + productImage + ", price=" + price + ", quantity="
                + quantity + "]";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
