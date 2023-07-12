'use strict';
/*
let counter = 1;
setInterval(() => {
    document.querySelector('#radio' + counter).checked = true;
    counter++;
    if (counter > 5) {
        counter = 1;
    }
}, 5000);
*/

// main slide 부분
const slides = document.querySelector('.slides');
const slide = document.querySelectorAll('.slides li');

const prevBtn = document.querySelector('.prev');
const nextBtn = document.querySelector('.next');

let currentIndex = 0;
let slideCount = slide.length;
let slideWidth = 1550

makeClone();

function makeClone() {
    for (let i = 0; i < slideCount; i++) {
        let cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.appendChild(cloneSlide);
    }
    for (let i = slideCount - 1; i >= 0; i--) {
        let cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.prepend(cloneSlide);
    }

    updateWidth();
    setInitialPos();
    setTimeout(() => {
        slides.classList.add('animated');
    }, 100);
}

function updateWidth() {
    let currentSlides = document.querySelectorAll('.slides li');
    let newSlideCount = currentSlides.length;

    let newWidth = slideWidth * newSlideCount + 'px';

    slides.style.width = newWidth;
}

function setInitialPos() {
    let initialTranslateValue = -slideWidth * slideCount;
    slides.style.transform = `translateX(${initialTranslateValue}px)`;
}

setInterval(() => {
    moveSlide(currentIndex + 1);
}, 5000);

// nextBtn.addEventListener('click', () => {
//     moveSlide(currentIndex + 1);
// });

// prevBtn.addEventListener('click', () => {
//     moveSlide(currentIndex - 1);
// });

function moveSlide(num) {
    slides.style.left = -num * slideWidth + 'px';
    currentIndex = num;
    if (currentIndex === slideCount || currentIndex === -slideCount) {
        setTimeout(() => {
            slides.classList.remove('animated');
            slides.style.left = '0px';
            currentIndex = 0;
        }, 500);
        setTimeout(() => {
            slides.classList.add('animated');
        }, 600);
    }
}

// main review 부분
const mainReviewList = document.querySelectorAll('.cleaning__list')
const mainReviewCode = document.querySelectorAll('.main__review--code');

for(let i = 0; i < mainReviewList.length; i++) {
		mainReviewList[i].addEventListener('click', () => {
		console.log('test');
		console.log(mainReviewCode[i].textContent);
		
		location.href = `/review/${mainReviewCode[i].textContent}`
	})
}










