'use strict';

const reviewCode = document.querySelector('.review__code').value;


const modifyBtn = document.querySelector('.modify__btn');
const deleteBtn = document.querySelector('.delete__btn');
const cancelBtn = document.querySelector('.cancel__btn');

modifyBtn.addEventListener('click', () => {
	console.log('test');
	console.log(reviewCode);
	
	let formData = new FormData(document.querySelector('form'));
	formData.forEach((value, key) => {
		console.log("key : " + key);
		console.log("value : " + value.value);
	});
	
	$.ajax({
		async: false,
		type: "PUT",
		url: `/api/review/modify/${reviewCode}`,
		enctype: "multipart/form-data",
		contentType: false,
		processData: false,
		data: formData,
		dataType: "json",
	})
	.done((response) => {
		console.log(response);
		alert("작업 후기가 수정되었습니다.");
		location.href = "/admin/reviews";
	})
	.fail((error) => {
		console.log(error);
	})

	
})