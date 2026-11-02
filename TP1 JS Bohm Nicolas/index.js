// Trabajo Práctico: Algoritmia con Arrays y Strings

// 1. Crear un array de palabras
const palabras = [];

for (let i = 0; i < 5; i++) {
  const entrada = prompt(`Ingrese la palabra ${i + 1} de 5:`);
  palabras.push(entrada ? entrada.trim() : "");
}

console.log("Array original:", palabras);


// 2. Manipular el array
palabras.unshift("Inicio");
palabras.push("Final");
palabras.splice(1, 1);

console.log("Array actualizado:", palabras);


// 3. Analizar las palabras
console.log("--- Análisis ---");
let palabraMasLarga = "";

for (const palabra of palabras) {
  console.log(`"${palabra}" -> ${palabra.length} caracteres`);
  
  if (palabra.length > palabraMasLarga.length) {
    palabraMasLarga = palabra;
  }
  
  const tieneA = palabra.toLowerCase().includes("a");
  console.log(`¿Contiene 'a'?: ${tieneA ? "Sí" : "No"}`);
}

console.log(`Más larga: "${palabraMasLarga}"`);


// 4. Juego de inversión
const palabrasInvertidas = palabras.map(p => p.split("").reverse().join(""));
console.log("Invertidas:", palabrasInvertidas);
alert("Palabras invertidas:\n" + palabrasInvertidas.join(", "));


// 5. Palíndromo
const respuesta = prompt("¿Desea comprobar palíndromos? (sí/no)");

if (respuesta && respuesta.toLowerCase().trim() === "sí") {
  console.log("--- Palíndromos ---");
  for (const palabra of palabras) {
    const pMin = palabra.toLowerCase();
    const inv = pMin.split("").reverse().join("");
    
    if (pMin === inv && pMin.length > 0) {
      console.log(`"${palabra}" ES palíndromo`);
    } else {
      console.log(`"${palabra}" NO es palíndromo`);
    }
  }
}