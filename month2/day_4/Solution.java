package month2.day_4;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] num: nums1) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        for(int[] num: nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i][0] == nums2[j][0]) {
                ans.add(new int[]{nums1[i][0], map.get(nums1[i][0])});
                i++;
                j++;
            } else if(nums1[i][0] < nums2[j][0]) {
                ans.add(new int[]{nums1[i][0], map.get(nums1[i][0])});
                i++;
            } else {
                ans.add(new int[]{nums2[j][0], map.get(nums2[j][0])});
                j++;
            }
        }

        while(i < nums1.length) {
            ans.add(new int[]{nums1[i][0], map.get(nums1[i][0])});
            i++;
        }

        while(j < nums2.length) {
            ans.add(new int[]{nums2[j][0], map.get(nums2[j][0])});
            j++;
        }

        return convertListToArray(ans);
    }

    public static int[][] convertListToArray(List<int[]> list) {
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
