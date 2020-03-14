<#macro layout>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title} - Demo</title>
    <#include "/ftl/head.ftl"/>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div>
    <#nested />
</div>

</body>
<script type="text/javascript" language="javascript">
    function dateFmatter(cellvalue, options, rowObject) {
        if (cellvalue == '' || cellvalue == null) {
            return "";
        }
        var date = new Date(cellvalue);
        var mm = date.getMonth();
        var datetime = date.getFullYear() + "-"// "年"
                + ((date.getMonth() + 1) >= 10 ? (date.getMonth() + 1) : ("0" + (date.getMonth() + 1))) + "-"// "月"
                + (date.getDate() < 10 ? "0" + date.getDate() : date
                        .getDate()) + " "
                + (date.getHours() < 10 ? "0" + date.getHours() : date
                        .getHours()) + ":"
                + (date.getMinutes() < 10 ? "0" + date.getMinutes() : date
                        .getMinutes()) + ":"
                + (date.getSeconds() < 10 ? "0" + date.getSeconds() : date
                        .getSeconds());
        return datetime;
    }
</script>
</html>
</#macro>