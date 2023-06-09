'use strict';

const title = document.querySelector('.title');
const image = document.querySelector('.image');
const content = document.querySelector('.content');

const saveBtn = document.querySelector('.save__btn');
const cancelBtn = document.querySelector('.cancel__btn');

saveBtn.addEventListener('click', () => {
	console.log('test');
	console.log(content.value)
	
	let formData = new FormData(document.querySelector('form'));
	formData.forEach((value, key) => {
		console.log("key : " + key);
		console.log("value : " + value.value);
	});
	
	$.ajax({
		async: false,
		type: "POST",
		url: "/api/review/save",
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
	})
	.done((response) => {
		console.log(response);
		alert("작업 후기가 등록되었습니다.");
		location.href = "/admin";
	})
	.fail((error) => {
		console.log(error);
	})

	
})