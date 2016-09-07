<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta charset="UTF-8">
<script type="text/javascript" src="common/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="common/js/jquery.dataTables.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="common/css/demo.css"> -->
<link rel="stylesheet" type="text/css" href="common/css/menu.css">
<link rel="stylesheet" type="text/css" href="common/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="common/css/jquery-ui-1.10.4.custom.css">
<!-- <link rel="stylesheet" type="text/css" href="common/css/font-face/typicons.css"> -->


<script type="text/javascript">

$(function() {


	$(document).ready(function() {
// 		 $.ajax({
// 				type : "GET",
// 				url : "login/login.do", // リクエストURL
// 				cache : false,
// 					data : $(this).serialize(),
// 					timeout: 10000,
// 				success : function(data, status, xhr) {
// 		//			alert("success");
// //					alert(data);
// //					var jsonData = eval('(' + data + ')');
// //						if (data != null && data != ''
// //								&& jsonData.success == true) {
// 							window.location.href = 'menu.jsp';
// //						} else {
// //							$.messager.alert('提 示', jsonData.message);
// //						}
// 				},
// 				error : function(XMLHttpRequest, status, errorThrown) {
// //					alert("fail:" + XMLHttpRequest);
// //					alert("status:" + status);
// 				}
// 			});

	});

    $('#example tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    $('#button').click( function () {
        table.row('.selected').remove().draw( false );
    } );

});



</script>
</head>
<body>
	<div id="header">
		<table id="header-table" width="100%">
			<tr >
				<td rowspan="2" width="20%" align="left" ><h2>xxland管理システム</h2></td>
				<td rowspan="2" width="65%" align="center" ><h2>メニュー画面</h2></td>
				<td width="15%" align="left" >登録者：${operater.name}</td>
			</tr>
			<tr >
				<td>権限  ：${operater.status}</td>
			</tr>
		</table>
	</div>
	<div id="content">
		<div id="container">
		<FIELDSET>
			<table id="menu-table">
				<tr>
				<td>
					<h2>ユーザー管理</h2>
					</td>
				</tr>
				<tr>
					<td>
					<input type="button" name="btnPrint" id="btnPrint" class="menuBtn" value=" 申込書印刷" onclick="location.href='main.html'">
					</td>
				</tr>
				<tr>
					<td>
					<input type="button" name="btnPrint" id="btnPrint" class="menuBtn" value=" 申込書印刷">
					</td>
				</tr>
				<tr>
					<td>
					<input type="button" name="btnPrint" id="btnPrint" class="menuBtn" value=" 申込書印刷">
					</td>
				</tr>
			</table>
		</FIELDSET>
		</div>

	</div>
	<div id="footer">
		<address>制作者：xxland</address>
	</div>
</body>
</html>