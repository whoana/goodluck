------------------------------------------
-- 2023년 이후로 등록된 일자별 인터페이스 건수
------------------------------------------
SELECT 
	 substr(a.REG_DATE,1, 8)    as "date"
	,count(a.INTERFACE_ID)      as "cnt"
  FROM tan0201 a
 WHERE a.REG_DATE >= '20220101' || '000000000'
GROUP BY substr(a.REG_DATE,1, 8) , a.MOD_USER
ORDER BY 1 desc
dsfdsffds

