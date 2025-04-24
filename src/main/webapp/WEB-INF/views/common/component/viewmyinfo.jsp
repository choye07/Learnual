<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>나의 정보 보기</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

  <body>
    <div class="wrapper">
      <div class="myinfo manage-board">
        <div class="manage-board-wrapper">
          <div class="manage-board-header">
            <h1>개인 정보 관리</h1>
          </div>

          <div class="manage-board-body">

          <div class="regist-usr-form">
            <div class="email-area">
                <label for="email">계정</label>
                <input
                  id="myiLgnId"
                  name="myiLgnId"
                  type="email"
                  value="${inputEdit.myiLgnId}"
                />
              </div>

              <div class="name-area">
                <label for="name">이름</label>
                <input
                  id="myiNm"
                  name="myiNm"
                  type="text"
                  value="${inputEdit.myiNm}"
                  required
                />
              </div>

              <div class="password-area">
                <label for="password">비밀번호 수정</label>
                <input id="myiLgnPw" name="myiLgnPw" type="password" required />
              </div>
              
              <div class="address-area">
                <label for="address">주소</label>
                <input
                  id="myiAdrs"
                  name="myiAdrs"
                  type="text"
                  value="${inputEdit.myiAdrs}"
                  required
                />
              </div>
              <div class="phone-area">
                <label for="phone">전화번호</label>
                <input
                  id="myiPn"
                  name="myiPn"
                  type="text"
                  value="${inputEdit.myiPn}"
                  required
                />
              </div>
              
              <div class="btn-area">
              <form action="/editmyinformation" method="get">
                <button class="btn2 btn-edit" id="btn-edit" type="submit">수정</button>
                </form>
              </div>
              </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
