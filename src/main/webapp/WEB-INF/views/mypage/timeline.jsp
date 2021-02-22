<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script>
        $(function(){
        var lnb = $("#iii").offset().top;
        $(window).scroll(function() {
  	        var window = $(this).scrollTop();

          if(lnb <= window) {
                $("#iii").addClass("fixed");
          } else {
            $("#iii").removeClass("fixed");
          }
    })
    });
    </script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>MyPage timeline | Triangle</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="/resources/css/animate.min.css" rel="stylesheet"> 
    <link href="/resources/css/lightbox.css" rel="stylesheet"> 
	<link href="/resources/css/main.css" rel="stylesheet">
	<link href="/resources/css/responsive.css" rel="stylesheet">

    <!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header">
        <div class="container"  style="position: fixed; background-color: #fff; width: 100%; z-index: 10; top:0;">
            <div class="row">
                <div class="col-sm-12 overflow" style=" padding-bottom: 10px;">
                    <a class="navbar-brand" href="index.html">

                        <h1><img src="/resources/images/logo.png" alt="logo" style="width: 75px; height:55px;"></h1>
                    </a>
                    <input type="text" class="search-form" autocomplete="off" placeholder="ê²ì">
                <div class="pull-right">
                        <ul class="nav nav-pills">
                            <li><a href="" style="border: 1px solid #dbb075; border-radius: 50px; margin-top:5px;">ë¡ê·¸ìì</a></li>
                            <li><a href=""><i class="fa fa-2x fa-user" aria-hidden="true"></i></a></li>
                            <li><a href=""><i class="fa fa-2x fa-comments-o"></i></a></li>
                            <li><a href=""><i class="fa fa-2x fa-envelope-o"></i></a></li>
                        </ul>
                    </div> 
                </div>
            </div>
        </div>     
    </header>
    <!--/#header-->


    <!--/#action-->
<div class = "nav2">
    <ul class="portfolio-filter text-center">
        <li><a class="btn btn-default active" href="#" data-filter=".timeline">íìë¼ì¸</a></li>
        <li><a class="btn btn-default" href="#" data-filter=".gallery">ê°¤ë¬ë¦¬</a></li>
        <li><a class="btn btn-default" href="#" data-filter=".diary">ë¤ì´ì´ë¦¬</a></li>
        <li><a class="btn btn-default" href="#" data-filter=".TodoList">TodoList</a></li>
        <li><a class="btn btn-default" href="#" data-filter=".friend">ì¹êµ¬</a></li>
        <li><a class="btn btn-default" href="#" data-filter=".information">ì ë³´</a></li>
    </ul>
