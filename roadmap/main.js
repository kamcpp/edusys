$(document).ready(function() {  
    $("main").css("height", (window.innerHeight - 100) + "px");
    $(window).on('resize', function () {
        $("main").css("height", (window.innerHeight - 100) + "px");
    });
    $(".register-link a").html("برای ثبت نام کلیک کنید ...");
    $(document).tooltip({
        items: "[title], [data-title], .register-link a",
        content: function () {
            var element = $(this);            
            if (element.is("[title]")) {
                return element.attr("title");
            }
            if (element.is("[data-title]")) {
                return element.attr("data-title");
            }
            if(element.is(".register-link a")) {
            	return "برای ثبت نام پس از باز شدن صفحه دوره ها و انتخاب زمان مورد نظر روی لینک <strong>ثبت نام</strong> کلیک کنید.";
            }
        },
    	open: function (event, ui) {
    		ui.tooltip.css("max-width", "500px");
    	}
    });
    $(".course-item").mouseenter(function(e) {
		var id = $(this).attr("data-id");
		$(".course-item circle[data-id='" + id + "']").each(function(index, element) {                        
            $(this).attr("stroke", "orange");    
        });
        $(this).css("cursor", "pointer");
		$("#course-description-" + id).hide();
		$("#course-description-" + id).css('top', e.pageY - 50);
		$("#course-description-" + id).css('left', e.pageX + 10);
		$("#course-description-" + id).css('position', 'absolute');
		$("#course-description-" + id).show();
		
    });
    $(".course-item").mouseleave(function() {
		var id = $(this).attr("data-id");
		$(".course-item circle[data-id='" + id + "']").each(function(index, element) {                        
            $(this).attr("stroke", "gray");
        });
        $(this).css("cursor", "auto");
		$("#course-description-" + id).hide();
    });
	$(".profession-box").mouseenter(function(e) {
		var id = $(this).attr("data-id");
		$("#profession-box-" + id + " rect").each(function(index, element) {
			$(this).attr("data-temp-color", $(this).css("stroke"));
            $(this).css("fill", "orange");
			$(this).css("stroke", "orange");
        });
		$(this).css("cursor", "pointer");		
		$("#profession-description-" + id).hide();
		$("#profession-description-" + id).css('top', e.pageY - 50);
		$("#profession-description-" + id).css('left', e.pageX + 10);
		$("#profession-description-" + id).css('position', 'absolute');
		$("#profession-description-" + id).show();
    });
	$(".profession-box").mouseleave(function(e) {
		var id = $(this).attr("data-id");
		$("#profession-box-" + id + " rect").each(function(index, element) {                        
            $(this).css("fill", $(this).attr("data-temp-color"));
			$(this).css("stroke", $(this).attr("data-temp-color"));
        });
		$(this).css("cursor", "auto");
		$("#profession-description-" + id).hide();
    });
	$(".course-item").click(function() {
		var id = $(this).attr("data-id");

		$("#course-full-description-" + id).show();
        var minimumWidth = 600;
        if($("#course-full-description-" + id).attr("data-actual-width")) {
            minimumWidth = $("#course-full-description-" + id).attr("data-actual-width");
        }
		$("#course-full-description-" + id).dialog({
				position: [($(window).width() / 2) - ($("#course-full-description-" + id).width / 2), 20],
				minWidth: minimumWidth,
				modal: true,
				open: function() {
					$('.ui-widget-overlay').addClass('custom-overlay');
				},
				close: function() {
					$('.ui-widget-overlay').removeClass('custom-overlay');
				}     
		});
		$("#course-full-description-" + id).dialog("open");
	});
	$(".path").mouseenter(function(e) {
	    $(this).css("cursor", "pointer");
	    var category = $(this).attr("data-category");
	    $(".path[data-category='" + category + "']").each(function (index, element) {
	        $(this).attr("data-temp-color", $(this).css("stroke"));
	        $(this).css("stroke", "orange");
	        $(this).css("box-shadow", "0px 0px 5px #fff");
	    });
   	});
   	$(".path").mouseleave(function(e) {
   	    $(this).css("cursor", "auto");
   	    var category = $(this).attr("data-category");
   	    $(".path[data-category='" + category + "']").each(function (index, element) {
   	        $(this).css("stroke", $(this).attr("data-temp-color"));
   	    });
   	});

});  

<!-- Piwik -->
var _paq = _paq || [];
_paq.push(["trackPageView"]);
_paq.push(["enableLinkTracking"]);
(function() {
    var u=(("https:" == document.location.protocol) ? "https" : "http") + "://analytics.mftvanak.com/";
    _paq.push(["setTrackerUrl", u+"piwik.php"]);
    _paq.push(["setSiteId", "1"]);
    var d=document, g=d.createElement("script"), s=d.getElementsByTagName("script")[0]; g.type="text/javascript";
    g.defer=true; g.async=true; g.src=u+"piwik.js"; s.parentNode.insertBefore(g,s);
})();
<!-- End Piwik Code -->
