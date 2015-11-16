<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.yph.infcenter.common.constant.Constants"%>
<%
request.setAttribute("app",request.getContextPath());
	request.setAttribute("id", request.getParameter("id"));
	String firstLevelId = request.getParameter("firstLevelId");
	String title = "";
	if(firstLevelId!=null){
		if("2".equals(firstLevelId)){
			title = "工作动态";
		}else if("3".equals(firstLevelId)){
			title = "政策法规";
		}else if("4".equals(firstLevelId)){
			title = "工业运行";
		}else if("5".equals(firstLevelId)){
			title = "规划投资";
		}else if("6".equals(firstLevelId)){
			title = "民营经济";
		}else if("7".equals(firstLevelId)){
			title = "信息化建设";
		}else if("8".equals(firstLevelId)){
			title = "安全生产";
		}
		request.setAttribute("firstLevelId",firstLevelId);
		request.setAttribute("title",title);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><%=Constants.WEB_TITLE%></title>
<LINK rel=stylesheet type=text/css href="${app}/img/base.css">
  <LINK rel=stylesheet type=text/css href="${app}/img/news.css">
  <script type="text/javascript" src="${app}/img/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "POST",
			url : "${app}/index/newsDetail?id=${id}",
			dataType : 'json',
			beforeSend : function(){
				var load = "<div id='loadDiv' align='center' style='width:100%; heigth:100%; margin-top:22%;'><img src='${app}/images/loading1.gif' alt='加载中'/></div>";
				$(".news_con_page").append(load);
			},
			complete : function(){
				$("#loadDiv").hide();
			},
			success : function(data) {
				data = eval('(' + data + ')');
				$(".page_txt_box").show();
				$("#newsContent").show();
				$("#newsTitle").html(data.title);
				$("#newsDate").html(data.createTime);
				$("#newsContent").html(data.text);
			}
		});
	});
</script>
</head>

<body>
<BODY>
<DIV class=wrap><!-- headbar -->
<DIV class=headbar>
<DIV class=headbar_l>
<SCRIPT language=JavaScript> 
      today=new Date();
      function initArray(){
      this.length=initArray.arguments.length
      for(var i=0;i<this.length;i++)
      this[i+1]=initArray.arguments[i] }
      document.write(today.getFullYear(),"年",today.getMonth()+1,"月",today.getDate(),"日"); 
      var d=new initArray("星期日","星期一","星期二","星期三","星期四","星期五","星期六"); 
    </SCRIPT>

<SCRIPT language=javascript>document.write(d[today.getDay()+1]);</SCRIPT>
<SPAN id=liveclock></SPAN>
<SCRIPT language=javascript>
      function time(){
      var Digital=new Date();
      var hours=Digital.getHours();
      var minutes=Digital.getMinutes();
      var seconds=Digital.getSeconds();
      if(minutes<=9){
      minutes="0"+minutes;
      }
      if(seconds<=9){
      seconds="0"+seconds;
      }
      myclock=hours+":"+minutes+":"+seconds;
      jQuery("#liveclock").html(myclock);
      setTimeout("time()",1000);    
      }
      time();
      //-->
    </SCRIPT>
</DIV>
<DIV class=headbar_r><A 
onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://<%=Constants.WEB_DOMAIN_URL%>');" 
href="javascript:void(0);">设为首页</A> | <A title=<%=Constants.WEB_TITLE%> 
href="javascript:window.external.AddFavorite('http://<%=Constants.WEB_DOMAIN_URL%>','<%=Constants.WEB_TITLE%>')" 
alt="<%=Constants.WEB_TITLE%>">加入收藏</A> | <A 
href="http://<%=Constants.WEB_DOMAIN_URL%>/">网站导航</A></DIV></DIV><!-- header -->
<DIV class=header>
<OBJECT 
codeBase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" 
classid=clsid:D27CDB6E-AE6D-11cf-96B8-444553540000 width=1000 height=145><PARAM NAME="movie" VALUE="img/header.swf"><PARAM NAME="quality" VALUE="high"><PARAM NAME="wmode" VALUE="transparent">
                        <embed src="img/header.swf" 
quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" 
type="application/x-shockwave-flash" width="1000" height="145" 
wmode="transparent"></embed>    </OBJECT></DIV>

<!-- 导航 -->
<DIV class=nav><A class=crt href="${app}/index.jsp">首页</A> 
<A href="${app}/news_list.jsp?firstLevelId=2">工作动态</A> 
<A href="${app}/news_list.jsp?firstLevelId=3">政策法规</A> 
<A href="${app}/news_list.jsp?firstLevelId=4">工业运行</A> 
<A href="${app}/news_list.jsp?firstLevelId=5">规划投资</A> 
<A href="${app}/news_list.jsp?firstLevelId=6">民营经济</A> 
<A href="${app}/news_list.jsp?firstLevelId=7">信息化建设</A> 
<A href="${app}/news_list.jsp?firstLevelId=8">安全生产</A> 
<A href="${app}/about.jsp">关于我们</A> </DIV>
<!-- 地市、搜索 -->

<DIV class=navbar>
<DIV class=nav_dishi>欢迎点击进入“中国吉林省白山市江源区经济局中小企业网”</DIV>
</DIV>
<SCRIPT type=text/javascript src="/img/344.htm"></SCRIPT>
<!-- 当前页面位置 --><!-- 面包屑导航[当前位置] -->
<DIV class=crumb>
您现在的位置：&nbsp;<a class='LinkPath' href='${app}/index.jsp'><%=Constants.WEB_TITLE%></a>&nbsp;>>&nbsp;<a class='LinkPath' href='news_list.jsp?firstLevelId=${firstLevelId}'>${title}</a>&nbsp;>>&nbsp;首页
</DIV>
<!-- 新闻正文 -->
	<div class="company_box box_width1000">
		<div class="news_con_page">
			<div class="page_txt_box" style="display: none;">
				<h1 id="newsTitle"></h1>
				<span id="newsDate"></span>
			</div>
			<div class="page_con_box" id="newsContent" style="display: none;"></div>
		</div>
	</div>
<!-- 新闻正文 -->

<DIV class=footbar></DIV>
<DIV class=footer>Copyright &copy; 2013 <%=Constants.WEB_DOMAIN_URL%> All rights Reserved.　<%=Constants.COPYRIGHT%>
版权所有<BR>主办单位：<%=Constants.SPONSOR%>　承办单位：<%=Constants.CONTRACTORS%>　技术支持：<%=Constants.IT_SUPPORT%><BR>电子邮件：<%=Constants.EMAIL%>　联系电话：<%=Constants.TEL%><a href="${app}/admin/index.jsp" target="_blank">&nbsp;&nbsp;后台登陆</a><BR>ICP备案号：<%=Constants.ICP%>
</DIV>

</BODY>
</html>
