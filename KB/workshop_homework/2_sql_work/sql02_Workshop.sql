DESC EMP;
--1) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�. ��, �̸��� �տ��� 3���ھ��� ����϶�.
SELECT empno, SUBSTR(ename,1,3) �̸�, sal
FROM emp;

--2) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
SELECT ename, lower(substr(ename, 1, 3))
FROM emp
WHERE length(ename) > =6;

--3) ���������� �Է��ϴ� �� �Ʒ��� ���� �Է� �Ǿ���.(�̸��� ������ �Էµ�)
--insert into emp values(8001, �� PARK �� , 'IT' , 7521 , '21/11/10', 20000,1000,10);
--select * from emp;
--�̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
--select * from emp where ename='PARK';
--�̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����϶�.

insert into emp values(8002,' PARK  ', 'IT' ,  7521 , '21/11/10', 20000,1000,10);
select * from emp;

select * from emp where trim(ename)='PARK';

--4) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���.
--�̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.
SELECT ename, sal, ROUND(sal*0.15,2) "ȸ��"
FROM emp
WHERE sal BETWEEN 1500 AND 3000;

--5) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ���� �� �Ͽ���.
--�̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�
SELECT ename, sal, ROUND(sal*0.05) "������"
FROM emp
WHERE sal >= 2000;

--6) �Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿���
--����϶�.
SELECT ename, hiredate, hiredate+100 "100�� ���� ��", sal
FROM emp;

--7) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�.
--�Ի���, 6���� ���� ��¥, �޿��� ����϶�
SELECT hiredate, ADD_MONTHS(hiredate,6) "6���� ���� ��¥", sal
FROM emp;

--8) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �ٹ��ϼ��� ����϶�.
SELECT deptno, ename, LAST_DAY(hiredate)-hiredate �ٹ��ϼ�
FROM emp;

--9) ��� ����� �Ի��� �������� 100���� ���� ���� �������� ��¥�� ���ؼ� ��� �̸�,
--�Ի��� , ��MONDAY���� ����϶�.
SELECT ename, hiredate, NEXT_DAY(hiredate+100, 2) "MONDAY"
FROM emp;

--10) ������ �̸�, ����, �ټӳ���� ���Ͽ� ����϶�.
SELECT ename, job, CEIL((SYSDATE-hiredate)/365) �ټӳ��
FROM emp;

--11) ��� ������ �̸��� �Ի����� ��1996-05-14���� ���·� ��� �϶�.
SELECT ename, TO_CHAR(hiredate, 'YYYY"-"MM"-"DD')
FROM emp;

--12) ��� ������ ��ȣ, �̸�, �޿��� ����϶�. ��, �޿� �տ� ȭ��ǥ��($), �׸���
--����(,)ǥ��, �Ҽ��� ���� 2�ڸ��� ǥ�õǵ��� �϶�.
SELECT empno, ename, TO_CHAR(sal, '$999,999.99')
FROM emp;

--13) ��� ������ �̸��� �Ի��� ������ ����϶�.
SELECT ename, hiredate �Ի���, to_char(hiredate,'DAY') �Ի���� from emp;
