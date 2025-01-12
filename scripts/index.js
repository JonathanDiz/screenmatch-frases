import getDatos from './getDatos.js';

document.addEventListener("DOMContentLoaded", function() {
    function cargarInfoSerie() {
        getDatos('/random')
            .then(data => {
                if (data) {
                    const contenedor = document.getElementById('ficha-descripcion');
                    contenedor.innerHTML = `
                        <img src="${data.poster}" alt="Poster">
                        <h2>${data.titulo}</h2>
                        <p>${data.frase}</p>
                        <p><strong>Personaje:</strong> ${data.personaje}</p>
                    `;
                } else {
                    console.error("Datos no encontrados");
                }
            })
            .catch(error => {
                console.error("Error al obtener las informaciones de la serie:", error);
            });
    }

    // Llama a la función para cargar la información de la serie
    cargarInfoSerie();
});
