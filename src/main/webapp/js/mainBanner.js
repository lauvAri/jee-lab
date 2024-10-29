
$(function(){
    //定义i变量为动态控制图片轮播做准备，i的值与每张图片进行一一的对应
    var i=0;
    //时间变量，为自动轮播以及对光标的影响做出相应的反应
    var timer=null;
    //根据图片的张数动态添加圆点个数
    for (var j = 0; j < $('.MainBannerImage li').length; j++) {
        $('.num').append('<li></li>');
    }
    //默认情况下的第一个圆点进行背景设计
    $('.MainBannerNum li').first().addClass('active');
    //根据光标的影响控制按钮的显示和隐藏
    $('.MainBanner').hover(function(){
        $('.btn').show();
    },function(){
        $('.btn').hide();
    });
    //将第一张图片复制并添加到img部分下与前五张图片相接
    var firstimg=$('.MainBannerImage li').first().clone(); //复制第一张图片
    $('.img').append(firstimg).width($('.img li').length*($('.MainBannerImage img').width()));
    //定时器自动轮播
    timer=setInterval(function(){
        i++;
        if (i==$('.MainBannerImage li').length) {
            i=1;
            $('.img').css({left:0});//保证无缝轮播，设置left值
        }
        //进行下一张图片
        $('.MainBannerImage').stop().animate({left:-i*512},500);
        //圆点跟着变化
        if (i==$('.MainBannerImage li').length-1) {
            $('.MainBannerNum li').eq(0).addClass('active').siblings().removeClass('active');
        }else{
            $('.MainBannerNum li').eq(i).addClass('active').siblings().removeClass('active');
        }
    },1000);
    //鼠标移入，暂停自动播放，移出，开始自动播放
    $('.banner').hover(function(){
        clearInterval(timer);
    },function(){
        timer=setInterval(function(){
            i++;
            if (i==$('.MainBannerImage li').length) {
                i=1;
                $('.MainBannerImage').css({left:0});
            };
            //进行下一张图片
            $('.MainBannerImage').stop().animate({left:-i*512},500);
            //圆点跟着变化
            if (i==$('.MainBannerImage li').length-1) {
                $('.num li').eq(0).addClass('active').siblings().removeClass('active');
            }else{
                $('.num li').eq(i).addClass('active').siblings().removeClass('active');
            }
        },1000)
    });
    //上一个按钮
    $('.prev').click(function(){
        i--;
        if (i==-1) {
            i=$('.MainBannerImage li').length-2;
            $('.MainBannerImage').css({left:-($('.img li').length-1)*512});
        }
        $('.MainBannerImage').stop().animate({left:-i*512},500);
        $('.MainBannerNum li').eq(i).addClass('active').siblings().removeClass('active');
    });
    // 下一个按钮
    $('.MainBannerNext').click(function(){
        i++;
        if (i==$('.MainBannerImage li').length) {
            i=1; //这里不是i=0
            $('.img').css({left:0});
        };
        $('.MainBannerImage').stop().animate({left:-i*512},500);
        if (i==$('.MainBannerImage li').length-1) { //设置小圆点指示
            $('.MainBannerNum li').eq(0).addClass('active').siblings().removeClass('active');
        }else{
            $('.MainBannerNum li').eq(i).addClass('active').siblings().removeClass('active');
        };

    });
    //鼠标划入圆点
    $('.MainBannerNum li').mouseover(function(){
        var _index=$(this).index();
        //维持i变量控制的对应关系不变
        i = _index;
        $('.MainBannerImage').stop().animate({left:-_index*512},300);
        $('.MainBannerNum li').eq(_index).addClass('active').siblings().removeClass('active');
    });

})