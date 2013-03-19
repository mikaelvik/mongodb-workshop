
db.dudes.insert({
  "name" : "Andreas Heim",
  "skill" : 4300,
  "employed_since" : ISODate("2008-01-31T00:00:00Z"),
  "famous_for" : [
    "Bekk Band", "Medmenneske", "RoboCup"
  ],
  "info" : {
    "seniority" : "Akkurat passe",
    "branch" : "Tech",
    "group" : "NoSQL"
  }
});

function insertDude(name, skill, employed_since, famous_for, info) {
  db.dudes.insert({
    name: name,
    skill: skill,
    employed_since: ISODate(employed_since),
    famous_for: famous_for,
    info: info
  });
}

insertDude("Mikael Vik", 667, "2006-06-13", ["Sunnmøring", "Python", "Americana"], {branch: "Tech", group: "NoSQL"});
insertDude("Ketil Velle", 668, "1982-03-03", ["Sunnmøring", "Konsertgjengar"], {branch: "Tech", group: "NoSQL"});
insertDude("Olav Folkestad", 666666, "2000-01-01", ["Sjef", "Bekk Band"]);
insertDude("Magne Davidsen", 1337, "2009-08-01", ["Rappestjernesveis", "Rekruttering"], {branch: "Tech", group: "IT Rådgivning"});
insertDude("Håvard Tegelsrud", 1994, "2010-08-01", ["Sniping"], {branch: "Tech", group: "IT Rådgivning"});
insertDude("Charlie Midtlyng", 7001, "2010-08-01", ["Flaggvifting", "Snusing", "Skysstjeneste"], {branch: "Tech", group: "Webarkitektur"});
