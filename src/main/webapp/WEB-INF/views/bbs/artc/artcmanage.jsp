<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>게시판 관리</title>
				<link rel="stylesheet" href="/css/common.css" type="text/css" />
				<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
				<script src="/js/common.js" type="text/javascript"></script>
			</head>

			<body>
				<div class="article-manage">
					<h1>게시판 관리</h1>
					<div class="home-page-button-group">
						<button class="main-home">메인 홈페이지</button>
						<button class="insttn-home">학원 홈페이지</button>
						<button class="crs-home">강좌 홈페이지</button>
					</div>
					<!-- req1) 게시판 수정/삭제 버튼은 추가된 목록에 넣는다 -->
					<!-- <a class="del-artc">게시판 수정</a> <a
			class="del-artc">게시판 삭제</a> -->

					<div class="artc-contents-wrapper">
						<div class="artc-Item-container">
							<ul class="artc-item-box">
								<!-- 추가되는 아이템1 -->
								<li class="artc-item">
									<p class="artc-item-name">공지사항</p>
									<div class="artc-item-control">
										<button class="btn-edit">수정</button>
										<button class="btn-del">삭제</button>
									</div>
								</li>
								<!-- 추가되는 아이템2 -->
								<li class="artc-item">
									<p class="artc-item-name">시험게시판</p>
									<div class="artc-item-control">
										<button class="btn-edit">수정</button>
										<button class="btn-del">삭제</button>
									</div>
								</li>
								<!-- 추가되는 아이템3 -->
								<li class="artc-item">
									<p class="artc-item-name">과제게시판</p>
									<div class="artc-item-control">
										<button class="btn-edit">수정</button>
										<button class="btn-del">삭제</button>
									</div>
								</li>
							</ul>
						</div>
						<form:form class="artc-regist-form">
							<input type="hidden" name="artcUsYn" id="artcUsYn" value="" />
							<input type="hidden" name="" id="" value="" />
							<input type="hidden" name="" id="" value="" />

							<div class="article-name-area form-group">
								<label for="artcNm">게시판 명</label> <input type="text" name="artcNm" id="artcNm" style="display: block;">
							</div>

							<div class="article-useyn-area form-group">
								<h3>게시판 사용 여부</h3>
								<input type="checkbox" name="use-yn" id="use-yn" value="Y" /><span>사용</span> <input type="checkbox"
									name="use-yn" id="use-yn" value="N" /><span>미사용</span>
							</div>

							<div class="article-acc-area form-group">
								<h3>게시판 권한</h3>
								<div class="article-acc-select">
									<div class="write-select-box">
										<label for="artcAccWr">쓰기 권한</label> <select name="artcAccWr" id="artcAccWr">
											<c:choose>
												<c:when test="${not empty cmCdList }">
													<c:forEach items="${cmCdList}" var="cmcd">
														<option value="${cmcd.cmcdId}">${cmcd.cmcdNm}</option>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<p>등록된 권한이 없습니다. 슈퍼관리자에게 문의하세요</p>
												</c:otherwise>
											</c:choose>
										</select>
									</div>

									<div class="read-select-box">
										<label for="artcAccRd">읽기 권한</label> <select name="artcAccRd" id="artcAccRd">
											<c:choose>
												<c:when test="${not empty cmCdList }">
													<c:forEach items="${cmCdList}" var="cmcd">
														<option value="${cmcd.cmcdId}">${cmcd.cmcdNm}</option>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<p>등록된 권한이 없습니다. 슈퍼관리자에게 문의하세요</p>
												</c:otherwise>
											</c:choose>
										</select>
									</div>

									<div class="edit-select-box">
										<label for="artcAccUpdt">수정 권한</label> <select name="artcAccUpdt" id="artcAccUpdt">
											<c:choose>
												<c:when test="${not empty cmCdList }">
													<c:forEach items="${cmCdList}" var="cmcd">
														<option value="${cmcd.cmcdId}">${cmcd.cmcdNm}</option>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<p>등록된 권한이 없습니다. 슈퍼관리자에게 문의하세요</p>
												</c:otherwise>
											</c:choose>
										</select>
									</div>

									<div class="del-select-box">
										<label for="artcAccDel">삭제 권한</label> <select name="artcAccDel" id="artcAccDel">
											<c:choose>
												<c:when test="${not empty cmCdList }">
													<c:forEach items="${cmCdList}" var="cmcd">
														<option value="${cmcd.cmcdId}">${cmcd.cmcdNm}</option>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<p>등록된 권한이 없습니다. 슈퍼관리자에게 문의하세요</p>
												</c:otherwise>
											</c:choose>
										</select>
									</div>
								</div>
							</div>

							<div class="btn-area">
								<button class="save-button" id="artc-save" type="submit">저장</button>
								<button class="save-button" id="go-menu-manage" type="button">메뉴 관리로</button>
							</div>

						</form:form>
					</div>
				</div>
			</body>

			</html>