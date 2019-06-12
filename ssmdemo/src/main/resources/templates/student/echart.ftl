<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src="/jquery-easyui-1.5.2/jquery.min.js" type="text/javascript"></script>
<link href="/jquery-easyui-1.5.2/themes/default/easyui.css" rel="stylesheet" type="text/css">
<link href="/jquery-easyui-1.5.2/themes/icon.css" rel="stylesheet" type="text/css">
<link href="/jquery-easyui-1.5.2/demo/demo.css" rel="stylesheet" type="text/css">
<link href="/jquery-easyui-1.5.2/othercss/css/easyuistyle02.css" rel="stylesheet" type="text/css">
<script src="/jquery-easyui-1.5.2/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="/jquery-easyui-1.5.2/extends/datagridTooltip.js" type="text/javascript"></script>
<script src="/jquery-easyui-1.5.2/datagrid-detailview.js" type="text/javascript"></script>
<script src="/echart/echarts.min.js" ></script>
<#--<script src="/echart/macarons.js" type="text/javascript"></script>-->
<body>
<div id="sensor_grid_info">


</div>
<div title=""  id="echartDiv">
    <div id="barChart" style="width:1000px;height:580px;"></div>
</div>
<script>
    $(function () {
        getChartsInfo();
    });

    function getChartsInfo(){
        var chart = echarts.init(document.getElementById('barChart'));
        var option = {
            xAxis: {
                type: 'category',
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [820, 932, 901, 934, 1290, 1330, 1320],
                type: 'line',
                smooth: true
            }]
        }
        chart.setOption(option);
        chart.showLoading();
        chart.hideLoading();
    }
</script>
</body>
</html>