package com.learn;

public class 对象数组手机jBean {
    private  String Brand;
    private  int Price;
    private  String Color;

    public 对象数组手机jBean(){

    }
    public 对象数组手机jBean(String Brand, int Price, String Color) {
        this.Brand = Brand;
        this.Price = Price;
        this.Color = Color;
    }
    public void setBrand(String Brand){
        this.Brand = Brand;
    }
    public void setPrice(int Price ){
        this.Price= Price;
    }
    public void setColor(String Color){
        this.Color = Color;
    }
    public String getBrand(){
        return Brand;
    }
    public int getPrice(){
        return Price;
    }
    public String getColor(){
        return Color;
    }
}
