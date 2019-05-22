<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	                 <c:if test="${sessionScope.manageIsno2 == 1}">
	                 	panel-danger
	                 </c:if>
	                 <c:if test="${sessionScope.manageIsno2 == 2}">
	                 	panel-default
	                 </c:if> 
                 ">
            
                    <div class="panel-heading">
                    <c:if test="${sessionScope.manageIsno2 == 2}">
                    	<h3 class="panel-title"><fmt:message key="manage.login.managelogin" bundle="${session }"/></h3>
                    </c:if>
                    
                    <c:if test="${sessionScope.manageIsno2  == 1}">
                    	<h3 class="panel-title"><fmt:message key="manage.login.error" bundle="${session }"/></h3>
                    	
                    </c:if>
                    	<c:set var="manageIsno2" scope="session" value="${2}"/>
                    </div>
                    <div class="panel-body">
                        <form role="form" name="login" action="../manage/managelogin.do" method="post">
                            <fieldset>
                                <div class="form-group" >
                                    <input class="form-control" placeholder="<fmt:message key="manage.login.managemail" bundle="${session }"/>" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="<fmt:message key="manage.login.managepass" bundle="${session }"/>" name="password" type="password" value="">
                                </div>
                                
                                </br>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit"  class="btn btn-lg btn-success btn-block" value="<fmt:message key="manage.login.login" bundle="${session }"/>">
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
