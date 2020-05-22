package lists;

public class Lists {
	private int[] arr;
	Lists(int[] arr){
		this.arr = arr;
	}
	public int take(int index) {
		return arr[index];
	}
	public void drop(int index) {
		int[] newArr = new int[arr.length - 1];
		for (int i = 0; i < index; i++) {
			newArr[i] = arr [i];
		}
		for (int i = index + 1; i < arr.length; i++) {
			newArr[i-1] = arr[i];
		}
		arr = newArr;
		}
	public void concat(int[] arr1) {
		int[] newArr = new int[arr.length + arr1.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		for (int i = 0; i < arr1.length; i++) {
			newArr[arr.length + i] = arr1[i];
		}
		arr = newArr;
	}
	public String toString() {
		String s = "[";
		for(int i = 0; i < arr.length; i++) {
			s += arr[i];
			if(i == arr.length - 1) {
				s += "]";
			}
			else {
				s += ", ";
			}
		}
		return s;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		Lists l1 = new Lists(arr);
		System.out.println(l1);
		System.out.println(l1.take(1));
		
	}

}
