initial_data_handler = {
	
	users : [],

	getUsers : function () {
		this.users.push({username:'Seb',password:'esteban11'});
		this.users.push({username:'Root',password:'toor'});
		this.users.push({username:'Sebastien',password:'esteban11'});
		this.users.push({username:'David',password:'esteban11'});
		this.users.push({username:'Julien',password:'esteban11'});

		return this.users;
	},
	
	addTracksForUser : function (users) {
		
		for(user in users){
			var tracks = [];
			var track = {name:'Track pour ' + users[user].username, date:new Date(), description: 'Parcours de test pour insertion des données ' + user};
			tracks.push(track);
			
			users[user].tracks = tracks;
		}
	},
	
	updateUsersAfterInsert : function (afterUsers){
		this.users = afterUsers;
		return this.users;	
	},
	
	generateTracks : function () {
		var tracks = [];
		
		for(user in this.users){
			
			var track = {user_id:this.users[user]._id,name:'Track pour ' + this.users[user].username, date:new Date(), description: 'Parcours de test pour insertion des données ' + this.users[user].username};
			tracks.push(track);

		}
		
		return tracks;
	}	
}