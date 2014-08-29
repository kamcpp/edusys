<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<tiles:insertAttribute name="links" />
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
  <header id="div_header">
    <div id="div_header_bar">
      <div id="div_header_bar_logo">
        <div id="div_header_bar_logo_left">
          <img src="images/mft.jpg" height="62px" style="padding-right: 50px">
        </div>
        <div id="div_header_bar_logo_center">
          <img src="images/mft-dept-admin.png" height="47px">
        </div>
        <c:if test="${principal != null}">
          <div id="div_header_bar_account">
            <span>${principal.getName()} خوش آمدید</span> <a style="margin-right: 5px;"
              href="j_spring_security_logout">خروج از سیستم</a>
          </div>
        </c:if>
      </div>
    </div>
  </header>
  <div id="div_content">
    <div id="div_content_left">
      <div id="div_content_main">
        <tiles:insertAttribute name="body" />
      </div>
    </div>
    <div id="div_content_right">
      <nav id="nav_content_right">
        <ul>
          <li class="right_menu_item"><div class="right_menu_item_header"></div> <a
            class="right_menu_item_anchor" onclick="load_home();">خانه</a></li>
          <li id="li_course_categories" class="right_menu_item"><div
              class="right_menu_item_header"></div> <a class="right_menu_item_anchor"
            onclick="load_course_category_tree();">دسته بندی درس ها</a></li>
          <li id="li_courses" class="right_menu_item"><div class="right_menu_item_header"></div>
            <a class="right_menu_item_anchor" onclick="alert('OK');">درس ها</a></li>
          <li id="li_course_plans" class="right_menu_item"><div class="right_menu_item_header"></div>
            <a class="right_menu_item_anchor" onclick="alert('OK');">دوره ها</a></li>
        </ul>
      </nav>
    </div>
  </div>
</body>
</html>