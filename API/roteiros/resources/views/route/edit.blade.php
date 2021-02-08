@extends('route.layouts.app')

@section('content')
<div class="row">
<div class="col-lg-11">
<h2>Atualizar Rota</h2>
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
<form method="post" action="{{ route('routes.update',$route->id) }}" >
@method('PATCH')
@csrf
<div class="form-group">
<label for="txtName">Nome:</label>
<input type="text" class="form-control" id="txtName" placeholder="Introduz o nome" name="txtName" value="{{ $route->name }}">
</div>
<div class="form-group">
<label for="txtDescription">Descrição:</label>
<input type="text" class="form-control" id="txtDescription" placeholder="Introduz a descrição" name="txtDescription" value="{{ $route->description }}">
<div class="form-group">
<label for="txtImage">Imagem:</label>
<input type="text" class="form-control" id="txtImage" placeholder="Introduz a imagem" name="txtImage" value="{{ $route->images }}">
<div class="form-group">
<label for="txtVideoUrl">Video:</label>
<input type="text" class="form-control"  id="txtVideoUrl" name="txtVideoUrl" placeholder="Enter videoUrl" value="{{ $route->videoUrl}}"></input>
</div>
<button type="submit" class="btn btn-default">Submeter</button>
</form>
@endsection

       