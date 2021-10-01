import java.util.*;
public class heap {
    static int size=0;
    static void delete(int[] arr,int key,int type){
        int i=0;
        for(i=0;i<size;i++){
            //searching of data user wants to delete
            //and storing the index in i
            if(arr[i]==key){
                break;
            }
        }
        if(i>=size){
            System.out.println("Data that you entered is not present in the heap");
            return;
        }
        //if data is found swap the data to be deleted and the data at last index
        arr[i]=arr[size-1];
        size=size-1;
        buildheap(arr,type);
        System.out.println("Deletion Successfull");
    }
    static int[] insert(int[] heap,int key){
        if(size==heap.length){
        int[] arr=new int[size+1]; //creating a new array of size+1
        for(int i=0;i<size;i++){
            arr[i]=heap[i];
        }
        arr[arr.length-1]=key;
        size=arr.length;
        System.out.println("Insertion Succesfull");
        return arr;
    }
        else{
            heap[size]=key;
            size=size+1;
        }
        System.out.println("Insertion Succesfull");
        return heap;
    }
    static void min_heapify(int[] arr,int i){
        int smallest=i;
        int l=2*i+1; //index of left child
        int r=2*i+2; // index of right child
        if(l<size&&arr[l]<arr[smallest]){
            //if left child is smallest among the three
            smallest=l;
        }
        if(r<size&&arr[r]<arr[smallest]){
            //if right child is smallest among the three
            smallest=r;
        }
        if(smallest!=i){
            //if parent is not smallest among the three swap parent with smallest
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
            //as we swapped parent with smallest the part of heap
            //with smallest as a parent may require heapify again
            min_heapify(arr,smallest);
        }
    }
    static void max_heapify(int[] arr,int i){
        int largest=i;
        int l=2*i+1;//index of left child
        int r=2*i+2;// index of right child
        if(l<size&&arr[l]>arr[largest]){
             //if left child is largest among the three
            largest=l;
        }
        if(r<size&&arr[r]>arr[largest]){
             //if right child is largest among the three
            largest=r;
        }
        if(largest!=i){
             //if parent is not largest among the three swap parent with smallest
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            //as we swapped parent with largest the part of heap
            //with largest as a parent may require heapify again
            max_heapify(arr,largest);
        }
    }
    static void buildheap(int[] arr,int type){
        int index= (size/2)-1;
        if(type==1){
            for(int i=index;i>=0;i--){
                max_heapify(arr,i);
            }
        }
        else{
            for(int i=index;i>=0;i--){
                min_heapify(arr,i);
            }
        }
    }
    static void printheap(int[] arr){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        try{
            System.out.println("enter the size of heap");
            int n=sc.nextInt();
            int[] arr= new int[n];
            size=n;
            int type;
            System.out.println("enter the data of heap. we will arrange the data for ypu dont worry");
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println("Select the type of heap you want to build\n1.) max heap\n2.)min heap");
            type=sc.nextInt();
        buildheap(arr,type);
        System.out.println("The heap is");
        printheap(arr);
        while(true){
            System.out.println("\n---------------->MENU<---------------\n1.)Delete a data\n2.)Insert a data\n3.)Exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1:  System.out.println("enter the data you want to delete form heap");
                         int key=sc.nextInt();
                         delete(arr,key,type);
                         printheap(arr);
                         break;
                case 2:  System.out.println("enter the data you want to insert");
                         int data=sc.nextInt();
                         arr=insert(arr,data);
                         buildheap(arr,type);
                         printheap(arr);
                         break;
                case 3:  System.exit(0);
                default : System.out.println("Wrong choice please press again");         
            }
        }
        }catch(Exception e){}
        sc.close();
    }
    
}
