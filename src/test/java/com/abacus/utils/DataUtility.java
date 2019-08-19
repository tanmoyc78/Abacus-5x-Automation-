package com.abacus.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtility {

    public static String[][] getTestData(File dataFile, String sheetName) throws InvalidFormatException, IOException {
        XSSFWorkbook book = new XSSFWorkbook(dataFile);
        XSSFSheet sheet = book.getSheet(sheetName);
        ArrayList<String[]> contents = new ArrayList<String[]>();
        Iterator<Row> rows = sheet.rowIterator();
        boolean headerExcluded = false;
        while(rows.hasNext()) {
            Row row = rows.next();
            if (!headerExcluded) {
                headerExcluded = true;
                continue;
            }
            List<Object> data = new ArrayList<Object>();
            Iterator<Cell> cells = row.cellIterator();
            while(cells.hasNext()) {
                Cell cell = cells.next();
                data.add(cell.getStringCellValue());
            }
            contents.add(data.toArray(new String[0]));
        }
        return contents.toArray(new String[0][0]);
    }

}