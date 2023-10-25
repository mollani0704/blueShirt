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
		let errorMessages = error.responseJSON;
		console.log(errorMessages);
		showErrorMessage(errorMessages);

	})
});

function showErrorMessage(errorMessages) {
	
	// 이런 방법을 써보자 display를 none으로 해놓고 에러가 있으면
	// 보여주는 방식을 사용하면 되는 거 아닌가?
	
	
	let errorMessageUsername = document.querySelector('.errorMessage.username');;
	let errorMessageUserId = document.querySelector('.errorMessage.userId');;
	let errorMessagePassword = document.querySelector('.errorMessage.password');;
	
	if(errorMessages.username) {		
		errorMessageUsername.innerText = errorMessages.username;
		errorMessageUsername.style.visibility = 'visible';
	} else {
		errorMessageUsername.style.visibility = 'hidden';
	}
	
	if(errorMessages.userId) {
		errorMessageUserId.innerText = errorMessages.userId;
		errorMessageUserId.style.visibility = 'visible';
	} else {
		errorMessageUserId.style.visibility = 'hidden';
	}
	
	if(errorMessages.password) {
		errorMessagePassword.innerText = errorMessages.password;
		errorMessagePassword.style.visibility = 'visible';
	} else {
		errorMessagePassword.style.visibility = 'hidden';
	}
	
	
	/*
	const usernameData = document.querySelector('.usernameData')
	const userIdData = document.querySelector('.userIdData')
	const passwordData = document.querySelector('.passwordData')
	
	let errorMessage = document.createElement("div");
	let spanTag = document.createElement('span');
	
	errorMessage.append(spanTag);
	
	if(errorMessages.username) {
		spanTag.append(errorMessages.username);
		usernameData.appendChild(errorMessage);
	
	} else {
		
	}
	if(errorMessages.password) {
		password.after(errorMessages.password);
	} else {
		password.after("")
	}
	if(errorMessages.userId) {
		userId.after(errorMessages.userId);
	} else {
		userId.after("")
	}
	*/
	
	
}
