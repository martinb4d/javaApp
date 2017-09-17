function onBackClick(form){
	form.action="/login";
	form.submit();
}

$(document).ready(function(){
	var table = $('#cmnTable').DataTable({
		"sAjaxSource": "/getPurchase",
		"sAjaxDataProp": "",
		"order": [] ,
		"aoColumns": [
		    { "mData": "user.username","sTitle":"User", "bSortable": false},
	      	{ "mData": "item.name","sTitle":"Item Description","bSortable": false},
	      	{ "mData": "item.category","sTitle":"Item Category","bSortable": false},
			{ "mData": "quantity","sTitle":"Quantity","bSortable": false , "mRender": function(data, type, full){
				var opts = '{style: "decimal", currency: "$", minimumFractionDigits: 2}';
				return data.toLocaleString("en-US", opts);
			} },
			{ "mData": "amount","sTitle":"Amount","bSortable": false , "mRender": function(data, type, full){
				var opts = '{style: "decimal", currency: "$", minimumFractionDigits: 2}';
				return '$'+data.toLocaleString("en-US", opts)+'.00';
			} },
			{ "mData": "createdDate","sTitle":"Date","bSortable": false , "mRender": function(data, type, full){
				var date = new Date(data);
			return ('0' + date.getDate()).slice(-2)+"/"+('0' +(date.getMonth()+1)).slice(-2)+"/"+date.getFullYear()+" "
			+('0' + date.getHours()).slice(-2)+":"+('0' + date.getMinutes()).slice(-2)+":"+('0' + date.getSeconds()).slice(-2);
		} }
		]
	})
});