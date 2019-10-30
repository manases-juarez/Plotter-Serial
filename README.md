# Plotter-Serial
Prgrama para enviar datos por medio del puerto paralelo como también la recepción de datos.
El puerto serial es una interfaz de comunicaciones entre ordenadores y periféricos el cual envía y recibe información BIT por BIT, entre los puertos seriales se puede mencionar el puerto de los antiguos modelos de teclados y módems
Un puerto serial posee un conector estándar y trabaja con un protocolo que permite la conexión de dispositivos al computador. Se denomina «serial» porque el puerto serie «serializa» los datos. Esto quiere decir que toma un byte de datos y transmite los 8 bits del byte de uno en uno.

Los puertos seriales utilizan un chip especial denominado UART (Universal Asynchronous Reciever/Transmitter). Este chip toma la salida paralela del bus del computador y lo convierte en forma serial, lo que permite la transmisión de los datos a través del puerto.

El conector externo para un puerto serial puede ser de 9 o de 25 pines.

Para esta aplicación se utiliza el puerto paralo del ordenador utilizandolo a modo de comnicación serial, el puerto paralelo tiene 25 pines, de los cuales se utilizan 3 pines: el pin 2 que es utilizado para el envío de datos (Output) y también se utiliza en pin 25 como tierra (Ground) y el pin 15 como el pin de entrada de datos (Input).
