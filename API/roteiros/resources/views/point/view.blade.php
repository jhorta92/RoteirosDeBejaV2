@extends('point.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Detalhe do ponto</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('points') }}"> Voltar</a>
        </div>
    </div>
    
    <table class="table table-bordered">
        <tr>
        @foreach($points as $point)
            <th>Nome da rota:</th>
            <td>{{ $point->routes->name }}</td>
        @endforeach
        </tr>
        <tr>
            <th>Nome:</th>
            <td>{{ $point->name }}</td>
        </tr>
        <tr>
            <th>Descriçao:</th>
            <td>{{ $point->description }}</td>
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