package mybatis;

import java.util.Scanner;

/**
 * @Author: wangxin * @Date: 2018/7/22 9:36 * @Description: *
 *
 * 潜逃循环的操作
 */
public class ForDemo {

   public static  void main(String[] arg){

//       for (int i=1 ;i<=9; i++){
//           for(int j=1; j<=9 ;j++){
//               System.out.println(i+"*"+j+"="+i*j);
//           }
//           System.out.println();
//       }

       Scanner input = new Scanner(System.in);
       System.out.print("请输入8位用户编号：");
       Long custNo = input.nextLong();
       int sum = 0;
       do{
           sum+=custNo%10;
           custNo=custNo/10;
       }while(custNo!=0);

       if(sum%7==0){
           System.out.println("恭喜您，中奖啦，请领取现金500万！");
       }else{
           System.out.println("很遗憾，您没有中奖，谢谢支持！");
       }
   }



   }



