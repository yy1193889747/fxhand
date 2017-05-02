//打开字滑入效果
window.onload = function(){
	$(".connect p").eq(0).animate({"left":"0%"}, 600);
	$(".connect p").eq(1).animate({"left":"0%"}, 400);
};
//jquery.validate表单验证
$(document).ready(function(){
	//登陆表单验证
	$("#loginForm").validate({
		rules:{
			username:{
				required:true,//必填
				minlength:3, //最少6个字符
				maxlength:20,//最多20个字符
			},
			password:{
				required:true,
				minlength:6, 
				maxlength:20,
			},
		},
		//错误信息提示
		messages:{
			username:{
				required:"必须填写用户名",
				minlength:"用户名至少为3个字符",
				maxlength:"用户名至多为20个字符",
				remote: "用户名已存在",
			},
			password:{
				required:"必须填写密码",
				minlength:"密码至少为6个字符",
				maxlength:"密码至多为20个字符",
			},
		},

	});
	//注册表单验证
	$("#registerForm").validate({
		rules:{
			username:{
				required:true,//必填
				minlength:3, //最少6个字符
				maxlength:20,//最多20个字符
			},
			password:{
				required:true,
				minlength:6, 
				maxlength:20,
			},
			email:{
				required:true,
				email:true,
			},
			confirm_password:{
				required:true,
				minlength:6,
				equalTo:'.password'
			},
			phone:{
				required:true,
				phone:true,//自定义的规则
				digits:true,//整数
			},
			check:{
				required:true,
				length:4,
				digits:true,//整数
			}
		},
		//错误信息提示
		messages:{
			username:{
				required:"必须填写用户名",
				minlength:"用户名至少为3个字符",
				maxlength:"用户名至多为20个字符",
				remote: "用户名已存在",
			},
			password:{
				required:"必须填写密码",
				minlength:"密码至少为3个字符",
				maxlength:"密码至多为32个字符",
			},
			email:{
				required:"请输入邮箱地址",
				email: "请输入正确的email地址"
			},
			confirm_password:{
				required: "请再次输入密码",
				minlength: "确认密码不能少于6个字符",
				equalTo: "两次输入密码不一致",//与另一个元素相同
			},
			phone:{
				required:"请输入手机号码",
				digits:"请输入正确的手机号码",
			},
			check:{
				required:"请输入验证码",
				length:"请输入正确的验证码",
			},
		},
	});
	//添加自定义验证规则
	jQuery.validator.addMethod("phone", function(value, element) { 
		var length = value.length; 
		var phone = /^((([1-9]{1}))+\d{10})$/ ;
		return this.optional(element) || (length == 11 && phone.test(value)); 
	}, "手机号码格式错误"); 
	
});
