// noinspection JSUnresolvedFunction,JSUnresolvedVariable

/**
 * 登录
 */
function doLogin() {
    let pwd = document.getElementById("pwd").value
    let account = document.getElementById("account").value
    axios.post(`http://localhost:8899/login`, Qs.stringify({account1: account, pwd1: pwd}))
        .then(res => {
            console.log('res', res)
        })

}