# Scala Kata

Level: Easy

Author: Alvaro Del Pozo

## Space Monkey Rocket 

![alt text](https://github.com/5u5iu5/monkeyRocketTdd/blob/master/src/images/monkeyrocket.png "Logo")

### Requisitos

La ESA nos está pidiendo un programa que lance un cohete espacial para comprobar que efectivamente hay vida inteligente fuera de la Tierra. 
Para ello nos establece estos requisitos en base a la primera tanda de ideas "y si"

- En el cohete irán 2 monos. Los ingenieros no se fían de los humanos. 
- El cohete será lanzado con una configuración, da igual que tipo de Setup, excepto que no tenga Setup (**NoSetup**). De ser así el cohete no seŕa lanzado devolviendo false.
- Antes de lanzar, lógicamente viene la famosa cuenta atrás, con lo que el método de lanzamiento realizará una cuenta atrás a partir de 10.
- Teniendo en cuenta que los monos el día antes se han puesto de M en otro experimento, es posible que hayan desconfigurado la configuración inicial del cohete.
Y en la cuenta atrás se desconfigure (llamada obligatoria al método **monkeyTouching** de la clase MonkeyTouchingLikeCrazy) teniendo que volver a realizar los ajustes para su correcto funcionamiento.
- El lanzamiento devolverá un booleano si fue bién true y si fue mal false.

Siguiente tanda de requisitos por parte de la ESA:

- Ahora se han puesto finos, y no se quiere un boolean como resultado, si no que se devuelva un objecto String con el mensaje "COHETE LANZADO" y en caso de error una excepción de tipo __MonkeyTouchingException__.
- Si no se pasa nada de configuración en el lanzamiento se entiende que es la configuración por defecto. Y ahora se controla que la configuración por defecto no sea __NoSetup__. Si fuera así, se devolvería un error en la construcción IllegalArgumentException
- La cuenta atrás podrá ser de un número que se quiera, no necesariamente de 10.
- Se han dado cuenta que quizás los monos no sean tampoco adecuados, por eso, se ha creado una normativa en la cual se añade la regla de que al método launcherRocket se pasa como argumento la función de **monkeyTouching** y se tendrá en cuenta que si por algún motivo los monos tocan el panel de control y tenemos un panel loco (__CrazySetup__) se abortará dicha cuenta atrás devolviendo una excepción __MonkeyTouchingException__.


## Como empezar

Para empezar, haz fork del repo, realiza el ejercicio y pasa los test "sbt test". 

Cuando acabes el ejercicio, comitea los cambios y sientete libre de hacer una pull request.

En el test **SpaceMonkeyRocketSpec**, tenemos una aproximación que nos valdrá para empezar a codificar. El nombre del servicio ya te lo da el propio test __SpaceMonkeyRocket__. Será una clase.
De cara a codificar en un mismo camino todos, el nombre del método, vamos a denominarlo **launcherRocket**. A partir de aquí, libertad absoluta. 
Y sentir libertar de crear nuevos tests si lo necesitáis.

## Pasando los tests

```
sbt test
```

