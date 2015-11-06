$(document).ready(function() {
	addTable();	
	paging();
});

var movieData={};
movieData=[{MovieTitle: 'Goosebumps',Genre: 'Action',Director: 'DirectorA',Rating:'4/5'},
           {MovieTitle: 'Dinosaur Adventure',Genre: 'Action',Director: 'Director B',Rating:'3.5/5'},
           {MovieTitle: 'Wild Roller Coaster',Genre: 'Action',Director: 'Director C',Rating:'1/5'},
           {MovieTitle: 'Temple Run 7',Genre: 'Action',Director: 'Director D',Rating:'2/5'},
           {MovieTitle: 'Movie 1',Genre: 'Action',Director: 'Director E',Rating:'4.5/5'},
           {MovieTitle: 'Movie 2',Genre: 'Action',Director: 'Director F',Rating:'5/5'},
           {MovieTitle: 'Movie 3',Genre: 'Action',Director: 'Director G',Rating:'5/5'},
           {MovieTitle: 'Movie 4',Genre: 'Action',Director: 'Director H',Rating:'3.5/5'},
           {MovieTitle: 'Movie 5',Genre: 'Action',Director: 'Director I',Rating:'3.3/5'},
           {MovieTitle: 'Movie 6',Genre: 'Action',Director: 'Director J',Rating:'5/5'},
           {MovieTitle: 'Movie 7',Genre: 'Action',Director: 'Director K',Rating:'4/5'},
           {MovieTitle: 'Movie 8',Genre: 'Action',Director: 'Director L',Rating:'4.5/5'},
           {MovieTitle: 'Movie 9',Genre: 'Action',Director: 'Director M',Rating:'2.5/5'},
           {MovieTitle: 'Movie 10',Genre: 'Action',Director: 'Director N',Rating:'5/5'},
           {MovieTitle: 'Movie 11',Genre: 'Action',Director: 'Director O',Rating:'4/5'},
           {MovieTitle: 'Movie 12',Genre: 'Action',Director: 'Director P',Rating:'2/5'},
           {MovieTitle: 'Movie 13',Genre: 'Action',Director: 'Director Q',Rating:'1/5'}];


function addTable(){
	
	
	var table=$('#movieTable').children();
	table.append('<tr><th style="border:1px solid blue">'+"MovieTitle"+'</th> <th style="border:1px solid blue">'+"Genre"+
			'</th><th style="border:1px solid blue">'+"Director"+'</th> <th style="border:1px solid blue">'+"Review"+'</th></tr>');
	for(var i=0;i< movieData.length;i++)
		table.append('<tr><td style="border:1px solid blue">'+movieData[i].MovieTitle+'</td><td style="border:1px solid blue">'+movieData[i].Genre+
				'</td><td style="border:1px solid blue">'+movieData[i].Director+'</td><td style="border:1px solid blue">'+movieData[i].Rating+'</td></tr>');
}

function paging(){
    $('#movieTable').after('<div id="nav" style="float:right"></div>');
    var rowsShown = 5;
    var rowsTotal = $('#movieTable tbody tr').length;
    var numPages = rowsTotal/rowsShown;
    for(i = 0;i < numPages;i++) {
        var pageNum = i + 1;
        $('#nav').append('<div style="width:40px;border:2px solid gray;float:left;text-align:center;margin-left:5px;"><a href="#" rel="'+i+'">'+pageNum+'</a><div>');
    }
    $('#movieTable tbody tr').hide();
    $('#movieTable tbody tr').slice(0, rowsShown).show();
    $('#nav a:first').addClass('active');
    $('#nav a').bind('click', function(){

        $('#nav a').removeClass('active');
        $(this).addClass('active');
        var currPage = $(this).attr('rel');
        var startItem = currPage * rowsShown;
        var endItem = startItem + rowsShown;
        $('#movieTable tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
                css('display','table-row').animate({opacity:1}, 300);
    });
}

function search() {
	var myTable = document.getElementById("movieTable");

	while(document.getElementById("movieTable").rows.length > 0) {
		
		document.getElementById("movieTable").deleteRow(0);
		  
		}
	var searchId = document.getElementById("srch-term");

	var searchMovie = searchId.value;
	var res = "";
	$( '#movieTable' ).show();
	$( 'div#nav' ).hide();
	
	var table = $('#movieTable');
	flag=0;
	table.append('<tr><th>' + "Movie Title" + '</th><th>' + 'Genre' + '</th><th>' + 'Director' + '</th><th>' + 'Ratings' + '</th></tr>');

	for(var i=0;i< movieData.length; i++) {
	
		if(movieData[i]["MovieTitle"].toLowerCase() == searchMovie.toLowerCase()) {
			table.append('<tr><td>' + movieData[i].MovieTitle + '</td><td>' + movieData[i].Genre + '</td><td>' + movieData[i].Director + '</td><td>' + movieData[i].Rating + '</td></tr>');
			flag=flag+1;
			
		}
	}	
	if(flag==0) {
		table.append('<tr><td colspan="3" style="align: center;">' + "No Movie Found" + '</td></tr>');
	}
}

function searchForSmall() {
	var myTable = document.getElementById("movieTable");

	while(document.getElementById("movieTable").rows.length > 0) {
		
		document.getElementById("movieTable").deleteRow(0);
		  
		}
	var searchId = document.getElementById("srchSmall");
	
	var searchMovie = searchId.value;
	var res = "";
	$( '#movieTable' ).show();
	$( 'div#nav' ).hide();
	
	var table = $('#movieTable');
	flag=0;
	table.append('<tr><th>' + "Movie Title" + '</th><th>' + 'Genre' + '</th><th>' + 'Director' + '</th><th>' + 'Ratings' + '</th></tr>');

	for(var i=0;i< movieData.length; i++) {
		
		if(movieData[i]["MovieTitle"].toLowerCase() == searchMovie.toLowerCase()) {
			table.append('<tr><td>' + movieData[i].MovieTitle + '</td><td>' + movieData[i].Genre + '</td><td>' + movieData[i].Director + '</td><td>' + movieData[i].Rating + '</td></tr>');
			flag=flag+1;
			
		}
	}	
	if(flag==0) {
		table.append('<tr><td colspan="3" style="align: center;">' + "No Movie Found" + '</td></tr>');
	}
}