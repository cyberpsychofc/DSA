#include<stdio.h>
#include<conio.h>

int array[10];
int current_index = 0;

void insert(int element,int post){
    if(array[9]!=NULL){
        printf("Array is full!");
    }
    else{
        for(int i = (current_index + 1);i>=(post-1);i--){
            if(i<(post-1)){
                printf("Enter position within the size of the Array i.e. %d",(current_index+1));
                break;
            }
            else{
                array[i+1]=array[i];
            }
        }
        array[post-1] = element;
        current_index++;
    }
}

int delete(int index){
    int value = array[index];

    for(int i=index; i <= (current_index - 2) ; i++){
        array[i] = array[i+1];
    }
    current_index--;
    return value;
}

void traverse(){
    if(array[0]==NULL){
        printf("Array is empty!");
    }
    else{
        for(int i=0;i<current_index;i++){
            printf("%d\t",array[i]);
        }
    }
}

int main(){
    /* Switch Implementation 
    1. Insertion
    2. Deletion
    3. Traverse
    4. Sort
    5. Search
    6. Minimum and Maximum
    7. Exit
    */
   int choice, num1 = 0, num2 = 0;

   while (1){
    printf("\nEnter choice : ");
    scanf("%d",&choice);
    switch (choice){
        case 1:
            printf("Enter element : ");
            scanf("%d",&num1);
            printf("Enter position : ");
            scanf("%d",&num2);

            insert(num1,num2);
            break;
        case 2:
            if(array[0]==NULL){
            printf("Array is empty!");
            }
            else{
                printf("Select Index to delete element : ");
                scanf("%d",&num1);
        
                num2 = delete(num1);
                printf("%d was removed from the Array!",num2);
            }
            break;
        case 3:
            printf("Array :\n");
            traverse();
            break;
        case 4:
            //Bubble Sort
            for(int i=(current_index+1);i>1; i--){
                for(int j=0; j< i-1; j++){
                    if(array[j]>array[j+1]){
                        int temp = array[j+1];
                        array[j+1] = array[j];
                        array[j] = temp;
                    }
                }
            }
            printf("Sorted Array :\n");
            traverse();
            break;
        case 5:
            printf("Enter element to search : ");
            scanf("%d",&num1);
            //Binary Search
            int mid,i=0,j=(current_index+1);
            
            while(i<=j){
                mid = (i+j)/2;
                if(array[mid]==num1){
                    printf("%d found at %d\n",num1,mid);
                    break;
                }
                else if(array[mid]<num1){
                    i = mid + 1;
                }
                else{
                    j = mid - 1;
                }
            }
            break;
        case 6:
            int min=0,max=0;
            for(int i=0; i<current_index; i++){
                if(array[max]<array[i]){
                    max = i;
                }
                if(array[min]>array[i]){
                    min = i;
                }
            }
            printf("Maximum : %d\nMinimum : %d",array[max],array[min]);
            break;
        case 7:
            exit(1);
            break;
        default:
            printf("Invalid choice!");
            break;
        }
    }  
}