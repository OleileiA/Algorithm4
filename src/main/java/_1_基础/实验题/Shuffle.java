package _1_基础.实验题;

public class Shuffle {

    // 返回一个泛型数组的泛型方法
    public static <T> T[] shuffle(T[] arr) {
        int len = arr.length;
        int i;
        T temp;
        while (len > 0) {
            i = (int) Math.floor(Math.random() * len--);// 任取数组范围内的一个index
            temp = arr[i];
            arr[i] = arr[len]; // 和最后一个交换
            arr[len] = temp;
        }
        return arr;
    }
}
