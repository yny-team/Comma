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
    <section id="projects" class="padding-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-lg-9">
                    <div class="row">
                        <div class="col-sm-12 col-md-12">
                            <div class="single-blog single-column">
			                    <form:form modelAttribute="timelineVO" id="timelineModifyForm" role="form" method="post" action="/modify">
			                    <div class="panel-body">
			                        <h1 id="timeline" class="timeline">타임라인 수정하기</h1>
			                            <div class="form-group">
			                                <form:input path="timeTitle" type="text"  cssClass="form-control" required="required" placeholder="제목을 작성해주세요" value="${timelineVO.timeTitle}" />
			                           		<font id="chk_time_title" name="chk_time_title"></font> 
            								<form:errors path="timeTitle" cssClass="regist-error" element="div"/>
			                            </div>
			                            <div class="form-group">
			                                <form:textarea path="timeContent" required="required" cssClass="form-control" rows="8" placeholder="내용을 작성해주세요"/>
			                            	<font id="chk_time_content" name="chk_time_content"></font>
            								<form:errors path="timeContent" cssClass="regist-error" element="div"/>  	
			                            </div>                        
		            					<div class="form-group uploadDiv">
		            						<label>첨부파일</label>           				
		            						<input type="file" name="uploadFile">
		            					</div>
		            					<div class="uploadResult">
		            						<ul>
	            							<c:if test="${not empty timelineFileList}">
												<c:forEach items="${timelineFileList}" var="timelineFileList">
			            							<div class='col-sm-6 col-md-4 col-lg-3 img-div' data-path='${timelineFileList.uploadPath}' 
			            								data-uuid='${timelineFileList.uuid}' data-filename='${timelineFileList.fileName}' 
			            								data-type='${timelineFileList.fileType}'>
			            								<div class='panel panel-primary'>
			            									<a data-file='${timelineFileList.uploadPath}/s_${timelineFileList.uuid}_${timelineFileList.fileName}'
			            									   data-type='image' class='btn btn-danger btn-circle pull-right'><i class='fa fa-times'></i></a>
			            									<div class='panel-heading' style='background-color: #d89b4e; border:1px solid #d89b4e;'>${timelineFileList.fileName}</div>
										     				<div class='panel-body'>
										     					<img style='height:150px display:inline-block;' class='img-responsive' 
										     						src='${pageContext.request.contextPath}/resources/upload/timeline/${timelineFileList.uploadPath}/s_${timelineFileList.uuid}_${timelineFileList.fileName}'>   
										     				</div>  	            									   
			            								</div>
			            							</div>
												</c:forEach>
	            							</c:if>                
		            						</ul>           				
		            					</div>      		            								                            
			                    </div>
			                    <div class="form-group">
        							<input type="hidden" name="userNo" value='<sec:authentication property="principal.userNo"/>'/>
        							<input type="hidden" name="timeNo" value='${timelineVO.timeNo}'/>
        							<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>     	
		                        	<div class="form-group pull-right" style="margin-top: 15px;">
			         						<sec:authorize access="(( isAuthenticated() ) and ( principal.userNo == #timelineVO.userNo ))">					         						
			         						<button type="submit" data-oper="modify" class="btn btn-primary">
			         							<i class="fa fa-pencil" aria-hidden="true">수정하기</i>
			         						</button>
				         					<button type="submit" data-oper='remove' class="btn btn-danger">
				         						<i class="fa fa-trash-o" aria-hidden="true">삭제하기</i>
				         					</button>    				         						
			         						</sec:authorize>
			         						<a href="/" class="btn btn-success">
			         							<i class="fa fa-list" aria-hidden="true">
			         							목록보기</i>
			         						</a>
			         				</div>			                    	
			                    </div>        
			                    </form:form>
                                <div class="author-profile padding">

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
   		
		var modifyResult = '<c:out value="${modifyMessage}"/>';

		checkModifyResult();
		
		history.replaceState({}, null, null);
		
		function checkModifyResult(){
			if(modifyResult === '' || history.state ){
				return;
			} else if(modifyResult === 'success'){
				alert('타임랄인 수정을 성공했습니다.');
			} else if(modifyResult === 'fail'){
				alert("타임라인 수정을 실패했습니다.");
			}	
		};
   		
		var formObj = $("#timelineModifyForm");
		
		$('button').on("click", function(e){
			
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			if(operation === 'remove') {
				if(confirm('정말 삭제하시겠습니까?')){
					formObj.attr("action", "/remove");
					formObj.submit();
				} else {
					return;
				}        					
			} else if(operation === 'list'){
				formObj.attr("action", "/").attr("method", "get");
				formObj.submit();
			} else if(operation === 'modify'){
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
       			if(confirm('정말 수정하시겠습니까?')){
       				
					var str = "";
					
					$(".uploadResult ul .img-div").each(function(i, obj){
						
						
						var jobj = $(obj);
						
						console.dir(jobj);
						
						str += "<input type='hidden' name='timelineFileList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
						str += "<input type='hidden' name='timelineFileList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
						str += "<input type='hidden' name='timelineFileList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
						str += "<input type='hidden' name='timelineFileList["+i+"].fileType' value='"+jobj.data("type")+"'>";
						
					});      
					
					formObj.append(str).submit();	
       				
       			} else {
       				return;
       			}
			}
			
		});
   	});
   	</script>
   	<script>
    	$(document).ready(function(){
    		
    		var header = $("meta[name='_csrf_header']").attr("content");
    		var token = $("meta[name='_csrf']").attr("content");
    		var folder = $(".timeline").attr("id");  
    		
    		// removeImageByUuid
    		$(".uploadResult").on("click", "a", function(e){
    				            			
    			if(confirm("첨부파일을 삭제하시겠습니까?")){
    				
    				var targetDiv = $(this).closest(".img-div");
    				targetDiv.remove();
    			}
    		
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
    		
    	});
</script>
</body>
</html>
