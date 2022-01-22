package com.github.tden27.model;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ParserExcel {
    private static final Map<Integer, String> map= new HashMap<>();

    private static String scanFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла:");
        String fileName = scanner.nextLine();
        while (!fileName.endsWith(".xlsx")) {
            System.out.println("Неверный формат файла. Попробуйте еще.");
            fileName = scanner.nextLine();
        }
        return fileName;
    }

    public static Map<Integer, String> readFromExcel() {
        String fileName = scanFileName();

        XSSFWorkbook workBook = null;
        try {
            workBook = new XSSFWorkbook(new FileInputStream(fileName));
        } catch (IOException e) {
            System.out.println("Файл не найден. Попробуйте еще.");
            readFromExcel();
            return map;
        }
        XSSFSheet sheet = workBook.getSheetAt(0);

        Iterator<Row> rows = sheet.rowIterator();

        try {
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                XSSFCell idCell = row.getCell(0);
                int id = (int) idCell.getNumericCellValue();
                XSSFCell nameCell = row.getCell(1);
                String name = nameCell.getStringCellValue();
                map.put(id, name);
            }
        } catch (Exception e) {
            System.out.println("Невозможно прочитать таблицу. Неверный формат ячеек таблицы.");
            readFromExcel();
        }
        return map;
    }

    public static Map<Integer, String> getMap() {
        return map;
    }
}
