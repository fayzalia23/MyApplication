// function validasi() {
//     var nama = document.getElementById("nama").value;
//     var email = document.getElementById("email").value;
//     var alamat = document.getElementById("alamat").value;
//     if (nama != "" && email!="" && alamat !="") {
//         return true;
//     }else{
//         alert('Anda harus mengisi data dengan lengkap !');
//     }
// }

const form = document.getElementById('form');
const nama = document.getElementById('nama');
const email = document.getElementById('email');
const alamat = document.getElementById('alamat');

form.addEventListener('submit', e =>{
    e.addEventListener();

    check_inputs();
});

function check_inputs() {
    const namaValue = nama.value.trim();
    const emailValue = email.value.trim();
    const alamatValue = alamat.value.trim();

    if (namaValue !== '') {
        setSuccessFor(nama);
    }
    else{
        setErrorFor(nama, 'Alamat tidak boleh kosong');
    }

    if (emailValue !== '') {
        setSuccessFor(email);
    }
    else if (!isEmail(emailValue)){
        setErrorFor(email, 'Format email salah');
    }
    else{
        setErrorFor(email);
    }

    if (alamatValue !== '') {
        setSuccessFor(alamat);
    }
    else{
        setErrorFor(alamat, 'Alamat tidak boleh kosong');
    }
}

function setSuccessFor(input){
    const cekForm = input.parentElement;
    formCek.className = 'cek-form.success'
}

function setErrorFor(input, message){
    const cekForm = input.parentElement;
    const small = formControl.querySelector('small');
    formCek.className = 'cek-form.error'
    small.innerText = message;
}

function isEmail(email) {
	return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}