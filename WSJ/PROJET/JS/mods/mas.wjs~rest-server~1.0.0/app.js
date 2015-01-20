var container = require('vertx/container');
var logger = container.logger;
var config = container.config;


//Recuperation de la configuration
logger.info('[app.js - ' + new Date() + '] mas rest server starting...');


if(config.init_data === true){
	container.deployVerticle('createTableAndData.js',config,function () {
		logger.info('[app.js - ' + new Date() + '] createTableAndData.js successfukky deployed');
	});
}
container.deployVerticle('rest_server.js',config,function () {
	logger.info('[app.js - ' + new Date() + '] rest_server.js successfukky deployed');
});
container.deployVerticle('services/mongodb/users.service.js',function () {
	logger.info('[app.js - ' + new Date() + '] users.service.js successfukky deployed');
});
container.deployVerticle('services/mongodb/tracks.service.js',function () {
	logger.info('[app.js - ' + new Date() + '] tracks.service.js successfukky deployed');
});


//Déploiement module mongodb
container.deployModule("io.vertx~mod-mongo-persistor~2.0.0-final",{
	address: "activity.tracks.persistence",
	db_name: "mas-wsj"
},function () {
	logger.info('[app.js - ' + new Date() + '] mongo persistor module deployed');
});

