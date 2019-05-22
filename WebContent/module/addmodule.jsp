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

		<jsp:include page="../include/top_left.jsp" />
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-6">
                    <h1 class="page-header">增加模块</h1>
                    <div class="panel-body">
                    <!-- enctype="multipart/form-data"这东西不能乱加，否则request在post中寻常方法取不出来了 -->
                        <form role="form" name="login" action="../module/addmodule.do" method="post" >
                            <fieldset>
                            
                                <div class="form-group" >
                                	<div class="row">
               							 <div class="col-lg-2">
                                			<label class="control-label" for="inputSuccess">版块标题</label>
                                		 </div>
                                		 
                                		 <div class="col-lg-10">
                                			<input class="form-control" name="title" type="text" >
                                		 </div>
                                   	</div>
                                </div>
                                </br>
                                <div class="form-group">
                                    <div class="row">
               							 <div class="col-lg-2">
                                			<label class="control-label" for="inputSuccess">版块内容</label>
                                		 </div>
                                		 
                                		 <div class="col-lg-10">
                                			<textarea name="text" class="form-control" rows="3"></textarea>
                                		 </div>
                                   	</div>
                                	
                                </div>
                                </br>
                                <div class="form-group" >
                                	<div class="row">
               							 <div class="col-lg-2">
                                			<label class="control-label" for="inputSuccess">选择版主</label>
                                		 </div>
                                		 
                                		 <div class="col-lg-10">
                                			 <select multiple name="mail" class="form-control">
       											
                                			 	<c:forEach var="i" items="${ sessionScope.users}">
                                                <option value=<c:out value="${i.mail }" />><c:out value="${i.mail }" /></option>
                                                
                                                </c:forEach>
                                           
                                            </select>
                                		 </div>
                                   	</div>
                                </div>
                                
                                
                                <div class="form-group" >
                                	<div class="row">
               							 <div class="col-lg-2">
                                			<label class="control-label" for="inputSuccess">选择颜色</label>
                                		 </div>
                                		 
                                		 <div class="col-lg-10">
                                			<div class="col-lg-3">
                                            <div class="radio" >
                                                <label >
                                                    <input type="radio" name="colour" id="optionsRadios1" value="1" checked>颜色 1
                                                </label>
                                                
                                                <div class="panel panel-yellow">
                                                    <div class="panel-heading">
                                                        <div class="row">
                                                            <div class="col-xs-3">
                                                                <i class="fa fa-fa-5x"></i>
                                                            </div>
                                                            <div class="col-xs-9 text-right">
                                                                <div class="huge"></div>
                                                                <div></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a >
                                                        <div class="panel-footer">
                                                            <span class="pull-left"></span>
                                                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                            <div class="clearfix"></div>
                                                        </div>
                                                    </a>
                                                </div>
                                            
                                            </div>
                                            </div>
                                            <div class="col-lg-3">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="colour" id="optionsRadios2" value="2" >颜色 2
                                                </label>
                                                <div class="panel panel-green">
                                                    <div class="panel-heading">
                                                        <div class="row">
                                                            <div class="col-xs-3">
                                                                <i class="fa fa-fa-5x"></i>
                                                            </div>
                                                            <div class="col-xs-9 text-right">
                                                                <div class="huge"></div>
                                                                <div></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a >
                                                        <div class="panel-footer">
                                                            <span class="pull-left"></span>
                                                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                            <div class="clearfix"></div>
                                                        </div>
                                                    </a>
                                           	 </div>
                                            
                                            </div>
                                            </div>
                                            <div class="col-lg-3">
                                            <div class="radio">
                                            
                                                <label>
                                                    <input type="radio" name="colour" id="optionsRadios3" value="3">颜色 3
                                                </label>
                                                <div class="panel panel-primary">
                                                    <div class="panel-heading">
                                                        <div class="row">
                                                            <div class="col-xs-3">
                                                                <i class="fa fa-fa-5x"></i>
                                                            </div>
                                                            <div class="col-xs-9 text-right">
                                                                <div class="huge"></div>
                                                                <div></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a >
                                                        <div class="panel-footer">
                                                            <span class="pull-left"></span>
                                                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                            <div class="clearfix"></div>
                                                        </div>
                                                    </a>
                                            	</div>
                                            </div>
                                            </div>
                                            <div class="col-lg-3">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="colour" id="optionsRadios3" value="4">颜色 4
                                                </label>
                                                <div class="panel panel-red">
                                                    <div class="panel-heading">
                                                        <div class="row">
                                                            <div class="col-xs-3">
                                                                <i class="fa fa-fa-5x"></i>
                                                            </div>
                                                            <div class="col-xs-9 text-right">
                                                                <div class="huge"></div>
                                                                <div></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a >
                                                        <div class="panel-footer">
                                                            <span class="pull-left"></span>
                                                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                            <div class="clearfix"></div>
                                                        </div>
                                                    </a>
                                            </div>
                                        </div>
                                        
                                			</div>
                                
                                		 </div>
                                   	</div>
                                </div>
                                
                                <div class="form-group" >
                                	<div class="row">
               							 <div class="col-lg-2">
                                			<label class="control-label" for="inputSuccess">选择图标</label>
                                		 </div>
                                		 
                                		 <div class="col-lg-10">
                                			<div class="col-lg-3">
                                            <div class="radio" >
                                                <label >
                                                    <input type="radio" name="pic" id="optionsRadios1" value="1" checked>图标 1
                                                </label>
                                                
                                                <i class="fa fa-space-shuttle fa-5x"></i>
                                            
                                            </div>
                                            </div>
                                            <div class="col-lg-3">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="pic" id="optionsRadios2" value="2">图标 2
                                                </label>
                                                 <i class="fa fa-heart-o fa-5x"></i>
                                            
                                            </div>
                                            </div>
                                            <div class="col-lg-3">
                                            <div class="radio">
                                            
                                                <label>
                                                    <input type="radio" name="pic" id="optionsRadios3" value="3">图标 3
                                                </label>
                                                 <i class="fa fa-trophy fa-5x"></i>
                                            </div>
                                            </div>
                                            <div class="col-lg-3">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="pic" id="optionsRadios3" value="4">图标 4
                                                </label>
                                                <i class="fa fa-mortar-board fa-5x"></i>
                                        	</div>
                                			</div>
                                
                                		 </div>
                                   	</div>
                                </div>
                                
    
    
    
                              
    
                              
                                </br>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit"  class="btn btn-lg btn-success btn-block" value="增加模块">
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
