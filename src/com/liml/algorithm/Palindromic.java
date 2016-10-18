package com.liml.algorithm;

import java.util.Scanner;

/**
 * Created by bright on 16-10-18.
 */
public class Palindromic {
    public static void main(String[] args){

        if(args.length<=0){
            System.out.println("请输入序列的长度");
            System.exit(0);
        }
        int n = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        int[] sequnce = new int[n];

        int i = 0;
        while(i < n){
            sequnce[i] = scanner.nextInt();
            i++;
        }

        int head = 0;
        int tail = sequnce.length-1;
        int count = 0;
        System.out.println(calculateCount(sequnce,head,tail,count));

    }

    public static int calculateCount(int[] sequnce,int head,int tail,int count){
        int first = sequnce[head];
        int last = sequnce[tail];

        if(first != last){
            if(first < last){
                head++;
                sequnce[head] = first + sequnce[head];
            }else{
                tail--;
                sequnce[tail] = last + sequnce[tail];
            }
            count++;
        }else{
            if(++head != tail){
                tail--;
            }
        }

        if(head != tail){
            count = calculateCount(sequnce,head,tail,count);
        }
        return count;

    }


}
