package fr.sparna.rdf.skos.xls2skos;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {
	private ExcelHelper() {
	}

	public static String getCellValue(Cell cell) {
		if (null == cell) return null;
		if (cell.getCellType() == Cell.CELL_TYPE_BLANK) return "";
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			double d = cell.getNumericCellValue();
			if((d % 1) == 0) {
				return "" + new Double(d).intValue();
			} else {
				return "" + d;
			}    	
		}
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) return cell.getStringCellValue();
		if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) return cell.getStringCellValue();
		throw new Xls2SkosException("Cell type unknown or unsupported: {} - {} - {}", cell.getSheet().getSheetName(), cell.getRowIndex(), cell.getColumnIndex());

		//    if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) return "" + cell.getBooleanCellValue();
		//    if(cell.getCellType() == Cell.CELL_TYPE_ERROR) return "";
		//    if(cell.getCellType() == Cell.CELL_TYPE_FORMULA) return "";
	}

	public static List<String> getColumnNames(Sheet worksheet, int rowNumber) {
		List<String> columnNames = new ArrayList<>();
		Row row = worksheet.getRow(rowNumber);
		for (int i = 0; true; i++) {
			Cell cell = row.getCell(i);
			if (null == cell) break;
			String columnName = cell.getStringCellValue();
			if (StringUtils.isBlank(columnName)) {
				break;
			}
			columnNames.add(columnName);
		}
		return columnNames;
	}
}