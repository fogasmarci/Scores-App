document.addEventListener("DOMContentLoaded", function() {
    // Get the search icon and the form
    const searchIcon = document.getElementById("search-icon");
    const searchForm = document.getElementById("search-form");

    // Add a click event listener to the search icon
    searchIcon.addEventListener("click", function() {
        // Toggle the display property of the form
        if (searchForm.style.display === "none") {
            searchForm.style.display = "block";
            searchIcon.style.display = "none";
        } else {
            searchForm.style.display = "none";
        }
    });

    searchForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the default form submission

        const query = document.querySelector('input[name="search_term"]');
        const queryValue = query.value

        fetch(`/api/search?searchTerm=${encodeURIComponent(queryValue)}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Competition not found');
                }
                return response.text();
            })
            .then(competitionName => {
                // Redirect to the competition URL
                window.location.href = `/competition/${queryValue}`;
            })
            .catch(error => {
                console.error('Error:', error);
                // Optionally, display an error message to the user
                alert('Competition not found');
            });
    });
});