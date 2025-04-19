<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>강좌 관리(관리자)</title>
  <link rel="stylesheet" href="/css/common.css" type="text/css" />
  <script src="/js/jquery-3.7.1.min.js" type="text/javascript"></script>
  <script src="/js/common.js" type="text/javascript"></script>
</head>

<body>
  <div class="dashboard insttn">
    <!-- 관리자 권한이 있는 유저만 활성화 가능 -->
    <jsp:include page="/WEB-INF/views/common/component/insttnsidebar.jsp" />

	<jsp:include page="/WEB-INF/views/common/component/insttnheader.jsp" />

    <div class="dashboard-main insttn">

      <div class="main-wrapper course-manage">
        <div class="main-wrapper-top">
          <h1>강좌 관리</h1>
          <div class="board-toolbox">
            <div class="board-manager-toolbox">
              <div class="btn-add-course">
                <a href="/insttn/pltad/create">강좌 추가 +</a>
              </div>
            </div>
          </div>
        </div>

        <div class="course-wrapper">
          <div class="active-courses">
            <div class="course-article widget-article">
              <div class="article-title">
                <h2>현재 개설 중인 강좌</h2>
                <a href="#">더보기</a>
              </div>

              <div>
                <ul class="article-content">
				  <c:forEach var="activeCourse" items="${activeCourses}">
				    <li>
				        <h3>${activeCourse.crsInfNm}</h3>
				        <p class="period">
				          <span>${activeCourse.crsInfStDt}</span> ~ <span>${activeCourse.crsInfEndDt}</span>
				        </p>
				        <p class="available-capa">
				          수강인원 :
				          <span class="current-capa">${activeCourse.crsCurPrsCnt}</span> /
				          <span class="max-capa">${activeCourse.crsInfPrsCnt}</span> 명
				        </p>
				      <div class="article-direct">
				        <a class="btn-modify" href="/insttn/pltad/modify/${activeCourse.crsInfId}">수정</a>
				        <a class="btn-delete" href="javascript:void(0);" data-id="${activeCourse.crsInfId}">삭제</a>
				        <c:if test="${activeCourse.deadlineToday}">
                            <a class="btn-shutdown" href="#">마감</a>	
				        </c:if>
				      </div>
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
          <div class="inactive-courses">
            <div class="course-article widget-article">
              <div class="article-title">
                <h2>신청 마감 강좌</h2>
                <a href="#">더보기</a>
              </div>

              <div>
                <ul class="article-content">
                    <c:forEach var="inactiveCourse" items="${inactiveCourses}">
	                  <li>
	                      <h3>${inactiveCourse.crsInfNm}</h3>
	                      <p class="period">
	                        <span>${inactiveCourse.crsInfStDt}</span>
	                        ~
	                        <span>${inactiveCourse.crsInfEndDt}</span>
	                      </p>
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
    </div>

	<jsp:include page="/WEB-INF/views/common/component/insttnfooter.jsp" />
	
  </div>
</body>

</html>