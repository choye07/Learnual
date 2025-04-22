<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>강좌 추가</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="dashboard course">
		<!-- 관리자 권한이 있는 유저만 활성화 가능 -->
		<jsp:include
			page="/WEB-INF/views/common/component/sidebar/crssidebar.jsp" />
		<jsp:include
			page="/WEB-INF/views/common/component/header/crsheader.jsp" />

		<div class="dashboard-main course">


			<div class="main-wrapper course-create">
				<div class="main-wrapper-top">
					<h1 class="page-title">강좌 추가</h1>
				</div>
				<div class="main-wrapper-body">
					<form:form modelAttribute="crsInfRegistRequestVO"
						id="course-create-form">
						<div class="title-area form-group">
							<label for="crsInfNm">강좌명</label> <input type="text"
								id="course-title" name="crsInfNm"
								value="${userRegistInfo.crsInfNm}" required />
							<form:errors path="crsInfNm" element="div" cssClass="error" />
							<c:if test="${not empty duplicateTitleError}">
								<div class="error">${duplicateTitleError}</div>
							</c:if>
						</div>

						<div class="classroom-area form-group">
							<label for="course-classroom">강의실</label> <input type="text"
								id="course-classroom" name="crsInfCrsRoomNm"
								value="${userRegistInfo.crsInfCrsRoomNm}" required />
							<form:errors path="crsInfCrsRoomNm" element="div"
								cssClass="error" />
						</div>

						<div class="subject-area form-group">
							<label>과목</label>
							<div>
								<c:forEach var="subject" items="${subjectList}">
									<label class="each-checkbox"> <input type="checkbox"
										name="subjects" value="${subject.sbjId}"
										${selectedSubjects !=null &&
                      selectedSubjects.contains(subject.sbjId) ? 'checked' : '' } />
										${subject.sbjNm}
									</label>
								</c:forEach>
							</div>
							<form:errors path="subjects" element="div" cssClass="error" />
						</div>

						<input type="hidden" id="selected-subjects-input"
							name="selectedSubjects" />

						<div class="course-capacity-area form-group">
							<label for="course-capacity">수강 인원</label> <input type="text"
								id="course-capacity" name="crsInfPrsCnt"
								value="${userRegistInfo.crsInfPrsCnt}" required
								oninput="this.value = this.value.replace(/[^0-9]/g, '')" />
							<div id="crsInfPrsCnt-zero-error" class="error"></div>
							<form:errors path="crsInfPrsCnt" element="div" cssClass="error" />
						</div>

						<div class="course-startDate-area form-group">
							<label for="course-startDate">강좌시작일</label> <input
								type="datetime-local" id="course-startDate" name="crsInfStDt"
								value="${userRegistInfo.crsInfStDt}" required />
							<form:errors path="crsInfStDt" element="div" cssClass="error" />
							<c:if test="${not empty crsInfStDtThanToday}">
								<div class="error">${crsInfStDtThanToday}</div>
							</c:if>
							<c:if test="${not empty appDtAfterThanStDt}">
								<div class="error">${appDtAfterThanStDt}</div>
							</c:if>
						</div>

						<div class="course-endDate-area form-group">
							<label for="course-endDate">강좌종료일</label> <input
								type="datetime-local" id="course-endDate" name="crsInfEndDt"
								value="${userRegistInfo.crsInfEndDt}" required />
							<form:errors path="crsInfEndDt" element="div" cssClass="error" />
							<c:if test="${not empty crsInfEndDtThanToday}">
								<div class="error">${crsInfEndDtThanToday}</div>
							</c:if>
							<c:if test="${not empty crsLateErrorMessage}">
								<div class="error">${crsLateErrorMessage}</div>
							</c:if>
						</div>

						<div class="course-registStart-area form-group">
							<label for="course-registStart">신청시작일</label> <input
								type="datetime-local" id="course-registStart" name="crsInfAppDt"
								value="${userRegistInfo.crsInfAppDt}" required />
							<form:errors path="crsInfAppDt" element="div" cssClass="error" />
							<c:if test="${not empty crsInfAppDtThanToday}">
								<div class="error">${crsInfAppDtThanToday}</div>
							</c:if>
						</div>

						<div class="course-registEnd-area form-group">
							<label for="course-registEnd">신청마감일</label> <input
								type="datetime-local" id="course-registEnd" name="crsInfDdlnDt"
								value="${userRegistInfo.crsInfDdlnDt}" required />
							<form:errors path="crsInfDdlnDt" element="div" cssClass="error" />
							<c:if test="${not empty crsInfDdlnDtThanToday}">
								<div class="error">${crsInfDdlnDtThanToday}</div>
							</c:if>
							<c:if test="${not empty appLateErrorMessage}">
								<div class="error">${appLateErrorMessage}</div>
							</c:if>
						</div>

						<div class="btn-area">
							<button class="btn-submit" type="submit">등록</button>
							<button class="btn-cancel" type="button">취소</button>
						</div>
					</form:form>
				</div>

			</div>

		</div>

		<div class="footer course">
			<div class="footer-wrapper">
				<div class="footer-logo">하단 학원 로고</div>

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