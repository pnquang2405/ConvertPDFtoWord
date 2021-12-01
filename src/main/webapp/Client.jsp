<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<link rel="stylesheet" href="./css/style1.css">
<title>Trang chủ</title>
</head>
<body>
	<div id="header">
            <ul class="nav">
                <li><a href="CheckLoginServlet" target="_top" id="nav1">Main</a></li>
                <li><a href="ServerServlet">History</a></li>
                <li><a href="LogoutServlet" >Sign Out</a></li>
            </ul>
        </div>
        <div id="content">
            <form class="content-form" enctype='multipart/form-data' method='POST' action="UploadServlet">
                <div class="container-xl">
                    <h1 style="text-align:center; margin:30px;">Convert PDF to WORD</h1>
                    <div class="form-group gcore-form-row" id="form-row-anh-the">
                        <label for="hoc_ba_thpt" class="control-label gcore-label-left tipped_label">Chọn các file
                        </label>
                        <div class="gcore-input gcore-display-table" id="fin-anh-the">
                            <input type="file" id="imgUpload_3" name="files[]" accept="application/PDF" multiple="">
                        </div>
                    </div>
                </div>
                <div class="submit">
                    <input class="btn-submit" type="submit" value="Convert" name="submit">
                </div>
            </form>
        </div>
        <div id="footer"></div>
</body>
</html>