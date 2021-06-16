'use strict';

const output = document.getElementById("output");

fetch(`http://localhost:8080/race/`)
    .then((response) => {
        if (response.status !== 200) {
            console.error(`status: ${reponse.status}`);
            return;
        }
        response.json()
            .then(data.forEach(race => renderRace(race)));
    }).catch((err) => console.error(`${err}`));


const renderRace = ({ id, Name, Date, Time }) => {
    const column = document.createElement("div");
    column.className = "col";

    const card = document.createElement("div");
    card.className = "card";
    column.appendChild(card);

    const cardBody = document.createElement("div");
    cardBody.className = "card-body";
    card.appendChild(cardBody);

    const NameText = document.createElement("p");
    NameText.className = "card-text";
    NameText.innerText = `Name: ${Name}`;
    cardBody.appendChild(NameText);

    const DateText = document.createElement("p");
    DateText.className = "card-text";
    DateText.innerText = `Date: ${Date}`;
    cardBody.appendChild(DateText);

    const TimeText = document.createElement("p");
    TimeText.className = "card-text";
    TimeText.innerText = `Time: ${Time}`;
    cardBody.appendChild(TimeText);

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        deleteRace(id);
    });
    cardFooter.appendChild(deleteButton);

    output.appendChild(column);
}



document.getElementById("createForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        Name: this.Name.value,
        Date: this.Date.value,
        Time: this.Time.value
    }

    axios.post("/race/create", data)
        .then(res => {
            getRace();
            this.reset();
            this.Name.focus();
        }).catch(err => console.log(err));

    console.log(this);
});
document.getElementById("createForm").addEventListener("submit", function (event) {
    event.preventDefault();
    fetch("http://localhost:8080/race/create", {
        method: 'post',
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(
            {
                Name: this.Name.value,
                Date: this.Date.value,
                Time: this.Time.value
            }
        )
    })
        .then(res => res.json())
        .then((data) => console.log(`Request succeeded with JSON response ${data}`))
        .catch((error) => console.log(`Request failed ${error}`))
});

const deleteRace = async (id) => {
    const res = await axios.delete(`/race/delete/${id}`);
    getCars();
};

const deleteRace = async (id) => {
    fetch("someURL/" + id, {
        method: 'delete',
    })
        .then((data) => {
            console.log(`Request succeeded with JSON response ${data}`);
        })
        .catch((error) => console.log(`Request failed ${error}`))
};