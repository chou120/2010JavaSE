function getCurrentDateTime() {
  var date = new Date();
  var year = date.getFullYear();
  var month = date.getMonth() + 1;
  var day = date.getDate();
  var hours = date.getHours();
  var minutes = date.getMinutes();
  var seconds = date.getSeconds();
  return year + "-" + formatZero(month) + "-" + formatZero(day) + " "
      + formatZero(hours) + ":" + formatZero(minutes) + ":" + formatZero(
          seconds);
}

function getCurrentDate() {
  var date = new Date();
  var year = date.getFullYear();
  var month = date.getMonth() + 1;
  var day = date.getDate();
  return year + "-" + formatZero(month) + "-" + formatZero(day);
}

function formatZero(n) {
  if (n >= 0 && n <= 9) {
    return "0" + n;
  } else {
    return n;
  }
}

$.extend($.fn.datagrid.defaults, {
  onLoadError: function (data) {
    $.messager.alert('提示信息', '请求异常', 'info');
    $(this).datagrid('loadData', {total: 0, rows: []});
  },
  loadFilter: function (data) {
    if (data.code != 0) {
      var push = {
        "total": 0,
        "rows": ""// 当为[]会出现空的两行
      };
      $.messager.alert("请求失败", data.message);
      return push;
    } else {
      return data;
    }
  },
});