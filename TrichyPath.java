import java.util.Scanner;

public class TrichyPath
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int index,temp;
        int a[] = new int[n];
        for(int i=0;i<n;++i)
        {   
            a[i] = sc.nextInt();
            if(a[i]==0)
            temp = i;
            else
            temp = 0;
        }
        index = temp;
        int c = sc.nextInt();
        int newindex = index,flag = 0;


        while(a[newindex]!=0)
        {
            if(newindex>index)
            newindex = c - a[c];
            else if(newindex<index)
            newindex = c + a[c];


            c = a[newindex];
            if(a[newindex]==0)
            {      
                flag = 1;
                break;
            }
        }
        if(flag==1)
        System.out.println("true");
        else
        System.out.println("false");
    }
}