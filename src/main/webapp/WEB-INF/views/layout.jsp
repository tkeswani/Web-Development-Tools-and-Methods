<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
 <head>
   
 </head>
 <body>
       <table  border="1" cellpadding="2" cellspacing="1" align="center">
   <tr>
       <td height="80px" width="700px"  colspan="2" ><tiles:insertAttribute name="header" /></td>
   </tr>
     <tr>
       <td height="445px" width="200px" ><tiles:insertAttribute name="menu" /></td>
       <td height="445px" width="600px" ><tiles:insertAttribute name="body" /></td>
   </tr>
     <tr>
       <td height="60px" width="700px" colspan="2" ><tiles:insertAttribute name="footer" />
       </td>
   </tr>
   </table>
 </body>
</html>