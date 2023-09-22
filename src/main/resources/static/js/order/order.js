const urlParams = new URL(location.href).searchParams;
const itemCode = urlParams.get('itemCode');

let userName = document.querySelector('.name');
let email = document.querySelector('.email');
let phoneNumber = document.querySelector('.phoneNumber');

let postCode = document.querySelector("#postcode");
let roadAddress = document.querySelector("#roadAddress");
let jibunAddress = document.querySelector("#jibunAddress");
let detailAddress = document.querySelector("#detailAddress");
let extraAddress = document.querySelector("#extraAddress"); 

const cancelBtn = document.querySelector(".cancel__button");
const buyingBtn = document.querySelector('.buying__button');

let stockQuantityResult = document.querySelector(".stockQuantity");
let totalPriceResult = document.querySelector(".totalPriceResult")

cancelBtn.addEventListener("click", () => {
	location.href = "/items";
});

function changeFn() {
	const select = document.querySelector('.itemStockQuantity');
	let stockQuatity = select.options[select.selectedIndex].value;
	const totalPrice = document.querySelector('.totalPrice');
	let price = document.querySelector('.price');
	
	console.log(`price : ${price.textContent}, stockQuatity : ${stockQuatity}`)
	console.log(select.options[select.selectedIndex].value);
	
	stockQuantityResult.value = stockQuatity;
	totalPriceResult.value = Number(price.textContent) * Number(stockQuatity);
	
	console.log(`stockQuantityResult.value : ${stockQuantityResult.value}`)
	console.log(`totalPriceResult.value : ${totalPriceResult.value}`)
	
	
	totalPrice.textContent = Number(price.textContent) * Number(stockQuatity);
}

function sample4_execDaumPostcode() {
	new daum.Postcode({
         oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                let roadAddr = data.roadAddress; // 도로명 주소 변수
                let extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                postCode.value = data.zonecode;
                roadAddress.value = roadAddr;
                jibunAddress.value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    extraAddress.value = extraRoadAddr;
                } else {
                    extraAddress.value = '';
                }

                let guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    let expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    let expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }

/*   
buyingBtn.addEventListener('click', () => {
	console.log(`itemCode = ${itemCode}`)
	console.log(`name = ${userName.value}`)
	console.log(`email = ${email.value}`)
	console.log(`phoneNumber = ${phoneNumber.value}`)
	console.log(`postCode = ${postCode.value}`)
	console.log(`Address = ${roadAddress.value} ${detailAddress.value} ${extraAddress.value}`)
	
	let order = {
		itemCode : itemCode,
		name : userName.value,
		email: email.value,
		phoneNumber : phoneNumber.value,
		postCode : postCode.value,
		roadAddress : roadAddress.value,
		detailAddress : detailAddress.value,
		extraAddress : extraAddress.value
	}

	$.ajax({
		async: false,
		type: "POST",
		url:`/api/order?itemCode=${itemCode}`,
		data: JSON.stringify(order),
		contentType: "application/json; charset=utf-8"
	})
	.done((response) => {
		console.log(response);
	})
	.fail((error) => {
		console.log(error);
	})
});
*/


