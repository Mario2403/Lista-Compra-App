package com.home.listaCompra.model.excel;

import com.home.listaCompra.defs.FieldTypeEnum;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class Field {

    FieldTypeEnum type;
    String content;
    boolean isNumeric;


    public Field(String content) {
        this.content = content;
    }

    public abstract FieldTypeEnum getType();

    public String getContent(){
        return this.content;
    }
    void setContent(String content){
         this.content = content;
    }

    public abstract CellStyle getCellStyle(XSSFWorkbook workbook);
    public abstract boolean connectWithRight();
    public abstract boolean isNumeric();

    }
