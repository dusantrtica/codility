package linkedlists;

public class App {

  public static void doubleLinkedListDemo() {
    DoubleLinkedList<String> names = new DoubleLinkedList<>();
    names.insert("Dusan1");
    names.insert("Dusan2");
    names.insert("Dusan3");
    names.insert("Dusan4");
    names.traverseForward();
    System.out.println("----- removing mid one -----");
    names.remove("Dusan3");
    names.traverseForward();
    System.out.println("---- removing last one----");
    names.remove("Dusan4");
    names.traverse(e -> {
      System.out.println(e);
    });
    System.out.println("------remove first one----");
    names.remove("Dusan1");
    names.traverseForward();
    System.out.println("----- removing last one ----");
    names.remove("Dusan2");
    names.traverseForward();
  }

  public static void linkedListDemo() {
    LinkedList<String> names = new LinkedList<>();
    names.insert("Adam");
    names.insert("Daniel");
    names.insert("Ana");
    names.traverse();

    System.out.println("-------------");
    names.remove("Daniel");
    names.traverse();
  }

  public static void midElemenet() {
    LinkedList<String> names = new LinkedList<>();
    names.insert("Adam");
    names.insert("Daniel");
    names.insert("Ana");

    System.out.println(names.midElement());
  }

  public static void main(String[] args) {
    midElemenet();
  }
}
// RCpTohmxyp19VegVB9pUd8qqbq66vko1