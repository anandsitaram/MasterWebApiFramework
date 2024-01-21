package com.tricentis.common.utils;

import com.tricentis.common.constants.FrameworkConstants;
import com.tricentis.common.exceptions.FrameworkException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Calendar;
import java.util.Objects;

public final class ExcelUtil {

    private ExcelUtil() {

    }

    private static Workbook workbook;
    private static Sheet sheet;

    private static FileInputStream fileInputStream;

    private static Workbook initInputWorkBook(String filePath) {
        String fileExtension = FilenameUtils.getExtension(filePath);
        try {
            if (fileExtension.equals("xlsx")) {
                return new XSSFWorkbook(fileInputStream);
            } else {
                return new HSSFWorkbook(fileInputStream);
            }
        } catch ( IOException e) {
            throw new FrameworkException("Problem in initializing the workbook");
        }
    }

    private static Workbook initWorkBook(String filePath) {
        String fileExtension = FilenameUtils.getExtension(filePath);
        try {
            if (fileExtension.equals("xlsx")) {
                return new XSSFWorkbook();
            } else {
                return new HSSFWorkbook();
            }
        } catch (Exception e) {
            throw new FrameworkException("Problem in initializing the workbook");
        }
    }

    public static String getCellValue(String filePath, String sheetName, int row, int col) {
        try {
            fileInputStream = new FileInputStream(filePath);
            workbook = initInputWorkBook(filePath);
            sheet = workbook.getSheet(sheetName);
            Cell cell = sheet.getRow(row).getCell(col);
            workbook.close();
            fileInputStream.close();
            return getCellText(cell);

        } catch (IOException e) {
            throw new FrameworkException("Problem in getting the value from cell");
        }
    }

    public static String getCellValue(int row, int col) {
        try {
            fileInputStream = new FileInputStream("filePath");
            workbook = initInputWorkBook("filePath");
            sheet = workbook.getSheetAt(0);
            Cell cell = sheet.getRow(row).getCell(col);
            workbook.close();
            fileInputStream.close();
            return getCellText(cell);

        } catch (IOException e) {
            throw new FrameworkException("Problem in getting the value from cell");
        }
    }

    public static Object[][] getExcelData(String filePath, String sheetName) {
        Object[][] retobj = null;
        try {

            fileInputStream = new FileInputStream(filePath);
            initInputWorkBook(filePath);
            sheet = workbook.getSheet(sheetName);
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum() + 1;
            int firstCol = sheet.getRow(firstRow).getFirstCellNum();
            int colsCnt = sheet.getRow(firstRow).getLastCellNum();
            retobj = new Object[lastRow - firstRow][colsCnt - firstCol];

            for (int row = firstRow; row < lastRow; row++) {

                for (int col = firstCol; col < colsCnt; col++) {
                    retobj[row - firstRow][col - firstCol] = sheet.getRow(row).getCell(col);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FrameworkException("File not found");
        }

        return retobj;

    }

    private static String getCellText(Cell cell) {
        String cellText = "";
        if (Objects.isNull(cell)) {
            return "";
        }
        if (cell.getCellType() == CellType.STRING) {
            cellText = cell.getStringCellValue();

        } else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
            cellText = String.valueOf(cell.getNumericCellValue());
            if (DateUtil.isCellDateFormatted(cell)) {
                double d = cell.getNumericCellValue();
                Calendar cal = Calendar.getInstance();
                cal.setTime(DateUtil.getJavaDate(d));
                String year = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                String month = String.valueOf((Integer.valueOf(cal.get(Calendar.MONTH))) + 1);
                cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + month + "/" + year;
            }

        } else if (cell.getCellType() == CellType.BOOLEAN) {
            cellText = String.valueOf(cell.getBooleanCellValue());
        }
        return cellText;

    }

    public static void generateReport(Object[][] data) {
        try {
            File file = new File(FrameworkConstants.USERDIR + "/Report.xlsx");

            if (file.exists()) {
                FileUtils.delete(file);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook = initWorkBook(FrameworkConstants.USERDIR + "/Report.xlsx");
            sheet = workbook.createSheet();
            Font header = workbook.createFont();
            header.setBold(true);
            header.setColor(IndexedColors.BLACK.getIndex());
            CellStyle tcs = workbook.createCellStyle();
            tcs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            tcs.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            tcs.setFont(header);
            tcs.setWrapText(true);
            tcs.setAlignment(HorizontalAlignment.CENTER_SELECTION);

            CellStyle tcs1 = workbook.createCellStyle();
            tcs1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            tcs1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            tcs1.setFont(header);
            tcs1.setWrapText(true);

            CellStyle tcs2 = workbook.createCellStyle();
            tcs2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            tcs2.setFillForegroundColor(IndexedColors.RED.getIndex());
            tcs2.setFont(header);
            tcs2.setWrapText(true);

            CellStyle tcs3 = workbook.createCellStyle();
            tcs3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            tcs3.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
            tcs3.setFont(header);
            tcs3.setWrapText(true);

            int rowLength = data.length;
            int col = 0;
            for (int i = 1; i <= rowLength; i++) {
                Row row = sheet.createRow(i);
                int col1 = data[i - 1].length;
                col = col1;
                for (int j = 0; j < col; j++) {
                    Cell cell = row.createCell(j);
                    sheet.autoSizeColumn(j);
                    if (i == 1) {
                        cell.setCellStyle(tcs);

                    }
                    Object dt = data[i - 1][j];
                    cell.setCellValue(dt.toString());
                    if (dt.toString().equals("PASSED")) {
                        cell.setCellStyle(tcs1);
                    }
                    if (dt.toString().equals("FAILURE")) {
                        cell.setCellStyle(tcs2);
                    }
                    if (dt.toString().equals("SKIPPED")) {
                        cell.setCellStyle(tcs3);
                    }
                }
            }
            CellRangeAddress cellAddresses = new CellRangeAddress(0, rowLength, 0, col - 1);
            PropertyTemplate pt = new PropertyTemplate();
            pt.drawBorderColors(cellAddresses, (short) 0, BorderExtent.ALL);
            pt.applyBorders(sheet);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, col - 1));
            Cell cell0 = sheet.createRow(0).createCell(0);
            cell0.setCellValue("Report Generated Date : - " + DateUtils.getDateTime());
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new FrameworkException("Problem in generating the report");
        }

    }


}
