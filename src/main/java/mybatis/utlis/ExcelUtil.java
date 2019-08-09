package mybatis.utlis;

import mybatis.bean.Student;
import org.apache.poi.hssf.record.formula.functions.T;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
	
	 /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     *
     *
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String []title, List<Student> list) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
//        if(wb == null){
//            wb = new HSSFWorkbook();
//        }
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = hssfWorkbook.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        // 添加数据内容
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);

            // 创建单元格，并设置值
            cell = row.createCell(0);
            cell.setCellValue(list.get(i).getId());
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(list.get(i).getName());
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(list.get(i).getSex());
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(list.get(i).getAge());
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(list.get(i).getSchool());
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue(list.get(i).getGrade());
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue(list.get(i).getCount());
            cell.setCellStyle(style);
        }


        return hssfWorkbook;

        }


    }
