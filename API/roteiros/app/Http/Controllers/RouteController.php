<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Route;
use App\Http\Resources\Route as RouteResource;

class RouteController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
   
        //
        $p = Route::all();
        return RouteResource::collection($p);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
        $p = Route::findOrFail($id);
        return new RouteResource($p);
    }

    public function create()
    {
        //
        return view('route.create');
    }

    public function store(Request $request)
    {
        //
        $request->validate([
            'name'=>'required',
            'description'=> 'required',
            'images' => 'required',
            'videoUrl' => 'required'
            
        ]);
 
        $route = new Route([
            'name' => $request->get('name'),
            'description'=> $request->get('description'),
            'images'=> $request->get('images'),
            'videoUrl'=> $request->get('videoUrl')
        ]);
 
        $route->save();
        return redirect('/route')->with('success', 'Route has been added');
    }

    public function edit(Route $route)
    {
        //
        return view('route.edit',compact('route'));
    }

    public function update(Request $request,$id)
    {
        //
 
        $request->validate([
            'name'=>'required',
            'description'=> 'required',
            'images' => 'required',
            'videoUrl' => 'required'
        ]);
 
 
        $route = Route::find($id);
        $route->name = $request->get('name');
        $route->description = $request->get('description');
        $route->imagens = $request->get('imagens');
        $route->videoUrl = $request->get('videoUrl');
 
        $route->update();
 
        return redirect('/route')->with('success', 'route updated successfully');
    }
    public function destroy(Route $route)
    {
        //
        $route->delete();
        return redirect('/route')->with('success', 'Route deleted successfully');
    }
}
