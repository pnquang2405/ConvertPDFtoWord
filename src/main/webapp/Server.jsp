<%@page import="Model.Bean.FileInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/table.css">
<title>History</title>
</head>
<body>
	<div>
        <div id="header">
            <ul class="nav">
                <li><a href="CheckLoginServlet" target="_top" id="nav1">Main</a></li>
                <li><a href="ServerServlet">History</a></li>
                <li><a href="LogoutServlet" >Sign Out</a></li>
            </ul>
        </div>
		<table border = 1>
		<tr>
	            <th>Ten file</th>
	            <th>Download</th>
	    </tr>
		<%
			ArrayList<FileInfo> files= (ArrayList<FileInfo>)request.getAttribute("files");
			if (files!=null)
			for(int i=0; i<files.size(); i++){
		%>
			<tr>
				<td><%= files.get(i).getFileName() %></td>
				<%
					if (files.get(i).isFileStatus()) {
				%>
				<td><a href='DownloadServlet?id=<%= files.get(i).getFileId() %>'>download</a></td>
				<%
					} else {
				%>
				<td>Processing ...</td>
				<%		
					}
				%>
			</tr>
		<% } %>
		</table>
	</div>
</body>
</html>