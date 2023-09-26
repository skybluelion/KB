-- ##################  문자열 함수 실습 ######################

-- 1) 직원 정보 중 사원번호, 이름, 급여를 출력한다.  단, 이름은 앞에서 3글자씩만 출력하라.
select empno, substr(ename,1,3), sal  from emp;

-- 2) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 이름만을 출력하라.
select ename,  lower(substr(ename, 1,3)) 
from emp
where  length(ename) >=6;

-- 3) 직원정보를 입력하던중 아래와 같이 입력 되었다.(이름에 공백이 입력됨)
insert into emp values(8001,'   PARK   ', 'IT' ,  7521 , '21/11/10', 20000,1000,10);
select * from emp;

-- 이름이 'PARK'인 직원의 정보를 출력하여 보자.
  select * from emp  where  ename='PARK';

-- 이름 좌우에 공백이 있더라도 공백을 제거하고 이름이 'PARK'인 직원의 정보를 출력하여 보자.
 select * from emp  where  trim(ename)='PARK';


-- ##################  숫자 함수 실습 ######################
-- 4) 급여가 $1,500부터 $3,000 사이의 사람은 급여의 15%를 회비로 지불하기로 하였다. 
-- 이를 이름, 급여, 회비(소수점 두 자리 아래에서 반올림)를 출력하라.
select ename, sal, round(sal*0.15, 2) 회비
from emp
where sal between 1500 and 3000;
 
-- 5) 급여가 $2,000 이상인 모든 사람은 급여의 5%를 경조비로 내기 로 하였다. 
-- 이름, 급여, 경조비(소수점 이하 절삭)를 출력하라.
select ename, sal, FLOOR(sal*0.05) 경조비
from emp
where sal>=2000;
  

-- ##################  날짜 함수 실습 ######################

-- 6)입사일로부터 100일이 지난 후를 구해보자. 사원이름, 입사일, 100일 후의 날, 급여를 출력하라.
select ename, hiredate, hiredate+100, sal   from emp;

-- 7) 입사일로부터 6개월이 지난 후의 날짜를 구하려고 한다.  입사일, 6개월 후의 날짜, 급여를 출력하라
SELECT hiredate 입사일, add_months(hiredate, 6) "6개월 후의 날짜", sal 급여 from emp;

-- 8) 입사한 달의 근무일수를 계산하여 부서번호, 이름, 근무일수를 출력하라.
select ename,hiredate,last_day(hiredate)from emp;
select deptno, ename, last_day(hiredate)-hiredate 근무일수 from emp;

-- 9) 모든 사원의 입사일 기준으로 100일이 지난 후의 월요일의 날짜를 구해서 이름, 입사일,’MONDAY’를 출력하라.
select ename, hiredate, next_day(hiredate+100,'월요일') as MONDAY  from emp; 
select ename, hiredate, next_day(hiredate+100,2) as MONDAY  from emp; 

-- 10) 직원의 이름, 근속년수를 구하여 출력하라.
select ename, trunc((sysdate-hiredate)/365) 근속년수 from emp;


-- ##################  변환 함수 실습 ######################

-- 11) 모든 직원의 이름과 입사일을 ‘1996-05-14’의 형태로 출력 하라.
select ename, hiredate from emp;
select ename, to_char(hiredate,'yyyy-mm-dd') 입사일 from emp;

-- 12) 모든 직원의 번호, 이름, 급여를 출력하라. 단, 급여앞에 화폐표시($), 그리고 천단위(,)표시, 소수점이하 2자리가 표시되도록 하라.
select empno, ename, to_char(sal,'$99,999.99') 급여 from emp;

-- 13) 모든 직원의 이름과 입사한 요일을 출력하라.
SELECT ename, hiredate 입사일, to_char(hiredate,'DAY') 입사요일 from emp;


-- ##################  일반 함수 실습 ######################

-- mgr이 null이면 상위담당자/ null이면 mgr값을 가지도록 한다.
-- 별칭을 mgr2로 하자

SELECT ename, mgr,
		CASE  WHEN mgr is null THEN '상위담당자'       
			 ELSE mgr || '' 
		END mgr2
FROM emp;

select ename, mgr,
        CASE  WHEN mgr is null THEN '상위담당자'  
        ELSE mgr || '담당자'
        END MGR2
from emp;

SELECT ename, mgr,
		CASE  WHEN mgr is null THEN '상위담당자'       
			 ELSE TO_CHAR(mgr)
		END mgr2
FROM emp;

select ename, mgr, 
       decode(mgr, null, '상위관리자', mgr ||'담당 ')
 from emp;
 
 select ename, mgr, nvl2(mgr, mgr||'담당 ', '상위관리자 ')
  from emp;


