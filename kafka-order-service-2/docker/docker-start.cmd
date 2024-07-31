for /f "delims=[] tokens=2" %%a in ('ping -4 -n 1 %ComputerName% ^| findstr [') do set NetworkIp=%%a
echo Network IP: %NetworkIp%
set DOCKERHOST=%NetworkIp%
docker-compose -f docker-compose.yaml up