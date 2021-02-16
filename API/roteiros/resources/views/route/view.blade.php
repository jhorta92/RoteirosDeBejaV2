@extends('route.layouts.app')


@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Detalhe da Rota</h2>
    </div>

    <div class="card" >
  <img class="card-img-top" src="{{ $route->images }}"  height=200 width=200 alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">{{ $route->name }}</h5>
    <p class="card-text">{{ $route->description }}</p>
    <a class="btn btn-primary" href="{{ url('routes') }}"> Voltar</a>
  </div>
</div>

@endsection