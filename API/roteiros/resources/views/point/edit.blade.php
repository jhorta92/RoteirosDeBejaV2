@extends('point.layouts.app')
@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Editar Ponto de Interesse</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('points') }}"> Voltar</a>
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
    <form method="post" action="{{ route('points.update',$point->id) }}" >
        @method('PATCH')
        @csrf
        <div class="form-group">
                <label for="routes_id">Rota:</label>
                <select class="form-control" id="routes_id" placeholder="Enter  Name" name="routes_id">
                    @foreach($routes as $route)
                        <option value="{{$route->id}}">{{$route->name}}</option>
                    @endforeach
                </select>
        </div>
        <div class="form-group">
            <label for="name">Nome:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter  Name" name="name" value="{{ $point->name }}">
        </div>
        <div class="form-group">
            <label for="description">Descrição:</label>
            <input type="text" class="form-control" id="description"  placeholder="Enter description" name="description" value="{{ $point->description }}"></textarea>
        </div>
        <div class="form-group">
            <label for="images">Imagem:</label>
            <input class="form-control" id="images" name="images"  placeholder="Enter images" value="{{ $point->images }}"></textarea>
        </div>
        <div class="form-group">
            <label for="videoUrl">Video:</label>
            <input class="form-control" id="videoUrl" name="videoUrl"  placeholder="Enter videoUrl" value="{{ $point->videoUrl }}"></textarea>
        </div>
        <div class="form-group">
            <label for="coordinate">Coordenadas:</label>
            <input class="form-control" id="coordinate" name="coordinate"  placeholder="Enter coordinate" value="{{ $point->coordinate }}"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Submeter</button>
    </form>
@endsection