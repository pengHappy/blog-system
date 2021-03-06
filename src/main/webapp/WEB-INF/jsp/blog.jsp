<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>


<c:url value="/css/bootstrap.css" var="bootstrapCSS" />
<c:url value="/css/style.css" var="styleCSS" />

<c:url value="/js/jquery-1.11.1.min.js" var="jquery11" />


<title>Blog</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Great Taste Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="${bootstrapCSS }" rel="stylesheet" />
<link href="${styleCSS }" rel="stylesheet" />
<!-- js -->
<script src="${jquery11 }"></script>
<!-- //js -->
<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Great+Vibes' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Comfortaa:400,300,700' rel='stylesheet' type='text/css'>
</head>
	
<body>
<!-- banner-body -->
	<div class="banner-body">
		<div class="container">
			<div class="banner-body-content">
			<div class="col-xs-3 banner-body-left">
				<div class="logo">
					<h1><a href="home">Great <span>Taste</span></a></h1>
				</div>
				<div class="top-nav">
					<nav class="navbar navbar-default">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
						  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						  </button>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<!-- Include File Operation Part -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
							<nav class="stroke">
								<ul class="nav navbar-nav">
									<li><a href="home" class="hvr-underline-from-left"><i class="home1"></i>Home</a></li>
									<li class="active"><a href="blog"><i class="edit"></i>Blog Sys</a></li>
									<li><a href="filepart" class="hvr-underline-from-left"><i class="text-size1"></i>Files</a></li>
									<!-- for users writing blog -->
									<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
									<li><a href="write_blog" class="hvr-underline-from-left"><i class="text-size1"></i>Write Blog</a></li>
									</sec:authorize>
									<!-- for admin manage users -->
									<sec:authorize access="hasRole('ROLE_ADMIN')">
									<li><a href="ctr_list" class="hvr-underline-from-left"><i class="text-size1"></i>Control List</a></li>
									</sec:authorize>
								</ul>
							</nav>
						</div>
						<!-- /.navbar-collapse -->
					</nav>
				</div>
			</div>
			<div class="col-xs-9 banner-body-right">
				<div class="wmuSlider example1">
					<div class="wmuSliderWrapper">
						<article style="position: absolute; width: 100%; opacity: 0;"> 
							<div class="banner-wrap">
								<div class="banner">
								</div>
							</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;"> 
							<div class="banner-wrap">
								<div class="banner1">
								</div>
							</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;"> 
							<div class="banner-wrap">
								<div class="banner2">
								</div>
							</div>
						</article>
					</div>
				</div>
					<script src="js/jquery.wmuSlider.js"></script> 
					  <script>
						$('.example1').wmuSlider();         
					 </script> 
				<div class="banner-bottom">
					<div class="col-md-4 banner-left">
						<div class="col-xs-3 banner-left1">
							<div class="banner-left11">
								<span> </span>
							</div>
						</div>
						<div class="col-xs-9 banner-right1">
							<h3>cupidatat proi</h3>
						</div>
						<div class="clearfix"> </div>
						<p>Excepteur sint occaecat cupidatat non proident, 
							sunt in culpa qui.</p>
					</div>
					<div class="col-md-4 banner-left">
						<div class="col-xs-3 banner-left1">
							<div class="banner-left22">
								<span> </span>
							</div>
						</div>
						<div class="col-xs-9 banner-right1">
							<h3>sint occaecat</h3>
						</div>
						<div class="clearfix"> </div>
						<p>Excepteur sint occaecat cupidatat non proident, 
							sunt in culpa qui.</p>
					</div>
					<div class="col-md-4 banner-left">
						<div class="col-xs-3 banner-left1">
							<div class="banner-left33">
								<span> </span>
							</div>
						</div>
						<div class="col-xs-9 banner-right1">
							<h3>cupida quisu</h3>
						</div>
						<div class="clearfix"> </div>
						<p>Excepteur sint occaecat cupidatat non proident, 
							sunt in culpa qui.</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="clearfix"> </div>
			<div class="col-xs-3 banner-body-left">
				<div class="latest-news">
			
				<!-- //latest news -->
				</div>
			</div>
			<div class="col-xs-9 banner-body-right">
				
				<!-- real post list -->
				<div class="typo">
				<h2 class="typoh2">All Post List</h2>
					<div class="bs-docs-example">
					<table class="table">
						<thead>
							<tr>
								<th>Title</th>
								<th>Created</th>
								<th>Operation</th>
							</tr>
						</thead>
						<tbody>
							<c:if  test="${!empty postList}">
							<c:forEach items="${postList}" var="post">
							<tr>
								<td><a href="view/post/${post.postId }">${post.postTitle }</a></td>
								<td>${post.postDate }</td>
								<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
								<td><a href="${pageContext.request.contextPath}/delete_post/${post.postId }">Delete</a></td>
								</sec:authorize>
							</tr>
							</c:forEach>
							</c:if>
						</tbody>
					</table>
					</div>
				</div>
				<!-- //real post list -->
				
				<div class="msg-text-bottom">
					<div class="col-md-4 msg-text-bottom-left">
						<figure class="effect-winston">
							<img src="images/4.jpg" alt=" " class="img-responsive" />
							<figcaption>
								
							</figcaption>		
						</figure>

						<h3>vel illum qui dolorem</h3>
						<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, 
							consectetur, adipisci velit, sed quia.</p>
					</div>
					<div class="col-md-4 msg-text-bottom-left">
						<figure class="effect-winston">
							<img src="images/5.jpg" alt=" " class="img-responsive" />
							<figcaption>
								
							</figcaption>	
							
						</figure>
						<h3>quia dolor sit amet</h3>
						<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, 
							consectetur, adipisci velit, sed quia.</p>
					</div>
					<div class="col-md-4 msg-text-bottom-left">
						<figure class="effect-winston">
							<img src="images/6.jpg" alt=" " class="img-responsive" />
							<figcaption>
								
							</figcaption>	
							
						</figure>
						<h3>porro quisquam est</h3>
						<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, 
							consectetur, adipisci velit, sed quia.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="clearfix"> </div>
			<div class="footer">
				<div class="footer-left">
					<ul>
						<li><a href="#">Privacy Policy</a>|</li>
						<li><a href="#">Terms of Use</a>|</li>
						<li><a href="#">Contact Us</a></li>
					</ul>
					
				</div>
				<div class="footer-right">
					<ul class="social-nav model-3">
						<li><a href="#" class="icon icon-border facebook"></a></li>
						<li><a href="#" class="icon icon-border twitter"></a></li>
						 <li><a href="#" class="icon icon-border googleplus"></a></li>
						 <li><a href="#" class="icon icon-border github"></a></li>
						 <li><a href="#" class="icon icon-border rss"></a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		</div>
	</div>
<!-- //banner-body -->
<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
</body>
</html>