<jsp:include page="head.jsp"></jsp:include>
<h1>Error</h1>
<div style="width:500px"></div>
<jsp:include page="foot.jsp"></jsp:include>


<script language="javascript">
$(document).ready(function() {
	 /*$.ajax({
		url:"http://localhost:8080/zyhCityTcp/resource",
		type:"get",
		dataType:"json",
		success:show
	});*/
	$.getJSON("http://localhost:8080/zyhCityTcp/resource",
		function(data){
			/* $("#resources").append("<ul class=\"easyui-tree\">");
			for(var i = 0;i < data.obj.length;i ++){
				$("#resources").append("<li><span>"+data.obj[i].text+"</span>");
				//console.log("data",msg.obj[i]);;
				make(data.obj[i]);
				$("#resources").append("</li>");
			}			
			$("#resources").append("</ul>"); */
			var ul = $("<ul class=\"easyui-tree\"></ul>");
			for(var i = 0;i < data.obj.length;i ++){
				var li = $("<li></li>");
				var span = $("<span></span>").text(data.obj[i].text);
				li.append(span);
				ul.append(li);
			}
			$("#resources").append(ul);
		}
	);
	
}); 
/* function show(msg) {
	//alert(result.nodes);
	//alert(result.data);
	/* alert(result.root.id);
	alert(result.root.text);
	alert(result.root.children.list.length); 
	//var json = eval("("+msg+")");
	//alert(msg.obj.length);
	$("#resources").append("<ul>");
	for(var i = 0;i < msg.obj.length;i ++){
		$("#resources").append("<li><span>"+msg.obj[i].text+"</span>");
		//console.log("data",msg.obj[i]);;
		make(msg.obj[i]);
		$("#resources").append("</li>");
	}
	
	$("#resources").append("</ul>");
}*/
function make(data) {
	if(data.children) {
		$("#resources").append("<ul>");
		//alert(data.children.length);
		for(var i = 0;i < data.children.length;i ++){
			//alert(data.children[i].text);
			$("#resources").append("<li><span>"+data.children[i].text+"</span>");
			make(data.children[i]);
			$("#resources").append("</li>");
		}
		
		$("#resources").append("</ul>");
	}
}
</script>