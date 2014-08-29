/**
 * Author: Kamran Amini <kam.cpp@gmail.com>
 * 
 * All right are reserved for Mojtama Fanni Tehran - Vanak branch. Copyright
 * 2013.
 */

function load_home() {
  var div_content_main_el = document.getElementById("div_content_main");
  if (div_content_main_el) {
    div_content_main_el.innerHTML = "";
  }
}
function course_category_tree_callback(responseText, caller_element,
    target_element) {
  if (!responseText) {
    return;
  }
  target_element.innerHTML = responseText;
  load_tree_nodes(this, 'course_category', 'ajax/course_category/tree/nodes');
  change_button_visibility(this, 'course_category');
}
function load_course_category_tree(id) {
  url = "ajax/course_category/tree";
  if (id) {
    url += "?id=" + id;
  }
  var div_cc = document.getElementById("li_course_categories");
  var div_content_main_el = document.getElementById("div_content_main");
  if (div_cc && div_content_main_el) {
    post_req(url, div_cc, div_content_main_el, course_category_tree_callback);
  }
}