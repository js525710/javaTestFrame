/**
 * 
 */
function loginAjax(){
	$.ajax({
		url: "./LoginClass",
		type: "post",
		dataType: "text",
		data: $("#loginForm").serialize(),
		success: function(result){
//			alert(result);
			document.getElementById("msgDiv").innerText=result;
			
		},
		error: function(result){
//			alert("接口请求出错！");
			document.getElementById("msgDiv").innerText="接口错误，请检查！";
		}
	})
}