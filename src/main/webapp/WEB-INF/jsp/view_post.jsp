<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<title>View</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Great Taste Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
<!-- js -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
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
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
							<nav class="stroke">
								<ul class="nav navbar-nav">
									<li><a href="${pageContext.request.contextPath}/home" class="hvr-underline-from-left"><i class="home1"></i>Home</a></li>
									
									<li><a href="${pageContext.request.contextPath}/blog" class="hvr-underline-from-left"><i class="edit1"></i>Blog Sys</a></li>
									<!-- for admin writing blog -->
									<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
									<li><a href="write_blog" class="hvr-underline-from-left"><i class="text-size1"></i>Write Blog</a></li>
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
					<script src="${pageContext.request.contextPath}/js/jquery.wmuSlider.js"></script> 
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
					<h2>Latest News</h2>
					<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					  <div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
						  <h4 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							  Michael Vol
							</a>
						  </h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
						  <div class="panel-body">
							Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry.
						  </div>
						</div>
					  </div>
					  <div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
						  <h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
							  Andrew Rich
							</a>
						  </h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
						  <div class="panel-body">
							Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry.
						  </div>
						</div>
					  </div>
					  <div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingThree">
						  <h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
							  Rita Rock
							</a>
						  </h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
						  <div class="panel-body">
							Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry.
						  </div>
						</div>
					  </div>
					</div>
					<div class="join">
						<a href="home">Learn More</a>
					</div>
					<h3>Benefits</h3>
					<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
				</div>
			</div>
			<div class="col-xs-9 banner-body-right">
				<!-- single -->
					<div class="single">
					<c:if test="${post != null}">
						<h3 data-key="${post.postId}"><c:out value="${post.postTitle}"/></h3>

						<div class="single-left">
							<p>Published on <span>${post.postDate }</span></p>
							
							<img src="${pageContext.request.contextPath}/images/8.jpg" alt=" " class="img-responsive" />
						</div>
						<div class="single-right">
							<h4>Curabitur aliquet quam id dui</h4>
							<p><span>There are many variations of passages of Lorem Ipsum available,
							but the majority have suffered alteration in some form, 
							by injected humour, or randomised words which don't look even slightly believable.
							If you are going to use a passage.
							Donec rutrum congue leo eget malesuada.</span></p>
						</div>
						<div class="clearfix"> </div>
						<!-- post content -->
						<pre> ${post.postContent}</pre>
						<!-- //post content -->
					</c:if>
						
						
						<div class="three-com">
						<label>Donec volutpat ligula non dapibus volutpat</label>
						<c:if  test="${!empty commentList}">
							<c:forEach items="${commentList}" var="everyComment">							
							<div class="tom-grid">
								<div class="tom">
									<img src="${pageContext.request.contextPath}/images/co.png" alt=" " />
								</div>
								<div class="tom-right">
									<div class="Hardy">		
										<h4>${everyComment.commentAuthor }</h4>								
										<p><label>${everyComment.commentDate }</label></p>
									</div>
									<sec:authorize access="hasRole('ROLE_USER')">
										<a href="${pageContext.request.contextPath}/delete_comment/${everyComment.commentId }"><span class="label label-primary">Delete</span></a>
									</sec:authorize>
									
									<div class="clearfix"> </div>
									<pre class="lorem">${everyComment.commentContent }</pre>
								</div>
								<div class="clearfix"> </div>
							</div>
							</c:forEach>
						</c:if>	
						</div>
						<!-- anyone may leave a comment -->
						<div class="leave-comment">
							<h4>Leave your comment</h4>
							<p>Suspendisse tempor tellus sed nisl semper, quis condimentum turpis pharetra.</p>
							<form:form method="post" action="${pageContext.request.contextPath}/save_comment/${post.postId }" commandName="newComment">
								<form:input type="text" path="commentAuthor" placeholder="Name" required=" " />			           					   
								<form:input type="text" path="commentAuthorEmail" placeholder="Email" required=" " />							
								<form:textarea placeholder="Leave Your Comment" path="commentContent" />
								<input type="submit" value="Submit">
								<div class="clearfix"> </div>
							</form:form>
						</div>
						
						<!-- modify post -->
						<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
						<div class="leave-comment">
							<h4>Modify Post</h4>							
							<form:form method="post" action="${pageContext.request.contextPath}/modify_post/${post.postId }" commandName="post">
								<form:input type="text" path="postTitle" placeholder="${post.postTitle }" required=" " />			           					   
															
								<form:textarea placeholder="${post.postContent }" path="postContent" required=" " />
								<input type="submit" value="Submit">
								<div class="clearfix"> </div>
							</form:form>
						</div>
						</sec:authorize>
					</div>
				<!-- //single -->
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
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<!-- //for bootstrap working -->
</body>
</html>