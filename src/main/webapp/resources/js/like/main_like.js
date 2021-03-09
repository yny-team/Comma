function likeListView(){
	var jsonData = JSON.stringify(param);
	jQuery.ajaxSettings.traditional = true;
	$.ajax({
		url : '/likes',
		type : 'post',
		async : true,
		data: {"jsonData" : jsonData},
		dataType : "json",
		success : function(data) {    	
			console.log(data);	
			$.each(data.TimelineLikeCheckList, function(key, likeCheckList){
				
				var str = "";
				if(likeCheckList.timeLikeDuplicateCheck == false){
               		str += "<a onclick='insertTimelineLike(" + likeCheckList.timeNo + "," + currentUser + ")'>";             	
                    str += "<i class='fa fa-heart-o'></i>";
                    
                    $.each(data.timelineLikeCountList, function(key, likeCountList){
                    		if(likeCountList.timeNo == likeCheckList.timeNo){
                    			str += "좋아요 " +  likeCountList.timeLikeCount  + "개</a>";
                    		}
                    
                    });

				} else {
					str += "<a onclick='deleteTimelineLike(" + likeCheckList.timeNo + "," + currentUser + ")'>";                              
					str += "<i class='fa fa-heart'></i>";
					
                    $.each(data.timelineLikeCountList, function(key, likeCountList){
                		if(likeCountList.timeNo == likeCheckList.timeNo){
                			str += "좋아요 " +  likeCountList.timeLikeCount  + "개</a>";
                		}
                    });    										
              	}
				
				$(".like_" + likeCheckList.timeNo).html(str);
    					
    				});
    				
    			}
    		});	
    	}
    	
   
    	
   		var csrfHeaderName = "${_csrf.headerName}";
var csrfTokenValue = "${_csrf.token}";

$(document).ajaxSend(function(e, xhr, options){
	xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
});

function insertTimelineLike(timeNo, userNo){
	
	var str = "";
	
	$.ajax({
		type : 'post',
		url : '/like/' + timeNo,
		data : JSON.stringify({userNo : userNo}),
		contentType : "application/json; charset=utf-8",
		success : function(result, status, xhr){
			console.log(result);
			alert(result.timeLikeMessage);
			str += "<a onclick='deleteTimelineLike(" + timeNo + "," + currentUser + ")'>";                              
			str += "<i class='fa fa-heart'></i>";
     		str += "좋아요 " +  result.timeLikeCount  + "개</a>";
        	
     		$(".like_" + timeNo).html(str);
				
		},
		error : function(xhr, status, er){
			alert(er);
		}
	});
	
};

function deleteTimelineLike(timeNo, userNo){
	
	var str = "";
	
	$.ajax({
		type : 'delete',
		url : '/like/' + timeNo,
		data : JSON.stringify({userNo : userNo}),
		contentType : "application/json; charset=utf-8",
		success : function(result, status, xhr){
			alert(result.timeLikeMessage);	
			
			str += "<a onclick='insertTimelineLike(" + timeNo + "," + currentUser + ")'>";                              
			str += "<i class='fa fa-heart-o'></i>";
     		str += "좋아요 " +  result.timeLikeCount  + "개</a>";
        	
     		$(".like_" + timeNo).html(str);
		},
		error : function(xhr, status, er){
			alert(er);
		}
	});
};

$(document).ready(function() {
	likeListView();
});    