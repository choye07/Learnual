<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>강좌 관리</title>
  <link rel="stylesheet" href="/css/common.css" type="text/css" />
  <script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
  <script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
  <div class="modal">
    <div class="course-create">
      <h1>강의 추가</h1>
      <form id="course-create-form">
        <div class="title-area form-group">
          <label for="course-title">강의제목</label>
          <input type="text" id="course-title" name="course-title" required />
        </div>

        <div class="classroom-area form-group">
          <label for="course-classroom">강의실</label>
          <input type="text" id="course-classroom" name="course-classroom" required />
        </div>

        <div class="subject-area form-group">
          <label for="course-subject">과목</label>
          <select id="course-subject" multiple>
            <option value="과목1">과목1</option>
            <option value="과목2">과목2</option>
            <option value="과목3">과목3</option>
          </select>
        </div>

        <div id="selected-subject-box"></div>
        <input type="hidden" name="course-subjects" id="selected-subjects-input" />

        <div class="course-startDate-area form-group">
          <label for="course-startDate">강의시작일</label>
          <input type="datetime-local" id="course-startDate" name="course-startDate" required />
        </div>

        <div class="course-endDate-area form-group">
          <label for="course-endDate">강좌종료일</label>
          <input type="datetime-local" id="course-endDate" name="course-endDate" required />
        </div>

        <div class="course-registStart-area form-group">
          <label for="course-registStart">신청시작일</label>
          <input type="datetime-local" id="course-registStart" name="course-registStart" required />
        </div>

        <div class="course-registEnd-area form-group">
          <label for="course-registEnd">신청종료일</label>
          <input type="datetime-local" id="course-registEnd" name="course-registEnd" required />
        </div>

        <div class="btn-area">
          <button class="btn-submit" type="submit">등록</button>
          <button class="btn-cancel" type="button">취소</button>
        </div>
      </form>
    </div>
  </div>

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

      <div class="main-wrapper course-manage">
        <div class="course-top">
          <h1>강좌 관리</h1>
          <div class="course-top-btns">
            <div class="btn-add-course">
              <a href="#">강좌 추가</a>
            </div>
          </div>
        </div>

        <div class="course-wrapper">
          <div class="active-courses">
            <div class="course-article widget-article">
              <div>
                <h2>현재 개설 중인 강좌</h2>
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
                      <a class="btn-modify" href="#">수정</a>
                      <a class="btn-delete" href="#">삭제</a>
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
                      <a class="btn-modify" href="#">수정</a>
                      <a class="btn-delete" href="#">삭제</a>
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
          <div class="inactive-courses">
            <div class="course-article widget-article">
              <div>
                <h2>신청 마감 강좌</h2>
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