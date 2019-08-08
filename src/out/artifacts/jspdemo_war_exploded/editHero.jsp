<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<div style="margin:50px auto; width:300px">
    <form class="form-horizontal" action="updateHero" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-4 control-label">姓名</label>
            <div class="col-sm-8">
                <input type="text" id="name" value="${hero.name}" class="form-control" name="name" placeholder="请输入名称">
            </div>
        </div>
        <div class="form-group">
            <label for="hp" class="col-sm-4 control-label">HP</label>
            <div class="col-sm-8">
                <input type="text" value="${hero.hp}" class="form-control" id="hp" name="hp" placeholder="请输入HP">
                <input type="hidden" name = "id" value="${hero.id}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">确定</button>
            </div>
        </div>
    </form>
</div>