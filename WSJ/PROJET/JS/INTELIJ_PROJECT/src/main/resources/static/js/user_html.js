$(function (){


	console.log('init app');


	$('#new_user_section').hide();

	$('#btn_open_user_form').click(function () {
		$('#new_user_section').show();
	});

	displayUsersList();


	$(document).on('click','.modal_form_button',function () {
		var userId = $(this).attr('data-userid');
		$('#form_add_track_' + userId).toggle();

	});



	$(document).on('click','.tracks_link',function () {
		var userId = $(this).attr('data-userid');
		var $that = $(this);

		if($(this).attr('data-display') == 'true'){
			$('.user_tracks_' + userId).remove();
			$that.attr('data-display','false');
		}else{
			displayTracksForUser($that,userId);

		}



	});

				
	$('#btn_add_user').click(function () {
				
		var username = $('#username').val();
		var password = $('#password').val();

		var data = {};
		data.username = username;
		data.password = password;


		$.ajax({
			url:"/userAdd",
			type:"POST",
			headers: {
				"Accept" : "application/json; charset=utf-8"
			},
			contentType:"application/json; charset=utf-8",
			data:JSON.stringify(data) ,
			dataType:"json"

		}).done(function( data ,textstatus,request ) {
			console.log(request.statusCode().responseText);
			console.log('user created: ' + request.getResponseHeader('Location'));

			console.log('data:')
			console.log(data);

			console.log('request:')
			console.log(request);

			console.log('textstatus:')
			console.log(textstatus);



			if(request.status === 200){
				alert('user created: ' + data.user._id);
				$('#new_user_section').hide();
				displayUsersList();

			}else if(data.status == 404){
				alert('Error during user creation: ' + data.reason);
			}

		}) .fail(function(data, textStatus) {
			console.log(JSON.parse(data.responseText).reason);
			alert( "error" + textStatus );
		});


	});

	$(document).on('click','#btn_add_track',function () {
		console.log('adding track for user id:' + $(this).attr('data-user-id'));

		var userId = $(this).attr('data-user-id');
		var data = {};
		data.userid = userId;
		data.date = new Date();
		data.name = $('#track_name_'+ userId).val();
		data.description = $('#track_desc_'+ userId).val();


		$.ajax({
			url:"/trackAdd",
			type:"POST",
			headers: {
				"Accept" : "application/json; charset=utf-8"
			},
			contentType:"application/json; charset=utf-8",
			data:JSON.stringify(data) ,
			dataType:"json"

		}).done(function( data ,textstatus,request ) {
			console.log(request.statusCode().responseText);
			console.log('user created: ' + request.getResponseHeader('Location'));

			console.log('data:')
			console.log(data);

			console.log('request:')
			console.log(request);

			console.log('textstatus:')
			console.log(textstatus);



			if(request.status === 200){
				alert('track created: ' + data._id);
				$('.form_add_track').hide();
				displayTracksForUser($('#tracks_link_btn_' + userId),userId);

				//$('#new_user_section').hide();
			}else if(data.status == 404){
				alert('Error during user creationy: ' + data.reason);
			}

		}) .fail(function(data, textStatus) {
			console.log(JSON.parse(data.responseText).reason);
			alert( "error" + textStatus );
		});
	});

});

var displayUsersList = function () {

	$('#usersResultZone').empty();

	$.get( "/usersList", {

	}).done(function( data ,textstatus,request) {
		var jsonData = JSON.parse(data);

		console.log(jsonData)
		console.log(jsonData.users)
		for(var user in jsonData.data.users){
			var u = jsonData.data.users[user];
			console.log(u)

			var detailLink;
			var userLinks = u.links;

			for (var l in userLinks){
				//console.log("link: " + u.links[link])

				var link = userLinks[l]

				if(link.rel=="self"){
					detailLink = '<a href="' + link.href + '">' + u.username + '</a>';
				}
			}

			$('#usersResultZone').append('<tr id="user_' + u._id +'"class="active"><td>' + detailLink + '</td>'
			+ '<td><button id="tracks_link_btn_' + u._id +'" class="tracks_link"  data-userid="' + u._id +'">Parcours</button></td>'
			+ '<td><button data-userid="' + u._id +'" class="modal_form_button">Ajout</button></td></tr>'
			+ '<tr id="form_add_track_' + u._id + '" class="form_add_track"><td><label>Nom:</label><input type="text" id="track_name_' + u._id +'"/><label>Description:</label><input type="text" id="track_desc_' + u._id +'"/>'
			+ '<button type="button" id="btn_add_track" data-user-id="' + u._id +'" class="btn btn-default">Valider</button></td></tr>');
		}

		$('.form_add_track').hide();
	}).fail(function(data, textStatus) {
		console.log(JSON.parse(data.responseText).reason);
		alert( "error" + textStatus );
	});
};

var displayTracksForUser = function ($element,userId) {
	$.get( "/userTracks/" + userId, {

	}).done(function( data ,textstatus,request) {
		var jsonData = JSON.parse(data);

		//console.log(data);
		//console.log(textstatus);
		//console.log(request);


		for(var track in jsonData.tracks){
			var t = jsonData.tracks[track];

			$('#user_' + userId).after('<tr class="user_tracks_' + userId +'"><td>'+ t.name +'></td><td>' + t.date +'</td></tr>');

			console.log(t);
		}
		$element.attr('data-display','true');
		//$('#usersResultZone').append('</ul>');
	});
}