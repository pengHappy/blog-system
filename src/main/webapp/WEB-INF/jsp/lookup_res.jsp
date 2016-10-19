<%@ page contentType="text/html;  charset=UTF-8"  language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<title>Home</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Great Taste Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
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
					<h1><a href="home">Fantastic <span>Taste</span></a></h1>
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
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
							<nav class="stroke">
								<ul class="nav navbar-nav">
									<li class="active"><a href="home"><i class="home"></i>Home</a></li>
									<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">					
									<li><a href="blog" class="hvr-underline-from-left"><i class="edit1"></i>Blog Sys</a></li>	
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
				<!-- login -->
				<form:form name='f' action="j_spring_security_check" method='POST'>
					<h2>Login Here</h2>
					<div class="input-group">
						<!-- login username -->
					    <span class="input-group-addon" id="basic-addon1">@</span>
					    <input type="text" name="username" />					    
					</div>
					<div class="input-group">
						<!-- login password -->
					    <span class="input-group-addon" id="basic-addon1">@</span>
					    <input type="password" name="password" />					    
					</div>		
					<div class="clearfix"> </div>
					<div class="join">
						<!-- prevent multiple login -->
						<input type="hidden" name="token" value="${token}" />
							<input name="submit" type="submit" value="Submit">
					</div>
				</form:form>
				<br>
				<!-- logout -->
				<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
					<c:url value="/logout" var="logoutUrl" />
					<a href="${logoutUrl}"><span class="label label-warning">Logout</span></a>					
				</sec:authorize>
				<!-- //logout -->
				
				<!-- sign up -->
				<br><br><a href="sign_up"><span class="label label-success">Sign Up</span></a><br><br>
				<!-- //sign up -->
				
				<!-- in the look up result page, no more searching method -->
				</div>
			</div>
			<div class="col-xs-9 banner-body-right">
				<div class="msg-text">
					<div class="col-xs-2 msg-text-left">
						<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					</div>
					<div class="col-xs-10 msg-text-right">
						<p>But I must explain to you how all this mistaken idea of 
							denouncing pleasure and praising pain was born and I will give 
							you a complete account of the system.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				
				<div class="typo">
				<h3 class="bars">All Posts</h3>
				<ul class="list-group">
					<c:if  test="${!empty resList}">
						<c:forEach items="${resList}" var="post">
						<li class="list-group-item"><a href="all_post/${post.postId }">${post.postTitle }</a></li>
						</c:forEach>
					</c:if>
				</ul>
				</div>
				
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
