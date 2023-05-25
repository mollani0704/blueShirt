'use strict';

const username = document.querySelector("#username");
const userId = document.querySelector("#userId");
const password = document.querySelector("#password");
const address = document.querySelector("#address");

const signup_button = document.querySelector(".button");

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
		url: "/signup",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json",
	})
	.done((response) => {
		console.log(response);
	})
	.fail((error) => {
		console.log(error)
	})
})