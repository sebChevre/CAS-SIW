var console = require('vertx/console');
var eventBus = require('vertx/event_bus');

eventBus.registerHandler('users.tracks', function(args, responder) {

	log('mongodb services: tracks.list');
	
	eventBus.send('activity.tracks.persistence',{
		action: 'find', 
		collection: 'tracks',//on ne remonte pas le mot de passe
		matcher: args
	},
	function(reply) {
		if (reply.status === 'ok') {
			responder({tracks:reply.results});
			log('status ok, response sending');
		} 
		else {
			responder(reply.message);
			log('status ko, response sending');
		} 
	});
});



/*
service de sauvegarde des utilisateurs
*/
eventBus.registerHandler('track.save', function(track, responder) {

	console.log('mongodb services: track.save');
	
	//objet json retourner
	var mongoWrapper = {};
	
	//converion objet
	track = JSON.parse(track);
	
	//Set la propriété
	mongoWrapper.data = track;
	
	//on passe l'objet
	eventBus.send('activity.tracks.persistence',{
		action: 'save', 
		collection: 'tracks', 
		document: track
	},
	function(reply) {
			if (reply.status === 'ok') {
				track._id = reply._id;
				mongoWrapper.status = 'ok';
				responder(mongoWrapper);
				console.log('status ok, response sending');
				
			} else {
				mongoWrapper.status = 'ko';
				mongoWrapper.errorMsg = reply.message;
				responder(mongoWrapper);
				console.log('status ko, response sending');
			} 
	});
	
});


var log = function (message) {
	console.log('[tracks.service.js]-' + message);
}

this.log('tracks.service.js successfully deployed');


