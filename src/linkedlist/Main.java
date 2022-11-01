package linkedlist;
public class Main {
  public static void main(String[] args) {
    Queue que = new Queue();

    que.push(9);
    que.push(10);
    que.push(8);

    que.pop();

    que.showAll();

    // System.out.println("Apakah Stack bisa di POP: " + que.hasPop());
  }
}
