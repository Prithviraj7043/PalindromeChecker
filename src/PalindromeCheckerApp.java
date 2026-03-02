import java.util.*;

// Service class following OOPS principles
class PalindromeChecker {

  // Public method exposed to client
  public boolean checkPalindrome(String input) {

    if (input == null) {
      return false;
    }

    // Normalize string (ignore spaces & case)
    String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    // Using Stack (ArrayDeque)
    Deque<Character> stack = new ArrayDeque<>();

    // Push all characters into stack
    for (char ch : normalized.toCharArray()) {
      stack.push(ch);
    }

    // Compare characters
    for (char ch : normalized.toCharArray()) {
      if (ch != stack.pop()) {
        return false;
      }
    }

    return true;
  }
}

// Application class
public class UseCase11PalindromeCheckerApp {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    // Encapsulation: Logic handled by service class
    PalindromeChecker checker = new PalindromeChecker();

    boolean result = checker.checkPalindrome(input);

    if (result) {
      System.out.println("The string \"" + input + "\" is a Palindrome.");
    } else {
      System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
    }

    scanner.close();
  }
}