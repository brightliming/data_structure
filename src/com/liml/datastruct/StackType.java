package com.liml.datastruct;

/**
 * Created by bright on 16-7-13.
 */
class DATA3{
    String key;
    String value;
}
public class StackType {
    static final int MAXLEN = 50;

    DATA3[] data = new DATA3[MAXLEN+1];

    int top;

    StackType STInit(){
        StackType p;
        if((p=new StackType())!=null){
            p.top = 0;
            return p;
        }

        return null;
    }

    boolean STIsEmpty(){
        return top == 0;
    }

    boolean STIsFull(){
        return top == MAXLEN;
    }

    void STClean(){
        top = 0;
    }

    int pushST(DATA3 data){
        if(top==MAXLEN){
            System.out.println("栈溢出");
            return 0;
        }

        this.data[++top] = data;
        return 1;
    }

    DATA3 pullST(){
        if(top==0){
            System.out.println("空栈");
            return null;
        }
        return data[top--];
    }

    DATA3 peekST(){
        if(top==0){
            System.out.println("空栈");
            return null;
        }
        return data[top];
    }


}
