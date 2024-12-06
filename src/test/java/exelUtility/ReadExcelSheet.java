package exelUtility;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;


import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcelSheet {
    public void readData(String fileName) throws IOException {

        File file =    new File("E:\\TestData\\TestData.xls");
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);

        HSSFSheet sheet=wb.getSheet("STUDENT_DATA");

        HSSFSheet sheet1=wb.getSheetAt(1);

        HSSFRow row1=sheet.getRow(1);

        HSSFCell cell=row1.getCell(0);

        //Get the address in a variable
        String address= cell.getStringCellValue();
    }
}