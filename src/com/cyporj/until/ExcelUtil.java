package com.cyporj.until;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import com.cyporj.model.Cyusers;


public class ExcelUtil {
	
	public static void execlDoc(OutputStream out,List<Cyusers> u,String title,String[] head) throws IOException{
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet();
		sheet.setDefaultColumnWidth(20);
		HSSFCellStyle titleStyle=workbook.createCellStyle();
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		HSSFFont titleFont=workbook.createFont();
		titleFont.setFontHeightInPoints((short)25);
		titleStyle.setFont(titleFont);
		
	
		HSSFRow row=sheet.createRow(0);
		HSSFCell cell=row.createCell(0);
		cell.setCellStyle(titleStyle);
		cell.setCellValue(title);
	
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
	
		HSSFCellStyle headStyle=workbook.createCellStyle();
		headStyle.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);

		
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		headStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		
		
		HSSFFont headFont=workbook.createFont();
		headFont.setColor(HSSFColor.LIGHT_BLUE.index); 
		headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headFont.setFontHeightInPoints((short)16);
		headStyle.setFont(headFont);
		
	
		HSSFCellStyle dataStyle=workbook.createCellStyle();
		dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		
	
		row=sheet.createRow(1);
		for(int i=0;i<head.length;i++){
			cell=row.createCell(i);     
			cell.setCellStyle(headStyle);
			cell.setCellValue(head[i]); 
			
		}
		Cyusers us=null;
	
		for(int i=0;i<u.size();i++){
			
		    us=u.get(i);
		    row=sheet.createRow(2+i);
		    cell=row.createCell(0); 
		    cell.setCellValue(us.getCyuid());
		    cell.setCellStyle(dataStyle);
		    cell=row.createCell(1); 
		    cell.setCellValue(us.getCyuname());
		    cell.setCellStyle(dataStyle);
		    cell=row.createCell(2); 
		    cell.setCellValue(us.getCyupwd());
		    cell.setCellStyle(dataStyle);
		    cell=row.createCell(3); 
		    cell.setCellValue(us.getCyuphone());
		    cell.setCellStyle(dataStyle);
		    cell=row.createCell(4); 
		    cell.setCellValue(us.getCyuqq());
		    cell.setCellStyle(dataStyle);
		    cell=row.createCell(5); 
		    cell.setCellValue(us.getCyemail());
		    cell.setCellStyle(dataStyle);
		    cell=row.createCell(6); 
		    cell.setCellValue(us.getCyrdate());
		    cell.setCellStyle(dataStyle);
		    
		}
		
		workbook.write(out);
		
		
	}

}
