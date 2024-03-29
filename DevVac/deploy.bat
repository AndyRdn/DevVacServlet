cls
set server_directory="C:\Program Files\Apache Software Foundation\Tomcat 10.1"

xcopy "out\production\DevVac" "web\WEB-INF\classes" /Y /E /I
@REM manao war
jar -cvf DevVac.war -C web .
@REM deployer
copy DevVac.war %server_directory%\webapps