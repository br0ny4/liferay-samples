<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<div id="chart" style="width: 600px; height: 400px"></div>

<script src="<%=renderRequest.getContextPath()%>/js/echarts.js"></script>
<script src="<%=renderRequest.getContextPath()%>/theme/<%= chartTheme%>.js"></script>

<aui:script>
	Liferay.Service(
	    '<%= source %>',
    function(data) {
        var series = [];

        for (var i = 0; i < data[0].length - 1; i++){
            series.push({type: 'bar', barGap: <%= bargap %> + '%'});
    }
    console.log(data)
    console.log(series)

    var chart = echarts.init(document.getElementById("chart"), '<%= chartTheme%>');

    chart.setOption({
    title: {
    text: '<%= title %>'
    },
    legend: {},
    tooltip: {},
    dataset: {
    source: data
    },
    xAxis: {"type": 'category'},
    yAxis: {},
    series: series
    });
    }
    );
</aui:script>