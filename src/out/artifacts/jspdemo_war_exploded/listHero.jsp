<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>


<br />
<table class="table table-bordered" align='center' style="width: 600px;margin-top: 200px;text-align: center;">
    <tr>
        <td colspan="4" style="text-align: right;">
            <a href="addHero.jsp" class="btn btn-default">新增</a>
        </td>
    </tr>
    <tr>
        <td>姓名</td>
        <td>生命值</td>
        <td>类型</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${heros}" var="hero" varStatus="st">
        <tr>
            <td>${hero.name}</td>
            <td>${hero.hp}</td>
            <td>${hero.damage}</td>
            <td><a class="btn btn-primary" href="editHero?id=${hero.id}">编辑</a>&nbsp;<a class="btn btn-warning"
                                                                                        href="deleteHero?id=${hero.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4" align="center">
            <span>当前是第 ${currPage} 页</span>
            <c:if test="${start!=1}">
                <a  href="?start=1">[首页]</a>&nbsp;
                <a href="?start=${pre}">[上一页]</a> &nbsp;
            </c:if>
            <c:if test="${start!=last}">
            <a href="?start=${next}">[下一页]</a>&nbsp;
            <a href="?start=${last}">[末页]</a>
            </c:if>
        </td>
    </tr>
</table>