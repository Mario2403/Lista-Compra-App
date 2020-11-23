package com.home.listaCompra.model.excel;

import com.home.listaCompra.defs.FieldTypeEnum;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainTitleField extends Field {


    public MainTitleField(String content) {
        super(content);
    }

    @Override
    public FieldTypeEnum getType() {
        return FieldTypeEnum.TITULO_PRINCIPAL;
    }

    @Override
    public CellStyle getCellStyle(XSSFWorkbook workbook) {
        return null;
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
