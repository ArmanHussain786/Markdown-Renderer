# 📓 Markdown Note-taking App

This is a simple RESTful application built using **Spring Boot** that allows users to upload and manage Markdown notes. It also integrates a grammar checking functionality using **LanguageTool** and renders Markdown content to HTML.

---

## ✨ Features

- ✅ Upload and save Markdown notes
- ✅ Grammar check for Markdown content
- ✅ List all saved notes
- ✅ Render Markdown as HTML
- ✅ API documentation using Swagger

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot 3.x
- LanguageTool 6.6
- flexmark-java (for Markdown rendering)
- Springdoc OpenAPI (Swagger integration)
- Maven

---

## 📂 Project Structure

MarkDown-Renderer/
│
├── src/
│ ├── main/
│ │ ├── java/com/example/markdown_renderer/
│ │ │ ├── controller/ # REST Controllers
│ │ │ ├── service/ # Business Logic
│ │ │ ├── model/ # Note Model
│ │ │ └── MarkdownRendererApplication.java
│ │ └── resources/
│ │ └── application.properties
├── pom.xml
└── README.md


---

## 🚀 How to Run

### 🧰 Prerequisites

- Java 17 or higher
- Maven

## API documentation available at:

http://localhost:8080/swagger-ui/index.html

## Here is the project URL

https://roadmap.sh/projects/markdown-note-taking-app


### 🔧 Setup and Run

```bash
git clone https://github.com/ArmanHussain786/Markdown-Renderer
cd markdown-renderer
mvn spring-boot:run
