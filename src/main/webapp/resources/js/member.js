function delUser(){
	var chkArr = $("input:checkbox[name=dus]:checked");
	var chkd = "0";
	for(var i=0; i<chkArr.length; i++){
		chkd += "-"+chkArr[i].value;
	}
	$('#users').val(chkd);
	$('#frm').submit();
}