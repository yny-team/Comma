<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/header_css.jsp" %>
<style>
	.regist-error {color:red;}
	.uploadResult {width:100%;}
</style>
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
                                <img src="${pageContext.request.contextPath}`/resources/images/home/icon3.png" alt="">
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
                    <div class="row">
                        <div class="col-sm-12 col-md-12">
                            <div class="single-blog single-column">
			                    <div class=" bottom">
			                        <h1 id="timeline" class="timeline">타임라인 글쓰기</h1>
			                        <form:form modelAttribute="timelineVO" role="form" method="post" action="/regist">
			                            <div class="form-group">
			                                <form:input path="timeTitle" type="text"  cssClass="form-control" required="required" placeholder="제목을 작성해주세요"/>
			                           		<font id="chk_time_title" name="chk_time_title"></font> 
            								<form:errors path="timeTitle" cssClass="regist-error" element="div"/>
			                            </div>
			                            <div class="form-group">
			                                <form:textarea path="timeContent" required="required" cssClass="form-control" rows="8" placeholder="내용을 작성해주세요"></form:textarea>
			                            	<font id="chk_time_content" name="chk_time_content"></font>
            								<form:errors path="timeContent" cssClass="regist-error" element="div"/>  	
			                            </div>                        
		            					<div class="form-group uploadDiv">
		            						<label>첨부파일</label>           				
		            						<input type="file" name="uploadFile">
		            					</div>
		            					<div class="uploadResult">
		            						<ul></ul>           				
		            					</div>      		            								                            
			                            
         								<input type="hidden" name="userNo" value='4'/>
         								<%-- <sec:authentication property="principal.userNo"/> --%>
         								<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>     	
			                        	<div class="form-group pull-right" style="margin-top: 15px;">
				         						<button type="submit" class="btn btn-primary">
				         							<i class="fa fa-pencil" aria-hidden="true">
				         							작성하기</i>
				         						</button>
				         						<a href="/" class="btn btn-success">
				         							<i class="fa fa-list" aria-hidden="true">
				         							목록보기</i>
				         						</a>
				         				</div>
			                        </form:form>
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
			<script src="/resources/js/valid/timeline-regist-form-valid-check.js"></script>
            <script>       
            	$(document).ready(function(e){
            		
             		var header = $("meta[name='_csrf_header']").attr("content");
            		var token = $("meta[name='_csrf']").attr("content");
            		var formObj = $("form[role = 'form']");
            		var folder = $(".timeline").attr("id");  
            		console.log(folder)
            		
            		$("button[type='submit']").on("click", function(e){
            			
            			e.preventDefault();
            			
            			console.log("submit clicked");
            	 		
               			if(!titleCheck || $("#timeTitle").val().trim()=="") {
	           				alert("제목을 입력해주세요");
	           				$("#timeTitle").focus();
	           				return false;
            			} 
            			if(!contentCheck || $("#timeContent").val().trim()==""){
            				alert("내용을 입력해주세요");
            				$("#timeContent").focus();
            				return false;
            			}     
            			
            			var str = "";
            			
            			$(".uploadResult ul .img-div").each(function(i, obj){
            				
            				var jobj = $(obj);
            				
            				console.log(jobj);
            				
            				str += "<input type='hidden' name='timelineFileList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
            				str += "<input type='hidden' name='timelineFileList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
            				str += "<input type='hidden' name='timelineFileList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
            				str += "<input type='hidden' name='timelineFileList["+i+"].fileType' value='"+jobj.data("type")+"'>";
            			});
            			
            			formObj.append(str).submit();
            			
            		});
            		
            		var regex = new RegExp("(.*?)\.(jpg|jpeg|png)$");
            		var maxSize = 5242880; // 5MB
            		
            		function checkExtension(fileName, fileSize){
            			
            			if(fileSize >= maxSize){
            				alert("파일 사이즈 초과");
            				return false;
            			}
            			
            			if(!regex.test(fileName)){
            				alert("해당 종류의 파일은 업로드할 수 없습니다.");
            				return false;
            			}
            			return true;
            		}
            			 		
            		$("input[type='file']").change(function(e){
            			
            			var formData = new FormData();
            			
            			var inputFile = $("input[name='uploadFile']");
            			
            			var files = inputFile[0].files;
            			
            			for(var i = 0; i < files.length; i++){
            				
            				if(!checkExtension(files[i].name, files[i].size) ){
                				document.getElementsByName("uploadFile")[0].value="";
            					return false;
            				}
            				formData.append("uploadFile", files[i]);
            			}
            			formData.append("folder", folder);
            			
            			$.ajax({
            				url: '/file/upload',
            				processData: false,
            				contentType: false,
            				data: formData,
            				type: 'POST',
            				dataType: 'json',
            				beforeSend : function(xhr){
            					if(header && token){
            						xhr.setRequestHeader(header, token);
            					}
            				},// beforeSend
            				success : function(result){
            					console.log(result);
            					
            					showUploadResult(result);
            					alert("첨부파일 등록을 성공했습니다.");
            					document.getElementsByName("uploadFile")[0].value="";
            					        					
            				}// success
            			});//.ajax
            			
            		});//input.file.change
            		
	            	function showUploadResult(uploadResultArr){
	            		
	            		if(!uploadResultArr || uploadResultArr.length == 0) {return;}
	            		
	            		var uploadUL = $(".uploadResult ul");
	            		
	            		var str = "";
	            		
	            		$(uploadResultArr).each(function(i, obj){
	            			
	            			// image type 
	            			if(obj.fileType){ // image 
	            				
	            				var fileCallPath = encodeURIComponent( obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);

	            				str += "<div class='col-sm-6 col-md-4 col-lg-3 img-div' data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";
	            				str += "<div class='panel panel-primary'><a data-file=\'"+fileCallPath+"\' data-type='image' class='btn btn-danger btn-circle pull-right'><i class='fa fa-times'></i></a>";
	            				str += "<div class='panel-heading' style='background-color: #d89b4e; border:1px solid #d89b4e;'>" + obj.fileName + "</div>";
	            				str += "<div class='panel-body'>";
	            				str += "<img style='height:150px display:inline-block;' class='img-responsive' src='/file/display?fileName=" + fileCallPath + "&folder="+ folder +"'></span>";     
	            				str += "</div>";           				
	            				str += "</div></div>";
	            				     
	            			} 
	            		});
	            		
	            		uploadUL.append(str);            		
	            	}
            		
            		$(".uploadResult").on("click", "a", function(e){
            			
            			console.log("delete file");
            			
            			var targetFile = $(this).data("file");
            			var type = $(this).data("type");
            			
            			var targetDiv = $(this).closest(".img-div");
            			
            			$.ajax({
            				url: "/file/deleteFile",
            				data: {fileName: targetFile, type:type, folder:folder},
            				dataType: 'text',
            				type: 'POST',
            				beforeSend : function(xhr){
            					if(header && token){
            						xhr.setRequestHeader(header, token);
            					}
            				},// beforeSend
            				success : function(result){
            					alert(result);
            					targetDiv.remove();			
            				}// success
            			
            			});          			
            		});                 		
            		
            	});
            	
            </script>	
</body>
</html>
