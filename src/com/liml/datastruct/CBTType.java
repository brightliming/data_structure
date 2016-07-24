package com.liml.datastruct;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/23.
 */
public class CBTType {
    String data;
    CBTType left;
    CBTType right;

    static final int MAXLEN = 20;
    static Scanner input = new Scanner(System.in);

    CBTType initTree(){
        CBTType node;

        if((node=new CBTType()) != null){
            System.out.println("请先输入一个根节点数据：");
            node.data = input.next();
            node.left = null;
            node.right = null;
            if(node != null){
                return node;
            }
            return null;
        }
        return null;
    }
    CBTType treeFindNode(CBTType treeNode,String data){
        CBTType ptr;
        if(treeNode==null){
            return null;
        }
        if(treeNode.data.equals(data)){
            return treeNode;
        }else{
            if((ptr = treeFindNode(treeNode.left,data))!=null){
                return ptr;
            }
            else if((ptr = treeFindNode(treeNode.right,data))!=null){
                return ptr;
            }
            else{
                return null;
            }
        }
    }

    void addTreeNode(CBTType treeNode){
        CBTType pnode,parent;
        String data;
        int menusel;

        if((pnode=new CBTType())!=null){
            System.out.println("输入二叉树节点数据：\n");
            pnode.data = input.next();
            pnode.left = null;
            pnode.right = null;

            System.out.println("输入该节点的父节点数据：");
            data = input.next();

            parent = treeFindNode(treeNode,data);

            if(parent == null){
                System.out.println("未找到该父节点！\n");
                pnode = null;
                return;
            }
            System.out.println("1.添加该节点到左子树\n2.添加该节点到右子树\n");
            do{
                menusel = input.nextInt();
                if(menusel==1||menusel==2){
                    if(parent == null){
                        System.out.println("不存在父节点，请先设置父节点！");
                    }
                    else{
                        switch(menusel){
                            case 1:
                                if(parent.left != null){
                                    System.out.println("左子树不为空");
                                }else{
                                    parent.left = pnode;
                                }
                                break;
                            case 2:
                                if(parent.right != null){
                                    System.out.println("左子树不为空");
                                }else{
                                    parent.right = pnode;
                                }
                                break;
                            default:
                                System.out.println("无效参数");
                        }
                    }
                }
            }while(menusel != 1 && menusel != 2);
        }
    }

    CBTType treeLeftNode(CBTType treeNode){
        if(treeNode != null){
            return treeNode.left;
        }
        else{
            return null;
        }
    }
    CBTType treeRightNode(CBTType treeNode){
        if(treeNode != null){
            return treeNode.right;
        }
        else{
            return null;
        }
    }
    int treeIsEmpty(CBTType treeNode){
        if(treeNode != null){
            return 0;
        }
        else{
            return 1;
        }
    }

    int treeDepth(CBTType treeNode){
        int depthleft;
        int depthright;
        if(treeNode == null){
            return 0;
        }
        else{
            depthleft = treeDepth(treeNode.left);
            depthright = treeDepth(treeNode.right);
            if(depthleft>depthright){
                return depthleft+1;
            }
            else{
                return depthright+1;
            }
        }
    }

    void clearTree(CBTType treeNode){
        if(treeNode != null){
            clearTree(treeNode.left);
            clearTree(treeNode.right);
            treeNode = null;
        }
    }
    void treeNodeData(CBTType treeNode){
        System.out.printf("%s",treeNode.data);
    }
    void levelTree(CBTType treeNode){
        CBTType p;
        CBTType[] q = new CBTType[MAXLEN];

        int head=0,tail=0;
        if(treeNode != null){
            tail = (tail+1) % MAXLEN;
            q[tail] = treeNode;
        }
        while(head!=tail){
            head = (head+1) % MAXLEN;
            p = q[head];
            treeNodeData(p);
            if(p.left != null){
                tail = (tail+1) % MAXLEN;
                q[tail] = p.left;
            }
            if(p.right != null) {
                tail = (tail + 1) % MAXLEN;
                q[tail] = p.right;
            }
        }
    }

    void DLRTree(CBTType treeNode){
        if(treeNode != null){
            treeNodeData(treeNode);
            DLRTree(treeNode.left);
            DLRTree(treeNode.right);
        }
    }
    void LDRTree(CBTType treeNode){
        if(treeNode != null){
            LDRTree(treeNode.left);
            treeNodeData(treeNode);
            LDRTree(treeNode.right);
        }
    }
    void LRDTree(CBTType treeNode){
        if(treeNode != null){
            LRDTree(treeNode.left);
            LRDTree(treeNode.right);
            treeNodeData(treeNode);
        }
    }
}
