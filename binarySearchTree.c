#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

struct BST{
    int info;
    struct node *left,*right;
};
typedef struct BST node;

node *insert(node *r,int n){
    if(r==NULL){
        r = (node*)malloc(sizeof(node));
        r->left = r->right = NULL;
        r->info = n;
    }
    //comparing the root with the element being inserted
    else if(n < r->info){
        r->left = insert(r->left,n);
    }
    else if(n > r->info){
        r->right = insert(r->right,n);
    }
    else if (n == r->info){
        printf("Duplicate Entry!");
    }
    return r;
}

void search(node *r,int n){
    if(r==NULL){
        printf("\n%d not present in the tree!",n);
        return;
    }
    else if (n==r->info){
        printf("Element %d is found!",n);
    }
    else if (n<r->info){
        search(r->left,n);
    }
    else{
        search(r->right,n);
    }
}

int del(node **r,int n){
    if(*r==NULL){
        return (0);
    }
    else if(n < (*r)->info){
        return (del(&((*r)->left),n));
    }
    else if(n>(*r)->info){
        return (del(&((*r)->right),n));
    }
    else{
        node *ptr;
        //node with no left child
        if((*r)->left == NULL){
            ptr = *r;
            *r = (*r)->right;
            free(ptr); //deallocting memory
            return (1);
        }
        //node with no right child
        else if((*r)->right == NULL){
            ptr = *r;
            r = (*r)->left;
            free(ptr);
            return (1);
        }
        //node with both left & right child
        else{
            //inorder predecessor
            ptr = (*r)->left;
            while(ptr->right!=NULL){
                ptr = ptr->right; //rightmost node in the left sub-tree
            }
            /* attaching children nodes to inorder
            predecessor of the to be deleted node*/
            (*r)->info = ptr->info;
            return (del(&((*r)->left),ptr->info));
        }
    }
}
void display(node *r){
    if(r!=NULL){
        if(r->left != NULL){
            display(r->left);
        }
        printf("%d",r->info);
        if(r->right!= NULL){
            display(r->right);
        }
    }
}

int main(){
    struct node *root = NULL;
    int choice,element, num, flag;

    while (1){
        printf("\nEnter Choice : ");
        scanf("%d",&choice);
        /* Switch Implementation 1. Insert 2. Search 3. Delete 4. Display 5.Exit*/
        switch (choice){
        case 1:
            printf("\nEnter the Node value : ");
            scanf("%d",&element);

            root = insert(root,element);
            break;
        case 2:
            printf("\nEnter the element to be searched : ");
            scanf("%d",&num);
            search(root,num);
            break;
        case 3:
            printf("\nEnter the element to be deleted : ");
            scanf("%d",&num);
            flag = del(&root,num);
            if(flag==1){
                printf("\nElement %d was removed from the tree!",num);
            }
            else{
                printf("\nElement %d not present in the tree!");
            }
            break;
        case 4:
            display(root);
            break;
        case 5:
            exit(1);
            break;
        default:
            printf("Invalid choice!");
            break;
        }
    }
    return 0;
}