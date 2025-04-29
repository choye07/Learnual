<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>강좌-과제목록-강사</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="dashboard course">
		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/crssidebar.jsp" />
		<jsp:include
			page="/WEB-INF/views/common/component/header/crsheader.jsp" />

		<div class="dashboard-main course">
			<div class="main-wrapper assignment">
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

				<div class="flarch-write-board board">
					<div class="board-header">
						<h1>자료실 게시판</h1>
					</div>

					<!-- 폼에 파일이 포함되면 폼 태그에 enctype을 작성해줘야한다. -->
					<form:form modelAttribute="flArchWriteRequestVO"
						class="flarch-write-form" enctype="multipart/form-data">

						<div class="author-area form-group">
							<label for="author">작성자</label> <input type="text" id="author"
								name="instrId" value="${flArchWriteRequestVO.instrId}" required />
						</div>
						<div class="title-area form-group">
							<label for="title">제목</label> <input type="text" id="title"
								name="flArchTtl" value="${flArchWriteRequestVO.flArchTtl}"
								required />
							<form:errors path="flArchTtl" element="div" cssClass="error" />
						</div>
						<div class="file-area form-group">
							<label>첨부파일</label>
							<div class="file-container">
								<div class="file-item">
									<input type="file" id="file" name="flList" />
									<button type="button" class="btn-file-remove btn">x</button>
								</div>
							</div>
						</div>

						<div class="content-area form-group">
							<label for="content">내용</label>
							<textarea id="content" name="flArchCtt" rows="5" required>${flArchWriteRequestVO.flArchCtt}</textarea>
							<form:errors path="flArchCtt" element="div" cssClass="error" />
						</div>
						<div class="btn-area">
							<a
								href="/eduad/INSTTN-20250424-000001/CRS_INF-20250428-000014/ARTC-20250428-000004/flarch/list">
								<button type="button" class="btn-flarch-list btn">목록 보기</button>
							</a>
							<button type="submit" class="btn-flarch-submit btn">작성
								완료</button>
						</div>

					</form:form>
				</div>
			</div>
		</div>

		<jsp:include
			page="/WEB-INF/views/common/component/footer/crsfooter.jsp" />
	</div>

	<!-- 파일 아이템 추가를 위한 템플릿 생성 -->
	<template id="flarch-file-item-template">
		<div class="file-item">
			<input type="file" id="file" name="files" />
			<button type="button" class="btn-file-remove btn">x</button>
		</div>
	</template>
</body>
</html>
