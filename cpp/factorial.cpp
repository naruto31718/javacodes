#include<iostream>
using namespace std;
long long factorial(long long n){
    long long fact;
    if(n==0){
       fact=1;
    }else{
        fact=n*factorial(n-1);
    }
    return fact;
}
int main(){
    long long n;
    cin>>n;
    cout<<factorial(n)<<endl;
}