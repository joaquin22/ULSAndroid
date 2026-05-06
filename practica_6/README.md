# practica_6

Aplicación Android desarrollada con **Kotlin + Jetpack Compose** para practicar:
- navegación entre pantallas,
- manejo de estado en Compose,
- validación de formulario,
- renderizado de listas con acciones (eliminar y favorito).

## Descripción

La app inicia en una pantalla con una lista de usuarios y un botón flotante para abrir un formulario.

### Flujo principal

1. **Lista de usuarios** (`list_users`)
    - Muestra usuarios iniciales en memoria.
    - Permite eliminar usuarios.
    - Permite marcar/desmarcar favoritos.

2. **Formulario** (`add_user`)
    - Captura nombre y edad.
    - Valida campos obligatorios.
    - Muestra un diálogo de confirmación con resumen.
    - Al confirmar, vuelve a la pantalla anterior.

> Estado actual: el formulario **no agrega** un nuevo usuario a la lista; solo valida, muestra resumen y regresa.
