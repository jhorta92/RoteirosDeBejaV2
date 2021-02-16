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
        $p = Point::all()->where('routes_id','=',$id);
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


    public function store(Request $request)
    {
        $point = Route::create($request->all());

        return response()->json($point, 201);
    }

    public function update(Request $request, Point $point)
    {
        $point->update($request->all());

        return response()->json($point, 200);
    }


    public function destroy(Point $point)
      {
          $point->delete();
  
          return response()->json(null, 204);
      }
    
}
