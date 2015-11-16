<%@ page contentType="text/html; charset=UTF-8"%>

<link href="${app}/js/jquery-easyui-1.4.1/themes/default/easyui.css" rel="stylesheet" type="text/css">
<link href="${app}/js/jquery-easyui-1.4.1/themes/icon.css" rel="stylesheet" type="text/css">

<script src="${app}/js/jquery-easyui-1.4.1/jquery-1.8.0.min.js" charset="UTF-8" type="text/javascript"></script>
<script src="${app}/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js" charset="UTF-8" type="text/javascript"></script>

<script type="text/javascript">
	$(function(){
		if("${messageCode}" != ""){
			$.messager.show({
				title : '信息提示',
				msg : '${messageCode}',
				timeout : 5000,
				showType : 'slide'
			});
		}
	});
	//信息提示
	function showMsgSlide(msg){
		$.messager.show({
			title : '信息提示',
			msg : msg,
			timeout : 5000,
			showType : 'slide'
		});
	}
	/*将form表单元素的值序列化成对象 */
	function serializeObject(form) {
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		});
		return o;
	};

	/*清空*/
	function clearForm(datagrid) {
		$('#searchForm input').val('');
		$("#searchForm select").each(function(){
			$("#"+$(this).attr("id")).combobox('select','');
		});
		if($("#province").length > 0){
			$("#province").combobox('reload');
			$("#province").combobox('setValue','请选择');
		}
		if($("#city").length > 0){
			$("#city").combobox('loadData',[]);
			$("#city").combobox('setValue','请选择');
		}
		datagrid.datagrid('load', {});
	}
</script>