<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Point;
use App\Http\Resources\Point as PointResource;

class PointController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index($id)
    {
        //
        $p = Point::all()->where('points_id','=',$id);
        return PointResource::collection($p);
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
        $p = Point::findOrFail($id);
        return new PointResource($p);
   
    }
    public function create()
    {
        //
        return view('point.create');
    }

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

    public function edit(Point $point)
    {
        //
        return view('point.edit',compact('point'));
    }

    public function update(Request $request,$id)
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
    public function destroy(Point $point)
    {
        //
        $point->delete();
        return redirect('/point')->with('success', 'Point deleted successfully');
    }
}
