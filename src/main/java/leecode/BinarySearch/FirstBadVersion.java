package leecode.BinarySearch;

public class FirstBadVersion {
    // 278.
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start<end){
            int mid = start + (start - end)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else {
                start = mid+1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int n){
        return true;
    }
}
