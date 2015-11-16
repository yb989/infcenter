<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.yph.infcenter.common.constant.Constants"%>
<%
	request.setAttribute("app",request.getContextPath());
%>
<!DOCTYPE html>
<!-- saved from url=(0024)http://www.jyzxqy.com/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE><%=Constants.WEB_TITLE%></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<LINK rel=icon type=image/x-icon href="/favicon.ico" mce_href="/favicon.ico">
<LINK rel=stylesheet type=text/css href="${app}/img/base.css">
<LINK rel=stylesheet type=text/css href="${app}/img/main.css"><!-- banner -->
<SCRIPT type=text/javascript src="${app}/img/jquery.js"></SCRIPT>

</HEAD>
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
		function newsDynamic(firstLevelId,divId,rowNumber){
			$.ajax({
				type: "POST",
				url: "index/newsDynamic?rowNumber="+rowNumber+"&firstLevelId="+firstLevelId,
				dataType:'json',
				success: function(result){
					var data = eval('(' + result + ')');
					if(data == ""){
						$("#"+divId).append("<li>没有文章</li>");
					}else{
						$(data).each(function(i){
							var title = data[i].title;
							if(title.length >= 20){
								title = title.substring(0,20) + "...";
							}
							$("#"+divId).append("<li>"+
							"<span>"+data[i].operateTime+"</span>•<a href='news.jsp?firstLevelId="+firstLevelId+"&id="+data[i].id+"' title='"+data[i].title+"'>"+title+"</a>"+
							"</li>");
						});
					}
				}
			}); 
		}
	
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
      
      	$(function(){
	    	newsDynamic(2,'gzdt',10);//工作动态
	    	newsDynamic(3,'zcfg',7);//政策法规
	    	newsDynamic(4,'gyyx',7);//工业运行
	    	newsDynamic(5,'ghtz',7);//规划投资
	    	newsDynamic(6,'myjj',7);//民营经济
	    	newsDynamic(7,'xxhjs',7);//信息化建设
	    	newsDynamic(8,'bszn',7);//安全生产
		});
    </SCRIPT>
</DIV>
<DIV class=headbar_r><A 
onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('<%=Constants.WEB_DOMAIN_URL%>');" 
href="javascript:void(0);">设为首页</A> | <A title=<%=Constants.WEB_TITLE%> 
href="javascript:window.external.AddFavorite('http://<%=Constants.WEB_DOMAIN_URL%>','<%=Constants.WEB_TITLE%>')" 
alt="<%=Constants.WEB_TITLE%>">加入收藏</A> | <A 
href="http://<%=Constants.WEB_DOMAIN_URL%>/">网站导航</A></DIV></DIV><!-- header -->
<DIV class=header>
<OBJECT 
codeBase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" 
classid=clsid:D27CDB6E-AE6D-11cf-96B8-444553540000 width=1000 height=145><PARAM NAME="movie" VALUE="${app}/img/header.swf"><PARAM NAME="quality" VALUE="high"><PARAM NAME="wmode" VALUE="transparent">
                        <embed src="${app}/img/header.swf" 
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
<DIV class=nav_search></DIV></DIV>
<DIV class=content><!-- 广告 --><IMG border=0 
onerror="this.src='/site/sxsme_gov/test/banner_1.jpg'" 
src="${app}/img/47941781-3bc9-454f-9e1a-b549074df312.jpg" width=1000> 
</A></DIV>
<!-- 图片新闻、新闻列表、政务公开、党务公开 -->
<DIV class=content>
<DIV class="wide mr10">
<DIV class="news mb10">
<DIV class=picnews>
<DIV id=picnews_tab>

<UL>
   <LI class=out><A title=图片新闻 
  href="http://<%=Constants.WEB_DOMAIN_URL%>/" 
  alt="图片新闻">图片新闻</A></LI>

</DIV>

<DIV id=picnews_con>


<DIV>
<SCRIPT type=text/javascript>
              var interval_time=5;     //间隔时间
              var focus_width=355;     //宽、高为偶数
              var focus_height=236;
              var text_height=24;      //文字高度
              var text_align= 'center';
              var swf_height = focus_height+text_height;
			  var pics = [];
              var links = [];
              var texts = [];
	    	  //图片新闻
			            
					
				$.ajax({
					type: "GET",
					url: "${app}/index/newsDynamic?rowNumber=5&firstLevelId=9",
					dataType:'json',
					async: false,
					success: function(result){
						var data = eval('(' + result + ')');
						$(data).each(function(i){
							var title = data[i].title;
							if(title.length >= 25){
								title = title.substring(0,25) + "...";
							}
							pics.push(escape("indexImg/"+data[i].indexUrl));
				            links.push(escape("news.jsp?firstLevelId=2&id="+data[i].id));
				            texts.push(title);
						});
					}
				}); 
			                		              
