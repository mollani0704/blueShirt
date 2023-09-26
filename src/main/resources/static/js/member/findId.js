'use strict';
const findIdButton = document.querySelector('.findId__button');
const findIdContainer = document.querySelector('.findId__container');
let username = document.querySelector('#username');

findIdButton.addEventListener('click', (event) => {
	event.preventDefault();
	let userNameData = username.value;
	console.log(userNameData);
	
	$.ajax({
		type: "POST",
		url: "/auth/findId",
		data: userNameData,
		contentType: "text/plain; charset=utf-8",
		dataType: "text"
	})
	.done((response) => {
		console.log(response);
		showingFindId(response);
	})
	.fail((error) => {
		console.log(error);
	})
})

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

