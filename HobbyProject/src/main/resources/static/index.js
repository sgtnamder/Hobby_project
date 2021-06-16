'use strict';

const output = document.getElementById("output");

const getRace = async () => {
    const res = await axios.get("/race/");
    output.innerHTML = "";
    res.data.forEach(race => renderRace(race));
}

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

const deleteRace = async (id) => {
    const res = await axios.delete(`/race/delete/${id}`);
    getCars();
};

const updateRace = async (id) => {

    const data = {
        Name: this.Name.value,
        Date: this.Da.value,
        Time: this.Time.value
    }
    const
}