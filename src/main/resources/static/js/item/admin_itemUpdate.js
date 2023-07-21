'use strict'

const itemCode = document.querySelector('.item__code').value

const updateBtn = document.querySelector('.update__btn');
const deleteBtn = document.querySelector('.delete__btn');

updateBtn.addEventListener('click', () => {
	console.log('test');
	console.log(itemCode);
	
	let formData = new FormData(document.querySelector('form'));
	formData.forEach((value, key) => {
		console.log("key : " + key);
		console.log("value : " + value);
	});
	
	$.ajax({
		async: false,
		type: "PUT",
		url: `/api/item/modify/${itemCode}`,
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
	})
	.done((response) => {
		console.log(response);
		alert("작업 후기가 수정되었습니다.");
		location.href = "/admin/items"
	})
	.fail((error) => {
		console.log(error);
	})	
})

deleteBtn.addEventListener('click', () => {
	$.ajax({
		type: "delete",
		url: `/api/item/delete/${itemCode}`
	})
	.done((response) => {
		alert("글 삭제가 완료 되었습니다.")
		location.href = "/admin/items";
	})
	.fail((error) => {
		console.log(error);
	})
})
