package com.exceldemo.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.exceldemo.entity.Emp;

public class ExcelHelper {
	

	  public static boolean checkExcelFormat(MultipartFile file) {

		  String contentType = file.getContentType();
	    if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
	      return true;
	    }

	    return false;
	  }

	  public static List<Emp> excelToTutorials(InputStream is) {
	   
		  List<Emp> list = new ArrayList<>();
		  try {
	      XSSFWorkbook workbook = new XSSFWorkbook(is);

	      Sheet sheet = workbook.getSheet("demodata");
	      int rowNumber = 0;
	      Iterator<Row> rows = sheet.iterator();


	      while (rows.hasNext()) {
	    	  Row currentRow = rows.next();

	          // skip header
	          if (rowNumber == 0) {
	            rowNumber++;
	            continue;
	          }

	          Iterator<Cell> cells = currentRow.iterator();
              int cid=0; 
              Emp emp = new Emp();
	          while (cells.hasNext()) {
	            Cell currentCell = cells.next();

	            switch (cid) {
	            case 0:
	              emp.setEid((int) currentCell.getNumericCellValue());
	              break;

	            case 1:
	              emp.setName(currentCell.getStringCellValue());
	              break;

	            case 2:
	              emp.setRole(currentCell.getStringCellValue());
	              break;

	            default:
	              break;
	            }

	            cid++;
	          }

	          list.add(emp);
	        }

	        workbook.close();

	    } catch (Exception e) {
	      e.printStackTrace();
	      }
		  return list;
	    }
	  
	      
	}


