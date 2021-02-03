@extends('point.layouts.app')
 
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Laravel 8 CRUD Example</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('point') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
    <tr>
            <th>Routes_id:</th>
            <td>{{ $point->routes_id }}</td>
        </tr>
        <tr>
            <th>Name:</th>
            <td>{{ $point->name }}</td>
        </tr>
        <tr>
            <th>Description:</th>
            <td>{{ $point->description }}</td>
        </tr>
        <tr>
            <th>Images:</th>
            <td>{{ $point->images }}</td>
        </tr>
        <tr>
            <th>VideoUrl:</th>
            <td>{{ $point->videoUrl }}</td>
        </tr>
        <tr>
            <th>Coordinate:</th>
            <td>{{ $point->coordinate }}</td>
        </tr>
 
    </table>
@endsection