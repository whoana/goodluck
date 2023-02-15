set LIBS=C:\mocomsys\workspace\calculators\calclibrary\target\calclibrary-0.0.1-SNAPSHOT.jar
set LIBS=%LIBS%;"C:\mocomsys\workspace\calculators\calmain\target\calmain-0.0.1-SNAPSHOT.jar";.\classes
java -cp %LIBS% org.calmain.Main %*
