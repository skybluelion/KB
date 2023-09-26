--1) EMP ���̺������Ǳ�����Ȯ���ϴ�SQL���ۼ��ϼ���.
DESC emp;

--2) �̸���K�ν����ϴ»���ǻ����ȣ, �̸�, �Ի���, �޿����˻��ϼ���.
SELECT empno, ename, hiredate, sal
FROM emp
WHERE ename LIKE 'K%';

--3) �Ի�����80�⵵�λ���Ǹ���������˻��ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE hiredate LIKE '80%';

--4) Ŀ�̼���NULL�̾ƴѻ���Ǹ���������˻��ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE comm is not null;

--5) �μ���30���μ��̰�޿���$1,500 �̻��λ�����̸�, �μ�,�������˻��ϼ���.
SELECT ename, deptno, sal
FROM emp
WHERE deptno=30 AND sal>=1500;

--6) �μ���ȣ��30�λ���߻����ȣSORT�Ͽ���µǵ��ϰ˻��ϼ���.
SELECT ename, deptno, empno
FROM emp
WHERE deptno=30
ORDER BY 3;

--7) �޿�������������SORT�Ͽ���µǵ��ϰ˻��ϼ���.
SELECT empno, ename, sal
FROM emp
ORDER BY 3 DESC;

--8) �μ���ȣ��ASCENDING SORT���ı޿���������������ΰ˻��ϼ���.
SELECT empno, ename, sal, deptno
FROM emp
ORDER BY 4, sal DESC;

--9) �μ���ȣ��DESCENDING SORT�ϰ�, �̸�������ASCENDING SORT,
--�޿�������DESCENDING SORT �Ͽ���µǵ��ϰ˻��ϼ���.
SELECT empno, ename, sal, deptno
FROM emp
ORDER BY 4 DESC, ename, sal DESC;

--10) EMP Table�����̸�, �޿�, Ŀ�̼Ǳݾ�, �Ѿ�(�޿�+Ŀ�̼Ǳݾ�)��
--���Ͽ��Ѿ��̸��������ΰ˻��ϼ���. ��, Ŀ�̼���NULL��
--����������Ѵ�.(Ŀ�̼Ǳݾ�: sal*comm/100)
--�Ѿ��Ǻ�Ī��Total���Ѵ�.
SELECT ename, sal, comm, sal+sal*comm/100 "Total"
FROM emp
WHERE comm is not null;

--11) 10���μ��Ǹ�����鿡�Ա޿���13%�����ʽ��������ϱ��
--�Ͽ���. �̸�, �޿�, ���ʽ��ݾ�, �μ���ȣ���˻��ϼ���.
SELECT ename, sal, sal*0.13 bonus, deptno
FROM emp
WHERE deptno = 10;

--12) �μ���ȣ��20�λ���ǽð����ӱ�������Ͽ��˻��ϼ���.
--��, 1���Ǳٹ��ϼ���12���̰�, 1�ϱٹ��ð���5�ð��̴�.
--��¾�����̸�, �޿�, �ð����ӱ�(�Ҽ�������ù��°�ڸ������ݿø�)���˻��ϼ���.
SELECT ename, sal, ROUND(sal/12/5) "�ð����ӱ�"
FROM emp;

--13) �޿���$1,500����$3,000 �����ǻ�����޿���15%��ȸ��������ϱ���Ͽ���. 
--�̸��̸�, �޿�, ȸ��(�Ҽ������ڸ��Ʒ������ݿø�)���˻��ϼ���.
SELECT ename, sal, ROUND(sal*0.15,1) "ȸ��"
FROM emp
WHERE sal>1500 AND sal<3000;

--14) ������ǽǼ��ɾ�������Ͽ��˻��ϼ���.. 
--��, �޿��������������̸�, �޿�, �Ǽ��ɾ����˻��ϼ���..(�Ǽ��ɾ����޿�������10%�Ǽ��������ݾ�)
SELECT ename, sal, sal*0.9 "�Ǽ��ɾ�"
FROM emp
ORDER BY 2 DESC;





