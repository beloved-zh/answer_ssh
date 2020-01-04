<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/style.css" rel='stylesheet' type='text/css' media="all">
    <style>
        #head{
            width: 100%;
            height: 10%;
        }
        #head_a{
            margin-top: 50px;
            text-align: center;
        }
        a{
            font-family: "微软雅黑", Arial, Helvetica, sans-serif;
            color:#666;
            font-size: 15px;
            text-decoration:none;
            margin-left: 50px;
        }
        #main{
            margin: 0 auto;
            width: 50%;
        }
        #number{
            width: 80%;
            text-align: center;
        }
        #sub_tab td,#sub_tab th{
            height: 40px;
        }
        #answer{
            width: 500px;
            margin: 0 auto;
        }
        #answer td{
            height: 30px;
        }
        #answer_tab input{
            /*display :inline-block;*/
            /*float: ri;*/
        }
        #result_tab{
            width: 500px;
            margin: 100px auto;
            display: none;
            text-align: center;
        }
        #result_tab textarea{
            text-align: center;
            height: 100%;
            width: 100%;
            disabled: disabled;
        }
    </style>
    <script type="text/javascript" src="../js/jquery-2.2.3.min.js" ></script>
    <script>
        /**
         * 初始化
         */

        //所选科目id
        var courseNO = [];
        var courseName = [];
        //所有题顺序的id
        var allTopic = [];
        //所有题答案
        var allAnswer = [];
        //自己选所有题按顺序的答案
        var MyAnswer = [];
        //正确的题
        var correctAnswer = [];
        //错误的题
        var errorAnswer = [];
        //开始时间
        var startTime;
        //结束时间
        var endTime;
        /**
         * 获取当前时间
         */
        function getDate(){
            var now = new Date();
            var year = now.getFullYear(); //得到年份
            var month = now.getMonth()+1;//得到月份
            var date = now.getDate();//得到日期
            // var day = now.getDay();//得到周几
            var hour= now.getHours();//得到小时数
            var minute= now.getMinutes();//得到分钟数
            var second= now.getSeconds();//得到秒数
            var d = year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
            return d;
        }

        $(function () {
            $.post(
                "tCourseEntityAction_findAll",
                function (data) {
                    $.each(data, function(i,c) {
                        if(i%5==0 || i==0){
                            $("#sub_tab").append("<tr></tr>");
                        }
                        $("#sub_tab tbody").append("<td><input type='checkbox' id='c"+i+"' name='courses' value='"+c.courseNo+"' /><label for='c"+i+"' id='c"+i+"courseName'>"+c.courseName+"</label></td>");
                    });
                },
                "json"
            );

        });

        function subject_sub(){
            //选择科目的数量
            var num = 0;
            //遍历多选框
            $("input:checkbox").each(function(){
                if ($(this).is(":checked")) {
                    num++;
                    courseNO.push($(this).val());
                    var id = $(this).attr("id")+"courseName";
                    courseName.push($("#"+id+"").html());
                }
            });
            if(num == 0){
                alert("至少选择一门科目");
                return false;
            }

            var number = $("#number").val();
            //隐藏
            $("#subject").hide();
            //设置序列化，提交数字
            jQuery.ajaxSettings.traditional = true;
            $.post(
                "questionAction_findByNumberAndCourseNO",
                {
                    "courseNO":courseNO,
                    "number":number
                },
                function (data) {
                    //获取开始时间
                    startTime = getDate();
                    //显示answer div
                    $("#answer").show();
                    $.each(data,function (i,q) {
                        //保存题id
                        allTopic.push(q.questionId);
                        //保存题答案
                        allAnswer.push(q.questionAnswer);
                        //得到答案的长度判断单选与多选
                        var b = q.questionAnswer.length;
                        if(b == 1){//单选
                            $("#answer_tab").append("<tr><td>"+(i+1)+":"+q.questionText+"</td></tr>");
                            $("#answer_tab").append("<tr><td><input type='radio' id='A"+q.questionId+"' name='r"+q.questionId+"' value='A' /><label for='A"+q.questionId+"'>A:"+q.answerA+"</label></td></tr>");
                            $("#answer_tab").append("<tr><td><input type='radio' id='B"+q.questionId+"' name='r"+q.questionId+"' value='B' /><label for='B"+q.questionId+"'>B:"+q.answerB+"</label></td></tr>");
                            $("#answer_tab").append("<tr><td><input type='radio' id='C"+q.questionId+"' name='r"+q.questionId+"' value='C' /><label for='C"+q.questionId+"'>C:"+q.answerC+"</label></td></tr>");
                            $("#answer_tab").append("<tr><td><input type='radio' id='D"+q.questionId+"' name='r"+q.questionId+"' value='D' /><label for='D"+q.questionId+"'>D:"+q.answerD+"</label></td></tr>");
                        }else {
                            $("#answer_tab").append("<tr><td>"+(i+1)+":"+q.questionText+"</td></tr>");
                            $("#answer_tab").append("<tr><td><input type='checkbox' id='A"+q.questionId+"' name='r"+q.questionId+"' value='A' /><label for='A"+q.questionId+"'>A:"+q.answerA+"</label></td></tr>");
                            $("#answer_tab").append("<tr><td><input type='checkbox' id='B"+q.questionId+"' name='r"+q.questionId+"' value='B' /><label for='B"+q.questionId+"'>B:"+q.answerB+"</label></td></tr>");
                            $("#answer_tab").append("<tr><td><input type='checkbox' id='C"+q.questionId+"' name='r"+q.questionId+"' value='C' /><label for='C"+q.questionId+"'>C:"+q.answerC+"</label></td></tr>");
                            $("#answer_tab").append("<tr><td><input type='checkbox' id='D"+q.questionId+"' name='r"+q.questionId+"' value='D' /><label for='D"+q.questionId+"'>D:"+q.answerD+"</label></td></tr>");
                        }
                        $("#answer_tab").append('<tr><td id="td'+q.questionId+'"></td></tr>');
                        $("#answer_tab").append('<tr><td><HR align=center width=100% color=#666 SIZE=2></td></tr>');
                    });
                    $("#answer_tab").append('<tr><td align="center"><button onclick="return answer_sub()" id="submit" type="button">提交</button></td></tr>');
                    $("#answer_tab").append('<tr><td></td></tr>');
                },
                "json"
            );

        }

        /**
         * 提交答案
         */
        function answer_sub() {
            for (var i in allTopic) {
                var arr = [];
                $('input[name=r'+allTopic[i]+']:checked').each(function(){
                    arr.push($(this).val());//
                });
                if (arr.length != 0) {
                    var a = arr.toString();
                    a = a.replace(",","");
                    a = a.replace(",","");
                    a = a.replace(",","");
                    MyAnswer.push(a);
                }
            }
            var n = allAnswer.length;
            var n1 = MyAnswer.length;
            if(n1 > n){
                alert("请勿重复提交");
                return false;
            }
            if (n != n1) {
                //初始化自选答案
                MyAnswer = [];
                alert("还没做完哦");
                return false;
            }

            /*
             * 判断答案是否错误
             */
            for(var i in allTopic){
                if(MyAnswer[i] != allAnswer[i]){
                    errorAnswer.push(allTopic[i]);
                }else{
                    correctAnswer.push(allTopic[i]);
                }
            }

            //结束时间
            endTime = getDate();
            /*
             *   Answer答案
             *   Topic 题目
             *   allTopic 所有题  allAnswer   allTopic  allAnswer
             * allAnswer  正确答案  allTopic  allAnswer   allTopic
             * MyAnswer  自选答案 MyAnswer  zxda MyAnswer
             */
            console.log("所选科目："+courseNO);
            console.log("答题数量："+(correctAnswer.length+errorAnswer.length));
            console.log("分数："+correctAnswer.length*2);
            console.log("正确的题："+correctAnswer);
            console.log("错误的题："+errorAnswer);
            console.log("开始时间："+startTime);
            console.log("结束时间："+endTime);
            console.log("题的顺序："+allTopic);
            console.log("正确答案："+allAnswer);
            console.log("自选答案："+MyAnswer);

            $.post(
                "statisticsAction_add",
                {
                    "allTopic":allTopic,
                    "correctAnswer":correctAnswer,
                    "errorAnswer":errorAnswer,
                    "fraction":correctAnswer.length*2,
                    "uid":$("#uid").val(),
                    "startTime":startTime,
                    "endTime":endTime,
                    "answerNumber":allTopic.length,
                    "Subject":courseName,
                    "MyAnswer":MyAnswer,
                    "allAnswer":allAnswer
                },
                function (data) {
                    //隐藏
                    $("#answer_tab").hide();
                    $("#result_tab").show();
                    $("#courseNO").val(courseName);
                    $("#allTopic").val(allTopic);
                    $("#answerNumber").val(allTopic.length);
                    $("#fraction").val(correctAnswer.length*2);
                    $("#errorAnswer").val(errorAnswer);
                    $("#startTime").val(startTime);
                    $("#endTime").val(endTime);
                },
                "json"
            );
        }

        function examine() {
            $("#result_tab").hide();
            $("#answer_tab").show();
            $("#submit").hide();
            $.each(allTopic,function (i,id) {
                if(allAnswer[i] == MyAnswer[i]){
                    $("#td"+id+"").append('<lable style="color: #00dbff;">正确答案：'+allAnswer[i]+'   你的答案'+MyAnswer[i]+'</lable>')
                }else{
                    $("#td"+id+"").append('<lable style="color: red;">正确答案：'+allAnswer[i]+'   你的答案'+MyAnswer[i]+'</lable>')
                }
            });
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
    <div id="subject">
        <table id="sub_tab" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <th colspan="5" align="left">请选择科目及数量</th>
            </tr>

            <tr>
                <td>
                    <select name="number" id="number">
                        <option value="10">10</option>
                        <option value="30">30</option>
                        <option value="50">50</option>
                    </select>
                </td>
                <td colspan="4">
                    <button onclick="return subject_sub()">开始答题</button>
                </td>
            </tr>
        </table>
    </div>
    <div id="answer">
        <table id="answer_tab" border="0" cellspacing="0" cellpadding="0">

        </table>
        <table id="result_tab" border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td>测试科目</td>
                <td><textarea id="courseNO" readonly="readonly"></textarea></td>
            </tr>
            <tr>
                <td>测试题号</td>
                <td><textarea id="allTopic" readonly="readonly"></textarea></td>
            </tr>
            <tr>
                <td>答题数量</td>
                <td><textarea id="answerNumber" readonly="readonly"></textarea></td>
            </tr>
            <tr>
                <td>成绩</td>
                <td><textarea id="fraction" readonly="readonly"></textarea></td>
            </tr>
            <tr>
                <td>错题序号</td>
                <td><textarea id="errorAnswer" readonly="readonly"></textarea></td>
            </tr>
            <tr>
                <td>开始时间</td>
                <td><textarea id="startTime" readonly="readonly"></textarea></td>
            </tr>
            <tr>
                <td>结束时间</td>
                <td><textarea id="endTime" readonly="readonly"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="button" onclick="examine()">查看详情</button>
                </td>
            </tr>
        </table>

    </div>
</div>
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
</body>
</html>
