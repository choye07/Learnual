$(document).ready(function () {
  /* 대시보드 이벤트 start */

  // sidebar 초기 상태 숨김
  $(".sidebar").hide();

  // 메뉴 버튼 클릭 시 sidebar 활성화
  $(".btn-menu").on("click", function () {
    $(".sidebar").stop().show().addClass("on");
  });

  // sidebar 닫기 버튼 클릭 시 sidebar 비활성화
  $(".btn-close").on("click", function () {
    $(".sidebar").stop().removeClass("on");
  });

  // sidebar 메뉴
  $(".sidebar-main-menu").on("click", function () {
    $(this).closest(".sidebar-menu").find(".menu-list").stop().slideToggle();
  });

  // 알림 버튼 클릭 시 알림 박스 토글
  $(".btn-notification").on("click", function () {
    $(".notification-box").toggleClass("on");
  });

  /* 대시보드 이벤트 end */

  /* 강좌 생성 이벤트 start */

  // 선택된 과목 ID 저장용 Set
  const selectedSubjects = new Set();

  // 과목 체크박스 선택 시 Set에 추가/제거
  $('input[name="subjects"]').change(function () {
    const subjectId = $(this).val();

    if ($(this).is(':checked')) {
      selectedSubjects.add(subjectId);
    } else {
      selectedSubjects.delete(subjectId);
    }

    updateHiddenInput();
  });

  // 숨겨진 input에 선택된 과목들 저장
  function updateHiddenInput() {
    $('#selected-subjects-input').val(Array.from(selectedSubjects).join(","));
  }

  // 제출 버튼 클릭 시 폼 전송
  $('.btn-submit').on('click', function (e) {
    e.preventDefault();

    $('#crsInfPrsCnt-error').text('');

    // 수강 인원 체크; 0이나 빈 값일시
    const prsCnt = parseInt($('#course-capacity').val());
    if (isNaN(prsCnt) || prsCnt < 1) {
      $('#crsInfPrsCnt-zero-error').text('수강 인원은 1명 이상이어야 합니다.');
      $('#course-capacity').focus();
      return;
    }
    
    // 선택된 과목들 hidden input에 반영
    $('#selected-subjects-input').val(Array.from(selectedSubjects).join(","));

    // 폼 전송
    $('#course-create-form')
      .attr({
        method: 'POST',
        action: '/insttn/pltad/create'
      })
      .submit();
  });

  /* 강좌 생성 이벤트 end */
  
  
  /* 사용자 회원 가입시 동의 여부 이벤트 start*/
  // 개인정보 수집 및 이용 동의 라디오 버튼 확인
  $("input[name='private-agreement']").on("change", function () {
    privateAgreed = $("input[name='private-agreement']:checked").val() === "agree";
    if (!privateAgreed) {
      alert("개인정보 수집 및 이용에 동의해주셔야 회원가입이 완료됩니다.");
    }
  });

  // 폼 제출 시 유효성 검사
  $("#regist-agreement-form").on("submit", function (e) {
    if (!termsAgreed || !privateAgreed) {
      alert("모든 동의 사항에 체크하셔야 회원가입이 완료됩니다.");
      e.preventDefault(); // 폼 제출 방지
      return false;
    }
  });
  /* 사용자 회원 가입시 동의 여부 이벤트 end*/
  
});
