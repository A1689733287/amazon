/**
 * 
 */

function commentCheck() {
	if ($("[name=guestContent]").val() == "") {
		alert("请输入留言内容！")
		return false;
	}
	return true;
}
