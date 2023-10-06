#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

int queue[5];
int front = -1;
int rear = -1;

void insert(int value){
    /*front == rear + 1, 
    checks if there is an element at the beginning 
    of the queue*/
    if((front == 0 && rear==4) || front == rear + 1){
        printf("Queue Overflow!");
        return;
    }
    //updating queue front & rear pointer
    //if the queue is empty
    if(front == -1){
        front = 0;
        rear = 0;
    }
    /*makes the rear pointer point to the
     beginning of the queue*/


    /* rear = (rear++) % length */
    else if(rear == 4){
        rear = 0;
    }
    else{
        rear++;
    }
    queue[rear]=value;
}

int delete(){
    int i;
    if(front == -1){
        printf("\nQueue underflow!");
        return (-9999);
    }
    i = queue[front];
    /*if the queue has only one element left, 
    front & rear get default values*/
    if(front == rear){
        front = -1; 
        rear = -1;
        return (i);
    }
    /*points at the beginning,
    if front points at the last element
    of the queue*/

    /* front = (front++) % length */
    else if(front == 4){
        front = 0;
        return (i);
    }
    else{
        front++;
        return(i);
    }
}

void display(){
    int i;
    if(front == -1){
        printf("Queue underflow!");
        return;
    }
    printf("Queue elements :\n");
    
    i=front;

    while(i!=rear){
        printf("%d\t",queue[i]);
        if(i==4){
            i = 0;
        }
        else{
            i++;
        }
    }
    //last element
    printf("%d\t",queue[i]);
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
