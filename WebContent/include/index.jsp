<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--谨记要加UTF-8，不然浏览器出来的就是乱码  
位置不能乱放-->

<!--  

$mod=unserialize($_SESSION["module"]);

$title_notes=array();
if(isset($_SESSION["title_notes"])){
    $title_notes=unserialize($_SESSION["title_notes"]);
}

-->
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>欢迎来到BBS论坛</title>

<!-- 这个防止的是以addmodule.do的方式跳到这里，路径不一样了 -->
<jsp:include page="headContent.jsp" />
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


    
<!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
</head>

<body>

    <div id="wrapper">
	<c:set var="manageIsno2" scope="session" value="${2}"/>
 	<jsp:include page="top_left.jsp" />
	

		<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">选择您感兴趣的话题:</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            
            
            <!-- 以下放着的是4个模块 -->
            <div class="row">
                
                <c:forEach	var="i" items="${sessionScope.module}">
                	
                
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-<c:out value="${i.cs_color}"/>">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-<c:out value="${i.cs_pic}"/> fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">on:<c:out value="${applicationScope.onlinenum}" /></div>
                                    <div><c:out value="${i.module_cont}" /></div>
                                </div>
                            </div>
                        </div>
                        <a href="../module/tomodule.do?id=<c:out value="${i.id}"></c:out>">
                            <div class="panel-footer">
                                <span class="pull-left"><c:out value="${i.module_name}" /></span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                </c:forEach>
                
            </div>
            
            
            <!-- 主页界面聊天处 -->
            <!-- /.panel -->
                    <div class="chat-panel panel panel-default">
                    
                        <div class="panel-heading">
                            <i class="fa fa-comments fa-fw"></i>
                            	查询结果
                            
                            <div class="btn-group pull-right">
                                <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-chevron-down"></i>
                                </button>
                                <!--  
                                <ul class="dropdown-menu slidedown">
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-refresh fa-fw"></i> Refresh
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-check-circle fa-fw"></i> Available
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-times fa-fw"></i> Busy
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-clock-o fa-fw"></i> Away
                                        </a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-sign-out fa-fw"></i> Sign Out
                                        </a>
                                    </li>
                                </ul>
                             -->
                            </div>
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul class="chat">
                            	<c:if test="${!(empty sessionScope.title_notes)}">
                            	<c:forEach var="i" items="${sessionScope.title_notes}">
                            	
                                <li class="left clearfix">
                                    <span class="chat-img pull-left">
                                        <img src="C:\Users\李肖阳\Desktop\pic\<c:out value="${i.user_name }"/>.jpg"  width=50px height=50px alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <strong class="primary-font"><c:out value="${ i.title}"/></strong> 
                                            <small class="pull-right text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i>  <c:out value="${i.time }"/>
                                            </small>
                                        </div>
                                        <p>
                                           <c:out value="${i.cont }"/>
                                        </p>
                                    </div>
                                    
                                </c:forEach>
                                </c:if>
                                </li>
                               
                                <!--  
                                <li class="right clearfix">
                                    <span class="chat-img pull-right">
                                        <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <small class=" text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 13 mins ago</small>
                                            <strong class="pull-right primary-font">Bhaumik Patel</strong>
                                        </div>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                        </p>
                                    </div>
                                </li>
                                <li class="left clearfix">
                                    <span class="chat-img pull-left">
                                        <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <strong class="primary-font">Jack Sparrow</strong> 
                                            <small class="pull-right text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 14 mins ago</small>
                                        </div>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                        </p>
                                    </div>
                                </li>
                                <li class="right clearfix">
                                    <span class="chat-img pull-right">
                                        <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle" />
                                    </span>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <small class=" text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> 15 mins ago</small>
                                            <strong class="pull-right primary-font">Bhaumik Patel</strong>
                                        </div>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                        </p>
                                    </div>
                                </li>
                                -->
                            </ul>
                        </div>
                        <!-- /.panel-body -->
                        <div class="panel-footer">
                            <div class="input-group">
                            <!--  
                                <input id="btn-input" type="text" class="form-control input-sm" placeholder="Type your message here..." />
                                <span class="input-group-btn">
                                    <button class="btn btn-warning btn-sm" id="btn-chat">
                                        Send
                                    </button>
                                </span>
                               -->
                            </div>
                        </div>
                        <!-- /.panel-footer -->
                    </div>
            
            
        	   
        </div>
       
    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="../js/jquery-1.11.0.js"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
    
    <!-- Bootstrap Core JavaScript必须加载两次，不知道为什么 -->
    <script src="../js/bootstrap.min.js"></script>
    


    <!-- Metis Menu Plugin JavaScript -->
    <script src="../js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="../js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="../js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
    
    </script>
 

   
</body>

</html>
