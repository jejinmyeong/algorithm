class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        
        for (int i = 1 ; i < arrayA.length ; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        
        for (int i = 1 ; i < arrayB.length ; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        if (gcdB != 0) {
            for (int a : arrayA) {
                if (a % gcdB == 0) {
                    gcdB = 0;
                    break;
                }
            }
        } else gcdB = 0;
        
        if (gcdA != 0) {
            for (int b : arrayB) {
                if (b % gcdA == 0) {
                    gcdA = 0;
                    break;
                }
            }
        } else gcdA = 0;
        
        
        return Math.max(gcdB, gcdA);
    }
    
    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}