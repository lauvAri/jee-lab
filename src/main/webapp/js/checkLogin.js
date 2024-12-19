//验证码
const genCodeBtn = document.querySelector("#gen-code-btn");
function genCode() {
    let code = "";
    const str = '1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOASDFGHJKLZXCVBNM';
    let len = Math.floor(4 + Math.random() * 3);
    for (let i = 0; i < len; i++) {
        let random = Math.floor(Math.random()*str.length);
        code += str[random];
    }
    let codeHTML = code.split('').map((char)=>{
        let degree = -20 + Math.floor(-30 + Math.random() * 40);
        return '<span style="display: inline-block;transform:rotate(' + degree + 'deg); user-select: none; font-family: Georgia">' + char + '</span>';
    }).join("");
    document.querySelector('#verify-code-view').innerHTML = codeHTML;
}
genCodeBtn.addEventListener('click', genCode);

function checkVeri() {
    const verifyCode = document.querySelector('#veri-code').value;
    const genCode = document.querySelector('#verify-code-view').innerText;
    if (verifyCode.toUpperCase() != genCode.toUpperCase()) {
        return false;
    }
    return true;
}

const username = document.getElementById('username')
const password = document.getElementById('password')
const captcha = document.getElementById('veri-code')

function searchSQL(e) {
    let target = e.target;
    if (target.id === 'username') {
        $.ajax({
            type: 'get',
            url: `http://localhost:8080/searchUserName?username=${target.value}`,
            success(data) {
                showGreenBorder(e, data)
            },
            error(errorMsg) {
                console.log(errorMsg)
            }
        })
    } else if (target.id === 'password') {
        $.ajax({
            type: 'get',
            url: `http://localhost:8080/searchUserNameAndPassword?username=${username.value}&password=${target.value}`,
            success(data) {
                showGreenBorder(e, data)
            },
            error(errorMsg) {
                console.log(errorMsg)
            }
        })
    } else {
        showGreenBorder(e);
    }

}

function showGreenBorder(e, data) {
    let target = e.target;
    //检验的不是验证码
    if (target.id !== 'veri-code') {
        if (target.value !== null && target.value.length > 0 && target.value !== '') {
            if (data === 'true') {
                target.classList.remove('red')
                target.classList.add('green')
            } else {
                target.classList.remove('green')
                target.classList.add('red')
            }
        }
    } else {
        //检验的的验证码
        if (checkVeri()) {
            target.classList.remove('red')
            target.classList.add('green')
        } else {
            target.classList.remove('green')
            target.classList.add('red')
        }

    }
}

document.getElementById('login-form').addEventListener('keyup', searchSQL);