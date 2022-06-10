function doLogin() {
    let pwd = document.getElementById("pwd").value
    let account = document.getElementById("account").value
    axios.post('http://localhost:8899/login', {
        account: account,
        pwd: pwd,
    }).then(function (response) {
        console.log(response);
    }).then(function (error) {
        console.log(error);
    })
}