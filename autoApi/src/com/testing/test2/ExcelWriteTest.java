package com.testing.test2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelWriteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH+mm+ss");
		String createdate = sdf.format(date);
		ExcelWriter excelWriter = new ExcelWriter("Cases/HTTPLogin.xlsx", "Cases/Result-HTTPLogin-"+createdate+".xlsx");
		excelWriter.writeCell(0, 15, "测试正常输入");
	    excelWriter.writeCell(0, 16, "测试异常输入");
	    excelWriter.save();
	}

}
