// Dropdown Menu
const expandCell = function (element) {

    console.log(element);
    // console.log(event.target);

    const cell = element.closest('.dropdown__wrapper').querySelector('.dropdown__cell-content');
    // if (event.target.classList.contains('dropdown__cell')) {

    // console.log(event.target.nextSibling);
    cell.classList.toggle('max-h-0');
    cell.classList.toggle('max-h-80');
    cell.classList.toggle('mt-4');
}

// Show Form
const showForm = function () {
    const form = document.getElementById("formInput");

    if (form.style.display === "none") {
        form.style.display = "block";
    } else {
        form.style.display = "none";
    }
}
