# Documentación.
Desarrollamos una aplicación web de lista de tareas (To-Do) en la que los 
usuarios pueden cargar sus tareas. Cada tarea tiene un nombre y una 
descripción, y la aplicación incluye las funciones esenciales de un CRUD.

1. **Crear Tarea**: Permite al usuario crear tareas, agregando a estas un
nombre y una descripción para poder crearla.
2. **Listar Tareas**: Permite que el usuario vea todas las tareas que ha
creado.
3. **Editar Tarea**: El usuario tiene la posibilidad de corregir alguna tarea
que haya sido creada con anterioridad.
4. **Eliminar Tarea**: Se permitirá al usuario borrar alguna tarea que haya
creado si asi lo desea. Esta tarea se eliminará de manera permanente.
5. **Finalizar Tarea**: El usuario podrá finalizar aquellas tareas que ya
haya realizado.
6. **Rehacer Tarea**: Permite que el usuario cambie una tarea finalizada a 
pendiente si asi lo amerita. 

## Tecnologías requeridas.
Se necesita tener instalado lo siguiente para poder trabajar de manera local:

- Java 17
- MySQL

## Ejecución del proyecto de manera local.
Comience clonando el repositorio en su PC:

```sh
git clone https://github.com/HenaoGiordy/todo.git
```
Conectese a una base de datos MySQL:

```
Esta base de datos debe llamarse "todo". 
La cual debe tener como nombre de usuario "root" y contraseña "root".
```

## Ejecución del proyecto en despliegue.

## Endpoint.
Para desarrollar esta aplicación web se implementarón varios endpoints. Se
mostrará una breve descripción de la funcionalidad de cada uno y como estos
serian ejecutados de manera local. Tenga en cuenta que el puerto no siempre
es el mismo para todos.

- **Register:** Este endpoint hace una peticion POST la cual recibirá un json
en el body de la petición con el username y la password del usuario que desea 
registrarse. Esto se realizará por medio de la url:
```
http://localhost:8080/register
```
El json que recibe se veria de la siguiente manera:
```
{
    "username": "user", 
    "password": "password"
}
```
- **Login:** Este endpoint es el encargado de que la sesión del usuario 
permanezca activa, es una petición POST el cual recibe el username y la 
password. Se realizará por medio de la url:
```
http://localhost:8080/login
```
El json que recibe se veria de la siguiente manera:
```
{
    "username": "user", 
    "password": "password"
}
```
- **CreateTarea:** Este endpoint permite al usuario crear nuevas tareas, es
una peticion POST la cual recibe el nombre y descripcion de la tarea que va
a crear, ademas de esto cada tarea contará con un id unico que será otorgado
de manera automatica. Se realizará por medio de la url:
```
http://localhost:8080/tareas
```
El json que recibe se veria de la siguiente manera:
```
{
    "nombre": "tarea", 
    "descripcion": "descripcion de la tarea"
    "idCreador": "{id}"
}
```
- **GetTareas:** Este endpoint es una peticion GET que se encarga de mostrar 
todas las tareas que cada usuario a creado. Para esto se solitará el id del
usuario/creador como parametro de la url. La url para su ejecución se veria
de la siguiente manera:
```
http://localhost:8080/tareas/{id}
```
- **DeleteTarea:** Este endpoint es una petición DELETE la cual se encarga 
de borrar de manera permanente la tarea con determinado id. Por este motivo
el id de la tarea que se desea borrar debe ser enviado como parametro por
medio de la url. De la siguiente manera:
```
http://localhost:8080/tareas/{id}
```
- **EditTarea:** Este endpoint es una petición PUT que permite actualizar la
información de alguna tarea que anteriormente haya sido creada. Para esto de
manera interna obtendrá el id de la tarea que va a editar y tambien devolverá
la información que anteriormente habia sido suministrada. Su url seria:
```
http://localhost:8080/tareas
```
El json que recibe se veria de la siguiente manera:
```
{
    "nombre": "tarea editada", 
    "descripcion": "descripcion de la tarea editada"
    "id": "{id}"
}
```
- **FinalizarTarea:** Este endpoint es una petición PUT la cual cambia el
estado de una tarea de pendiente a finalizado. Para esto la url recibe el
id de la tarea como parametro. Viendose de la siguiente manera:
```
http://localhost:8080/tareas/finalizar/{id}
```
