<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/header_css.jsp" %>
<link href="${pageContext.request.contextPath}/resources/css/bxslider/jquery.bxslider.css" rel="stylesheet">
<style>
textarea.autosize { min-height: 50px; max-height:150px; }
</style>
<head>
<body>
<%@ include file="/WEB-INF/include/header.jsp" %>
    <section id="blog-details" class="padding-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-lg-9">
                    <div class="row">
                         <div class="col-md-12 col-sm-12" style="margin-bottom: 25px; border: 1px solid #d99c4e; padding-top: 25px; border-radius:25px;">
                            <div class="single-blog blog-details two-column">
 	                                <div class="post-thumb">
                                    	<div class="text-center">
                                    		<ul class="slide_timeline">
                                    			<c:forEach items="${timelineFileList}" var="timelineFile">					
													<li>
													   <img src="${pageContext.request.contextPath}/resources/upload/timeline/${timelineFile.uploadPath}/s_${timelineFile.uuid}_${timelineFile.fileName}" 
								                                    		class="img-responsive" alt="" style="display:inline-block;">
								                    </li>
								                </c:forEach>
											</ul>
                                    	</div>	
	                                    <div class="post-overlay">
	                                       <span class="uppercase">
	                                       	<a class="move" href="<c:out value='${timelineVO.timeNo}'/>">
	                                       		<fmt:formatDate pattern="E"
                                        				value="${timelineVO.timeCreateDt}"/> 
                                        				<br><small>
	                                       		<fmt:formatDate pattern="MM/dd"
                                        	value="${timelineVO.timeCreateDt}"/></small>
                                        	</a>
                                        	</span>
	                                   </div>
	                                </div>
	                                <div class="post-content overflow">
	                                    <h3 class="post-author">
	                                    	<span>
	                                    		<img class="media-object" src="${pageContext.request.contextPath}/resources/images/favicon.png" alt="" style="width:25px; height:25px; display: inline-block; padding-right:3px;">
	                                    		<a href="/mypage"><c:out value="${timelineVO.userNames}"/></a>
	                                    	</span>
	                                    </h3>                                    
	                                    <h2 class="post-title bold"><a href="#"><c:out value="${timelineVO.timeTitle}"/></a></h2>                
	                                    <p><c:out value="${timelineVO.timeContent}"/></p>                                
	                                    <div class="post-bottom overflow">
	                                        <ul class="nav navbar-nav post-nav">
		                                        	<li><a href="#"><i class="fa fa-heart"></i>조회수 <c:out value="${timelineVO.timeViewCount}"/></a></li>            
		                                            <li><a href="#"><i class="fa fa-heart"></i>좋아요 <c:out value="${timelineVO.timeLikeCount}"/></a></li>
		                                            <li><a><i class="fa fa-comments"></i>댓글 갯수 <span id="commentCount"></span></a></li>
	                                        </ul>
	                                    </div>	                                    
	<%--         							<input type="hidden" name="userNo" value='<sec:authentication property="principal.userNo"/>'/>
	        							<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>    --%>  	
			                        	<div class="form-group pull-right" style="margin-top: 15px;">
			                        			<sec:authorize access="(( isAuthenticated() ) and ( principal.userNo == #timelineVO.userNo ))">		
				         						<a href="/modify?timeNo=${timelineVO.timeNo}&userNo=${timelineVO.userNo}" class="btn btn-primary">
				         							<i class="fa fa-pencil" aria-hidden="true">
				         							수정하기</i>
				         						</a>
				         						</sec:authorize>
				         						<a href="/" class="btn btn-success">
				         							<i class="fa fa-list" aria-hidden="true">
				         							목록보기</i>
				         						</a>
				         				</div>            
				         				                       
	                                    <div class="author-profile padding">
	
	                                    </div>
	                                    <div class="response-area">
	                                    <h2 class="bold">
	                                    	Comments                           		
	                                    </h2>
	                                   	<textarea class="form-control autosize" id="newComment" name="timeCommContent" id="test" cols="10" rows="3" placeholder="새로운 댓글을 작성해주세요" onkeydown="resize(this)" onkeyup="resize(this)"></textarea>
	                                    <input type="button" id="registCommentBtn" name="name" class="form-control" required="required" value="새로운 댓글 남기기" style="border-radius: 25px; background-color: #d99c4e; color:white; font-weight: 400; margin-top:15px; margin-bottom:15px;">
	                                    <ul class="media-list">
                            			
	                                    </ul>                   
	                                	</div><!--/Response-area-->
	                                </div>
                            </div>
                        </div>
                    </div>
                 </div>
                <div class="col-md-3 hidden-md hidden-sm hidden-xs">
                    <div class="sidebar portfolio-sidebar">
                        <div class="sidebar-item categories">
                            <h5>&copy;2021, Comma Inc All Rights Reserved.</h5>
                            <ul class="nav navbar-stacked">
                                <li><a href="#">개인정보처리방침</a></li>
                                <li class=""><a href="#">About</a></li>
