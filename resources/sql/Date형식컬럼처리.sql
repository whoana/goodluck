-----------------------------------
-- Date 형식 컬럼 처리 
-----------------------------------
SELECT 
	INTERFACE_ID,
	INTERFACE_NM,
	INTEGRATION_ID, 
	 to_date(SUBSTR(reg_date, 1, 14), 'yyyymmddHH24MISS') AS SYSTEM_REG_DATE
  FROM tan0201
 ;
----------------------------------
-- 과제 
----------------------------------
-- EMP 및 DEPT 테이블에 등록일 컬럼을 각각 추가하고 
-- EMP 및 DEPT 테이블에 신규 데이터를 한 건 추가해보기.
-- 등록일은 db의 현재 시간을 얻어와 사용하도록 
-- 등록일을 INSERT 
-- 등록일 REG_DATE VARCHAR(14) 


-- date 문자열 varchar(17) 변환
select to_char(current_timestamp(3),'yyyymmddhh24missff') from dual; 
