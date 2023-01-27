-------------------------
-- 인터페이스 리스트 조회
------------------------- 
SELECT 	
		 a.INTEGRATION_ID	AS "인터페이스ID"
		,a.INTERFACE_NM		AS "인터페이스명"
--		,b.STATUS 
		,''					AS "상태명"
		,b01.BUSINESS_NM	AS "업무명"
		,c01.SYSTEM_NM  	AS "송신시스템명"
		,d01.SYSTEM_NM  	AS "수신시스템명"
--		,a.DATA_PR_DIR
		,''					AS "데이터처리방향"
--		,a.APP_PR_METHOD
		,'' 				AS "APP처리방식"
--		,a.DATA_PR_DIR
		,''					AS "데이터처리방향"
		,a01.USER_NM 		AS "등록자명"
		,a.REG_DATE
		,a02.USER_NM 		AS "수정자명"
		,a.MOD_DATE
  	  FROM TAN0201 a
INNER JOIN TAN0101 b
		ON a.INTERFACE_ID = b.INTERFACE_ID 
INNER JOIN TIM0301 b01
        ON b01.BUSINESS_ID = b.BUSINESS_ID 
INNER JOIN TAN0213 c
		ON a.INTERFACE_ID = c.INTERFACE_ID 
	   AND c.NODE_TYPE = '0'
	   AND c.SEQ = (SELECT max(SEQ) FROM TAN0213 WHERE INTERFACE_ID = c.INTERFACE_ID AND NODE_TYPE = '0')
INNER JOIN	TIM0101 c01 
		ON c01.SYSTEM_ID = c.SYSTEM_ID 
INNER JOIN TAN0213 d
		ON a.INTERFACE_ID = d.INTERFACE_ID 
	   AND d.NODE_TYPE = '2'	   
	   AND d.SEQ = (SELECT max(SEQ) FROM TAN0213 WHERE INTERFACE_ID = d.INTERFACE_ID AND NODE_TYPE = '2')
INNER JOIN TIM0101 d01
		ON d01.SYSTEM_ID = d.SYSTEM_ID
INNER JOIN tsu0101 a01 
		ON a01.USER_ID = a.REG_USER 
LEFT OUTER JOIN tsu0101 a02 
		ON a02.USER_ID = a.MOD_USER
		
-------------------------
-- 인터페이스 상세 조회
-------------------------
SELECT 
	 인터페이스ID(인티그레이션ID)
	,인터페이스명 
	,상태명 
	,업무명  
	,송신시스템명 
	,수신시스템명 
	,데이터처리방식명  
	,APP처리방식
	,데이터처리방향명 		
	,등록일 (yyyymmdd hh24miss)
	,등록자명 
	,수정일 
	,수정자명 
	,송신담당자명 
	,수신담당자명  
  FROM tan0201
 WHERE INTERFACE_ID = 'F@00000508'
;