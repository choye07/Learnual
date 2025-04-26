<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>러뉴얼 홈</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<ul class="quick-navbar learnual">
		<li class="quick-menu learnual"><a href="/">
				<div class="quick-icon">img</div>
				<p>러뉴얼 홈</p>
		</a></li>
		<li class="quick-menu insttn"><a href="/insttn">
				<div class="quick-icon">img</div>
				<p>학원 홈</p>
		</a></li>
		<li class="quick-menu course"><a href="/insttn/crs">
				<div class="quick-icon">img</div>
				<p>강좌 홈</p>
		</a></li>
		<li class="quick-menu dashboard"><a href="/dashboard/usr">
				<div class="quick-icon">img</div>
				<p>대시보드(학생)</p>
		</a></li>
		<li class="quick-menu dashboard"><a href="/dashboard/eduad">
				<div class="quick-icon">img</div>
				<p>대시보드(강사)</p>
		</a></li>
		<!-- 슈퍼관리자 계정만 활성화 -->
		<li class="quick-menu super"><a href="#">
				<div class="quick-icon">img</div>
				<p>슈퍼관리자 메뉴</p>
		</a></li>
	</ul>

	<div class="wrapper">
		<jsp:include
			page="/WEB-INF/views/common/component/header/learnualheader.jsp" />

		<div class="home-main">

			<div>
				<jsp:include page="/WEB-INF/views/main/mainloginstatus.jsp" />
			</div>
			<div class="visual">main visual</div>

			<div class="contents">
				<div class="learnual-notice article">
					<div>
						<h2>러뉴얼 공지사항</h2>
						<a href="/ntc/list">더보기</a>
					</div>

					<div>
						<ul class="article-content">
							<li class="empty-notice-list">작성한 공지사항이 없습니다.</li>
						</ul>
					</div>
				</div>

				<div class="usr-section">
					<!-- 로그인하지 않을 경우 보이는 div / search 비활성 -->
					<div class="login-status-section">
						<p>학원 또는 강좌명 검색은 로그인이 필요합니다.</p>
						<div class="btn-area">
							<a href="/login">
								<div class="login-overlay">login-overlay</div> <span>러뉴얼
									로그인</span>
							</a> <a href="/regist/agreement">
								<div class="login-overlay">login-overlay</div> <span>회원
									가입</span>
							</a>
						</div>
					</div>
					<!-- 로그인했을 경우 보이는 div / search 활성 -->
					<div class="search-section">

						<div class="search-area academy">
							<form id="search-academy-form" class="search-form" action="#">
								<div class="search-input-area">
									<label for="search-academy">학원명 검색 입력란</label> <input
										id="search-academy" type="text" placeholder="학원명을 입력하세요" />
								</div>
								<div class="search-button-area">
									<button type="button btn3">검색</button>
								</div>
							</form>
						</div>

						<ul class="search-academy-list-wrapper list-wrapper">
							<!-- search item forEach start -->
							<li><a href="#">
									<p>(채용예정자 전형) 풀스택 양성과정</p> <span>(주)그린 컴퓨터 아카데미</span> <span>서울시
										동작구 연남동</span>
							</a></li>
							<li><a href="#">
									<p>(재직자 전형)AZURE 보안 전문가 과정</p> <span>(주)그린 컴퓨터 아카데미</span> <span>서울시
										동작구 연남동</span>
							</a></li>
							<!-- search item forEach end -->
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

		<jsp:include
			page="/WEB-INF/views/common/component/footer/learnualfooter.jsp" />
	</div>

</body>
</html>
