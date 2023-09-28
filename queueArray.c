#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

int queue[100];
int front = -1;
int rear = -1;

void insert(int value){
    if(front==-1){
        front = rear = front + 1;
        queue[front] = value;
        return;
    }
    if(rear == 99){
        printf("Queue is full!");
        return;
    }
    rear++;
    //Adding element at the end of the queue
    queue[rear] = value;
}
int delete(){
    int i;
    if(front == -1 && front == rear){
        printf("\nQueue is Empty!");
        return -9999;
    }
    //When the queue has only one element
    if(front!=-1 && front == rear){
        i = queue[front];
        front = -1;
        rear = -1;
        return (i);
    }
    //Removing the element at the beginning of the queue
    return (queue[front++]);
}
void display(){
    if(front == -1){
        printf("Queue is Empty!");
        return;
    }
    printf("\nElements of the queue :\n");
    for(int i=front;i<=rear;i++){
        printf("%d\t",queue[i]);
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