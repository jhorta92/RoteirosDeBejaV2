<?php

namespace App\Http\Controllers;

use App\Models\Route;
use Illuminate\Http\Request;
use App\Http\Resources\Route as RouteResource;
use App\Http\Requests;


class RouteWebController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $routes = Route::latest()->paginate(5);
        return view('route.list',compact('routes'))
        ->with('i', (request()->input('page', 1) -1) * 5);
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
            'txtName'=>'required',
            'txtDescription'=> 'required',
            'txtImage' => 'required',
            'txtVideoUrl' => 'required'
            
        ]);
 
        $route = new Route([
            'name' => $request->get('txtName'),
            'description'=> $request->get('txtDescription'),
            'images'=> $request->get('txtImage'),
            'videoUrl'=> $request->get('txtVideoUrl')
        ]);
 
        $route->save();
        return redirect('/routes')->with('success', 'Route has been added');
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
            'txtName'=>'required',
            'txtDescription'=> 'required',
            'txtImage' => 'required',
            'txtVideoUrl' => 'required'
        ]);
 
 
        $route = Route::find($id);
        $route->name = $request->get('txtName');
        $route->description = $request->get('txtDescription');
        $route->images = $request->get('txtImage');
        $route->videoUrl = $request->get('txtVideoUrl');
 
        $route->update();
 
        return redirect('/routes')->with('success', 'Rota atualizado com sucesso');
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
        return redirect('/routes')->with('success', 'Rota foi eliminada com Sucesso!');
    }
}
