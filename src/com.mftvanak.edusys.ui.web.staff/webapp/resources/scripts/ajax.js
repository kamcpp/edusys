/**
 * Author: Kamran Amini <kam.cpp@gmail.com>
 * 
 * All right are reserved for Mojtama Fanni Tehran - Vanak branch. Copyright
 * 2013.
 */

function get_xml_http_obj() {
  var xmlhttp;
  if (window.XMLHttpRequest) {
    xmlhttp = new XMLHttpRequest();
  } else {
    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  return xmlhttp;
}
function make_req(method, url, caller_element, target_element, callback, opts) {
  var ajax_loader_el = null;
  if (caller_element) {
    if (!document.getElementById("img_ajax_loader")) {
      ajax_loader_el = document.createElement("img");
      ajax_loader_el.id = "img_ajax_loader";
      ajax_loader_el.src = "images/ajax-loader.gif";
      ajax_loader_el.style.marginTop = "7px";
      ajax_loader_el.style.marginRight = "10px";
      ajax_loader_el.style.visibility = "visible";
      caller_element.appendChild(ajax_loader_el);
    } else {
      return;
    }
  }
  var xmlhttp = get_xml_http_obj();
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
      if (xmlhttp.responseText.indexOf("input_login_page") >= 0) {
        window.location = "login";
      } else {
        if (ajax_loader_el) {
          caller_element.removeChild(ajax_loader_el);
        }
        if (callback) {
          callback(xmlhttp.responseText, caller_element, target_element, opts);
        } else {
          if (xmlhttp.responseText) {
            target_element.innerHTML = xmlhttp.responseText;
          }
        }
      }
    }
  };
  xmlhttp.open(method, url, true);
  xmlhttp.setRequestHeader("Content-type", "text/html; charset=UTF-8");
  xmlhttp.send();
}
function post_req(url, caller_element, target_element, callback, opts) {
  make_req("POST", url, caller_element, target_element, callback, opts);
}
function get_req(url, caller_element, target_element, callback, opts) {
  make_req("GET", url, caller_element, target_element, callback, opts);
}
function post_form(url, form_id, caller_element, target_element, callback, opts) {
  var form_tree_new_node = document.getElementById(form_id);
  var inputs = form_tree_new_node.getElementsByTagName("input");

  var params = "";
  for ( var i = 0; i < inputs.length; i++) {
    if (params) {
      params += "&";
    }
    params += inputs[i].name + "=" + inputs[i].value;
  }
  var ajax_loader_el = null;
  if (caller_element) {
    if (!document.getElementById("img_ajax_loader")) {
      ajax_loader_el = document.createElement("img");
      ajax_loader_el.id = "img_ajax_loader";
      ajax_loader_el.src = "images/ajax-loader.gif";
      ajax_loader_el.style.marginTop = "7px";
      ajax_loader_el.style.marginRight = "10px";
      ajax_loader_el.style.visibility = "visible";
      caller_element.appendChild(ajax_loader_el);
    } else {
      return;
    }
  }
  var xmlhttp = get_xml_http_obj();
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
      if (xmlhttp.responseText.indexOf("input_login_page") >= 0) {
        window.location = "login";
      } else {
        if (ajax_loader_el) {
          caller_element.removeChild(ajax_loader_el);
        }
        if (callback) {
          callback(xmlhttp.responseText, caller_element, target_element, opts);
        } else {
          if (xmlhttp.responseText) {
            target_element.innerHTML = xmlhttp.responseText;
          }
        }
      }
    }
  };
  xmlhttp.open("POST", url, true);
  xmlhttp.setRequestHeader("Content-type",
      "application/x-www-form-urlencoded;  charset=UTF-8");
  xmlhttp.send(params);
}