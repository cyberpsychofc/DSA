#include<stdio.h>
#include<conio.h> 

void traverse(int arr[][100], int r, int w) {
     for (int i = 0; i < r; i++) {
        for (int j = 0; j < w; j++) {
            printf("%d\t", arr[i][j]);
        }
     printf("\n");
     }
}

void mul(int arr1[][100], int arr2[][100], int r, int w){
    int res[100][100];
    for(int i=0;i<r;i++){
        for(int j=0; j<w; j++){
            for(int k=0;k<w;k++){
                res[i][j] += arr1[i][k]*arr2[k][j];
            }
        }
    }
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < w; j++) {
            printf("%d\t", res[i][j]);
     }
     printf("\n");
     }
}
void add(int arr1[][100], int arr2[][100], int r, int w){
     for (int i = 0; i < r; i++) {
        for (int j = 0; j < w; j++) {
            printf("%d\t", arr1[i][j] + arr2[i][j]);
     }
     printf("\n");
     }
}
void transpose(int arr[][100],int r, int w){
     for (int i = 0; i < r; i++) {
        for (int j = 0; j < w; j++) {
            printf("%d\t", arr[j][i]);
     }
     printf("\n");
     }
}

int addDiagonal(int arr[][100],int r, int w){
     int sum = 0;
     for (int i = 0; i < r; i++) {
        for (int j = 0; j < w; j++) {
            if(i==j){
                sum += arr[i][j];
            }
        }
     }
    return sum;
}

void transform(int arr[][100],int r,int w){
    for(int i=0;i<r;i++){
        for(int j=0; j<w; j++){
            if(i<=j){
                arr[i][j] = 0;
            }
            else if(i>j){
                arr[i][j] = 1;
            }
        }
    }
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < w; j++) {
            printf("%d\t", arr[i][j]);
        }
        printf("\n");
    }
}

int main() { 
     int r, w;

     printf("Rows : ");
     scanf("%d", &r);
     printf("Columns : ");
     scanf("%d", &w);

     int arr1[r][100], arr2[r][100]; 

     printf("Enter elements for Array 1:\n");
     for (int i = 0; i < r; i++) {
     for (int j = 0; j < w; j++) {
     scanf("%d", &arr1[i][j]);
     }
     }

     printf("Enter elements for Array 2:\n");
     for (int i = 0; i < r; i++) {
        for (int j = 0; j < w; j++) {
            scanf("%d", &arr2[i][j]);
        }
    }

    printf("Array 1:\n");
    traverse(arr1, r, w);

    printf("Array 2:\n");
    traverse(arr2, r, w);

    int choice;
    printf("Enter Choice :\n1. SUM OF DIAGONAL ELEMENTS\n2. Replace upper diagonal elements with 0 and lower diagonal elements w/ 1\n3. ADDITON OF MATRIX\n4. MULTIPLICATION\n5. TRANSPOSE\n6. Exit\n");
    scanf("%d",&choice);
    
    printf("\n");
    
    switch(choice){
        case 0:
            break;
        case 1:
            printf("Sum of diagonal elements : %d", addDiagonal(arr1,r,w));
            break;    
        case 2:
            printf("Upper/Lower diagonal transforms :\n");
            transform(arr1,r,w);
            break;
        case 3:
            printf("Sum of Matrix :\n");
            add(arr1,arr2,r,w); 
            break;
        case 4:
            printf("Product of Matrix :\n");
            mul(arr1,arr2,r,w);
            break;
        case 5:
            printf("Transpose :\n");
            transpose(arr1,r,w);
            break;       
        case 6:
            exit(1);
            break;
        default:
            printf("Invalid Input!");
            break;
    }
    return 0;
}