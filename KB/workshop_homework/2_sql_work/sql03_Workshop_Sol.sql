-- ### equi join ###

-- 1).  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.

select  dept.deptno, dname, ename, sal
from emp , dept 
where emp.deptno = dept.deptno 
order by dept.deptno;

-- =====================================
select d.deptno, d.dname, e.ename, e.sal 
from emp e  join dept d on e.deptno=d.deptno
order by d.deptno;
-- =====================================
select deptno, d.dname, e.ename, e.sal 
from emp e  join dept d using (deptno);

-- 2).  이름이 ‘SMITH’인 사원의 부서명을 출력하라.

select  dname
from emp, dept
where emp.deptno  = dept.deptno  and emp.ename='SMITH';

-- ========================================
select d.dname, e.ename
from emp e  join  dept d using (deptno)
where  e.ename='SMITH';

select d.dname, e.ename
from emp e  join  dept d on e.deptno=d.deptno
where  e.ename='SMITH';


 
-- ### outer join ###
-- 3).  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno;

-- ========================================

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e RIGHT JOIN  dept d
ON e.deptno(+)=d.deptno;



-- ###self join###
-- 4.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’
-- 연결 연산자 사용  || 

SELECT  e.ename  ||' 의 매니저는 ' || m.ename || '이다.'
FROM emp e, emp m
WHERE e.mgr = m.empno;



-- ### SubQuery ###

-- 1).  전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서번호, 입사일,급여를 출력하라.
select empno, ename, DEPTNO, hiredate,  sal
from emp
where sal >=(select avg(sal) from emp);


-- 2). 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 급여를 검색..급여가 많은 순으로 출력하라.
select empno, ename, sal
from emp 
where job in  ( select job from emp where deptno=10)
order by sal desc;

-- ===========================================
select e.empno, e.ename, d.dname, d.loc, sal
from emp e join dept d on e.deptno=d.deptno
where e.job  in (select job from emp where deptno=10)
Order by sal  desc;


-- 3).  10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서번호,업무, 입사일을 출력하라.
select empno, ename, hiredate, job
from emp 
where  (deptno=10 and job not in (select job from emp  where deptno=30));

-- ===========================================================

select e.empno, e.ename, d.dname, hiredate, d.loc
from emp e join dept d on e.deptno=d.deptno
where e.deptno=10
and e.job not in (select job from emp where deptno=30);

-- 4).  ‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 출력하라.
select empno, ename, sal
from emp
where sal in (select sal from emp where ename in ('KING','JAMES'));


-- 5).  급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 출력하라.
select empno, ename, sal
from emp
where sal >( select max(sal) from emp where deptno=30);


-- 6). SCOTT의 급여보다 더많은 급여를 받는 사원을 검색
-- 2가지 방법을 사용 1) 서브쿼리  2) 테이블 알리야스를 사용
-- 1) 
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');

-- 2) 
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal > b.sal;

-- 7). 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색
SELECT deptno, min(sal) FROM emp 
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=20);



-- 8). 부하직원을 거느린 사원을 검색 . 상사이름과 상사의 사원번호가 검색되도록(얄리야스 상사이름, 상사사원번호)
-- 1)
SELECT distinct mgr FROM emp;
SELECT * FROM emp WHERE empno IN (SELECT distinct mgr FROM emp);

-- 2)
SELECT e.ename 상사이름, e.empno 상사의사원번호 FROM emp e 
WHERE e.empno IN (SELECT m.mgr FROM emp m);
