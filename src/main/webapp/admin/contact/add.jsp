<%@page import="model.bean.Category"%>
<%@page import="model.bean.Song"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm liên hệ</h2>
            </div>
        </div>
        <!-- /. ROW  -->
         <%
         String msg = request.getParameter("msg");
         String error = request.getParameter("error");
	     	if("1".equals(error)){
	     		out.print("<span style =\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi khi thêm!</span>");
	     	}
	     	
	     	
        %>
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form action=""  method="post" id="form" >
                                  
                                    <div class="form-group">
                                        <label for="name">Tên người liên hệ</label>
                                        <input type="text" id="name" value="" name="name" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="name">Email</label>
                                        <input type="text" id="email" value="" name="email" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Webside</label>
                                        <input type="text" id="webside" value="" name="webside" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="name">Message</label>
                                        <input type="text" id="message" value="" name="message" class="form-control" />
                                    </div>
                                  
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <!-- /. ROW  -->
    </div>
    <!-- /. PAGE INNER  -->
</div>
<script type="text/javascript">
$(document).ready(function(){
	$('#form').validate({
		//ignore:[],
		ignore: ".ignoreThisClass"
		rules:{
			"name":	{   
				required: true,
			},
			
			"email":	{   
				required: true,
			},
			"message":	{   
				required: true,
			},
			
		},
		messages:{
			"name":	{   
				required: "Bạn chưa nhập thông tin !",
			},
			"email":	{   
				required: "Bạn chưa nhập thông tin !",
			},
			"message":	{   
				required: "Bạn chưa nhập thông tin !",
			},
			
			
								
		},
	});

}); 
    document.getElementById("song").classList.add('active-menu');
</script>
<script type="text/javascript">
	var ckeditor = CKEDITOR.replace('detail');
	CKFinder.setupCKEditor(ckeditor,'${pageContext.request.contextPath}/lib/ckfinder/');
</script>
<style>
	.error {
		color: red;
		padding-left: 5px;
		font-size: 12px;
		font-style: italic;
	}
	
</style>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>