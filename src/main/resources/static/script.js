// Base URL for the API
const API_URL = '/api/movies';

// Handle Add Movie Form Submission
document.getElementById('addMovieForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission

    // 1. Gather data from form inputs
    const name = document.getElementById('name').value;
    const description = document.getElementById('description').value;
    const genre = document.getElementById('genre').value;
    const rating = document.getElementById('rating').value;

    // 2. Create the movie object
    const movieData = {
        name: name,
        description: description,
        genre: genre,
        rating: rating ? parseFloat(rating) : null
    };

    // 3. Send POST request to backend
    fetch(API_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(movieData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to add movie');
        }
        return response.json();
    })
    .then(data => {
        // 4. Show success message
        const resultDiv = document.getElementById('addResult');
        resultDiv.textContent = 'Success! Movie added with ID: ' + data.id;
        resultDiv.className = 'result-message success';
        
        // Clear form
        document.getElementById('addMovieForm').reset();
    })
    .catch(error => {
        // Handle errors
        const resultDiv = document.getElementById('addResult');
        resultDiv.textContent = 'Error: ' + error.message;
        resultDiv.className = 'result-message error';
    });
});

// Handle Search Movie
function searchMovie() {
    // 1. Get ID from input
    const id = document.getElementById('searchId').value;
    const resultDiv = document.getElementById('searchResult');
    const errorDiv = document.getElementById('searchError');

    // Reset displays
    resultDiv.style.display = 'none';
    errorDiv.textContent = '';

    if (!id) {
        errorDiv.textContent = 'Please enter an ID.';
        return;
    }

    // 2. Send GET request to backend
    fetch(API_URL + '/' + id)
    .then(response => {
        if (response.status === 404) {
            throw new Error('Movie not found');
        }
        if (!response.ok) {
            throw new Error('Error fetching movie');
        }
        return response.json();
    })
    .then(movie => {
        // 3. Display movie details
        document.getElementById('displayTitle').textContent = movie.name;
        document.getElementById('displayId').textContent = movie.id;
        document.getElementById('displayGenre').textContent = movie.genre || 'N/A';
        document.getElementById('displayRating').textContent = movie.rating || 'N/A';
        document.getElementById('displayDesc').textContent = movie.description || 'No description available.';
        
        resultDiv.style.display = 'block';
    })
    .catch(error => {
        // Handle errors
        errorDiv.textContent = error.message;
    });
}
