package com.home.listaCompra.model.excel;

import com.home.listaCompra.defs.CategoryPositionEnum;
import com.home.listaCompra.defs.FieldTypeEnum;
import com.home.listaCompra.service.ListaService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NumberField extends Field {

    private CategoryPositionEnum position;

    public NumberField(String content) {
        super(content);
    }

    public NumberField(String cantidad, CategoryPositionEnum position) {
        super(cantidad);
        this.position = position;
    }

    @Override
    public FieldTypeEnum getType() {
        return FieldTypeEnum.CELDA_CANTIDAD;
    }

    @Override
    public CellStyle getCellStyle(XSSFWorkbook workbook) {

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) (16 * ListaService.FONT_MULTIPLIER));
        cellStyle.setFont(font);

        switch (position){

            case ONLY_ONE:
                //External border
                cellStyle.setBorderTop(BorderStyle.THICK);
                cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                cellStyle.setBorderLeft(BorderStyle.THICK);
                cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                cellStyle.setBorderBottom(BorderStyle.THICK);
                cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());

                //Internal border
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

                break;
            case FIRST:
                //External border
                cellStyle.setBorderTop(BorderStyle.THICK);
                cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                cellStyle.setBorderLeft(BorderStyle.THICK);
                cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());

                //Internal border
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
                cellStyle.setBorderBottom(BorderStyle.THIN);
                cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                break;

            case MIDDLE:
                //External border
                cellStyle.setBorderLeft(BorderStyle.THICK);
                cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());

                //Internal border
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
                cellStyle.setBorderTop(BorderStyle.THIN);
                cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                cellStyle.setBorderBottom(BorderStyle.THIN);
                cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                break;

            case LAST:
                //External border
                cellStyle.setBorderLeft(BorderStyle.THICK);
                cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                cellStyle.setBorderBottom(BorderStyle.THICK);
                cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());

                //Internal border
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
                cellStyle.setBorderTop(BorderStyle.THIN);
                cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                break;
        }
        return cellStyle;
    }

    @Override
    public boolean connectWithRight() {
        return false;
    }

    @Override
    public boolean isNumeric() {
        return true;
    }


}
