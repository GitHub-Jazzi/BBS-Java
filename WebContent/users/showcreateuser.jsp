<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html lang="en">

<head>

    <jsp:include page="../include/headContent.jsp" />

</head>

<body>

    <div id="wrapper">


        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-6">
                    <h1 class="page-header">注册成功！</h1>
                    <div class="panel-body">
                        <form role="form" name="login" action="../include/login.jsp">
                            <fieldset>
                            
                                <div class="form-group" >
                                	<div class="row">
               							 <div class="col-lg-2">
                                			<label class="control-label" for="inputSuccess">邮箱</label>
                                		 </div>
                                		 
                                		 <div class="col-lg-10">
                                		 	<c:out value="${sessionScope.create_user.mail }" />
                                			
                                		 </div>
                                   	</div>
                                </div>
                                </br>
                                <div class="form-group">
                                    <div class="row">
               							 <div class="col-lg-2">
                                			<label class="control-label" for="inputSuccess">密码</label>
                                		 </div>
                                		 
                                		 <div class="col-lg-10">
                                		 	<c:out value="${sessionScope.create_user.password }" />
                                		
                                		 </div>
                                   	</div>
                                	
                                </div>
                                </br>
                                <div class="form-group">
                                    <div class="row">
               							 <div class="col-lg-2">
                                			<label class="control-label" for="inputSuccess">头像</label>
                                		 </div>
                                		 
                                		 <div class="col-lg-10">
                                			<div style="width:60px; height:60px; border-radius:100%; overflow:hidden;">
                                                  <img src="C:\Users\李肖阳\Desktop\pic\<c:out value="${sessionScope.create_user.mail }" />.jpg"  width=100% height=100%/>
                                            </div>   
                                		 </div>
                                   	</div>
                                	
                                </div>
                                </br>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit"  class="btn btn-primary btn-lg btn-block" value="返回登陆">
                            </fieldset>
                        </form>
                    </div>
                </div>  
            
            
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

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

    <!-- Morris Charts JavaScript -->
    <script src="../js/plugins/morris/raphael.min.js"></script>
    <script src="../js/plugins/morris/morris.min.js"></script>
    <script src="../js/plugins/morris/morris-data.php"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/sb-admin-2.js"></script>

</body>

</html>
