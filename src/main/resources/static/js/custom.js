var json;

function initModalUpload(){
	$.get('/modal',function(modal){
		$('#corpoModal').html(modal);
		$('#motalTitulo').text('Upload Arquivo');

		init_ModalUpload();
		
		$('#modal').modal('show');
	});
}

function init_ModalUpload(){
	$('#salvarUpload').click(function(){
		uploadFile();
	});
	
	$('#uploadFile').change(function(){
		// REINICIAR PADRÕES DE ERRO POR VALIDAÇÕES
		$(this).css('border','none');
		$('.text-errorP').each(function(){$(this).css('display','none')})
		$("#listFiles2").children().remove();
		
		if($(this)[0].files && $(this)[0].files[0]){
			
			// VERIFICAR SE O ARQUIVO É DO TIPO JSON
			if($(this)[0].files[0].type.includes('application/json')){
				
				var readFile = new FileReader();
		        readFile.onload = function(e) { 
		            var contents = e.target.result;
		            json = JSON.parse(contents);
		        };
		        readFile.readAsText(this.files[0]);
			}else{
				$('.text-errorP')[1].style.display = '';
				$(this).css('border','1px solid red');
				$(this).val("");
				imgPergunta = "";
			}	
		}
	});
}

function uploadFile(){
	
	$.ajax({
		url : '/',
		type : "POST",
		data : JSON.stringify(json),
		headers: 
	    {
	        'X-CSRF-TOKEN': $("[name='_csrf']").val()
	    },
		dataType : "json",		 
		contentType : "application/json",
		success : function(msg, status, jqxhr) {
			location.reload();
		},
		error : function(msg, status) {
			
		}
	});
}