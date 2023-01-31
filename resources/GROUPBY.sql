-- 2023년 이후로 등록된 일자별 인터페이스 건수를 구해볼까나?
SELECT 
	 substr(a.REG_DATE,1, 8)
	,count(a.INTERFACE_ID)
	,max(a.REG_USER)
	,a.MOD_USER
  FROM tan0201 a
 WHERE a.REG_DATE >= '20220101' || '000000000'
GROUP BY substr(a.REG_DATE,1, 8) , a.MOD_USER
ORDER BY 1 desc
dsfdsffds

