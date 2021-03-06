<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:set var="faModname" scope="session" value="${sessionScope.faMod.user_name}" />
<!DOCTYPE html>
<html lang="en">

<head>

    
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>欢迎来到BBS论坛</title>

<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Timeline CSS -->
<link href="../css/plugins/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="../css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div id="wrapper">

       
        <jsp:include page="../include/top_left.jsp" />
        
        <div id="page-wrapper">
        <!-- 版块信息 -->
            <div class="row">
               
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	版快块信息:
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#home" data-toggle="tab">版主</a>
                                </li>
                                <li><a href="#profile" data-toggle="tab">版块分类</a>
                                </li>
                                <li><a href="#messages" data-toggle="tab">版块介绍</a>
                                </li>
                               
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="home">
                                    <h4><c:out value="${sessionScope.faMod.user_name}" /></h4>
                                    
                                    </div>
                                <div class="tab-pane fade" id="profile">
                                    <h4><c:out value="${sessionScope.faMod.module_name}" /></h4>
                                                                    
                                    </div>
                                <div class="tab-pane fade" id=      "messages">
                                    <h4><c:out value="${sessionScope.faMod.module_cont}" /></h4>
                                    
                                    </div>
                               
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
               
            </div>
            
          
            <jsp:include page="../note/addmodulenote.jsp" />
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">选择您感兴趣的帖子
                    
            
                    
                    <button class="btn btn-outline btn-danger" data-toggle="modal" data-target="#myModal">
                               	添加帖子
                    </button>
                    </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
       
       
       
       
       
       
       
                <!-- 帖子信息-->
               
                <c:forEach var="i" items="${sessionScope.notes }" >
                <a href="../note/toreplynote.do?id=<c:out value="${i.id }" />">
                    <div class="col-lg-4" >
                        <div class="panel panel-<c:out value="${i.m_color }" />">
                            <div class="panel-heading">
                            	<c:out value="${i.title }" />
                               
                            </div>
                            <div class="panel-body">
                                <p><c:out value="${i.cont }" /></p>
                            </div>
                            <div class="panel-footer">
                                <c:out value="${i.time }" />
                            </div>
                        </div>
                    </div>
                </a>
                </c:forEach>
                    
            
        </div>
        <!-- /#page-wrapper -->


    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="../js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->

      <!-- Bootstrap Core JavaScript必须加载两次，不知道为什么 -->
    <script src="../js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/sb-admin-2.js"></script>
    


</body>

</html>
