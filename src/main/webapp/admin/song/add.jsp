﻿<%@page import="model.bean.Category"%>
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
                <h2>Thêm bài hát</h2>
            </div>
        </div>
        <!-- /. ROW  -->
         <%
	        @SuppressWarnings("unchecked")
	     	ArrayList<Category> listcat =(ArrayList<Category>) request.getAttribute("listcat");
         	String name = request.getParameter("name");
         	String catId = request.getParameter("category");
         	String previewText = request.getParameter("preview_text");
         	String detailText = request.getParameter("detail_text");
         	
         	ArrayList<User> listUser =(ArrayList<User>) request.getAttribute("listUser");
         	String Uid = request.getParameter("id");
          	String username = request.getParameter("username");
          	
          	
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
                                <form action=""  method="post" id="form" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="name">Tên bài hát</label>
                                        <input type="text" id="name" value="<%if(name != null) out.print(name); %>" name="name" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Danh mục bài hát</label>
                                        <select id="category" name="category" class="form-control" >
                                        <%
                                        
                                        	if(listcat != null && listcat.size() > 0){
                                        		for(Category item: listcat){
                                        			
                                        %>
	                                        <option <%if(catId != null && catId.equals(String.valueOf(item.getId())))out.print("selected"); %> value="<%=item.getId() %>" ><%=item.getName() %></option>
										<% }} %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="picture">Hình ảnh</label>
                                        
                                        <input type="file" name="picture" />
                                    </div>
                                   
                                    <div class="form-group">
                                        <label for="preview">Mô tả</label>
                                        <textarea id="preview" class="form-control" rows="3" name="preview_text"><%if(previewText != null) out.print(previewText); %></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="detail">Chi tiết</label>
                                        <textarea id="detail" class="form-control"  rows="9" name="detail_text"><%if(detailText != null) out.print(detailText); %></textarea>
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
		ignore:[],
		
		rules:{
			"name":	{   
				required: true,
				maxlength: 50,
				minlength: 2
			},
			"counter":	{   
				required: true,
				
			},
			"preview_text":	{   
				required: true,
				
			},
			"detail_text":	{   
				required: true,
			},
		},
		messages:{
			"nhap":	{   
				required: "Bạn chưa nhập thông tin !",
				
			},
			"counter":	{   
				required: "Bạn chưa nhập thông tin !",
			},
			"preview_text":	{   
				required: "Bạn chưa nhập thông tin !",
			},
			"detail_text":	{   
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