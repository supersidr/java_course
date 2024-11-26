# Указываем базовый образ
FROM openjdk:17-jdk-alpine

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR-файл в контейнер
ADD build/libs/auth-0.0.1-SNAPSHOT-plain.jar app.jar

# Открываем порт приложения
EXPOSE 8080

# Указываем команду запуска JAR-файла
ENTRYPOINT ["java", "-jar", "app.jar"]
