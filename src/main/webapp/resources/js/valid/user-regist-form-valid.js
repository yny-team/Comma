var idCheck = true; 
var nameCheck = true; 
var pwdCheck = true;
var repwdCheck = true; 
var emailCheck = true; 
var header = $("meta[name='_csrf_header']").attr("content");
var token = $("meta[name='_csrf']").attr("content");

// 이름 체크 여부
// ^[가-힣]{2,7}$
$(document).on('focusout', 'input[name=userNames]', function () {
	var chkName = $(this).val();
    var chk = chkName.search(/^[가-힣]{2,7}$/g);
    
    if (chk > -1) {
        $('font[name=chk_name]').css('color', 'green');
        $('font[name=chk_name]').html('사용가능한 이름입니다.');
        if(document.getElementById("userNames.errors")){
        	document.getElementById("userNames.errors").remove();
        }
        nameCheck = true;
        
    } else {
        $('font[name=chk_name]').css('color', 'red');
        $('font[name=chk_name]').html('이름은 한글로 2~7자 이하로 입력해주세요.');
        nameCheck = false;
    }
    
});

// 아이디 체크 여부 + 중복점검
$(document).on('focusout','input[name=userId]',function() {
	
	var chkId = $(this).val();
	var chk = chkId.search(/^[A-Za-z0-9]{6,16}$/);
	
	if(chk > -1){
		$.ajax({
			type: 'POST',
			url:'/user/idCheck',
			data: {userId:$(this).val()},
			cache: false,
			async: false,
			beforeSend : function(xhr){
				if(header && token){
					xhr.setRequestHeader(header, token);
				}
			}, 	
		})
		.done(function(result) {
			if(result.trim() == '1') {
				$('font[name=chk_id]').css('color','red');
				$('font[name=chk_id]').html('이미 사용중인 아이디입니다.');
				idCheck = false;
				
			} else {
				$('font[name=chk_id]').css('color','green');
				$('font[name=chk_id]').html('사용 가능한 아이디입니다.');
				if(document.getElementById("userId.errors")){
		        	document.getElementById("userId.errors").remove();
		        }
				idCheck = true;
			}
		});	
	} else {
		$('font[name=chk_id]').css('color','red');
		$('font[name=chk_id]').html('아이디는 6글자이상 16글자이하의 영문 숫자 조합만 가능합니다.');
		$("#userId").val("");
		idCheck = false;
	}
});

// 패스워드 체크 여부
$(document).on('focusout', 'input[name=userPassword]', function () {
    var chkPw = $(this).val();
    var chk = chkPw.search(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^*()-_?])[A-Za-z\d!@#$%^*()-_?]{8,20}$/g);

    if (chk > -1) {
        $('font[name=chk_pwd]').css('color', 'green');
        $('font[name=chk_pwd]').html('사용 가능한 패스워드입니다.');
        if(document.getElementById("userPassword.errors")){
        	document.getElementById("userPassword.errors").remove();
        }
        pwdCheck = true;
    } else {
        $('font[name=chk_pwd]').css('color', 'red');
        $('font[name=chk_pwd]').html('비밀번호는 영문, 숫자, 특수문자(!@#$%^*()_-?)를 포함해 8~20자리로 조합해주세요.');
        pwdCheck = false;
    }
});

// 패스워드 확인 체크 여부
$(document).on('focusout', 'input[name=userPassword2]', function () {
    var chkPw = $(this).val();
    var pwd = $("#userPassword").val();
    var chk = chkPw.search(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^*()-_?])[A-Za-z\d!@#$%^*()-_?]{8,20}$/g);
    console.log(chk);
    if (chk > -1) {
        if (pwd == chkPw) {
            $('font[name=chk_re_pwd]').css('color', 'green');
            $('font[name=chk_re_pwd]').html('비밀번호가 일치합니다.');
            repwdCheck = true;
        } else {
            $('font[name=chk_re_pwd]').css('color', 'red');
            $('font[name=chk_re_pwd]').html('비밀번호가 일치하지 않습니다.');
            repwdCheck = false;
        }
    } else {
        $('font[name=chk_re_pwd]').css('color', 'red');
        $('font[name=chk_re_pwd]').html('비밀번호는 영문, 숫자, 특수문자(!@#$%^*()_-?)를 포함해 8~20자리로 조합해주세요.');
        repwdCheck = false;
    }
});

