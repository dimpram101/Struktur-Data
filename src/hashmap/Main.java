package hashmap;

public class Main {
  public static void main(String[] args) {
    HashMap hashMap = new HashMap();

    hashMap.insert("Dimas", 34);
    hashMap.insert("Pramudya", 14);
    hashMap.insert("Strukdat B", 6);
    hashMap.insert("11211032", 10);

    hashMap.show();

    System.out.println("11211032".compareTo("Dimas"));

  }
}
