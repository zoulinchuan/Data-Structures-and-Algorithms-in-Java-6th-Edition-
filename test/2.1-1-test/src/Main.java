/**
 * @Author zoulinchuan
 * @Date 2024年09月01日 星期日 10:37
 * @description: ${description}
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1,3,4,5,0,123,4,2};
        SelectionSort.sort(array);

        // println
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}

/**
 * 排序：小<-大
 */
class SelectionSort{

    /**
     * 交换数组中的两个元素
     * @param array
     * @param i 需要交换的元素
     * @param j 被交换的元素
     */
    public static void swapElements(int[] array, int i, int j){
        int iValue = array[i];
        array[i] = array[j];
        array[j] = iValue;
    }

    /**
     * 从start下标开始找，找到最小的元素
     * @param array
     * @param start
     * @return
     */
    public static int indexLowest(int[] array, int start){
        int lowestIndex = start;
        for (int i = start; i < array.length; i++) {
            if(array[i] < array[lowestIndex]) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }



    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++) { // 下标后移
            // 获取当前下标开始找到的最小元素
            int swapIndex = indexLowest(array, i); 
            // 交换找到的下标与当前下标元素
            swapElements(array, i, swapIndex);
        }
    }
}