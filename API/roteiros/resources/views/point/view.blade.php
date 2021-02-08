@extends('point.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Detalhe do ponto</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('point') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
    <tr>
            <th>ID da rota:</th>
            <td>{{ $point->routes_id }}</td>
        </tr>
        <tr>
            <th>Nome:</th>
            <td>{{ $point->name }}</td>
        </tr>
        <tr>
            <th>Descriçao:</th>
            <td>{{ Str::limit($point->description, 20) }}</td>
        </tr>
        <tr>
            <th>Imagem:</th>
            <td>{{ $point->images }}</td>
        </tr>
        <tr>
            <th>Video:</th>
            <td>{{ $point->videoUrl }}</td>
        </tr>
        <tr>
            <th>Coordenadas:</th>
            <td>{{ $point->coordinate }}</td>
        </tr>
 
    </table>
@endsection