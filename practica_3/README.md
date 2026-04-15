# Práctica 3 – Recursos Multimedia e Interacción con Imágenes

Aplicación Android desarrollada en **Kotlin** como parte de la asignatura de Desarrollo Móvil en la **Universidad La Salle (ULS)**. La app explora el uso de recursos multimedia locales y la interacción con elementos visuales dentro de una misma aplicación.

---

## 📱 Pantallas de la aplicación

### 1. `MainActivity` – Menú Principal
Pantalla de inicio que presenta dos botones de navegación:
- **Interacción con Imágenes** → navega a `ImagesActivity`
- **Reproductor de Música** → navega a `MediaActivity`

### 2. `ImagesActivity` – Interacción con Imágenes
Actividad que demuestra la interacción entre componentes de UI:
- Muestra una imagen en pantalla.
- Incluye un campo de texto para que el usuario ingrese un mensaje.
- Al **tocar la imagen**, se despliega un `Toast` con el texto introducido por el usuario.

### 3. `MediaActivity` – Reproductor de Música
Reproductor de audio funcional con las siguientes características:
- **Lista de reproducción** con tres canciones del videojuego *Hollow Knight*:
  - Mantis Lords
  - City of Tears
  - Greenpath
- **Controles de reproducción:**
  - ▶ / ⏸ Reproducir / Pausar
  - ⏮ Canción anterior
  - ⏭ Canción siguiente
- **SeekBar** interactiva para visualizar y controlar el progreso de la canción.
- El reproductor avanza automáticamente a la siguiente canción al terminar la actual.
- Muestra el nombre de la canción en reproducción.
- Portada de álbum representativa (`ImageView`).
- Barra de herramientas con botón de retroceso.

---

## 📸 Capturas de pantalla

| Menú Principal | Interacción con Imágenes | Reproductor de Música |
|:--------------:|:------------------------:|:---------------------:|
| <img width="1080" height="2400" alt="Screenshot_20260412_221556" src="https://github.com/user-attachments/assets/2b854379-6b58-4988-8d06-079d37c33729" /> | <img width="1080" height="2400" alt="Screenshot_20260412_221737" src="https://github.com/user-attachments/assets/18b78d08-9ba1-4b18-a137-3c3b23572906" /> | <img width="1080" height="2400" alt="Screenshot_20260412_221749" src="https://github.com/user-attachments/assets/db22ec4e-509a-4d7f-9a47-f2c7c6152805" />

---


## 🗂️ Estructura del proyecto

```
practica_3/
├── app/
│   └── src/main/
│       ├── java/com/uls/practica_3/
│       │   ├── MainActivity.kt        # Menú principal
│       │   ├── ImagesActivity.kt      # Interacción con imágenes
│       │   └── MediaActivity.kt       # Reproductor de música
│       ├── res/
│       │   ├── layout/
│       │   │   ├── activity_main.xml
│       │   │   ├── activity_images.xml
│       │   │   └── activity_media.xml
│       │   └── raw/
│       │       ├── mantis_lords.mp3
│       │       ├── city_of_tears.mp3
│       │       └── greenpath.mp3
│       └── AndroidManifest.xml
```

