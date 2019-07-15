<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>jq滑动拼图验证插件，支持移动、PC</title>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/jq_slideImage.js" type="text/javascript" charset="utf-8"></script>
    <style>
        .demo1{
            width: 100%;
            height: 300px;
        }
        .demo2{
            width: 300px;
            height: 200px;
        }
    </style>
</head>
<body>
<div class="demo1" id="slideImageWrap">

</div>
<button id="reset-one">
    重置test1
</button>

<div style="width: 500px;margin: 0 auto;height: 300px;">
    <div class="demo2" id="slideImageWrap2">

    </div>
</div>
<button id="reset-two">
    重置test2
</button>
<script>
    var mySlideImage = new SlideImageVerify('#slideImageWrap',{
        slideImage:['image/a1.png','image/a2.png','image/a3.png'],
        slideAreaNum:1,
        refreshSlide:true,
        getSuccessState:function (res) {
            console.log(res);
        }
    })
    $("#reset-one").on('click',function () {
        mySlideImage.resetSlide();
    })
    window.onresize = function (ev) {
        mySlideImage.resizeSlide();
    }


    var mySlideImage2 = new SlideImageVerify('#slideImageWrap2',{
        initText:'请滑动拼图完成验证',
        slideImage:'image/a2.png',
        slideAreaNum:20,
        refreshSlide:false,
        getSuccessState:function (res) {
            console.log(res);
        }
    })

    $("#reset-two").on('click',function () {
        mySlideImage2.resetSlide();
    })

</script>
</body>
</html>

