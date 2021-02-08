@extends('point.layouts.app')
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Pontos de Interesse</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('points.create') }}">Add</a>
        </div>
    </div>
 
    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif
 
    <table class="table table-bordered">
        <tr>
            <th>No</th>
            <th>ID rota</th>
            <th>nome</th>
            <th>descriçao</th>
            <th>imagen</th>
            <th>video</th>
            <th>coordenadas</th>

            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($points as $point)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $point->routes_id }}</td>
                <td>{{ $point->name }}</td>
                <td>{{ $point->description }}</td>
                <td><img src="{{ $point->images }}" alt="" height=100 width=100></td>
                <td>{{ $point->videoUrl }}</td>
                <td>{{ $point->coordinate }}</td>
                <td>
                    <form action="{{ route('points.destroy',$point->id) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('points.show',$point->id) }}">Detalhes</a>
                        <a class="btn btn-primary" href="{{ route('points.edit',$point->id) }}">Editar</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Eliminar</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection