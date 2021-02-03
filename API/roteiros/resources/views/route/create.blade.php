@section('content')
    <div class="row">
        <div class="col-lg-11">
            <h2>Add New route</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('route') }}"> Back</a>
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
    <form action="{{ route('route.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter  Name" name="name">
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" row="200" placeholder="Enter description" name="description"></textarea>
        </div>
        <div class="form-group">
            <label for="images">Images:</label>
            <textarea class="form-control" id="images" name="images" rows="200" placeholder="Enter images"></textarea>
        </div>
        </div>
        <div class="form-group">
            <label for="videoUrl">Video:</label>
            <textarea class="form-control" id="videoUrl" name="videoUrl" rows="200" placeholder="Enter videoUrl"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
@endsection