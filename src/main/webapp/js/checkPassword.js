const originalPassword = document.getElementById('originalPassword');
const newPassword = document.getElementById('newPassword');
const confirmPassword = document.getElementById('confirmPassword');
function validatePasswords() {

    if (newPassword.value !== null && newPassword.value !== '' && newPassword.value.length > 0) {
        if (newPassword.value === originalPassword.value) {
            alert('新密码不能和原密码相同')
            return false;
        }
        if (newPassword.value !== confirmPassword.value) {
            alert('两次输入密码请保持一致')
            return false;
        }
    }

    return true;
}

function showGreenBorder (e) {
    let target = e.target;
    if (target.id === 'originalPassword') {
        $.ajax({
            type: 'get',
            url: 'http://localhost:8080/api/getUserFromSession?password=' + target.value,
            success(data) {
                if (data === 'true') {
                    target.classList.remove('red')
                    target.classList.add('green');
                } else {
                    target.classList.remove('green')
                    target.classList.add('red');
                }
            },
            error(errorMsg) {
                console.log(errorMsg)
            }
        })
    } else if (target.id === 'newPassword') {
        if (target.value !== null && target.value !== '' && target.value !== originalPassword.value) {
            target.classList.remove('red')
            target.classList.add('green')
        } else {
            target.classList.remove('green')
            target.classList.add('red')
        }
    } else if (target.id === 'confirmPassword') {
        if (target.value == newPassword.value) {
            target.classList.remove('red')
            target.classList.add('green')
        } else {
            target.classList.remove('green')
            target.classList.add('red')
        }
    }
}
document.getElementById('form').addEventListener('keyup', showGreenBorder)