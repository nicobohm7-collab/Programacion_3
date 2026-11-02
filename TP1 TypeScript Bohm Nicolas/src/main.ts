interface SimpsonCharacter {
    id: number;
    name: string;
    portrait_path: string;
    phrases: string[];
}

interface IResponseApi {
    count: number;
    next: string | null;
    prev: string | null;
    pages: number;
    results: SimpsonCharacter[];
}

const API_URL = "https://thesimpsonsapi.com/api/characters";

const btnCargar = document.getElementById("btnCargar") as HTMLButtonElement;
const loadingSection = document.getElementById("loadingSection" as string) as HTMLElement;
const errorContainer = document.getElementById("errorContainer") as HTMLDivElement;
const charactersContainer = document.getElementById("charactersContainer") as HTMLDivElement;

const showLoading = (): void => {
    loadingSection.classList.remove("hidden");
    errorContainer.classList.add("hidden");
};

const hideLoading = (): void => {
    loadingSection.classList.add("hidden");
};

const showError = (message: string): void => {
    errorContainer.textContent = message;
    errorContainer.classList.remove("hidden");
    setTimeout(() => {
        errorContainer.classList.add("hidden");
    }, 5000);
};

const createCharacterCard = (character: SimpsonCharacter): HTMLElement => {
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

const renderCharacters = (characters: SimpsonCharacter[]): void => {
    charactersContainer.innerHTML = "";
    characters.forEach(character => {
        const card = createCharacterCard(character);
        charactersContainer.appendChild(card);
    });
};

const fetchCharacters = async (): Promise<void> => {
    showLoading();
    try {
        const response = await fetch(API_URL);
        if (!response.ok) {
            throw new Error("No se pudo conectar con la API de Los Simpsons.");
        }
        const data: IResponseApi = await response.json();
        renderCharacters(data.results);
    } catch (error) {
        console.error("Error al obtener los personajes:", error);
        showError("Ocurrió un error al cargar los personajes. Pruebe más tarde.");
    } finally {
        hideLoading();
    }
};

btnCargar.addEventListener("click", fetchCharacters);