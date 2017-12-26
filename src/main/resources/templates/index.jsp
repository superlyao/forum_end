<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%
    Date dateTime = new Date();
    SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyyMMddhhmmss");
    pageContext.setAttribute("timestamp", fmt.format(dateTime));
    pageContext.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="icon" href="${ctx}/img/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="${ctx}/img/favicon.ico" type="image/x-icon"/>
    <title>CCM 登录</title>
    <!--start:css-->
    <link type="text/css" rel="stylesheet" href="${ctx}/css/ccm/ccm-login.css?v=1.01"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/passwordevaluator/jquery.pstrengthEvaluator.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/browerUtil.css">
    <script type="text/javascript" src="${ctx}/lib/jquery.min.js"></script>
    <script type="text/javascript">
        var ctx = "${ctx}";
        var errInfo = "${errInfo}";
        var userId = "${userId}";
        var test = 'test';
        $(function () {
            $("input[name=newpassword]").psstrength({sameValue: '${userId}'});
        });
    </script>
</head>
<body>
<div class="unsupported-browser" id="unsupported">
  <div class="container clearfix">
    <button class="btn btn-danger" id="ignoreBtn">忽略</button>
    <a class="btn" href="../supported-browsers.html" target="_blank">了解更多</a>
    <h5>请注意，CCM 不再支持旧版本（IE10以下）的 Internet Explorer</h5>
    <p>我们建议升级到最新的 <a href="https://support.microsoft.com/zh-cn/help/17621/internet-explorer-downloads" target="_blank">Internet Explorer 11</a>,
      <a href="https://www.microsoft.com/en-us/windows/microsoft-edge" target="_blank">Microsoft
        Edge</a>, <a href="http://rj.baidu.com/soft/detail/14744.html" target="_blank">Google Chrome</a>, 或 <a
        href="https://mozilla.org/firefox/" target="_blank">Firefox</a>.</p>
    <p>如果您使用 IE10，请确保关闭 <a
      href="https://support.microsoft.com/zh-cn/help/17472/windows-internet-explorer-11-fix-site-display-problems-compatibility-v" target="_blank">
      "Compatibility View（兼容性视图）"</a>.</p>
  </div>
</div>
<div class="unsupported-browser" id="suggest">
  <div class="container clearfix">
    <button class="btn btn-danger" id="suggestBtn">忽略</button>
    <button class="btn btn-danger" id="suggestBtnNo">不再提示</button>
    <a class="btn" href="../supported-browsers.html" target="_blank">了解更多</a>
    <h5>为了更好的用户体验，我们建议使用非 IE 浏览器</h5>
    <p>我们建议使用最新的 <a href="https://www.microsoft.com/en-us/windows/microsoft-edge" target="_blank">Microsoft
      Edge</a>, <a href="http://rj.baidu.com/soft/detail/14744.html" target="_blank">Google Chrome</a>, 或 <a
      href="https://mozilla.org/firefox/" target="_blank">Firefox</a>.</p>
  </div>
</div>
<form action="${ctx}/ccmLogin" method="post">
    <div class="content">
        <div class="main-cont">
            <%--<h1><a href=""><img src="${ctx}/img/login/logo.png"/></a></h1>--%>
            <div class="loginBox">
                <div class="loginPart">
                    <div class="error hidden">用户名或密码错误</div>
                    <h2>登录CCM</h2>
                    <%
                        String userCcmId = (String)request.getAttribute("userId");
                    if(userCcmId == null){
                    %>
                    <input type="text" id="ccmUserId" class="text user-name" placeholder="用户名" name="userId">
                    <input type="password" class="text password" placeholder="密码">
                    <%
                        }else {
                    %>
                    <input type="text" id="ccmUserId" class="text user-name" placeholder="用户名" name="userId" value="${userId}">
                    <input type="password" class="text password" placeholder="密码"  value="${passWord}">
                    <%
                        }
                    %>

                    <input type="hidden" id="password" name="password" id="password">
                    <input type="text" class="text yanzheng" placeholder="验证码" name="verify">
                    <img style="width: 79px; height:34px;cursor: pointer;" title="看不清？点击换一个" class="yanzhengImg"
                         src="${ctx}/login/authImage" id="verifycode"/>
                    <p class="changeImg"
                       onclick="document.getElementById('verifycode').src='${ctx}/login/authImage?v='+new Date().getTime()">
                        换一张</p>
                    <input type="submit" class="loginBtn" value="登    录" style="margin-top: 25px">
                    <input type="button" class="resetBtn" value="重 置" style="margin-top: 25px">
                </div>
            </div>
        </div>
        <div style="display: none;">ajax跳转登录页面隐藏标记</div>
    </div>
</form>
<div class="comRight">
    <p>
        <span>中国民航信息网络股份有限公司版权所有</span>
        <span>Copyright 2015 Travelsky Technology Limited</span><br>
        <span>京ICP备06014661号-1        京公网安备11010102000528号</span>
    </p>
