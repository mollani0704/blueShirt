'use strict';

const username = document.querySelector("#username");
const userId = document.querySelector("#userId");
const password = document.querySelector("#password");
const address = document.querySelector("#address");

const signup_button = document.querySelector(".button");
const checkId_button = document.querySelector('.check__id--btn')


// 아이디 중복체크
checkId_button.addEventListener('click', (event) => {
	event.preventDefault();
	
	$.ajax({
		async: false,
		type: 'POST',
		url: "/auth/duplication",
		data : userId.value,
		contentType: "text/plain; charset=utf-8",
		dataType: "text"
	})
	.done((response) => {
		console.log(response);
		if(response === "true") {
			alert("중복된 아이디가 있습니다.");
		}else {
			alert("사용해도 되는 아이디 입니다.")
		}
	})
	.fail((error) => {
		console.log(error);
	})
	
})

// 회원가입
signup_button.addEventListener('click', () => {

	let data = {
		username : username.value,
		userId : userId.value,
		password : password.value,
		address : address.value
	}
	
	$.ajax({
		async: false,
		type: "POST",
		url: "/auth/signup",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json",
	})
	.done((response) => {
		console.log(response);
		location.href = "/"
	})
	.fail((error) => {
		console.log(error);
		alert(error.responseText)
	})
});