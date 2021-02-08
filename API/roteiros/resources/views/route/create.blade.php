@extends('route.layouts.app')

@section('content')
<div class="row">
<div class="col-lg-11">
<h2>Adicionar Rota</h2>
</div>
<div class="col-lg-1">
<a class="btn btn-primary" href="{{ url('routes') }}"> Voltar</a>
</div>
</div>

@if ($errors->any())
<div class="alert alert-danger">
<strong>Whoops!</strong> There were some problems with your input.<br><br>
<ul>
@foreach ($errors->all() as $error)
<li>{{ $error }}</li>
@endforeach
</ul>
</div>
@endif
<form action="{{ route('routes.store') }}" method="POST">
@csrf
<div class="form-group">
<label for="txtName">Nome:</label>
<input type="text" class="form-control" id="txtName" placeholder="Introduz o nome" name="txtName">
</div>
<div class="form-group">
<label for="txtDescription">Descrição:</label>
<textarea type="text" class="form-control" id="txtDescription" rows="10" placeholder="Introduz a descrição" name="txtDescription"></textarea>
</div>
<div class="form-group">
<label for="txtImage">Imagem:</label>
<input class="form-control" id="txtImage" name="txtImage"  placeholder="Introduz a imagem"></textarea>
</div>
<div class="form-group">
<label for="txtVideoUrl">Video:</label>
<input type="text" class="form-control"  id="txtVideoUrl" name="txtVideoUrl" placeholder="Enter videoUrl"></input>
        </div>
<button type="submit" class="btn btn-default">Submeter</button>
</form>
@endsection
        