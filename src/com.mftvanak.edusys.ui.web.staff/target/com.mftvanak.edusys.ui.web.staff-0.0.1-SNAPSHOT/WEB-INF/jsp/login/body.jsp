<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=utf-8"%>

<style>
#div_content_left {
  min-height: 220px;
}
</style>
<div id="div_login_form">
  <form:form action="login" commandName="loginForm">
    <input id="input_login_page" type="hidden" value="login_page">
    <table style="margin: 10px 20px">
      <c:if test="${ErrorMessage != null}">
        <tr>
          <td></td>
          <td><FONT color="red">${ErrorMessage}</FONT></td>
        </tr>
      </c:if>
      <tr>
        <td>نام کاربری</td>
        <td><form:input class="rounded" path="username" /> <FONT color="red"> <br /> <form:errors
              path="username" /></FONT></td>
      </tr>
      <tr>
        <td>کلمه عبور</td>
        <td><form:password class="rounded" path="password" /><FONT color="red"><br />
            <form:errors path="password" /></FONT></td>
      </tr>
      <tr>
        <td></td>
        <td style="padding-top: 15px; padding-right: 15px;"><img class="captcha" src="captcha" /></td>
      </tr>
      <tr>
        <td></td>
        <td><form:input class="rounded" path="captcha"
            Style="width: 150px; margin-bottom: 5px;" /><FONT color="red"><br /> <form:errors
              path="captcha" /></FONT></td>
      </tr>
      <tr>
        <td></td>
        <td align="center"><input type="submit" value="ورود به سیستم" /></td>
      </tr>
    </table>
  </form:form>
</div>