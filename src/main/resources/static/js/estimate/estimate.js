'use strict';

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
		url: "/api/estimates/save",
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
	})
	.done((response) => {
		console.log(response);
		alert("견적 요청이 완료되었습니다.")
		location.href = "/"
	})
	.fail((error) => {
		console.log(error);
	})
})

cancelBtn.addEventListener('click', () => {
	location.href = "/";
})