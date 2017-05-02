		function getLength(str) {
			// \x00-xff代表单字节字符。
			return str.replace(/[^\x00-\xff]/g, "xx").length;
		}
		//注册
		var uname = document.getElementById('username');
		var phone = document.getElementById('phone');
		var pwd = document.getElementById('pwd');
		var umsg = document.getElementById('u1');
		var pmsg = document.getElementById('p1');
		var p2msg = document.getElementById('p2');
		var pp1 = document.getElementById('pp1');
		var pp2 = document.getElementById('pp2');
		var pp3 = document.getElementById('pp3');
		var code = document.getElementById('code');
		var c1 = document.getElementById('c1');
		//登录
		var phone_login = document.getElementById('phone_login');
		var phone_login1 = document.getElementById('phone_login1');
		var pwd_login = document.getElementById('pwd_login');
		var pwd_login1 = document.getElementById('pwd_login1');
		var code_login = document.getElementById('code_login');
		var code_login1 = document.getElementById('code_login1');
		window.onload = function() {

			//用户名
			uname.onfocus = function() {
				umsg.innerHTML = "";
			};

			uname.onblur = function() {
				var reg = /[^\w\u4e00-\u9fa5]/g; // \w代表“数字、字母（不分大小写）、下划线”，\u4e00-\u9fa5代表汉字。 

				//不能为空
				if (this.value == "") {
					umsg.innerHTML = '<span>请输入用户名</span>';
					uname.style.borderColor = "#ff6711";
					return false;
				}

				//长度超过25个字符
				else if (getLength(this.value) > 25) {
					umsg.innerHTML = '<span>用户名长度不能超过25位</span>';
					uname.style.borderColor = "#ff6711";
					return false;
				}

				//长度少于6个字符
				else if (getLength(this.value) < 6) {
					umsg.innerHTML = '<span>用户名长度不能少于6位</span>';
					uname.style.borderColor = "#ff6711";
					return false;
				}
				//含有非法字符            

				else if (reg.test(this.value)) {
					umsg.innerHTML = '<span>含有非法字符</span>';
					uname.style.borderColor = "#ff6711";
					return false;
				}

				else if (CheckUser(this.value) == "手机号已存在") {
					umsg.innerHTML = '<span>该用户名已存在</span>';
					uname.style.borderColor = "#ff6711";
					return false;
				}
				//OK
				else {
					return true;
					
				}
			};

			//手机号
			phone.onfocus = function() {
				pmsg.innerHTML = "";

			};
			phone.onblur = function() {
				//匹配手机号       
				var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|17[0-9])\d{8}$/; // \w代表“数字、字母（不分大小写）、下划线”，\u4e00-\u9fa5代表汉字。 

				//不能为空
				if (this.value == "") {
					pmsg.innerHTML = '<span>请输入手机号</span>';
					phone.style.borderColor = "#ff6711";
					return false;
				} else if (!reg.test(this.value)) {
					pmsg.innerHTML = '<span>手机格式不正确</span>';
					phone.style.borderColor = "#ff6711";
					return false;

				} else if (CheckPhone(this.value) == "手机号已存在") {
					pmsg.innerHTML = '<span>该手机已注册</span>';
					phone.style.borderColor = "#ff6711";
					return false;
				} else {
					return true;
				}
			};

			phone_login.onfocus = function() {
				phone_login1.innerHTML = "";
			};
			phone_login.onblur = function() {
				//匹配手机号       
				var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|17[0-9])\d{8}$/; // \w代表“数字、字母（不分大小写）、下划线”，\u4e00-\u9fa5代表汉字。 

				//不能为空
				if (this.value == "") {
					phone_login1.innerHTML = '<span>请输入手机号</span>';
					phone_login.style.borderColor = "#ff6711";

					return false;
				} else if (!reg.test(this.value)) {
					phone_login1.innerHTML = '<span>手机格式不正确</span>';
					phone_login.style.borderColor = "#ff6711";

					return false;

				} else {
					return true;
				}
			};
			//密码
			pwd.onfocus = function() {
				p2.innerHTML = "";
			};

			pwd.onkeyup = function() {
				//初始 
				if (this.value.length > 0) {
					pp1.style.backgroundColor = "#da4619";

				} else {
					pp1.style.backgroundColor = "#ddd";
					pp2.style.backgroundColor = "#ddd";
					pp3.style.backgroundColor = "#ddd";
				}
				//大于6字符为“弱”
				if (this.value.length > 5) {
					pp1.style.backgroundColor = "#ff5c00";
					pp2.style.backgroundColor = "#ddd";
					pp3.style.backgroundColor = "#ddd";
				}
				//大于8字符为“中”
				if (this.value.length > 10) {
					pp1.style.backgroundColor = "#ff5c00";
					pp2.style.backgroundColor = "#ff5c00";
					pp3.style.backgroundColor = "#ddd";
				}
				//大于10字符为“强”
				if (this.value.length > 14) {
					pp1.style.backgroundColor = "#35b558";
					pp2.style.backgroundColor = "#35b558";
					pp3.style.backgroundColor = "#35b558";
				}

			};

			// /^.*[A-Za-z0-9_\.-]+.*$/
			pwd.onblur = function() {
				var reg_n = /^.*[A-Za-z0-9_\.-]+.*$/g;

				//不能为空
				if (this.value == "") {
					p2msg.innerHTML = '<span>请输入密码</span>';
					pwd.style.borderColor = "#ff6711";
					return false;
				}
				//长度超过25个字符
				else if (getLength(this.value) > 16) {
					p2msg.innerHTML = '<span>密码长度不能超过16位</span>';
					pwd.style.borderColor = "#ff6711";
					return false;
				}

				//长度少于6个字符
				else if (getLength(this.value) < 6) {
					p2msg.innerHTML = '<span>密码长度不能少于6位</span>';
					pwd.style.borderColor = "#ff6711";
					return false;
				} else {
					return true;
				}

			};
			pwd_login.onfocus = function() {
				pwd_login1.innerHTML = "";
			};
			pwd_login.onblur = function() {
				var reg_n = /^.*[A-Za-z0-9_\.-]+.*$/g;

				//不能为空
				if (this.value == "") {
					pwd_login1.innerHTML = '<span>请输入密码</span>';
					pwd_login.style.borderColor = "#ff6711";
					return false;
				}
				//长度超过25个字符
				else if (getLength(this.value) > 32) {
					pwd_login1.innerHTML = '<span>密码长度不能超过32位</span>';
					pwd_login.style.borderColor = "#ff6711";
					return false;
				}

				//长度少于6个字符
				else if (getLength(this.value) < 6) {
					pwd_login1.innerHTML = '<span>密码长度不能少于6位</span>';
					pwd_login.style.borderColor = "#ff6711";
					return false;
				} else {
					return true;
				}

			};
			//验证码
			code.onfocus = function() {
				c1.innerHTML = "";
			};

			code.onblur = function() {

				//不能为空
				if (this.value == "") {
					c1.innerHTML = '<span>请输入动态码</span>';
					code.style.borderColor = "#ff6711";
					return false;
				} else {
					return true;
				}
			};
			code_login.onfocus = function() {
				code_login1.innerHTML = "";
			};

			code_login.onblur = function() {

				//不能为空
				if (this.value == "") {
					code_login1.innerHTML = '<span>请输入验证码</span>';
					code_login.style.borderColor = "#ff6711";
					return false;
				}

				else {
					return true;
				}
			};

		};
		//发送验证码
		function settime(obj) {
			if (phone.onblur()) {
				settime1(obj);
				$.ajax({
					url : "cyuser!sendcode.action?phone=" + phone.value,
					async : false,//改为同步方式
					type : "POST",
					data : "",
					dataType : "text",
					success : function(response) {
					}
				});
			}

		}
		//计时器
		var countdown = 60;
		function settime1(obj) {
			if (countdown == 0) {
				obj.removeAttribute("disabled");
				obj.value = "获取动态码";
				countdown = 60;
				return;
			} else {
				obj.setAttribute("disabled", true);
				obj.value = "重新发送(" + countdown + ")";
				countdown--;
			}
			setTimeout(function() {
				settime1(obj);
			}, 1000);
		}
		//检查手机验证码
		function CheckPhoneCode(phonecode) {
			var result = "";

			$.ajax({
				url : "cyuser!checkphonecode.action?phonecode=" + phonecode,
				async : false,//改为同步方式
				type : "POST",
				data : "",
				dataType : "text",
				success : function(response) {
					result = response;
				}
			});
			return result;
		}
		//检查手机号
		function CheckPhone(phone) {
			var result = "";
			$.ajax({
				url : "cyuser!checkphone.action?cyuser.cyuphone=" + phone,
				async : false,//改为同步方式
				type : "POST",
				data : "",
				dataType : "text",
				success : function(response) {
					result = response;
				}
			});
			return result;
		}
		//检查登录
		function CheckLogin(phonenumb, password) {
			var result = "";
			$.ajax({
				url : "cyuser!checkphone.action?cyuser.cyuphone=" + phonenumb
						+ "&cyuser.cyupwd=" + password ,
				async : false,//改为同步方式
				type : "POST",
				data : "",
				dataType : "text",
				success : function(response) {
					result = response;
				}
			});
			return result;
		}
		//检查用户名锁定
		function Checklock(phonenumb, password) {
			var result = "";
			$.ajax({
				url : "cyuser!checkphone.action?cyuser.cyuphone=" + phonenumb
				+ "&cyuser.cyupwd=" + password + "&cyuser.cyustat=-1",
				async : false,//改为同步方式
				type : "POST",
				data : "",
				dataType : "text",
				success : function(response) {
					result = response;
				}
			});
			return result;
		}
		//检查用户名
		function CheckUser(user) {
			var result = "";
			$.ajax({
				url : "cyuser!checkphone.action?cyuser.cyuname=" + user,
				async : false,//改为同步方式
				type : "POST",
				data : "",
				dataType : "text",
				success : function(response) {
					result = response;
				}
			});
			return result;
		}
		//注册初始
		function reg_init() {
			pwd.onfocus();
			code.onfocus();
			uname.onfocus();
			phone.onfocus();
		}
		//登录初始
		function log_init() {

			pwd_login.onfocus();
			code_login.onfocus();
			phone_login.onfocus();
		}
		//注册验证
		function sub() {
			pwd.onblur();
			code.onblur();
			uname.onblur();
			phone.onblur();
			if (pwd.onblur() && code.onblur() && uname.onblur()
					&& phone.onblur()) {
				if (CheckPhoneCode(code.value) == "动态码正确") {
					alert("注册成功");
					document.getElementById("register-form").submit();
				} else {
					alert("动态码不正确");
				}
			} else {
			}
		}
		//登录验证
		    var handlerEmbed = function (captchaObj) {
        $("#embed-submit1").click(function (e) {
            var validate = captchaObj.getValidate();
    		pwd_login.onblur();
			phone_login.onblur();
			if (pwd_login.onblur() &&  phone_login.onblur() &&validate) {
				if (CheckLogin(phone_login.value, pwd_login.value) == "手机号已存在") {
					if(Checklock(phone_login.value, pwd_login.value) != "手机号已存在"){
						document.getElementById("login-form").submit();
					} else {
						alert("该账户已被锁定，请联系管理员");
					}
				} else {
					alert("手机号或密码错误");
				}
			}
			else if (!validate) {
            	document.getElementById('gtcode').innerHTML = '<span style>请先拖动验证码到相应位置</span>';
                setTimeout(function () {
                document.getElementById('gtcode').innerHTML = '';
                }, 1000);
                e.preventDefault();
            }
        });
        // 将验证码加到id为captcha的元素里，同时会有三个input的值：geetest_challenge, geetest_validate, geetest_seccode
        captchaObj.appendTo("#embed-captcha");
        captchaObj.onReady(function () {
            $("#wait")[0].className = "hide";
        });
        // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
    };
    $.ajax({
        // 获取id，challenge，success（是否启用failback）
        url: "pc-geetest/register?t=" + (new Date()).getTime(), // 加随机数防止缓存
        type: "get",
        dataType: "json",
        success: function (data) {
            // 使用initGeetest接口
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                product: "embed", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
                offline: !data.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
            }, handlerEmbed);
        }
    });