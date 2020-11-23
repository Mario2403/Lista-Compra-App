package com.home.listaCompra.model.excel;

import com.home.listaCompra.defs.CategoryPositionEnum;
import com.home.listaCompra.defs.FieldTypeEnum;
import com.home.listaCompra.service.ListaService;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NormalField extends Field{


    private CategoryPositionEnum position;
    public NormalField(String content) {
        super(content);
    }

    public NormalField(String nombre, CategoryPositionEnum position) {
        super(nombre);
        this.position = position;
    }

    @Override
    public FieldTypeEnum getType() {
        return FieldTypeEnum.CELDA_NORMAL;
    }

    @Override
    public CellStyle getCellStyle(XSSFWorkbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();

        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) (16 *ListaService.FONT_MULTIPLIER));
        cellStyle.setFont(font);

        if (position != null) { //Campos blancos entre categorias
            switch (position) {

                case ONLY_ONE:
                    //External boder
                    cellStyle.setBorderTop(BorderStyle.THICK);
                    cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderRight(BorderStyle.THICK);
                    cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderBottom(BorderStyle.THICK);
                    cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());


                    break;
                case FIRST:
                    //External boder
                    cellStyle.setBorderTop(BorderStyle.THICK);
                    cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderRight(BorderStyle.THICK);
                    cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

                    //Internal border
                    cellStyle.setBorderBottom(BorderStyle.THIN);
                    cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                    break;

                case MIDDLE:
                    //External border
                    cellStyle.setBorderRight(BorderStyle.THICK);
                    cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

                    //Internal border
                    cellStyle.setBorderTop(BorderStyle.THIN);
                    cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderBottom(BorderStyle.THIN);
                    cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                    break;

                case LAST:
                    //External border
                    cellStyle.setBorderBottom(BorderStyle.THICK);
                    cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderRight(BorderStyle.THICK);
                    cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

                    //Internal border
                    cellStyle.setBorderTop(BorderStyle.THIN);
                    cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                    break;
            }
        }
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
