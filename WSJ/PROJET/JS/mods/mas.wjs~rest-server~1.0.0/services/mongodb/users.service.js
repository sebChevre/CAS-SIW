var vertx = require('vertx');
var container = require('vertx/container');
var logger = container.logger;
var eventBus = vertx.eventBus;

/*
service de listage des utilisateurs
*/
eventBus.registerHandler('users.list', function(args, responder) {

	log('mongodb services: users.list');
	
	//envoi avec timeout 2 secondes
	eventBus.sendWithTimeout('activity.tracks.persistence',{
		action: 'find', 
		collection: 'users',
		matcher: args
	},
	2000,
	function(cause,reply) {
		//erreur
		if(cause !== null){
			responder({status:'ko',error:cause.message,data:cause.toString()});
			log('status ko, response sending');

		}else if(reply !== null){
			responder({status:'ok',data:reply.results});
			log('status ok, response sending');
		}
		
	});
});

/*
service de sauvegarde des utilisateurs
*/
eventBus.registerHandler('user.save', function(user, responder) {

	var that = this;
	log('mongodb services: user.save');
	
	//objet json retourner
	var mongoWrapper = {};
	
	//converion objet
	user = JSON.parse(user);
	
	//Set la propriété
	mongoWrapper.data = user;
	
	//on passe l'objet
	eventBus.send('activity.tracks.persistence',{
		action: 'save', 
		collection: 'users', 
		document: user
	},
	function(reply) {
			if (reply.status === 'ok') {
				user._id = reply._id;
				mongoWrapper.status = 'ok';
				responder(mongoWrapper);
				log('status ok, response sending');
				
			} else {
				mongoWrapper.status = 'ko';
				mongoWrapper.errorMsg = reply.message;
				responder(mongoWrapper);
				log('status ko, response sending');
			} 
	});
	
});

/*
Lecture des utilisateurs
*/
eventBus.registerHandler('user.read', function(args, responder) {

	var that = this;

	log('mongodb services: user.read');
		
	eventBus.send('activity.tracks.persistence',{
		action: 'find', 
		collection: 'users',
		matcher: args
	},
	function(reply) {
		if (reply.status === 'ok') {
			responder(reply.results);
			log('status ok, response sending');
		} 
		else {
			responder(reply.message);
			log('status ko, response sending');

		} 
	});
});

/*
count des utilisateurs
*/
eventBus.registerHandler('user.count', function(args, responder) {

var that = this;
	log('mongodb services: user.count');
	
	eventBus.send('activity.tracks.persistence',{
		action: 'count', 
		collection: 'users',
		matcher: args
	},
	function(reply) {
		if (reply.status === 'ok') {
			responder(reply.count);
			that.log('status ok, response sending');

		} 
		else {
			responder(reply.message);
			that.log('status ko, response sending');
		} 
	});
});

var log = function (message) {
	logger.info('[users.service.js - ' + new Date() + ']' + message);
}

this.log('users.service.js successfully deployed');


