const estimateList = document.querySelectorAll(".estimate__list");
const estimateCode = document.querySelectorAll(".estimate__code");

for(let i = 0; i < estimateList.length; i++) {
	estimateList[i].addEventListener('click', () => {
		
		location.href = `/admin/estimates/${estimateCode[i].textContent}`
	})
}