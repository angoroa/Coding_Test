#include<stdio.h>
#define MAX 100000
void push(int a);
int pop();
int stack[MAX];
int top=-1;
int main(){
    int n;
    int value;
    int count = 0;
    scanf("%d", &n);
    for (int i=0; i<n; i++){
        scanf("%d", &value);
        if (value == 0){
            count -= pop();
        }
        else{
        push(value);
        count += value;
        } 
    }
    printf("%d\n", count);
    
}

void push(int a){
    if(top>=MAX-1){
        return;
    }
    stack[++top] = a;
}
int pop(){
    if(top ==-1){
        return 0;
    }
    return stack[top--];
}
