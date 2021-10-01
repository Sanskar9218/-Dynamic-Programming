#include <stdio.h>
#include <stdlib.h>
#include <math.h>
void createminheap(int a[],int );
void createmaxheap(int a[],int );
void maxheapsort(int a[],int);
void minheapsort(int a[],int);
int main()
{

while(1)
{
printf("\n                     --------------- *** HEAPS AND HEAPSORT *** ---------------\n");
int i,j,k,l,n;
printf("1. Creation of MINHEAP \n");
printf("2. Creation a MAXHEAP \n");
printf("3. Convert any random array into a minheap or maxheap.\n");
printf("4. Heapsort\n");
printf("5. QUIT\n");
printf("Enter your choice : ");
scanf("%d",&n);
switch(n)
{
case 1 : printf("Enter number of elements for MINHEAP\n");
scanf("%d",&j);
int a[100];
printf("Enter data for the heap\n");
for(i=0;i<j;i++)
{
scanf("%d",&a[i]);
}
createminheap(a,j);
        break;
case 2 : printf("Enter number of elements for MAXHEAP\n");
scanf("%d",&j);
int b[100];
printf("Enter data for the heap\n");
for(i=0;i<j;i++)
{
scanf("%d",&b[i]);
}
createmaxheap(b,j);
        break;
case 3 : printf("1. In MAXHEAP\n");
printf("2. In MINHEAP\n");
printf("Enter your choice : ");
scanf("%d",&k);
switch(k)
{
case 1 : printf("Enter number of elements for MAXHEAP\n");
scanf("%d",&j);
int c[100];
printf("Enter data for the heap\n");
for(i=0;i<j;i++)
{
scanf("%d",&c[i]);
}
createmaxheap(c,j);
break;
case 2 : printf("Enter number of elements for MINHEAP\n");
scanf("%d",&j);
int d[100];
printf("Enter data for the heap\n");
for(i=0;i<j;i++)
{
scanf("%d",&d[i]);
}
createminheap(d,j);
break;
}
break;
case 4 : printf("1. Heapsort using MINHEAP\n");
printf("2. Heapsort using MAXHEAP\n");
printf("Enter your choice : ");
scanf("%d",&k);
switch(k)
{
case 1 : printf("Enter number of elements for MINHEAP\n");
scanf("%d",&j);
int e[100];
printf("Enter data for the heap\n");
for(i=0;i<j;i++)
{
scanf("%d",&e[i]);
}
minheapsort(e,j);
break;
case 2 : printf("Enter number of elements for MAXHEAP\n");
scanf("%d",&j);
int g[100];
printf("Enter data for the heap\n");
for(i=0;i<j;i++)
{
scanf("%d",&g[i]);
}
maxheapsort(g,j);
break;
}
break;
case 5: exit(0);
default : printf("\n                          Invalid Input\n");

}
}
}
void createminheap(int a[],int m)
{
int i,j,parent,temp;
for(i=0;i<m;i++)
{
j=i;
do
{
parent = floor(j/2);
if(a[parent]>a[j])
{
temp=a[parent];
a[parent]=a[j];
a[j]=temp;
}
j=parent;
}while(j!=0);
}
printf("MINHEAP created is : \n");
for(i=0;i<m;i++)
printf("%d ",a[i]);
printf("\n");
}
void createmaxheap(int a[],int m)
{
int i,j,parent,temp;
for(i=0;i<m;i++)
{
j=i;
do
{
parent = floor(j/2);
if(a[parent]<a[j])
{
temp=a[parent];
a[parent]=a[j];
a[j]=temp;
}
j=parent;
}while(j!=0);
}
printf("MAXHEAP created is : \n");
for(i=0;i<m;i++)
printf("%d ",a[i]);
printf("\n");
}
void maxheapsort(int a[],int m)
{
createmaxheap(a,m);
int c,root,j,temp;
for(j=m-1;j>=0;j--)
{
temp=a[0];
a[0]=a[j];
a[j]=temp;
root=0;
do
{
c=2*root+1;
if ((a[c]<a[c+1])&&c<j-1)
c++;
if (a[root]<a[c]&&c<j)
{
temp=a[root];
a[root]=a[c];
a[c]=temp;
}
root=c;
} while(c<j);
}
printf("Sorted heap is : \n");
for(j=0;j<m;j++)
printf("%d ",a[j]);
}
void minheapsort(int a[],int m)
{
createminheap(a,m);
int c,root,j,temp;
for(j=m-1;j>=0;j--)
{
temp=a[0];
a[0]=a[j];
a[j]=temp;
root=0;
do
{
c=2*root+1;
if ((a[c]>a[c+1])&&c<j-1)
c++;
if (a[root]>a[c]&&c<j)
{
temp=a[root];
a[root]=a[c];
a[c]=temp;
}
root=c;
} while(c<j);
}
printf("Sorted heap is : \n");
for(j=0;j<m;j++)
printf("%d ",a[j]);
}