package com.neusooft.entity;
import java.util.Date;
public class OfferPrice {
    private int ofpId;
    private Date EffetiveStartDate;
    private Date EffetiveEndDate;
    private int proId;
    private String price;
    private String typeCd;
    public OfferPrice(int anInt, String string, double aDouble) {
        super();
    }
    public OfferPrice(int anInt, String string, String resultSetString, int resultSetInt, java.sql.Date date, double aDouble, double resultSetDouble, int setInt){
    }
    public OfferPrice(int ofpId, Date effetiveStartDate, Date effetiveEndDate, int proId, String price, String typeCd) {
        this.ofpId = ofpId;
        EffetiveStartDate = effetiveStartDate;
        EffetiveEndDate = effetiveEndDate;
        this.proId = proId;
        this.price = price;
        this.typeCd = typeCd;
    }
    public int getOfpId() {
        return ofpId;
    }
    public void setOfpId(int ofpId) {
        this.ofpId = ofpId;
    }
    public Date getEffetiveStartDate() {
        return EffetiveStartDate;
    }
    public void setEffetiveStartDate(Date effetiveStartDate) {
        EffetiveStartDate = effetiveStartDate;
    }
    public Date getEffetiveEndDate() {
        return EffetiveEndDate;
    }
    public void setEffetiveEndDate(Date effetiveEndDate) {
        EffetiveEndDate = effetiveEndDate;
    }
    public int getProId() {
        return proId;
    }
    public void setProId(int proId) {
        this.proId = proId;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getTypeCd() {
        return typeCd;
    }
    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }
    @Override
    public String toString() {
        return "Emp{" +
                "ofpId=" + ofpId +
                ", EffetiveStartDate=" + EffetiveStartDate +
                ", EffetiveEndDate=" + EffetiveEndDate +
                ", proId=" + proId +
                ", price='" + price + '\'' +
                ", typeCd='" + typeCd + '\'' +
                '}';
    }
}
