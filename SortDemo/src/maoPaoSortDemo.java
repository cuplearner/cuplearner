public class maoPaoSortDemo {
    public static void main(String[] args) {
        int [] a = new int[]{2,5,7,4,6,0,1,5,8};
        maoPao(a);
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            System.out.println("i1 = " + i1);
        }

    }

    public static void maoPao(int [] a){
        //冒泡排序的关键是两层for循环依次记性比较
        //通过标记flag提高效率
        boolean flag = true;
        int temp = 0;
        for (int i = 1; flag&&i <=a.length-1 ; i++) {
            flag = false;
            for (int j = 0; j <a.length-1-i ; j++) {
                if(a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
        }
    }
}
