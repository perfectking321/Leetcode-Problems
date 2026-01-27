import java.util.Scanner;
class Solution {


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int original = x;
        int reversed = 0;
        
        while (x != 0) {
            int lastDigit = x % 10;
            x = x / 10;
            reversed = reversed * 10 + lastDigit;
        }
        
        return original == reversed;
    }


     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = scan.nextInt();
        
        Solution solution = new Solution();
        
        boolean result1 = solution.isPalindrome(x);
        System.out.println("Complete reversal result: " + result1);
        scan.close();
}
}