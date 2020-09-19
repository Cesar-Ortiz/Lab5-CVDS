# Escuela Colombiana de Ingeniería

# Introducción a proyectos Web

### Integrantes:

* Maria Angélica Alfaro Fandiño
* César Fernando Ortiz Rocha

### Parte I - Jugando a ser un cliente HTTP

3. Antes de que el servidor cierre la conexión por falta de comunicación:
Revise el resultado obtenido. ¿Qué codigo de error sale?
  *  ***301 Movido Permanentemente:*** Esta y todas las solicitudes futuras deben dirigirse al URI dado 

![](https://github.com/Cesar-Ortiz/Lab5-CVDS/blob/master/Servlet/src/main/resources/error.png)

Qué otros códigos de error existen?, ¿En qué caso se manejarán?

![](https://github.com/Cesar-Ortiz/Lab5-CVDS/blob/master/Servlet/src/main/resources/tiposErrores.png)

5. ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?

![](https://github.com/Cesar-Ortiz/Lab5-CVDS/blob/master/Servlet/src/main/resources/otros.png)

### Parte III
18. El formulario debe usar como método ‘POST’, y como acción, la ruta relativa del último servlet creado (es decir la URL pero excluyendo ‘http://localhost:8080/’).

![](https://github.com/Cesar-Ortiz/Lab5-CVDS/blob/master/Servlet/src/main/resources/FormularioHTML.PNG)

20. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia observa?

*** Método GET ***

![](https://github.com/Cesar-Ortiz/Lab5-CVDS/blob/master/Servlet/src/main/resources/HTMLGet.PNG)

*** Método POST ***

![](https://github.com/Cesar-Ortiz/Lab5-CVDS/blob/master/Servlet/src/main/resources/HTMLPost.PNG)

* La diferencia se puede evidenciar cuando se observa la URL de la página WEB ya que al utilizar el método GET se muestran el parámetro id ingresado anteriormente, algo que no sucede con el POST.

21. ¿Qué se está viendo? Revise cómo están implementados los métodos de la clase Service.java para entender el funcionamiento interno.
* En la clase service.java se realiza una conexión entre la URL original y la URL connection lo que permite obtener la información de tipo HTML para que el navegador la reconozca y así mismo mostrar dicha información en forma de tabla o en forma de fila.

### Parte IV. - Frameworks Web MVC – Java Server Faces / Prime Faces

10. Si todo funcionó correctamente, realice las siguientes pruebas:
c. Dado la anterior, ¿Cuál es la diferencia entre los backing-beans de sesión y los de aplicación?
* Los backing-beans de session crean una nueva instancia del bean por cada dispositivo que se conecte al servicio. Los de aplicación crean solo un bean independientemente de los dispositivos que se conecten al servicio

d. Por medio de las herramientas de desarrollador del explorador (Usando la tecla "F12" en la mayoría de exploradores):
    * Ubique el código HTML generado por el servidor y busque el elemento oculto:

      ![](https://github.com/Cesar-Ortiz/Lab5-CVDS/blob/master/PrimeFaces/src/main/resources/contenido%20oculto.PNG)

    * En la sección de estilos, deshabilite el estilo que oculta el elemento para que sea visible.

      ![](https://github.com/Cesar-Ortiz/Lab5-CVDS/blob/master/PrimeFaces/src/main/resources/contenido%20actualizado.PNG)

# Referencias

<https://developer.mozilla.org/es/docs/Web/HTTP/Methods>

<https://en.wikipedia.org/wiki/List_of_HTTP_status_codes>

<https://es.wikipedia.org/wiki/PrimeFaces>

<https://www.primefaces.org/showcase/ui/panel/panelGrid.xhtml>