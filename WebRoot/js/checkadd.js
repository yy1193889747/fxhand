function getLength(str) {
	// \x00-xff代表单字节字符。
	return str.replace(/[^\x00-\xff]/g, "xx").length;
}

var select = document.getElementById("select");
var first = document.getElementById("firstLevel");
var secd = document.getElementById("secondLevel");
var title = document.getElementById("title");
var title1 = document.getElementById("title1");
var descp = document.getElementById("descp");
var descp1 = document.getElementById("descp1");
var price = document.getElementById("price");
var price1= document.getElementById("price1");
var upload = document.getElementById("upload");
var upload1 = document.getElementById("upload1");

window.onload = function() {

	//商品名称
	title.onfocus = function() {
		title1.innerHTML = "";
	};
	title.onblur = function() {
		//不能为空
		if (this.value == "") {
			title1.innerHTML = '请输入商品名称';
			return false;
		}
		//长度超过25个字符
		else if (getLength(this.value) > 32) {
			title1.innerHTML = '商品名称不能超过16个字';
			return false;
		}
		//OK
		else {
			return true;
		}
	};
	//商品描述
	descp.onfocus = function() {
		descp1.innerHTML = "";
	};
	descp.onblur = function() {
		//不能为空
		if (this.value == "") {
			descp1.innerHTML = '请输入商品描述';
			return false;
		}
		//长度超过25个字符
		else if (getLength(this.value) < 30) {
			descp1.innerHTML = '商品描述不能少于15个字';
			return false;
		}
		//OK
		else {
			return true;
		}
	};
	//商品类别
	secd.onfocus = function() {
		select.innerHTML = "";
	};
	secd.onblur = function() {
		//不能为空
		if (this.value == -1) {
			select.innerHTML = '请选择商品类别';
			return false;
		}
		//长度超过25个字符
		//OK
		else {
			return true;
		}
	};
	//商品价格
	price.onfocus = function() {
		price1.innerHTML = "";
	};

	price.onblur = function() {
			var reg = /^[1-9]\d*$/g; // \w代表“数字、字母（不分大小写）、下划线”，\u4e00-\u9fa5代表汉字。
			//不能为空
			if (this.value == "") {
				price1.innerHTML = '请输入商品价格';
				return false;
			}
			//长度超过25个字符
			else if (!reg.test(this.value)) {
				price1.innerHTML = '价格不为正整数';
				return false;
			}
			else if (this.value >100000 ) {
				price1.innerHTML = '价格过高';
				return false;
			}
			//OK
			else {
				return true;
			}
		};
		
		//商品图片
		upload.onfocus = function() {
			upload1.innerHTML = "";
		};

		upload.onblur = function() {
				var reg = /^.*[^a][^b][^c]\.(?:png|jpg|bmp|jpeg)$/g; // \w代表“数字、字母（不分大小写）、下划线”，\u4e00-\u9fa5代表汉字。
				//不能为空
				if (this.value == "") {
					upload1.innerHTML = '请选择商品图片';
					return false;
				}
				//长度超过25个字符
				else if (!reg.test(this.value)) {
					upload1.innerHTML = '图片格式不正确';
					return false;
				}
				//OK
				else {
					return true;
				}
			};

	}
    function add() {
    	var userid = "${u.cyuid }";
    	title.onblur();
    	descp.onblur();
    	secd.onblur();
    	price.onblur();
    	upload.onblur();
    	if(userid == ""){
    		alert("您还没登录，请先登录");
    	}else {
    		if (title.onblur() && descp.onblur() && secd.onblur()
    				&& price.onblur()&& upload.onblur()) {
    				alert("发布成功");
    				document.getElementById("add_form").submit();
    		} else {
    		}
		}
    	
    }
	function change() {

		var i = first.selectedIndex;
		if (i == 1) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c1 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else if (i == 2) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c2 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else if (i == 3) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c3 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else if (i == 4) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c4 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else if (i == 5) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c5 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c6 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		}

	}