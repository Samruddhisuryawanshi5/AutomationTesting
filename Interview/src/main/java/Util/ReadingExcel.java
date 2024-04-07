package Util;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReadingExcel {
  /*  public static void main(String[] args) throws IOException {
        String excelPath="D:\\Selenium_Projects\\Interview\\src\\test\\resources\\DataFile\\Admin.xlsx";
        FileInputStream inputStream=new FileInputStream(excelPath);
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=workbook.getSheet("Admin_Data");
        int lastRow=sheet.getLastRowNum();

        for (int i = 0; i <=lastRow; i++) {

            XSSFRow row=sheet.getRow(i);
            int lastcol=row.getLastCellNum();
            for (int j = 0; j < lastcol; j++) {
                XSSFCell cell=row.getCell(j);
                String cell1=cell.getStringCellValue();
                System.out.println(cell1);
            }

        }



    }*/
    public List<HashMap<String, String>> readExcel(String SheetName) throws IOException {
        List<HashMap<String,String>> list=new ArrayList<>();
        String excelPath="D:\\Selenium_Projects\\Interview\\src\\test\\resources\\DataFile\\Admin.xlsx";
        FileInputStream inputStream=new FileInputStream(excelPath);
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=workbook.getSheet(SheetName);
        int lastRow=sheet.getLastRowNum();
        XSSFRow firstRow=sheet.getRow(0);
        for (int i = 1; i <=lastRow; i++) {
            HashMap<String,String> map=new HashMap<>();
            XSSFRow row=sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                map.put(readCellAsString(firstRow.getCell(j)),readCellAsString(row.getCell(j)));
            }
            list.add(map);
        }
        return list;
    }
    public static String readCellAsString(XSSFCell cell) {
        if (cell == null) {
            return ""; // Return an empty string if the cell is null
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try {
                    return cell.getStringCellValue();
                } catch (IllegalStateException e) {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}
