--1) 30���μ����������(�Ҽ�2�ڸ��Ʒ��ø�), �ְ�, ����, �ο��������Ͽ�����϶�.
SELECT ROUND(AVG(sal),1) "30�� �μ� ������ ���", MAX(sal) "�ְ�", MIN(sal) "����",COUNT(-1) "�ο���"
FROM emp
WHERE deptno = 30;

--2) ���μ����޿������(�Ҽ����Ϲݿø�), �ְ�, ����, �ο��������Ͽ�����϶�.
SELECT ROUND(AVG(sal)) "�� �μ��� �޿��� ���", MAX(sal) "�ְ�", MIN(sal) "����",COUNT(-1) "�ο���"
FROM emp
GROUP BY deptno;

--3) ���μ��������������ϴ»�����ο��������Ͽ��μ���ȣ,������, �ο����� ����϶�.
SELECT deptno "�μ���ȣ", job "������", COUNT(-1) "�ο���"
FROM emp
GROUP BY ROLLUP(job, deptno)
ORDER BY 1;

--4) �����������ϴ»���Ǽ���2���̻��ξ������ο����� ����϶�.
SELECT  job "������", COUNT(*) "�ο���"
FROM emp
GROUP BY ROLLUP(job)
HAVING COUNT(-1)>=2
ORDER BY 1;

--5) ���μ�����տ���(�Ҽ����Ϲ���), ��ü����, �ְ����, �������������Ͽ����
--�����̸�������������϶�.
SELECT FLOOR(AVG(sal)) "�� �μ��� ��� ����",SUM(sal) ��ü����,MAX(sal) �ְ����,MIN(sal) ��������
FROM emp
GROUP BY deptno
ORDER BY 1 DESC;

--6) ���μ��������������ϴ»���Ǳ޿����հ踦���Ͽ��μ���ȣ,�������޿���
--�Ұ������������϶�. �μ��������Ѵ�.
SELECT deptno,job, SUM(sal)
FROM emp
GROUP BY ROLLUP(job,deptno)
ORDER BY 1;


--7) ���μ����ο�������ȸ�ϵ��ο�����5���̻��κμ�����µǵ����Ͻÿ�.
SELECT deptno, COUNT(-1)" �� �μ��� �ο� ��"
FROM emp
GROUP BY deptno
HAVING COUNT(-1)>=5;

--8) �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
--��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���� ������
--��ȸ������� ���ܽ�Ų��.
SELECT deptno, MAX(sal) �ִ�޿�,MIN(sal) �ּұ޿�
FROM emp
GROUP BY deptno
HAVING COUNT(-1)!=1;

--9) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴�
--�������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
--��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
--�μ� ���� ��µǵ��� �ؾ� �Ѵ�.
SELECT deptno, AVG(sal) "��ձ޿�"
FROM emp
WHERE deptno IN('10','20','30') AND sal BETWEEN 2500 AND 5000
GROUP BY deptno
HAVING AVG(sal)>=2000
ORDER BY 2 DESC;










