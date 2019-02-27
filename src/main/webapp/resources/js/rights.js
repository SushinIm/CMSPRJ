function granting(num){
	var frm = document.rightFrm;
	frm.right_no.value = num;
	if(frm.selector.value == 1){
		frm.action = "/right/pageMenu.do";
	}else if(frm.selector.value == 2){
		frm.action = "/right/pageMember.do";
	}
	
	frm.submit();
}