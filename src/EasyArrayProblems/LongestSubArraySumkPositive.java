package EasyArrayProblems;

import java.util.Scanner;

import static java.lang.Math.max;

public class LongestSubArraySumkPositive {


    static Scanner sc  = new Scanner(System.in);

    public static int findSubArrayBrute(int[] arr, int K){
        //1, 11, 112, 1121,...
        //1 2 3 1 1 1 1 4 2 3
        // 1
        // 1 2, 123, 1231,

        int max  = 0;
        for(int i = 0;i<arr.length;i++){

            for(int j = i;j<arr.length;j++){
               int sum = 0;
                for(int k  =i;k<=j;k++){
                    sum=sum+arr[k];
                    //enhancing
                    if(sum>K){
                        break;
                    }
                }
                if(sum == K ){
                    max = max(max,j-i+1);
                }else if(sum > K){      //enhancing
                    break;
                }
            }
        }

        return max;

    }

    public static int findSubArrayBruteEnhanced(int[] arr, int K){
        int max = 0;
        for(int i = 0 ;i<arr.length;i++){
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(sum == K ){
                    max = max(max,j-i+1);
                }
            }
        }
        return max;
    }

    public static int[] inputArray(){
        System.out.println("Enter N");

        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.println("Enter the elements");
        for (int i = 0; i < N; i++) {
            arr[i] =sc.nextInt();
        }
        return  arr;
    }

    public static void main(String[] args) {
        int[] arr = inputArray();
        System.out.println("Enter the sum");
        int K = sc.nextInt();


        System.out.println("The longest sub array wth sum "+K+" via Brute force is : "+ findSubArrayBrute(arr,K));
        System.out.println("The longest sub array wth sum "+K+" via  Enhanced Brute force is : "+ findSubArrayBruteEnhanced(arr,K));

    }
}
