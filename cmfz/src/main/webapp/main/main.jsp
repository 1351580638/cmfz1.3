﻿<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript" src="../js/echarts.min.js"></script>
<script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="../js/china.js"></script>

<script type="text/javascript">
    <!--菜单处理-->
    $.ajax({
        "url": "${pageContext.request.contextPath}/all",
        "dataType": "JSON",
        "type": "post",
        success: function (data) {

            $.each(data, function (index, first) {
                var c = "";
                    $.each(first.menuList, function (index1, second) {
                        c += "<p style='text-align: center'>" +
                        "<a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" onclick=\"addTabs('" + second.title + "','" + second.url + "','" + second.iconCls + "')\" data-options=\"iconCls:'icon-search'\">"
                        + second.title +
                        "</a>" +
                        "</p>";
                })

                $('#aa').accordion('add', {
                    title: first.title,
                    content: c,
                    iconCls: first.iconCls,
                    selected: false
                });
            })
        }
    })

    function addTabs(title, url, iconCls) {
        var flag=$("#tt").tabs("exists",title);
        if (flag){
            $("#tt").tabs("select",title);
        } else {
            /*添加选项卡*/
            $('#tt').tabs('add', {
                title: title,
                selected: true,
                href:"${pageContext.request.contextPath}/main/"+url,
                iconCls: iconCls,
                closable:true
            });


        }
    }

   /* //打开添加的框
    function toOPeninsert(){
        $("#updateProdia").dialog("open");
    }
    //打开添加框的结束==*/
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${user.username} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login.jsp" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
        </div>
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>

</div>



</body> 
</html>