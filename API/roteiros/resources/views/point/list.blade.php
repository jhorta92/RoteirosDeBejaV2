@extends('point.layouts.app')
@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Pontos de Interesse</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('points.create') }}">Adicionar</a>
        </div>
    </div>
 
    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif
 
    <table class="table table-bordered">
        <tr>
            <th>Nº</th>
            <th>Rota</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Imagem</th>
            <th>Vídeo</th>
            <th>Coordenadas</th>

            <th width="280px"></th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($points as $point)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $point->routes->name }}</td>
                <td>{{ $point->name }}</td>
                <td>{{ Str::limit($point->description, 30) }}</td>
                <td><img src="{{ $point->images }}" alt="" height=150 width=150></td>
                <td>{{ Str::limit($point->videoUrl, 20) }}</td>
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

