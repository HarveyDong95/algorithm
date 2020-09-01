import java.util.Arrays;

// import sun.awt.www.content.audio.aiff;
// import sun.security.util.Length;

public class MergeSort{
    public static int[] mergeSort(int[] a, int left, int right){
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(a, left, mid);
            mergeSort(a, mid+1, right);
            
            // merge(a, left, mid, right);
            merge(a, mid, left, right);
            
            // System.out.println(Arrays.toString(a));
        }
        // System.out.println(Arrays.toString(a));
        return a;
    }

    public static void merge(int[] a, int mid,int left, int right){
        int i = left; int j = mid + 1;int k = 0;
        // int mid = (left + right) / 2;
        int lenth = right - left +1;
        // System.out.println("right "+right);
        int res[] = new int[lenth];
        
        while(i <= mid && j <= right){
            // System.out.println(right);
            // System.out.println(i+" i and j "+j);
            if (a[i] < a[j] ){
                res[k++] = a[i++];
            } else {
                res[k++] = a[j++];
            }
        }

        while(i <= mid){
            // System.out.println("res" + res[k]);
            // System.out.println("a" + a[i]);
            res[k++] = a[i++];
        }
        
        while(j <= right){
            // System.out.println("res2" +" "+ k);
            // System.out.println("a2" +" "+ j);
            res[k++] = a[j++];
        }
        
        for(int x=0; x<res.length;x++){
            a[x+left] = res[x];
        }
    }

    public static void main(String[] args){
        int a[] = {2,4,1,65,22,6,7,34,8,5,13,552,44,66};
        // int[] res = mergeSort(a, 0, a.length-1); 
        int[] res = mergeSort(a, 0, a.length-1);

        System.out.println(Arrays.toString(res));
    }
}