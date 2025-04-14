$(document).ready(function () {
  /* ===== 대시보드 이벤트 ===== */
  // header 상단 메뉴버튼 클릭 시 sidebar 활성화
  $(".sidebar").hide();
  $(".btn-menu").on("click", function () {
    $(".sidebar").stop().show().addClass("on");
  });

  // sidebar close버튼 클릭시 sidebar 비활성화
  $(".btn-close").on("click", function () {
    $(".sidebar").stop().removeClass("on");
  });

  // sidebar menu accordion
  $(".sidebar-main-menu").on("click", function () {
    $(this).closest(".sidebar-menu").find(".menu-list").stop().slideToggle();
  });

  // header 상단 알림버튼 클릭 시 알림박스 활성화 (toggle)
  $(".btn-notification").on("click", function () {
    $(".notification-box").toggleClass("on");
  });
});
