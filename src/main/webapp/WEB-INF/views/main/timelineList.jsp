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
    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-md-6 col-lg-3 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="300ms">
                        <div class="single-service">
                            <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                                <img src="${pageContext.request.contextPath}/resources/images/home/icon1.png" alt="">
                            </div>
                            <h2>Incredibly Responsive</h2>
                            <p>Ground round tenderloin flank shank </p>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="single-service">
                            <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="600ms">
                                <img src="${pageContext.request.contextPath}/resources/images/home/icon2.png" alt="">
                            </div>
                            <h2>Superior Typography</h2>
                            <p>Hamburger ribeye drumstick turkey, </p>
                        </div>
                    </div>
                    <div class="col-sm-3 col-lg-3 hidden-md hidden-sm hidden-xs text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="900ms">
                        <div class="single-service">
                            <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="900ms">
                                <img src="${pageContext.request.contextPath}/resources/images/home/icon3.png" alt="">
                            </div>
                            <h2>Swift Page Builder</h2>
                            <p>Venison tongue, salami corned beef ball tip meatloaf bacon.</p>
                        </div>
                    </div>
                    <div class="col-sm-3 col-lg-3 hidden-md hidden-sm hidden-xs text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="900ms">
                        <div class="single-service">
                            <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="900ms">
                                <img src="${pageContext.request.contextPath}/resources/images/home/icon3.png" alt="">
                            </div>
                            <h2>Swift Page Builder</h2>
                            <p>Venison tongue, salami corned beef ball tip meatloaf bacon</p>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>
   </section>
    <!--/#action-->

    <section id="projects" class="padding-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-lg-9">
                    <div class="form-group">
                       <a href="/regist">
                      	<input type="button" name="name" class="form-control" value="000님, 현재 무슨 생각을 하고 계신가요?" required="required" placeholder="Name" style=" border-radius: 25px; background-color: #d99c4e; color:white; font-weight: 400;">
                       </a>
                    </div>
                    <div class="row">
                     	<c:choose>
                        	<c:when test="${not empty timelineList}">
	                    	<c:forEach items="${timelineList}" var="timeline">
	                        <div class="col-sm-12 col-md-12" style="margin-bottom: 25px; border: 1px solid #d99c4e; padding-top: 25px; border-radius:25px;">
	                            <div class="single-blog single-column">
		                                    <div class="post-thumb">                        	
		                                    	<div class="text-center">
		                                    		<ul class="slide_timeline">
		                                    			<c:forEach items="${timelineFileList}" var="timelineFile">
															<c:if test="${timeline.timeNo eq timelineFile.no}">
		                               							<a class="move" href="<c:out value='${timeline.timeNo}'/>">
																<li>
																   	<img src="${pageContext.request.contextPath}/resources/upload/timeline/${timelineFile.uploadPath}/s_${timelineFile.uuid}_${timelineFile.fileName}" 
											                                    		class="img-responsive"  alt="" style="display:inline-block;">
											                    </li>
	                                    						</a>		                            	
										                    </c:if>
										                </c:forEach>
													</ul>
		                                    	</div>	
 			                                    <div class="post-overlay">
			                                       <span class="uppercase">
			                                       	<a class="move" href="<c:out value='${timeline.timeNo}'/>">
			                                       		<fmt:formatDate pattern="E"
		                                        				value="${timeline.timeCreateDt}"/> 
		                                        				<br><small>
			                                       		<fmt:formatDate pattern="MM/dd"
		                                        	value="${timeline.timeCreateDt}"/></small>
		                                        	</a>
		                                        	</span>
			                                   </div> 
			                                </div>          			                                             
	                                <div class="post-content overflow">
	                                    <h3 class="post-author">
	                                    	<span>
	                                    		<img class="media-object" src="${pageContext.request.contextPath}/resources/images/favicon.png" alt="" style="width:25px; height:25px; display: inline-block; padding-right:3px;">
	                                    		<a href="/mypage"><c:out value="${timeline.userNames}"/></a>
	                                    	</span>
	                                    </h3>
	                                    <h2 class="post-title bold"><a class="move" href="<c:out value='${timeline.timeNo}'/>"><c:out value="${timeline.timeTitle}"/></a></h2>
	                                    <p><c:out value="${timeline.timeContent}"/></p>
	                                    <a href="#" class="read-more">View More</a>
	                                    <div class="post-bottom overflow">
	                                        <ul class="nav navbar-nav post-nav">
	                                        	<li><a href="#"><i class="fa fa-heart"></i>조회수 <c:out value="${timeline.timeViewCount}"/></a></li>            
	                                            <li><a href="#"><i class="fa fa-heart"></i>좋아요 <c:out value="${timeline.timeLikeCount}"/></a></li>
	                                            <li><a class="move" href="<c:out value='${timeline.timeNo}'/>"><i class="fa fa-comments"></i>댓글 갯수 <c:out value="${timeline.timeCommContentCount}"/></a></li>
	                                        </ul>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>         	
	                    	</c:forEach>
	                    	</c:when>
		                    <c:otherwise>
		                    	<div class="col-sm-12 col-md-12">
		                    		<div class="single-blog single-column">
	                                <div class="post-content overflow">
	                                    <h2 class="post-title bold"><a href="">현재 게시물이 존재하지 않습니다<./a></h2>
	                                </div>		                    		
		                    		</div>
		                    	</div>
		                    </c:otherwise>
	                    </c:choose> 	                                        	                                          	                                        
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
                <form id="actionForm" action="" method="GET">
                
                </form>
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
    <script>
    
    var actionForm = $("#actionForm");
	var registResult = '<c:out value="${registMessage}"/>';
	var removeResult = '<c:out value="${removeMessage}"/>';
	
	checkRegistResult();
	checkRemoveResult();
	
	history.replaceState({}, null, null);
	
	
	function checkRegistResult(){
		if(registResult === '' || history.state ){
			return;
		} else if(registResult === 'success'){
			alert('게시글 등록을 성공했습니다.');
		} else if(registResult === 'fail'){
			alert("게시글 등록을 실패했습니다. 다시 한 번 시도해주세요.");
		}	
	};
	
	function checkRemoveResult(){
		if(removeResult === '' || history.state ){
			return;
		} else if(removeResult === 'success'){
			alert('타임라인 삭제를 성공했습니다.');
		} else if(removeResult === 'fail'){
			alert("타임라인 삭제를 실패했습니다. 다시 한 번 시도해주세요.");
		}			
	};
	
	// [리스트 -> 조회] -> 리스트(검색 조건 유지)
	$(".move").on("click", function(e){
		
		e.preventDefault();
		actionForm.append("<input type='hidden' name='timeNo' value='" +
				$(this).attr("href") + "'>");
		actionForm.attr("action", "/detail");
		actionForm.submit();
	});
	
    </script>      
</body>
</html>