<!--                                <li><a href="#">Folio<span class="pull-right">(4)</span></a></li>-->
                            </ul>
                        </div>
                        <div class="sidebar-item popular">
                            <h3>Popular Projects</h3>
                            <ul class="gallery">
                                <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/portfolio/popular1.jpg" alt=""></a></li>
                                <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/portfolio/popular2.jpg" alt=""></a></li>
                                <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/portfolio/popular3.jpg" alt=""></a></li>
                                <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/portfolio/popular4.jpg" alt=""></a></li>
                                <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/portfolio/popular5.jpg" alt=""></a></li>
                                <li><a href="#"><img src="${pageContext.request.contextPath}/resources/images/portfolio/popular1.jpg" alt=""></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">댓글 수정하기</h4>
                </div>
                <div class="modal-body">
                   <div class="form-group">
					  <textarea class="form-control autosize" id="modifyComment" name="timeCommContent" id="test" cols="10" rows="3" placeholder="새로운 댓글을 작성해주세요" onkeydown="resize(this)" onkeyup="resize(this)"></textarea>                      
                   </div>
                </div>
                <div class="modal-footer">
                    <button id="modalModBtn" type="button" class="btn btn-warning">수정</button>
                    <button id="modalRemoveBtn" type="button" class="btn btn-danger">삭제</button>
                    <button id="modalRegistBtn" type="button" class="btn btn-primary">등록</button>
                    <button id="modalCloseBtn" data-dismiss="modal" type="button" class="btn btn-default">닫기</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <input type="hidden" name="userNo" value='<sec:authentication property="principal.userNo"/>'/>
    
    <!-- /.modal -->    
