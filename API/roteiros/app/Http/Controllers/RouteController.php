<?php

namespace App\Http\Controllers;

use App\Models\Route;
use Illuminate\Http\Request;
use App\Http\Resources\Route as RouteResource;
use App\Http\Requests;


class RouteController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $route = Route::all();
        return RouteResource::collection($route);
    }

    public function createRoute(Request $request) {
        $route = new Route;
        $route->name = $request->name;
        $route->description = $request->description;
        $route->videoUrl = $request->videoUrl;
        $route->save();
    
        return response()->json([
            "message" => "route record created"
        ], 201);
      }

      public function show($id)
      {
          $route = Route::findOrFail($id);
          return new RouteResource($route);
      }
  
      public function store(Request $request)
      {
          $route = Route::create($request->all());
  
          return response()->json($route, 201);
      }
  
      public function update(Request $request, Route $route)
      {
          $route->update($request->all());
  
          return response()->json($route, 200);
      }
  
      public function destroy(Route $route)
      {
          $route->delete();
  
          return response()->json(null, 204);
      }
}
