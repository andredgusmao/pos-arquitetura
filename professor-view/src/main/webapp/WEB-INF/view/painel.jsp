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
        <div class="conteudo conteudo-inicio col-xs-12">
            <div class="mensagem-inicio">
                <h3 class="text-center">Uniarq - Módulo do professor</h3>
                <h3 class="text-center">Bem vindo Luiz!</h3>
                <h5 class="text-center">Suas informações para hoje (<b>19/09/2017</b>).</h5>
            </div>
            <div class="cards col-md-12 col-sm-11">
                <div class="card card-financeiro col-md-offset-0 col-md-3 col-sm-offset-1 col-sm-5 col-xs-12">
                    <div class="card-header text-center">
                        <img src="img/line-chart.png" alt="" class="card-header-img" />
                        <h2 class="card-header-titulo">10</h2>
                        <h4 class="card-header-subtitulo">Disciplinas</h4>
                    </div>
                    <div class="card-conteudo">
                        <p class="card-conteudo-texto">
                            <small>Quantidade de disciplinas nesse semestre.</small>
                        </p>
                    </div>
                    <div class="card-footer">
                        <a href="#" class="card-footer-link text-center">Ver disciplinas</a>
                    </div>
                </div>
                <div class="card card-licencas col-md-3 col-sm-offset-1 col-sm-5 col-xs-12">
                    <div class="card-header text-center">
                        <img src="img/license.png" alt="" class="card-header-img" />
                        <h2 class="card-header-titulo">120</h2>
                        <h4 class="card-header-subtitulo">Alunos</h4>
                    </div>
                    <div class="card-conteudo">
                        <p class="card-conteudo-texto">
                            <small>Alunos matriculados em disciplinas ministradas por você.</small>
                        </p>
                    </div>
                    <div class="card-footer">
                        <a href="#" class="card-footer-link text-center">Ver alunos matriculados</a>
                    </div>
                </div>
                <div class="card card-clientes col-md-4 col-sm-offset-1 col-sm-11 col-xs-12">
                    <div class="card-header text-center">
                        <h4 class="card-header-subtitulo"><i class="fa fa-address-book-o"></i> Disciplinas de hoje</h4>
                    </div>
                    <div class="card-conteudo">
                        <ul class="list-group card-lista">
                            <li class="list-group-item card-lista-item">
                            	<span class="badge card-lista-item-badge">9:00 - 10:00</span>
                                Cálculo I
                            </li>
                            <li class="list-group-item card-lista-item">
                            	<span class="badge card-lista-item-badge">10:00 - 11:00</span>
                                Cálculo I
                            </li>
                            <li class="list-group-item card-lista-item">
                            	<span class="badge card-lista-item-badge">13:00 - 14:00</span>
                                Arquitetura de computadores
                            </li>
                            <li class="list-group-item card-lista-item">
								<span class="badge card-lista-item-badge">14:00 - 15:00</span>
                                Programação II
                            </li>
                        </ul>
                    </div>
                    <div class="card-footer">
                        <a href="#" class="card-footer-link text-center">Ver horários</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<!--Common plugins-->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jasny-bootstrap.min.js"></script>
</body>
</html>