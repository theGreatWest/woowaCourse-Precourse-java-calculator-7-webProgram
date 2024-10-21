const numberBox = document.querySelectorAll('.number');
const display = document.getElementById('input_string_and_result');
const inputField = document.getElementById('inputString');

function fontSize_paddingLeft(){
    inputField.style.paddingLeft = '10px';
    inputField.style.fontSize = '24px';
}

numberBox.forEach(numberBox => {
    numberBox.addEventListener('click', function(){
        this.classList.add('inner-shadow');

                const value = this.getAttribute('data-value');

                if(value.length==1){
                    if(tmp==''){
                        inputField.value = '';
                        display.textContent = '';
                    }
                    tmp += value;

                    inputField.value += value;
                    display.textContent += value;

                    fontSize_paddingLeft();
                }else if(value=='delete'){
                    inputField.value = inputField.value.slice(0,-1);
                    display.textContent = display.textContent.slice(0,-1);

                    if(sum!=0 && tmp==''){
                        sum = inputField.value;
                    }else{
                        tmp = inputField.value;
                    }
                    alert(sum+" / "+tmp);

                }else if(value=='plus'){
                    if(tmp!=''){
                        sum += parseInt(tmp);
                    }
                    tmp = '';

                    inputField.value = sum;
                    display.textContent = sum;
                }

        setTimeout(() => {
            this.classList.remove('inner-shadow');
        }, 300);
    });
});