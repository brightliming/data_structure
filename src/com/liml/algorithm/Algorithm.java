package com.liml.algorithm;

/**
 * Created by Administrator on 2016/7/24.
 */
public class Algorithm {
    /**
     * 鸡兔同笼问题，穷举算法
     * @param head
     * @param foot
     */
    void qiongJu(int head,int foot){
        int chicken=0,rabbit=0;
        int i,j;
        for(i=0;i<=head;i++){
            j = head - i;
            if((2*i+4+j) == foot){
                chicken = i;
                rabbit = j;
            }
        }
        System.out.printf("鸡的数量:%d,兔子的数量:%d",chicken,rabbit);
    }

    /**
     * 兔子产仔问题，斐波那契函数，递推算法
     * @param n
     * @return
     */
    int fibonacci(int n){
        int t1,t2;
        if(n==1||n==2){
            return 1;
        }
        else{
            t1 = fibonacci(n-1);
            t2 = fibonacci(n-2);
            return t1 + t2;
        }
    }

    /**
     * 求阶乘，递归算法
     * @param n
     * @return
     */
    long fact(int n){
        if(n<=1){
            return 1;
        }
        else{
            return n*fact(n-1);
        }
    }
    /**
     * 找假币，分治算法
     * @param coin
     * @param low
     * @param high
     * @return
     */
    int falseCoin(int coin[],int low,int high){
        int i,sum1,sum2,sum3;
        int re = 0;
        sum1 = sum2 = sum3 = 0;
        if(low+1==high){
            if(coin[low]<coin[high]){
                re = low + 1;
                return re;
            }
            else{
                re=high+1;
                return re;
            }
        }
        //n是偶数
        if((high-low+1)%2==0){
            for(i=low;i<=(high-low)/2;i++){
                sum1 = sum1 + coin[i]; //前半段的和
            }
            for(i=(high-low+1)/2;i<=high;i++){
                sum2 = sum2 + coin[i]; //后半段的和
            }
            if(sum1 > sum2){
                re = falseCoin(coin,(high-low+1)/2,high);
                return re;
            }
            else if(sum2 > sum1){
                re = falseCoin(coin,low,(high-low)/2);
                return re;
            }
            else{}
        }else{
            for(i=low;i<=low+(high-low)/2-1;i++){
                sum1 = sum1 + coin[i];
            }
            for(i=low+(high-low)/2+1;i<high;i++){
                sum2 = sum2 + coin[i];
            }
            sum3 = coin[low+(high-low)/2];
            if(sum1>sum2){
                re = falseCoin(coin,low+(high-low)/2+1,high);
                return re;
            }
            else if(sum1<sum2){
                re = falseCoin(coin,low,low+(high-low)/2-1);
                return re;
            }
            else{
                re = low+(high-low)/2;
                return re;
            }
        }
        return re;
    }

    /**
     * 概率算法，蒙特卡罗算法求PI
     * @param n
     * @return
     */
    static double montePI(int n){
        double PI;
        double x,y;
        int i,sum=0;
        for(i=0;i<n;i++){
            x = Math.random();
            y = Math.random();
            if(x*x+y*y<=1){
                sum++;
            }
        }
        PI = 4.0*sum/n;
        return PI;
    }
    public static void main(String[] args){
        System.out.println(montePI(999999));
    }
}
