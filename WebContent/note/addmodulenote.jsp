<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BBS欢迎您</title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/sb-admin-2.css" rel="stylesheet">

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

           
                    
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        
        <form role="form" name="login" action="../note/addmodulenote.do" method="post" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">
                	<input name="title" class="form-control" placeholder="标题">
                </h4>
                
            </div>
            
            <div class="modal-body">
               <textarea name="cont" class="form-control" rows="3" placeholder="内容"></textarea>
               
               <div class="form-group" >
                                	<div class="row">
               							 
                                		 
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
                                                    
                                            </div>
                                        </div>
                                        
                                			</div>
                                
                                		 </div>
                                   	</div>
                                </div>
            </div>
            
            
            
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary">添加</button>
            </div>
        
        </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
                        
            
       
    <!-- jQuery Version 1.11.0 -->
    <script src="../js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Notifications - Use for reference -->
    <script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>

</body>

</html>