</div>    
    <!--/#portfolio-filter-->
    <section id="blog" class="padding-top">
        <div class="container">
            <div class="row">
                <div class="col-md-9 col-sm-7">
                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                           <div class="single-blog two-column">
                               <div class="post-thumb">
                                   <a href="blogdetails.html"><img src="images/blog/7.jpg" class="img-responsive" alt=""></a>
                                   <div class="post-overlay">
                                       <span class="uppercase"><a href="#">14 <br><small>Feb</small></a></span>
                                   </div>
                               </div>
                               <div class="post-content clearfix">
                                   <h2 class="post-title bold"><a href="blogdetails.html">Advanced business cards design</a></h2>
                                   <h3 class="post-author"><a href="#">Posted by micron News</a></h3>
                                   <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]</p>
                                   <a href="#" class="read-more">View More</a>
                                   <div class="post-bottom clearfix">
                                       <ul class="nav navbar-nav post-nav">
                                           <li><a href="#"><i class="fa fa-heart"></i>ì¢ìì 31</a></li>
                                           <li><a href="#"><i class="fa fa-comments"></i>ëê¸ 100ê°</a></li>
                                       </ul>
                                   </div>
                               </div>
                           </div>
                       </div>
                       <div class="col-md-12 col-sm-12">
                           <div class="single-blog two-column">
                               <div class="post-thumb">
                                   <a href="blogdetails.html"><img src="/resources/images/blog/8.jpg" class="img-responsive" alt=""></a>
                                   <div class="post-overlay">
                                       <span class="uppercase"><a href="#">14 <br><small>Feb</small></a></span>
                                   </div>
                               </div>
                               <div class="post-content clearfix">
                                   <h2 class="post-title bold"><a href="blogdetails.html">Advanced business cards design</a></h2>
                                   <h3 class="post-author"><a href="#">Posted by micron News</a></h3>
                                   <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]</p>
                                   <a href="#" class="read-more">View More</a>
                                   <div class="post-bottom clearfix">
                                       <ul class="nav navbar-nav post-nav">
                                           <li><a href="#"><i class="fa fa-heart"></i>ì¢ìì 32</a></li>
                                           <li><a href="#"><i class="fa fa-comments"></i>ëê¸ 3ê°</a></li>
                                       </ul>
                                   </div>
                               </div>
                           </div>
                       </div>
                       <div class="col-md-12 col-sm-12">
                           <div class="single-blog two-column">
                               <div class="post-thumb">
                                   <a href="blogdetails.html"><img src="/resources/images/blog/9.jpg" class="img-responsive" alt=""></a>
                                   <div class="post-overlay">
                                       <span class="uppercase"><a href="#">14 <br><small>Feb</small></a></span>
                                   </div>
                               </div>
                               <div class="post-content clearfix">
                                   <h2 class="post-title bold"><a href="blogdetails.html">Advanced business cards design</a></h2>
                                   <h3 class="post-author"><a href="#">Posted by micron News</a></h3>
                                   <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]</p>
                                   <a href="#" class="read-more">View More</a>
                                   <div class="post-bottom clearfix">
                                       <ul class="nav navbar-nav post-nav">
                                           <li><a href="#"><i class="fa fa-heart"></i>ì¢ìì 32</a></li>
                                           <li><a href="#"><i class="fa fa-comments"></i>ëê¸ 3ê°</a></li>
                                       </ul>
                                   </div>
                               </div>
                           </div>
                       </div>
                   </div>
                 </div>
                <div class="col-md-3 col-sm-5">
                    <div class="sidebar blog-sidebar">
                        <div class="sidebar-item recent hidden-sm hidden-xs">
                            <h3>Profile</h3>
                            <div class="media">
                                    <div class="col-sm-12 text-center">
                                        <img src="/resources/images/home/icon2.png" style="margin-bottom : 10px" alt="">
                                        <h3>íê¸¸ë<br>asdf1234@gmail.com</h3>
                                        <p>Ground round tenderloin flank shank ribeye. Hamkevin meatball swine. Cow shankle beef sirloin chicken ground round.</p>
                                    </div>
                            </div>
                        </div>
                        <div class="sidebar-item categories  hidden-sm hidden-xs">
                            <h5>&copy;2021, Comma Inc All Rights Reserved.</h5>
                            <p>Designed by <a target="_blank" href="http://www.themeum.com">Themeum</a></p>
                            <ul class="nav navbar-stacked">
                                <li><a href="#">ê°ì¸ì ë³´ì²ë¦¬ë°©ì¹¨</a></li>
                                <li class=""><a href="#">About</a></li>
<!--                                <li><a href="#">Folio<span class="pull-right">(4)</span></a></li>-->
                            </ul>
                        </div>
                        <div class="sidebar-item popular hidden-sm hidden-xs">
                            <h3>Fridends</h3>
                            <ul class="gallery">
                                <li><a href="#"><img src="/resources/images/portfolio/popular1.jpg" alt=""></a>friend1</li>
                                <li><a href="#"><img src="/resources/images/portfolio/popular2.jpg" alt=""></a>friend2</li>
                                <li><a href="#"><img src="/resources/images/portfolio/popular3.jpg" alt=""></a>friend3</li>
                            </ul>
                            <ul class = "gallery">
                                <li><a href="#"><img src="/resources/images/portfolio/popular4.jpg" alt=""></a>friend4</li>
                                <li><a href="#"><img src="/resources/images/portfolio/popular5.jpg" alt=""></a>friend5</li>
                                <li><a href="#"><img src="/resources/images/portfolio/popular1.jpg" alt=""></a>friend6</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--/#blog-->

    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center bottom-separator">
                </div>
                <div class="col-sm-12 hidden-sm hidden-xs">
                    <div class="copyright-text text-center">
                        
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--/#footer-->

    <script type="text/javascript" src="/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="/resources/js/wow.min.js"></script>
    <script type="text/javascript" src="/resources/js/main.js"></script>     
</body>
</html>
