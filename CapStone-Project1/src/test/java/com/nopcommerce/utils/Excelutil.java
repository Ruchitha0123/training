package com.nopcommerce.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class Excelutil {

    // ✅ Corrected path
    private static final String FILE_PATH = System.getProperty("user.dir")
            + "/src/test/resources/testdata/Book.xlsx";

    public static String getData(String sheetName, int row, int col) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row r = sheet.getRow(row);
        Cell c = r.getCell(col);

        String value = "";
        if (c != null) {
            value = c.toString();
        }

        workbook.close();
        fis.close();
        return value.trim();
    }
}
