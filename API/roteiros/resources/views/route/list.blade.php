@extends('route.layouts.app')

@section('content')
<div class="row">
<div class="col-lg-11">
<h2>Rotas</h2>
</div>
<div class="col-lg-1">
<a class="btn btn-success" href="{{ route('routes.create') }}">Adicionar</a>
</div>
</div>

@if ($message = Session::get('success'))
<div class="alert alert-success">
<p>{{ $message }}</p>
</div>
@endif

<table id= "myTable" class="table table-bordered">
<thead class="thead">
<tr>
<th>Nº</th>
<th>Nome</th>
<th>Descrição</th>
<th>Imagem</th>
<th></th>
</tr>
</thead>
<tbody>
@php
$i = 0;
@endphp
@foreach ($routes as $route)
<tr>
<td>{{ ++$i }}</td>
<td>{{ $route->name }}</td>
<td>{{Str::limit($route->description, 30) }}</td>
<td><img src="{{ $route->images }}" alt="" height=150 width=150></td>
<td>
<form action="{{ route('routes.destroy',$route->id) }}" method="POST">
<a class="btn btn-info" href="{{ route('routes.show',$route->id) }}">Detalhe</a>
<a class="btn btn-primary" href="{{ route('routes.edit',$route->id) }}">Editar</a>
@csrf
@method('DELETE')
<button type="submit" class="btn btn-danger">Eliminar</button>
</form>
</td>
</tr>
@endforeach
</tbody>
</table>
@endsection

<!-- <script type="text/javascript">
$(document).ready( function () {
    $('#myTable').DataTable();
} );
</script> -->