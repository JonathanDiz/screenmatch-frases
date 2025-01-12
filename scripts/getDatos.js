// URL base de la API
const baseURL = 'http://localhost:8081/api/frases';

export default function getDatos(endpoint = '') {
    return fetch(`${baseURL}${endpoint}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .catch(error => {
            console.error(`Error al acceder al endpoint ${endpoint}`, error);
        });
}
