import java.util.*;

public class UseCase4PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        // Normalize string (optional)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Convert to char array
        char[] chars = normalized.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        // Two-pointer comparison
        while (start < end) {
            if (chars[start] != chars[end]) {
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
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}
