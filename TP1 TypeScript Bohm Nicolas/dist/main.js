"use strict";
const API_URL = "https://thesimpsonsapi.com/api/characters";
const btnCargar = document.getElementById("btnCargar");
const loadingSection = document.getElementById("loadingSection");
const errorContainer = document.getElementById("errorContainer");
const charactersContainer = document.getElementById("charactersContainer");
const showLoading = () => {
    loadingSection.classList.remove("hidden");
    errorContainer.classList.add("hidden");
};
const hideLoading = () => {
    loadingSection.classList.add("hidden");
};
const showError = (message) => {
    errorContainer.textContent = message;
    errorContainer.classList.remove("hidden");
    setTimeout(() => {
        errorContainer.classList.add("hidden");
    }, 5000);
};
const createCharacterCard = (character) => {
    const card = document.createElement("div");
    card.classList.add("character-card");
    const img = document.createElement("img");
    img.src = `https://cdn.thesimpsonsapi.com/500${character.portrait_path}`;
    img.alt = character.name;
    const name = document.createElement("h3");
    name.textContent = character.name;
    const phrase = document.createElement("p");
    phrase.textContent = character.phrases && character.phrases.length > 0
        ? `"${character.phrases[0]}"`
        : "Sin frase disponible";
    card.appendChild(img);
    card.appendChild(name);
    card.appendChild(phrase);
    return card;
};
const renderCharacters = (characters) => {
    charactersContainer.innerHTML = "";
    characters.forEach(character => {
        const card = createCharacterCard(character);
        charactersContainer.appendChild(card);
    });
};
const fetchCharacters = async () => {
    showLoading();
    try {
        const response = await fetch(API_URL);
        if (!response.ok) {
            throw new Error("No se pudo conectar con la API de Los Simpsons.");
        }
        const data = await response.json();
        renderCharacters(data.results);
    }
    catch (error) {
        console.error("Error al obtener los personajes:", error);
        showError("Ocurrió un error al cargar los personajes. Pruebe más tarde.");
    }
    finally {
        hideLoading();
    }
};
btnCargar.addEventListener("click", fetchCharacters);
