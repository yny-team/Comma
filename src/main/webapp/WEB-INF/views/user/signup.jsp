<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="ko">
  <head>
<%@ include file="/WEB-INF/include/header_css.jsp" %>
<style>
.regist-error {color:red} 
</style>
<link href="${pageContext.request.contextPath}/resources/css/regist.css" rel="stylesheet">
  </head>
  <body>
<%@ include file="/WEB-INF/include/header.jsp" %> 
<section id="projects" class="padding-top">
  <div class="content">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-xs-12 contents">
          <div class="row justify-content-center">
			<div class="col-md-6 col-md-offset-3 conForm">                     
				<div class="form-block">
                  <div class="mb-4">
                  <h3><strong>Comma</strong>에 오신 것을 환영합니다.</h3>
                </div>
                <form:form modelAttribute="userVO" id="registForm" name="registForm" action="/user/signup" method="POST">
					<div class="form-group first">
	                    <label for="userNames">이름</label>
	                    <form:input path="userNames" type="text" cssClass="form-control" 
	                    	 placeholder="이름을 입력해주세요"/>
						<font id="chk_name" name="chk_name" style="paddig-top:2px;"></font>
                        <form:errors path="userNames" cssClass="regist-error" element="div"/>	                    	 
                  	</div>					
					<div class="form-group first">
	                    <label for="userId">아이디</label>
	                    <form:input path="userId" type="text" cssClass="form-control" 
	                    	 placeholder="아이디를 입력해주세요"/>
						<font id="chk_id" name="chk_id"></font>
                        <form:errors path="userId" cssClass="regist-error" element="div"/>	                    
                  	</div>
                     <div class="bs_form_itembx">
                     	<label for="memEmailFirst" class="label_text">이메일</label>
                        <dl>
                            <!-- <dt></dt> -->
                            <dd>
                                <div class="form_email_bx">
                                    <ul>
                                        <li>
                                            <div class="bs_pr_bx max_600">
                                                <div class="bs_inputbx">
                                                    <form:input path="userEmailFirst" type="text"  class="form-control" />
                                                </div>
                                            </div>
                                        </li>
                                        <div class="input-group-email">@</div>
                                        <li>
                                            <div class="bs_pr_bx max_600">
                                                <div class="bs_inputbx">
                                                    <form:input path="userEmailEtc" type="text" class="form-control" />
                                                </div>
                                            </div>
                                        </li>
                 
                                        <li>
                                            <div class="mail_seletbx">
                                                <select id="emailAddress" name="emailAddress">
                                                    <option value="">직접입력</option>
                                                    <option value="naver.com">naver.com</option>
                                                    <option value="daum.net">daum.net</option>        
                                                    <option value="hanmail.net">hanmail.net</option>
                                                    <option value="nate.com">nate.com</option>
                                                    <option value="gmail.com">gmail.com</option>
                                                </select>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <font id="chk_email" name="chk_email"></font>
                            	<form:errors path="userEmailFirst" cssClass="regist-error" element="div"/>
                                <form:errors path="userEmailEtc" cssClass="regist-error" element="div"/> 
                            </dd>
                        </dl>
                    </div>                 						
	                <div class="form-group last mb-4">
                    	<label for="password">비밀번호</label>
                    	<form:password  path="userPassword" class="form-control" 
                    	placeholder="비밀번호를 입력해주세요"/>
                        <font id="chk_pwd" name="chk_pwd"></font>
                        <form:errors path="userPassword" cssClass="regist-error" element="div"/>                    	
                  	</div>					
	                <div class="form-group last mb-4">
                    	<label for="password">비밀번호 확인</label>
                    	<input type="password" class="form-control" id="userPassword2" name="userPassword2"
                    	placeholder="비밀번호 확인을 입력해주세요"/>
                    	<font id="chk_re_pwd" name="chk_re_pwd"></font>
                  	</div>					
				</form:form>                
                  <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
                  <input type="submit" id="BTN_REGIST" name="BTN_REGIST" value="회원가입" class="btn btn-pill text-white btn-block btn-primary" 
                  		 style="background-color: #dbb075; border: 1px solid #dbb075; border-radius: 50px;">
                  
                  <span class="d-block text-center my-4 text-muted"> or sign in with</span>
                  
                  <div class="social-login text-center">

                  </div>
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
		$("#BTN_REGIST").on("click", function(){
		
			
			$("#registForm").submit();
			
		});
	});  	
  </script>  
<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/valid/user-regist-form-valid.js"></script> 
 --%>  </body>
</html>