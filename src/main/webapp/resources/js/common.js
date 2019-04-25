function pagingMenu(str, no){
	switch (no) {
	case 0:

		break;
	case 1:
		break;

	default:
		
		break;
	}
	$('#frm').submit();
}

function paging(flag){
	var frm = document.frm;
	switch (flag) {
	case 0:
		frm.action = "/member/main.do";
		break;
	case 1:
		frm.action = "/menu/main.do";
		break;
	case 2:
		frm.action = "/right/main.do";
		break;

	default:
		break;
	}
	frm.submit();
}

function logout(){
	location.href = "/logout.do";
}