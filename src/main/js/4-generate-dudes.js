
function insertSimpleDude(skill, languageName, knows) {
  db.dudes.insert({
              skill: skill,
      info: {languages: [{name: languageName, knows: knows}]}
    }
  );
}

function generateDudes(numDudes) {
  var languages = ["Java", "Ruby", "Python", "Scala", "C#"]
  for (var i = 0; i < numDudes; i++) {
    insertSimpleDude(
      Math.random() * 10000 << 0,
      languages[Math.random() * languages.length << 0],
      Math.random() * 2 << 0 === 0
    )
  }
}

generateDudes(500000);

var query = { skill: { $gt: 7000 }, "info.languages": { $elemMatch: { name: "Java", knows: true } } };
db.dudes.count( query );
db.dudes.find( query).explain();

db.dudes.ensureIndex(
        { skill: 1, "info.languages.name": 1},
        { unique: true, dropDups: true }
);