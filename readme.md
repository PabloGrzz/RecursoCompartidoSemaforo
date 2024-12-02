https://github.com/PabloGrzz/RecursoCompartidoSemaforo.git

Descripción

Este proyecto implementa un semáforo en Java que permite controlar el acceso concurrente a un bloque de código, asegurando que un número específico de hilos (X) puede acceder a dicho bloque al mismo tiempo. Este mecanismo es fundamental en entornos de programación concurrente donde se busca evitar condiciones de carrera y garantizar la integridad de los datos.

Este proyecto implementa un semáforo en Java que permite controlar el acceso concurrente a un recurso, pidiendo en tiempo de ejecucción cuantos hilos crear, cuantos hilos quieres que accedan a la vez, cuanto recurso compartido hay en un inicio y cuanto quieres que reste de ese recurso cada hilo. A cada hilo que acceda a la funcion para restar del recurso se le añade un tiempo en sleep simulando que lleva a cabo una tarea.
En tiempo de ejecucción tambien te muestra por pantalla los hilos que estan intentando acceder al semaforo, los hilos que adquieren un permiso para entrar, los hilos que han liberado ese permiso para que entre otro y la cantidad del recurso que va quedando despues de que cada hilo le reste una cantidad.

Características

Control de concurrencia: Permite que un número limitado de hilos accedan a un recurso compartido simultáneamente.
Bloqueo eficiente: Utiliza técnicas de sincronización para minimizar el tiempo de espera de los hilos y maximizar la eficiencia.
Personalizable: Se puede ajustar el número de hilos permitidos a través de un parámetro de configuración.

Requisitos

Java 8 o superior
Entorno de desarrollo Java (IDE) como IntelliJ IDEA, Eclipse o cualquier otro que soporte Java.
