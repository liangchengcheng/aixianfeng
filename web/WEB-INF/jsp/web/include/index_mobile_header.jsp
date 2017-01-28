<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="Top">
    <span class="top-list" onclick="slide()"><i class="fa fa-align-justify" aria-hidden="true"></i></span>
    <span>Pelin's Blog</span>
    <span class="top-github">
        <a href="https://github.com/penglongli"><i class="fa fa-github" aria-hidden="true"></i></a>
    </span>
    <div class="clear-fix"></div>
</div>
<nav id="SlideBar">
    <div class="author_info">
        <img src="${imageDomain}/author_header.png"/>
        <p>Pelin</p>
    </div>
    <div class="menu_bar">
        <ul>
            <li><a href="${staticDomain}/"><i class="fa fa-home" aria-hidden="true"></i> 主页</a></li>
            <li><a href="${staticDomain}/archives"><i class="fa fa-calendar" aria-hidden="true"></i> 文章</a></li>
            <li><a href="${staticDomain}/category"><i class="fa fa-align-justify" aria-hidden="true"></i> 分类</a></li>
            <li><a href="${staticDomain}/read"><i class="fa fa-book" aria-hidden="true"></i> 书籍</a></li>
            <li><a href="${staticDomain}/record/detail"><i class="fa fa-camera" aria-hidden="true"></i> 记录</a></li>
            <li><a href="${staticDomain}/about"><i class="fa fa-info-circle" aria-hidden="true"></i> 关于</a></li>
        </ul>
        <ul>
            <li><a href="http://blog.csdn.net/u010800530" style="color: #FFF;"><span class="csdn"></span> BLOG</a></li>
            <li><a href="https://www.zhihu.com/people/pelin.li" style="color: #FFF;"><span class="zhihu"></span> 知乎</a></li>
        </ul>
    </div>
</nav>