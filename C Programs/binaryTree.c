#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct bin_tree{
    int info;
    struct node *left,*right;
};
//to refer to bin_tree as a datatype | used to refer
typedef struct bin_tree node;
int count = 0;

node *insert(node * r,int n){
    //if no root node present
    if(r==NULL){
        r = (node *)malloc(sizeof(node)); //Allocated Memory to the new node
        r -> left = r -> right = NULL; //set both child nodes to NULL
        r -> info = n; //Assigning value to the node
        count++;
    }
    else{
        //for even no. of nodes, element stored in the left child
        if(count%2==0){
            r -> left = insert(r->left,n);
        }//otherwise element is stored on the right child
        else{
            r -> right = insert(r->right,n);
        }
    }
    return (r);
}
void display(node * r){
    /*check for any children,
    print current node*/
    if(r->left != NULL){
        display(r->left);
    }

    printf("%d\t",r->info);
    
    if (r->right!=NULL){
        display(r->right);
    }
    
}

int main(){
    struct node *root = NULL;
    int element,choice;

    while (1){
        printf("\nEnter Choice : ");
        scanf("%d",&choice);
        /* Switch Implementation 1. Insert 2. Display 3.Exit*/
        switch (choice){
        case 1:
            printf("\nEnter the Node value : ");
            scanf("%d",&element);

            root = insert(root,element);
            break;
        case 2:
            display(root);
            break;
        case 3:
            exit(1);
            break;
        default:
            printf("Invalid choice!");
            break;
        }
    }
    
    return 0;
}