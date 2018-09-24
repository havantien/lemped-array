import java.util.Scanner;

public class LempedArray {

    static Scanner sc = new Scanner(System.in);

    public static float[] input(float[] array){
        System.out.println("nhập vào số phần tử của mảng");
         int n = sc.nextInt();
         array = new float[n];
        System.out.println("nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.println("a[%d] = " + i);
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static void sortASC(float[] array){
        float temp = array[0];
        for (int i = 0; i < array.length-1; i++) {
            for(int j = i+ 1; i< array.length; i++){
                if (array[i] > array[j]) {
                    array[j] = temp;
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static float[] merge(float[] a, float[] b) {
        int aIndex = a.length - 1;
        int bIndex = b.length - 1;
        int cIndex = a.length + b.length -1;
        float[] c = new float[cIndex + 1];

        sortASC(a);
        sortASC(b);

        for (int i = 0; i > -1; i--) {
            if (aIndex > -1 && bIndex > -1) {
                if (a[aIndex] > b[bIndex]) {
                    c[i] = a[aIndex]--;
                } else {
                    c[i] = b[bIndex]--;
                }
                } else if (bIndex == -1) {
                c[i] = a[aIndex--];
                } else if (aIndex == -1) {
                c[i] = b[bIndex--];
                }
            }
            return c;
        }

    public static void show(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        float[] a = null;
        float[] b = null;
        float[] c = null;

        System.out.println("---Nhập mảng a---");
        a = input(a);
        System.out.println("---Nhập mảng b---");
        b = input(b);

        // trộn mảng a và b thành c
        c = merge(a, b);

        // in mảng c ra màn hình
        show(c);
    }

}
