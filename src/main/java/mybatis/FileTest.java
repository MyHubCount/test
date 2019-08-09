package mybatis;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

/**
 * @Description  创建文件 以及读取文件内容的示例
 * @Author wx
 * @DATE 2019/7/31 10:38
 **/

public class FileTest {

    public static void main(String[] args) {


        //创建文件夹，文本文件，输出类容
//        File file =new File("D://test");
//        if(!file.exists()){
//           file.mkdir();
//        }
//        try{
//            BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter("D://test/test.txt"));
//            bufferedWriter.write("HelloWorld");
//            bufferedWriter.close();
//            bufferedWriter.flush();
//        }catch (IOException e){
//
//        }

        // 读取文件内容（输入流操作），将文本内容读取到list集合中，并在控制台中输出内容。
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file = new File("D://test/test.txt");


            Long filelength = file.length();
            byte[] filecontent = new byte[filelength.intValue()];
            FileInputStream in = new FileInputStream(file);

            in.read(filecontent);
            in.close();


//            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
//            BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
//            while ((str = in.read()) != null) {
//                arrayList.add(str);
//            }
//            bf.close();
//            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回数组
        for (int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }












    }


}
