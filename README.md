# 🌦️ Weather Dashboard (Backend)

A simple Spring Boot backend that fetches current and hourly weather data using the Open-Meteo API.

---

## ✅ Progress

- ✅ Backend completed with Spring Boot  
- 🔧 Currently working on the frontend integration (React coming soon!)

---

## 📌 API Endpoints

### `/api/weather/current`
Returns current temperature & wind speed.

**Params:**  
- `latitude`  
- `longitude`

---

### `/api/weather/hourly`
Returns weather data for a specific hour.

**Params:**  
- `lat`  
- `lon`  
- `time` (e.g., `2025-04-10T13:00`)

---

## 🚀 How to Run

Make sure Java and Maven are installed.

```bash
mvn spring-boot:run
