# Lab 6 – Spring Boot blog with GitLab CI

Це блог-додаток на Spring Boot 3 + MySQL з налаштованим пайплайном GitLab CI.

## Як запустити локально

1. Підніміть MySQL (локально або в Docker) і створіть БД `blog_lab4`.
2. Відредагуйте при потребі `application.properties` (логін/пароль до MySQL).
3. Виконайте:

```bash
mvn clean package
java -jar target/springbootconsoleapp-0.0.1-SNAPSHOT.jar
```

Додаток буде доступний на `http://localhost:8080/blog`.

## GitLab CI

Файл `.gitlab-ci.yml` містить етапи:

- `validate` – перевірка проєкту;
- `test` – юніт-тести;
- `package` – збірка jar-артефакту;
- `integration-tests` – інтеграційні тести `*IT.java`;
- `coverage` – генерація звіту JaCoCo;
- `deploy` – умовний деплой (потрібно дописати під ваш сервер).

