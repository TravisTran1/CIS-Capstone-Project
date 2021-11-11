// validates form by checking for fill outs. this includes, username, password, password confirmation, email validation.

function validateForm() {
    let f_name = document.forms["register"]["name"].value;
    if (f_name === "") {
        alert("Please fill out required fields.");
        return false;
    }

    let f_email = document.forms["register"]["email"].value;
    if (f_email === "") {
        alert("Please fill out required fields.");
        return false;
    }

    let f_username = document.forms["register"]["username"].value;
    if (f_username === "") {
        alert("Please fill out required fields.");
        return false;
    }

    let f_password = document.forms["register"]["password"].value;
    if (f_password === "") {
        alert("Please fill out required fields.");
        return false;
    }

    let f_password2 = document.forms["register"]["password2"].value;
    if (f_password2 === "") {
        alert("Please fill out required fields.");
        return false;
    }

    let pass = document.getElementById('password').value;
    let pass2 = document.getElementById('password2').value;

    // if not same return False.
    if (pass !== pass2) {
        alert("Passwords did not match: Please try again.")
        //console.log(pass)
        //console.log(pass2)
        return false;
    }

    // validates email
    let mailFormat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if (document.getElementById('email').value.match(mailFormat)) {
        return true;
    } else {
        alert("Please enter a valid email address.");
        //console.log (("email") + (document.getElementById('email').value));
        return false;
    }



}
