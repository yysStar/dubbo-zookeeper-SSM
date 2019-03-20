<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <title>连连支付</title>
    <link href="//css-cdn.lianlianpay.com/h5/css/style.css" type="text/css"
          rel="stylesheet">
</head>

<body>
<div class="header" style="background: #ff5001">
    <a href="javascript:history.go(-1);" class="back">返回</a>
    <h1 class="logo" style="color:#fff">
        连连支付
    </h1>
    <a href="about.html" class="about">关于</a>
</div>
<div
        class="result
			fail">
    <h3>
        <i class="iconfont"></i><span> 支付失败</span>
    </h3>
    <p id="errorMsg">
        请求报文解析失败[1012]
    </p>
</div>
<div class="warp">
    <a id="back_href" href="javascript:history.go(-1);" class="btn color"
       style="background:#ff5001;color:#fff">返回商户</a>
    <a href="tel:4000188888"
       class="btn" style="margin-top: 15px; color:#fff;background:#ff5001">客服热线：400-018-8888</a>
</div>
</body>
</html>
