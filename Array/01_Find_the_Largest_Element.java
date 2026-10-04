import java.util.*;
class 01_Find_the_largest_Element{
    public static void main(String args[]){
       // Find the largest ELement
        int arr[] = {1,2,3,4,5};
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("The largest element in the array is : " + max);
    }
}