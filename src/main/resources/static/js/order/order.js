function changeFn() {
	const select = document.querySelector('.itemStockQuantity');
	
	let price = document.querySelector('.price');
	let stockQuatity = select.options[select.selectedIndex].value;
	const totalPrice = document.querySelector('.totalPrice');

	console.log(`price : ${price.textContent}, stockQuatity : ${stockQuatity}`)
	
	totalPrice.textContent = Number(price.textContent) * Number(stockQuatity);
}