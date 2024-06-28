document.addEventListener('DOMContentLoaded', function() {

    const tableDatas = document.querySelectorAll('#gamesTableData tr');

    tableDatas.forEach(row => {
        row.addEventListener('click', function() {
            const getCustomUrl = row.getAttribute('custom-url');
            const url = `http://localhost:8080/${getCustomUrl}`;
            window.open(url, '_blank');
        });
    });


});