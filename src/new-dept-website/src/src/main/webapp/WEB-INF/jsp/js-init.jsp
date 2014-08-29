<%@page import="java.util.Calendar"%>
<%@page contentType="text/javascript" language="java"%>
<%
	Calendar today = Calendar.getInstance();
	out.print("var currentMonth = " + (today.get(Calendar.MONTH) - 1));
%>