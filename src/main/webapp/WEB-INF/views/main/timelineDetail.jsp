<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/header_css.jsp" %>
<link href="${pageContext.request.contextPath}/resources/css/bxslider/jquery.bxslider.css" rel="stylesheet">
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
	                                    		<a href="/mypage"><c:out value="${timelineVO.userName}"/></a>
	                                    	</span>
	                                    </h3>                                    
	                                    <h2 class="post-title bold"><a href="#"><c:out value="${timelineVO.timeTitle}"/></a></h2>                
	                                    <p><c:out value="${timelineVO.timeContent}"/></p>                                
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
				         				                        
	                                    <div class="post-bottom overflow">
	                                        <ul class="nav navbar-nav post-nav">
		                                        	<li><a href="#"><i class="fa fa-heart"></i>조회수 <c:out value="${timelineVO.timeViewCount}"/></a></li>            
		                                            <li><a href="#"><i class="fa fa-heart"></i>좋아요 <c:out value="${timelineVO.timeLikeCount}"/></a></li>
		                                            <li><a href="#"><i class="fa fa-comments"></i>댓글 갯수</a></li>
	                                        </ul>
	                                    </div>
	                                    <div class="author-profile padding">
	
	                                    </div>
	                                    <div class="response-area">
	                                    <h2 class="bold">Comments</h2>
	                                    <ul class="media-list">
                                    		<c:forEach items="${timelineCommentList}" var="timelineComment">					                    
		                                        <li class="media" data-no='<c:out value="${timelineComment.timeCommNo}"/>'>
		                                            <div class="post-comment">
		                                                <div class="media-body">
		                                                    <span><img class="media-object" src="images/home/icon1.png" alt="" style="width:25px; height:25px; display: inline-block; padding-right:3px;"><a href="#"><c:out value="${timelineComment.userName}"/></a></span>
		                                                    <p><c:out value="${timelineComment.timeCommContent}"/></p>
		                                                    <ul class="nav navbar-nav post-nav">
		                                                        <li>
		                                                        	<a href="#"><i class="fa fa-clock-o"></i>
		                                                        		<fmt:formatDate pattern="yy/MM/dd"
                                        								value="${timelineVO.timeCreateDt}"/>
                                        							</a>
                                        						</li>
                                        						<sec:authorize access="(( isAuthenticated() ) and ( principal.userNo == #timelineComment.userNo ))">		
		                                                        <li><a href="#"><i class="fa fa-reply"></i>수정</a></li>
		                                                        <li><a href="#"><i class="fa fa-reply"></i>삭제</a></li>
		                                                        </sec:authorize>
		                                                    </ul>
		                                                </div>
		                                            </div>                
		                                        </li>
	                                        </c:forEach>	                                        
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
	
/* 	console.log("=========================");
	console.log("JS REGIST TEST");
	
	var timeNoValue = '<c:out value="${timelineVO.timeNo}"/>';
	
	// for commentService regist test
	commentService.regist(
		{
			timeCommContent: "JS TEST", userNo: 4, timeNo: timeNoValue
		},
		function(result){
			alert("RESULT : " + result);
		}
				
	); */
	
/* 	console.log("=========================");
	console.log("JS REMOVE TEST");
	
	var timeNoValue = '<c:out value="${timelineVO.timeNo}"/>';
	commentService.remove(38, function(count){
		console.log(count);
		
		if(count == 'success'){
			alert("REMOVED");
		}
		
	}, function(err){
		alert('ERROR...');
	}); */

/* 	console.log("=========================");
	console.log("JS MODIFY TEST");
	
	var timeNoValue = '<c:out value="${timelineVO.timeNo}"/>';	
	
	commentService.modify({
		timeCommNo : 39,
		userNo : 4,
		timeNo : timeNoValue,
		timeCommContent : "Modified Reply..."
	}, function(result){
		alert("수정 완료");
	}) */
	
/* 	console.log("=========================");
	console.log("JS DETAIL TEST");
	
	commentService.detail(39, function(data){
		console.log(data);
	}); */
	
</script>	  
</body>
</html>
