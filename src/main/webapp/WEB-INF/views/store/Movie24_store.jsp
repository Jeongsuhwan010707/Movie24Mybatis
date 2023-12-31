<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Movie24</title>
        <link rel="stylesheet" href="/resources/css/store/Movie24_store.css">
    </head>
    <body>
        <div>
           <jsp:include page="/include/header.jsp"></jsp:include>
            <!-- -----------네비게이터 영역----------------------------------- -->
			<jsp:include page="/include/nav.jsp"></jsp:include>
        <!-- -----------------메인--------------------------- -->
<main>
    <div id="main_logo">
        <h1>스토어</h1>
    </div>
    <div id="main_content">
        <div id="login_li">
            <ul>
                <li><a href="#">패키지</a></li>
                <li><a href="#">영화관람권</a></li>
                <li><a id="li-last" href="#">기프트카드</a></li>
                <li><a href="#">장바구니</a>
                <span>0</span></li>
            </ul>
        </div>
    </div>
        <div id="package">
            <div class="title_store">
                <h1>패키지</h1>
            </div>
            <div class="product">
                <ul>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/cgv팝콘-removebg-preview.png" alt="">
                        <p>팝콘 패키지1</p>
                        <p>10,000원</p>
                    </a></li>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/cgv팝콘2-removebg-preview.png" alt="">
                        <p>팝콘 패키지2</p>
                        <p>10,000원</p>
                    </a></li>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/메가박스팝콘.png" alt="">
                        <p>팝콘 패키지3</p>
                        <p>10,000원</p>
                    </a></li>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/메가박스팝콘2.png" alt="">
                        <p>팝콘 패키지4</p>
                        <p>10,000원</p>
                    </a></li>
                </ul>
            </div>
        </div>
        <div id="movie-ticket">
            <div class="title_store">
                <h1>영화관람권</h1>
            </div>
            <div class="product">
                <ul>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/메가티켓1.png" alt="">
                        <p>영화관람권 1</p>
                        <p>20,000원</p>
                    </a></li>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/메가티켓2.png" alt="">
                        <p>영화관람권 2</p>
                        <p>30,000원</p>
                    </a></li>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/메가티켓3.png" alt="">
                        <p>영화관람권 3</p>
                        <p>10,000원</p>
                    </a></li>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/메가티켓4.png" alt="">
                        <p>영화관람권 4</p>
                        <p>15,000원</p>
                    </a></li>
                </ul>
            </div>
        </div>
        <div id="gift">
            <div class="title_store">
                <h1>기프트카드</h1>
            </div>
            <div class="product">
                <ul>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/메가카드1.png" alt="">
                        <p>기프트카드 1</p>
                        <p>11,000원</p>
                    </a></li>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/메가카드2.png" alt="">
                        <p>기프트카드 2</p>
                        <p>12,000원</p>
                    </a></li>
                    <li><a href="/movie24/store/Movie24_bag.html">
                        <img src="/resources/images/메가카드3.png" alt="">
                        <p>기프트카드 3</p>
                        <p>20,000원</p>
                    </a></li>
                    <li><a href="#">
                    </a></li>
                </ul>
            </div>
        </div>
        <a id="next" href="/movie24/store/Movie24_bag.html">장바구니</a>
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

    </script>