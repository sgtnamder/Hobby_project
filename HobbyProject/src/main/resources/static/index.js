'use strict';

const output = document.getElementById("output");
function wait() {
    setTimeout(location.reload.bind(location), 250);
}


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

    let cardHeader = document.createElement("div");
    cardHeader.className = "card-header";
    cardHeader.innerText = `Name: ${name}, Date: ${date}, Time: ${time} `;
    card.appendChild(cardHeader);

    let cardBody = document.createElement("div");
    cardBody.className = "card-body";
    card.appendChild(cardBody);

    let listGroup = document.createElement("div");
    listGroup.className = "list-group";
    cardBody.appendChild(listGroup);


    let renderDriver = ({ id, name, teamName, points, driverNum, time, position, }) => {
        let driverList = document.createElement("button");
        driverList.type = "button";
        driverList.innerText = `Name: ${name}, Team Name: ${teamName}, Points: ${points}, Driver Num: ${driverNum}, Time: ${time}, Position ${position}`;
        driverList.className = "list-group-item list-group-item-action"
        driverList.addEventListener("click", function () {
            deletedriver(id);
        })
        listGroup.appendChild(driverList);

    }
    drivers.forEach(drivers => renderDriver(drivers));

    let cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    let deleteButton = document.createElement("button");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-button";
    deleteButton.addEventListener("click", function () {
        deleteRace(id);
    });
    cardFooter.appendChild(deleteButton);

    let updateButton = document.createElement("button");
    updateButton.innerText = "update race";
    updateButton.className = "card-button";
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
                .then(wait())
                .then(res => { res.json() })
                .then((data) => console.log(`Request succeeded with JSON response ${data}`))
                .catch((error) => console.log(`Request failed ${error}`))
        });
    });
    cardFooter.appendChild(updateButton);

    let addButton = document.createElement("button");
    addButton.innerText = "Add Driver";
    addButton.className = "card-button";
    addButton.setAttribute('data-bs-toggle', 'modal');
    addButton.setAttribute('data-bs-target', '#addModal');
    addButton.addEventListener("click", function () {
        addDriver(id)
    });
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
        .then(wait())
        .then((data) => console.log(`Request succeeded with JSON response ${data}`))
        .catch((error) => console.log(`Request failed ${error}`))
});
const addDriver = async (id) => {
    document.getElementById("createDriverForm").addEventListener("submit", function (event) {
        event.preventDefault();

        let data = {
            name: document.getElementById("AName").value,
            teamName: document.getElementById("TeamName").value,
            points: document.getElementById("Points").value,
            driverNum: document.getElementById("DriverNum").value,
            time: document.getElementById("DTime").value,
            position: document.getElementById("Position").value,
            race: {
                id: id
            }
        }

        fetch("http://localhost:8080/driver/add", {
            method: 'post',
            headers: {
                "Content-type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(console.log(JSON.stringify(data)))
            .then(res => { res.json() })
            .then(wait())
            .then((data) => console.log(`Request succeeded with JSON response ${data}`))
            .catch((error) => console.log(`Request failed ${error}`))
    });
}


const deleteRace = async (id) => {
    fetch("http://localhost:8080/race/delete/" + id, {
        method: 'delete',
    })
        .then((data) => {
            console.log(`Request succeeded with JSON response ${data}`);
            wait();
        })
        .catch((error) => console.log(`Request failed ${error}`))
};

const deletedriver = async (id) => {
    fetch("http://localhost:8080/driver/delete/" + id, {
        method: 'delete',
    })
        .then((data) => {
            console.log(`Request succeeded with JSON response ${data}`);
            wait();
        })
        .catch((error) => console.log(`Request failed ${error}`))
};
