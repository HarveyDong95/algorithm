import java.util.Scanner;
//import java.util.Arrays;
public class strongInversions {
    public static long ret;
    static long templist[] = new long[1000000];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = in.nextLine();
        int lines = Integer.parseInt(x);
        long[] nums = new long[lines];
        for (int i = 0; i < lines; i++) {
            String temp = in.nextLine();
            long temp2 = Long.parseLong(temp);
            nums[i] = temp2;
        }
//            System.out.println(nums.length);
//        for(int j=0;j<nums.length;j++){
//            System.out.println(nums[j]);
//        }
            long res = mergeCount(nums, 0, nums.length - 1);
            System.out.println(res);

    }

    private static long mergeCount(long[] nums, int head, int end) {
        if(head >= end) return 0;
        int mid = head +  (end - head) / 2;
        ret = mergeCount(nums, head, mid) + mergeCount(nums, mid+1, end);
        for(int i = head, j = mid+1;i<=mid;i++) {
            while(j<=end && nums[i]>2*nums[j]) {
                j++;
            }
            ret += j - (mid+1);
        }

        mergeSort(nums, head, mid, end);
//        Arrays.sort(nums, head, end+1);
        return ret;
    }

    private static void mergeSort(long[] nums, int head, int mid, int end) {
        for(int i=head;i<=end;i++) {
            templist[i] = nums[i];
        }
        int p1 = head;
        int p2 = mid + 1;
        int i = head;
        while(p1<=mid || p2<=end) {
            if(p1>mid || (p2<=end && templist[p1] >= templist[p2])) {
                nums[i++] = templist[p2++];
            } else {
                nums[i++] = templist[p1++];
            }
        }
    }
}
