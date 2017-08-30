var express = require("express");
var cors = require("cors");
var bodyParser = require("body-parser");
var app = express();

var skierTerms = [
    {
        term: "Mohammad Taufik Andrian",
        defined: "Let her go!!!"
    },
    {
        term: "Mohammad Taufik Andrian",
        defined: "Wish you were here"
    },
    {
        term: "Mohammad Taufik Andrian",
        defined: "Wimba my new mate"
    }
];

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.use(function(req, res, next) {
	console.log(`${req.method} request for '${req.url}' - ${JSON.stringify(req.body)}`);
	next();
});

app.use(express.static("./public"));

app.use(cors());

app.get("/dictionary-api", function(req, res) {
	res.json(skierTerms);
});

app.post("/dictionary-api", function(req, res) {
    skierTerms.push(req.body);
    res.json(skierTerms);
});

app.delete("/dictionary-api/:term", function(req, res) {
    skierTerms = skierTerms.filter(function(definition) {
        return definition.term.toLowerCase() !== req.params.term.toLowerCase();
    });
    res.json(skierTerms);
});

app.listen(3000);

console.log("Express app running on port 3000");

module.exports = app;