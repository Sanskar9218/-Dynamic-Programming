
#include<bits/stdc++.h>
using namespace std;

int main()
{
	int x[10], h[10], y[10];
	int len1, len2 = 0;
	cout<<"Enter the length of the first sequence: ";
	cin>>len1;
	cout<<"Enter the length of thesecond sequence: ";
	cin>>len2;
	int l = (len1) + (len2) - 1;
	int i, j, n, k = 0;
	for (i = 0; i < len1; i++) {
		cin>>x[i];
	}
	for (j = 0; j < len2; j++) {
		cin>>h[i];
	}
	for (n = 0; n < l; n++) {
		y[n] = 0;
		for (k = 0; k < len1; k++) {
			if ((n - k) >= 0
				&& (n - k) < len2) {
				y[n] = y[n] + x[k] * h[n - k];
			}
			cout<<y[n]<<"\t";
		}
	}
}


