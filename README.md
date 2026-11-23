# Actividad Tema 6.3: Sistemas de EDOs y RK4 Vectorial (Circuito RLC)

--- 

**Alumnos:** 
Mariem Cristina García López, Diego Ortiz Morales 

---

## Descripción del proyecto

Implementación en Java del método numérico de **Runge-Kutta de 4to orden (RK4) en forma vectorial** para simular la respuesta libre de un circuito RLC serie ($L = 1\text{ H}$, $R = 0.4\ \Omega$, $C = 1\text{ F}$) con condiciones iniciales $q(0) = 1.0\text{ C}$ y $q'(0) = 0.0\text{ A}$

El programa transforma la ecuación diferencial de segundo orden en un sistema equivalente de dos ecuaciones de primer orden:

$$\begin{cases} y_1' = y_2 \\ y_2' = -y_1 - 0.4y_2 \end{cases}$$

donde $y_1(t)$ corresponde a la carga en el capacitor y $y_2(t)$ a la corriente en el circuito, comparando en cada paso la aproximación numérica contra la solución analítica exacta $q_{\text{exacta}}(t)$.

---

## Estructura del repositorio

* `RK4CircuitoRLC.java`: Contiene la definición del sistema de ecuaciones (`evaluarSistema`), la suma vectorial escalada (`sumaEscalada`) y la solución analítica (`solucionExacta`).
* `Main.java`: Ejecuta el ciclo iterativo del método RK4 vectorial para $n = 25$ puntos adicionales con tamaño de paso configurable (`h = 0.2`, `0.1`, `0.05`) e imprime la tabla comparativa en consola.

---

## Instrucciones de clonación, compilación y ejecución

1. **Clonar el repositorio:**
```bash
  git clone [https://github.com/mariemcris2212-hue/istemas-de-EDOs-y-RK4-Vectorial.git](https://github.com/mariemcris2212-hue/istemas-de-EDOs-y-RK4-Vectorial.git)
   cd istemas-de-EDOs-y-RK4-Vectorial/src
```

1. Compilar los archivos fuente desde la terminal:
javac RK4CircuitoRLC.java Main.java

2. Ejecutar el programa:
java Main

---

## Salida en pantalla (h = 0.2, nPuntos = 25)

```text
n	 t_n	 y1 (Carga)	 y2 (Corr)	 q_exacta	 Error Abs
--------------------------------------------------------------------------
0	 0.00	 1.000000	 0.000000	 1.000000	 0.00e+00
1	 0.20	 0.980523	 -0.192053	 0.980523	 2.52e-07
2	 0.40	 0.925107	 -0.359630	 0.925106	 4.57e-07
3	 0.60	 0.838424	 -0.501557	 0.838423	 6.06e-07
4	 0.80	 0.725992	 -0.617427	 0.725991	 6.94e-07
5	 1.00	 0.593877	 -0.707564	 0.593876	 7.21e-07
6	 1.20	 0.448414	 -0.772973	 0.448413	 6.92e-07
7	 1.40	 0.295957	 -0.815267	 0.295956	 6.15e-07
8	 1.60	 0.142651	 -0.836588	 0.142650	 5.00e-07
9	 1.80	 -0.005617	 -0.839523	 -0.005617	 3.59e-07
10	 2.00	 -0.143571	 -0.826992	 -0.143571	 2.03e-07
11	 2.20	 -0.266692	 -0.802143	 -0.266692	 4.49e-08
12	 2.40	 -0.371303	 -0.768224	 -0.371303	 1.06e-07
13	 2.60	 -0.454648	 -0.728482	 -0.454648	 2.40e-07
14	 2.80	 -0.514924	 -0.686051	 -0.514924	 3.51e-07
15	 3.00	 -0.551287	 -0.643850	 -0.551287	 4.33e-07
16	 3.20	 -0.563834	 -0.604484	 -0.563834	 4.84e-07
17	 3.40	 -0.553543	 -0.570147	 -0.553543	 5.04e-07
18	 3.60	 -0.522186	 -0.542544	 -0.522186	 4.93e-07
19	 3.80	 -0.472219	 -0.522833	 -0.472219	 4.57e-07
20	 4.00	 -0.406667	 -0.511583	 -0.406667	 3.99e-07
21	 4.20	 -0.328981	 -0.508762	 -0.328981	 3.25e-07
22	 4.40	 -0.242900	 -0.513734	 -0.242900	 2.41e-07
23	 4.60	 -0.152291	 -0.525279	 -0.152291	 1.53e-07
24	 4.80	 -0.060996	 -0.541645	 -0.060996	 6.68e-08
25	 5.00	 0.027366	 -0.560618	 0.027366	 1.31e-08
```