<%@ include file="/WEB-INF/include/footer.jsp" %>	
<%@ include file="/WEB-INF/include/footer_css.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bxslider/jquery.bxslider.js"></script> 
<script>
	$(function() {
		$('.slide_timeline').bxSlider({
			// auto : true,
			autoControls : true,
			stopAutoOnClick : true,
			pager : true,
			controls : false
		});
	});
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/comment/comment.js"></script>
<script>
	function resize(obj){
		obj.style.height = "1px";
		obj.style.height = (12 + obj.scrollHeight) + "px";
	};
	
	$(document).ready(function(){
		
		var timeNoValue = '<c:out value="${timelineVO.timeNo}"/>';	
		var commentUL = $(".media-list");
		var currentUser = "";
		
		<sec:authorize access="isAuthenticated()">
			currentUser = <sec:authentication property="principal.userNo"/>	
		</sec:authorize>
		
		var csrfHeaderName = "${_csrf.headerName}";
		var csrfTokenValue = "${_csrf.token}";
		
		showList();
		
		function showList(){
			
			commentService.list({timeNo : timeNoValue}, function(timeCommContentCount , list){
				
				//console.log(list);
				
				console.log(timeCommContentCount);
				console.log(list);
				
				var str = "";
				if(list == null || list.length == 0){
					
					commentUL.html("");
					
					return;
				}
				
				$("#commentCount").html(timeCommContentCount);
				
				for(var i = 0, len = list.length || 0; i < len; i++){
					str += "<li class='media' data-timeCommNo='" + list[i].timeCommNo + "'>";
					str += "<div class='post-comment'>";
					str += "<div class='media-body'>";
					str += "<span><img class='media-object' src='images/home/icon1.png' alt='' style='width:25px; height:25px; display: inline-block; padding-right:3px;'><a href='#'>"+ list[i].userNames + "</a></span>"					
					str += "<p><pre style='background-color:#fff; border:1px solid #d99c4e;'>" + list[i].timeCommContent +"</pre></p>";
					str += "<ul class='nav navbar-nav post-nav'>";
					
					var current = "";
					
					var today = new Date();
					var gap = today.getTime() - list[i].timeCommCreateDt;
					//console.log(gap);
					
					if(gap < 1000 * 60) 
						current =  Math.floor(gap / 1000) + ' 초전';
					else if(gap < 1000 * 60 * 60) 
						current = Math.floor(gap / (1000 * 60)) + ' 분전';
					else if(gap < 1000 * 60 * 60 * 24)    
						current = Math.floor(gap / (1000 * 60 * 60)) + ' 시간전';
					else if(gap < 1000 * 60 * 60 * 24 * 30)
						current = Math.floor(gap / (1000 * 60 * 60 * 24)) + ' 일전';
					else if(gap < 1000 * 60 * 60 * 24 * 30 * 12)
						current = Math.floor(gap / (1000 * 60 * 60 * 24 * 30)) + ' 달전';					
					
					str += "<li><a href='#'><i class='fa fa-clock-o'></i>"+ current +"</a></li>";
					if(currentUser == list[i].userNo){
						str += "<button id='modifyCommentBtn' style='background-color:#fff; border:none; margin-right:5px;'><li><a><i class='fa fa-pencil'></i>수정</a></li></button>";
    	                str += "<button id='removeCommentBtn' style='background-color:#fff; border:none;'><li><a><i class='fa fa-trash-o'></i>삭제</a></li>";				
					}
					str += "</ul></div></div></li>";          
				} 
				
				commentUL.html(str);
			});
			
		};
		
		var modal = $(".modal");
		var inputTimeCommContent = $("textarea[name='timeCommContent']");
		
		var modalTextareaTimeCommContent = modal.find("textarea[name='timeCommContent']");
		
		var modalModBtn = $("#modalModBtn");
		var modalRemoveBtn = $("#modalRemoveBtn");
		var modalRegistBtn = $("#modalRegistBtn") ;
		
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
		});
		
		$("#registCommentBtn").on("click", function(e){
			
			var comment = {
				timeCommContent : inputTimeCommContent.val(),
				userNo : currentUser,
				timeNo : timeNoValue	
			}
			
			if($("#newComment").val().trim()==""){
				alert("새로운 댓글을 입력해주세요");
				$("#newComment").focus();				
				return false;
			}
			
			commentService.regist(comment, function(result){
				
				inputTimeCommContent.val("");
				
				alert(result);
				
				showList();
			});
		
		});
		
		var modalBody = $(".modal-body");
		
		
		$(".media-list").on("click", "#modifyCommentBtn", function(e){
			
			var timeCommNo = $(this).closest("div").closest("div").closest("li").data("timecommno");
			
			console.log(timeCommNo);
			
			commentService.detail(timeCommNo, function(comment){
				
				modalTextareaTimeCommContent.val(comment.timeCommContent);
				
				modal.find("button[id != 'modalCloseBtn']").hide();
				modal.attr('data-timecommno', timeCommNo);
				
				
				modalModBtn.show();
				
				$(".modal").modal("show");
				
			});
		
		});
		
		modalModBtn.on("click", function(e){
			
			
			var comment = {
					timeCommNo : modal.data("timecommno"),
 					userNo : currentUser,
					timeCommContent : modalTextareaTimeCommContent.val()					  
			};

			if($("#modifyComment").val().trim()==""){
				alert("새로운 댓글을 입력해주세요");
				$("#modifyComment").focus();				
				return false;
			}			
			
			commentService.modify(comment, function(result){
				
				alert(result);
				modal.modal("hide");
				showList();
				
			});
			
		});		
		
		$(".media-list").on("click", "#removeCommentBtn", function(e){
			
			var timeCommNo = $(this).closest("div").closest("div").closest("li").data("timecommno");
			
			console.log(timeCommNo);
			
			if(confirm("정말 삭제하시겠습니까?")){
				
				commentService.remove(timeCommNo, currentUser, function(result){
					
					alert(result);
					showList();
					
				});
				
			} else {
				return;
			}
			
		});	
		
		
		
	});
</script>	  
</body>
</html>
