
function queryProducts() {
	var qname = $("#qname").val()
	if (qname == null) {
		alert("请输入想要搜索的商品名!")
	} else {
		window.location.href = "query?qname=" + qname

	}

}

