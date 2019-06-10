$.extend($.fn.validatebox.defaults.rules, {
    idcard: { // 验证身份证 
        validator: function(value) {
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
        },
        message: '身份证号码格式不正确'
    },
    minLength: {
        validator: function(value, param) {
            return value.length >= param[0];
        },
        message: '请输入至少{0}个字符.'
    },
    maxLength: {
        validator: function(value, param) {
            return value.length <= param[0];
        },
        message: '输入字符不超过{0}个字符.'
    },
    length: {
        validator: function(value, param) {
            var len = $.trim(value).length;
            return len >= param[0] && len <= param[1];
        },
        message: "输入内容长度必须介于{0}和{1}之间."
    },
    fixLength: {
        validator: function(value, param) {
            var len = $.trim(value).length;
            return len == param[0];
        },
        message: "输入内容长度必须为{0}."
    },
    xy: { //坐标验证
        validator: function(value) {
            return /\d{1,3}.\d{4,6}/i.test(value);
        },
        message: '坐标格式不正确'
    },
    phone: { // 验证电话号码 
        validator: function(value) {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message: '电话格式不正确,请使用下面格式:027-88888888'
    },
    mobile: { // 验证手机号码 
        validator: function(value) {
            return /^1[3-9]\d{9}$/i.test(value);
        },
        message: '手机号码格式不正确'
    },
    phoneOrMobile: {
        validator: function(value) {
            var rex = /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$|^1[3-9]\d{9}$/;
            return rex.test(value);
        },
        message: '请输入正确电话或手机格式,电话格式:027-88888888'
    },
    intOrFloat: { // 验证大于0的整数或小数
        validator: function(value) {
            return /^([1-9]\d*)+(\.\d+)?$/i.test(value);
        },
        message: '请输入大于0的整数或者小数'
    },
    currency: { // 验证货币 
        validator: function(value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message: '货币格式不正确'
    },
    qq: { // 验证QQ,从10000开始 
        validator: function(value) {
            return /^[1-9]\d{4,9}$/i.test(value);
        },
        message: 'QQ号码格式不正确'
    },
    number: {
        validator: function(value, param) {
            return /^[0-9]+.?[0-9]*$/.test(value);
        },
        message: '请输入数字'
    },
    integer: { // 验证整数 
        validator: function(value) {
            return /^[+]?[1-9]+\d*$/i.test(value);
        },
        message: '请输入整数'
    },
    range: {
        validator: function(value, param) {
            if (/^[1-9]\d*$/.test(value)) {
                return value >= param[0] && value <= param[1]
            } else {
                return false;
            }
        },
        message: '输入的数字在{0}到{1}之间'
    },
    age: { // 验证年龄
        validator: function(value) {
            return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i.test(value);
        },
        message: '年龄必须是0到120之间的整数'
    },
    chinese: { // 验证中文 
        validator: function(value) {
            return /^[\Α-\￥]+$/i.test(value);
        },
        message: '请输入中文'
    },
    english: { // 验证英语 
        validator: function(value) {
            return /^[A-Za-z]+$/i.test(value);
        },
        message: '请输入英文'
    },
    unnormal: { // 验证是否包含空格和非法字符 
        validator: function(value) {
            return /.+/i.test(value);
        },
        message: '输入值不能为空和包含其他非法字符'
    },
    username: { // 验证用户名 
        validator: function(value) {
            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
        },
        message: '用户名不合法（字母开头，允许6-16字符，允许字母数字下划线）'
    },
    faxno: { // 验证传真 
        validator: function(value) {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message: '传真号码不正确'
    },
    zip: { // 验证邮政编码 
        validator: function(value) {
            return /^[1-9]\d{5}$/i.test(value);
        },
        message: '邮政编码格式不正确'
    },
    ip: { // 验证IP地址 
        validator: function(value) {
            return /d+.d+.d+.d+/i.test(value);
        },
        message: 'IP地址格式不正确'
    },
    name: { // 验证姓名，可以是中文或英文 
        validator: function(value) {
            return /^[\Α-\￥]+$/i.test(value) | /^\w+[\w\s]+\w+$/i.test(value);
        },
        message: '请输入姓名'
    },
    date: { // 验证姓名，可以是中文或英文 
        validator: function(value) {
            //格式yyyy-MM-dd或yyyy-M-d
            return /^(?:(?!0000)[0-9]{4}([-]?)(?:(?:0?[1-9]|1[0-2])\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\1(?:29|30)|(?:0?[13578]|1[02])\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-]?)0?2\2(?:29))$/i.test(value);
        },
        message: '请输入合适的日期格式'
    },
    msn: {
        validator: function(value) {
            return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);
        },
        message: '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
    },
    equalTo: {
        validator: function(value, param) {
            return value == $(param[0]).val();
        },
        message: '两次输入的字符不一至'
    },
    same: {
        validator: function(value, param) {
            if ($("#" + param[0]).val() != "" && value != "") {
                return $("#" + param[0]).val() == value;
            } else {
                return true;
            }
        },
        message: '两次输入的密码不一致'
    },
    notemptyorblank: { //去掉所有空格后再判断是否为空
        validator: function(value) {
            return !(value.replace(/(^\s*)|(\s*$)/g, "") == "");
        },
        message: '输入值不能为空或空格'
    },
    //select即选择框的验证 
    selectValid: {
        validator: function(value, param) {
            return $(param[0]).find("option:contains('" + value + "')").val() != '';
        },
        message: '该输入项为必填项'
    }
});