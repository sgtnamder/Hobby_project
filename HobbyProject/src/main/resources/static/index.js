'use strict';

const output = document.getElementById("output");

// const getRaces = function () {
//     fetch(`http://localhost:8080/race/`)
//         .then((response) => {
//             if (response.status !== 200) {
//                 console.error(`status: ${reponse.status}`);
//                 return;
//             }
//             response.json()
//                 .then(data => console.info(data))

//         }).catch((err) => console.error(`${err}`));

// }
async function getRaces() {
    const response = await fetch(`http://localhost:8080/race/`);
    const get = await response.json();
    console.info(get);
    get.forEach(get => console.log(get));
    get.forEach(get => renderRace(get));
};

let renderRace = ({ id, name, date, time, drivers, }) => {
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
    raceText.innerText = `Name: ${name}, Date: ${date}, Time: ${time} `;
    cardBody.appendChild(raceText);

    let cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    let deleteButton = document.createElement("button");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        deleteRace(id);
    });
    cardFooter.appendChild(deleteButton);

    let updateButton = document.createElement("button");
    updateButton.innerText = "update";
    updateButton.className = "card-link";
    updateButton.href = "#";
    updateButton.setAttribute('data-bs-toggle', 'modal');
    updateButton.setAttribute('data-bs-target', '#updateModal');
    updateButton.addEventListener("click", function () {
        document.getElementById("updateRaceForm").addEventListener("submit", function (event) {
            event.preventDefault();

            let data = {
                name: document.getElementById("UName").value,
                date: document.getElementById("UDate").value,
                time: document.getElementById("UTime").value
            }

            fetch("http://localhost:8080/race/update/" + id, {
                method: 'PUT',
                headers: {
                    "Content-type": "application/json"
                },
                body: JSON.stringify(data)
            })
                .then(console.log(JSON.stringify(data)))
                .then(res => { res.json() })
                .then((data) => console.log(`Request succeeded with JSON response ${data}`))
                .catch((error) => console.log(`Request failed ${error}`))
        });
    });
    cardFooter.appendChild(updateButton);

    let addButton = document.createElement("button");
    addButton.innerText = "Delete";
    addButton.className = "card-link";
    cardFooter.appendChild(addButton);


    output.appendChild(column);
}

getRaces().catch((err) => console.error(`${err}`));

document.getElementById("createRaceForm").addEventListener("submit", function (event) {
    event.preventDefault();

    let data = {
        name: document.getElementById("Name").value,
        date: document.getElementById("Date").value,
        time: document.getElementById("Time").value
    }

    fetch("http://localhost:8080/race/add", {
        method: 'post',
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(console.log(JSON.stringify(data)))
        .then(res => { res.json() })
        .then(getRaces())
        .then((data) => console.log(`Request succeeded with JSON response ${data}`))
        .catch((error) => console.log(`Request failed ${error}`))
});


const deleteRace = async (id) => {
    fetch("http://localhost:8080/race/delete/" + id, {
        method: 'delete',
    })
        .then((data) => {
            console.log(`Request succeeded with JSON response ${data}`);
            getRaces();
        })
        .catch((error) => console.log(`Request failed ${error}`))
};
