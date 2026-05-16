# 🐱 Spring Boot Cat API

Simple REST API built with Spring Boot for managing cats.

## 🚀 Features

- Get all cats
- Get cat by ID
- Create cats
- Update cats
- Delete cats
- Spring Data JPA
- RESTful API structure

---

# 📦 Technologies

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- SQLite

---

# ▶️ Run the project

```bash
mvn spring-boot:run
```

Server runs on:

```text
http://localhost:8080
```

---

# 📌 API Endpoints

Base URL:

```text
/api
```

---

# 🐾 Get all cats

## Request

```http
GET /api/cats
```

## Example

```bash
curl http://localhost:8080/api/cats
```

## Response

```json
[
  {
    "id": 1,
    "name": "Milo",
    "picUrl": "https://example.com/cat1.jpg"
  },
  {
    "id": 2,
    "name": "Luna",
    "picUrl": "https://example.com/cat2.jpg"
  }
]
```

---

# 🐾 Get cat by ID

## Request

```http
GET /api/cats/{id}
```

## Example

```bash
curl http://localhost:8080/api/cats/1
```

## Response

```json
{
  "id": 1,
  "name": "Milo",
  "picUrl": "https://example.com/cat1.jpg"
}
```

---

# 🐾 Create a cat

## Request

```http
POST /api/cats
```

## Body

```json
{
  "name": "Milo",
  "picUrl": "https://example.com/cat.jpg"
}
```

## Example

```bash
curl -X POST http://localhost:8080/api/cats \
-H "Content-Type: application/json" \
-d '{
  "name": "Milo",
  "picUrl": "https://example.com/cat.jpg"
}'
```

## Response

```json
{
  "id": 1,
  "name": "Milo",
  "picUrl": "https://example.com/cat.jpg"
}
```

---

# 🐾 Update a cat

## Request

```http
PUT /api/cats/{id}
```

## Body

```json
{
  "name": "Garfield",
  "picUrl": "https://example.com/garfield.jpg"
}
```

## Example

```bash
curl -X PUT http://localhost:8080/api/cats/1 \
-H "Content-Type: application/json" \
-d '{
  "name": "Garfield",
  "picUrl": "https://example.com/garfield.jpg"
}'
```

## Response

```json
{
  "id": 1,
  "name": "Garfield",
  "picUrl": "https://example.com/garfield.jpg"
}
```

---

# 🐾 Delete a cat

## Request

```http
DELETE /api/cats/{id}
```

## Example

```bash
curl -X DELETE http://localhost:8080/api/cats/1
```

## Response

```http
204 No Content
```

---

# 📁 Project Structure

```text
src
 └── main
     └── java
         └── com.example.demo
             ├── controller
             ├── dto
             ├── entities
             ├── repositories
             └── services
```

---

# 🧠 Example Entity

```java
@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String picUrl;
}
```

---

# 👨‍💻 Author

Made by Sergi Navarro Moraleda.
