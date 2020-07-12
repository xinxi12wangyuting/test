package com.neusooft.entity;
import java.util.List;
public class Product {
    private int proId;
    private String sku;
    private String title;
    private List<OfferPrice> offerPrices;

    public Product(int proId, String sku, String title) {
        super();
        this.proId = proId;
        this.sku = sku;
        this.title = title;
    }
    public int getProId() {
        return proId;
    }
    public void setProId(int proId) {
        this.proId = proId;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<OfferPrice> getOfferPrices() {
        return offerPrices;
    }
    public void setOfferPrices(List<OfferPrice> offerPrices) {
        this.offerPrices = offerPrices;
    }

    @Override
    public String toString() {
        return "Student{" +
                "proId=" + proId +
                ", sku='" + sku + '\'' +
                ", title='" + title + '\'' +
                ", offerPrices=" + offerPrices +
                '}';
    }
}
