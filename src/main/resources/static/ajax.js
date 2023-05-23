function fetchData() {
  // XMLHttpRequest 객체 생성
  var xhr = new XMLHttpRequest();

  // 요청 완료 시 처리할 콜백 함수 지정
  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        // 요청이 성공한 경우
        var response = xhr.responseText;
        // 서버로부터 받은 데이터(response)를 처리
        console.log(response);
      } else {
        // 요청이 실패한 경우
        console.log('Error: ' + xhr.status);
      }
    }
  };

  // GET 방식의 Ajax 요청 설정
  xhr.open('GET', 'http://localhost:8083/api/data', true);

  // 요청 헤더 설정 (필요한 경우)
  // xhr.setRequestHeader('Content-Type', 'application/json');

  // Ajax 요청 전송
  xhr.send();
}

// Ajax 요청 실행
fetchData();