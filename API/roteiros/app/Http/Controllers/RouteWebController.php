<?php

namespace App\Http\Controllers;

use App\Models\Route;
use Illuminate\Http\Request;

class RouteWebController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $routes = Route::all();
        return view('route.list', compact('routes'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        return view('route.create');
        
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
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

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Route  $route
     * @return \Illuminate\Http\Response
     */
    public function show(Route $route)
    {
        //
        return view('route.view',compact('route'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Route  $route
     * @return \Illuminate\Http\Response
     */
    public function edit(Route $route)
    {
        //
        return view('route.edit',compact('route'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Route  $route
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
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

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Route  $route
     * @return \Illuminate\Http\Response
     */
    public function destroy(Route $route)
    {
        //
        $route->delete();
        return redirect('/route')->with('success', 'Route deleted successfully');
    }
}
