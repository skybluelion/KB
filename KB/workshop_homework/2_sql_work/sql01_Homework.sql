--1) 30번부서월급의평균(소수2자리아래올림), 최고, 최저, 인원수를구하여출력하라.
SELECT ROUND(AVG(sal),1) "30번 부서 월급의 평균", MAX(sal) "최고", MIN(sal) "최저",COUNT(-1) "인원수"
FROM emp
WHERE deptno = 30;

--2) 각부서별급여의평균(소수이하반올림), 최고, 최저, 인원수를구하여출력하라.
SELECT ROUND(AVG(sal)) "각 부서별 급여의 평균", MAX(sal) "최고", MIN(sal) "최저",COUNT(-1) "인원수"
FROM emp
GROUP BY deptno;

--3) 각부서별같은업무를하는사람의인원수를구하여부서번호,업무명, 인원수를 출력하라.
SELECT deptno "부서번호", job "업무명", COUNT(-1) "인원수"
FROM emp
GROUP BY ROLLUP(job, deptno)
ORDER BY 1;

--4) 같은업무를하는사람의수가2명이상인업무와인원수를 출력하라.
SELECT  job "업무명", COUNT(*) "인원수"
FROM emp
GROUP BY ROLLUP(job)
HAVING COUNT(-1)>=2
ORDER BY 1;

--5) 각부서별평균월급(소수이하버림), 전체월급, 최고월급, 최저월급을구하여평균
--월급이많은순으로출력하라.
SELECT FLOOR(AVG(sal)) "각 부서별 평균 월급",SUM(sal) 전체월급,MAX(sal) 최고월급,MIN(sal) 최저월급
FROM emp
GROUP BY deptno
ORDER BY 1 DESC;

--6) 각부서별같은업무를하는사람의급여의합계를구하여부서번호,업무명별급여의
--소계와총합을출력하라. 부서별정렬한다.
SELECT deptno,job, SUM(sal)
FROM emp
GROUP BY ROLLUP(job,deptno)
ORDER BY 1;


--7) 각부서별인원수를조회하되인원수가5명이상인부서만출력되도록하시오.
SELECT deptno, COUNT(-1)" 각 부서별 인원 수"
FROM emp
GROUP BY deptno
HAVING COUNT(-1)>=5;

--8) 각 부서별 최대급여와 최소급여를 조회하시오.
--단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기 때문에
--조회결과에서 제외시킨다.
SELECT deptno, MAX(sal) 최대급여,MIN(sal) 최소급여
FROM emp
GROUP BY deptno
HAVING COUNT(-1)!=1;

--9) 부서가 10, 20, 30 번인 직원들 중에서 급여를 2500 이상 5000 이하를 받는
--직원들을 대상으로 부서별 평균 급여를 조회하시오.
--단, 평균급여가 2000 이상인 부서만 출력되어야 하며, 출력결과를 평균급여가 높은
--부서 먼저 출력되도록 해야 한다.
SELECT deptno, AVG(sal) "평균급여"
FROM emp
WHERE deptno IN('10','20','30') AND sal BETWEEN 2500 AND 5000
GROUP BY deptno
HAVING AVG(sal)>=2000
ORDER BY 2 DESC;










