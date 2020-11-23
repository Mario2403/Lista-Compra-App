package com.home.listaCompra.model.excel;

import com.home.listaCompra.defs.FieldTypeEnum;
import com.home.listaCompra.service.ListaService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TitleField extends Field {

    public TitleField(String content) {
        super(content);
    }


    @Override
    public CellStyle getCellStyle(XSSFWorkbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) (24 * ListaService.FONT_MULTIPLIER));
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setWrapText(true);

        cellStyle.setBorderTop(BorderStyle.THICK);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

        cellStyle.setBorderBottom(BorderStyle.THICK);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        return cellStyle;
    }

    @Override
    public boolean connectWithRight(){
        return true;
    }

    @Override
    public boolean isNumeric() {
        return false;
    }

    @Override
    public FieldTypeEnum getType() {
        return FieldTypeEnum.TITULO_SECCION;
    }

}
