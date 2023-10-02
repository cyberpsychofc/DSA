#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct bin_tree{
    int info;
    struct node *left,*right;
};

typedef struct bin_tree node;

int count = 0;

node *insert(node *r,int n){
    if(r==NULL){
        r = (node *)malloc(sizeof(node));
        r ->left = r->right = NULL;
        r ->info = n;
        count++;
    }
    else{
        if(count%2==0){
            r ->left = insert(r ->left,n);
        }
        else{
            r ->right = insert(r->right,n);
        }
    }
    return(r);
}

void preorder(node *r){
    if(r!=NULL){
        printf("%d",r->info); //root
        printf("\n");
        preorder(r->left);  //left sub-tree
        printf("\n");
        preorder(r->right); //right sub-tree
    }
}
void inorder(node *r){
    if (r!=NULL){
        inorder(r->left); //left sub-tree
        printf("\n");
        printf("%d",r->info); //root
        printf("\n");
        inorder(r->right); //right sub-tree
    }
}
void postorder(node *r){
    if(r!=NULL){
        postorder(r->left); //left sub-tree
        printf("\n");
        postorder(r->right); //right sub-tree
        printf("\n");
        printf("%d",r->info); //root
    }
}

int main(){
    struct node *root = NULL;
    int element,choice;

    while (1){
        printf("\nEnter Choice : ");
        scanf("%d",&choice);
        /* Switch Implementation 1. Insert 2. Preorder 3. Inorder 4. Postorder 5.Exit*/
        switch (choice){
        case 1:
            printf("\nEnter the Node value : ");
            scanf("%d",&element);

            root = insert(root,element);
            break;
        case 2:
            preorder(root);
            break;
        case 3:
            inorder(root);
            break;
        case 4:
            postorder(root);
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