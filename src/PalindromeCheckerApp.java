import java.util.*;

public class PalindromeCheckerApp {

  // Node class
  static class Node {
    char data;
    Node next;

    Node(char data) {
      this.data = data;
      this.next = null;
    }
  }

  // Singly Linked List class
  static class SinglyLinkedList {
    Node head;

    // Convert string to linked list
    public void createList(String str) {
      for (char ch : str.toCharArray()) {
        append(ch);
      }
    }

    private void append(char data) {
      Node newNode = new Node(data);

      if (head == null) {
        head = newNode;
        return;
      }

      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }

    // Check palindrome
    public boolean isPalindrome() {
      if (head == null || head.next == null)
        return true;

      Node slow = head;
      Node fast = head;

      // Find middle using fast & slow pointer
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      // Reverse second half
      Node secondHalf = reverse(slow);

      Node firstHalf = head;
      Node tempSecond = secondHalf;

      // Compare halves
      while (tempSecond != null) {
        if (firstHalf.data != tempSecond.data) {
          return false;
        }
        firstHalf = firstHalf.next;
        tempSecond = tempSecond.next;
      }

      return true;
    }

    // Reverse linked list (in-place)
    private Node reverse(Node head) {
      Node prev = null;
      Node current = head;
      Node nextNode;

      while (current != null) {
        nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
      }

      return prev;
    }
  }

  // Main method
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    SinglyLinkedList list = new SinglyLinkedList();
    list.createList(input);

    if (list.isPalindrome()) {
      System.out.println("The string \"" + input + "\" is a Palindrome.");
    } else {
      System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
    }

    scanner.close();
  }
}