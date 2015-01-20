$(function () {
	$('.detail').hide();
				
	$('.open_detail').click(function () {
	console.log($(this));
		console.log($(this).data());
		var $zoneToShow = $('#' + $(this).attr('data-detail_zone'));
		console.log($zoneToShow);
		$zoneToShow.toggle();
	});
})