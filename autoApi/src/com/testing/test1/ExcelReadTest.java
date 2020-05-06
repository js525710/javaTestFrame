package com.testing.test1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExcelReadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        KeywordOfInter keyword = new KeywordOfInter();
        
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH+mm+ss");
		String createdate = sdf.format(date);
        
		ExcelWriter excelWrite = new ExcelWriter("Cases/HTTPLogin.xlsx", "Cases/result-HTTPLogin"+createdate+".xlsx");
		ExcelReader excelCase = new ExcelReader("Cases/HTTPLogin.xlsx");
		
		//遍历sheet页面
		for (int sheetNo=0;sheetNo<excelCase.getTotalSheetNo();sheetNo++) {
			//输出sheet页的shee页名称
//			System.out.println(excelCase.getSheetName(sheetNo));
			//通过下标指定读取对应的sheet页
			excelCase.useSheetByIndex(sheetNo);
			excelWrite.useSheetByIndex(sheetNo);
			//循环读取每一行
			for(int line=0;line<excelCase.rows;line++) {
				List<String> lineContent = excelCase.readLine(line);
//				System.out.println(lineContent);
				//如果一行中前两个单元格为空或者长度为零，则为用例行。
				if ((lineContent.get(0).length() == 0 && lineContent.get(1).length() ==0 )
						||(lineContent.get(0) == null &&  lineContent.get(1) == null)) 
				{
					//通过关键字列（下标为3），选择使用的关键字
					switch(lineContent.get(3)) {
					case "post":
						String response = keyword.testPost(lineContent.get(4), lineContent.get(5));
						excelWrite.writeCell(line, 12, response);
						break;
					case "saveParam":
						keyword.saveParam(lineContent.get(4), lineContent.get(5));
						break;
					case "addHeader":
						keyword.addHeader(lineContent.get(4));
						break;
					}
					//第二步 执行校验列对应的断言
					switch (lineContent.get(7)) {
					case "equal":
						Boolean result = keyword.assertSame(lineContent.get(8), lineContent.get(9));
						if (result) {
							excelWrite.writeCell(line, 11, "PASS");
						}else {
							excelWrite.writeCell(line, 11, "FAIL");
						}
						break;
					case "contains":
						keyword.assertContains(lineContent.get(8), lineContent.get(9));
						break;
					}
				}
				
			}
			
		}
		excelWrite.save();
	}

}
