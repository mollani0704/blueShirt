'use strict';

const userId = document.querySelector("#userId");
const password = document.querySelector("#password");

const signIn_button = document.querySelector('.button');

signIn_button.addEventListener('click', () => {
	
	console.log('test');
	/*
	let data = {
		username : userId.value,
		password : password.value
	}
	
	$.ajax({
		type: "POST",
		url: "/auth/signin",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	})
	.done((response) => {
		console.log(response);
	})
	.fail((error) => {
		console.log(error);
		
	})
	*/
})
