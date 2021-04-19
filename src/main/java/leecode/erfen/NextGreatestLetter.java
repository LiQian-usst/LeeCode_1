package leecode.erfen;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        while(left<=right){
            int m = left +(right-left)/2;
            if(m-1>=0 && letters[m]>target && letters[m-1]<=target){
                return letters[m];
            }else if(letters[m]>target){
                right = m-1;
            }else {
                left = m+1;
            }
        }
        return letters[0];
    }
}
