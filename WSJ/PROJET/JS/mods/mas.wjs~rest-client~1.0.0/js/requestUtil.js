
function getRessourceRepresentationByPath (path) {
	var splitPath = path.split('.');
	
	if(splitPath.length == 1){
		return 'json';
	}else if(splitPath.length == 2){
		var res = splitPath[1];
		
		if(res == 'xml'){
			return 'xml';
		}else if(res == 'json'){
			return 'json';
		}else{
			return null;
		}
	}
}


function isUserJsonOk(data){
	var obj = JSON.parse(data);
		
	return ('username' in obj);
}


function parseJsonUserObject (data) {
	
	var objData = JSON.parse(data);
	var objDataToSend = {};
	objDataToSend.username = objData.username;
	return objDataToSend;
}