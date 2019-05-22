<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 右上角以及左边的小图标 -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

         

        <a class="navbar-brand" href="../include/toindex.do"><c:out value="${sessionScope.user}"/></a>
        <div style="width:40px; height:40px; border-radius:100%; overflow:hidden;">
        	  <!-- 这里存放的是默认路径C盘，如果项目迁移，这里可能要改 -->
              <img src="C:\Users\李肖阳\Desktop\pic\<c:out value="${sessionScope.user}"/>.jpg"  width=100% height=100%/>
        </div>   
    </div>
    <!-- /.navbar-header -->



	<!-- 右上角的小图标 -->
    <ul class="nav navbar-top-links navbar-right">
    	<!--  
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-messages">
                <li>
                    <a href="#">
                        <div>
                            <strong>John Smith</strong>
                            <span class="pull-right text-muted">
                                <em>Yesterday</em>
                            </span>
                        </div>
                        <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <strong>John Smith</strong>
                            <span class="pull-right text-muted">
                                <em>Yesterday</em>
                            </span>
                        </div>
                        <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <strong>John Smith</strong>
                            <span class="pull-right text-muted">
                                <em>Yesterday</em>
                            </span>
                        </div>
                        <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>Read All Messages</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
            
        </li>
        -->
        <!-- /.dropdown -->
       
        <!-- /.dropdown -->
        <!-- 
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-comment fa-fw"></i> New Comment
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                            <span class="pull-right text-muted small">12 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-envelope fa-fw"></i> Message Sent
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-tasks fa-fw"></i> New Task
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-upload fa-fw"></i> Server Rebooted
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>See All Alerts</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
          
        </li>
        -->
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
            <!--  
                <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                </li>
                -->
                <li><a href="../users/changemm.jsp"><i class="fa fa-gear fa-fw"></i>修改密码</a>
                </li>
                <li class="divider"></li>
             
                <li><a href="../include/login.jsp"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    

	<!-- 左侧栏的标题栏 -->
	<div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
            <form method="post" action="../include/top_left.do">
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">
                     
                        <input name="find" type="text" class="form-control" placeholder="搜索相应的帖子...">
                        <span class="input-group-btn">
                       
                            <button class="btn btn-default" type="submit">
                                <i class="fa fa-search"></i>
                            </button>
                    
                    	</span>
                     
                    </div>
                    <!-- /input-group -->
                </li>
                </form>
                <li>
                    <a href="../include/toindex.do"><i class="fa fa-dashboard fa-fw"></i> 论坛主页</a>
                </li>
                <li>
                	<c:set var="manageIsno" scope="session" value="${2}"/>
                    <a href="../manage/managelogin.jsp"><i class="fa fa-gears fa-fw"></i> 增加版块</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 数据统计<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="../counter/todata_counter.do">浏览量统计</a>
                        </li>
                        <li>
                            <a href="../counter/todata_count.do">数据信息统计</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                
                
                <li>
                    <a href="#"><i class="fa fa-sitemap fa-fw"></i>论坛版块<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                    
                    <c:forEach var="i" items="${sessionScope.module}">
                        <li>
                            <a href="../module/tomodule.do?id=<c:out value="${i.id}"/>">
                            <c:out value="${i.module_name}"/>
                            </a>
                        </li>
                    </c:forEach>
                    
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i> 更多功能<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="../include/blank.jsp">联系我们</a>
                        </li>
                        <li>
                            <a href="../include/login.jsp ">重新登陆</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
    
</nav>



    <!-- Custom Theme JavaScript -->
    <script src="../js/sb-admin-2.js"></script>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="../js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
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
