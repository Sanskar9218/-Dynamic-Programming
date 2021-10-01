import java.util.Scanner;

public class QuickSort {
	
	static void quickSort(int l, int r, int arr[])
	{
		if(l<r)
		{
			int p = partition(l, r, arr);
			quickSort(l, p-1, arr);
			quickSort(p+1, r, arr);
		}
	}
	
	static int partition(int l, int r, int arr[])
	{
		int pivot = arr[l];
		int i,j;
		i = l+1;
		for(j=l+1;j<=r;j++)
		{
			if(arr[j]<pivot)
			{
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
			}
		}
		int temp = arr[l];
		arr[l] = arr[i-1];
		arr[i-1] = temp;
		return i-1;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int i,l;
		int[] arr = {2,4,1,3,5,10,8,7,9};
		l = arr.length;
		quickSort(0, l-1, arr);
		for(i=0;i<l;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}
