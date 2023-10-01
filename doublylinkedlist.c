#include<stdio.h>
#include<conio.h>

struct dl_node{
    int element;
    struct dl_node *next;
    struct dl_node *prev;
};
struct dl_node *first = NULL;
struct dl_node *last = NULL;

struct dl_node *search (int value){
    struct dl_node *ptr;

    if(first == NULL){
        return NULL;
    }
    if(first==last && first->element == value){
        return first;
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

void insert(int value){
    struct dl_node *ptr = (struct dl_node*)malloc(sizeof(struct dl_node));

    ptr -> element = value;
    //linking new node to the Doubly LinkedList
    if(first == NULL){
        first = last = ptr;
        ptr -> next = NULL;
        ptr -> prev = NULL;
    }
    else{
        last -> next = ptr; 
        ptr -> next = NULL; //ptr becomes the last element
        ptr -> prev = last;
        last = ptr;
    }
}
int delete(int value){
    struct dl_node *loc, *temp;
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
            /* breaking the link between First and Second Node*/
            first -> next -> prev = NULL;  //first element is removed from Doubly LL
            first = first -> next; 
        }
        return value;
    }
    //This for loop does not execute any instructions, but only updates the pointer
    for(temp = first; temp -> next != loc; temp = temp->next);
    //When the above condition in the for loop is satisfied
    if(loc == last){
        last = temp; //former last dl_node is removed
        temp -> next = NULL; 
    }
    else{
        //the previous and next node of the removed element are linked
        temp -> next = loc -> next;
        loc -> next -> prev = temp; //previous pointer is updated accordingly
    }
    return (loc -> element);
}
void print(){
    struct dl_node *ptr;

    if(first == NULL){
        printf("\nEmpty List!");
        return;
    }
    printf("Doubly LinkedList Elements :\n");
    if(first == last){
        printf("\t%d",first -> element);
        return;
    }
    for(ptr=first;ptr != last;ptr = ptr->next){
        printf("\t%d",ptr->element);
    }
    printf("\t%d",last->element);
}

int main(){
    int num1,num2, choice;
    struct dl_node *location;

    while (1){
        /*Switch Implementation 1. Insertion 2. Deletion 3. Search 4. Print 5. Exit*/
        printf("\nEnter choice : ");
        scanf("%d",&choice);

        switch(choice){
            case 1:
                printf("\nEnter element : ");
                scanf("%d",&num1);
                insert(num1);
                break;
            case 2:
                printf("\nEnter element to be deleted : ");
                scanf("%d",&num1);
                num2 = delete(num1);

                if(num2 == -9999){
                    printf("\n%d not present in the Doubly LinkedList!",num1);
                }
                else
                {
                    printf("\n%d was removed from the Doubly LinkedList!",num2);
                }
                break;
            case 3:
                printf("\nEnter element to be searched : ");
                scanf("%d",&num1);

                location = search(num1);
                if(location == NULL){
                    printf("%d was not found in the Doubly LinkedList!");
                }
                else{
                    if(location == last){
                        printf("%d is the last element");
                    }
                    else{
                        printf("Element '%d' is present before the Element'%d' in the Doubly LinkedList!",num1,(location -> next)->element);
                    }
                }
                break;
            case 4:
                print();
                break;
            case 5:
                exit(1);
                break;
            default:
                printf("Invalid Input!");
                break;
        }
    }
    
    return 0;
}