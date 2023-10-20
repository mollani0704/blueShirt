'use strict';

const findPasswordButton = document.querySelector('.findPassword__button');
const findPasswordContainer = document.querySelector('.findPassword__container');

let username = document.querySelector('#username');
let userId = document.querySelector('#userId');
let email = document.querySelector("#email");

findPasswordButton.addEventListener('click', (event) => {
	event.preventDefault();
	let userNameData = username.value;
	let userIdData = userId.value;
	let emailData = email.value;
	
	let findPasswordData = {
		userNameData : userNameData,
		userIdData: userIdData,
		emailData: emailData
	}
	
	$.ajax({	
		type: "POST",
		url: "/auth/findPassword",
		data: JSON.stringify(findPasswordData),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	})
	.done((response) => {
		console.log(response);
		//showingFindPassword(response);
	})
	.fail((error) => {
		console.log(error);
	})
	
})

/*

function showingFindId(data) {
	if(data === null || data.length == 0) {	
		console.log(typeof(data));	
		findIdContainer.innerHTML = `
			<span> 입력한 이름에 대한 아이디가 없습니다 </span>
		`
	} else {
		findIdContainer.innerHTML = `
		<span> 아이디는 ${data} 입니다. </span>
	`	
	}
}
*/

