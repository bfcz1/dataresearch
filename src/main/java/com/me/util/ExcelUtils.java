package com.me.util;

import com.me.model.Item;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static List<Item> readeExcel2List(InputStream inputStream) throws Exception{
        ArrayList<Item > dataList = new ArrayList<Item>();
        try {
            //读取的时候可以使用流，也可以直接使用文件名
            XSSFWorkbook xwb = new XSSFWorkbook(inputStream);
            //循环工作表sheet
            for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
                XSSFSheet xSheet = xwb.getSheetAt(numSheet);
                if (xSheet == null) {
                    continue;
                }
                //循环行row
                for (int numRow = 0; numRow <= xSheet.getLastRowNum(); numRow++) {
                    XSSFRow xRow = xSheet.getRow(numRow);
                    if (xRow == null||xRow.getLastCellNum()<=5) {
                        continue;
                    }
                    //判断是第一行，且为表格头，那么跳过这一行。
                    try {
                        if(numRow==0&&"公司名称".equals(xRow.getCell(1)))continue;
                    } catch (Exception e) {
                    }
                    Item item = new Item();
                    try {
                        item.setCompany(getValue(xRow.getCell(1)));
                    } catch (Exception e) {
                    }
                    try {
                        item.setProject(getValue(xRow.getCell(2)));
                    } catch (Exception e) {
                    }
                    try {
                        item.setBatch(getValue(xRow.getCell(3)));
                    } catch (Exception e) {
                    }
                    try {
                        item.setAidingways(getValue(xRow.getCell(4)));
                    } catch (Exception e) {
                    }
                    try {
                        item.setAssistance(getValue(xRow.getCell(5)));
                    } catch (Exception e) {
                    }
                    dataList.add(item);
//                    for (int numCell = 0; numCell <= xRow.getLastCellNum(); numCell++) {
//                        XSSFCell xCell = xRow.getCell(numCell);
//                        if (xCell == null) {
//                            continue;
//                        }
//                        //输出值
//                        System.out.println("excel表格中取出的数据" + getValue(xCell));
//                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
    private static String getValue(XSSFCell xCell) {
        if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xCell.getBooleanCellValue());
        } else if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(xCell.getNumericCellValue());
        } else {
            return String.valueOf(xCell.getStringCellValue());
        }
    }
}
