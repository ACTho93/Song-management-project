﻿<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa danh mục</h2>
            </div>
        </div>
        <!-- /. ROW  -->
         <%
         	String name = request.getParameter("name");
        	 Category itemCat =(Category) request.getAttribute("itemCat");
        	 if(itemCat != null){
        		 name = itemCat.getName();
         	}
        	 
        	 
        	String error = request.getParameter("error");
        	if("1".equals(error)){
        		out.print("<span style =\"background: yellow; color: red; font-weight: bold; padding: 5px;\">Có lỗi xảy ra</span>");
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
                                <form action ="" role="form" method="post" id="form">
                          
                                    <div class="form-group">
                                        <label for="name">Tên danh mục</label>
                                        <input type="text" id="name" value="<%if(name != null) out.print(name);%>" name="name" class="form-control" />
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Update</button>
                                  
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
		rules:{
			"name":	{   
				required: true,
				
			},
			
		},
		messages:{
			"name":	{   
				required: "Bạn chưa nhập thông tin !",
			},
								
		},
	});

}); 
document.getElementById("category").classList.add('active-menu');

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