package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] list = scan.nextLine().split(",");
    ArrayList<Integer> newList = new ArrayList<>(); 

    for (String x : list) {
      newList.add(Integer.valueOf(x));
    }

    for (int i = 0; i < newList.size()-1; i++) {
      for (int j = 0; j < newList.size()-1; j++) {
        if(newList.get(j) > newList.get(j+1)) {
          int temp = newList.get(j);
          newList.set(j, newList.get(j+1));
          newList.set(j+1, temp);
        }
      }
    }

    for (int i = 0; i < newList.size(); i++) {
      if(i == newList.size()-1) {
        System.out.print(newList.get(i));
      } else {
        System.out.print(newList.get(i) + ",");
      }
    }
  }
}
