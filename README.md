# Scala Kata

Level: Easy

Author: Alvaro Del Pozo

## Space Monkey Rocket 

![alt text](https://github.com/5u5iu5/monkeyRocketTdd/blob/master/src/images/monkeyrocket.png "Logo")

### Requisitos

La ESA nos está pidiendo un programa que lance un cohete espacial para comprobar que efectivamente hay vida inteligente fuera de la Tierra. 
Para ello nos establece estos requisitos en base a la primera tanda de ideas "y si"

- En el cohete irán 2 monos. Los ingenieros no se fía de los humanos. 
- El cohete será lanzado con una mínima configuración para el cohete.
- Antes de lanzar, lógicamente viene la famosa cuenta atrás, con lo que el método de lanzamiento esperará una cuenta atrás a partir de 10.
- Teniendo en cuenta que los monos el día antes se han puesto de M en otro experimento, es posible que hayan desconfigurado la configuración inicial del cohete.
Y en la cuenta atrás se desconfigure (llamada obligatoria al método **monkeyTouching** de la clase MonkeyTouchingLikeCrazy) teniendo que volver a la que se pasó como parámetro.
- El lanzamiento devolverá un booleano si fue bién true y si fue mal false.

Siguiente tanda de requisitos por parte de la ESA:

- Visto los ensayos, se quiere ahora, que no se devuelva un boolean si no que se devuelva en caso de ser lanzando correctamente el setup pasado como parámetro del cohete
y en caso de error una excepción de tipo __MonkeyTouchingException__.
- Si no se pasa nada de configuración en el lanzamiento se entiende que es la configuración por defecto.
- La cuenta atrás podrá ser de un número que se quiera, no necesariamente de 10.
- Se tendrá en cuenta que si por algún motivo los monos tocan el panel de control y tenemos un panel loco (__CrazySetup__) se abortará dicha cuenta atrás devolviendo una excepción.


## Como empezar

Para empezar, bajate el repo, create una rama con tu nombre y pasa los test "sbt test". Fallarán!!

Cuando acabes el ejercicio, comitea los cambios y sientete libre de hacer una pull request.

En el test **SpaceMonkeyRocketSpec**, tenemos una aproximación que nos valdrá para empezar a codificar. El nombre del servicio ya te lo da el propio test __SpaceMonkeyRocket__. Será una clase.
De cara a codificar en un mismo camino todos, el nombre del método, vamos a denominarlo **launcherRocket**. A partir de aquí, libertad absoluta. 
Y sentir libertar de crear nuevos tests si lo necesitáis.

## Pasando los tests

```
sbt test
```

