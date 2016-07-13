/**
 * Created by bright on 16-7-13.
 */

class SDATA{
    String key;
    String value;
}

/**
 * 顺序表
 */
public class SLType {
    final int MAX_LENGTH = 50;
    SDATA[] DataList = new SDATA[MAX_LENGTH+1];
    int SLength;

    void initSLType(){
        SLength = 0;
    }
    int length(){
        return SLength;
    }

    int SLInsert(SDATA data,int n){
        if(SLength+1 > MAX_LENGTH){
            System.out.print("顺序表已满,不能在插入数据");
            return 1;
        }
        if(n < 1 || n>MAX_LENGTH){
            System.out.print("输入位置不正确,不能在插入数据");
            return 1;
        }

        for(int i = SLength;i>n;i--){
            DataList[i+1] = DataList[i];
        }
        DataList[n] = data;
        SLength++;
        return 0;
    }

    int SLAdd(SDATA data){
        if(SLength+1 > MAX_LENGTH){
            System.out.print("顺序表已满,不能在插入数据");
            return 1;
        }
        DataList[++SLength]=data;
        return 0;
    }
    int SLDelete(int n){
        if(n < 1|| n>MAX_LENGTH){
            System.out.print("输入位置不正确,不能在插入数据");
            return 1;
        }
        for(int i = n;n<SLength;n++){
            DataList[n]=DataList[n+1];
        }
        SLength--;
        return 0;
    }
    SDATA SLFindByNumber(int n){
        if(n < 0|| n > MAX_LENGTH){
            System.out.print("输入位置不正确,不能在插入数据");
            return null;
        }
        return DataList[n];
    }

    int SLFindByConst(String key){
        for(int i = 1;i<SLength;i++){
            if(DataList[i].key.equals(key)){
                return i;
            }
        }
        return 0;
    }

    int SLALL(){
        for(int i = 1;i<SLength;i++){
            System.out.printf("%s%s\n",DataList[i].key,DataList[i].value);
        }
        return 0;
    }
    public static void main(String[] args){
        
    }
}
