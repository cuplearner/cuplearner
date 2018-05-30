

public class BinarySearch {

    public static void main(String[] args) {
        int [] a = new int[]{1,3,5,7,9,11,13,15,17,19};
        int first = 0;
        int last = a.length-1;
        int [] b = new int[a.length];
        mergeSortDemo.mergeSort(a,first,last,b);
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println("i1 = " + i1);

        }
        int i = binarySearch(a, 9);
        System.out.println("i = " + i);
    }
    //二分查找的两种方式一种循环一种递归
    public static int binarySearch(int[]a,int key){
        //进行二分查找
        int low = 0;
        int high = a.length-1;
        if(high<low){
            return -1;
        }else{
            while(low<=high){
                int mid = low+((high-low)>>1);
                if(a[mid]<key){
                    low = mid+1;
                }
                else if(a[mid]>key){
                    high = mid-1;
                }
                else{
                    return mid;
                }
            }
            return -1;
        }


    }
}
