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
		int[] appendArr = append(a1, appendNum);
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
		/*
		 * arrSum has the same length as arr1.
		 * Each index of arrSum holds the sum of the 
		 * values of arr1 and arr2 at the 
		 * same index
		 */
		public static int[] sum(int[] arr1 , int[] arr2) {
			int[] arrSum = new int[arr1.length];
			for(int i = 0; i < arr1.length; i++) {
				arrSum[i] = arr1[i] + arr2[i];
			}
			return arrSum;
		}
		
		/*
		 * appendarr has a length of one greater than arr.
		 * The array is identical to arr, except it adds num to
		 * the last index of appendarr
		 */
		public static int[] append(int[] arr, int num) {
			int[] appendarr = new int[arr.length + 1];
			for(int i = 0; i < arr.length; i++) {
				appendarr[i] = arr[i];
			}
			appendarr[arr.length] = num;
			return appendarr;
		}
		
		/*
		 * noIndex has a length of one less than arr. 
		 * noIndex is identical to arr except it removes
		 * the value at index idx by replacing it with 
		 * the next index, until it meets the array's end.
		 */
		public static int[] remove(int[] arr, int idx) {
			int[] noIndex = new int[arr.length - 1];
			for(int i = 0; i < idx; i++) {
				noIndex[i] = arr[i];
			}
			for(int i = idx; i < arr.length; i++) {
				noIndex[idx] = arr[idx + 1];
			}
			return noIndex;
		}
		
		/*
		 * arrSumEven adds all values at indexes
		 * divisible by 2.
		 */
		public static int sumEven(int[] arr) {
			int arrSumEven = 0;
			for(int i = 0; i < arr.length; i += 2) {
				arrSumEven += arr[i];
			}
			return arrSumEven;
			}
		
		/*
		 * rotateRight does not return anything.
		 * int last stores the value at the last
		 * index. The last index changes its value 
		 * to the index before it, and continues
		 * down the array until it meets index 1, 
		 * where it stops. Index 0 is then set to the
		 * last value of the array before shifting.
		 */
		public static void rotateRight(int[] arr) {
			int last = arr[arr.length - 1];
			for(int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = last;
		}
			
}