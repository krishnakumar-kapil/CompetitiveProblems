#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int t,i;
    scanf("%d",&t);
    unsigned int val, res;
    unsigned int x = 0xFFFFFFFF;
    for ( i = 0;i < t; i++ ) {
        
        scanf("%d",&val);
        res = val ^ x;
        printf("%u\n",res);
    }
    
    return 0;
}