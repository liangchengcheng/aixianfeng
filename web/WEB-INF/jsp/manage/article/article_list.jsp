<%@ include file="../include/namespace.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>文章管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/article_list.css" rel="stylesheet"  />
    <link rel="stylesheet" href="${staticDomain}/resources/assets/plugins/font-awesome.min.css" />
    <script src="${jsPlugins}/jquery.min.js"></script>
</head>
<body>
<c:set var="active_line" value="1" />
<c:set var="first_nav" value="文章管理" />
<c:set var="second_nav" value="文章列表" />
<c:set var="first_url" value="${staticDomain}/manage/article/list" />



<div id="wrapper">
    <%@ include file="../include/index_man_header.jsp"%>


    <div class="content">

        <div class="content-second-nav">
            <ol>
                <li><a href="${staticDomain}/manage/article/list"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>${first_nav}</a></li>
                <li class="active"><i class="fa fa-list" aria-hidden="true"></i>${second_nav}</li>
            </ol>
            <div style="clear: both;"></div>
        </div>


        <div class="content-find">
            <div class="find-by-type">
                类别:
                <select>
                <option>全部</option>
                <option>测试11111</option>
                <option>测试222222</option>
                <option>测试121</option>
            </select>
            </div>
            <div class="add-article">
                <a href="${staticDomain}/manage/article/add" class="click-btn">添加文章</a>
            </div>
            <div style="clear: both;"></div>
        </div>


        <div class="content-article-list">
            <table>
                <thead>
                <tr>
                    <th class="slug">编号</th>
                    <th class="title">标题</th>
                    <th class="thumbNum">点赞数</th>
                    <th class="status">状态</th>
                    <th class="operate">操作</th>
                </tr>
                </thead>
                <tbody>


                <c:forEach var="articleInfo" items="${articleInfoList}" varStatus="status">
                    <tr>
                        <td class="slug">${articleInfo.slug}</td>
                        <td class="title">${articleInfo.title}
                            <span>(<fmt:formatDate value="${articleInfo.createTime}" pattern="yyyy-MM-dd" /> )</span>
                        </td>
                        <td class="thumbNum">${articleInfo.thumb}</td>
                        <td class="status">
                            <c:choose>
                                <c:when test="${articleInfo.enabled}">是</c:when>
                                <c:otherwise>否</c:otherwise>
                            </c:choose>
                        </td>
                        <td class="operate">
                            <a href="${staticDomain}/manage/article/edit/${articleInfo.id}" class="click-btn">编辑</a>
                            <a href="${staticDomain}/#/article/${articleInfo.slug}" target="_blank" class="click-btn">查看</a>
                            <a href="javascript:void(0)" onclick="hideArticle(${articleInfo.id})" class="click-btn">
                                <c:choose>
                                    <c:when test="${articleInfo.enabled}">隐藏</c:when>
                                    <c:otherwise>显示</c:otherwise>
                                </c:choose>
                            </a>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>
        </div>
    </div>
</div>

<input class="enabled_url" type="hidden" value="${staticDomain}/manage/article/enabled" />
</body>

<script type="text/javascript">
    function hideArticle(articleInfoId){
        var url = $(".enabled_url").val();
        $.post(url, {'id': articleInfoId}, function(data){
            if(data.status == 1){
                alert("更新成功");
                location.reload();
            }
        }, "json");
    }
</script>
</html>