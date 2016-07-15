/**
 * Created by bright on 16-7-13.
 */
class DATA4{
    String key;
    String value;
}
public class SQType {
    static final int QUEUELEN = 10;

    DATA4[] data = new DATA4[QUEUELEN];

    int head = 0;
    int tail = 0;

    SQType init(){
        SQType p;
        if((p=new SQType())==null){
            p.head = 0;
            p.tail = 0;
            return p;
        }
        return null;
    }

    boolean SQIsEmpty(){
        return head==tail;
    }

    boolean SQIsFull(){
        return (tail-head)==QUEUELEN;
    }

    void SQTypeClear(){
        head = 0;
        tail = 0;
    }
    int inSQType(DATA4 _data){
        if(SQIsFull()){
            System.out.println("队列已满");
            return 0;
        }
        data[tail++] = _data;
        return 1;
    }

    DATA4 outSQType(){
        if(SQIsEmpty()){
            System.out.println("空队列");
            return null;
        }
        return data[head++];
    }

    DATA4 peekSQType(){
        if(SQIsEmpty()){
            System.out.println("空队列");
            return null;
        }
        return data[head];
    }

    int SQTypeLen(){
        return tail - head;
    }
}