</div>
<div>
    <div id="popWindow" class="popWindow">
    </div>
    <div id="maskLayerGai" class="maskLayer newDIv newH" style="top:263px;">
        <form action="${pageContext.request.contextPath }/ccmLogin/changepasswordLogin" method="post"
              name="changePasswordForm">
            <div class="newDivtitle" style="background: #4eb3f1 none repeat scroll 0 0;">
                修改密码
                <img onclick="closeDiv()" src="${ctx}/img/closeIcon.png">
            </div>

            <div class="newDivCon0">
                <div class="ts">
                    <label class="first" style="color: red;">提示：您的密码为弱密码</label>
                    <p>
                        <label class="next">1、密码长度应该不少于8位;</label>
                    </p>
                    <p>
                        <label class="next">2、密码应为数字、字母的组合;</label>
                    </p>
                    <p>
                        <label class="next">3、密码不能包含用户名;</label>
                    </p>
                    <p>
                        <label class="next">4、不能含有3个以上连续相同值;</label>
                    </p>
                    <p>
                        <label class="next">5、不能含有3个以上连续数字或字母.</label>
                    </p>
                </div>
                <div class="dwmcP" style="height: auto">
                    <div class="h37">
                        <span>原始密码：</span>
                        <input class="jobNum" type="password" name="orgpassword">
                    </div>
                    <div class="h37" style="width: 430px;">
                        <span>新 密 码：</span>
                        <input class="jobNum" type="password" name="newpassword">
                        <div class="passwordStrength">
                            <span id="lv0" style=" margin-left: 10px;">弱</span>
                            <span id="lv1" style=" margin-left: 0px;">中</span>
                            <span class="last" id="lv2" style=" margin-left: 0px;">强</span>
                        </div>
                    </div>
                    <div class="h37">
                        <span>重复密码：</span>
                        <input class="jobNum" type="password" name="confirmpassword">
                    </div>
                </div>
                <div>
                    <input id="submit_userpassword_reset" class="cancelBtn" type="button" onclick="closeDiv()"
                           value="取消" style="margin-right: 80px;">
                    <input id="submit_userpassword_change" class="newDIVsBtn" type="button" value="保存"
                           style="margin-right: 40px;">
                    <%-- <input type="hidden" name="userIdChangePW"  value="${userId}">--%>

                </div>
            </div>
        </form>
    </div>
    <div id="accountAuditMaskLayer" class="maskLayer newDIv newH" style="width: 650px;top: 200px; left: 30%;">
        <form action="${pageContext.request.contextPath }/ccmLogin/accountAudit" method="post" name="accountAuditForm">
            <div class="newDivtitle" style="background: #4eb3f1 none repeat scroll 0 0;width: 630px;">
                帐号审计
                <img onclick="logout()" src="${ctx}/img/closeIcon.png" style="left: 610px;">
            </div>
            <div class="newDivCon0">
                <div class="ts">
                    <label class="first" style="color: red;">提示：请点击保存进行帐号审计，确保帐号仍在使用</label>
                    <p>
                        <label class="next">1、审计时可以修改：邮箱、电话;</label>
                    </p>
                    <p>
                        <label class="next">2、点击保存即可完成帐号审计，不强制修改信息;</label>
                    </p>
                    <p>
                        <label class="next">3、点击还原，还原初始值.</label>
                    </p>
                </div>
                <div class="dwmcP" style="height: auto">
                    <table style="margin-bottom: 20px;width: 650px">
                        <tr>
                            <td width="25%">
                                <span>用户名:</span>
                                <span style="margin-left: 5px;">${fn:escapeXml(ccmUser.userName)}</span>
                            </td>
                            <td>
                                <span>邮箱:</span>
                                <input type="text" class="jobNum" value="${fn:escapeXml(ccmUser.email)}" name="email"/>
                            </td>
                            <td>
                                <span>电话:</span>
                                <input type="text" name="tel" value="${fn:escapeXml(ccmUser.tel)}" class="jobNum"/>
                            </td>
                        </tr>
                    </table>
                    <div style="margin-left: 150px">
                        <input type="hidden" name="userId" value="${user.userId}">
                        <input id="submit_account_audit_reset" class="cancelBtn" type="reset" value="还原"
                               style="margin-right: 40px;">
                        <input id="submit_ccm_account_audit_change" class="newDIVsBtn" type="button" value="保存"
                               style="margin-right: 40px;">
                    </div>
                </div>
            </div>
        </form>
        <form action="${pageContext.request.contextPath }/ccmLogout" method="get" name="logoutForm">
            <%-- <input type="hidden" name="userId"  value="${user.userId}"> --%>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/lib/browserUtil.js" language="javascript"></script>
<script type="text/javascript" src="${ctx}/lib/des.js" language="javascript"></script>
<script src="${ctx}/lib/ccmLogin.js?timestamp=${timestamp}" type="text/javascript" language="javascript"></script>
<script src="${ctx}/lib/jquery.pstrengthEvaluator.js" type="text/javascript" language="javascript"></script>


</html>
