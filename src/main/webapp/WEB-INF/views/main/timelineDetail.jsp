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
                         <div class="col-md-12 col-sm-12">
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
                                    <h2 class="post-title bold"><a href="#"><c:out value="${timelineVO.timeTitle}"/></a></h2>
                                    <h3 class="post-author"><a href="#">Posted by <c:out value="${timelineVO.userName}"/></a></h3>
                                    <p><c:out value="${timelineVO.timeContent}"/></p>
                                    <div class="post-bottom overflow">
                                        <ul class="nav navbar-nav post-nav">
	                                        	<li><a href="#"><i class="fa fa-heart"></i>조회수 <c:out value="${timeline.timeViewCount}"/></a></li>            
	                                            <li><a href="#"><i class="fa fa-heart"></i>좋아요 <c:out value="${timeline.timeLikeCount}"/></a></li>
	                                            <li><a href="#"><i class="fa fa-comments"></i>댓글 갯수</a></li>
                                        </ul>
                                    </div>
                                    <div class="author-profile padding">
<!--                                         <div class="row">
                                            <div class="col-sm-2">
                                                <img src="images/blogdetails/1.png" alt="">
                                            </div>
                                            <div class="col-sm-10">
                                                <h3>Rodrix Hasel</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliq Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi</p>
                                                <span>Website:<a href="www.jooomshaper.com"> www.jooomshaper.com</a></span>
                                            </div>
                                        </div> -->
                                    </div>
                                    <div class="response-area">
                                    <h2 class="bold">Comments</h2>
                                    <ul class="media-list">
                                        <li class="media">
                                            <div class="post-comment">
                                                <div class="media-body">
                                                    <span><img class="media-object" src="images/home/icon1.png" alt="" style="width:25px; height:25px; display: inline-block; padding-right:3px;"><a href="#">Endure</a></span>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliq Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi.</p>
                                                    <ul class="nav navbar-nav post-nav">
                                                        <li><a href="#"><i class="fa fa-clock-o"></i>February 11,2014</a></li>
                                                        <li><a href="#"><i class="fa fa-reply"></i>Reply</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="parrent">
                                                <ul class="media-list">
                                                    <li class="post-comment reply">
                                                        <div class="media-body">
                                                            <span><img class="media-object" src="images/home/icon2.png" alt="" style="width:25px; height:25px; display: inline-block;"><a href="#">Endure</a></span>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut </p>
                                                            <ul class="nav navbar-nav post-nav">
                                                                <li><a href="#"><i class="fa fa-clock-o"></i>February 11,2014</a></li>
                                                            </ul>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li class="media">
                                            <div class="post-comment">
                                                <div class="media-body">
                                                    <span><img class="media-object" src="images/home/icon3.png" alt="" style="width:25px; height:25px; display: inline-block;"><a href="#">Endure</a></span>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliq Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi.</p>
                                                    <ul class="nav navbar-nav post-nav">
                                                        <li><a href="#"><i class="fa fa-clock-o"></i>February 11,2014</a></li>
                                                        <li><a href="#"><i class="fa fa-reply"></i>Reply</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </li>
                                        
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
</body>
</html>
