@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Laravel 8 CRUD Example</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('point.create') }}">Add</a>
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
            <th>routes_id<th>
            <th>name</th>
            <th>description</th>
            <th>images</th>
            <th>videoUrl</th>
            <th>coordinate</th>
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
                <td>{{ $point->images }}</td>
                <td>{{ $point->videoUrl }}</td>
                <td>{{ $point->coordinate }}</td>
                <td>
                    <form action="{{ route('point.destroy',$point->id) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('point.show',$point->id) }}">Show</a>
                        <a class="btn btn-primary" href="{{ route('point.edit',$point->id) }}">Edit</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection