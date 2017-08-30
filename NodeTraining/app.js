var express = require("express");
var https = require("https");
var cors = require("cors");
var bodyParser = require("body-parser");
var data = require("./data/Training");
var fs = require("fs");
var qs = require('querystring');
var app = express();
var guitaristTerm = [
	{
		term: "Shred",
		defined: "fast scale and arpeggio runs and special effects"
	},
	{
		term: "Alternate Picking",
		defined: "a continuous down-up or up-down motion of the picking hand"
	},
	{
		term: "Tapping",
		defined: "string is fretted and set into vibration as part of a single motion of being pushed onto the fretboard"
	}
];

var option = {
	hostname : "en.wikipedia.org",
	port: 443,
	path: "/wiki/George_Washington",
	method: "GET"
};

var req = https.request(option, function(res){
	var responseBody = "";
	res.setEncoding("UTF-8");
	res.on("data", function(chunk) {
		responseBody += chunk;
	});
	res.on("end",function(){
		fs.writeFile("george-washington.html", responseBody, function(err){
			if(err){
				throw err;
			}
			console.log("File Downloaded");
		});
	});
});
req.on("error",function(err){
	console.log(`problem with request: ${err.message}`);
});
req.end();

app.use(function(req, res, next) {
	if(req.url === "/") {
		if(req.method === "GET") {
			res.writeHead(200, {"Content-Type": "text/html"});
			fs.createReadStream("./public/index.html", "UTF-8").pipe(res);
		} else if(req.method === "POST") {
			var body = "";
			req.on("data",function(obj) {
				body += obj;
				console.log(body);
			});
			
			req.on("end", function() {
				res.writeHead(200, {"Content-Type": "text/html"});
				res.end(`
				<!DOCTYPE html>
				<html>
					<head>
						<meta name="viewport" content="minimum-scale=1.0, width=device-width, maximum-scale=1.0, user-scalable=no"/>
						<meta charset="utf-8">
						<title>Dashboard</title>
					</head>
					<body>
						<h1>${body}</h1>
						<table>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Status</th>
							</tr>
							<tr>
								<td>${JSON.stringify(data[0]["firstName"])}</td>
								<td>${JSON.stringify(data[0]["lastName"])}</td>
								<td>${JSON.stringify(data[0]["email"])}</td>
								<td>${JSON.stringify(data[0]["Status"])}</td>
							</tr>
							<tr>
								<td>${JSON.stringify(data[1]["firstName"])}</td>
								<td>${JSON.stringify(data[1]["lastName"])}</td>
								<td>${JSON.stringify(data[1]["email"])}</td>
								<td>${JSON.stringify(data[1]["Status"])}</td>
							</tr>
							<tr>
								<td>${JSON.stringify(data[2]["firstName"])}</td>
								<td>${JSON.stringify(data[2]["lastName"])}</td>
								<td>${JSON.stringify(data[2]["email"])}</td>
								<td>${JSON.stringify(data[2]["Status"])}</td>
							</tr>
							<tr>
								<td>${JSON.stringify(data[3]["firstName"])}</td>
								<td>${JSON.stringify(data[3]["lastName"])}</td>
								<td>${JSON.stringify(data[3]["email"])}</td>
								<td>${JSON.stringify(data[3]["Status"])}</td>
							</tr>
							<tr>
								<td>${JSON.stringify(data[4]["firstName"])}</td>
								<td>${JSON.stringify(data[4]["lastName"])}</td>
								<td>${JSON.stringify(data[4]["email"])}</td>
								<td>${JSON.stringify(data[4]["Status"])}</td>
							</tr>
							<tr>
								<td>${JSON.stringify(data[5]["firstName"])}</td>
								<td>${JSON.stringify(data[5]["lastName"])}</td>
								<td>${JSON.stringify(data[5]["email"])}</td>
								<td>${JSON.stringify(data[5]["Status"])}</td>
							</tr>
							<tr>
								<td>${JSON.stringify(data[6]["firstName"])}</td>
								<td>${JSON.stringify(data[6]["lastName"])}</td>
								<td>${JSON.stringify(data[6]["email"])}</td>
								<td>${JSON.stringify(data[6]["Status"])}</td>
							</tr>
							<tr>
								<td>${JSON.stringify(data[7]["firstName"])}</td>
								<td>${JSON.stringify(data[7]["lastName"])}</td>
								<td>${JSON.stringify(data[7]["email"])}</td>
								<td>${JSON.stringify(data[7]["Status"])}</td>
							</tr>
							<tr>
								<td>${JSON.stringify(data[8]["firstName"])}</td>
								<td>${JSON.stringify(data[8]["lastName"])}</td>
								<td>${JSON.stringify(data[8]["email"])}</td>
								<td>${JSON.stringify(data[8]["Status"])}</td>
							</tr>
							<tr>
								<td>${JSON.stringify(data[9]["firstName"])}</td>
								<td>${JSON.stringify(data[9]["lastName"])}</td>
								<td>${JSON.stringify(data[9]["email"])}</td>
								<td>${JSON.stringify(data[9]["Status"])}</td>
							</tr>
						</table>
					</body>
				</html>
				`);
			});
		}else{
			res.writeHead(404, {"Content-Type": "text/plain"});
			res.end("DATA NOT FOUND!!!");
		}
	}else if(req.url === "/active") {
		activeUser(res);
	}else if(req.url === "/inactive"){
		inactiveUser(res);
	}else{
		if(req.url === "/dictionary-api"){
			//console.log("Masuk");
			res.writeHead(200, {"Content-Type": "text/html"});
			res.end(`
			<!DOCTYPE html>
			<html>
				<head>
					<meta name="viewport" content="minimum-scale=1.0, width=device-width, maximum-scale=1.0, user-scalable=no"/>
					<meta charset="utf-8">
					<title>Dashboard</title>
					<link rel="stylesheet" href="/css/style.css"/>
				</head>
				<body>
					<script src="/js/jquery.min.js"></script>
					<script src="/js/dictionary.js"></script>
					<h1>Guitar Dictionary</h1>
					<dl></dl>
					<p>Dictionary Empty</p>
				
					<form>
						<input type="text" id="term" name="term" placeholder="new term..." required />
						<input type="Text" name="defined" id="defined" placeholder="new definition..." required />
						<button>Add Term</button>
					</form>
				</body>
			</html>
			`);
			// console.log(`${req.method} request for '${req.url}'`);
			// next();
		}else{
			res.writeHead(404, {"Content-Type": "text/plain"});
			res.end("DATA NOT FOUND!!!");
		}
	}
});
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(function(req, res, next) {
	console.log(`${req.method} request for '${req.url}' - ${JSON.stringify(req.body)}`);
	next();
});

app.use(express.static("./public"));

app.use(cors());
app.get("/dictionary-api",function(req, res){
	res.json(guitaristTerm);
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

function activeUser(res) {
	var isStatus = data.filter(function(item) {
		return item.Status === "active";
	});
	res.end(JSON.stringify(isStatus));
}
function inactiveUser(res) {
	var isnotStatus = data.filter(function(item){
		return item.Status === "inactive";
	});
	res.end(JSON.stringify(isnotStatus));
}

module.exports = app;