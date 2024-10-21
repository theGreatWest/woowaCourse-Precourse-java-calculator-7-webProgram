function clickChange(boxID, newColor){
    document.getElementById('inputString').value = '';
    document.getElementById('input_string_and_result').textContent = '';
    sum = 0;
    tmp = '';

    const box = document.getElementById(boxID);
    const originalColor = box.style.backgroundColor;

    box.style.backgroundColor = newColor;

    setTimeout(() => {
        box.style.backgroundColor = originalColor;
    }, 200);
}

document.getElementById('delete_all').addEventListener('click', function() {
    clickChange('delete_all', 'black');
});