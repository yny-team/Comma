<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title> Triangle</title>
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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/resources/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/resources/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/resources/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/resources/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
    <style>
        @import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";


body {
    font-family: 'Poppins', sans-serif;
    background: #fafafa;
}

p {
    font-family: 'Poppins', sans-serif;
    font-size: 1.1em;
    font-weight: 300;
    line-height: 1.7em;
    color: #999;
}

a, a:hover, a:focus {
    color: inherit;
    text-decoration: none;
    transition: all 0.3s;
}

#sidebar {
    /* don't forget to add all the previously mentioned styles here too */
    background: #e6b754;
    color: #fff;
    transition: all 0.3s;
    margin: 20px;
}

#sidebar .sidebar-header {
    padding: 20px;
    background: #c4ba39;
}

#sidebar ul.components {
    padding: 20px 0;
    border-bottom: 1px solid #a5a73d;
}

#sidebar ul p {
    color: #fff;
    padding: 10px;
}

#sidebar ul li a {
    padding: 10px;
    font-size: 1.1em;
    display: block;
}
#sidebar ul li a:hover {
    color: #d1cf3f;
    background: #fff;
}
#content{
    margin : 20px;
}
#sidebar ul li.active > a, a[aria-expanded="true"] {
    color: #fff;
    background: #e2ad4a;
}
ul ul a {
    font-size: 0.9em !important;
    padding-left: 30px !important;
    background: #d6b445;
}
        .wrapper {
    display: flex;
    width: 100%;
    align-items: stretch;
}
.wrapper {
    display: flex;
    align-items: stretch;
}
#sidebar {
    min-width: 250px;
    max-width: 250px;
    min-height: 100vh;
}
#sidebar {
    min-width: 250px;
    max-width: 250px;
}

#sidebar.active {
    margin-left: -250px;
}
a[data-toggle="collapse"] {
    position: relative;
}

.dropdown-toggle::after {
    display: block;
    position: absolute;
    top: 50%;
    right: 20px;
    transform: translateY(-50%);
}
    </style>
	<!-- <header id="header">      
        <div class="container">
            <div class="row">
                <div class="col-sm-12 overflow">
                   
                </div>
             </div>
        </div>
        <div class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">
                    	<h1><img src="images/logo.png" alt="logo"></h1>
                    </a>
                </div>
            </div>
        </div>
    </header> -->
    <!--page border scrum-->
    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            <h1><img src="images/logo.png" alt="logo"></h1>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            <h1 class="title">관리자 페이지</h1>
                        </div>
                        <ul class="nav navbar-nav navbar-right">
                            <button type="button" class="btn btn-warning">로그 아웃</button>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--상단 내비게이션바-->
    <!-- <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
            <a class="navbar-brand" href="#">관리자 메뉴</a>
            </div>
        </div>
    </nav> -->
    <div class="wrapper">
        <!-- Sidebar -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3> 관리자 페이지 메뉴</h3>
            </div>
            <ul class="list-unstyled components">
                <li>
                    <a href="#">회원관리</a>
                </li>
                <li>
                    <a href="#">게시물관리</a>
                </li>
                <li>
                    <a href="#">댓글 관리</a>
                </li>
                <li>
                    <a href="#">신고 관리</a>
                </li>
            </ul>
           </nav>

           <div id="content">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <h1>회원관리</h1>
                    <br>
                </div>
            </nav>
            <table class="table">
                
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">글장성자 ID</th>
                    <th scope="col">글작성자 이름</th>
                    <th scope="col">글 내용</th>
                    <th scope="col">글 작성시간</th>
                    <th scope="col">글 조회수</th>
                    <th scope="col">글 좋아요 수</th>
                    <th scope="col">글 상세보기</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td></td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <th scope="row">3</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>

                  </tr> <tr>
                    <th scope="row">3</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>

                  </tr>
                  
                </tbody>
              </table>
              <div class="blog-pagination">
                  <ul class="pagination">
                    <li><a href="#">left</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li class="active"><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">7</a></li>
                    <li><a href="#">8</a></li>
                    <li><a href="#">9</a></li>
                    <li><a href="#">right</a></li>
                  </ul>
              </div>
            </div>
            




    <!--/#footer-->
    <!-- <footer id="footer">
        <div class="container">
            <div class="col-sm-12">
                <div class="copyright-text text-center">
                    <p>&copy; Your Company 2014. All Rights Reserved.</p>
                    <p>Designed by <a target="_blank" href="http://www.themeum.com">Themeum</a></p>
                </div>
            </div>
        </div>
    </footer> -->

    <script type="text/javascript" src="/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="/resources/js/wow.min.js"></script>
    <script type="text/javascript" src="/resources/js/main.js"></script>   
</body>
</html>
