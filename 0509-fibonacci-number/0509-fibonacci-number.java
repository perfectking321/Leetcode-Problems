import java.util.*;
class Solution {
    public static int fib(int n) {
        if(n<=1) return n;
        else
        {
            int last = fib(n-1);
            int slast = fib(n-2);
            return last+slast;
        }
    }
    public static void main(String[] args)

        {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            System.out.print(fib(n));
        }
    }