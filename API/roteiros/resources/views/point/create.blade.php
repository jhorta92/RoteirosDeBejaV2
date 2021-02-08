@extends('point.layouts.app')
@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Adicionar Ponto de interesse</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('points') }}"> Back</a>
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
    <form action="{{ route('points.store') }}" method="POST">
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
            <input type="text" class="form-control" id="name" placeholder="Enter  Name" name="name">
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea type="text" class="form-control" id="description" rows="10" placeholder="Enter description" name="description"></textarea>
        </div>
        <div class="form-group">
            <label for="images">Images:</label>
            <input type="text" class="form-control" id="images" name="images" placeholder="Enter images"></input>
        </div>
        <div class="form-group">
            <label for="videoUrl">Video:</label>
            <input type="text" class="form-control" id="videoUrl" name="videoUrl"  placeholder="Enter videoUrl"></input>
        </div>
  
        <div class="form-group">
            <label for="coordinate">Coordinate:</label>
            <input type="text" class="form-control" id="coordinate" name="coordinate" rows="200" placeholder="Enter coordinate"></input>
        </div>
        <button type="submit" class="btn btn-default">Submeter</button>
    </form>
@endsection