<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--谨记要加UTF-8，不然浏览器出来的就是乱码  
位置不能乱放-->
<fmt:setBundle basename="messages" var="session" scope="session" />
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="include.login.frame" bundle="${session }"/></title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">


</head>



<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel 
	                <c:if test="${!(empty sessionScope.userIsno)}">
	                	 panel-danger
	               	</c:if>
	                 <c:if test="${(empty sessionScope.userIsno)}">
	                	 panel-default
	               	</c:if> 
             	">
                    <div class="panel-heading">
                    
                    <c:if test="${(empty sessionScope.userIsno)}">
	                	<h3 class="panel-title"><fmt:message key="include.login.title" bundle="${session }"/></h3>
	               	</c:if>  
                    <c:if test="${!(empty sessionScope.userIsno)}">
                    	<c:if test="${sessionScope.userIsno == 1}">
                    	
	                	 	<h3 class="panel-title"><fmt:message key="include.login.nouser" bundle="${session }"/></h3>
	               		</c:if>
	                	<c:if test="${sessionScope.userIsno == 2}">
                    	
	                	 	<h3 class="panel-title"><fmt:message key="include.login.nopass" bundle="${session }"/></h3>
	               		</c:if>
	               		<c:set var="userIsno" scope="session" value="${null}" />
	               		
	               	</c:if>
	                
                    
                  
                    </div>
                    <div class="panel-body">
                        <form role="form" name="login" action="../include/login.do" method="post">
                            <fieldset>
                                <div class="form-group" >
                                    <input class="form-control" placeholder="<fmt:message key="include.login.email" bundle="${session }"/>" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="<fmt:message key="include.login.pass" bundle="${session }"/>" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me"><fmt:message key="include.login.remember" bundle="${session }"/>
                                    </label>
                                    
                                     <a href="../users/createuser.jsp" style="float: right" type="button" class="btn btn-outline btn-success"><fmt:message key="include.login.create" bundle="${session }"/></a>
                                </div>
                                </br>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit"  class="btn btn-lg btn-success btn-block" value="<fmt:message key="include.login.login" bundle="${session }"/>">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery Version 1.11.0 -->
    <script src="../js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/sb-admin-2.js"></script>

</body>

</html>
