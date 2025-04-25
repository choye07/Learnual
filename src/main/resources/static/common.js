$(document).ready(function () {
  /* ================================ */
  /* 휘원 0418 추가한 부분 start */
  /* 메인 이벤트 start */
  // 메인 화면이 로드될 때 러뉴얼 공지사항 API 호출

  $.get("/api/ntc/list", function (ajaxResponse) {
    var mainNoticeList = ajaxResponse.ntcList; // 받아온 NtcListVO의 List
    var ntcCount = ajaxResponse.ntcCnt; // NtcListVO의 공지사항 개수

    var articleContent = $(".home-main").find(".article-content");

    // 받아온 NtcListVO.ntcCnt가 0이거나,
    // mainNoticeList의 item들이 전부 ntcDelYn가 Y라면
    // 보여줄 공지사항이 존재하지 않음을 의미
    if (
      ntcCount !== 0 &&
      !mainNoticeList.every((mainNotice) => mainNotice.ntcDelYn === "Y")
    ) {
      articleContent.empty(); // 기존 내용을 비움

      // ntcPinnedYn 값에 따라 정렬
      mainNoticeList.sort(function (a, b) {
        return (
          (b.ntcPinnedYn === "Y" ? 1 : 0) - (a.ntcPinnedYn === "Y" ? 1 : 0)
        );
      });

      var count = 0; // li 출력 제한을 위한 count변수
      mainNoticeList.forEach(function (mainNotice) {
        // 받아온 mainNoticeList의 item인
        // mainNotice의 삭제여부가 Y가 아니라면 출력
        if (mainNotice.ntcDelYn != "Y" && count < 4) {
          // 상단고정여부가 Y면 pinned-list class 및 pin img추가
          if (mainNotice.ntcPinnedYn === "Y") {
            var listItem = `<li class="pinned-notice">
						        <a href="/ntc/view/${mainNotice.ntcId}">
						            <h3>${mainNotice.ntcTtl}</h3>
						            <span>${mainNotice.ntcRgstDt}</span>
						        </a>
								<div class="pin">img</div>
						    </li>`;
            articleContent.append(listItem); // 새로운 항목 추가
            count++;
          }
          // 상단고정여부가 N이면 pin img없음
          else {
            var listItem = `<li>
						        <a href="/ntc/view/${mainNotice.ntcId}">
						            <h3>${mainNotice.ntcTtl}</h3>
						            <span>${mainNotice.ntcRgstDt}</span>
						        </a>
						    </li>`;
            articleContent.append(listItem); // 새로운 항목 추가
            count++;
          }
        }
      });
    }
  });

  /* 메인 공지사항 작성 폼 이벤트 */
  $("#learnual-notice-form")
    .find(".btn-submit")
    .on("click", function () {
      $(this)
        .closest("#learnual-notice-form")
        .attr({
          method: "POST",
          action: "/ntc/write", // 경로 변경될 수 있음
        })
        .submit();
    });

  /* 휘원 0418 추가한 부분 end */
  /* ================================ */
  /* 휘원 0421 추가한 부분 start */
  // 학원 메인 페이지가 로드될 때 '학원 공지사항' API 호출

  $.get("/api/insttnntc/list", function (ajaxResponse) {
    var insttnNoticeList = ajaxResponse.ntcList; // 받아온 InsttnNtcListVO의 List
    var ntcCount = ajaxResponse.ntcCnt; // InsttnNtcListVO의 공지사항 개수

    var articleContent = $(".dashboard-main.insttn")
      .find(".insttn-notice.widget-article")
      .find(".article-content");

    // 받아온 InsttnNtcListVO.ntcCnt가 0이거나,
    // insttnNoticeList의 item들이 전부 ntcDelYn가 Y라면
    // 보여줄 공지사항이 존재하지 않음을 의미
    if (
      ntcCount !== 0 &&
      !insttnNoticeList.every((insttnNotice) => insttnNotice.ntcDelYn === "Y")
    ) {
      articleContent.empty(); // 기존 내용을 비움

      // ntcPinnedYn 값에 따라 정렬
      insttnNoticeList.sort(function (a, b) {
        return (
          (b.ntcPinnedYn === "Y" ? 1 : 0) - (a.ntcPinnedYn === "Y" ? 1 : 0)
        );
      });

      var count = 0; // li 출력 제한을 위한 count변수
      insttnNoticeList.forEach(function (insttnNotice) {
        // 받아온 insttnNoticeList의 item인
        // insttnNotice의 삭제여부가 Y가 아니라면 출력
        if (insttnNotice.ntcDelYn != "Y" && count < 4) {
          // 상단고정여부가 Y면 pinned-list class 및 pin img추가
          if (insttnNotice.ntcPinnedYn === "Y") {
            var listItem = `<li class="pinned-notice">
						        <a href="/insttnntc/view/${insttnNotice.ntcId}">
						            <h3>${insttnNotice.ntcTtl}</h3>
						            <span>${insttnNotice.ntcRgstDt}</span>
						        </a>
								<div class="pin">img</div>
						    </li>`;
            articleContent.append(listItem); // 새로운 항목 추가
            count++;
          }
          // 상단고정여부가 N이면 pin img없음
          else {
            var listItem = `<li>
						        <a href="/insttnntc/view/${insttnNotice.ntcId}">
						            <h3>${insttnNotice.ntcTtl}</h3>
						            <span>${insttnNotice.ntcRgstDt}</span>
						        </a>
						    </li>`;
            articleContent.append(listItem); // 새로운 항목 추가
            count++;
          }
        }
      });
    }
  });

  /* 학원 공지사항 작성 폼 이벤트 */
  $("#insttn-notice-form")
    .find(".btn-submit")
    .on("click", function () {
      $(this)
        .closest("#insttn-notice-form")
        .attr({
          method: "POST",
          action: "/insttnntc/write", // 경로 변경될 수 있음
        })
        .submit();
    });
  /* 휘원 0421 추가한 부분 end */
  /* ================================ */
  /* 휘원 0422 추가한 부분 start */

  $.get("/api/crntc/list", function (ajaxResponse) {
    var crNoticeList = ajaxResponse.ntcList; // 받아온 crNtcListVO의 List
    var crntcCount = ajaxResponse.ntcCnt; // crNtcListVO의 공지사항 개수
    var articleContent = $(".dashboard-main.course")
      .find(".course-notice.widget-article")
      .find(".article-content");
    console.log(crNoticeList);
    console.log(crntcCount);

    // 받아온 crntcListVO.ntcCnt가 0이거나,
    // crNoticeList의 item들이 전부 crntcDelYn가 Y라면
    // 보여줄 강좌 공지사항이 존재하지 않음을 의미
    if (
      crntcCount !== 0 &&
      !crNoticeList.every((crNotice) => crNotice.crntcDelYn === "Y")
    ) {
      articleContent.empty(); // 기존 내용을 비움

      // crntcPinnedYn 값에 따라 정렬
      crNoticeList.sort(function (a, b) {
        return (
          (b.crntcPinnedYn === "Y" ? 1 : 0) - (a.crntcPinnedYn === "Y" ? 1 : 0)
        );
      });

      var count = 0; // li 출력 제한을 위한 count변수
      crNoticeList.forEach(function (crNotice) {
        // 받아온 crNoticeList의 item인
        // crNotice의 삭제여부가 Y가 아니라면 출력
        if (crNotice.crntcDelYn != "Y" && count < 4) {
          // 상단고정여부가 Y면 pinned-list class 및 pin img추가
          if (crNotice.crntcPinnedYn === "Y") {
            var listItem = `<li class="pinned-notice">
								<a href="/crntc/view/${crNotice.crntcId}">
								<h3>${crNotice.crntcTtl}</h3>
								<span>${crNotice.crntcRgstDt}</span>
								</a>
								<div class="pin">img</div>
							</li>`;
            articleContent.append(listItem); // 새로운 항목 추가
            count++;
          }
          // 상단고정여부가 N이면 pin img없음
          else {
            var listItem = `<li>
								<a href="/crntc/view/${crNotice.crntcId}">
								<h3>${crNotice.crntcTtl}</h3>
								<span>${crNotice.crntcRgstDt}</span>
								</a>
							</li>`;
            articleContent.append(listItem); // 새로운 항목 추가
            count++;
          }
        }
      });
    }
  });

  /* 강좌 공지사항 작성 폼 이벤트 */
  $("#crntc-notice-form")
    .find(".btn-submit")
    .on("click", function () {
      $(this)
        .closest("#crntc-notice-form")
        .attr({
          method: "POST",
          action: "/crntc/write", // 경로 변경될 수 있음
        })
        .submit();
    });
  /* 휘원 0422 추가한 부분 end */

  /* ================================ */

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

  // 소희 Part start ----------------------------------
      /* 사용자 회원 가입시 동의 여부 이벤트 start*/
      // 개인정보 수집 및 이용 동의 라디오 버튼 확인
  	
  	$("input[name='terms-agreement']").on("change", function() {
  		termsAgreed = $("input[name='terms-agreement']:checked").val() === "agree";
  		if (!termsAgreed) {
  			alert("이용약에 동의해주셔야 회원가입이 완료됩니다.");
  		}
  	});

  	$("input[name='private-agreement']").on("change", function() {
  		privateAgreed = $("input[name='private-agreement']:checked").val() === "agree";
  		if (!privateAgreed) {
  			alert("개인정보 수집 및 이용에 동의해주셔야 회원가입이 완료됩니다.");
  		}
  	});

  	// 폼 제출 시 유효성 검사
  	$("#regist-agreement-form").on("submit", function(e) {
  		if (!termsAgreed || !privateAgreed) {
  			alert("모든 동의 사항에 체크하셔야 회원가입이 완료됩니다.");
  			e.preventDefault(); // 폼 제출 방지
  			return false;
  		}
  	});
      /* 사용자 회원 가입시 동의 여부 이벤트 end*/

      /* 로그인 시 사용자, 관리자, 강사  누구로 로그인을 할건지에 대한 이벤트 start */
      // 버튼 클릭에 따라 사용자, 관리자, 강사로 구별되어 로그인 된다. 
      $(".btn-login").on("click", function() {
          const form = $(".login-form");
          const actionUrl = $(this).data("action");
          form.attr("action", actionUrl); 
          form.submit();
      });

      /* 로그인 시 강사, 회원, 관리자 누구로 로그인을 할건지에 대한 이벤트 end */
  	
  	
  	$(".regist-btns button").click(function() {
  		if (confirm("정말 취소하시겠습니까?")) {
  			// "예"를 클릭하면 이전 페이지로 이동
  			window.history.back();
  		} else {
  			// "아니오"를 클릭하면 현재 페이지에 머무름
  			// 아무 작업도 하지 않음
  			return false;
  		}
  	});
  	
  	/* 관리자 - 개인 정보 관리 페이지에서 수정 버튼을 클릭시 실행할 이벤트 start */
  	$('#btn-edit').click(function() {
  		if (confirm('정말 수정하시겠습니까?')) {
  			window.location.href = '/editmyinformation';
  		} else {
  			// 취소 버튼을 누른 경우
  			return false;
  		}
  	});
  	/* 관리자 - 개인 정보 관리 페이지에서 수정 버튼을 클릭시 실행할 이벤트 end */

      // 소희 Part end ----------------------------------

  /* ================================= */
  /* 0419 유진 파트 start */
  /* 자료실 게시판 - 게시글 생성 이벤트 start */
  /* 자료실 게시판 - 게시글 생성 이벤트 start */
  // 글 작성 페이지 이벤트

  // 1. 글 작성시 파일을 추가하면 밑에 또 파일을 추가하는 input이 생긴다.
  // 2. 파일을 첨부할 수 있는 최대 개수는 4개로 제한한다.

  // 유효한 파일 input 개수 세는 함수
  function getValidFileInputCount($form) {
    // 1. input에 파일이 들어 있는 경우
    var realInputs = $form
      .find(".file-container input[type='file']")
      .filter(function () {
        return this.files && this.files.length > 0;
      }).length;

    // 2. 기존 파일 항목: input 없이 a 태그만 있는 .file-item
    var existFiles = $form
      .find(".file-container .file-item")
      .filter(function () {
        return $(this).find("input[type='file']").length === 0;
      }).length;

    return realInputs + existFiles;
  }

  $("form.flarch-write-form, form.flarch-modify-form")
    .find(".file-container")
    .on("change", "input[type='file']", function () {
      var $form = $(this).closest("form");

      var maxFiles = 4;

      // 현재까지 실제로 선택된 파일 input 개수
      var totalFilesCount = getValidFileInputCount($form);

      if (this.files.length === 0) {
        // 파일을 선택하지 않았으면 아무것도 하지 않음
        return;
      }

      if (totalFilesCount >= maxFiles) {
        alert("파일은 최대 4개까지만 첨부할 수 있습니다.");
        return;
      }

      // "빈 input"이 하나라도 있으면 append 하지 않도록 수정 (중복 방지 핵심)
      var hasEmptyInput =
        $form.find(".file-container input[type='file']").filter(function () {
          return !this.files || this.files.length === 0;
        }).length > 0;

      // append는 조건 만족할 때만 하도록 제한
      if (!hasEmptyInput && totalFilesCount < maxFiles) {
        var newItemDom = $($("#flarch-file-item-template").html());
        $form.find(".file-container").append(newItemDom);
      }
    });

  // 3. 파일 삭제 처리 - 동적으로 추가된 파일에 대해 위임 방식으로 이벤트 처리
  // - 수정 페이지에서 동일한 파일 관련 이벤트
  $("form.flarch-write-form, form.flarch-modify-form").on(
    "click",
    ".btn-file-remove",
    function () {
      var $form = $(this).closest("form");
      var maxFiles = 4;

      var wrappers = $form.find(".file-item");

      // 첨부파일 레이아웃 깨짐 방지
      if (wrappers.length <= 1) {
        return;
      }

      // 삭제할 파일 ID 처리 (수정 폼만 해당)
      var flId = $(this).data("fl-id");
      if (flId) {
        var hiddenInput = $("<input>")
          .attr("type", "hidden")
          .attr("name", "deleteFileIds")
          .val(flId);
        $("#delete-file-container").append(hiddenInput);
      }

      // 해당 input 제거
      $(this).closest(".file-item").remove();

      // file-item template을 이용하여 새 input을 추가
      // 이미 빈 input이 있으면 새로운 input 추가 안 한다.
      var totalFilesCount = getValidFileInputCount($form);
      var hasEmptyInput =
        $form.find(".file-container input[type='file']").filter(function () {
          return !this.files || this.files.length === 0;
        }).length > 0;

      // 삭제 후 파일이 4개 미만이라면, 새 파일 input 추가
      if (!hasEmptyInput && totalFilesCount < maxFiles) {
        var newItemDom = $($("#flarch-file-item-template").html());
        $form.find(".file-container").append(newItemDom);
      }
    }
  );

  // 글 작성 페이지 submit 처리
  $("form.flarch-write-form")
    .find(".btn-flarch-submit")
    .on("click", function () {
      // 유효성 검사
      var invalidInputs = $("input:invalid,textarea:invalid");
      if (invalidInputs.length > 0) {
        return;
      }

      // POST 전송
      $("form.flarch-write-form")
        .attr({
          method: "POST",
          action: "/eduad/flarch/write",
        })
        .submit();
    });

  // 3. 글 수정 시 submit 처리
  $("form.flarch-modify-form")
    .find(".btn-flarch-submit")
    .on("click", function () {
      console.log("수정완료 클릭");

      // 유효성 검사
      var invalidInputs = $("input:invalid,textarea:invalid");
      if (invalidInputs.length > 0) {
        return;
      }

      var flArchId = $("form.flarch-modify-form")
        .find("input[name='flArchId']")
        .val();
      console.log(flArchId);

      // 삭제할 파일 정보가 있는지 확인하고, 없는 경우 deleteFileIds hidden input을 제거
      var deleteFileIds = $("input[name='deleteFileIds']").length;
      if (deleteFileIds === 0) {
        // 삭제할 파일이 없을 경우 삭제 정보가 없도록 폼에서 관련 데이터 제거
        $("#delete-file-container").empty();
      }

      $("form.flarch-modify-form")
        .attr({
          method: "POST",
          action: "/eduad/flarch/modify/" + flArchId,
        })
        .submit();
    });

  // 글 수정 페이지 이벤트 종료

  /* 
  1. +버튼 클릭 시 
    1-1. input영역 미끄러져 내려오기 (toggle)
    1-2. 삭제 버튼 보이기
  */
  $(".btn-todo-edit").on("click", function () {
    $(".todo-edit-area").slideToggle(300);
    $(".todo-item-manage").toggleClass("on");
  });

  /* 2. input에 값을 적고 추가 버튼 클릭할 경우 todo-item append */
  $(".todo-edit-area")
    .find(".btn-add")
    .on("click", function () {
      var userInput = $(this)
        .closest(".todo-edit-area")
        .find(".custom-todo-input")
        .val();

      var todoItemDom = $($("#todo-item-template").html());
      todoItemDom.find(".todo-item-content").text(userInput);
      todoItemDom.on("click", function () {
        $(this).toggleClass("done");
      });
      todoItemDom.find(".btn-todo-delete").on("click", function () {
        $(this).closest(".todo-item").remove();
      });
      $(".right-widget.todo").find(".todo-item-wrapper").append(todoItemDom);
    });

  /* 3. todo-item을 클릭하면 done toggle 처리 */
  // $(".right-widget.todo")
  //   .find(".todo-item")
  //   .on("click", function () {
  //     $(this).toggleClass("done");
  //   });

  /* 4. todo-item 삭제버튼을 클릭하면 todo-item 지워짐*/
  // $(".right-widget.todo")
  //   .find(".todo-item")
  //   .find(".btn-todo-delete")
  //   .on(".click", function () {
  //     $(this).closest(".todo-item").remove();
  //   });

  /* 0419 유진 파트 end */
  /* ================================= */

  /* 강준식 기능들 */
  /* ------------강준식----------------- */

  // 강준식 2025-04-20 수정
  // -----------------------------------------

  /* 강좌 생성 이벤트 start */

  // 선택된 과목 ID 저장용 Set
  const selectedSubjects = new Set();

  // 과목 체크박스 선택 시 Set에 추가/제거
  $('input[name="subjects"]').change(function () {
    const subjectId = $(this).val();

    if ($(this).is(":checked")) {
      selectedSubjects.add(subjectId);
    } else {
      selectedSubjects.delete(subjectId);
    }

    updateHiddenInput();
  });

  // 숨겨진 input에 선택된 과목들 저장
  function updateHiddenInput() {
    $("#selected-subjects-input").val(Array.from(selectedSubjects).join(","));
  }

  // 제출 버튼 클릭 시 폼 전송

  // 강준식 2025-04-20 수정
  // -----------------------------------------
  $("course-create")
    .find(".btn-submit")
    .on("click", function (e) {
      e.preventDefault();

      $("#crsInfPrsCnt-error").text("");

      // 수강 인원 체크; 0이나 빈 값일시
      const prsCnt = parseInt($("#course-capacity").val());
      if (isNaN(prsCnt) || prsCnt < 1) {
        $("#crsInfPrsCnt-zero-error").text(
          "수강 인원은 1명 이상이어야 합니다."
        );
        $("#course-capacity").focus();
        return;
      }

      // 선택된 과목들 hidden input에 반영
      $("#selected-subjects-input").val(Array.from(selectedSubjects).join(","));

      // 폼 전송
      $("#course-create-form")
        .attr({
          method: "POST",
          action: "/insttn/pltad/create",
        })
        .submit();
    });
  // -----------------------------------------
  /* 강좌 생성 이벤트 end */

  /* 강좌 신청 페이지에서 뒤로 가기 */
  $(".course-create")
    .find(".btn-cancel")
    .on("click", function () {
      window.location.href = "/insttn/pltad";
    });

  /* 강좌 수정 이벤트 start */

  // 수정 로직
  $(".course-manage")
    .find(".btn-update")
    .on("click", function (e) {
      e.preventDefault();

      $("#crsInfPrsCnt-error").text("");

      // 수강 인원 체크; 0이나 빈 값일시
      const prsCnt = parseInt($("#course-capacity").val());
      if (isNaN(prsCnt) || prsCnt < 1) {
        $("#crsInfPrsCnt-zero-error").text(
          "수강 인원은 1명 이상이어야 합니다."
        );
        $("#course-capacity").focus();
        return;
      }

      const courseId = $("#crsInfId").val();

      // 선택된 과목들 hidden input에 반영
      $("#selected-subjects-input").val(Array.from(selectedSubjects).join(","));

      // 폼 전송
      $("#course-create-form")
        .attr({
          method: "POST",
          action: "/insttn/pltad/modify/" + courseId,
        })
        .submit();
    });

  /* 강좌 수정 이벤트 end */

  /* 강좌 삭제 이벤트 start */

  // 삭제 로직
  $(".course-manage")
    .find(".btn-delete")
    .on("click", function () {
      var crsInfId = $(this).data("id");

      // 삭제 확인
      if (confirm("정말 해당 강좌를 삭제하시겠습니까?")) {
        $.ajax({
          url: "/insttn/pltad/delete/" + crsInfId,
          type: "POST",
          success: function (response) {
            alert("삭제가 완료되었습니다.");
            window.location.href = "/insttn/pltad";
          },
          error: function (xhr, status, error) {
            alert("삭제에 실패했습니다.");
          },
        });
      }
    });
  // -----------------------------------------
  /* 강좌 삭제 이벤트 end */

  /* 강좌 신청 이벤트 start */
  // 강준식 2025-04-25 수정
  // -----------------------------------------

  $(".course-detail")
    .find(".btn-regist")
    .on("click", function () {
      var crsInfId = $(this).data("id");

      if (confirm("정말 해당 강좌를 신청하시겠습니까?")) {
        $.ajax({
          url: "/insttn/usr/detail/" + crsInfId + "/register",
          type: "POST",
          success: function (response) {
            if (response === "FULL") {
              alert("정원이 초과되어 신청할 수 없습니다.");
            } else if (response === "OK") {
              alert("신청이 완료되었습니다.");
              location.reload();
            }
          },
          error: function () {
            alert("신청 처리 중 오류가 발생했습니다.");
          }
        });
      }
    });

  /* 강좌 신청 이벤트 end */

  /* 강좌 신청 취소 이벤트 start */

  $(".course-detail")
    .find(".btn-cancel")
    .on("click", function () {
      const crsInfId = $(this).data("id");

      if (confirm("정말 신청을 취소하시겠습니까?")) {
        $.ajax({
          url: "/insttn/usr/detail/" + crsInfId + "/cancel",
          type: "POST",
          success: function () {
            alert("신청이 취소되었습니다.");
            // window.location.href = "/insttn/usr/detail/" + crsInfId;
            location.reload();
          },
          error: function (xhr, status, error) {
            alert("신청 취소 실패했습니다.");
          },
        });
      }
    });

  // -----------------------------------------
  /* 강좌 신청 취소 이벤트 end */

  /* 2025-04-22 강준식 추가 */
  /* 강좌 마감 이벤트 start */

  $(".course-manage")
    .find(".btn-shutdown")
    .on("click", function () {
      const crsInfId = $(this).data("id");

      if (confirm("정말 해당 강의를 마감하시겠습니까?")) {
        $.ajax({
          url: "/insttn/pltad/end/" + crsInfId,
          type: "POST",
          success: function () {
            alert("강의가 마감되었습니다.");
            location.reload();
          },
          error: function (xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
            alert("강의 마감에 실패했습니다.");
          },
        });
      }
    });

  /* 강좌 마감 이벤트 end */

  /* 강좌 폐강 이벤트 start */

  /* coursemanage에서의 폐강 */
  $(".course-manage")
    .find(".btn-abandon")
    .on("click", function () {
      const crsInfId = $(this).data("id");

      if (confirm("정말 해당 강의를 폐강하시겠습니까?")) {
        $.ajax({
          url: "/insttn/pltad/abandon/" + crsInfId,
          type: "POST",
          success: function () {
            alert("강의가 폐강되었습니다.");
            location.reload();
          },
          error: function (xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
            alert("강의 폐강에 실패했습니다.");
          },
        });
      }
    });

  /* courseconfirm에서의 폐강 */
  $(".course-confirm")
    .find(".btn-abandon")
    .on("click", function () {
      const crsInfId = $(this).data("id");

      if (confirm("정말 해당 강의를 폐강하시겠습니까?")) {
        $.ajax({
          url: "/insttn/pltad/abandon/" + crsInfId,
          type: "POST",
          success: function () {
            alert("강의가 폐강되었습니다.");
            window.location.href = "/insttn/pltad";
          },
          error: function (xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
            alert("강의 폐강에 실패했습니다.");
          },
        });
      }
    });

  /* 강좌 폐강 이벤트 end */

  /* 2025-04-23 강준식 추가 */
  /* 강좌 확정 이벤트 start */

  $(".course-confirm")
    .find("#btn-real-confirm")
    .click(function () {
      const crsInfId = $(this).data("id");
      const form = $("#confirm-applied-user-form");

      const selectedUsers = $('input[name="selectedUserEmails"]:checked');
      
      if (selectedUsers.length === 0) {
        alert("확정할 회원을 선택하세요.");
        return;
      }

      form.find('input[type="hidden"][name="selectedUserEmails"]').remove();

      // 선택된 유저 이메일 hidden input으로 추가
      selectedUsers.each(function () {
        const email = $(this).val();
        form.append(
          $("<input>")
            .attr("type", "hidden")
            .attr("name", "selectedUserEmails")
            .val(email)
        );
      });

      alert("강의가 확정되었습니다.");

      form.attr({
        method: "POST",
        action: "/insttn/pltad/confirm/" + crsInfId,
      }).submit();
    });

  /* 강좌 확정 이벤트 end */
  /* ------------강준식----------------- */
});
