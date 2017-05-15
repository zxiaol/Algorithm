package com.xiaomingyk.alg;

/**
 * Created by My on 5/16/2017.
 */
public class ArrayAlgo {

    public static int RemoveElemGreater(int[] array, int target){

        if(array == null || array.length == 0)
            return 0;

        int j = 0;

        for(int i = 0; i < array.length;i++){

            if(array[i] <= target){

                array[j] = array[i];
                j++;
            }
        }

        return j;
    }
}
