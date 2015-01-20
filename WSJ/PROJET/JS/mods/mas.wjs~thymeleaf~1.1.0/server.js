var vertx = require('vertx');
var http = require('vertx/http');
var eb = require('vertx/event_bus');
var container = require('vertx/container');

var httpPort = 7080


var config = {
  address: 'vertx.thymeleaf.parser',
  templateDir: 'templates',
  templateMode: 'HTML5',
  cacheable: true,
  characterEncoding: 'UTF-8',
  suffix: '.html'
}

var instances = 2


container.deployModule('io.vertx~thymeleaf-1.0.0-SNAPSHOT', config, instances)

var server = http.createHttpServer().requestHandler(function(req) {

  var json = {
    templateName: req.path(),
    uri: req.uri(),
    params: req.params(),
    headers: req.headers(),
    hello: 'world',
    foo: { man: 'chu' },
    one: { two: { three: 'four' } },
    data1: ['one', 'two', 'three'],
    data2: [
      {id: 1, name: 'one'},
      {id: 2, name: 'two'},
      {id: 3, name: 'three'}
    ]
  }

  eb.send('vertx.thymeleaf.parser', json, function(reply) {
    req.response.statusCode = reply.status
    req.response.end(reply.rendered)
  })

}).listen(httpPort, 'localhost')