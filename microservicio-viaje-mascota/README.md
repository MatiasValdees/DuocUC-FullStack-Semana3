docker build -t matiasvaldees/viaje-mascota:week-7 .
docker push matiasvaldees/viaje-mascota:week-7
docker run -p 8081:8080 -e SPRING_PROFILES_ACTIVE=docker matiasvaldees/viaje-mascota:week-7
----------------------------------------
docker build -t matiasvaldees/viaje-mascota:transversal .
docker push matiasvaldees/viaje-mascota:transversal
docker run -p 8081:8080 -e SPRING_PROFILES_ACTIVE=docker matiasvaldees/viaje-mascota:transversal
