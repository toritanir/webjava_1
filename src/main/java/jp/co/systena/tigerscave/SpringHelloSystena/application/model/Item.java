package jp.co.systena.tigerscave.SpringHelloSystena.application.model;

public class Item {

 // 名前
 private String name;
 private int price;

 public Item(){
};
 //getter.setter(name)
 public String getName() {
   return this.name;
 }
 public void setName(String name) {
   this.name = name;
 }
 //getter.setter(price)
 public int getPrice() {
   return price;
 }
 public void setPrice(int price) {
   this.price = price;
 }

}
