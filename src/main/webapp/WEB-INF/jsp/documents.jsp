<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<title>Documents</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Great Taste Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
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
					<h1><a href="index.html">Great <span>Taste</span></a></h1>
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
									<li><a href="home" class="hvr-underline-from-left"><i class="home1"></i>Home</a></li>									
									<li><a href="blog" class="hvr-underline-from-left"><i class="edit1"></i>Blog Sys</a></li>
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
				<!--typography-page -->
				<div class="typo">
					<div class="grid_3 grid_4">
						<h3 class="hdg">Document Manager</h3>
							<div class="bs-example">
							<!-- the file table -->
							<form:form method="post" action="save_document" commandName="document" enctype="multipart/form-data">
    						  <form:errors path="*" cssClass="error"/>
    							<table>
									<tr>
        								<td><form:label path="name">Name</form:label></td>
        								<td><form:input path="name" /></td> 
    								</tr>
    								<tr>
        								<td><form:label path="description">Description</form:label></td>
        								<td><form:textarea path="description" /></td>
									</tr>
									<tr>
        								<td><form:label path="content">Document</form:label></td>
        								<td><input type="file" name="file" id="file"></input></td>
    								</tr>
    								<tr>
        								<td colspan="2">
            							<input type="submit" value="Add Document"/>
        								</td>
    								</tr>
								</table>  
							</form:form>
							<br/>
						<h3>Document List</h3>
						<c:if  test="${!empty documentList}">
							<table class="data">
								<tr>
    								<th>Name</th>
    								<th>Description</th>
    								<th>&nbsp;</th>
								</tr>
							<c:forEach items="${documentList}" var="document">
    							<tr>
        							<td width="100px">${document.name}</td>
        							<td width="250px">${document.description}</td>
        							<td width="20px">
            						<a href="${pageContext.request.contextPath}/download/${document.id}.html"><img 
            							src="${pageContext.request.contextPath}/images/save_icon.gif" border="0"
                						title="Download this document"/></a> 
        
            						<a href="${pageContext.request.contextPath}/remove/${document.id}.html"
                						onclick="return confirm('Are you sure you want to delete this document?')"><img
                						src="${pageContext.request.contextPath}/images/delete_icon.gif" border="0"
                						title="Delete this document"/></a> 
        							</td>
    							</tr>
							</c:forEach>
							</table>
						</c:if>
						</div>	<!-- bs-example -->				
					</div>
				</div>
			</div>  <!-- banner body right -->
			
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