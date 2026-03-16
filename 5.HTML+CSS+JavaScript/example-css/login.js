document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    
    const emailInput = document.getElementById('email').value;
    const passwordInput = document.getElementById('password').value;

    
    const VALID_EMAIL = "hong@example.com";
    const VALID_PASSWORD = "qwer1234";

    if (emailInput === VALID_EMAIL && passwordInput === VALID_PASSWORD) {
        location.href = 'user-list.html'; 
    } else {
        alert('이메일 또는 비밀번호가 일치하지 않습니다.');
    }
});