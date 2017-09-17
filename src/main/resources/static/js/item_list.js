function onConfirmClick(form){
	var form = document.forms[0];
	var val = false;
	for(i=0;i<form.quantity.length;i++){
		var reTest = new RegExp("^[0-9]\\d*$");
		if(form.quantity[i] == undefined || form.quantity[i].value==undefined || form.quantity[i].value== "" || form.quantity[i].value== "0"){
			form.quantity[i].value=0;
		}else if(!reTest.test(form.quantity[i].value)){
			$('#errorJs').attr('style', 'display:block');
			$("#errorJsLabel").text("Invalid Quantity");
			return;
		}else{
			val=true;
		}
		console.log('a',form.quantity[i].value);
	}
	if(val){
		$('#errorJs').attr('style', 'display:none');
		form.action="/confirm";
		form.submit();
	}else{
		$('#errorJs').attr('style', 'display:block');
		$("#errorJsLabel").text("Invalid Quantity");
		return;
	}
}

function onLogoutClick(form){
	form.action="/logout";
	form.submit();
}

function onSubmitClick(form){
	var form = document.forms[0];
	form.action="/submit";
	form.submit();
}

function onBackClick(form){
	var form = document.forms[0];
	form.action="/backItem";
	form.submit();
}

function onlyNum(e){
	var key = window.event ? e.keyCode : e.which;
	if ((key > 47 && key < 58) || key == 8  || key == 0) return true;
	return false;
}

$(document).ready(function(){
	var table = $('#listTable').DataTable({
		"bPaginate": false,
		"bFilter": false,
		"bInfo": false,
		"sAjaxSource": "/getItemList",
		"sAjaxDataProp": "",
		"order": [] ,
		"aoColumns": [
			{ "mData": "name","sTitle":"Item Description" ,"bSortable": false},
			{ "mData": "category","sTitle":"Item Category" ,"bSortable": false},
			{ "mData": "price","sTitle":"Price" ,"mRender": function(data, type, full) {
				return '$' + data+'.00';
			},"bSortable": false},
			{ "mData": "qty","sTitle":"Quantity" ,"mRender": function(data, type, full) {
				var result = ""; 
				result = '<td><input class="form-control" id="quantity" name="quantity" type="text" placeholder="Input Your Quantity" onkeypress="return onlyNum(event)"></td>';
				return result;
			},"bSortable": false}
			]
	});

	var table2 = $('#cnfrmTable').DataTable({
		"bPaginate": false,
		"bFilter": false,
		"bInfo": false,
		"order": [] 
	});
});