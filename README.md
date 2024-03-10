# Reto2_FullStackCore-Digital-Nao

# **Google Scholar API - SerpApi**

SerpApi permite extraer diferentes resultados SERP de consultas de búsqueda en este caso de Google Scholar. Para poder acceder a ella se utiliza el siguiente endpoint:

## `https://serpapi.com/search?`

Parámetros del API

### **Search Query**

| Parámetro | Requerido | Descripción |
| --- | --- | --- |
| q | Verdadero | Define la consulta que se vaya a realizar ya sea por alguna característica ejemplo: autor, ciudades, tema, etc. También se puede hacer uso del operador or para englobar dos resultados posibles. |

### **Parámetros avanzados de Google Scholar**

| Parámetro | Requerido | Descripción |
| --- | --- | --- |
| cites | Opcional | Permite activar las búsquedas por el uso de el ID de un artículo, mostrando así una lista de documentos citados en Google Scholar. |
| as_ylo | Opcional | Con este parámetro se define el año a partir de donde se desea que se obtengan los resultados, es decir solo se tendrán resultados empezando desde el año definido. |
| as_yhi | Opcional | Con este parámetro se define el año hasta donde se desea que se obtengan los resultados, es decir solo se tendrán resultados hasta el año definido. |
| SCISBD | Opcional | Con este parámetro se definen los artículos agregados en el último año, donde se puede configurar solo resúmenes o incluir todo, los valores predeterminados están ordenados por relevancia. 1 2 0 |
| cluster | Opcional | Con este parámetro de puede definir el identificador único de un artículo para desencadenar búsquedas de todas las versiones. Se encentra prohibido el uso de parámetros con la conjunción y. |

### Localización

| Parámetro | Requerido | Descripción |
| --- | --- | --- |
| hl | Opcional | Con este parámetro se permite definir el idioma que será utilizado para la búsqueda de Google Scholar. Por ejemplo: en, es, fr, etc. |
| lr | Opcional | Este parámetro permite definir uno o varios idiomas a los que se limitan la búsqueda. lang_fr | lang_de |

### Paginación

| Parámetro | Requerido | Descripción |
| --- | --- | --- |
| start | Opcional | Con este parámetro permite definir el rango de resultados de las páginas por defecto es la primera página de resultados. |
| num | Opcional | Con este parámetro define el número máximo máximo de resultados que se van a devolver. |

### **Tipo de búsqueda**

| Parámetro | Requerido | Descripción |
| --- | --- | --- |
| as_sdt | Opcional | Este parámetro permite definir como criterio de búsqueda los tribunales específicos al asignar su respectivo código en el parámetro. |

### Filtros avanzados

| Parámetro | Requerido | Descripción |
| --- | --- | --- |
| safe | Opcional | Con este parámetro se define el nivel de filtrado para evitar contenido para adultos. |
| filter | Opcional | Este parámetro permite definir si los filtros de ‘Resultados similares’ y ‘Resultados omitidos’ se encuentran activados o desactivados. 1 0  |
| as_vis | Opcional | Permite definir si se desea incluir ciertas citas o no, para excluir esos resultados se puede usar 0 y 1 para incluir. |
| as_rr | Opcional | Permite filtrar artículos de revisión o no, para habilitar este filtro se puede definir 1 o 0 para no mostrar. |

### **Parámetros de SerpApi**

| Parámetro | Requerido | Descripción |
| --- | --- | --- |
| engine | Verdadero | Permite establecer el motor de la API de Google Scholar |
| no_cache | Opcional | Este parámetro obliga al SerpApi a obtener los resultados incluso si ya está presente una versión en caché, pero es solo válida si los parámetros son exactamente iguales. |
| async | Opcional | Con este parámetro se define como enviar la búsqueda a SerpApi, permite configurar como obtener los resultados o solamente realizar la consulta y obtenerlos más tarde. |
| api_key | Verdadero | Este parámetro define la clave privada SerpApi que se va a utilizar |
| output | Opcional | Permite establecer el formato de salida para obtener los resultados finales, se puede establecer json para obtener estructurados los datos o html para recuperarlo sin procesar. |

### **Resultados de la API**

**Resultados JSON**

Como resultados de la salida en JSON se obtienen datos estructurados que permiten facilitar su comprensión al tener una organización detalle a detalle.

**Resultados HTML**

Como resultados de la salida HTML se pueden obtener datos que permiten depurar resultados JSON.

### **Ejemplos de API**

Ejemplo con q : programación

![image](https://github.com/FreddyArreagaM/Reto2_FullStackCore-Digital-Nao/assets/127709400/e34553ec-9699-4b87-99ca-5fa9ac107de1)
