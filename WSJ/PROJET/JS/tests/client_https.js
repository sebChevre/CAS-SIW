var vertx = require('vertx')
var console = require('vertx/console')
var client = vertx.createHttpClient().port(4443).ssl(true).trustAll(true);
client.getNow('/', function(resp) {
console.log("Got response " + resp.statusCode());
resp.bodyHandler(function(body) {
console.log("Got data " + body);
})
});