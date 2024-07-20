#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct queue{
    int element;
    int priority;
    struct queue *next;
};

struct queue *front = NULL;

void insert(int value, int pr){
    /* 'temp' traverses throughout the queue
    in order to find the right position of 
    the node */
    struct queue *temp;
    struct queue *ptr = (struct queue*)malloc(sizeof(struct queue));

    ptr -> element = value;
    ptr -> priority = pr;

    if(front == NULL || ptr -> priority < front -> priority){
        ptr -> next = front; //inserting the element at the front
        front = ptr;
    }
    else{
        temp = front;
        // adding the element about the as per priority

        /* temp->next != NULL : checks if the next node
         in the queue exists. If true, means temp is the 
         last node */
        while(temp -> next != NULL && temp -> next -> priority <= ptr -> priority){
            temp = temp -> next;
        }
        /* afte finding the right position,
        ptr is linked to the right node*/
        ptr -> next = temp -> next;
        temp -> next = ptr;
    }
}
int delete(){
    int i;

    if(front == NULL){
        return (-9999);
    }
    else{
        //Retrieveing the element, and removing the element at the front of the queue
        i = front -> element;
        front = front -> next;
        return (i);
    }
}
void display(){
    struct queue *ptr = front;
    if(front == NULL){
        printf("Queue is empty!");
        return;
    }
    else{
        printf("Elements of the Queue :\n");
        printf("Element\tPriority\n");

        while(ptr != NULL){
            printf("%d\t%d\n",ptr -> element, ptr -> priority);
            ptr = ptr -> next;
        }
    }
}

int main(){
    int choice,pr;
    int num1=0,num2=0;
    while (1){
        /*Switch Implementation 1. Enqueue 2. Dequeue 3. Display 4. Exit*/
        printf("\nEnter choice : ");
        scanf("%d",&choice);
        switch (choice)
        {
        case 1:
            printf("Enter element to enqueue : ");
            scanf("%d",&num1);
            printf("Enter priority : ");
            scanf("%d",&pr);
            insert(num1,pr);
            break;
        case 2:
            num2 = delete();
            if(num2 == -9999){
                break;
            }
            else{
                printf("\n%d was removed from the queue!",num2);
            }
            break;
        case 3:
            display();
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