<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>BSong</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/templates/public/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />


<!-- Jquery-->
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/public/js/jquery-3.2.1.js"></script>

 <!-- SCRIPT-->
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/public/js/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/public/js/coin-slider.min.js"></script>
<!-- JVALIDATE-->
<script src="<%=request.getContextPath() %>/templates/admin/assets/js/jquery.validate.min.js" type="text/javascript"> </script>
<!-- CKEDITOR-->
<script src="<%=request.getContextPath() %>/lib/ckeditor/ckeditor.js" type="text/javascript"></script>
<!-- CKFINDER-->
<script src="<%=request.getContextPath() %>/lib/ckfinder/ckfinder.js" type="text/javascript"></script>

</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="">BSong <small>Một dự án khóa JAVA tại VinaEnter Edu</small></a></h1>
      </div>
      <div class="menu_nav">
        <ul>
       <%
       
       String active = "";
       
       %>
          <li class="active"><a href="<%=request.getContextPath()%>/"><span>Trang chủ</span></a>
          <li class=""><a href="<%=request.getContextPath() %>/lien-he"><span>Liên hệ</span></a></li>
          
        </ul>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"><a href="#"><img src="<%=request.getContextPath() %>/templates/public/images/slide1.jpg" width="935" height="307" alt="" /></a> <a href="#"><img src="images/slide2.jpg" width="935" height="307" alt="" /></a> <a href="#"><img src="images/slide3.jpg" width="935" height="307" alt="" /></a></div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">