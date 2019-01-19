package jp.co.systena.tigerscave.SpringHelloSystena.application.model;

import java.util.ArrayList;
import java.util.List;

public class ListService {
  //商品一覧表示
  public static List<Item> getItemlist(){
  
  List<Item> itemlist = new ArrayList<Item>();
  Item Protein = new Item();
  Item AbRoller = new Item();
  Item Dumbbell = new Item();
  Item Mat = new Item();
  
  Protein.createProtein();
  itemlist.add(Protein);
  AbRoller.createAbRoller();
  itemlist.add(AbRoller);
  Dumbbell.createDumbbell();
  itemlist.add(Dumbbell);
  Mat.createMat();
  itemlist.add(Mat);
  
  return itemlist;
  }
}