<%--                					              pics.push(escape("swf/image/20130627.jpg"));--%>
<%--              links.push(escape("/w/sxsme/article-61962757-347c-446a-b6c4-9361dae39c19.html"));--%>
<%--              texts.push("2012年小微企业17条措施新闻");--%>
<%--                					              pics.push(escape("swf/image/20140425.jpg"));--%>
<%--              links.push(escape("/w/sxsme/article-9e2418a1-8270-459d-9ba0-9e1864c58aed.html"));--%>
<%--              texts.push("第九届中博会新闻");--%>
              
              document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="swf/swflash.cab#version=8,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
              document.write('<param name="movie" value="swf/pixviewer.swf"><param name="quality" value="high"><param name="bgcolor" value="#f6f6f6">');
              document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
              document.write('<param name="FlashVars" value="pics='+pics.join("|")+'&links='+links.join("|")+'&texts='+texts.join("|")+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&text_align='+text_align+'&interval_time='+interval_time+'">');
              document.write('<embed src="swf/pixviewer.swf" wmode="opaque" FlashVars="pics='+pics.join("|")+'&links='+links.join("|")+'&texts='+texts.join("|")+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&text_align='+text_align+'&interval_time='+interval_time+'" menu="false" bgcolor="#ffffff" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');
              document.write('</object>');
            </SCRIPT>
</DIV>
</DIV>
<SCRIPT>
          var Tags=document.getElementById('picnews_tab').getElementsByTagName('li'); 
          var TagsCnt=document.getElementById('picnews_con').getElementsByTagName('div'); 
          var len=Tags.length; 
          var flag=0; //修改默认值
          for(i=0;i<len;i++){
            Tags[i].value = i;
            Tags[i].onmouseover=function(){changeNav(this.value)}; 
            TagsCnt[i].className='undis';			
          }
            Tags[flag].className='over';
            TagsCnt[flag].className='dis';
            function changeNav(v){	
            Tags[flag].className='out';
            TagsCnt[flag].className='undis';
            flag=v;	
            Tags[v].className='over';
            TagsCnt[v].className='dis';
          }
        </SCRIPT>
</DIV>
<!-- 工作动态 -->
<DIV class=focusnews>
<DIV class=focusnews_t>
<H2>工作动态</A></H2><A class=more title=更多 href="news_list.jsp?firstLevelId=2" target=_blank alt="更多">更多&gt;</A>
</DIV>
<DIV class=focusnews_box_c>
	<UL class=news_list id="gzdt">
	</UL>
</DIV>

</DIV>
</DIV>


<!-- 政策法规-->
<DIV class=news_container>
<DIV class="news_box_2 mr10 mb10">
<DIV class=news_box_t>
<H2>政策法规</H2><A class=more 
href="${app}/news_list.jsp?firstLevelId=3" target=_blank>更多&gt;</A> 
</DIV>
<DIV class="focusnews_box_c">
<DIV>
	<UL class=news_list id="zcfg">
	</UL>
</DIV></DIV></DIV>


<!-- 工业运行 -->
<DIV class="news_box_2 mb10">
<DIV class=news_box_t_2>
<DIV class=news_box_t>
<H2>工业运行</H2><A class=more 
href="${app}/news_list.jsp?firstLevelId=4" target=_blank>更多&gt;</A> 
</DIV>
<DIV class="focusnews_box_c">
<DIV>
	<UL class=news_list id="gyyx">
	</UL>
</DIV></DIV>
</DIV>
</DIV>


</DIV></DIV>
<DIV class=side>
<DIV class="public mb10">

<DIV class=public_content>
<UL class=public_list>
</UL></DIV></DIV>


<DIV class=zhengfeng>
<DIV class=zhengfeng_title></DIV>
<DIV class=zhengfeng_content>
<img src="${app}/img/fwzx.jpg" width="250" height="210">
</DIV></DIV></DIV></DIV><!-- banner -->
<DIV class=content><!-- 广告 --><IMG border=0 
onerror="this.src='test/banner_2.jpg'" 
src="${app}/img/af22a123-8054-4c8c-a057-0728d517ff16.jpg" width=1000> 
</A></DIV>
<!-- 创业项目 -->
<DIV class=content>
<DIV class="wide mr10">
<DIV class="news_box mr10">
<DIV class=news_box_t>
<H2 id=news_tab_6>规划投资</H2><A class=more href="${app}/news_list.jsp?firstLevelId=5" target=_blank>更多&gt;</A> 
</DIV>
<DIV id=news_con_6 class="news_box_c h194">
<DIV>
<UL class=news_list id="ghtz">
</UL>
</DIV></DIV></DIV>



<!-- 招商引资 -->
<DIV class=news_box>
<DIV class=news_box_t>
<H2 id=news_tab_6>民营经济</H2><A class=more 
href="${app}/news_list.jsp?firstLevelId=6" target=_blank>更多&gt;</A> 
</DIV>
<DIV class="news_box_c h194">

<UL class=news_list id="myjj">
</UL>

</DIV></DIV></DIV>
<DIV class=side>
<DIV class="public mb10">

<DIV class=public1_content>
<UL class=public1_list>

</UL></DIV></DIV></DIV></DIV><!-- 专题专栏 -->
<DIV class=topic>
<DIV class=topic_c>
<DIV class=topic_arrow_left><IMG onmouseup=ISL_StopUp() onmouseout=ISL_StopUp() 
onmousedown=ISL_GoUp() src="${app}/img/topic_arrow_left.gif"></DIV>
<DIV id=isl_cont class=cont>
<DIV class=scrcont>
<DIV id=list1>
<UL>
  <LI><IMG src="${app}/img/topic_1.jpg" width=220 height=60></LI>
  <LI><IMG src="${app}/img/topic_2.jpg" width=220 height=60></LI>
  <LI><IMG src="${app}/img/topic_3.jpg" width=220 height=60></LI>
  <LI><IMG src="${app}/img/topic_4.jpg" width=220 height=60></LI>
  <LI><IMG src="${app}/img/topic_5.jpg" width=220 height=60></LI></UL></DIV>
<DIV id=list2></DIV></DIV></DIV>
<DIV class=topic_arrow_right><IMG onmouseup=ISL_StopDown() 
onmouseout=ISL_StopDown() onmousedown=ISL_GoDown() 
src="${app}/img/topic_arrow_right.gif"></DIV>
<SCRIPT language=javascript type=text/javascript>
        <!--//--><![CDATA[//><!--
        //图片滚动列表
        var Speed = 10; //速度(毫秒)
        var Space = 10; //每次移动(px)
        var PageWidth = 233 //翻页宽度
        var fill = 0; //整体移位
        var MoveLock = false;
        var MoveTimeObj;
        var Comp = 0;
        var AutoPlayObj = null;
        GetObj("list2").innerHTML = GetObj("list1").innerHTML;
        GetObj('isl_cont').scrollLeft = fill;
        GetObj("isl_cont").onmouseover = function() {
          clearInterval(AutoPlayObj);
        }
        GetObj("isl_cont").onmouseout = function() {
          AutoPlay();
        }
        AutoPlay();
        function GetObj(objName) {
          if (document.getElementById) {
            return eval('document.getElementById("' + objName + '")')
          } else {
            return eval
            ('document.all.' + objName)
          }
        }
        function AutoPlay() { //自动滚动
          clearInterval(AutoPlayObj);
          AutoPlayObj = setInterval('ISL_GoDown();ISL_StopDown();', 3000); //间隔时间
        }
        function ISL_GoUp() { //上翻开始
          if (MoveLock) return;
          clearInterval(AutoPlayObj);
          MoveLock = true;
          MoveTimeObj = setInterval('ISL_ScrUp();', Speed);
        }
        function ISL_StopUp() { //上翻停止
          clearInterval(MoveTimeObj);
          if (GetObj('isl_cont').scrollLeft % PageWidth - fill != 0) {
            Comp = fill - (GetObj('isl_cont').scrollLeft % PageWidth);
            CompScr();
          } else {
            MoveLock = false;
          }
          AutoPlay();
        }
        function ISL_ScrUp() { //上翻动作
          if (GetObj('isl_cont').scrollLeft <= 0) {
            GetObj('isl_cont').scrollLeft = GetObj
            ('isl_cont').scrollLeft + GetObj('list1').offsetWidth
          }
          GetObj('isl_cont').scrollLeft -= Space;
        }
        function ISL_GoDown() { //下翻
          clearInterval(MoveTimeObj);
          if (MoveLock) return;
          clearInterval(AutoPlayObj);
          MoveLock = true;
          ISL_ScrDown();
          MoveTimeObj = setInterval('ISL_ScrDown()', Speed);
        }
        function ISL_StopDown() { //下翻停止
          clearInterval(MoveTimeObj);
          if (GetObj('isl_cont').scrollLeft % PageWidth - fill != 0) {
            Comp = PageWidth - GetObj('isl_cont').scrollLeft % PageWidth + fill;
            CompScr();
          } else {
            MoveLock = false;
          }
          AutoPlay();
        }
        function ISL_ScrDown() { //下翻动作
          if (GetObj('isl_cont').scrollLeft >= GetObj('list1').scrollWidth) {
            GetObj('isl_cont').scrollLeft =
            GetObj('isl_cont').scrollLeft - GetObj('list1').scrollWidth;
          }
          GetObj('isl_cont').scrollLeft += Space;
        }
        function CompScr() {
          var num;
          if (Comp == 0) {
            MoveLock = false;
            return;
          }
          if (Comp < 0) { //上翻
            if (Comp < -Space) {
              Comp += Space;
              num = Space;
            } else {
              num = -Comp;
              Comp = 0;
            }
            GetObj('isl_cont').scrollLeft -= num;
            setTimeout('CompScr()', Speed);
          } else { //下翻
            if (Comp > Space) {
              Comp -= Space;
              num = Space;
            } else {
              num = Comp;
              Comp = 0;
            }
            GetObj('isl_cont').scrollLeft += num;
            setTimeout('CompScr()', Speed);
          }
        }
        //--><!]]>
      </SCRIPT>
</DIV></DIV><!-- 新闻列表 -->
<DIV class=content>
<DIV class="wide mr10">
<DIV class="news_box mr10">
<DIV class=news_box_t>
<H2 id=news_tab_6>信息化建设</H2><A class=more 
href="${app}/news_list.jsp?firstLevelId=7" target=_blank>更多&gt;</A> 
</DIV>
<DIV id=news_con_6 class="news_box_c h194">
<DIV>

<UL class=news_list id="xxhjs">
</UL>

</DIV></DIV></DIV>
<!-- 休闲旅游 -->
<DIV class=news_box>
<DIV class=news_box_t>
<H2 id=news_tab_6>安全生产</H2><A class=more 
href="${app}/news_list.jsp?firstLevelId=8" target=_blank>更多&gt;</A> 
</DIV>
<DIV class="news_box_c h194">

<UL class=news_list id="bszn">
</UL>

</DIV></DIV></DIV>
<DIV class=side>
<DIV class=side_box>
<DIV class=side_box_t>
<H2>江源区经济局地图</H2></DIV>
<DIV class="news_box_c h194">
<img src="${app}/img/ditu.jpg">
</DIV></DIV></DIV></DIV><!-- banner -->
<!-- 广告 --> 
<!-- 新闻列表、浏览排行、在线调查 -->
<DIV class=content>
<DIV class=link_pic>
<DIV class=link_arrow_left><A onmouseover="javascript: GoLeft2();" 
href="http://<%=Constants.WEB_DOMAIN_URL%>/#"><IMG 
src="${app}/img/arrow_left.gif"></A></DIV>
<DIV id=marquee_link>
<DIV id=inlink>
<DIV id=link1>
<UL>
  <LI><A title=白山市工业和信息化局 href="http://bsgxj.cbs.gov.cn/" target=_blank 
  alt="白山市工业和信息化局"><IMG onerror="this.src='/site/sxsme_gov/test/sme.gif'" 
  src="${app}/img/bsgxj.jpg"></A></LI>
  <LI><A title=白山政府网 href="http://bs.jl.gov.cn/" target=_blank 
  alt="白山政府网"><IMG onerror="this.src='/site/sxsme_gov/test/sme.gif'" 
  src="${app}/img/bszf.jpg"></A></LI>
  <LI><A title=中国中小企业吉林信息网 href="http://www.smejl.gov.cn/" target=_blank 
  alt="中国中小企业吉林信息网"><IMG onerror="this.src='/site/sxsme_gov/test/sme.gif'" 
  src="${app}/img/3051916c-5770-4dd6-91b9-989c835e7bc2.gif"></A></LI>　 
  <LI><A title=吉林省工业和信息化厅 href="http://gxt.jl.gov.cn/" target=_blank 
  alt="吉林省工业和信息化厅"><IMG onerror="this.src='/site/sxsme_gov/test/sme.gif'" 
  src="${app}/img/b286dfce-e510-4346-b643-2b109fc5c1f3.gif"></A></LI>　 
  <LI><A title=白山中小企业网 href="http://www.cbssme.gov.cn/" target=_blank 
  alt="白山中小企业网"><IMG onerror="this.src='/site/sxsme_gov/test/sme.gif'" 
  src="${app}/img/5ef3cc50-ce5a-40cc-b98d-d7a2a71a1624.gif"></A></LI>　 
  <LI><A title=江源人民政府网 href="http://jy.cbs.gov.cn/" target=_blank 
  alt="江源人民政府网"><IMG onerror="this.src='/site/sxsme_gov/test/sme.gif'" 
  src="${app}/img/c7c3594c-e5e3-486c-b4a4-bce38bf34c86.gif"></A></LI>　 
  <LI><A title=抚松中小企业网 href="http://www.fs.smejl.gov.cn/" target=_blank 
  alt="抚松中小企业网"><IMG onerror="this.src='/site/sxsme_gov/test/sme.gif'" 
  src="${app}/img/4c494f6f-1231-448f-8fc6-b8bd7a25f0bc.gif"></A></LI>　 
  <LI><A title=临江中小企业网 href="http://linj.longcon.com.cn" target=_blank alt="临江中小企业网"><IMG 
  onerror="this.src='/site/sxsme_gov/test/sme.gif'" 
  src="${app}/img/db7e5584-28af-4e59-9266-f092555e0f78.gif"></A></LI>　 　 
</UL></DIV>
<DIV id=link2></DIV></DIV></DIV>
<SCRIPT>
		<!--
		var LeftOrRight2 = "MarqueeLeft2"; //1向左2向右
		var speed = 30; //数字越大速度越慢
		var tab2 = document.getElementById("marquee_link");
		var tab21 = document.getElementById("link1");
		var tab22 = document.getElementById("link2");
		tab22.innerHTML = tab21.innerHTML;
		function MarqueeLeft2(){
			if(tab22.offsetWidth - tab2.scrollLeft <= 0)
				tab2.scrollLeft -= tab21.offsetWidth;
			else{
				tab2.scrollLeft++;
			}
		}
		function MarqueeRight2(){
			if(tab2.scrollLeft <= 0)
				tab2.scrollLeft += tab22.offsetWidth;
			else{
				tab2.scrollLeft--;
			}
		}
		function GoLeft2(){
			LeftOrRight2 = "MarqueeLeft2";
			clearInterval(MyMar22);
			MyMar22 = setInterval(eval(LeftOrRight2),speed);
		}
		function GoRight2(){
			LeftOrRight2 = "MarqueeRight2";
			clearInterval(MyMar22);
			MyMar22 = setInterval(eval(LeftOrRight2),speed);
		}
		var MyMar22 = setInterval(eval(LeftOrRight2),speed);
		tab2.onmouseover = function() {clearInterval(MyMar22)};
		tab2.onmouseout = function() {MyMar22=setInterval(eval(LeftOrRight2),speed)};
		-->
    </SCRIPT>

<DIV class=link_arrow_right><A onmouseover="javascript: GoRight2();" 
href="http://<%=Constants.WEB_DOMAIN_URL%>/"><IMG 
src="${app}/img/arrow_right.gif"></A></DIV></DIV></DIV><!-- footer -->

<DIV class=footer>Copyright &copy; 2013 <%=Constants.WEB_DOMAIN_URL%> All rights Reserved.　<%=Constants.COPYRIGHT%>
版权所有<BR>主办单位：<%=Constants.SPONSOR%>　承办单位：<%=Constants.CONTRACTORS%>　技术支持：<%=Constants.IT_SUPPORT%><BR>电子邮件：<%=Constants.EMAIL%>　联系电话：<%=Constants.TEL%><a href="${app}/admin/index.jsp" target="_blank">&nbsp;&nbsp;后台登陆</a><BR>ICP备案号：<%=Constants.ICP%>
</DIV>

</BODY>
</HTML>