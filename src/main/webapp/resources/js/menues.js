function addMenu(){
	if($('#menu_nm').val == '' || $('#menu_nm').val == null){
		alert("메뉴명이 비어있습니다.");
	}
	$('#frm').submit();
}

function updMenu(){
	
}

function delMenu(){
	var chkArr = $("input:checkbox[name=dms]:checked");
	var chkd = "0";
	for(var i=0; i<chkArr.length; i++){
		chkd += "-"+chkArr[i].value;
	}
	$('#menues').val(chkd);
	$('#frm').attr("action", "/menu/delMenu.do");
	$('#frm').submit();
}

function addChoice(menu){
	$('#parents').val($("input:radio[name=ams]:checked").val())
	$('#upper').val(menu);
}