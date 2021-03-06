console.log("Comment module");

var commentService = (function(){

	function regist(comment, callback, error){
		console.log("regist comment..............");
		
		$.ajax({
			type : 'post',
			url : '/comment/new',
			data : JSON.stringify(comment),
			contentType : "application/json; charset=utf-8",				
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function list(param, callback, error){
		
		var timeNo = param.timeNo;
		
		$.getJSON("/comments/" + timeNo, 
			function(data){
				if(callback){
					console.log(data);
					callback(data.timeCommContentCount, data.timelistCommentList);
				}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
		
	}
	
	function remove(timeCommNo, currentUser, callback, error){
				
		$.ajax({
			type : 'delete',
			url : '/comment/' + timeCommNo,
			data : JSON.stringify({userNo : currentUser}),
			contentType : "application/json; charset=utf-8",
			success : function(deleteResult, status, xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function modify(comment, callback, error){
		
		console.log("timeCommNo : " + comment.timeCommNo);
		
		$.ajax({
			type : 'put',
			url : "/comment/" + comment.timeCommNo,
			data : JSON.stringify(comment),
			contentType : "application/json; charset=utf-8",		
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
			
		});
		
	}
	
	function detail(timeCommNo, callback, error){
		
		$.get("/comment/" + timeCommNo, function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	return {
		regist : regist,
		list : list,
		remove : remove,
		modify : modify,
		detail : detail
	};
})();;