<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<head>
    <script type="text/javascript">
        var toolbar= [{
            iconCls: 'icon-edit',
            text:"全部导入",
            handler: function(){
                alert('编辑按钮')
            }
        },'-',{
            iconCls: 'icon-save',
            text:"全部导出",
            handler: function(){alert('帮助按钮')
                $("#gssg").datagrid({
                    url:'${pageContext.request.contextPath}/main/excl',
                    method:'post',
                })
              }
          }];

        $(function(){
           $('#gssg').datagrid({
                toolbar:toolbar,
                url:'${pageContext.request.contextPath}/main/selectUserss',
                columns:[[
                    {field:'id',title:'编号',width:100},
                    {field:'phoneNum',title:'手机号',width:100},
                    {field:'username',title:'用户',width:100},
                    {field:'password',title:'密码',width:100},
                    {field:'salt',title:'盐值',width:100},
                    {field:'dharmaName',title:'法号',width:100},
                    {field:'province',title:'省份',width:100},
                    {field:'city',title:'城市',width:100},
                    {field:'sex',title:'性别',width:100},
                    {field:'sign',title:'签名',width:100},
                    {field:'headPic',title:'头像',width:100},
                    {field:'status',title:'状态',width:100,},
                    {field:'date',title:'注册日期',width:100,},

        ]],
                fit:true,
                fitColumns:true,

            });
        })

    </script>
</head>


<table id="gssg"></table>


