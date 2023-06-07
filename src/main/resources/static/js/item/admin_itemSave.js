'use strict';

const itemName = document.querySelector('.item_name');
const image = document.querySelector('.image');
const itemPrice = document.querySelector('.item_price');
const stockQuantity = document.querySelector('.item_stockQuantity');

const saveBtn = document.querySelector('.save__btn');
const cancelBtn = document.querySelector('.cancel__btn');

saveBtn.addEventListener('click', () => {
	console.log('test');
	
	let formData = new FormData(document.querySelector('form'));
	formData.forEach((value, key) => {
		console.log("key : " + key);
		console.log("value : " + value);
	});
	
	$.ajax({
		async: false,
		type: "POST",
		url: "/api/item/save",
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
	})
	.done((response) => {
		console.log(response);
	})
	.fail((error) => {
		console.log(error);
	})
})

