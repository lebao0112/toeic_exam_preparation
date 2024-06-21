document.addEventListener('DOMContentLoaded', function() {
        const testList = [
            { title: "Test 1", description: "Description for Test 1" },
            { title: "Test 2", description: "Description for Test 2" },
            { title: "Test 3", description: "Description for Test 3" },
            { title: "Test 4", description: "Description for Test 4" },
            { title: "Test 5", description: "Description for Test 5" },
            { title: "Test 6", description: "Description for Test 6" },
            { title: "Test 7", description: "Description for Test 7" },
            { title: "Test 8", description: "Description for Test 8" }
        ];

        const testListContainer = document.getElementById('testList');

        testList.forEach(test => {
            const col = document.createElement('div');
            col.className = 'col-md-3 mb-4';

            const card = document.createElement('div');
            card.className = 'card';

            const cardBody = document.createElement('div');
            cardBody.className = 'card-body';

            const cardTitle = document.createElement('h5');
            cardTitle.className = 'card-title';
            cardTitle.textContent = test.title;

            const cardText = document.createElement('p');
            cardText.className = 'card-text';
            cardText.textContent = test.description;

            cardBody.appendChild(cardTitle);
            cardBody.appendChild(cardText);
            card.appendChild(cardBody);
            col.appendChild(card);
            testListContainer.appendChild(col);
        });

        document.getElementById('searchButton').addEventListener('click', function() {
            const query = document.getElementById('searchInput').value;
            alert('You searched for: ' + query);
            // Add your search functionality here
        });
    });