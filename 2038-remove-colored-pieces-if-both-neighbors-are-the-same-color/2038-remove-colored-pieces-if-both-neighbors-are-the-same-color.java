class Solution {
    public boolean winnerOfGame(String colors) {

        int alice=0;
        int bob=0;
        for(int i=1;i<colors.length()-1;i++){
            if(colors.charAt(i-1)=='A' && colors.charAt(i)=='A' && colors.charAt(i+1)=='A')
            {
                alice++;
            }
            if(colors.charAt(i-1)=='B' && colors.charAt(i)=='B' && colors.charAt(i+1)=='B')
            {
                bob++;
            }
        }

        return alice>bob;
        /*
        so basically if there are triple neighbours:
        AAA or BBB
        we can remove the middle
        if alice wins then return true
        else false;
        alice wins when no BBB available
        alice loose when no AAA or BBB available 
        if AAA or BBB exists:
            update the string by removing the middle A or B
        */

    }
}