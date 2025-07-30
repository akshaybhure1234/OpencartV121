package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtility
{
    public FileInputStream f;
    public FileOutputStream output;
    public Workbook wb;
    public Sheet tgt_sheet;
    public Row tgt_row;
    public Cell tgt_cell;
    public CellStyle style;
    String path;

    public excelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetname) throws IOException
    {
        f = new FileInputStream(path);
        wb = WorkbookFactory.create(f);
        tgt_sheet = wb.getSheet(sheetname);
        int rowcount = tgt_sheet.getLastRowNum();
        wb.close();
        f.close();
        return rowcount;
    }

    public int getCellCount(String sheetname, int rownum) throws IOException
    {
        f = new FileInputStream(path);
        wb = WorkbookFactory.create(f);
        tgt_sheet = wb.getSheet(sheetname);
        tgt_row = tgt_sheet.getRow(rownum);
        int cellcount = tgt_row.getLastCellNum();
        wb.close();
        f.close();
        return cellcount;
    }

    public String getCellData(String sheetname, int rownum, int cellnum) throws IOException
    {
        f = new FileInputStream(path);
        wb = WorkbookFactory.create(f);
        tgt_sheet = wb.getSheet(sheetname);
        tgt_row = tgt_sheet.getRow(rownum);
        tgt_cell = tgt_row.getCell(cellnum);

        DataFormatter formatter = new DataFormatter();
        String data = "";

        try {
            data = formatter.formatCellValue(tgt_cell);
        } catch (Exception e) {
            data = "";
        }
        wb.close();
        f.close();
        return data;
    }

    public void setCellData(String sheetname, int rownum, int cellnum, String data) throws IOException
    {
        File xlfile = new File(path);
        if (!xlfile.exists()) { // If file doesn't exist, create a new file
            wb = WorkbookFactory.create(f);
            output = new FileOutputStream(path);
            wb.write(output);
        }

        f = new FileInputStream(path);
        wb = WorkbookFactory.create(f);

        if (wb.getSheetIndex(sheetname) == -1) { // If sheet doesn't exist, create a new sheet
            wb.createSheet(sheetname);
        }

        tgt_sheet = wb.getSheet(sheetname);

        if (tgt_sheet.getRow(rownum) == null) { // If row doesn't exist, create a new row
            tgt_sheet.createRow(rownum);
        }

        tgt_row = tgt_sheet.getRow(rownum);
        tgt_cell = tgt_row.createCell(cellnum);
        tgt_cell.setCellValue(data);

        output = new FileOutputStream(path);
        wb.write(output);
        wb.close();
        f.close();
        output.close();
    }

    public void fillGreenColor(String sheetName, int rownum, int cellnum) throws IOException
    {
        f = new FileInputStream(path);
        wb = WorkbookFactory.create(f);
        tgt_sheet = wb.getSheet(sheetName);
        tgt_row = tgt_sheet.getRow(rownum);
        tgt_cell = tgt_row.getCell(cellnum);
        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        tgt_cell.setCellStyle(style);

        output = new FileOutputStream(path);
        wb.write(output);
        wb.close();
        f.close();
        output.close();
    }

    public void fillRedColor(String sheetName, int rownum, int cellnum) throws IOException
    {
        f = new FileInputStream(path);
        wb = WorkbookFactory.create(f);
        tgt_sheet = wb.getSheet(sheetName);
        tgt_row = tgt_sheet.getRow(rownum);
        tgt_cell = tgt_row.getCell(cellnum);
        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        tgt_cell.setCellStyle(style);

        output = new FileOutputStream(path);
        wb.write(output);
        wb.close();
        f.close();
        output.close();
    }
}
