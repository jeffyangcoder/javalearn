package com.ecc.javalanguage.aboutClass;

public class Sort {

    static void BubbleSort(int[] sortArray){
        if (sortArray == null || sortArray.length < 2) return;

        for (int i : sortArray)
        {
            boolean is_swap = false;
            for (int j  = 0;j < sortArray.length  -1;j ++)
            {
                if (sortArray[i] < sortArray[j])
                {
                    int temp;
                    temp = sortArray[j];
                    sortArray[j] = sortArray[i];
                    sortArray[i] = temp;
                    is_swap = true;
                }
                if(is_swap = false)
                    break;
            }
        }
    }

    static void selectionSort(int[] sortArray){
        if (sortArray == null || sortArray.length < 2) return;

        for(int i = 0;i<sortArray.length;i++){
            int minIndex = i;
            for (int j = i + 1;j < sortArray.length ;j++){
                if (sortArray[j] < sortArray[minIndex]){
                    minIndex  = j;
                }
            }
            if (minIndex!=i){
                int temp;
                temp = sortArray[minIndex];
                sortArray[minIndex] = sortArray[i];
                sortArray[i] = temp;
            }
        }
    }

}
