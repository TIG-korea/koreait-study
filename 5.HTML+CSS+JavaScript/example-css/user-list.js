// 보기 버튼 클릭 시 실행되는 함수
function goToDetail() {
    // 요구사항: location.href를 활용하여 상세 페이지로 이동
    location.href = 'user-detail.html';
}

// (참고) 로그아웃 버튼 등 필요한 로직을 아래 추가할 수 있습니다.
document.querySelector('.logout-btn').addEventListener('click', () => {
    if(confirm('로그아웃 하시겠습니까?')) {
        location.href = 'login.html';
    }
});