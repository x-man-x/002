  
  var url = "http://gossiproom.wechat121.com/";
  var articleId = "";
  var shareTitle="GossipRoom 大抽奖";
  var shareImgUrl="http://p0.meituan.net/merchantpic/e3680726a81ffee5bdf0ec7a4a90147488223.jpg%40240w_180h_1e_1c_1l%7Cwatermark%3D1%26%26r%3D1%26p%3D9%26x%3D2%26y%3D2%26relative%3D1%26o%3D20";
  var userinfo = localStorage.getItem("_userinfo");
  var timestamp;
  var noncestr;
  var signature;
  //获取签名
  $.ajax({
   type: "GET",
   url: "Share",
   //data:{timestamp:timestamp,noncestr:noncestr,url:url},
   data:{url:url},
   success: function(data){
    console.log(data);
    timestamp=data.timestamp; 
    noncestr=data.noncestr; 
    signature=data.signature;
    wxShare();
   }
   });
  function wxShare(){
  wx.config({
  debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
  appId: 'wxa8476ad109c11e44', // 和获取Ticke的必须一样------必填，公众号的唯一标识
  timestamp:timestamp, // 必填，生成签名的时间戳
  nonceStr: noncestr, // 必填，生成签名的随机串
  signature: signature,// 必填，签名，见附录1
  jsApiList: [
  'onMenuShareAppMessage'
  ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
  });
  }
  wx.ready(function(){
   //config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，
   //config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关
   //接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
 
  //----------“分享给朋友”
  wx.onMenuShareAppMessage({
   title: "GossipRoom 大抽奖", // 分享标题
   desc: shareTitle, // 分享描述
   link: url, // 分享链接
   imgUrl: shareImgUrl, // 分享图标
   type: '', // 分享类型,music、video或link，不填默认为link
   dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
   success: function () { 
   // 用户确认分享后执行的回调函数、
   },
   cancel: function () { 
   // 用户取消分享后执行的回调函数
   }
  });
  //------------"分享到朋友圈"
  wx.onMenuShareTimeline({
   title: 'GossipRoom 大抽奖', // 分享标题
   link: '', // 分享链接
   imgUrl: shareImgUrl, // 分享图标
   success: function () { 
   // 用户确认分享后执行的回调函数
   },
   cancel: function () { 
   // 用户取消分享后执行的回调函数
   }
  });
  //-------------分享到QQ
  wx.onMenuShareQQ({
   title: 'GossipRoom 大抽奖', // 分享标题
   desc: shareTitle, // 分享描述
   link: '', // 分享链接
   imgUrl: shareImgUrl, // 分享图标
   success: function () { 
   // 用户确认分享后执行的回调函数
   },
   cancel: function () { 
   // 用户取消分享后执行的回调函数
   }
  });
  //-------------分享到QQ空间
  wx.onMenuShareQZone({
   title: 'GossipRoom 大抽奖', // 分享标题
   desc: shareTitle, // 分享描述
   link: '', // 分享链接
   imgUrl: shareImgUrl, // 分享图标
   success: function () { 
   // 用户确认分享后执行的回调函数
   },
   cancel: function () { 
   // 用户取消分享后执行的回调函数
   }
  });
 
  });