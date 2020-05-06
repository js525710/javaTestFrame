package com.testing.test0;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.jayway.jsonpath.JsonPath;

public class UploadTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub

		HttpClient client = HttpClients.createDefault();
		HttpPost uploadPost = new HttpPost("http://www.testingedu.com.cn:8000/index.php/home/Uploadify/imageUp/savepath/head_pic/pictitle/banner/dir/images.html");
		
		//创建multipartentitybuilder,用于完成请求的封装
		MultipartEntityBuilder mtpEn = MultipartEntityBuilder.create();
		//将每个请求的部分进行封装
		File uploadfile = new File("E:\\1.jpg");
		mtpEn.addBinaryBody("File", uploadfile);
		mtpEn.addTextBody("id","WU_FILE_0" );
		mtpEn.addTextBody("name", "1.jpg");
		//通过multipartbuilder创建实体
		HttpEntity uploadEn = mtpEn.build();
		uploadPost.setEntity(uploadEn);
		
		//执行请求
		HttpResponse uploadRes = client.execute(uploadPost);
		String uploadResult = EntityUtils.toString(uploadRes.getEntity());
		System.out.println(uploadResult);
//		String res = JsonPath.read(uploadResult, "$.state");
//		System.out.println(res);
		
		
		
		
	}

}
