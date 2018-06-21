const http = require('http');
const xml = require('xml-parse');
const StaticServer = require('node-static').Server;
const file = new StaticServer('./public');

const handlers = {};

handlers['/'] = function(req, res) {
	file.serve(req, res);
}

handlers['/borrowappusers'] = function(req, res) {
	console.log("/borrowappusers accessed");
	if(req.method == 'GET') {
		const options = {
			hostname : '127.0.0.1',
			port : 8080,
			path : '/CuaternoDaveBorrowApp/borrowappusers'
		};
		const reqServlet = http.request(options);
		reqServlet.end();
		reqServlet.on('response', function(resServlet) {
			var respData;
			resServlet.on('data', function(data) {
				respData += data;
			});
			resServlet.on('end', function() {
				res.write(parseXML(respData));
				res.end();
			});
		});
	}
}

handlers['/borrowappratings'] = function(req, res) {
	console.log("/borrowappratings accessed");
	if(req.method == 'GET') {
		const options = {
			hostname : '127.0.0.1',
			port : 8080,
			path : '/CuaternoDaveBorrowApp/borrowappratings'
		};
		const reqServlet = http.request(options);
		reqServlet.end();
		reqServlet.on('response', function(resServlet) {
			var respData;
			resServlet.on('data', function(data) {
				respData += data;
			});
			resServlet.on('end', function() {
				res.write(parseXML(respData));
				res.end();
			});
		});
	}
}

function parseXML(respData) {
	var pObj = new Object();
	let parsed = xml.parse(respData);
	let jsonObj = parsed[1].childNodes;
	for(let e of jsonObj) {
		if(pObj.hasOwnProperty(e.tagName) == false) {
			pObj[e.tagName] = [];
		}
		var cObj = new Object();
		for(let f of e.childNodes) {
			cObj[f.tagName] = f.innerXML;
		}
		pObj[e.tagName].push(cObj);
	}
	return(JSON.stringify(pObj));
};

const server = http.createServer(function(req, res) {
	if(handlers[req.url]) {
		handlers[req.url](req, res);
	}
	else {
		res.writeHead(404, {"Content-Type" : "text/html"});
		res.end("<h1>Error 404: Page Not Found</h1>");
	}
});

server.listen(7007);
console.log("Server is running at port 7007");
