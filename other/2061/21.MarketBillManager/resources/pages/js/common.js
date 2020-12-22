$(function () {
  $(document).ajaxError(function (e, xhr) {
    alert("操作失败:" + xhr.responseText);
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

  getCurrentUser();
});

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

        $("#welcome-user-name").text(result.name);
        // $("#flag").val(id);
        // let lineNode = $("tbody");
        // for (let prop in result) {
        //   // 找到以属性名作为css类的div，将内容替换为属性的值
        //   if (prop === "isPay") {
        //     lineNode.find("[name='" + prop + "']").each(function () {
        //       $(this).prop("checked", $(this).val() === result[prop] + "");
        //     });
        //   } else if (prop === "providerName") {
        //     lineNode.find("[name=provider]'").val([result[prop]]);
        //   } else {
        //     lineNode.find("[name='" + prop + "']").val(result[prop]);
        //   }
        // }
      } else {
        alert("查询用户失败");

      }
    }
  });
}