package itjinxun.StringAndArray;

public class ArrayHomeWork {
    public static int[] twoSum(int[] arr,int sum){
        int[] indexs = new int[2];
        int sums;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > sum){
                continue;
            }
            for (int j = i+1; j < arr.length; j++) {
                sums = arr[i]+arr[j];
                if(sums == sum){
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return null;
    }
}
