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
});
