<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<head>
    <script type="text/javascript">
        var toolbar= [{
            iconCls: 'icon-edit',
            text:"添加",
            handler: function(){alert('编辑按钮')
                $('#dd').dialog({
                    title: '添加',
                    width: 400,
                    height: 300,
                    closed: false,
                    cache: false,
                    //  href: 'get_content.php',
                    modal: true

                });
                    }
        },'-',{
            iconCls: 'icon-cancel',
            text:"删除",
            handler: function(){alert('删除按钮')
                var row = $("#dg").edatagrid("getSelected")
                console.log(row)
                if (row == null) {
                    $.messager.show({
                        title: '警告',
                        msg: '请选中删除行。',
                        showType: 'show',
                        style: {
                            right: '',
                            top: document.body.scrollTop + document.documentElement.scrollTop,
                            bottom: ''
                        }
                    });
                } else {
                    /*将当前行删除*/
                    $("#dg").edatagrid("destroyRow");
                    $.messager.show({
                        msg:"删除成功",
                    })
                }

            }
        },'-',{
            iconCls: 'icon-help',
            text:"修改",
            handler: function(){
                /*var row= $("#dg").edatagrid("getSelected")
                if(row==null){
                    alert("请先选择修改框")
                }else{
                   var index=$("#dg").edatagrid("getRowIndex",row);
                    $("#dg").edatagrid("editRow",index);
                }*/
                /*获取选中行*/
                var row = $("#dg").edatagrid("getSelected")
                if (row == null) {
                    $.messager.show({
                        title: '警告',
                        msg: '请选中修改行。',
                        showType: 'show',
                        style: {
                            right: '',
                            top: document.body.scrollTop + document.documentElement.scrollTop,
                            bottom: ''
                        }
                    });
                } else {
                    /*将当前行变成可编辑模式*/
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);
                }
            }
        },'-',{
            iconCls: 'icon-save',
            text:"保存",
            handler: function(){alert('帮助按钮')
                //saveRow none 保存编辑行并发送到服务器。
                $("#dg").edatagrid("saveRow");
            }
        }];

        $(function(){
           $('#dg').edatagrid({
               updateUrl:"${pageContext.request.contextPath}/update",
               destroyUrl:"${pageContext.request.contextPath}/delete",

                toolbar:toolbar,
                 url:'${pageContext.request.contextPath}/show',
                    columns:[[
                    {field:'title',title:'名字',width:100},
                    {field:'status',title:'状态',width:100,editor:{
                        type:"text",
                            option:{
                            required:true,
                            }
                        }},
                    {field:'desc',title:'描述',width:100,align:'right'},
                ]],
                fit:true,
                fitColumns:true,
                pagination:true,
                pageSize:3,
                pageList:[3,6,9],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="' + rowData.imgPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>时间: ' + rowData.date + '</p>' +
                        '<p>描述: ' + rowData.desc + '</p>' +
                        '<p>状态: ' + rowData.status + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });
     })

    </script>
    </head>


        <table id="dg"></table>

<%--弹出对话框--%>
<%--<div id="dd">
    <form id="ff" method="post" >
        标题： <input type="text" name="title"/> </br>
        描述：<input type="text" name="desc"/> </br>
        状态：<input type="text" name="status"/> </br>
        &lt;%&ndash; <input type="submit" value="添加">&ndash;%&gt;
        <a href="JavaScript:void(0)" class="easyui-linkbutton" onclick="doAdd()">添加</a>
    </form>
</div>--%>

