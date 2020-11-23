package com.home.listaCompra.model.excel;

import com.home.listaCompra.defs.FieldTypeEnum;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RightTitleField extends Field {


    public RightTitleField() {
        super("");
    }

    @Override
    public FieldTypeEnum getType() {
        return FieldTypeEnum.DERECHA_TITULO;
    }

    @Override
    public CellStyle getCellStyle(XSSFWorkbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setBorderTop(BorderStyle.THICK);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

        return cellStyle;
    }

    @Override
    public boolean connectWithRight() {
        return false;
    }

    @Override
    public boolean isNumeric() {
        return false;
    }
}
