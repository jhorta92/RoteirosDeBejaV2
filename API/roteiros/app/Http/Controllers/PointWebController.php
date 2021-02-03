<?php

namespace App\Http\Controllers;

use App\Models\Point;
use Illuminate\Http\Request;

class PointWebController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $points = Point::all();
        return view('point.list', compact('points'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        return view('point.create');
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
            'routes_id'=>'required',
            'name'=>'required',
            'iescription'=> 'required',
            'images' => 'required',
            'videoUrl' => 'required',
            'coordinate' => 'required'

        ]);
 
        $point = new Point([
            'routes_id' => $request->get('routes_id'),
            'name' => $request->get('name'),
            'description'=> $request->get('description'),
            'images'=> $request->get('images'),
            'videoUrl'=> $request->get('videoUrl'),
            'coordinate'=> $request->get('coordinate')

        ]);
 
        $point->save();
        return redirect('/point')->with('success', 'Point has been added');
    }
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Point  $point
     * @return \Illuminate\Http\Response
     */
    public function show(Point $point)
    {
        //
        return view('point.view',compact('point'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Point  $point
     * @return \Illuminate\Http\Response
     */
    public function edit(Point $point)
    {
        //
        return view('point.edit',compact('point'));

    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Point  $point
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Point $point)
    {
        //
        $request->validate([
            'routes_id'=>'required',
            'name'=>'required',
            'description'=> 'required',
            'images' => 'required',
            'videoUrl' => 'required',
            'coordinate' => 'required'
        ]);
 
 
        $point = Point::find($id);
        $point->routes_id = $request->get('routes_id');
        $point->name = $request->get('name');
        $point->description = $request->get('description');
        $point->images = $request->get('images');
        $point->videoUrl = $request->get('videoUrl');
        $point->coordinate = $request->get('coordinate');
        
 
        $point->update();
 
        return redirect('/point')->with('success', 'point updated successfully');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Point  $point
     * @return \Illuminate\Http\Response
     */
    public function destroy(Point $point)
    {
        //
        $point->delete();
        return redirect('/point')->with('success', 'Point deleted successfully');
    }
}
