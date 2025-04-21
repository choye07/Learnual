<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>강좌 상세페이지</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
	<div class="dashboard insttn">
		<!-- 관리자 권한이 있는 유저만 활성화 가능 -->
		<jsp:include page="/WEB-INF/views/common/component/crssidebar.jsp" />

		<jsp:include page="/WEB-INF/views/common/component/crsheader.jsp" />

		<div class="dashboard-main insttn">

			<div class="main-wrapper course-detail">
				<h2>강좌 교육과정</h2>
				<div class="course-info">
					<div class="course-name-label">강좌명</div>
					<div class="course-name">${courseDetail.crsInfNm}</div>
					<div class="course-startDate-label">교육시작일</div>
					<div class="course-startDate">${courseDetail.crsInfStDt}</div>
					<div class="course-endDate-label">교육종료일</div>
					<div class="course-endDate">${courseDetail.crsInfEndDt}</div>
					<div class="course-registStartDate-label">신청시작일</div>
					<div class="course-registStartDate">
						${courseDetail.crsInfAppDt}</div>
					<div class="course-registEndDate-label">신청마감일</div>
					<div class="course-registEndDate">
						${courseDetail.crsInfDdlnDt}</div>
					<div class="course-registEndDate-label">강의실</div>
					<div class="course-registEndDate">
						${courseDetail.crsInfCrsRoomNm}</div>
					<div class="course-registEndDate-label">강사</div>
					<div class="course-registEndDate">
						<!-- 나중엔 진짜 데이터 강사에서 가져와서 넣어야함 -->
						장민창
					</div>
				</div>

				<h2>상세정보</h2>
				<!-- foreach 쓰기 -->
				<c:forEach var="curriculum" items="${courseDetail.curriculumList}">
					<div class="course-subjectName"
						style="font-weight: 700; font-size: 24px;">${curriculum.sbjNm}</div>
					<!-- 회의 후 css 변경 -->
					<div class="course-subjectDesc">${curriculum.crclmDesc}</div>
				</c:forEach>

				<!-- session 불러와서 만약 session이 플랫폼관리자라면 이 버튼들 아예 안보이게 하시면 됩니다; 여기부터-->
				<div class="button-wrapper">
					<c:choose>
						<c:when test="${showCancelButton}">
							<a href="javascript:void(0);" class="btn-cancel"
								data-id="${courseDetail.crsInfId}"> 신청 취소 </a>
						</c:when>
						<c:otherwise>
							<a href="javascript:void(0);" class="btn-regist"
								data-id="${courseDetail.crsInfId}"> 강좌 신청 </a>
						</c:otherwise>
					</c:choose>
					<!-- session 불러와서 만약 session이 플랫폼관리자라면 이 버튼들 아예 안보이게 하시면 됩니다; 여기까지-->
					
					<!-- session 불러와서 플랫폼관리자면 href="/insttn/pltad", 유저면 href="/insttn/usr"로 가게끔 하면 됩니다; 아마 나중에 endpoint 정리하면서 달라질거같네요 -->
					<a class="btn-back" href="/insttn/usr" type="button">뒤로</a>
				</div>
			</div>
		</div>

		<jsp:include page="/WEB-INF/views/common/component/insttnfooter.jsp" />

	</div>
</body>

</html>