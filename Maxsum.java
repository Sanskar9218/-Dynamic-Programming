

class Maxsum{
    public static void main(String[] args) {
        int a[]={1,4,2,10,23,3,1,0,20};
        int k=4;
        int max=0;
        
        for(int i=0;i<=a.length-k;i++){
            int sum=0;
            for(int j=0;j<k;j++){
               sum=sum+a[i+j];
            }
            if(sum>max){
                max=sum;
            }
        }
        System.out.println(max);
    }
}