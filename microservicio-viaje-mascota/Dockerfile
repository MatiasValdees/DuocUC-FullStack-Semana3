# Build stage
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean install -DskipTests=true

# Run stage
FROM eclipse-temurin:21-jdk-alpine AS runner

WORKDIR /app
COPY --from=builder /app/Wallet_FirstDB wallet
COPY --from=builder /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]