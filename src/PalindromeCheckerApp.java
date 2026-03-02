import java.util.*;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        // Normalize string (optional but recommended)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear until deque is empty or one element left
        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
