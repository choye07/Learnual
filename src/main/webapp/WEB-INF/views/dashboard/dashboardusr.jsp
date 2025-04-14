<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>대시보드-학생</title>
  <link rel="stylesheet" href="/css/common.css" type="text/css" />
  <script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
  <script src="/js/common.js" type="text/javascript"></script>

</head>

<body>
  <div class="dashboard">
    <div class="sidebar student">
      <div class="btn-close">
        <a href="#">close</a>
      </div>
      <div class="user-info">
        <div class="user-info-img">
          user-info-img
        </div>
        <p class="user-greeting">
          <span class="user-name">홍길동</span> 님 안녕하세요!
        </p>
        <div class="user-info-btns">
          <a class="btn-mypage btn" href="#">마이페이지</a>
          <a class="btn-logout btn" href="#">로그아웃</a>
        </div>
      </div>
      <!-- sidebar menu wrapper -->
      <div class="menu-wrapper">
        <!-- sidebar menu1 -->
        <ul class="menu1 sidebar-menu">
          <li class="sidebar-main-menu">
            <a href="#">나의 정보</a>
            <div class="btn-toggle on">
              <a href="#">toggle</a>
            </div>
          </li>
          <ul class="menu-list">
            <li><a href="#">마이페이지</a></li>
            <li><a href="#">출결현황</a></li>
            <li><a href="#">내가 쓴 글</a></li>
            <li><a href="#">나의 정보 수정</a></li>
          </ul>
        </ul>
        <!-- sidebar menu2 -->
        <ul class="menu2 sidebar-menu">
          <li class="sidebar-main-menu">
            <a href="#">게시판</a>
            <div class="btn-toggle on">
              <a href="#">toggle</a>
            </div>
          </li>
          <ul class="menu-list">
            <li><a href="#">공지사항</a></li>
            <li><a href="#">자료실</a></li>
            <li><a href="#">과제 게시판</a></li>
            <li><a href="#">시험 게시판</a></li>
            <li><a href="#">질문 게시판</a></li>
          </ul>
        </ul>
        <!-- sidebar menu3 -->
        <ul class="menu3 sidebar-menu">
          <li class="sidebar-main-menu">
            <a href="#">문의하기</a>
            <div class="btn-toggle on">
              <a href="#">toggle</a>
            </div>
          </li>
          <ul class="menu-list">
            <li><a href="#">상담 신청 및 현황</a></li>
            <li><a href="#">관리자 문의</a></li>
          </ul>
        </ul>
      </div>
    </div>

    <div class="header">
      <div class="header-top">
        <div class="header-top-wrapper">
          <div class="btn-menu">
            <a href="#">menu</a>
          </div>
          <div class="logo">
            <a href="/">logo</a>
          </div>
          <div class="btn-notification">
            <a href="#">notification</a>
            <div class="badge"></div>
          </div>
          <div class="notification-box">
            <div class="notification-deco">
              <div class="tri"></div>
            </div>
            <ul class="notification-content">
              <li>
                <a href="#"> 과제게시판 알림이 도착했습니다. </a>
              </li>
              <li>
                <a href="#"> 과제게시판 알림이 도착했습니다. </a>
              </li>
              <li>
                <a href="#"> 과제게시판 알림이 도착했습니다. </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="header-bottom">
        <div class="header-bottom-wrapper">
          <h2>KT ds University 25기 풀스택 전문가 양성과정</h2>
          <span>2025.01.24 ~ 2025.06.17</span>
        </div>
      </div>
    </div>

    <div class="dashboard-main student">
      <div class="main-wrapper">
        <div class="dashboard-col1">
          <div class="notice widget-article">
            <div>
              <h2>강좌 공지사항</h2>
              <a href="#">더보기</a>
            </div>

            <div>
              <ul class="article-content">
                <li>
                  <a href="#">
                    <h3>러뉴얼 서비스 오픈 기념 할인 행사!</h3>
                    <span>2025.03.29 홍길동</span>
                  </a>
                </li>

                <li>
                  <a href="#">
                    <h3>기능 개발자 채용 공고</h3>
                    <span>2025.03.29 홍길동</span>
                  </a>
                </li>
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

          <div class="notice widget-article">
            <div>
              <h2>과제 게시판</h2>
              <a href="#">더보기</a>
            </div>

            <div>
              <ul class="article-content">
                <li>
                  <a href="#">
                    <h3>20240413_과제_홍길동</h3>
                    <span>2025.04.13 홍길동</span>
                  </a>
                </li>

                <li>
                  <a href="#">
                    <h3>20240413_과제_홍길동</h3>
                    <span>2025.04.13 홍길동</span>
                  </a>
                </li>
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
        <div class="dashboard-col2">
          <div class="notice widget-article">
            <div>
              <h2>자료실</h2>
              <a href="#">더보기</a>
            </div>

            <div>
              <ul class="article-content">
                <li>
                  <a href="#">
                    <h3>자료실 item1</h3>
                    <span>2025.03.29 홍길동</span>
                  </a>
                </li>

                <li>
                  <a href="#">
                    <h3>자료실 item2</h3>
                    <span>2025.03.29 홍길동</span>
                  </a>
                </li>
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

          <div class="notice widget-article">
            <div>
              <h2>샘플 게시판</h2>
              <a href="#">더보기</a>
            </div>

            <div>
              <ul class="article-content">
                <li>
                  <a href="#">
                    <h3>샘플 게시판 item1</h3>
                    <span>2025.03.29 홍길동</span>
                  </a>
                </li>

                <li>
                  <a href="#">
                    <h3>샘플 게시판 item2</h3>
                    <span>2025.03.29 홍길동</span>
                  </a>
                </li>
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
        <div class="dashboard-col3">
          <div class="dday widget-right">
            <div class="dday-content1">
              <p>다음 시험까지</p>
              <strong>D-<span class="dday-target">11</span>일</strong>
              <span>2025.04.13(일)</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>