// Count Donasi
const nominalElement = document.getElementById('nominal');
const kekuranganElement = document.getElementById('kekurangan');

const nominal = parseInt(nominalElement.innerHTML.replace(/\D/g,''));
const kekurangan = parseInt(kekuranganElement.innerHTML.replace(/\D/g,''));

const persen = (nominal/(nominal+kekurangan))*100;

const progresBar = document.getElementById('progress');
progresBar.style.width = `${persen}%`;