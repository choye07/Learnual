<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>강좌-시험목록-학생</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>


<body>
  <div class="dashboard course student">
    <jsp:include page="/WEB-INF/views/common/component/sidebar/crssidebar.jsp" />
    <jsp:include page="/WEB-INF/views/common/component/header/crsheader.jsp" />

    <div class="dashboard-main course student">
      <div class="main-wrapper tst">
        <div class="course-info v2">
          <div class="course-info-wrapper">
            <div class="course-info-title">
              <p>강의명:</p>
              <h2>Kt ds 25기 풀스택 전문가 양성과정</h2>
            </div>
            <div class="course-info-period">
              <p>
                강의신청일: <span>2024.11.01</span>
              </p>
              <p>
                신청마감일: <span>2025.01.10</span>
              </p>
              <p>
                강의시작일: <span>2025.01.14</span>
              </p>
              <p>
                강의종료일: <span>2025.06.20</span>
              </p>
            </div>
          </div>

        </div>

        <div class="tst-board board list">
          <div class="board-header">
            <h1>시험 게시판</h1>
            <div class="board-toolbox">
              <div class="btn-go-list">
                <a href="#">목록 보기</a>
              </div>
            </div>
          </div>

          <div class="board-body">
            <div class="board-list-top">
              <div>시험 내용</div>
              <div>정규 시험 날짜</div>
              <div>강사명</div>
              <div>작성 시간</div>
            </div>
            <!-- 시험 목록 -->
            <ul class="board-list-wrapper">
              <li><a href="#">
                  <div class="board-list-title">자바 기초 시험</div>
                  <div class="board-list-submitTime">2025.03.29</div>
                  <div class="board-list-writer">박성연</div>
                  <div class="board-list-time">2025.03.26</div>
                </a></li>
              <li><a href="#">
                  <div class="board-list-title">1차 종합 시험 (25기 풀스택 전문가 양성 과정)</div>
                  <div class="board-list-submitTime">2025.04.11</div>
                  <div class="board-list-writer">장민창</div>
                  <div class="board-list-time">2025.04.10</div>
                </a></li>
            </ul>

            <ul class="pagination">
              <li><a href="#">이전</a></li>
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li><a href="#">다음</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <jsp:include page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
  </div>
</body>

</html>