public class Main{
    // Method to find the longest palindromic substring
    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes
            int len1 = expandAroundCenter(s, i, i);
            // Check for even length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the maximum length between the two possibilities
            int len = Math.max(len1, len2);
            
            // Update the start and end indexes for the longest palindrome found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    // Helper method to expand around the center and return the length of the palindrome
    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    public static void main(String[] args) {
        // Test string
        String input = "thequickbrownfoxxofnworbquickthc";
        
        // Find the longest palindromic substring
        String longestPalindrome = longestPalindromicSubstring(input);
        
        // Output the result
        System.out.println("The given string is: " + input);
        System.out.println("The longest palindrome substring in the given string is: " + longestPalindrome);
        System.out.println("The length of the palindromic substring is: " + longestPalindrome.length());
    }
}
