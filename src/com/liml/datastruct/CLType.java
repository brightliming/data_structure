package com.liml.datastruct;

/**
 * Created by bright on 16-7-13.
 */
class CDATA{
    String key;
    String value;
}
public class CLType {
    CDATA data;
    CLType nextNode;

    CLType ClAddEnd(CLType head,CDATA data){
        CLType node,htemp;
        if((node=new CLType())==null){
            System.out.println("分配空间失败");
            return null;
        }
        node.data = data;
        node.nextNode = null;
        if(head == null){
            head = node;
            return head;
        }
        htemp = head;
        while(htemp.nextNode != null){
            htemp = head.nextNode;
        }
        htemp.nextNode = node;
        return head;
    }

    CLType CLAddFirst(CLType head,CDATA data){
        CLType node,htemp;
        if((node = new CLType())==null){
            System.out.println("分配空间失败");
            return null;
        }
        node.data = data;
        node.nextNode = head;
        head = node;
        return head;
    }
    CLType CLFindNode(CLType head,String key){
        CLType htemp;
        htemp = head;
        while(htemp != null){
            if(htemp.data.key.compareTo(key)==0){
                return htemp;
            }
            htemp = htemp.nextNode;
        }
        return null;
    }
    CLType CLInsertNode(CLType head,String key,CDATA data){
        CLType node,htemp;
        if((node=new CLType())==null){
            System.out.println("分配空间失败");
            return null;
        }
        node.data = data;
        htemp = CLFindNode(head,key);
        if(htemp != null){
            node.nextNode = htemp.nextNode;
            htemp.nextNode = node;
        }else{
            System.out.println("未找到正确的插入位置");
        }

        return head;
    }
    int CLDeleteNode(CLType head,String key){
        CLType node,htemp;
        node = head;
        htemp = head;
        while(htemp != null){
            if(htemp.data.key.compareTo(key)==0){
                node.nextNode = htemp.nextNode;
                htemp = null;
                return 1;
            }else{
                node = htemp;
                htemp = htemp.nextNode;
            }
        }
        return 0;
    }

    int CLLength(CLType head){
        CLType htemp = head;
        int LEN = 0;
        while(htemp != null){
            LEN++;
            htemp = htemp.nextNode;
        }
        return LEN;
    }
    void CLAllNode(CLType head){
        CLType htemp;
        CDATA data;

        htemp = head;
        while(htemp != null){
            data = htemp.data;
            htemp = htemp.nextNode;
            System.out.printf("%s%s\n",data.key,data.value);
        }
    }

}
