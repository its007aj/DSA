/*
https://leetcode.com/problems/assign-cookies/description/
*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int ng = g.length;
        int ns = s.length;
        int gp = 0;
        int sp = 0;

        while (gp<ng && sp<ns) {
            if(s[sp]>=g[gp]) {
                sp++;
                gp++;
            }
            else
                sp++;
        }

        return gp;
        
    }
}