$(document).on('focusout', 'input[name=userEmailFirst],input[name=userEmailEtc]', function (e) {

    emailFormCheck();

}).on('change', 'select[name=emailAddress]', function (e) {
    if ($(this).val() == "") {
        $("input[name=userEmailEtc]").val("");
        $("input[name=userEmailEtc]").attr('readonly', false);

        if ($('input[name=userEmailFirst]').val().length < 1 || $("input[name=userEmailEtc]").val() == "") {
            $('font[name=chk_email]').css('color', 'red');
            $('font[name=chk_email]').html('올바른 이메일 주소를 입력해주세요.');
            emailCheck = false;

        } else {
            $('font[name=chk_email]').css('color', '');
            $('font[name=chk_email]').html('');
            emailCheck = true;
        }
        emailFormCheck();

    } else {
        $("input[name=userEmailEtc]").val($(this).val());
        $("input[name=userEmailEtc]").attr('readonly', true);

        if ($('input[name=userEmailFirst]').val().length < 1 || $("input[name=userEmailEtc]").val() == "") {
            $('font[name=chk_email]').css('color', 'red');
            $('font[name=chk_email]').html('올바른 이메일 주소를 입력해주세요.');
            emailCheck = false;
        } else {
            $('font[name=chk_email]').css('color', '');
            $('font[name=chk_email]').html('');
            emailCheck = true;
        }

        emailFormCheck();
    }
});

function emailFormCheck() {

    var e1 = $('input[name=userEmailFirst]').val();
    var e2 = $('input[name=userEmailEtc]').val();
    var userEmail = e1 + '@' + e2;
    var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    
    var chk = userEmail.search(regExp);
    
	if(chk > -1){
		$.ajax({
			type: 'POST',
			url:'/user/emailCheck',
			data: {userEmail: userEmail},
			cache: false,
			async: false,
			beforeSend : function(xhr){
				if(header && token){
					xhr.setRequestHeader(header, token);
				}
			}, 	
		})
		.done(function(result) {
			if(result.trim() == '1') {
				$('font[name=chk_email]').css('color','red');
				$('font[name=chk_email]').html('이미 사용중인 이메일입니다.');
				emailCheck = false;
				
			} else {
				$('font[name=chk_email]').css('color','green');
				$('font[name=chk_email]').html('사용 가능한 이메일입니다.');
		        if(document.getElementById("userEmailFirst.errors")){
		        	document.getElementById("userEmailFirst.errors").remove();
		        }
		        if(document.getElementById("userEmailEtc.errors")){
		        	document.getElementById("userEmailEtc.errors").remove();
		        }
				emailCheck = true;
			}
		});	
	} else {
		$('font[name=chk_email]').css('color','red');
		$('font[name=chk_email]').html('올바른 이메일 주소를 입력해주세요.');
		emailCheck = false;

	}
}

$(document).ready(function () {

    $("#BTN_REGIST").on("click", function () {

        if ($("#userNames").val() == "" || !nameCheck) {
            alert("이름은 필수 입력항목입니다.");
            $("#userNames").focus();
            return;
        }
        if ($("#userId").val() == "" || !idCheck) {
            alert("아이디는 필수 입력항목입니다.");
            $("#userId").focus();
            return;
        }
        if ($("#userPassword").val() == "" || !pwdCheck) {
            alert("비밀번호는 필수 입력항목입니다.");
            $("#userPassword").focus();
            return;
        }
        if ($("#userPassword2").val() == "" || !repwdCheck) {
            alert("비밀번호가 일치하지 않습니다.");
            $("#userPassword2").focus();
            return;
        }
        if ($("#userEmailFirst").val() == "" || !emailCheck) {
            alert("이메일형식이 올바르지 않습니다.");
            $("#userEmailFirst").focus();
            return;
        }
        if ($("userEmailEtc").val() == "" || !emailCheck) {
            alert("이메일형식이 올바르지 않습니다.");
            $("#userEmailEtc").focus();
            return;
        }
        
        $("#registForm").submit();

    });


});
