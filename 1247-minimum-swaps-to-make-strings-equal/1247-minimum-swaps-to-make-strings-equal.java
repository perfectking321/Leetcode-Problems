class Solution {
    public int minimumSwap(String s1, String s2) {
        if(s1.length() !=s2.length())
        {
            return -1;
        }
        // here s[i]='x' and s2[i]='y' and vise versa case
        int xy = 0,yx=0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                if(s1.charAt(i)=='x')
                {
                    xy++;
                }
                else
                {
                    yx++;
                }
            }
        }
        if(xy%2!=yx%2)
        {
            return -1;
        }
        return xy/2 + yx/2 + (xy%2)*2;


        /*

        okay so they are asking 
        xx, yy => 1 swap
        xy->xx=> 2swap here
        yx->yy=>
        
        xx here left side part both are x and we only consider the right side
        xy => -1

        
         */
    }
}

