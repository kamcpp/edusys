$(document)
		.ready(
				function() {

					for (var i = 1; i <= 31; i++) {
						$(".duration-day-from").append(
								"<option value='" + i + "' "
										+ (i == 1 ? "selected" : "") + ">" + i
										+ "</option>");
						$(".duration-day-to").append(
								"<option value='" + i + "' "
										+ (i == 31 ? "selected" : "") + " >"
										+ i + "</option>");
					}

					for (var i = 1; i <= 12; i++) {
						$(".duration-month-from").append(
								"<option value='" + i + "' "
										+ (i == currentMonth ? "selected" : "")
										+ ">" + i + "</option>");
						$(".duration-month-to").append(
								"<option value='" + i + "' "
										+ (i == currentMonth ? "selected" : "")
										+ " >" + i + "</option>");
					}

					for (var i = 1391; i <= 1400; i++) {
						$(".duration-year-from").append(
								"<option value='" + i + "' "
										+ (i == 1393 ? "selected" : "") + ">"
										+ i + "</option>");
						$(".duration-year-to").append(
								"<option value='" + i + "' "
										+ (i == 1393 ? "selected" : "") + " >"
										+ i + "</option>");
					}

					$(
							".duration-year-from, .duration-month-from,"
									+ ".duration-day-from, .duration-year-to,"
									+ ".duration-month-to, .duration-day-to")
							.click(
									function() {
										var group = $(this).attr("data-group");
										$(
												".duration-mode-radio[data-group='"
														+ group + "']").prop(
												"checked", true);
									});

					$(".month-selector").click(
							function() {
								var group = $(this).attr("data-group");
								$(
										".fast-search-mode-radio[data-group='"
												+ group + "']").prop("checked",
										true);
							});

					$("#tabs").jqxTabs({
						width : 850,
						height : 470,
						position : 'top',
						rtl : true
					});

					// $(".jqx-tabs-title-container").css("left", "0");

					$(".produce-report[data-group='first']")
							.click(
									function() {
										if ($(".fast-search-mode-radio[data-group='first']:checked").length > 0) {
											$(
													".month-selector[data-group='first']")
													.find(":selected")
													.each(
															function() {
																if ($(this)
																		.attr(
																				"data-from")) {
																	var from = $(
																			this)
																			.attr(
																					"data-from");
																	var to = $(
																			this)
																			.attr(
																					"data-to");
																	retrieveReport(
																			from,
																			to);
																}
															});
										} else {
											var fromYear = $(
													".duration-year-from[data-group='first'] option:selected")
													.text().substring(2, 4);
											var fromMonth = $(
													".duration-month-from[data-group='first'] option:selected")
													.text();
											var fromDay = $(
													".duration-day-from[data-group='first'] option:selected")
													.text();

											var toYear = $(
													".duration-year-to[data-group='first'] option:selected")
													.text().substring(2, 4);
											var toMonth = $(
													".duration-month-to[data-group='first'] option:selected")
													.text();
											var toDay = $(
													".duration-day-to[data-group='first'] option:selected")
													.text();

											var from = fromYear
													+ "/"
													+ (fromMonth < 10 ? "0"
															: "") + fromMonth
													+ "/"
													+ (fromDay < 10 ? "0" : "")
													+ fromDay;
											var to = toYear + "/"
													+ (toMonth < 10 ? "0" : "")
													+ toMonth + "/"
													+ (toDay < 10 ? "0" : "")
													+ toDay;
											retrieveReport(from, to);
										}
									});
					$(".produce-report[data-group='second']")
							.click(
									function() {
										var deptCode = 0;
										$(".dept-selector[data-group='second']")
												.find(":selected")
												.each(
														function() {
															deptCode = $(this)
																	.attr(
																			"data-code");
														});
										if ($(".fast-search-mode-radio[data-group='second']:checked").length > 0) {
											$(
													".month-selector[data-group='second']")
													.find(":selected")
													.each(
															function() {
																if ($(this)
																		.attr(
																				"data-from")) {
																	var from = $(
																			this)
																			.attr(
																					"data-from");
																	var to = $(
																			this)
																			.attr(
																					"data-to");
																	retrieveRegistrationReport(
																			deptCode,
																			from,
																			to);
																}
															});
										} else {
											var fromYear = $(
													".duration-year-from[data-group='second'] option:selected")
													.text().substring(2, 4);
											var fromMonth = $(
													".duration-month-from[data-group='second'] option:selected")
													.text();
											var fromDay = $(
													".duration-day-from[data-group='second'] option:selected")
													.text();

											var toYear = $(
													".duration-year-to[data-group='second'] option:selected")
													.text().substring(2, 4);
											var toMonth = $(
													".duration-month-to[data-group='second'] option:selected")
													.text();
											var toDay = $(
													".duration-day-to[data-group='second'] option:selected")
													.text();

											var from = fromYear
													+ "/"
													+ (fromMonth < 10 ? "0"
															: "") + fromMonth
													+ "/"
													+ (fromDay < 10 ? "0" : "")
													+ fromDay;
											var to = toYear + "/"
													+ (toMonth < 10 ? "0" : "")
													+ toMonth + "/"
													+ (toDay < 10 ? "0" : "")
													+ toDay;
											retrieveRegistrationReport(
													deptCode, from, to);
										}
									});

					function retrieveReport(dateFrom, dateTo) {
						var dateDuration = dateFrom + "," + dateTo;
						var encodedDateDuration = $.base64.encode(dateDuration);
						var source = {
							datatype : "json",
							datafields : [ {
								name : 'name',
								type : 'string'
							}, {
								name : 'incomeString',
								type : 'string'
							}, {
								name : 'incomeMinusAbortionString',
								type : 'string'
							}, {
								name : 'abortionString',
								type : 'string'
							}, {
								name : 'numberOfStudents',
								type : 'int'
							} ],
							id : 'name',
							url : "report/dept/" + encodedDateDuration
						};
						var dataAdapter = new $.jqx.dataAdapter(source);
						$(".report-grid[data-id='1']").jqxGrid({
							width : 800,
							height : 250,
							source : dataAdapter,
							columnsresize : true,
							showfilterrow : false,
							filterable : false,
							sortable : false,
							rtl : true,
							selectionmode : 'singlecell',
							columns : [ {
								text : 'نام دپارتمان',
								datafield : 'name',
								cellsalign : 'center',
								align : 'center',
								width : 200
							}, {
								text : 'دریافتی',
								datafield : 'incomeString',
								cellsalign : 'center',
								align : 'center',
								width : 150
							}, {
								text : 'انصرافی',
								datafield : 'abortionString',
								cellsalign : 'center',
								align : 'center',
								width : 150
							}, {
								text : 'درآمد خالص',
								datafield : 'incomeMinusAbortionString',
								cellsalign : 'center',
								align : 'center',
								width : 150
							}, {
								text : 'تعداد ثبت نام',
								datafield : 'numberOfStudents',
								cellsalign : 'center',
								align : 'center',
								minwidth : 100
							} ]
						});
					}

					function retrieveRegistrationReport(deptCode, dateFrom,
							dateTo) {
						var dateDuration = deptCode + "," + dateFrom + ","
								+ dateTo;
						var encodedDateDuration = $.base64.encode(dateDuration);
						var source = {
							datatype : "json",
							datafields : [ {
								name : 'registrationStatus',
								type : 'string'
							}, {
								name : 'name',
								type : 'string'
							}, {
								name : 'className',
								type : 'string'
							}, {
								name : 'phone',
								type : 'string'
							}, {
								name : 'emergencyPhone',
								type : 'string'
							}, {
								name : 'paymentDate',
								type : 'string'
							}, {
								name : 'paid',
								type : 'string'
							}, {
								name : 'payment',
								type : 'string'
							}, {
								name : 'discount',
								type : 'string'
							}, {
								name : 'abortionDate',
								type : 'string'
							}, {
								name : 'abortionPayment',
								type : 'string'
							} ],
							url : "report/reg/" + encodedDateDuration
						};
						var dataAdapter = new $.jqx.dataAdapter(source);
						$(".report-grid[data-id='2']").jqxGrid({
							width : 800,
							source : dataAdapter,
							columnsresize : true,
							showfilterrow : true,
							filterable : true,
							sortable : true,
							rtl : true,
							selectionmode : 'singlecell',
							columns : [ {
								text : 'نام',
								datafield : 'name',
								cellsalign : 'right',
								align : 'center',
								width : 150
							}, {
								text : 'دوره',
								datafield : 'className',
								cellsalign : 'right',
								align : 'center',
								width : 350
							}, {
								text : 'تاریخ پرداخت',
								datafield : 'paymentDate',
								cellsalign : 'center',
								align : 'center',
								minwidth : 100
							}, {
								text : 'قابل پرداخت',
								datafield : 'payment',
								cellsalign : 'center',
								align : 'center',
								minwidth : 100
							}, {
								text : 'تخفیف',
								datafield : 'discount',
								cellsalign : 'center',
								align : 'center',
								minwidth : 100
							}, {
								text : 'وضعیت',
								datafield : 'registrationStatus',
								align : 'center',
								width : 70
							}, {
								text : 'تلفن',
								datafield : 'phone',
								cellsalign : 'center',
								align : 'center',
								width : 100
							}, {
								text : 'تلفن اظطراری',
								datafield : 'emergencyPhone',
								cellsalign : 'center',
								align : 'center',
								width : 100
							}, {
								text : 'پرداخت شده',
								datafield : 'paid',
								cellsalign : 'center',
								align : 'center',
								minwidth : 100
							}, {
								text : 'تاریخ انصراف',
								datafield : 'abortionDate',
								cellsalign : 'center',
								align : 'center',
								minwidth : 100
							}, {
								text : 'مبلغ انصراف',
								datafield : 'abortionPayment',
								cellsalign : 'center',
								align : 'center',
								minwidth : 100
							} ]
						});
					}

				});