class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++)
        {
            for(int coin:coins)
            {
                if(coin<=i)
                {
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]>amount ? -1:dp[amount];
    }
}

/*

    first ek dp array mai i will keep all the possible number of coins i can give to make up with the amount.
    formula:
    dp[i]=dp[i-coin]+1

    like we iterate through all the coins:
        check coin needs too be lesser than amount, if not then it will exceed:
            fill up the dp table
            dp[i]=Math.min(dp[i],dp[i-coin]+1);



*/