clear
echo "----------------------------------------------"
echo "-- KOREAN CALCULATOR V1.0 "
echo "----------------------------------------------"
LIBS=/Users/whoana/DEV/workspace-study/korean-calculator/lib/target/korean-calculator-lib-1.0.jar
LIBS=$LIBS:/Users/whoana/DEV/workspace-study/korean-calculator/app/target/korean-calculator-app-1.0.jar
java -cp $LIBS com.whoana.app.Main "$1"