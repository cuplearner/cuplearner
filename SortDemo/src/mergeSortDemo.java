import java.util.Comparator;

public class mergeSortDemo {

    public static void main(String[] args) {
        int [] a = new int[]{2,5,7,4,6,0,1,5,8};
        int first = 0;
        int last = a.length-1;
        int [] b = new int[a.length];
        mergeSort(a,first,last,b);
        for (int i = 0; i <last; i++) {
            System.out.println(a[i]);
        }
    }
    public static void mergeSort(int[]a,int first,int last,int [] b){
        //采用递归的方式进行排序
        //分段排序，然后进行合并
        //递归排序跳出的条件是first==last
        if(first==last){
            return;
        }
        int mid = first+((last-first)>>1);
        mergeSort(a,first,mid,b);
        mergeSort(a,mid+1,last,b);
        //进行合并
        merge(a, first, mid, last, b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static void merge(int []a, int first, int mid, int last, int []b, Comparator<Integer> comparator){
        //合并部分有序的数组
        int k = 0;
        int left = first;
        int right = mid+1;
        while(left<=mid&&right<=last){
            if(comparator.compare(a[left],a[right])>0){
                b[k++] = a[right++];
            }else{
                b[k++] = a[left++];
            }

        }
        //如果此时有一个分段数组没有可比较的元素了
        while(left<=mid){
            b[k++] = a[left++];
        }
        while(right<=last){
            b[k++] = a[right++];
        }
        //将临时数组中的元素重新放入原始数组
        for (int i = 0; i < k; i++) {
            a[first++] = b[i];
        }
    }

}
