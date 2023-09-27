#include<stdio.h>
#include<conio.h>

struct stackll{
    int element;
    struct stackll *next;
}*top;

void push(int value){
    struct stackll *ptr;
    //Reserving Memory for new node of Stack
    ptr = (struct stackll*)malloc(sizeof(struct stackll));
    //Storing value
    ptr -> element = value;
    //Updating top address
    ptr -> next = top;
    top = ptr;
    return;
}
int pop(){
    if(top==NULL){
        printf("Stack UnderFLow detected!");
        exit(1);
    }
    else{
        //Retreving top element
        int temp = top -> element;
        top = top -> next;
        return temp;
    }
}
void peep(){
    struct stackll *ptr;
    printf("\nStack Elements :");
    for(ptr=top;ptr!=NULL;ptr=ptr->next){
        printf("\n%d",ptr->element);
    }
}

int main(){
    /*Switch Implementation 1. Push 2. Pop 3. Display 4. Exit*/
    int choice;
    int num1 = 0,num2 = 0;

    while(1){
        printf("\nEnter a choice : ");
        scanf("%d",&choice);

        switch(choice){
            case 1:
            printf("Enter element : ");
            scanf("%d",&num1);

            push(num1);
            break;

            case 2:
            num2 = pop();
            printf("%d popped!",num2);
            break;

            case 3:
            peep();
            break;

            case 4:
            exit(1);
            break;

            default:
            printf("Invalid Choice!");
            break;
        }
    }
    return 0;
}