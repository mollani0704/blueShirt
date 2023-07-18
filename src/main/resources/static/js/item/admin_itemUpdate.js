'use strict'

const itemCode = document.querySelector('.item__code').value

const updateBtn = document.querySelector('.update__btn');
const deleteBtn = document.querySelector('.delete__btn');

updateBtn.addEventListener('click', () => {
	console.log('test');
	console.log(itemCode);
	
	let formData = new FormData(document.querySelector('form'));
})
