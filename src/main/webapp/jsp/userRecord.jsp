<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>记录查询</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/style.css" rel='stylesheet' type='text/css' media="all">
    <script type="text/javascript" src="../js/jquery-2.2.3.min.js" ></script>
    <script src="../js/move-top.js"></script>
    <script src="../js/easing.js"></script>
    <script>
        $(document).ready(function() {

            var defaults = {
                containerID: 'toTop', // fading element id
                containerHoverID: 'toTopHover', // fading element hover id
                scrollSpeed: 1200,
                easingType: 'linear'
            };

            $().UItoTop({
                easingType: 'easeOutQuart'
            });

        });
    </script>
    <style>
        #head{
            width: 100%;
            height: 10%;
        }
        #head_a{
            margin-top: 50px;
            text-align: center;
        }
        #head a{
            font-family: "微软雅黑", Arial, Helvetica, sans-serif;
            color:#666;
            font-size: 15px;
            text-decoration:none;
            margin-left: 50px;
        }
        #main{
            width: 80%;
            margin: 0 auto;
        }

        #main td{
            height: 30px;
        }

        #record_tab{
            width: 100%;
            text-align: center;
            table-layout:fixed;
        }
        #record_tab a{
            font-family: "微软雅黑", Arial, Helvetica, sans-serif;
            color:#666;
            font-size: 15px;
            text-decoration:none;
        }
        textarea{
            text-align: center;
            height: 100%;
            width: 100%;
            disabled: disabled;
        }
    </style>
    <script>
        function findRecord(id) {
            $("#record_tab").hide();
            var allTopic = $("#allTopic"+id+"").val();
            var errorAnswer = $("#errorAnswer"+id+"").val();
            errorAnswer = errorAnswer.split(", ");
            $.post(
                "questionAction_findByIds",
                {
                    "ids":allTopic
                },
                function (data) {
                    $.each(data,function (i,q) {
                        $("#answer_tab").append("<tr><td>"+(i+1)+":"+q.questionText+"</td></tr>");
                        $("#answer_tab").append("<tr><td><label>A:"+q.answerA+"</label></td></tr>");
                        $("#answer_tab").append("<tr><td><label>B:"+q.answerB+"</label></td></tr>");
                        $("#answer_tab").append("<tr><td><label>C:"+q.answerC+"</label></td></tr>");
                        $("#answer_tab").append("<tr><td><label>D:"+q.answerD+"</label></td></tr>");
                        var questionId = ""+q.questionId;
                        var n = $.inArray(questionId,errorAnswer);
                        if (n == -1) {
                            $("#answer_tab").append('<tr><td><lable style="color: #00dbff;">正确</lable>&emsp;&emsp;&emsp;&emsp;<label style="color: #00dbff;">正确答案：'+q.questionAnswer+'</lable></td></tr>');
                        }else {
                            $("#answer_tab").append('<tr><td><lable style="color: red;">错误</lable>&emsp;&emsp;&emsp;&emsp;<label style="color: #00dbff;">正确答案：'+q.questionAnswer+'</lable></td></tr>');
                        }
                        $("#answer_tab").append('<tr><td><HR align=center width=100% color=#666 SIZE=2></td></tr>');
                    });
                },
                "json"
            );
        }
    </script>
</head>
<body>
<div id="head">
    <div id="head_a">
        <a href="main.jsp">首页</a>
        <a href="statisticsAction_findByUid">个人记录</a>
        <a href="statisticsAction_findAll">全部记录</a>
        <a href="#" onclick="alert('后期开发')">反馈</a>
        <input type="hidden" id="uid" value="${user.userId}">
    </div>
</div>
<div id="main">
    <table id="record_tab" border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>账号</td>
            <td>科目</td>
            <td>题号</td>
            <td>错题</td>
            <td>数量</td>
            <td>分数</td>
            <td>开始时间</td>
            <td>结束时间</td>
            <td>查看详情</td>
        </tr>
        <s:iterator value="list" var="s">
            <tr>
                <td>
                    <textarea readonly="readonly">${s.uid}</textarea>
                </td>
                <td>
                    <textarea readonly="readonly">${s.subject}</textarea>
                </td>
                <td>
                    <textarea id="allTopic${s.tid}" readonly="readonly">${s.allTopic}</textarea>
                </td>
                <td>
                    <textarea id="errorAnswer${s.tid}" readonly="readonly">${s.errorAnswer}</textarea>
                </td>
                <td>
                    <textarea readonly="readonly">${s.answerNumber}</textarea>
                </td>
                <td>
                    <textarea readonly="readonly">${s.fraction}</textarea>
                </td>
                <td>
                    <textarea readonly="readonly">${s.startTime}</textarea>
                </td>
                <td>
                    <textarea readonly="readonly">${s.endTime}</textarea>
                </td>
                <td>
                    <a href="#" onclick="findRecord(${s.tid})">查看详情</a>
                </td>
            </tr>
        </s:iterator>
    </table>
    <table id="answer_tab" border="0" cellspacing="0" cellpadding="0">

    </table>
</div>
</body>
</html>
