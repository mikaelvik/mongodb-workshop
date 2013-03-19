
// Inkrementer skills pga mongodb-kunnskap
db.dudes.update(
  { name: /Mikael/ },
  { $inc: {skill: 500} }
);

// legg til languages
db.dudes.update(
  {name: "Mikael Vik"},
  { $set:
    {"info.languages": [
      {name: "Java", knows: true},
      {name: "Cobol", knows: false}
    ] }
  }
);

function updateDude(name, languages) {
  db.dudes.update(
    { name: name },
    { $set: {"info.languages": languages} }
  )
};

updateDude(/Andreas/, [{name: "Java", knows: false}, {name: "Ruby", knows: true}]);
updateDude(/Ketil/, [{name: "Norsk", knows: true}, {name: "Java", knows: true}, {name: "Tysk", knows:false}])
updateDude(/Charlie/, [{name: "JavaScript", knows: true}])
// legg gjerne til språk for fleire dudes
