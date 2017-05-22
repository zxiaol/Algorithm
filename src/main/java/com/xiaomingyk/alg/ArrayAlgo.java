package com.xiaomingyk.alg;

import java.util.ArrayList;

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

    public static int RemoveDuplicateFromSortedArray(int[] array){

        int j = 0;

        for(int i = 1; i < array.length; i++){

            if(array[i] != array[j]){

                array[++j] = array[i];

            }
        }

        return j+1;


    }

    public static void generatePascalTriangle(int n){

        if( n < 1)return;

        ArrayList<int[]> triangle = new ArrayList<int[]>();

        for(int i = 1; i <= n; i++){

            int[] line = new int[i];

            line[0] = 1;

            line[i-1] = 1;

            for(int j = 1; j < i-1;j++){

                line[j] = triangle.get(i-2)[j-1]+triangle.get(i-2)[j];
            }

            triangle.add(line);

            System.out.print("[");

            for(int k = 0; k < n; k++){

                if(k < (n-i)/2){

                    System.out.print(" ");

                }else if( k < (n-i)/2 + i ){

                    System.out.print(line[k-(n-i)/2]);

                    System.out.print(" ");

                }else {

                    System.out.print(" ");;
                }



            }

            System.out.print("]");

            System.out.println();

        }
    }




}
