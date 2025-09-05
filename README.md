# 🤖 Ollama AI Backend

## 🚀 Overview
This project is a **Java Spring Boot backend** designed to interact with the **Ollama AI runtime** running locally on your machine.  
It provides REST APIs to send prompts to Ollama, fetch AI-generated responses, and serve them to the frontend client.  
The system is lightweight, modular, and easy to integrate with other services.

---

## 💻 Tech Stack  
- **Java 17** (Core programming language)  
- **Spring Boot 3.1** (Backend framework)  
- **Maven** (Dependency management & build tool)  
- **Ollama** (Local AI runtime)  
- **Postman** (API testing)  

---

## 🔑 Key Features  
- ✅ **Ollama integration** (send prompts and get responses)  
- ✅ **Lightweight REST API** (easy to consume from frontend apps)  
- ✅ **Configurable runtime** (set port and properties in `application.properties`)  
- ✅ **Model flexibility** (support for multiple Ollama models like LLaMA2, Mistral, etc.)  

---

## 🛠 Setup Guide  

### 🔧 Prerequisites  
Before running the application, make sure you have the following installed:  

| Requirement      | Version   | Download Link                                |
|------------------|-----------|-----------------------------------------------|
| **Java**         | 17+       | [Download Java](https://adoptium.net/)        |
| **Maven**        | 3.8+      | [Download Maven](https://maven.apache.org/)   |
| **Ollama**       | Latest    | [Download Ollama](https://ollama.ai/download) |
| **Git**          | Latest    | [Download Git](https://git-scm.com/)          |

---

### ⚙️ Installation & Run  

1. **Install Ollama**  
Download and install Ollama from: [https://ollama.ai/download](https://ollama.ai/download)  

Verify installation:  
```bash
ollama --version
```


2. **Download a DeepSeek model**
Ollama requires at least one model to generate responses.
For this project, you can pull the DeepSeek model:

```bash
ollama pull deepseek-coder:6.7b
```

3. **Clone the repository**

```bash
git clone https://github.com/bhuvanesh2207/ollama-ai-be.git
cd ollama-ai-be
```

4. **Run the backend**  
If using **Maven**:  
```bash
mvn clean install
mvn spring-boot:run
```

## 🏁 Conclusion  

The **Ollama AI Backend** provides a simple and extensible way to interact with large language models using the local **Ollama runtime**.  
By setting up Ollama and pulling a model such as **DeepSeek**, developers can quickly start sending prompts and integrating AI-powered responses into their applications.  

This backend is designed to be:  
- ⚡ **Lightweight** – easy to run locally with minimal setup  
- 🔧 **Extensible** – additional models and features can be added in the future  
- 🤝 **Developer-friendly** – RESTful APIs ready for frontend integration  

With Ollama installed and running, you’re all set to build powerful AI-enabled applications on top of this backend! 🚀


