docker build -t matiasvaldees/envio-internacional:week-7 .
docker push matiasvaldees/envio-internacional:week-7
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=docker matiasvaldees/envio-internacional:week-7
-------------------------
docker build -t matiasvaldees/envio-internacional:transversal .
docker push matiasvaldees/envio-internacional:transversal
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=docker matiasvaldees/envio-internacional:transversal