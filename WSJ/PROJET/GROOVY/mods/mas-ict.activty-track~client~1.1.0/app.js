var vertx = require('vertx');
var container = require("vertx/container");
var console = require('vertx/console');
var eventBus = require('vertx/event_bus');
   
container.deployModule("io.vertx~mod-web-server~2.0.0-final", {
	port: 8888,
	host: "localhost"
});


