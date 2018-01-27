<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/demo.css">
<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
   /* var contextPath="<%=request.getContextPath()%>";*/
    $(function(){
        $("ul.myTree").each(function(){
            var url="doTReeNodeList?parentNodeId="+$(this).attr("id");
            $(this).tree({
                url:url,
                onLoadSuccess:function(){
                    $("ul.myTree").tree("options").url="doTReeNodeList";
                },
                onSelect:function(node){
                    var text=node.text;
                    var url=node.attributes.url;
                    if(!url) return false;
                    <!-- url=contextPath+url;-->
                    openTag(text,url);

                }
            });
        });
    });

    function openTag(text,url){
        if(!$("#myTabs").tabs("exists",text)){
            var content = '<iframe scrolling="no" frameborder="0" src="' + url + '" style="width:100%;height: 100%;"></iframe>';
            $('#myTabs').tabs('add', {
                title: text,
                selected: true,
                closable: true,
                content: content,
            });
        }else{
            $("#myTabs").tabs("select",text);
        }
    }
</script>
</head>

<body class="easyui-layout">
<div data-options="region:'north',split:false" style="height:100px;background-color: burlywood"></div>  </div>
<div data-options="region:'west',split:false" class="easyui-accordion" style="width:20%;" >
    <c:import url="doTReeNodeList">
        <c:param name="forward">null</c:param>
    </c:import>

    <c:forEach var="v" items="${treeNodes}">
        <div title="${v.text}">
            <ul class="myTree" id="${v.id}"></ul>
        </div>
    </c:forEach>

</div>
<div id="myTabs" data-options="region:'center',narrow:true" class="easyui-tabs" style="background:#eee;">
    <div title="菜单" data-options="closable:true" style="padding:20px;">
    </div>
</div>
</body>
</html>
