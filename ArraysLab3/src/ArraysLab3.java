import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * Anthony Alisantosa
 * APCS 2nd Period
 * 
 * Description: Follows the requirements set
 * by the ArrayLab3 worksheet. 
 * Contains and runs methods that manipulate arrays.
 * CoNtAiNs AnD rUnS mEtHoDs ThAt MaNiPuLaTe ArRaYs
 */
public class ArraysLab3 {
	public static void main(String[] args) {
		//test
		int[] a1 = {5, 10, 15, 20 , 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1,appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		
		
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
	

		
		public static int[] sum(int[] arr1 , int[] arr2) {
			int[] arrSum = new int[arr1.length];
			for(int i = 0; i < arr1.length; i++) {
				arrSum[i] = arr1[i] + arr2[i];
			}
			return arrSum;
		}
		
		public static int[] append(int[] arr, int num) {
			int[] appendarr = new int[arr.length + 1];
			for(int i = 0; i < arr.length; i++) {
				appendarr[i] = arr[i];
			}
			appendarr[arr.length - 1] = num;
			return appendarr;
		}
		
		public static int[] remove(int[] arr, int idx) {
			int[] noIndex = new int[arr.length - 1];
			for(int i = 0; i < idx; i++) {
				noIndex[i] = arr[i];
			}
			for(int i = idx; i < noIndex.length; i++) {
				noIndex[idx] = noIndex[idx + 1];
			}
			return noIndex;
		}
		
		public static int sumEven(int[] arr) {
			int arrSumEven = 0;
			for(int i = 0; i < arr.length; i += 2) {
				arrSumEven += arr[i];
			}
			return arrSumEven;
			}
		
		public static void rotateRight(int[] arr) {
			for(int i = 1; i < arr.length; i++) {
				arr[i] = arr[i - 1];
			}
			arr[0] = arr[arr.length - 1];
		}
			
}