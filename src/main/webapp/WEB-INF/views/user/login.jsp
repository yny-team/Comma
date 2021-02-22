<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!doctype html>
<html lang="ko">
  <head>
<%@ include file="/WEB-INF/include/header_css.jsp" %>
  </head>
  <body>
<%@ include file="/WEB-INF/include/header.jsp" %> 
<section id="projects" class="padding-top">
  <div class="content">
    <div class="container">
      <div class="row justify-content-center">
        <!-- <div class="col-md-6 order-md-2">
          <img src="images/undraw_file_sync_ot38.svg" alt="Image" class="img-fluid">
        </div> -->
        <div class="col-xs-12 contents">
          <div class="row justify-content-center">
			<div class="col-md-6 col-md-offset-3 conForm">                     
				<div class="form-block">
                  <div class="mb-4">
                  <h3><strong>Comma</strong>에 오신 것을 환영합니다.</h3>
<!--                   <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur adipisicing.</p>
 -->                </div>
          		<form id="loginForm" name="f" action="/login" method="POST">				
                  <div class="form-group first">
                    <label for="username">아이디</label>
                    <input type="text" class="form-control" id="userId" name="userId"
                    	value="${memUserId}" placeholder="아이디를 입력해주세요">
                  </div>
                  <div class="form-group last mb-4">
                    <label for="password">비밀번호</label>
                    <input type="password" class="form-control" id="userPassword" name="userPassword"
                    	placeholder="비밀번호를 입력해주세요">
                  </div>
                  <div class="d-flex mb-5 align-items-center">    
                  	<c:if test="${not empty ERRORMSG}">
                  	<p>    
                      <font color="red">
                        ${ERRORMSG}
                      </font>
                    </p>
                  	</c:if>
                  </div>
                  <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
                  <input type="submit" id="BTN_LOGIN" name="BTN_LOGIN" value="로그인" class="btn btn-pill text-white btn-block btn-primary" 
                  		 style="background-color: #dbb075; border: 1px solid #dbb075; border-radius: 50px;">
				  </form>
                  <span class="d-block text-center my-4 text-muted"> or sign in with</span>
                  
                  <div class="social-login text-center">
<!--                     <a href="#" class="facebook">
                      <span class="icon-facebook mr-3"></span> 
                    </a>
                    <a href="#" class="twitter">
                      <span class="icon-twitter mr-3"></span> 
                    </a>
                    <a href="#" class="google">
                      <span class="icon-google mr-3"></span> 
                    </a> -->
                  </div>
                </form>
              </div>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>
</section>  
  <%@ include file="/WEB-INF/include/footer.jsp" %>
  <%@ include file="/WEB-INF/include/footer_css.jsp" %>
  <script>
	$(document).ready(function(){
		$("#BTN_LOGIN").on("click", function(){
			
			if($("#userId").val() == ""){
					alert("아이디를 입력해주세요");
					$("#userId").focus();
					return false;
			} 	
			if($("#userPassword").val() == ""){
				alert("비밀번호를 입력해주세요");
				$("#userPassword").focus();
				return false;
			}
			
			$("#loginForm").submit();
			
		});
	});  	
  </script>
  </body>
</html>