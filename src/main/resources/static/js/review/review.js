const reviewList = document.querySelectorAll('.review__list');
const reviewCode = document.querySelectorAll('.review__code');

for(let i = 0; i < reviewList.length; i++) {
	reviewList[i].addEventListener('click', () => {
		console.log('test');
		console.log(reviewCode[i].textContent);
		
		location.href = `/review/${reviewCode[i].textContent}`
	})
}