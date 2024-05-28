document.addEventListener('DOMContentLoaded', function() {
    const tableRows = document.querySelectorAll('#gamesTableData tr');

    tableRows.forEach(row => {
        row.addEventListener('click', function() {
            const gameId = row.getAttribute('data-game-id');
            const url = `/game/${gameId}`;
            window.open(url, '_blank'); // Redirects the user to the new URL in the same tab
        });
    });
});