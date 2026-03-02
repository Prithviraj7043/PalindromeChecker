import java.util.*;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        // Normalize string (optional)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Step 1: Enqueue & Push characters
        for (char ch : normalized.toCharArray()) {
            queue.add(ch);    // FIFO
            stack.push(ch);   // LIFO
        }

        // Step 2: Compare dequeue vs pop
        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
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
