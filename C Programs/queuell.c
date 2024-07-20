#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct queue{
    int element;
    struct queue *next;
};

struct queue *front = NULL;
struct queue *rear = NULL;

void insert(int value){
    //Resering memory for new element enqueued
    struct queue *ptr = (struct queue *)malloc(sizeof(struct queue));
    //Storing the element in the node
    ptr -> element = value;
    //If the queue is empty, then adding an element
    if(front == NULL){
        front = rear = ptr;
        ptr -> next = NULL;
    }
    //Else linking the new node at the end of the queue
    else{
        rear -> next = ptr;
        ptr -> next = NULL;
        rear = ptr;
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
    struct queue *ptr;
    if(front == NULL){
        printf("Queue is empty!");
        return;
    }
    else{
        printf("Elements of the Queue :\n");
        for(ptr = front; ptr != rear; ptr = ptr -> next){
            printf("%d\t",ptr -> element);
        }
        printf("%d",rear -> element);
    }

}

int main(){
    int choice;
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
            insert(num1);
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