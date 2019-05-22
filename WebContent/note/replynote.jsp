<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- $modlue=unserialize($_SESSION["faMod"]); -->




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
                <div class="col-lg-12">
                    <h5 class="page-header">该帖回复信息</h5>
                </div>
                <!-- 帖子信息-->
         
                        <div class="col-lg-4">
                            <div class="panel panel-<c:out value="${sessionScope.choseNote.m_color }" />">
                                <div class="panel-heading">
                                   
                                   <c:out value="${sessionScope.choseNote.title }" />
                                </div>
                                <div class="panel-body">
                                    <p><c:out value="${sessionScope.choseNote.cont }" /></p>
                                </div>
                                <div class="panel-footer">
                                    
                                    <c:out value="${sessionScope.choseNote.time }" />
                                </div>
                            </div>
                        </div>

            </div>
            <!-- /.row -->
            <div class="row">
                
                
                
            </div>
            <!-- /.row -->
            <div class="row">
                
                   
                
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-clock-o fa-fw"></i> 历史留言
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	
                            <ul class="timeline">
                            	
                            	<c:forEach var="i" items="${sessionScope.reply}" >
                                <li class="">
                                    <div class="timeline-badge">
                                    	
                                        <div style="width:100%; height:100%; border-radius:100%; overflow:hidden;">
                                        
                						<img src="C:\Users\李肖阳\Desktop\pic\<c:out value="${i.user_name }" />.jpg"  width=100%/>
                						
                						</div>
                						<form method="post" action="../note/deletereplynote.do">
                						
                    						<button type="submit" name="delreply" value="<c:out value="${i.id }" />" class="btn btn-default btn-circle">
                    							<i class="fa fa-times"></i>
                    						</button>
                                    	</form>
                                    </div>
                                    <div class="timeline-panel">
                                    
                                        <div class="timeline-heading">
                                        	
                                            <h4 class="timeline-title"><c:out value="${i.title }" /></h4>
                                            
                                            <p><small class="text-muted"><i class="fa fa-clock-o"></i><c:out value="${i.time }" /></small>
                                            </p>
                                        </div>
                                        <div class="timeline-body">
                                        	
                                            <p><c:out value="${i.cont }" /></p>
                                        </div>
                                    </div>
                                </li>
                                </c:forEach>
                              
                                
                         
                            </ul>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                
              
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
            
            
            <form role="form" name="addnote" action="../note/addnote.do" method="post">
            
            <div id="page-wrapper">
      			
                <div class="row">
               		<div class="col-lg-6">
                	 	<div class="form-group">
                            <label>标题</label>
                            <input name="title" class="form-control" placeholder="关于本帖说点您想说的把">
                        </div>
                     </div>
                
                </div>
                <div class="row">
                	<div class="col-lg-6">
                	 	<div class="form-group">
                            <label>内容</label>
                            <textarea name="text" class="form-control" rows="3"></textarea>
                        </div>
                     </div>
                </div>
                <div class="row">
                	<div class="col-lg-6">
                	 	 <button style="float: right" type="submit" class="btn btn-default">提交讨论</button>
                     </div>
                </div>
        	</div>
        	</form>
        <!-- /#page-wrapper -->
        </div>
        
    	 


    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

    <!-- jQuery Version 1.11.0 -->
    <script src="../js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../js/plugins/morris/raphael.min.js"></script>
    <script src="../js/plugins/morris/morris.min.js"></script>
    <script src="../js/plugins/morris/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/sb-admin-2.js"></script>
	<script type="text/javascript">
	function pic_pos(){
		if((Math.random()*100)%2==0){
			return "timeline-inverted";
		}else{
	        return "";   
	    }
	}
		
	
	</script>
</body>

</html>
