import java.util.*;
class 02_Find_the_Second_Largest_Element{
    public static void main(String[] args) {
     // Find the second largest ELement
        int arr[] = {0,-1,2};
        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
        }
        int secondlargest = min;
        for(int i = 0; i < arr.length; i++){
            if(max > arr[i] && min < arr[i]){
                secondlargest = arr[i];
            }
        }
       
        System.out.println("The second largest element in the array is : " + secondlargest);
    }
}