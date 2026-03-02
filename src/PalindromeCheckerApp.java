import java.util.*;

// Step 1: Strategy Interface
interface PalindromeStrategy {
  boolean checkPalindrome(String input);
}

// Step 2: Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

  @Override
  public boolean checkPalindrome(String input) {

    String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    Deque<Character> stack = new ArrayDeque<>();

    for (char ch : normalized.toCharArray()) {
      stack.push(ch);
    }

    for (char ch : normalized.toCharArray()) {
      if (ch != stack.pop()) {
        return false;
      }
    }

    return true;
  }
}

// Step 3: Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

  @Override
  public boolean checkPalindrome(String input) {

    String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    Deque<Character> deque = new ArrayDeque<>();

    for (char ch : normalized.toCharArray()) {
      deque.add(ch);
    }

    while (deque.size() > 1) {
      if (!deque.pollFirst().equals(deque.pollLast())) {
        return false;
      }
    }

    return true;
  }
}

// Step 4: Context Class
class PalindromeContext {

  private PalindromeStrategy strategy;

  // Inject strategy at runtime
  public PalindromeContext(PalindromeStrategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(PalindromeStrategy strategy) {
    this.strategy = strategy;
  }

  public boolean execute(String input) {
    return strategy.checkPalindrome(input);
  }
}

// Step 5: Application Class
public class PalindromeCheckerApp {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Choose Strategy:");
    System.out.println("1. Stack Strategy");
    System.out.println("2. Deque Strategy");
    System.out.print("Enter choice (1 or 2): ");

    int choice = scanner.nextInt();
    scanner.nextLine(); // consume newline

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    PalindromeStrategy strategy;

    // Runtime selection
    if (choice == 1) {
      strategy = new StackStrategy();
    } else {
      strategy = new DequeStrategy();
    }

    PalindromeContext context = new PalindromeContext(strategy);

    boolean result = context.execute(input);

    if (result) {
      System.out.println("The string \"" + input + "\" is a Palindrome.");
    } else {
      System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
    }

    scanner.close();
  }
}