<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Category | Pelin的个人博客</title>
    <link rel="icon" href="${imageDomain}/pblog_icon.ico"/>
    <link href="${cssDomain}/mobile/time_line.css" rel="stylesheet" />
    <link href="${cssPlugins}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsPlugins}/jquery.min.js" type="text/javascript"></script>
    <script src="${staticDomain}/resources/js/mobile/analytics.js" type="text/javascript"></script>
</head>


<body onload="timeLineInitial()">
<div id="Wrapper">
    <%@ include file="../include/index_mobile_header.jsp"%>


    <div id="Content">
        <div class="archive-header"><i class="fa fa-check-circle" aria-hidden="true"></i>分类统计：<span>${num}类</span></div>
        <div class="archive-title">文章分类</div>


        <div class="archive-timeline">
            <div class="timeline-left">
                <c:forEach var="categoryInfoVO" items="${categoryInfoVOList}" varStatus="status">
                    <div class="left-item">
                        <span>
                            <a href="${staticDomain}/category/${categoryInfoVO.slug}/list">${categoryInfoVO.categoryTitle}</a>
                            (${fn:length(categoryInfoVO.articleInfoVOList)})
                        </span>
                        <div class="time-point"></div>
                    </div>
                </c:forEach>
            </div>


            <div class="timeline-right">
                <c:forEach var="categoryInfVO" items="${categoryInfoVOList}" varStatus="status">
                    <div class="right-item">
                        <c:forEach var="articleVO" items="${categoryInfVO.articleInfoVOList}" varStatus="articleStatus">
                            <div class="article-item">
                                <span><fmt:formatDate value="${articleVO.createTime}" pattern="MM-dd"/></span>
                                <a href="${staticDomain}/article/${articleVO.articleSlug}/detail">${articleVO.title}</a>
                            </div>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>


            <div class="clear-fix"></div>
        </div>


    </div>


</div>
</body>
<script type="text/javascript" src="${staticDomain}/resources/js/mobile/global_mobile.js"></script>
</html>
