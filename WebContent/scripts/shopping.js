function alterCount(cid) {

	// window.location.href="alterQuantity?"+cid+"_"+$("#"+cid).val()
	$.ajax({
		url : "alterCart",// 请求的servlet地址
		type : "POST",// 请求方式
		data : {
			"cid" : cid,
			"count" : $("#" + cid).val()
		},// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(total) {
			$("#cartCount").html(total);
		},// 响应成功后执行的回调方法data响应文本
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
}

// -按钮事件
function reduce(id) {

	if ($("#" + id).val() == 1) {
		$("#" + id).val(1)
	} else if ($("#" + id).val() >= 2) {
		var old = $("#" + id).val()
		$("#" + id).val(parseInt(old) - 1)
	}
	alterCount(id)
}

// +按钮事件
function increase(id) {

	var stock = $("#hpStock" + id).val()// 获得库存
	var old = $("#" + id).val()// 获得原来的数量
	console.log(stock);
	if (parseInt(old) < parseInt(stock)) {
		$("#" + id).val(parseInt(old) + 1)
		alterCount(id)
	} else {
		alert("您选择的数量超过库存!")
	}

}

function checkStock(id) {
	var stock = $("#hpStock" + id).val()// 获得库存
	var old = $("#" + id).val()// 获得原来的数量
	if (parseInt(old) > parseInt(stock)) {
		alert("您选择的数量超过库存!")
	} else {
		alterCount(id)
	}
}
