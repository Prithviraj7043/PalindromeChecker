import java.util.*;

public class PalindromeCheckerApp {


  public static boolean iterativePalindrome(String input) {
    String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    int start = 0;
    int end = normalized.length() - 1;

    while (start < end) {
      if (normalized.charAt(start) != normalized.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }


  public static boolean recursivePalindrome(String str, int start, int end) {
    if (start >= end) return true;

    if (str.charAt(start) != str.charAt(end)) return false;

    return recursivePalindrome(str, start + 1, end - 1);
  }


  public static boolean stackPalindrome(String input) {
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

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    long start1 = System.nanoTime();
    boolean result1 = iterativePalindrome(input);
    long end1 = System.nanoTime();
    long time1 = end1 - start1;


    long start2 = System.nanoTime();
    boolean result2 = recursivePalindrome(normalized, 0, normalized.length() - 1);
    long end2 = System.nanoTime();
    long time2 = end2 - start2;


    long start3 = System.nanoTime();
    boolean result3 = stackPalindrome(input);
    long end3 = System.nanoTime();
    long time3 = end3 - start3;

    System.out.println("\n----- Performance Results -----");
    System.out.println("Iterative Result: " + result1 + " | Time: " + time1 + " ns");
    System.out.println("Recursive Result: " + result2 + " | Time: " + time2 + " ns");
    System.out.println("Stack Result:     " + result3 + " | Time: " + time3 + " ns");

    scanner.close();
  }
}