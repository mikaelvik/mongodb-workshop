
function insertSimpleDude(name, skill, languageName, knows) {
  db.dudes.insert({
              name: name,
              skill: skill,
      info: {languages: [{name: languageName, knows: knows}]}
    }
  );
}

function generateDudes(numDudes) {
  var languages = ["Java", "Ruby", "Python", "Scala", "C#", "JavaScript"]
  for (var i = 0; i < numDudes; i++) {
     var language = languages[Math.random() * languages.length << 0]
    insertSimpleDude(
      "Mister-" + language + "-" + i,
      Math.random() * 10000 << 0,
      language,
      Math.random() * 3 << 0 > 0
    )
  }
}

generateDudes(500000);

var query = { skill: { $gt: 7000 }, name: /Java/ };
db.dudes.count( query );
db.dudes.find( query ).explain();

db.dudes.ensureIndex(
        { skill: 1, name: 1},
        { unique: true, dropDups: true }
);
