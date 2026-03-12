class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        // base case
        dp[0]=1;
        dp[1]=s.charAt(0) != '0' ? 1:0;
        for(int i=2;i<=n;i++)
        {
            int oneDigit=s.charAt(i-1)-'0';
            int twoDigit=Integer.parseInt(s.substring(i-2,i));
            if(oneDigit>=1) dp[i]=dp[i]+dp[i-1];
            if(twoDigit>=10 && twoDigit<=26) dp[i]=dp[i]+dp[i-2];
        }
        return dp[n];
    }
}