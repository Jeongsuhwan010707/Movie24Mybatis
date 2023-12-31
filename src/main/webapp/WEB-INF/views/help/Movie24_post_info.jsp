<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>메인 페이지</title>
        <link rel="stylesheet" href="/resources/css/help/Movie24_post_info.css">
    </head>
    <body>
        <div>
            <jsp:include page="/include/header.jsp"></jsp:include>
            <!-- -----------네비게이터 영역----------------------------------- -->
			<jsp:include page="/include/nav.jsp"></jsp:include>
        <!-- -----------------메인--------------------------- -->
<main>
            <div id="blank_1"></div>
            <div id="main_menu">
                <div id="member">
                    <h3>1:1 문의사항</h3>
                    <ul>
                        <li><a href="#">문의하기</a></li>
                        <c:if test="${sessionScope.memberId ne null }">
	                        <li><a href="/movie24/myPage.do">문의내역보기</a></li>
						</c:if>
                        <li><a href="#">약관 확인</a></li>
                    </ul>
                    <h3>공지사항</h3>
                    <ul>
                        <li><a href="/movie24/post.do">공지사항목록</a></li>
                    </ul>
                    <h3>자주 찾는 질문</h3>
                    <ul>
                        <li><a href="#">자주 찾는 질문</a></li>
                    </ul>

                    <h3>건의사항</h3>
                    <ul>
                        <li><a href="#">건의사항</a></li>
                        <li><a href="#">개선사항</a></li>
                        <li><a href="#">도움말</a></li>
                    </ul>
                    <h3>검색</h3>
                    <ul>
                        <li><a href="#">검색하기</a></li>
                    </ul>

                    <h3>환불문의</h3>
                    <ul>
                        <li><a href="#">환불문의하기</a></li>
                        <c:if test="${sessionScope.memberId ne null }">
	                        <li><a href="/movie24/myPage.do">환불문의 내역보기</a></li>
						</c:if>
                    </ul>
                </div>
            </div>
            <div id="main_blank"></div>
        <div id="h2">
            <h2>공지사항</h2>
        </div>
        
        <div id="table">
            <table>
                <tr id="tr1">
                    <th id="tr">제목 : ${notice.noticeSubject}</th>
                    <td class="tr2">작성자 : ${notice.noticeWriter}</td>
                    <td class="tr1">등록일 : ${notice.noticeDate}</td>
                    <td class="tr">조회수 : ${notice.viewCount}</td>
                </tr>
                </table>
            </div>
        <div id="blank">
            <p>${notice.noticeContent}</p>
        </div>
        <div id="back">
            <p class="b1"><strong>이전글 ▲</strong></p> 
            <c:if test="${notice.noticeNo ne totalNum}">
	            <p id="b2"><a href="/movie24/postInfo.do?noticeNo=${noticeB.noticeNo}"><strong>${noticeB.noticeSubject }</strong></a></p>
	            <p class="b3">등록일 : ${noticeB.noticeDate }</p>
            </c:if>
            <c:if test="${notice.noticeNo eq totalNum}">
	            <p id="b2">이전 글이 존재하지 않습니다.</p>
            </c:if>
        </div>
        <div id="next">
            <p class="b1"><strong>다음글 ▼</strong></p> 
            <c:if test="${noticeN.noticeNo ne null}">
	            <p id="b2"><a href="/movie24/postInfo.do?noticeNo=${noticeN.noticeNo}"><strong>${noticeN.noticeSubject}</strong></a></p>
    	        <p class="b3">등록일 : ${noticeN.noticeDate }</p>
            </c:if>
            <c:if test="${noticeN.noticeNo eq null}">
            	<p id="b2">다음 글이 존재하지 않습니다.</p>
            </c:if>
        </div>
        <div id="main_button">
            <a href="/movie24/post.do?currentPage=1" id="before">목록으로</a>
            <c:if test="${memberId eq 'khuser01'}">
            <a href="/notice/modify.do?noticeNo=${notice.noticeNo}" id="modify">수정하기</a>
            <a href="javascript:void(0)" onclick="deleteCheck();" id="delete">삭제하기</a>
            </c:if>
        </div>
</main>
         <!-- --------------------푸터---------------------------------- -->
         <footer class="footer">
            <div class="footer-container">
              <ul class="footer-list">
                <li><a href="">이용약관</a></li>
                <li><a href="">개인정보처리방침</a></li>
                <li><a href="">회사소개</a></li>
                <li><a href="">광고/제휴/출점문의</a></li>
                <li><a href="">법적고지</a></li>
                <li><a href="">채용정보</a></li>
                <li><a href="">편성기준</a></li>
              </ul>
              <div class="footer-content">
                <hr class="footer-line">
                <p>저작권 © 2023 My Website. All rights reserved.</p>
              </div>
            </div>
            <p>()경기도 의정부시 상금로 102-37, 스페셜빌딩(금오동)
                <br>대표이사 : 정모씨 | 사업자 등록번호 : 010-7777-7777 | 통신판매업신고번호 : 2023-의정부시-0527
                <br>COPYRIGHT @ Movie24.by_suhwan.All rights reserved
            </p>
          </footer>
    </div>
    <!-- 스크립트 -->
    <script>
        var ulElement = document.getElementById('nav_ul');
        var liElements = ulElement.querySelectorAll('li');
        var menuText = document.getElementById('menu_text');

        liElements.forEach(li => {
        li.addEventListener('mouseenter', () => {
                menuText.classList.add('active');
                menuText.style.zIndex= 5000;
            });

        });
        document.getElementById("menu_text").addEventListener('mouseleave', () => {
            menuText.classList.remove('active');
            menuText.style.zIndex= -1;
        });
        function myCheck(){
        	alert("로그인이 되어있지 않습니다.");
        }
        function outCheck(){
        	if(confirm("로그아웃 하시겠습니까?")){
        		location.href="/movie24/logout.do";
        	}
        }
        const deleteCheck = () => {
			const noticeNo = '${notice.noticeNo}';
			if(confirm("정말 삭제하시겠습니까?")){
				location.href = "/movie24/postDelete.do?noticeNo="+noticeNo;
			}
		}
    </script>