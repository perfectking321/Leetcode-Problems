class Solution {
    public int hammingWeight(int n) 
    {
        String result = conversion(n);
        int cnt=0;
        for(int i=0;i<=result.length()-1;i++)
        {
            if(result.charAt(i)=='1') cnt++;
        }
        return cnt;
    }
    private String conversion(int n)
    {
        String res="";
        while(n!=0)
        {
            if(n%2==1) res+='1';
            else res+='0';
            n=n/2;
        }
        res = new StringBuilder(res).reverse().toString();
        return res;
    }
}
/*

    first conversion of decimal2Binary:



*/