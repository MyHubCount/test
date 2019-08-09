package mybatis.utlis;

import mybatis.bean.Book;
import mybatis.bean.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDemo2 {

    public static void main(String arg[]) {


         int id = 2;
        //设置书籍字段的信息
        String bookName = "资治通鉴,增广贤文,伤寒论,论中国,曾国藩全集";
        String[] bookNames = bookName.split(",");
        System.out.println("此时书籍数组的长度是：" + bookNames.length);
        List<String> list1 = Arrays.asList(bookNames);
        System.out.println("此时书籍集合的长度是：" + list1.size());

//        //1.动态创建对象，将书名动态添加到每个对象的对应属性里面
//        for(int i=0;i<list1.size();i++){
//            Book book=new Book();
//            book.setBookName(list1.get(i));
//
//        }
        //2.如何将动态创建出来的对象添加到新的list里面
        List<Book> bookList= new ArrayList<>();
        for (int i=0;i<list1.size();i++){
            Book book=new Book();
            book.setBookName(list1.get(i));
            bookList.add(book);
        }


    //    bookList.add(book);


//        Book book1 = new Book();


//        book1.setId(id);
//        book1.setBookName(list1.get(0));
//        Book book2 = new Book();
//        book2.setId(id);
//        book2.setBookName(list1.get(1));
//        Book book3 = new Book();
//        book3.setId(id);
//        book3.setBookName(list1.get(2));
//        Book book4 = new Book();
//        book4.setId(id);
//        book4.setBookName(list1.get(3));
//        Book book5 = new Book();
//        book5.setId(id);
//        book5.setBookName(list1.get(4));
//
//        List<Book> list=new ArrayList<>();
//        list.add(book1);
//        list.add(book2);
//        list.add(book3);
//        list.add(book4);
//        list.add(book5);


    }


}
