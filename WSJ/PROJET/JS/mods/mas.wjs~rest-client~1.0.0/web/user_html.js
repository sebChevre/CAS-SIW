$(function (){
	$.get( "/usersList", {}).done(function( data ,textstatus,request) {
		var jsonData = JSON.parse(data);
						
		$('#usersResultZone').append('<ul>');
		for(var user in jsonData.users){
			var u = jsonData.users[user];
			console.log(u);
			$('#usersResultZone').append('<li><a href="' + u.detail + '">' + u.username + '</a></li>');
		}
		$('#usersResultZone').append('</ul>');
	});
				
				
	$('#btn_add_user').click(function () {
				
		var username = $('#username').val();
		var password = $('#password').val();
					
		$.post( "/userAdd", 
			{ username: username, password: password }
		)
		.done(function( data ,textstatus,request) {
			console.log(request.statusCode().responseText);
			console.log('user created: ' + request.getResponseHeader('Location'));
						
			if(request.statusCode().responseText === '201'){
				alert('user created: ' + request.getResponseHeader('Location'));
			}else{
				alert('Error during user creation: ' + request.statusCode().statusText);
			}
			//alert( "Data Loaded: " + data );
			console.log(data);
			console.log(textstatus);
			console.log(request);
		});
	});							
});
