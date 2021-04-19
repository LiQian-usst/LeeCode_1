package leecode.erfen;

public class BinarySearch {
    // 1.正常实现
    public int binarySearch(int[] nums, int key) {
        // 低位和高位
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            /*
            *   m 计算
            *   有两种计算中值 m 的方式：
            *   m = (l + h) / 2  ,可能存在溢出风险
            *   m = l + (h - l) / 2  ,推荐使用
            */
            int m = l + (h - l) / 2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    // 变种
    // 例如在一个有重复元素的数组中查找 key 的最左位置的实现如下
    public int binarySearchⅡ(int[] nums, int key) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= key) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
