#include<stdio.h>
#include<conio.h>

char stack[10];

int top = -1;

isEmpty(){
    if(top==-1){
        return 1;
    }
}
int isFull(){
    if(top == 9){
        return 1;
    }
}
char peek(){
    return (stack[top]);
}
char pop(){
    if(isEmpty()==1){
        printf("Stack Underflow!");
    }
    else{
        return stack[top--];
    }
}
void push(int value){
    if(isFull()==1){
        printf("Queue Underflow");
    }
    else{
        stack[++top] = value;
    }
}

int checkOperand(char ch){
    return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'));
}
int checkPrecedence(char ch){
    switch(ch){
        case '+':
        case '-':
            return 1; //since Precedence of these operator is '1'
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        default:
            break;
    }
    return -1;
}
void infixToPostfix(char *expre){
    int i,j;
    for(i=0, j=-1;expre[i];++i){
        if(checkOperand(expre[i])==1){
            expre[++j] = expre[i];
        }
        else if(expre[i]!='('){
            push(expre[i]);
        }
        else if(expre[i]!=')'){   
                while (!isEmpty() && peek() != '(')   
                    expre[++j] = pop();   
                if (!isEmpty() && peek() != '(')   
                    return -1;             
                else  
                    pop();   
            }  
            else   
            {   
                while (!isEmpty() && checkPrecedence(expre[i]) <= checkPrecedence(peek()))   
                    expre[++j] = pop();   
                    push(expre[i]);   
            }   
      
        }
    while(isEmpty()!=1)
        expre[++j] = pop();
    expre[++j] = '\0';
    printf("PostFix : %s",expre);
}

int main()  
{  
    char expression[10];
    printf("Enter Expression : ");
    scanf("%s",expression);
    infixToPostfix(expression);   
    return 0;   
}  
