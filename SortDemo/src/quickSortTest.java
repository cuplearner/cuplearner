import java.util.Comparator;

public class quickSortTest {
    public static void main(String[] args) {
    int [] a = new int[]{2,5,7,4,6,0,1,5,8};
    int first = 0;
    int last = a.length-1;
    quickSort(a, first, last, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
        for (int num:a
             ) {
            System.out.println(num);
        }
    }

    //快速排序的java代码实现
    public static void quickSort(int[] a, int first, int last, Comparator<Integer> comparator){
        //整个排序操作建立在last>first的基础上所以先进行判断last是否大于first
        if(last>first){
            //选取基准元素，对基准元素进行操作，并返回操作后的基准元素的索引
            int yuansu = partition(a,first,last,comparator);
            //以基准元素的索引为分割界限，对分段数组进行递归快速排序操作
            quickSort(a,first,yuansu-1,comparator);
            quickSort(a,yuansu,last,comparator);


        }



    }

    public static int partition(int[] a,int first,int last,Comparator comparator){
        //选取基准元素
        int p = a[first];
        int low = first+1;
        int high = last;
        int temp ;
        //对基准元素进行操作
        //从前向后找一个比基准元素大的元素
        while(high>low){
           while(high>=low&&comparator.compare(a[low],p)<=0){
               low++;
           }
        }
        //从后向前找一个比基准元素小的元素
        while(high>low){
            while(high>=low&&comparator.compare(a[high],p)>=0){
                high--;
            }
        }
        //找到之后两个元素交换位置
        if(high>low){
            temp = a[low];
            a[low] = a[high];
            a[high] = temp;
        }
        //基准元素归位
        //从后向前找一个比基准元素小的元素和基准元素交换位置
        while (high > first&&comparator.compare(a[high],p)>= 0) {
            high--;
        }
        //基准元素归位
        if(comparator.compare(p,a[high])>0){
            temp = p;
            p = a[high];
            a[high] = temp;
            return high;
        }else{
            return low;
        }


    }
}

