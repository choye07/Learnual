<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>강의 등록(사용자/강사)</title>
  <link rel="stylesheet" href="/css/common.css" type="text/css" />
  <script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
  <script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
  <div class="dashboard insttn">
    <!-- 관리자 권한이 있는 유저만 활성화 가능 -->
    <jsp:include page="/WEB-INF/views/common/component/sidebar/insttnsidebar.jsp" />

	<jsp:include page="/WEB-INF/views/common/component/header/insttnheader.jsp" />

    <div class="dashboard-main insttn">

      <div class="main-wrapper course-regist">
        <div class="main-wrapper-top">
          <h1>현재 개설 강좌 목록</h1>
        </div>

        <div class="course-wrapper">
          <div class="course-article widget-article">
            <div class="article-title">
              <h2>현재 개설 중인 강좌</h2>
            </div>

            <div>
                <ul class="article-content">
                  <c:forEach var="availableCourse" items="${availableCourses}">
                    <li>
                        <a href="/insttn/usr/detail/${availableCourse.crsInfId}"><h3>${availableCourse.crsInfNm}</h3></a>
                        <p class="period">
                          <span>${availableCourse.crsInfStDt}</span> ~ <span>${availableCourse.crsInfEndDt}</span>
                        </p>
                        <p class="available-capa">
                          수강인원 :
                          <span class="current-capa">${availableCourse.crsCurPrsCnt}</span> /
                          <span class="max-capa">${availableCourse.crsInfPrsCnt}</span> 명
                        </p>
<%--                       <div class="article-direct">
                        <a class="btn-modify" href="/insttn/pltad/modify/${activeCourse.crsInfId}">수정</a>
                        <a class="btn-delete" href="javascript:void(0);" data-id="${activeCourse.crsInfId}">삭제</a>
                        <c:if test="${activeCourse.deadlineToday}">
                            <a class="btn-shutdown" href="#">마감</a> 
                        </c:if>
                      </div> --%>
                    </li>
                  </c:forEach>
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

	<jsp:include page="/WEB-INF/views/common/component/footer/insttnfooter.jsp" />
	
  </div>
</body>

</html>