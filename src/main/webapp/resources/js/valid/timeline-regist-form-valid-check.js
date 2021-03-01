var titleCheck = true; 
var contentCheck = true; 

$(document).on('focusout', 'input[name=timeTitle]', function (e) {
	if ($("#timeTitle").val().trim()=="") {
		$('font[name=chk_time_title]').css('color', 'red');
        $('font[name=chk_time_title]').html('제목을 입력해주세요');
        titleCheck = false;
	} else {
		$('font[name=chk_time_title]').css('color', '');
        $('font[name=chk_time_title]').html('');
        if(document.getElementById("timeTitle.errors")){
        	document.getElementById("timeTitle.errors").remove();
        }                	        
        titleCheck = true;
	}
});

$(document).on('focusout', 'textarea[name=timeContent]', function (e) {
	if ($("#timeContent").val().trim()=="") {
		$('font[name=chk_time_content]').css('color', 'red');
        $('font[name=chk_time_content]').html('질문 내용을 입력해주세요');
        contentCheck = false;
	} else {
		$('font[name=chk_time_content]').css('color', '');
        $('font[name=chk_time_content]').html('');
        if(document.getElementById("timeContent.errors")){
        	document.getElementById("timeContent.errors").remove();
        }                	        
        contentCheck = true;
	}
});   