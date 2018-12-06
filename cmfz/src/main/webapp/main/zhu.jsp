<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>

<head>
    <script type="text/javascript">
        $(function(){
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('dddididi'));
            $.ajax({
                url:"${pageContext.request.contextPath}/sss/count",
                dataType:"JSON",
                type:"post",
                success:function(data){
                    // 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: 'ECharts 入门示例'
                        },
                        tooltip: {},
                        legend: {
                            data:['人数']
                        },
                        xAxis: {
                            data: data.ply,
                        },
                        yAxis: {},
                        series: [{
                            name: '人数',
                            type: 'bar',
                            data: data.count,
                        }]
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
<div id="dddididi" style="width: 600px;height:400px;"></div>
</body>