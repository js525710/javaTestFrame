package com.testing.suanfa;

public class YangHui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义有多少层
		int yh=11;
		//定义两个数组
		int[] arr1=new int[yh];
		int[] arr2=new int[yh];
		arr1[0]=1;
		//外层循环
		for(int ceng=1;ceng<=yh;ceng++) {
			//内层循环
			for(int xb=0;xb<=ceng-1;xb++) {
				if(xb==0||xb==ceng-1) {
					arr2[xb]=1;
				}else {
					arr2[xb]=arr1[xb]+arr1[xb-1];
				}
			}
			//计算空格并输出空格
			int space=(yh-ceng)*4/2;
			String format="%"+space+"s";
			if (space!=0) {
				System.out.format(format, "");
			}
			//把arr2赋值给arr1
			for(int i=0;i<=ceng-1;i++) {
				arr1[i]=arr2[i];
			}
			//输出数值
			for(int j=0;j<=ceng-1;j++) {
				System.out.format("%-4d",arr2[j]);
			}
			System.out.println();
		}
		
		

	}

}
