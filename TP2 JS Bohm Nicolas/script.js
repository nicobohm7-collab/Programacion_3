// ==========================================
// PUNTO 1: Funciones declarativas y expresadas
// ==========================================

// Función declarativa (se puede invocar antes de ser declarada por el "hoisting")
function calcularCuadrado(numero) {
    return numero * numero;
}
console.log("Cuadrado de 4:", calcularCuadrado(4));

// Función expresada (asignada a una variable, no sufre hoisting de la misma manera)
const calcularCubo = function(numero) {
    return numero * numero * numero;
};
console.log("Cubo de 3:", calcularCubo(3));

/* 
Diferencia: Las funciones declarativas se cargan en memoria antes de ejecutar el código (hoisting completo), 
mientras que las expresadas se comportan como variables y solo están disponibles después de la línea donde se definen.
*/


// ==========================================
// PUNTO 2: Arrow Functions y parámetros por defecto
// ==========================================

const presentarPersona = (nombre, edad = 18) => `Hola ${nombre}, tienes ${edad} años`;

console.log(presentarPersona("Ana", 22));
console.log(presentarPersona("Carlos")); // Usa el valor por defecto (18)


// ==========================================
// PUNTO 3: Objetos con propiedades y métodos
// ==========================================

const persona = {
    nombre: "Lucía",
    edad: 25,
    presentarse: function() {
        return `Hola, me llamo ${this.nombre} y tengo ${this.edad} años.`;
    }
};

console.log(persona.presentarse());

/* 
Diferencia: Las propiedades almacenan datos o valores (como strings, números), 
mientras que los métodos son funciones asociadas al objeto que realizan acciones con esos datos.
*/


// ==========================================
// PUNTO 4: Desestructuración
// ==========================================

const { nombre, edad } = persona;
console.log("Desestructuración - Nombre:", nombre, "| Edad:", edad);

/* 
Ventajas: Permite extraer múltiples propiedades de un objeto de forma limpia en una sola línea, 
evitando repetir la referencia al objeto constantemente (ej: persona.nombre, persona.edad).
*/


// ==========================================
// PUNTO 5: Operador spread/rest
// ==========================================

// Spread (...) para expandir arrays
const numerosBase = [1, 2, 3];
const numerosExtendidos = [...numerosBase, 4, 5, 6];
console.log("Spread array:", numerosExtendidos);

// Rest (...) para agrupar argumentos en una función
function sumarTodos(...args) {
    return args.reduce((acumulador, actual) => acumulador + actual, 0);
}
console.log("Suma con rest:", sumarTodos(10, 20, 30, 40));

/* 
Diferencia: "Spread" expande los elementos de un array u objeto en lugares individuales, 
mientras que "rest" agrupa múltiples elementos en un solo array dentro de los parámetros de una función.
*/


// ==========================================
// PUNTO 6: Manipulación básica del DOM
// ==========================================

const titulo = document.getElementById("tituloPrincipal");
titulo.textContent = "Trabajo Práctico Modificado";

const lista = document.getElementById("miLista");
const nuevoLi1 = document.createElement("li");
nuevoLi1.textContent = "Elemento nuevo 1";
const nuevoLi2 = document.createElement("li");
nuevoLi2.textContent = "Elemento nuevo 2";

lista.appendChild(nuevoLi1);
lista.appendChild(nuevoLi2);

titulo.classList.add("resaltado");


// ==========================================
// PUNTO 7 y 9: Eventos click, input y keydown
// ==========================================

const inputTarea = document.getElementById("inputTarea");
const btnAgregar = document.getElementById("btnAgregar");

function agregarElementoLista() {
    const texto = inputTarea.value.trim();
    if (texto !== "") {
        const nuevoLi = document.createElement("li");
        nuevoLi.textContent = texto;
        lista.appendChild(nuevoLi);
        inputTarea.value = ""; // Limpiar input
    }
}

// Evento click en el botón
btnAgregar.addEventListener("click", agregarElementoLista);

// Punto 9: Evento keydown para detectar "Enter" en el input
inputTarea.addEventListener("keydown", (e) => {
    if (e.key === "Enter") {
        agregarElementoLista();
    }
});


// ==========================================
// PUNTO 8: Evento submit y preventDefault
// ==========================================

const formulario = document.getElementById("miFormulario");
const inputForm = document.getElementById("inputForm");

formulario.addEventListener("submit", (e) => {
    e.preventDefault(); // Evita que la página se recargue por defecto
    alert(`Valor enviado desde el formulario: ${inputForm.value}`);
    inputForm.value = "";
});

/* 
preventDefault(): Sirve para cancelar el comportamiento predeterminado que tiene un elemento nativo, 
como el envío de un formulario que recarga la página por defecto.
*/


// ==========================================
// PUNTO 9: Evento change en un Select
// ==========================================

const selectOpciones = document.getElementById("miSelect");
const resultadoSelect = document.getElementById("resultadoSelect");

selectOpciones.addEventListener("change", (e) => {
    resultadoSelect.textContent = e.target.value || "Ninguna";
});

/* 
Diferencia de eventos:
- input: Se dispara inmediatamente cada vez que el valor de un campo cambia (al escribir cada letra).
- change: Se dispara cuando el valor cambia y el elemento pierde el foco (en inputs) o inmediatamente al cambiar de opción (en un select).
- keydown: Se dispara justo en el momento en que el usuario presiona una tecla hacia abajo.
*/