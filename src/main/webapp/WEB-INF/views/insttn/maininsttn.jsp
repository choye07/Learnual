<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>학원 메인</title>
  <link rel="stylesheet" href="/css/common.css" type="text/css" />
  <script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
  <script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
  <div class="dashboard insttn">
    <!-- 관리자 권한이 있는 유저만 활성화 가능 -->
    <div class="sidebar insttn">
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
            <a href="#">관리자 메인메뉴1</a>
            <div class="btn-toggle on">
              <a href="#">toggle</a>
            </div>
          </li>
          <ul class="menu-list">
            <li><a href="#">관리자 sub메뉴1</a></li>
            <li><a href="#">관리자 sub메뉴2</a></li>
            <li><a href="#">관리자 sub메뉴3</a></li>
            <li><a href="#">관리자 sub메뉴4</a></li>
          </ul>
        </ul>
        <!-- sidebar menu2 -->
        <ul class="menu2 sidebar-menu">
          <li class="sidebar-main-menu">
            <a href="#">관리자 메인메뉴2</a>
            <div class="btn-toggle on">
              <a href="#">toggle</a>
            </div>
          </li>
          <ul class="menu-list">
            <li><a href="#">관리자 sub메뉴1</a></li>
            <li><a href="#">관리자 sub메뉴2</a></li>
            <li><a href="#">관리자 sub메뉴3</a></li>
            <li><a href="#">관리자 sub메뉴4</a></li>
          </ul>
        </ul>
      </div>
    </div>

    <div class="header">
      <div class="header-top">
        <div class="header-top-wrapper">
          <!-- 관리자 권한이 있는 사람만 보임 -->
          <div class="btn-menu">
            <a href="#">setting</a>
          </div>
          <div class="insttn-area">
            <div class="insttn-logo">학원 logo</div>
            <h2>KT ds University</h2>
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
    </div>

    <div class="dashboard-main insttn">
      <div class="main-wrapper">
        <div class="visual">
          insttn-main-visual
        </div>
        <div class="widget-wrapper">
          <div class="dashboard-col1">
            <div class="notice widget-article">
              <div>
                <h2>학원 강좌 목록</h2>
                <a href="#">더보기</a>
              </div>

              <div>
                <ul class="article-content">
                  <li>
                    <a href="#">
                      <h3>(채용예정자 전형) 풀스택 전문가 양성 과정</h3>
                      <p class="period">
                        <span>2025-01-17</span>
                        ~
                        <span>2025-06-20</span>
                      </p>
                    </a>
                    <div class="article-direct">
                      <a class="btn" href="#">자세히보기</a>
                    </div>
                  </li>

                  <li>
                    <a href="#">
                      <h3>(재직자 대상) AZURE 심화 과정</h3>
                      <p class="period">
                        <span>2025-01-17</span>
                        ~
                        <span>2025-06-20</span>
                      </p>
                    </a>
                    <div class="article-direct">
                      <a class="btn" href="#">자세히보기</a>
                    </div>
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
            <div class="insttn-notice widget-article">
              <div>
                <h2>학원 공지사항</h2>
                <a href="#">더보기</a>
              </div>

              <div>
                <ul class="article-content">
                  <li>
                    <a href="#">
                      <h3>공지사항 item1</h3>
                      <span>2025.04.13 홍길동</span>
                    </a>
                  </li>

                  <li>
                    <a href="#">
                      <h3>공지사항 item2</h3>
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

            <div class="recruit-info widget-article">
              <div>
                <h2>실시간 채용 정보</h2>
                <a href="#">더보기</a>
              </div>

              <div>
                <ul class="article-content">
                  <li>
                    <a href="#">
                      <h3>개발자 / 프론트엔드 / 판교 / (주)하이테크</h3>
                      <span>2025.04.13 등록</span>
                    </a>
                  </li>

                  <li>
                    <a href="#">
                      <h3>Spring 백엔드 개발자 / 강남 / (주)Hitek</h3>
                      <span>2025.04.11 등록</span>
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
        </div>

      </div>
    </div>

    <div class="footer insttn">
      <div class="footer-wrapper">
        <div class="footer-logo">하단 로고</div>

        <div class="footer-contents">
          <div class="footer-content1">
            <p>Use cases</p>
            <ul class="footer-content1-list">
              <li>UI design</li>
              <li>UX design</li>
              <li>Wireframing</li>
            </ul>
          </div>

          <div class="footer-content2">
            <p>Explore</p>
            <ul class="footer-content2-list">
              <li>Design</li>
              <li>Prototyping</li>
            </ul>
          </div>

          <div class="footer-content3">
            <p>Resources</p>
            <ul class="footer-content3-list">
              <li>Blog</li>
              <li>Best practices</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>