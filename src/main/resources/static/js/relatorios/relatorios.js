$(document).ready(function() {
	buscarChart1();
	buscarChart2();
	buscarChart3();
	buscarChart4();
});

function buscarChart1() {
	$.get('relatorio/buscar_obesidade', function(lista) {

		init_chart(lista[0], lista[1]);
	});
}

function buscarChart2() {
	$.get('relatorio/buscar_faixa', function(lista) {

		init_chartIdade(lista);
	});
}

function buscarChart3() {
	$.get('relatorio/buscar_sangue', function(lista) {

		init_chartHp(lista);
	});
}

function buscarChart4() {
	$.get('relatorio/buscar_doador', function(lista) {

		init_chartDoador(lista);
	});
}

function init_chart(homens, mulheres) {
	// based on prepared DOM, initialize echarts instance
	var myChart = echarts.init(document.getElementById('main'));

	// specify chart configuration item and data
	var option = {
		title : {
			text : 'OBESIDADE (IMC > 30)',
			subtext : 'PORCENTAGEM (%)'
		},
		legend : {},
		tooltip : {},
		xAxis : {
			type : 'category',
			data : [ 'Homens', 'Mulheres' ]
		},
		yAxis : {
			type : 'value'
		},
		series : [ {
			data : [ homens, mulheres ],
			type : 'bar',
			label : {
				show : true,
				position : 'top'
			}
		} ]
	};

	// use configuration item and data specified to show chart
	myChart.setOption(option);
}

function init_chartIdade(listaIdades) {
	// based on prepared DOM, initialize echarts instance
	var myChart = echarts.init(document.getElementById('idade'));

	// specify chart configuration item and data
	var option = {
		title : {
			text : 'IMC MÉDIO POR IDADE',
			subtext : 'FAIXA DE 10 EM 10 ANOS'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'shadow'
			}
		},
		legend : {
			data : []
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : {
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		},
		yAxis : {
			type : 'category',
			data : [ '0-10', '11-20', '21-30', '31-40', '41-50', '51-60',
					'61-70', '71-80', '81-90', '91-100', '101-110' ]
		},
		series : [ {
			name : 'IMC MÉDIO',
			type : 'bar',
			data : [ listaIdades[0], listaIdades[1], listaIdades[2],
					listaIdades[3], listaIdades[4], listaIdades[5],
					listaIdades[6], listaIdades[7], listaIdades[8],
					listaIdades[9], listaIdades[10] ],
			label : {
				show : true
			}
		} ]
	};

	// use configuration item and data specified to show chart
	myChart.setOption(option);
}

function init_chartHp(listaIdades) {
	// based on prepared DOM, initialize echarts instance
	var myChart = echarts.init(document.getElementById('sangue'));

	// specify chart configuration item and data
	var option = {
		title : {
			text : 'MÉDIA DE IDADE POR TIPO SANGUÍNEO',
			subtext : 'TIPO SANGUÍNEO'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'shadow'
			}
		},
		legend : {
			data : []
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : {
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		},
		yAxis : {
			type : 'category',
			data : [ 'A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-' ]
		},
		series : [ {
			name : 'MÉDIA DE IDADE',
			type : 'bar',
			data : [ listaIdades[0], listaIdades[1], listaIdades[2],
					listaIdades[3], listaIdades[4], listaIdades[5],
					listaIdades[6], listaIdades[7] ],
			label : {
				show : true
			}
		} ]
	};

	// use configuration item and data specified to show chart
	myChart.setOption(option);
}

function init_chartDoador(listaIdades) {
	// based on prepared DOM, initialize echarts instance
	var myChart = echarts.init(document.getElementById('doador'));

	// specify chart configuration item and data
	var option = {
		title : {
			text : 'POSSÍVEIS DOADORES POR TIPO SANGUÍNEO',
			subtext : 'TIPO SANGUÍNEO'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'shadow'
			}
		},
		legend : {
			data : []
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : {
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		},
		yAxis : {
			type : 'category',
			data : [ 'A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-' ]
		},
		series : [ {
			name : 'TOTAL DE DOADORES',
			type : 'bar',
			data : [ listaIdades[0], listaIdades[1], listaIdades[2],
					listaIdades[3], listaIdades[4], listaIdades[5],
					listaIdades[6], listaIdades[7] ],
			label : {
				show : true
			}
		} ]
	};

	// use configuration item and data specified to show chart
	myChart.setOption(option);
}