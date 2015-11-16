<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <body>
  <!-- 二级导航页面 -->
  <div id="roootDiv" class="menuDiv">
    <form id="pilotForm" class="easyui-form" method="post" modelAttribute="infcenterPilot">
    	<c:if test="${!empty parentId}">
    		<input type="hidden" id="parentId" name="parentId" value="${parentId}"/>
    	</c:if>
    	<c:if test="${!empty infcenterPilot.id}">
    		<input  type="hidden" id="id" name="id" value="${infcenterPilot.id}"/>
    	</c:if>
    
		<table id="fatherRoot" class="tableForm" width="100%" height="63%" border="0">
			<tr>
				<td class="tdR" width="30%"><span style="color: red">*</span>中文名字:</td>
				<td width="70%">
					<input type="text" id="prepaymentDate" name="columnZhName" value="${infcenterPilot.columnZhName}" class='easyui-textbox' data-options="required:true,validType:['length[0,20]']" style="width: 280px;height: 27px;"/>
				</td>
			</tr>
			
			<tr>
				<td class="tdR"><span style="color: red">*</span>英文名字:</td>
				<td>
					<input type="text" id="prepaymentDate" name="columnEnName" value="${infcenterPilot.columnEnName}" class='easyui-textbox' data-options="validType:['length[0,50]']" style="width: 280px;height: 27px;"/>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red"></span>模板名称:</td>
				<td>
					<input type="text" id="prepaymentDate" name="velocityName" value="${infcenterPilot.velocityName}" class='easyui-textbox' data-options="validType:['length[0,30]']" style="width: 280px;height: 27px;"/>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>url:</td>
				<td>
					<input type="text" id="prepaymentDate" name="columnUrl" value="${infcenterPilot.columnUrl}" class='easyui-textbox' data-options="required:true,validType:['length[0,300]']" style="width: 280px;height: 27px;"/>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>是否可用:</td>
				<td>
					<input readonly="readonly" type="radio" id="isEffective1" name="isEffective" value="0" <c:if test="${infcenterPilot.isEffective=='0'}">checked</c:if>/><label for="isEffective1">否</label>
					<input readonly="readonly" type="radio" id="isEffective2" name="isEffective" value="1" <c:if test="${infcenterPilot.isEffective=='1'||infcenterPilot.isEffective==null}">checked</c:if>/><label for="isEffective2">是</label>
				</td>
			</tr>
			<!-- 
			<tr>
				<td class="tdR"><span style="color: red">*</span>保存目录:</td>
				<td>
					<input type="text" id="prepaymentDate" name="pageSavePath" value="${infcenterPilot.pageSavePath}" class='easyui-textbox' data-options="required:true,validType:['length[0,400]']" style="width: 280px;height: 27px;"/>
				</td>
			</tr>
			 -->
			<tr>
				<td colspan="2" align="center" height="30px">
					<a class="easyui-linkbutton" id="submitButton"  iconCls="icon-ok" onclick="submitFn();">提交</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancelFn();">取消</a>
				</td>
			</tr>
		</table>
	</form>
  </div>
  </body>
</html>
