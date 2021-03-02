<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/header_css.jsp" %>
<head>
<body>
<%@ include file="/WEB-INF/include/header.jsp" %>

    <section id="error-page">
        <div class="error-page-inner">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="text-center">
                            <div class="bg-404">
                                <div class="error-image">                                
                                    <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/404.png" alt="">  
                                </div>
                            </div>
                            <h2>페이지 오류 안내</h2>
                            <p>입력한 주소가 정확한지 다시 한 번 확인해 주시길 바랍니다.</p>
                            <a href="index.html" class="btn btn-error">홈으로 이동</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


<%@ include file="/WEB-INF/include/footer.jsp" %>	
<%@ include file="/WEB-INF/include/footer_css.jsp" %>	 
</body>
</html>
