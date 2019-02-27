function grantMenu(){
	var frm = document.mrFrm;
	var chkList = $("input:checkbox[name=menues]:checked");
	var chkMenu = "";
	for(var i=0; i<chkList.length; i++){
		chkMenu += chkList[i].value+"|";
	}
	console.log(chkMenu);
	frm.menuno.value = chkMenu.substr(0, chkMenu.length-1);
	$.ajax({
		url:'/right/grantMenu.do',
		data:$('#mrFrm').serialize(),
		success:function(data){
			console.log(data);
			alert("동작 끝");
		}
	})
}