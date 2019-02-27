function grantMember(){
	var frm = document.mbFrm;
	var selected = $("input:radio[name=members]:checked").val();
	frm.memberno.value = selected;
	$.ajax({
		url:'/right/grantMember.do',
		data:$('#mbFrm').serialize(),
		success:function(data){
			console.log(data);
			alert("동작 끝");
		}
	})
}