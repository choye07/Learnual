<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>러뉴얼 로그인</title>
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
                <a href="/dashboard/usr">학생대시보드</a>
              </li>
              <li>
                <a href="/dashboard/eduad">강사대시보드</a>
              </li>
              <li>
                <a href="/insttn">학원페이지</a>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <div class="login-main">
        <div class="login-main-wrapper">
          <div class="login-main-left">
            <div class="text-wrapper">
              <div class="text-title">
                <p>모두의 학습</p>
                <p>'Your All-in-One Learning Manual'</p>
              </div>
              <div class="text-sub">
                <p>수강생과 강사, 플랫폼 관리자 모두를 위한 지침서</p>
                <p>Learn-you-all, Learn-Manual</p>
                <p>러뉴얼에 오신 것을 환영합니다.</p>
              </div>
            </div>

            <div class="login-visual">로그인 visual</div>
          </div>

          <div class="login-main-form">
            <form class="login-form" id="login-form" action="#">
              <h2>로그인</h2>
              <div class="login-input">
                <div class="login-email-area">
                  <label for="login-email">이메일(아이디)</label>
                  <input id="login-email" type="text" />
                </div>
                <div class="login-password-area">
                  <label for="">비밀번호</label>
                  <input id="login-password" type="password" />
                </div>
              </div>
            </form>

            <div class="btn-area">
              <button class="btn-login" type="button">Login</button>
              <div class="btn-regist-area">
                <button class="btn-regist1" type="button">
                  고객으로 가입하기
                </button>
                <button class="btn-regist2" type="button">
                  담당자로 가입하기
                </button>
              </div>
            </div>
          </div>
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
