var console = require('vertx/console');
var eventBus = require('vertx/event_bus');

//Sauvegarde d'une tache
eventBus.registerHandler('users.save', function(user, responder) {

	eventBus.sendWithTimeout('activity.track.persistence',{
		action: 'save', 
		collection: 'users', 
		document: user
	},
	2000,
	function(cause,reply) {
				
		var msg = {};
		
		//Si pas de problème
		if(cause == null){
			console.log('reply: ' + reply.status);
			
			if (reply.status === 'ok') {
				user._id = reply._id;
				msg.data = user;
				msg.status = 'ok';
				responder(msg);
			} else {
				console.log("MongoDB Error: " + reply.message);
				msg.status = reply.status;
				responder(msg);
			} 
		}else{
			msg.status = 'ko';
			msg.cause = cause.message;
			console.log(cause.message);
		
			responder(msg);
			
		}
				
	});
});

console.log('users.save.js successfully deployed');