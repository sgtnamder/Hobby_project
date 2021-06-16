'use strict';

const output = document.getElementById("output");

const getRaces = async () => {
    fetch(`http://localhost:8080/race/`)
        .then((response) => {
            if (response.status !== 200) {
                console.error(`status: ${reponse.status}`);
                return;
            }
            response.json()
                .then(data => renderRace(data));
        }).catch((err) => console.log(`Fetch Error:${err}`));
}

let renderRace = ({ id, Name, Date, Time }) => {
    let column = document.createElement("div");
    column.className = "col";

    let card = document.createElement("div");
    card.className = "card";
    column.appendChild(card);

    let cardBody = document.createElement("div");
    cardBody.className = "card-body";
    card.appendChild(cardBody);

    let raceText = document.createElement("p");
    raceText.className = "card-text";
    raceText.innerText = `Name: ${Name}, Date: ${Date}, Time: ${Time} `;
    cardBody.appendChild(raceText);

    let cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    let deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        deleteRace(id);
    });
    cardFooter.appendChild(deleteButton);

    output.appendChild(column);
}

getRaces();

document.getElementById("createRaceForm").addEventListener("submit", function (event) {
    event.preventDefault();

    let data = {
        Name: this.Name.value,
        Date: this.Date.value,
        Time: this.Time.value
    }

    fetch("http://localhost:8080/race/add", {
        method: 'post',
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(data)          
        )
})
    .then(res => {
        getRaces();
        res.json();

    })

    .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    .catch((error) => console.log(`Request failed ${error}`))
});

const deleteRace = async (id) => {
    fetch("someURL/" + id, {
        method: 'delete',
    })
        .then((data) => {
            console.log(`Request succeeded with JSON response ${data}`);
        })
        .catch((error) => console.log(`Request failed ${error}`))
};