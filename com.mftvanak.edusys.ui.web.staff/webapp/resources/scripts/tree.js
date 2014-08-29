/**
 * Author: Kamran Amini <kam.cpp@gmail.com>
 * 
 * All right are reserved for Mojtama Fanni Tehran - Vanak branch. Copyright
 * 2013.
 */

function load_tree_nodes(sender, tree_name, tree_nodes_url) {
  var div_tree_nodes = document.getElementById("div_" + tree_name
      + "_tree_nodes");
  if (div_tree_nodes) {
    post_req(tree_nodes_url, null, div_tree_nodes, null);
  }
}
function select_tree_node(sender, tree_name, node_id) {
  if (!node_id) {
    return;
  }
  var div_tree = document.getElementById("div_" + tree_name + "_tree");
  if (div_tree) {
    if (div_tree.selected_node_id) {
      div_tree.prev_selected_node_id = div_tree.selected_node_id;
    }
    div_tree.selected_node_id = node_id;
  }
  if (div_tree.prev_selected_node_id) {
    var div_tree_node_text = document.getElementById("div_" + tree_name
        + "_tree_node_text_" + div_tree.prev_selected_node_id);
    if (div_tree_node_text) {
      div_tree_node_text.style.backgroundColor = "white";
    }
  }
  if (div_tree.selected_node_id) {
    var div_tree_node_text = document.getElementById("div_" + tree_name
        + "_tree_node_text_" + div_tree.selected_node_id);
    if (div_tree_node_text) {
      div_tree_node_text.style.backgroundColor = "#d2d6db";
    }
    var input_tree_new_node_parent_id = document.getElementById("input_"
        + tree_name + "_new_node_parent_id");
    if (input_tree_new_node_parent_id) {
      input_tree_new_node_parent_id.value = div_tree.selected_node_id;
    }
    change_button_visibility(sender, tree_name);
  } else {
    var input_tree_new_node_parent_id = document.getElementById("input_"
        + tree_name + "_new_node_parent_id");
    if (input_tree_new_node_parent_id) {
      input_tree_new_node_parent_id.value = "";
    }
  }
  event.stopPropagation();
}
function deselect_tree(sender, tree_name) {
  var div_tree = document.getElementById("div_" + tree_name + "_tree");
  if (div_tree) {
    if (div_tree.selected_node_id) {
      var div_tree_node_text = document.getElementById("div_" + tree_name
          + "_tree_node_text_" + div_tree.selected_node_id);
      if (div_tree_node_text) {
        div_tree_node_text.style.backgroundColor = "white";
      }
    }
    div_tree.selected_node_id = undefined;
    var input_tree_new_node_parent_id = document.getElementById("input_"
        + tree_name + "_new_node_parent_id");
    if (input_tree_new_node_parent_id) {
      input_tree_new_node_parent_id.value = "";
    }

  }
  change_button_visibility(sender, tree_name);
}
function expand_tree_node(sender, tree_name, tree_nodes_url, node_id,
    force_expand) {
  if (!node_id) {
    return;
  }
  var span_tree_node_children_count = document.getElementById("span_"
      + tree_name + "_tree_node_children_count_" + node_id);
  if (span_tree_node_children_count) {
    if (span_tree_node_children_count.innerHTML == 0) {
      return;
    }
  }
  var div_tree_node = document.getElementById("div_" + tree_name
      + "_tree_node_" + node_id);
  if (div_tree_node) {
    if (force_expand) {
      div_tree_node.is_expanded = false;
    }
    if (div_tree_node.is_expanded != undefined) {
      div_tree_node.is_expanded = !div_tree_node.is_expanded;
    } else {
      div_tree_node.is_expanded = true;
    }
  }
  var div_tree_node_image = document.getElementById("div_" + tree_name
      + "_tree_node_image_" + node_id);
  if (div_tree_node_image) {
    div_tree_node_image.className = div_tree_node.is_expanded ? "tree_node_expanded"
        : "tree_node_not_expanded";
  }
  var div_tree_node_children = document.getElementById("div_" + tree_name
      + "_tree_node_children_" + node_id);
  if (div_tree_node_children) {
    if (div_tree_node.is_expanded) {
      url = tree_nodes_url + "?id=" + node_id;
      post_req(url, null, div_tree_node_children, null);
    } else {
      div_tree_node_children.innerHTML = "";
    }
  }
  select_tree_node(sender, tree_name, node_id);
}
function change_button_visibility(sender, tree_name) {
  var div_tree = document.getElementById("div_" + tree_name + "_tree");
  if (div_tree) {
    var li_tree_edit = document
        .getElementById("li_" + tree_name + "_tree_edit");
    var li_tree_remove = document.getElementById("li_" + tree_name
        + "_tree_remove");
    if (div_tree.selected_node_id) {
      li_tree_edit.style.visibility = "visible";
      li_tree_remove.style.visibility = "visible";
    } else {
      li_tree_edit.style.visibility = "hidden";
      li_tree_remove.style.visibility = "hidden";
    }
  }
}
function show_tree_new_node_form_div(sender, tree_name) {
  var div_tree_overlay = document.getElementById("div_" + tree_name
      + "_tree_overlay");
  var div_new_node_form = document.getElementById("div_" + tree_name
      + "_tree_new_node_form");
  div_tree_overlay.style.visibility = "visible";
  div_new_node_form.style.visibility = "visible";
  var inputs = document.getElementById("form_tree_" + tree_name + "_new_node");
  for ( var i = 0; i < inputs.length; i++) {
    if (inputs[i].type == "text" || inputs[i].type == "password") {
      inputs[i].value = "";
    }
  }
}
function hide_tree_new_node_form_div(sender, tree_name) {
  var div_tree_overlay = document.getElementById("div_" + tree_name
      + "_tree_overlay");
  var div_new_node_form = document.getElementById("div_" + tree_name
      + "_tree_new_node_form");
  div_tree_overlay.style.visibility = "hidden";
  div_new_node_form.style.visibility = "hidden";
}
function make_new_tree_node_callback(responseText, caller_element,
    target_element, opts) {
  if (responseText.trim() != "OK") {
    alert(responseText.trim());
    return;
  }
  var sender = opts[0];
  var tree_name = opts[1];
  var tree_nodes_url = opts[2];
  hide_tree_new_node_form_div(sender, tree_name);
  var div_tree = document.getElementById("div_" + tree_name + "_tree");
  if (div_tree.selected_node_id) {
    var span_tree_node_children_count = document.getElementById("span_"
        + tree_name + "_tree_node_children_count_" + div_tree.selected_node_id);
    span_tree_node_children_count.innerHTML++;

    var div_tree_node_image = document.getElementById("div_" + tree_name
        + "_tree_node_image_" + div_tree.selected_node_id);
    div_tree_node_image.className = "tree_node_not_expanded";

    expand_tree_node(sender, tree_name, tree_nodes_url,
        div_tree.selected_node_id, true);
  } else {
    load_tree_nodes(sender, tree_name, tree_nodes_url);
  }
}
function make_new_tree_node(sender, tree_name, tree_nodes_url,
    tree_nodes_add_url) {
  post_form(tree_nodes_add_url, "form_tree_" + tree_name + "_new_node", null,
      tree_name, make_new_tree_node_callback, new Array(sender, tree_name,
          tree_nodes_url));
}