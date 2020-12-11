$(function () {
  $(document).ajaxError(function (e, xhr) {
    alert("操作失败:" + JSON.parse(xhr.responseText).data);
  });

  $("#quit-btn").click(function () {
    var status = confirm("确定退出 ?");
    if (!status) {
      return false;
    }

    $.ajax({
      type: 'POST',
      contentType: "application/json;charset=UTF-8",
      url: "server/user/quit",
      success: function (msg) {
        window.location.href = "login.html";
      }
    });
  });

});

function bindFormAddSwitch() {
  $("#add-btn").click(function () {
    $('#modify-form')[0].reset();
    $("#flag").val("add");
    $("#modify-section").show();
    $("#list-section").hide();
  });
}

function bindFormBackSwitch() {
  $("#back-btn").click(function () {
    $('#modify-form')[0].reset();
    $("#modify-section").hide();
    $("#list-section").show();
  });
}

/*
将指定id的form 内容转换成json字符串
返回json字符串
 */
function form2JsonString(formId) {
  // 序列化成 key=value&key1=value1 的字符串
  let paramArray = $('#' + formId).serializeArray();
  let jsonObj = {};
  $(paramArray).each(function () {
    jsonObj[this.name] = this.value;
  });
  // json对象再转换成json字符串
  return JSON.stringify(jsonObj);
}

function getURLParameter(sParam) {
  let sPageURL = window.location.search.substring(1);
  let sURLVariables = sPageURL.split('&');
  for (let i = 0; i < sURLVariables.length; i++) {
    let sParameterName = sURLVariables[i].split('=');
    if (sParameterName[0] === sParam) {
      return sParameterName[1];
    }
  }
}

function getCurrentUser() {
  $.ajax({
    type: "post",
    contentType: "application/json;charset=UTF-8",
    url: "server/user/getInfo",
    success: function (result) {
      if (!$.isEmptyObject(result)) {

        $("#welcome-user-name").text(result.data);
      } else {
        alert("查询用户失败");
      }
    }
  });
}

function buildRow(obj, nodeTemplate) {
  let lineNode = nodeTemplate.clone();
  // 找到以属性名作为class的标签，将text替换为属性的值
  for (let prop in obj) {
    lineNode.find("." + prop).text(obj[prop]);
    lineNode.show(); // clone 的节点默认是隐藏的，需要让添加的行显示
  }
  return lineNode;
}

function appendList(result) {
  let nodeTemplate = $("#list-form-title").clone();
  // clone 之后不需要id属性
  nodeTemplate.removeAttr("id");
  // result 返回的是一个 obj 数组，这里遍历数组，将每个provider添加到表格中
  for (let index in result) {
    let lineNode = buildRow(result[index], nodeTemplate);
    $("#list-body").append(lineNode);
  }
}

function refreshList(module) {
  $.ajax({
    type: "post",
    contentType: "application/json;charset=UTF-8",
    url: "server/" + module + "/list",
    data: form2JsonString("search-form"),
    success: function (result) {
      // 清空表格
      $("#list-form-title").nextAll().remove();
      appendList(result.data);
      $("#modify-section").hide();
      $("#list-section").show();
    }
  });
}

function postModifyForm(module, updateFlag) {
  let url = updateFlag === "update" ? "server/" + module + "/update" : "server/"
      + module + "/add";
  $.ajax({
    type: "post",
    contentType: "application/json;charset=UTF-8",
    url: url,
    data: form2JsonString("modify-form"),
    success: function () {
      refreshList(module);
    }
  });
}

function postDeleteRow(module, id) {
  $.ajax({
    type: "post",
    contentType: "application/json;charset=UTF-8",
    url: "server/" + module + "/delete",
    data: JSON.stringify({"id": id}),
    success: function (result) {
      refreshList(module);
    }
  });
}
