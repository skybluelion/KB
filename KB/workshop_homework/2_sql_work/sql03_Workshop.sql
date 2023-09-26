--���� ������ ������ DB kb_db�� ����Ǿ��� �ִ�.
--������ �����Ǿ� �ִ� emp ���̺��� ����Ͽ� ���� ���Ǹ� ����
--SQL�� �ۼ��Ͽ� ����.

--### Equi join ###
--1) EMP�� DEPT Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿��� ����϶�.
SELECT d.deptno �μ���ȣ, d.dname �μ���, e.ename �̸�, e.sal �޿�
FROM emp e, dept d
WHERE e.deptno = d.deptno;

--2) �̸��� ��SMITH���� ����� �μ����� ����϶�.
SELECT d.dname �μ�, e.ename �̸�
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.ename = 'SMITH';

--### Outer join ###
--3) dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ�
--��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.
SELECT d.deptno, e.ename, e.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE d.deptno= e.deptno(+);

--### Self join###
--4) EMP Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�.
--��SMTH�� �Ŵ����� FORD�̴١�
SELECT ename, mgr, empno
FROM emp;

SELECT e.ename ����̸�, m.ename �Ŵ���
FROM emp e, emp m
WHERE e.mgr = m.empno
AND
e.ename = 'SMITH';

--### Sub Query ###
--1) ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���ȣ, �Ի���,
--�޿��� ����϶�.
SELECT ename, deptno, hiredate, sal
FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp);

--2) 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �޿��� �˻�..�޿��� ���� ������
--����϶�.
SELECT empno, ename, sal
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE deptno IN(SELECT deptno FROM emp WHERE deptno = '10');


--3) 10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���ȣ,
--����, �Ի����� ����϶�.
SELECT empno, ename, deptno, job, hiredate
FROM emp
WHERE (deptno=10 AND job not IN(SELECT job FROM emp WHERE deptno = 30));


--4) ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE sal IN(SELECT sal FROM emp WHERE ename = 'KING' OR ename = 'JAMES');

--5) �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = '30');

--6) SCOTT�� �޿����� �� ���� �޿��� �޴� ����� �˻��϶�.
--2���� ����� ��� 1) �������� 2) ���̺� �˸��߽� ���
--6-1)
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

--6-2)
SELECT a.empno, a.ename, a.sal
FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal>b.sal;

--7) �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻��϶�.
SELECT deptno, MIN(sal)
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp GROUP BY deptno HAVING deptno = '20');

--8) ���������� �Ŵ��� ����� �˻��϶� .
--�̶� ����̸��� ����� �����ȣ�� �˻��ǵ��� �Ѵ�.
--(�⸮�߽��� ����̸�, �������ȣ)
SELECT  e.ename ����̸�, e.empno �������ȣ
FROM emp e
WHERE e.empno IN(SELECT m.mgr FROM emp m);









