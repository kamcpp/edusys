<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String baseUrl = "http://www.jqwidgets.com/jquery-widgets-demo";
	String jQueryUrl = "http://code.jquery.com/jquery-1.11.1.min.js";
	// String jQueryBase64Url = "https://raw.githubusercontent.com/yckart/jquery.base64.js/master/jquery.base64.js";
	String jQueryBase64Url = "scripts/jquery.base64.min.js";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ریز کارکرد دپارتمان - گزارشات قیاس - دپارتمان وب و برنامه
	نویسی - مجتمع فنی تهران نمایندگی ونک</title>
<link type="text/css" rel="stylesheet" href="styles/fonts.css" />
<link type="text/css" rel="stylesheet" href="styles/main.css" />
<link type="text/css" rel="stylesheet"
	href="<%=baseUrl%>/jqwidgets/styles/jqx.base.css" />
<script type="text/javascript" src="js/init"></script>
<script type="text/javascript" src="<%=jQueryUrl%>"></script>
<script type="text/javascript" src="<%=jQueryBase64Url%>"></script>
<script type="text/javascript" src="<%=baseUrl%>/jqwidgets/jqxcore.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxscrollbar.js"></script>
<script type="text/javascript" src="<%=baseUrl%>/jqwidgets/jqxmenu.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxlistbox.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxdropdownlist.js"></script>
<script type="text/javascript" src="<%=baseUrl%>/jqwidgets/jqxtabs.js"></script>
<script type="text/javascript" src="<%=baseUrl%>/jqwidgets/jqxgrid.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxgrid.sort.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxgrid.pager.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxgrid.selection.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxgrid.columnsresize.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxgrid.edit.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxgrid.filter.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxgrid.storage.js"></script>
<script type="text/javascript"
	src="<%=baseUrl%>/jqwidgets/jqxgrid.columnsreorder.js"></script>
<script type="text/javascript" src="<%=baseUrl%>/jqwidgets/jqxdata.js"></script>
<script type="text/javascript" src="<%=baseUrl%>/jqwidgets/jqxpanel.js"></script>
<script type="text/javascript" src="scripts/main.js"></script>
</head>
<body>
	<div id="topline">
		<div id="dept-text">مجتمع فنی تهران نمایندگی ونک - دپارتمان وب و
			برنامه نویسی - گزارشات قیاس - ریز کارکرد دپارتمان</div>
	</div>
	<div id="main">
		<div id="report-panel">
			<div id="tabs">
				<ul>
					<li>گزارش کارکرد دپارتمان</li>
					<li>گزارش ریز افراد ثبت نامی</li>
				</ul>
				<div class="tab-data">
					<input type="radio" name="mode" class="fast-search-mode-radio"
						data-group="first" checked /> ماه مورد نظر <select
						class="month-selector" data-group="first">
						<%
							String[] months = new String[] { "فروردین", "اردیبهشت", "خرداد",
									"تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی",
									"بهمن", "اسفند" };

							Calendar today = Calendar.getInstance();
							for (int i = 1; i <= 12; i++) {
								String month = i < 10 ? "0" + i : "" + i;
								String endDay = "31";
								if (i >= 7 && i <= 12) {
									endDay = "30";
								}
								out.print("<option data-from='93/"
										+ month
										+ "/01' data-to='93/"
										+ month
										+ "/"
										+ endDay
										+ "'"
										+ (today.get(Calendar.MONTH) == i + 1 ? " selected"
												: "") + ">" + months[i - 1] + "</option>");
							}
						%>
					</select> <br /> <input type="radio" name="mode"
						class="duration-mode-radio" data-group="first" /> از <select
						class="duration-day-from" data-group="first">
					</select> <select class="duration-month-from" data-group="first">
					</select> <select class="duration-year-from" data-group="first">
					</select> تا <select class="duration-day-to" data-group="first">
					</select> <select class="duration-month-to" data-group="first">
					</select> <select class="duration-year-to" data-group="first">
					</select> <br />
					<button class="produce-report" data-group='first'>تولید
						گزارش کارکرد دپارتمان</button>
					<div class="report-grid" data-id="1"
						style="margin-top: 20px; direction: ltr;"></div>
					<br /> <br />
				</div>
				<div class="tab-data">
					<input type="radio" name="mode2" class="fast-search-mode-radio"
						data-group="second" checked /> ماه مورد نظر <select
						class="month-selector" data-group="second">
						<%
							for (int i = 1; i <= 12; i++) {
								String month = i < 10 ? "0" + i : "" + i;
								String endDay = "31";
								if (i >= 7 && i <= 12) {
									endDay = "30";
								}
								out.print("<option data-from='93/"
										+ month
										+ "/01' data-to='93/"
										+ month
										+ "/"
										+ endDay
										+ "'"
										+ (today.get(Calendar.MONTH) == i + 1 ? " selected"
												: "") + ">" + months[i - 1] + "</option>");
							}
						%>
					</select> <br /> <input type="radio" name="mode2"
						class="duration-mode-radio" data-group="second" /> از <select
						class="duration-day-from" data-group="second">
					</select> <select class="duration-month-from" data-group="second">
					</select> <select class="duration-year-from" data-group="second">
					</select> تا <select class="duration-day-to" data-group="second">
					</select> <select class="duration-month-to" data-group="second">
					</select> <select class="duration-year-to" data-group="second">
					</select> <br /> دپارتمان <select class="dept-selector" data-group="second">
						<option data-code="56">وب و برنامه نویسی</option>
						<option data-code="58">فرهنگ و هنر</option>
						<option data-code="54">زبان</option>
						<option data-code="53">فنی و مهندسی</option>
						<option data-code="55">گرافیک و انیمیشن</option>
						<option data-code="57">شبکه و سخت افزار</option>
						<option data-code="59">معماری</option>
					</select> <br />
					<button class="produce-report" data-group='second'>تولید
						گزارش ریز افراد ثبت نامی</button>
					<div class="report-grid" data-id="2"
						style="margin-top: 20px; direction: ltr;"></div>
					<br /> <br />
				</div>
			</div>
		</div>

	</div>
</body>
</html>