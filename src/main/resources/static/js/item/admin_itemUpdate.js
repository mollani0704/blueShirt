'use strict'

console.log("test")

const itemCode = document.querySelectorAll('.item__code');
const itemName = document.querySelectorAll('.item__name');
const itemPrice = document.querySelectorAll('.item__price');
const stockQuantity = document.querySelectorAll('.item__stockQuantity');


const update_button = document.querySelectorAll('.update__btn')
const delte_button = document.querySelectorAll('.delete__btn')

const dataList = new Array();

let formDataList = document.querySelectorAll("form")
formDataList.forEach(data => {
	dataList.push(data);
})

console.log(dataList);

for(let i = 0; i < update_button.length; i++) {
	update_button[i].addEventListener('click', () => {
		console.log("상품수정" + itemCode[i].value)
		
	})
}


/*
update_button.addEventListener('click', () => {
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
*/
