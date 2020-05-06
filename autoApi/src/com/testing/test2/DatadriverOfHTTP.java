package com.testing.test2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DatadriverOfHTTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//记录执行时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH+mm+ss");
		String createdate = sdf.format(date);
		//创建excelreader对象，打开用例源文件
		ExcelReader oriCase = new ExcelReader("Cases/HTTPLogin.xlsx");
		//创建excelwriter对象，复制一份结果文件，并且打开它进行操作
		ExcelWriter resCase = new ExcelWriter("Cases/HTTPLogin.xlsx","Cases/result-"+createdate+"HTTPLogin.xlsx");
		
		DataDriverOfInter key = new DataDriverOfInter(resCase);
		//遍历所有的sheet页
		for(int sheetNo=0;sheetNo<oriCase.getTotalSheetNo();sheetNo++) {
			//指定用例文件和结果文件使用当前下标的sheet页
			oriCase.useSheetByIndex(sheetNo);
			resCase.useSheetByIndex(sheetNo);
			//循环遍历sheet页中的每一行
			for(int rowNo=0;rowNo<oriCase.rows;rowNo++) {
				//传递line,告知datadriver的方法，当前执行到哪一行，应该往哪一行写结果
				key.line = rowNo;
				//调用方法完成测试的执行和结果的写入
				//读取当前行的内容
				List<String> lineContent = oriCase.readLine(rowNo);
				//判断第一列和第二列为空，这才是我们想要的执行的用例
				if ((lineContent.get(0).length()==0 && lineContent.get(1).length()==0)||
						(lineContent.get(0)==null && lineContent.get(0)==null)||
						(lineContent.get(0).trim().equals(""))&&(lineContent.get(1).trim().equals("")))
				{
					//通过第四列，也就是关键字列，判断当前执行的操作是什么
					switch(lineContent.get(3)) {
					case "post":
						String response = key.testPost(lineContent.get(4), lineContent.get(5));
						break;
					case "saveParam":
					     key.saveParam(lineContent.get(4), lineContent.get(5));
					     break;
					case "addHeader":
						key.addHeader(lineContent.get(4));
						break;
					}
					//第二步，执行校验列对应的断言
					switch (lineContent.get(7)) {
					case "equal":
						key.assertSame(lineContent.get(8), lineContent.get(9));
						break;
					case "contains":
						key.assertContains(lineContent.get(8), lineContent.get(9));
						break;
					}
					
				}
				
			}
			
			
		}
		//sheet页遍历结束
		//完成结果页文件的保存
		resCase.save();
		
	}

}
