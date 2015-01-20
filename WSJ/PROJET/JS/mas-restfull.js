var vertx = require('vertx');
var container = require('vertx/container');
var console = require('vertx/console')

container.deployModule('mas.wjs~rest-server~1.0.0');
console.log('MAS ICT REstFull Server started...');
