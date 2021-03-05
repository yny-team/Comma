<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<header id="header">
       <div class="container"  style="position: fixed; background-color: #fff; width: 100%; z-index: 10; top:0;">
          <div class="row">
              <div class="col-sm-12 overflow" style=" padding-bottom: 10px;">
                  <a class="navbar-brand" href="/">
                      <h1><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="logo" style="width: 75px; height:55px;"></h1>
                  </a>
                  <input type="text" class="search-form" autocomplete="off" placeholder="검색">
	              <div class="pull-right">
	                      <ul class="nav nav-pills">
		                      <c:if test="${not empty ERRORMSG}">
		                          <li><a href="/user/login" style="border: 1px solid #dbb075; border-radius: 50px; margin-top:5px;">로그인</a></li>
		                          <li><a href="/user/signup" style="background-color: #dbb075; color:white; border-radius: 50px; margin-top:5px;">회원가입</a></li>
		                      </c:if>
		                      <sec:authorize access="isAnonymous()">
		                          <li><a href="/user/login" style="border: 1px solid #dbb075; border-radius: 50px; margin-top:5px;">로그인</a></li>
		                          <li><a href="/user/signup" style="background-color: #dbb075; color:white; border-radius: 50px; margin-top:5px;">회원가입</a></li>                 
		                      </sec:authorize>
		                      <sec:authorize access="isAuthenticated()">
		                          <li>
		                          	<a style="border: 1px solid #dbb075; border-radius: 50px; margin-top:5px;">
		                          		<sec:authentication property="principal.userNames"/>님
		                          	</a>
		                          </li>                      	
		                          <li>
		                          	<a href="#" onclick="document.getElementById('logout-form').submit();"
		                          	   style="background-color: #dbb075; color:white; border-radius: 50px; margin-top:5px;">
		                          		로그아웃
		                          	</a>
		                          	<form id="logout-form" action="/logout" method="POST">
										<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
									</form>
		                          </li>                 
		                      	  <sec:authorize access="hasRole('ROLE_USER')">
			                          <li><a href="/user/info"><i class="fa fa-2x fa-user" aria-hidden="true"></i></a></li>
			                          <li><a href="#comment"><i class="fa fa-2x fa-comments-o"></i></a></li>
			                          <li><a href="#notification"><i class="fa fa-2x fa-envelope-o"></i></a></li>                      	
		                      	  </sec:authorize>
		                      	  <sec:authorize access="hasRole('ROLE_ADMIN')">
		                         	  <li><a href="/admin"><i class="fa fa-2x fa-user" aria-hidden="true"></i></a></li>
		                      	</sec:authorize>               
		                      </sec:authorize>    
	                      </ul>
	                  </div> 
              </div>
          </div>
      </div>     
  </header>
  <!--/#header-->