<!DOCTYPE html>
<html>
<head>
<title>Uniarq - Professor</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/jasny-bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Droid+Sans" rel="stylesheet">

<script src="resources/js/modernizr.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
    <div class="app">
        <div class="navegacao"></div>
        <div class="navegacao-mobile">
            <div class="navbar navbar-default navbar-fixed-top navegacao-navbar">
                <button type="button" class="navbar-toggle navegacao-menu-botao hidden-lg hidden-md
                        pull-left" data-toggle="offcanvas" 
                        data-target="#menu" data-canvas="body">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand navegacao-icone" href="#">
                    <img alt="SAC" src="resources/imagens/logo.png" class="hidden-xs navegacao-icone-img" />
                </a>
                <ul class="nav navbar-nav navbar-right visible-lg visible-md">
                    <li class="navegacao-menu-item">
                        <a href="#" class="nav-item">Horários</a>
                    </li>
                    <li class="navegacao-menu-item">
                        <a href="#" class="nav-item">Lançar Nota</a>
                    </li>
                    <li class="navegacao-menu-item">
                        <a href="#" class="nav-item">
                        <i class="fa fa-lg fa-user"></i><span style="padding-left: .5em;"> Luiz de Gusmão</span>
                        </a>
                    </li>
                    <li class="navegacao-menu-item navegacao-menu-item-sair">
                        <a href="#" class="nav-item">Sair</a>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
                            role="button" aria-haspopup="true" aria-expanded="false"></a>
                    </li>
                    <li></li>
                </ul>
            </div>
            <nav id="menu" class="navmenu navmenu-default navmenu-fixed-left navegacao-navbar offcanvas" 
                role="navigation">
            <a class="navmenu-brand" href="#">
                <img alt="SAC" src="resources/imagens/logo.png" class="navegacao-icone-img" />
            </a>
            <ul class="nav navmenu-nav">
                <li class="active"><a href="#">Início</a></li>
                <li><a href="#">Horários</a></li>
                <li><a href="#">Lançar nota</a></li>
            </ul>
            </nav>            
        </div>
        <div class="conteudo conteudo-inicio conteudo-com-header col-xs-12">
            <div class="mensagem-header">
                <h3>Horário das disciplinas</h3>            
            </div>
<!--             <ul class="nav nav-tabs"> -->
<!--                 <li role="presentation" class="active"><a href="#">Ciência da computação</a></li> -->
<!--                 <li role="presentation"><a href="#">Sistemas de informação</a></li> -->
<!--             </ul> -->
            <div class="filtros col-md-offset-1 col-md-10 col-sm-12 sem-padding">
            
            </div>
            <div class="painel col-xs-12 col-md-12">
                <div class="painel-conteudo">
                	<input id="professor" type="hidden" value="${professor}"></input>
                    <div class="painel-titulo">
                        <button class="pull-right painel-formulario-botao 
                            painel-formulario-botao-ajuste btn btn-success">
                            <i class="fa fa-print"></i> Imprimir
                        </button>
                        <h3 class="painel-titulo-texto">Horários</h3>
                    </div>
                    <div class="painel-corpo">
                        <table class="table table-bordered table-hover table-responsive horarios">
                            <thead>
                                <tr>
                                    <th class="text-center">Segunda</th>
                                    <th class="text-center">Terça</th>
                                    <th class="text-center">Quarta</th>
                                    <th class="text-center">Quinta</th>
                                    <th class="text-center">Sexta</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>            
        </div>
    </div>

	<!--Common plugins-->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jasny-bootstrap.min.js"></script>
	<script src="resources/js/modulo.js"></script>
	<script src="resources/js/app.js"></script>
</body>
</html>