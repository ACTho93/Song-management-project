<%@page import="model.bean.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>

<div class="content_resize">
  <div class="mainbar">
    <div class="article">
    <%
    	Song song =(Song) request.getAttribute("song");
    	if(song != null){
    %>
    
      <h1><%=song.getName() %></h1>
      <div class="clr" id="active"></div>
	      <span>Ngày đăng: <%=song.getDateCreate() %> Lượt xem: <%=song.getCounter() %> <span>
				<a href="javascript:void(0)">
					<img onclick="like()" id="image" height="20px" width="20px" src="<%=request.getContextPath() %>/templates/public/images/likeT.png" />
					
				</a>
				<span><%=song.getCountlike() %> <span>
      <div class="vnecontent">
          <%=song.getDetailText() %>
      </div>
       <% } %>
    </div>
    <div>
	   <form class="form-cmt" >
			<div class="article">
				<input type="text" name="cmt" id="cmt" value="" placeholder="Nhập bình luận" />
				<a  href="javascript:void(0)" onclick="return getComment()">Bình luận</a>
			</div>
		</form>
	</div>
	
	
	<div class="ajax-data"  >
		<%
			ArrayList<Comment> listCmtById =(ArrayList<Comment>) request.getAttribute("listCmtById");
	    	if(listCmtById != null){
	    		for(Comment item: listCmtById){
		%>
		<div >
			<span class="article" style="color: red; background-color: yellow ; padding-left: 20px " ><%=item.getComment() %></span>
			<%--<input style="color: green" class="comment" type="text" name="cmt" id="cmt" value="<%=item.getComment() %>" placeholder="" />--%>
		</div >
		<% }}else{ %>
		<p>Hãy là người bình luận đầu tiên !</p>
		<% } %>
	</div>
	
	
	
    <div class="article">
      <h2>Bài viết liên quan</h2>
      <div class="clr"></div>
      <%
      	ArrayList<Song> relatedSongs =(ArrayList<Song>) request.getAttribute("relatedSongs");
      	if(relatedSongs != null && relatedSongs.size() > 0){
      		for(Song item: relatedSongs){
      %>
      <div class="comment"> <a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(item.getCategory().getName()) %>/<%=StringUtil.makeSlug(item.getName())%>-<%=item.getId() %>.html"><img src="<%=request.getContextPath() %>/files/<%=item.getPicture() %>" width="40" height="40" alt="" class="userpic" /></a>
        <h2><a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(item.getCategory().getName()) %>/<%=StringUtil.makeSlug(item.getName())%>-<%=item.getId() %>.html"><%=item.getName() %></a></h2>
        <p><%=item.getPreviewText() %></p>
      </div>
      <% }} %>
    </div>
  </div>
  <div class="sidebar">
  <%@ include file="/templates/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>

<script type="text/javascript">
	function getComment(){
		var cmt = $("#cmt").val();
		$.ajax({
			url: '<%=request.getContextPath()%>/detail',
			type: 'POST',
			cache: false,
			data: {
				acmt: cmt
			},
			success: function(data){
				$(".ajax-data").html(data);
			},
			error: function (){
				alert("có lỗi trong quá trình xử lý!");
			}
		});
		return false;
	}
</script>

<script type="text/javascript" >
	function like(){
		if(document.getElementById('image').src.endsWith("<%=request.getContextPath() %>/templates/public/images/likeT.png"))
			document.getElementById('image').src = "<%=request.getContextPath() %>/templates/public/images/likeD.png";
			
		 else{
			document.getElementById('image').src = "<%=request.getContextPath() %>/templates/public/images/likeT.png";	
			
		}
	}
</script>