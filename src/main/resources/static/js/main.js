'use strict';
let counter = 1;
setInterval(() => {
    document.querySelector('#radio' + counter).checked = true;
    counter++;
    if (counter > 5) {
        counter = 1;
    }
}, 5000);
