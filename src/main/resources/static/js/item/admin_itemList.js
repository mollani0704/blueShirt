const itemList = document.querySelectorAll('.item__list');
const itemCode = document.querySelectorAll('.item__code');

for(let i = 0; i < itemList.length; i++) {
	itemList[i].addEventListener('click', () => {
		console.log(itemCode[i].textContent);
		
		location.href = `/admin/item/${itemCode[i].textContent}`
	})
}