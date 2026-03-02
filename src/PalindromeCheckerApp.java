import java.util.*;

public class PalindromeCheckerApp {

  // Method to check palindrome after normalization
  public static boolean isPalindrome(String input) {

    // Step 1: Normalize string
    // Remove all non-alphanumeric characters (including spaces)
    String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    int start = 0;
    int end = normalized.length() - 1;

    // Step 2: Apply two-pointer logic
    while (start < end) {
      if (normalized.charAt(start) != normalized.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    boolean result = isPalindrome(input);

    if (result) {
      System.out.println("The string \"" + input + "\" is a Palindrome (ignoring case and spaces).");
    } else {
      System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
    }

    scanner.close();
  }
}