// Progress Bar
//let nominal = parseInt(document.getElementById("nominal").innerHTML);
//let target = parseInt(document.getElementById("target").innerHTML);
//let progres = (nominal/target) * 100;

//document.getElementById("nominal").style.display = "none";
//document.getElementById("target").style.display = "none";
//const progressBar = document.getElementById("progress");
//progressBar.style.width = `${progres}%`;

const elementsNominal = document.querySelectorAll('#nominal');
const elementsTarget = document.querySelectorAll('#target');
const progresBar = document.querySelectorAll('#progress');
const nominal = [];
const target = [];
const progres = [];

elementsNominal.forEach((el, i) => {
    let element = parseInt(el.innerHTML);
    nominal.push(element);
    el.style.display = 'none';
});

elementsTarget.forEach((el, i) => {
    let element = parseInt(el.innerHTML);
    target.push(element);
    el.style.display = 'none';
});

for (let i = 0; i < nominal.length; i++) {
	progres.push((nominal[i]/target[i])*100);
}

progresBar.forEach((el, i) => {
    el.style.width = `${progres[i]}%`;
});
