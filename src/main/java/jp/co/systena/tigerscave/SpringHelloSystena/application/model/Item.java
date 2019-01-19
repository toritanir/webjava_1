package jp.co.systena.tigerscave.SpringHelloSystena.application.model;

public class Item {

  // 名前
  private String name;
  private int price;

  public String getName() {
    return this.name;
  }
  // setter
  public void setName(String name) {
    this.name = name;
  }
  public int getPrice() {
    return price;
  }
  public void setprice(int price) {
    this.price = price;
  }
  


public void createProtein() {
  this.name = "プロテイン";
  this.price = 3000;
}
public void createAbRoller() {
  this.name = "腹筋ローラー";
  this.price = 1500;
}
public void createDumbbell() {
  this.name = "ダンベル";
  this.price = 2000;
}
public void createMat() {
  this.name = "ヨガマット";
  this.price = 2500;
}
}
