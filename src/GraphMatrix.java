import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/24.
 */
public class GraphMatrix {
    static final int MaxNum = 20;
    static final int MaxValue = 65535;
    char[] vertex = new char[MaxNum];
    int Gtype;
    int vertexNum;
    int edgeNum;
    int[][] edgeWeight = new int[MaxNum][MaxNum];
    int[] isTrav = new int[MaxNum];

    static Scanner input = new Scanner(System.in);

    static void createGraph(GraphMatrix GM){
        int i,j,k;
        int weight;
        char EstartV,EendV;

        System.out.println("输入图中个顶点信息\n");

        for(i=0;i<GM.vertexNum;i++){
            System.out.printf("第%d条边",i+1);
            GM.vertex[i] = input.next().toCharArray()[0];
        }

        System.out.println("输入构成各边的顶点及权值:\n");

        for(k=0;k<GM.edgeNum;k++){
            System.out.printf("第%d条边",k+1);
        }
        EstartV = input.next().charAt(0);
        EendV = input.next().charAt(0);
        weight = input.nextInt();
        for(i=0;EstartV!=GM.vertex[i];i++);
        for(j=0;EendV!=GM.vertex[j];j++);
        GM.edgeWeight[i][j] = weight;
        if(GM.Gtype==0){
            GM.edgeWeight[j][i] = weight;
        }
    }

    static void clearGraph(GraphMatrix GM){
        int i,j;
        for(i=0;i<GM.vertexNum;i++){
            for(j=0;j<GM.vertexNum;j++){
                GM.edgeWeight[i][j] = GM.MaxValue;
            }
        }
    }
    static void outGraph(GraphMatrix GM){
        int i,j;
        for(j=0;j<GM.vertexNum;j++){
            System.out.printf("\t%c",GM.vertex[j]);
        }
        for(i=0;i<GM.vertexNum;i++){
            System.out.printf("%c",GM.vertex[i]);
            for(j=0;j< GM.vertexNum;j++){
                if(GM.edgeWeight[i][j]==GM.MaxValue){
                    System.out.printf("\tZ");
                }
                else{
                    System.out.printf("\t%d",GM.edgeWeight[i][j]);
                }
            }
        }
        System.out.printf("\n");
    }
    static void deepTraOne(GraphMatrix GM,int n){
        int i;
        GM.isTrav[n] = 1;
        System.out.printf("->%c",GM.vertex[n]);

        for(i=0;i<GM.vertexNum;i++){
            if(GM.edgeWeight[n][i] != GM.MaxValue && GM.isTrav[i]==0){
                deepTraOne(GM,i);
            }
        }
    }

    static void deepTraGraph(GraphMatrix GM){
        int i;

        for(i=0;i<GM.vertexNum;i++){
            GM.isTrav[i] = 0;
        }

        System.out.printf("深度优先遍历节点");

        for(i=0;i<GM.vertexNum;i++){
            if(GM.isTrav[i]==0){
                deepTraOne(GM,i);
            }
        }
        System.out.printf("\n");
    }
}
