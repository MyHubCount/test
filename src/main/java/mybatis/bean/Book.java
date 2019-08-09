package mybatis.bean;

import lombok.Data;

/* *
 * @Author wx
 *
 * 使用lombok工具下的Data注解，自动生成getter和setter等方法
 * （相当于 @Getter + @Setter + @ToString + @EqualsAndHashCode + RequiredArgsConstructor）
 * @Date 2019/8/1 16:47
 */
@Data
public class Book {

    private int id ;

    private  String bookName;

    private String  bookAuthor;
}
