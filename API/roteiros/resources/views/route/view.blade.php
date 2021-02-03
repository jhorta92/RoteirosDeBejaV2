@extends('route.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Laravel 8 CRUD Example</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('route') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
        <tr>
            <th>Name:</th>
            <td>{{ $route->name }}</td>
        </tr>
        <tr>
            <th>Description:</th>
            <td>{{ $route->description }}</td>
        </tr>
        <tr>
            <th>Images:</th>
            <td>{{ $route->images }}</td>
        </tr>
        <tr>
            <th>VideoUrl:</th>
            <td>{{ $route->videoUrl }}</td>
        </tr>
 
    </table>
@endsection