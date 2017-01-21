<%@ include file="../include/namespace.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">


<head>
    <title>文章管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${cssDomain}/manage/article_add.css" rel="stylesheet"/>
    <link href="${cssPlugins}/font-awesome.min.css" rel="stylesheet"/>
    <script src="${jsPlugins}/jquery.min.js"></script>
    <script src="${jsPlugins}/marked.js"></script>
</head>

<body>
<c:set var="active_line" value="1"/>
<c:set var="first_nav" value="文章管理" />
<c:set var="first_url" value="${staticDomain}/manage/article/list" />


<c:choose>
    <c:when test="${type == 1}">
        <c:set var="second_nav" value="文章添加" />
        <c:set var="url" value="${staticDomain}/manage/article/add" />
        <c:set var="submit_btn" value="发布文章" />
    </c:when>
    <c:when test="${type == 2}">
        <c:set var="second_nav" value="文章更新" />
        <c:set var="url" value="${staticDomain}/manage/article/update" />
        <c:set var="submit_btn" value="更新文章" />
    </c:when>
</c:choose>


<div id="wrapper">

    <%@ include file="../include/index_man_header.jsp" %>

    <div class="content">

        <%@ include file="../include/index_second_header.jsp" %>

        <form action="${url}" method="post" id="article-add-form">
            <input type="hidden" name="id" value="${articleInfo.id}" />
            <div class="article">
                <div class="article-title">
                    <div class="article-title-theme">文章标题</div>
                    <div class="article-title-content">
                        <textarea rows="1" maxlength="120" name="title" autofocus="autofocus" placeholder="请输入文章标题，标题字数在120字以内">${articleInfo.title}</textarea>
                    </div>
                </div>
                <div class="article-body">
                    <div class="article-body-theme">文章正文</div>
                    <textarea class="editor" name="content" title="文章正文">${articleInfo.content}</textarea>
                </div>
                <div class="article-operate">
                    <i class="icon-eye-open" id="pre"></i>
                    <button type="button" class="preview-article">预览文章</button>
                    <div style="clear: both;"></div>
                </div>
                <div class="view"></div>
                <div class="description">
                    <div class="description-title">添加描述</div>
                    <textarea class="editor" title="文章描述" name="descriptionMd">${articleInfo.descriptionMd}</textarea>
                </div>
                <div class="description-operate">
                    <i class="icon-eye-open"></i>
                    <button type="button" class="preview-description">预览描述</button>
                    <textarea name="description" style="display: none;" title="描述隐藏域"></textarea>
                </div>
                <div class="description-view"></div>
            </div>
            <div class="operate">
                <div class="publish">
                    <button type="button" class="publish-article"><i class="icon-fighter-jet"></i>${submit_btn}</button>
                </div>
                <div class="article-category">
                    <div class="title">文章分类</div>
                    <c:forEach  var="category" items="${categoryList}" varStatus="status">
                        <span><input type="radio" name="categorySlug" value="${category.categorySlug}" <c:if test="${category.categorySlug eq articleInfo.categorySlug}">checked="checked"</c:if> />${category.title}</span>
                    </c:forEach>
                </div>
                <div class="tag">
                    <div class="title">文章标签</div>
                    <input type="text" name="tag" value="${articleInfo.tag}" />
                </div>
            </div>
        </form>
    </div>


    <!-- 提示 -->
    <div class="mask" id="mask-tip">
        <div class="modal-dialog">
            <div class="modal-title">提示</div>
            <div class="modal-body"></div>
            <div class="modal-operate">
                <span class="close" onclick="closeMask()">关闭</span>
                <div class="clear-fix"></div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript">
    var $title = $("textarea[name='title']");
    var $content = $("textarea[name='content']");
    var $descriptionMd = $("textarea[name='descriptionMd']");
    var $tag = $("input[name='tag']");
    var $maskTip = $("#mask-tip");

    $(".publish-article").click(function () {
        var htmlValue = markedToHTML($(".editor:eq(1)"),$(".description-view"));

        $("textarea[name='description']").html(htmlValue);
        var title = $title.val();
        var content = $content.val();
        var descriptionMd = $descriptionMd.val();
        var tag = $tag.val();

        if((null == title) || ("" == $.trim(title))) {
            tipMask("文章标题不能为空");
            return false;
        }

        if((null == content) || ("" == $.trim(content))) {
            tipMask("文章内容不能为空");
            return false;
        }

        if((null == descriptionMd) || ("" == $.trim(descriptionMd))) {
            tipMask("文章描述不能为空");
            return false;
        }

        if((null == tag) || ("" == $.trim(tag))) {
            tipMask("文章标签不能为空，标签格式以英文字符逗号隔开");
            return false;
        }

        $("#article-add-form").submit();
    });

    //预览文章内容
    $(".preview-article").click(function () {
        markedToHTML($(".editor:eq(0)"), $(".view"))
    });

    //预览描述
    $(".preview-description").click(function () {
        var htmlValue = markedToHTML($(".editor:eq(1)"), $(".description-view"));
        $("textarea[name='description']").html(htmlValue);
    });

    //关闭遮罩层
    function closeMask(str) {
        $(".mask").css("display", "none");
        if(str == "reload") {
            location.reload();
        }
    }

    function tipMask(modalBody) {
        $maskTip.find(".modal-body").html(modalBody);
        $maskTip.css("display", "block");
    }

    function markedToHTML($input, $preview) {
        var htmlValue = marked($input.val());
        $preview.html(htmlValue);
        return htmlValue;
    }
</script>