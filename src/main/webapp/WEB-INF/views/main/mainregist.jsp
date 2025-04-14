<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>러뉴얼 회원가입</title>
    <link rel="stylesheet" href="/css/common.css" type="text/css" />
  </head>

  <body>
    <div class="wrapper">
      <div class="header">
        <div class="header-wrapper">
          <h1 class="header-logo">
            <a href="/">로고</a>
          </h1>

          <div class="header-right">
            <ul class="header-right-nav">
              <li>
                <a href="#">About</a>
              </li>
              <li>
                <a href="#">Product</a>
              </li>
              <li>
                <a href="#">학생대시보드</a>
              </li>
              <li>
                <a href="#">강사대시보드</a>
              </li>
              <li>
                <a href="#">관리자페이지</a>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <div class="regist-main">
        <div class="regist-section1">
          <div class="text-area">
            <div class="text-title">
              <p>모두를 위한 학습 관리 플랫폼</p>
              <p>러뉴얼을 찾아주셔서 감사합니다.</p>
            </div>
            <div class="text-sub">
              <p>수강생과 강사, 플랫폼 관리자 모두를 위한 지침서</p>
              <p>Learn-you-all, Learn-manual</p>
            </div>
          </div>
          <div class="img-area">visual-image</div>
        </div>

        <div class="regist-student-section">
          <h2>회원가입 양식</h2>
          <form action="regist-student-form">
            <div class="email-area">
              <label for="email">이메일</label>
              <input id="email" name="email" type="email" required />
            </div>
            <div class="password-area">
              <label for="password">비밀번호</label>
              <input id="password" name="password" type="password" required />
            </div>
            <div class="confirm-password-area">
              <label for="password">비밀번호 확인</label>
              <input
                id="confirm-password"
                name="confirm-password"
                required="password"
              />
            </div>
            <div class="address-area">
              <label for="address">주소</label>
              <input id="address" name="address" type="text" />
            </div>
            <div class="phone-area">
              <label for="phone">전화번호</label>
              <input id="phone" name="phone" type="text" />
            </div>

            <button class="btn2" type="button">회원가입</button>
          </form>
        </div>
      </div>

      <div class="footer">
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
