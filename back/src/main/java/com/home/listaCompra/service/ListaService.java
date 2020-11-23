package com.home.listaCompra.service;


import com.home.listaCompra.builder.LineBuilder;
import com.home.listaCompra.model.Categoria;
import com.home.listaCompra.model.excel.Field;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ListaService {

    public static final int FONT_MULTIPLIER = 1;


    public static void createLista(ArrayList<Categoria> categorias) {

        String sheetName = "Lista de la Compra";
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetName);

        LineBuilder lineBuilder =  new LineBuilder(categorias);
        ArrayList<Field> line = lineBuilder.getLine();


        int r = 3; //Comienzo de la lista

        //Titulo de la lista
        XSSFRow titleRow = sheet.createRow(0);
        XSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("COMPRA");
        CellStyle cellStyle = wb.createCellStyle();
        Font f = wb.createFont();
        f.setFontHeightInPoints((short) (34 * FONT_MULTIPLIER));
        cellStyle.setFont(f);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        f.setBold(true);
        titleCell.setCellStyle(cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 4));


        while (line != null){

            XSSFRow row = sheet.createRow(r);

            for (int c = 0; c < line.size(); c++) {
                XSSFCell cell = row.createCell(c);
                Field lineField = line.get(c);

                cell.setCellValue(lineField.getContent());
                if (lineField.isNumeric()){
                    cell.setCellType(CellType.NUMERIC);
                    cell.setCellValue(Double.parseDouble(lineField.getContent()));
                }
                if (lineField.getCellStyle(wb) != null) {
                    cell.setCellStyle(lineField.getCellStyle(wb));
                }
                if (lineField.connectWithRight()){
                    sheet.addMergedRegion(new CellRangeAddress(r, r, c, c+1));
                }

            }

            r++;
            line = lineBuilder.getLine();
        }

        for (int i = 0; i < 8; i++) {
            if (i != 2) {
                sheet.autoSizeColumn(i);
            }

            if (i == 1 || i == 4){
                sheet.setColumnWidth(i, 8000);
            }
        }

        String excelFileName = "E:/backendListaCompra/test1.xlsx";
        try {
            FileOutputStream fileOut = new FileOutputStream(excelFileName);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        //send by email
        MailService.sendMail(excelFileName);
    }


}
