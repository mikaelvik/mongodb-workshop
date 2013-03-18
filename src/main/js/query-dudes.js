// Spørr vha id
db.dudes.find({ "_id" : ObjectId("4d0ada1fbb30773266f39fe4") });

// Match på fleire felt
db.dudes.find({
  name: /i/,
  skill : { $gt: 1000 }
});

// Inkluder/utelukk felt
db.dudes.find(
  { name: /i/, skill : { $gt : 1000 } },
  { _id: 0, name: 1, skill: 1, info: 1}
);

// Kriterier vha objekt
var skill_range = {};
skill_range['$gt'] = 667;
skill_range['$lt'] = 100000;
db.dudes.find({skill: skill_range}, {_id: 0, name: 1});
