# Appium Mobile Automation Project 📱

Este proyecto es un framework de automatización para aplicaciones Android utilizando **Appium** y **Java**. Se centra en la validación de flujos de configuración del sistema (Network/Internet) aplicando estándares de calidad profesional.

## 🛠️ Tecnologías y Herramientas
* **Lenguaje:** Java
* **Framework de Automatización:** Appium
* **Gestor de Dependencias:** Maven
* **Patrón de Diseño:** Page Object Model (POM)
* **Framework de Testing:** TestNG

## 🚀 Características del Proyecto
* **E2E Testing:** Validación de flujos completos.
* **Mantenibilidad:** Uso de `BasePage` para centralizar acciones comunes y esperas explícitas.
* **Robustez:** Localización de elementos mediante Accessibility Labels (`contentDescription`) asegurando la estabilidad frente a cambios en la interfaz.
* **Clean Code:** Separación clara entre la lógica de la página y los casos de prueba.

## 🌐 Automatización Híbrida y Web
El proyecto ha sido extendido para soportar pruebas en navegadores móviles (Chrome) y aplicaciones híbridas, implementando soluciones avanzadas para desafíos comunes de Appium:

* **Context Switching:** Lógica dinámica para identificar y cambiar entre contextos `NATIVE_APP` y `CHROMIUM/WEBVIEW`.
* **Dynamic Wait Strategies:** Implementación de esperas explícitas con `WebDriverWait`.
* **Driver Auto-Management:** Configuración del servidor para la gestión automática de `chromedriver`, garantizando compatibilidad entre el driver y la versión del navegador en el dispositivo.

## 🚀 Retos Técnicos Resueltos (Troubleshooting)
Durante el desarrollo, se solventaron bloqueos críticos de configuración:
1. **Conflicto de Capabilities:** Resolución de errores de sesión (SessionNotCreated) mediante la separación de lógica entre `appPackage` y `browserName`.
2. **Seguridad del Servidor:** Implementación de permisos `--allow-insecure`.

## 📈 Próximos Pasos
* Integración con herramientas de reporte (Allure/ExtentReports).
* Ampliación de la suite de pruebas para cubrir más módulos del sistema.
* Ejecución en dispositivos reales mediante servicios en la nube.