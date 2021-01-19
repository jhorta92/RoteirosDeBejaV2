<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Rota;
use App\Http\Resources\Rota as RotaResource;

class RotaController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
   
        //
        $p = Rota::all();
        return RotaResource::collection($p);
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
        $p = Rota::findOrFail($id);
        return new RotaResource($p);
    }

}
