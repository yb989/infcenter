<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.yph.infcenter.common.constant.Constants"%>
<%
	request.setAttribute("app",request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title><%=Constants.WEB_TITLE%></title>
  <LINK rel=stylesheet type=text/css href="${app}/img/base.css">
  <LINK rel=stylesheet type=text/css href="${app}/img/news.css">
  <script type="text/javascript" src="${app}/img/jquery.js"></script>
</head>
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
<DIV class=nav><A href="${app}/index.jsp">首页</A> 
<A href="${app}/news_list.jsp?firstLevelId=2" ${firstLevelId == '2' ? 'class=crt':''}>工作动态</A> 
<A href="${app}/news_list.jsp?firstLevelId=3" ${firstLevelId == '3' ? 'class=crt':''}>政策法规</A> 
<A href="${app}/news_list.jsp?firstLevelId=4" ${firstLevelId == '4' ? 'class=crt':''}>工业运行</A> 
<A href="${app}/news_list.jsp?firstLevelId=5" ${firstLevelId == '5' ? 'class=crt':''}>规划投资</A> 
<A href="${app}/news_list.jsp?firstLevelId=6" ${firstLevelId == '6' ? 'class=crt':''}>民营经济</A> 
<A href="${app}/news_list.jsp?firstLevelId=7" ${firstLevelId == '7' ? 'class=crt':''}>信息化建设</A> 
<A href="${app}/news_list.jsp?firstLevelId=8" ${firstLevelId == '8' ? 'class=crt':''}>安全生产</A> 
<A href="${app}/about.jsp">关于我们</A> </DIV>
<!-- 地市、搜索 -->


<DIV class=navbar>
<DIV class=nav_dishi>欢迎点击进入“中国吉林省白山市江源区经济局中小企业网”</DIV>
</DIV>
<SCRIPT type=text/javascript src="/img/344.htm"></SCRIPT>
<!-- 当前页面位置 --><!-- 面包屑导航[当前位置] -->
<DIV class=crumb>
您现在的位置：&nbsp;<a class='LinkPath' href='${app}/index.jsp'><%=Constants.WEB_TITLE%></a>&nbsp;>>&nbsp;<a class='LinkPath' href='${app}/about.jsp'>关于我们</a>&nbsp;>>&nbsp;首页
<!-- 新闻 -->
<DIV class=content><!-- 左侧列表 开始 -->
<DIV class="news_side mr10"><!-- 二级菜单 -->
<DIV class="menu mb10">
<DIV class=menu_t>
<H2>重点频道</H2></DIV>
<DIV class=menu_c>
 
  <UL>
    <LI><A href="${app}/news_list.jsp?firstLevelId=2" ${firstLevelId == '2' ? 'class=crt':''}>工作动态</A> </LI>
    <LI><A href="${app}/news_list.jsp?firstLevelId=3" ${firstLevelId == '3' ? 'class=crt':''}>政策法规</A> </LI>
    <LI><A href="${app}/news_list.jsp?firstLevelId=4" ${firstLevelId == '4' ? 'class=crt':''}>工业运行</A> 
    <LI><A href="${app}/news_list.jsp?firstLevelId=5" ${firstLevelId == '5' ? 'class=crt':''}>规划投资</A> </LI>
    <LI><A href="${app}/news_list.jsp?firstLevelId=6" ${firstLevelId == '6' ? 'class=crt':''}>民营经济</A> </LI>
    <LI><A href="${app}/news_list.jsp?firstLevelId=7" ${firstLevelId == '7' ? 'class=crt':''}>信息化建设</A> </LI>
    <LI><A href="${app}/news_list.jsp?firstLevelId=8" ${firstLevelId == '8' ? 'class=crt':''}>安全生产</A> </LI>
  </UL>
</DIV></DIV><!-- 图片新闻列表 --><!-- 左侧列表[文章列表页] -->

<DIV class="sub_side_box mb10">
<DIV class=sub_side_box_t>
<H2>江源区经济局</H2></DIV>
<DIV class=sub_side_box_c>
<UL>
<LI><img src="/img/125.jpg" width="287" height="250"></A></LI> 
</UL></DIV></DIV><!-- 视频新闻列表 --><!-- 左侧列表[文章列表页] -->
</DIV><!-- 左侧列表 结束 -->



<DIV class=news_wide>
<DIV class=news_title>
<H2>关于我们</H2></DIV>

<DIV class=news_about>
<UL>
<LI class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;负责中小企业的宏观指导，会同有关部门实施国家、
省有关方面促进中小企业发展和非国有经济发展的相关政策和措施；拟定全区中小企业发展的政策，
建立完善服务体系，协调相关部门解决重大问题；负责调度、监控、分析中小企业和非公有经济发展情况，
负责中小企业市场开拓工作和专项资金管理工作；负责政策法规等信息的收集整理、发布和传播等信息化工作，
协调新闻媒体及时宣传报道中小企业经济发展情况及中小企业信息网络建设工作，提出改善工业企业和中小企业融资环境的政策措施，
协调解决工业和中小企业融资的有关重大问题；引导和推动民间资本和风险投资机构投资中小企业，促进中小企业发展。</LI>
</UL>


</DIV></DIV></DIV></DIV>

<DIV class=footbar></DIV>
<DIV class=footer>Copyright &copy; 2013 <%=Constants.WEB_DOMAIN_URL%> All rights Reserved.　<%=Constants.COPYRIGHT%>
版权所有<BR>主办单位：<%=Constants.SPONSOR%>　承办单位：<%=Constants.CONTRACTORS%>　技术支持：<%=Constants.IT_SUPPORT%><BR>电子邮件：<%=Constants.EMAIL%>　联系电话：<%=Constants.TEL%><a href="${app}/admin/index.jsp" target="_blank">&nbsp;&nbsp;后台登陆</a><BR>ICP备案号：<%=Constants.ICP%>
</DIV>

</BODY>
</html>
