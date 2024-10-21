document.addEventListener('DOMContentLoaded', function () {
    const input = document.getElementById('inputString');
    const box = document.getElementById('input_string_and_result');

    input.addEventListener('input', function () {
        box.textContent = input.value;
    });
});