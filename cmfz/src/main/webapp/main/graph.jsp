<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>



<head>
  <script type="text/javascript">
        $(function(){
            var myChart = echarts.init(document.getElementById('dadad'));

            $.ajax({
                url:"${pageContext.request.contextPath}/sss/sex",
                dataType:"JSON",
                type:"post",
                success:function(data){
                    option = {
                        title : {
                            text: '男女分布图',
                            subtext: '纯属虚构',
                            left: 'center'
                        },
                        tooltip : {
                            trigger: 'item'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            data:['男','女',]
                        },
                        visualMap: {
                            min: 0,
                            max: 2500,
                            left: 'left',
                            top: 'bottom',
                            text:['高','低'],           // 文本，默认为数值文本
                            calculable : true
                        },
                        toolbox: {
                            show: true,
                            orient : 'vertical',
                            left: 'right',
                            top: 'center',
                            feature : {
                                mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                restore : {show: true},
                                saveAsImage : {show: true}
                            }
                        },
                        series : [
                            {
                                name: '男',
                                type: 'map',
                                mapType: 'china',
                                roam: false,
                                label: {
                                    normal: {
                                        show: false
                                    },
                                    emphasis: {
                                        show: true
                                    }
                                },
                                data:data.man
                            },

                            {
                                name: '女',
                                type: 'map',
                                mapType: 'china',
                                label: {
                                    normal: {
                                        show: false
                                    },
                                    emphasis: {
                                        show: true
                                    }
                                },
                                data:data.woman
                            }
                        ]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                }
            });

        });
    </script>
</head>
</body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="dadad" style="width: 600px;height:400px;"></div>

</body>
