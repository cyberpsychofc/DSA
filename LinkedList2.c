#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

struct node{
    int element;
    struct node *next;
};
struct node *first = NULL;
struct node *last = NULL;
int count=0; //counts the number of nodes

struct node *search (int value){
    struct node *ptr;

    if(first == NULL){
        return NULL;
    }
    for(ptr = first; ptr != last; ptr = ptr->next){
        if(ptr -> element == value){
            return ptr;
        }
    }
    if(last -> element == value){
        return last;
    }
    else{
        return NULL;
    }
}
void insert_beg(int value){
    struct node *ptr = (struct node*)malloc(sizeof(struct node));
    
    ptr -> element = value;
    if(first == NULL){
        first = last = ptr;
        ptr -> next = NULL;
    }
    else{
        ptr->next = first;
        first = ptr;
    
        count++;
    }
}
void insert_end(int value){
    /*creates a new node and and allots memory to the new node w/ an instance of a struct node */
    struct node *ptr = (struct node*)malloc(sizeof(struct node));
    ptr -> element = value;
    
    if(first == NULL){
        printf("\nEmpty List!");
        free(ptr);
        return;
    }
    else{
    
    last -> next = ptr;
    ptr -> next = NULL;
    last = ptr;

    count++;
    }
}

void insert_pos(int value, int prev){
    struct node *pos,*ptr;
    
    ptr = (struct node*)malloc(sizeof(struct node));
    ptr->element = value;
    
    if(first == NULL){
        printf("\nEmpty List!");
        return;
    }else{
        
    for(pos=first;pos!=last;pos = pos->next){
        if(pos->element == prev){
            ptr->next = pos->next;
            pos->next = ptr;
        }
    }
    count++;
    }
}
int delete(int value){
    struct node *loc, *temp;
    int i;
    i = value;

    loc = search(i);
    if(loc == NULL){
        return (-9999);
    }
    if(loc == first){
        if(first == last){
            first = last = NULL;
        }
        else{
            first = first -> next;
        }
        return value;
    }
    //This for loop does not execute any instructions, but only updates the pointer
    for(temp = first; temp -> next != loc; temp = temp->next);
    //When the above condition in the for loop is satisfied
    temp -> next = loc -> next;
    //the previous and next node of the given element are linked
    if(loc == last){
        last = temp; //former last node is removed
    }
    return (loc -> element);
}

int delete_beg(){
    int temp;
    if(first == NULL){
        printf("\nEmpty List!");
        return;
    }
    else{
        temp = first->element;
        first = first->next;
    }
    return temp;
}
int delete_end(){
    struct node *pos;
    int temp;
    
    if(first == NULL){
        printf("\nEmpty List!");
        return;
    }
    else{
        for(pos=first;pos!=last;pos = pos->next){
            if(pos->next == last){
                temp = last->element;
                last = pos;
            }
        }
        return temp;
    }
}

void print(){
    struct node *ptr;

    if(first == NULL){
        printf("\nEmpty List!");
        return;
    }
    printf("LinkedList Elements :\n");
    if(first == last){
        printf("\t%d",first -> element);
        return;
    }
    for(ptr=first;ptr != last;ptr = ptr->next){
        printf("\t%d",ptr->element);
    }
    printf("\t%d",last->element);
}

void length(){
    printf("Length : %d",count);
}

int main(){
    int num1,num2, choice;
    struct node *location;

    while (1){
        /*Switch Implementation 1. Insertion 2. Deletion 3. Search 4. Print 5. Length 6.Exit*/
        printf("\nEnter choice : ");
        scanf("%d",&choice);

        switch(choice){
            case 1:
                insert_beg(5);
                insert_end(6);
                insert_end(7);
                insert_end(8);
                insert_beg(4);
                insert_end(9);
                printf("Elements Inserted!");
                break;
            case 2:
                printf("\n1. Delete Element 2. Delete First 3. Delete Last\n");
                scanf("%d",&choice);
                switch(choice){
                    case 1:
                        printf("\nEnter element to be deleted : ");
                        scanf("%d",&num1);
                        num2 = delete(num1);

                        if(num2 == -9999){
                        printf("\n%d not present in the LinkedList!",num1);
                        }
                        else
                        {
                        printf("\n%d was removed from the LinkedList!",num2);
                        }
                        break;
                    case 2:
                        num1 = delete_beg();
                        printf("The first element, %d was removed from LinkedList!",num1);
                        break;
                    case 3:
                        num1 = delete_end();
                        printf("The last element, %d was removed from LinkedList!",num1);
                        break;
                }
                break;
            case 3:
                printf("\nEnter element to be searched : ");
                scanf("%d",&num1);

                location = search(num1);
                if(location == NULL){
                    printf("%d was not found in the LinkedList!");
                }
                else{
                    if(location == last){
                        printf("%d is the last element");
                    }
                    else{
                        printf("Element '%d' is present before the Element'%d' in the LinkedList!",num1,(location -> next)->element);
                    }
                }
                break;
            case 4:
                print();
                break;
            case 5:
                length();
                break;
            case 6:
                exit(1);
                break;
            default:
                printf("Invalid Input!");
                break;
        }
    }
    
    return 0;
}
