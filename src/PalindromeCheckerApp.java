import java.util.*;

public class PalindromeCheckerApp {

  // Recursive method to check palindrome
  public static boolean isPalindrome(String str, int start, int end) {

    // Base condition: if pointers cross or meet
    if (start >= end) {
      return true;
    }

    // If characters don't match
    if (str.charAt(start) != str.charAt(end)) {
      return false;
    }

    // Recursive call for next inner characters
    return isPalindrome(str, start + 1, end - 1);
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    boolean result = isPalindrome(input, 0, input.length() - 1);

    if (result) {
      System.out.println("The string \"" + input + "\" is a Palindrome.");
    } else {
      System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
    }

    scanner.close();
  }
}