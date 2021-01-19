<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Ponto;
use App\Http\Resources\Ponto as PontoResource;

class PontoController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index($id)
    {
        //
        $p = Ponto::all()->where('id_rota','=',$id);
        return PontoResource::collection($p);
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
        $p = Ponto::findOrFail($id);
        return new PontoResource($p);
   
    }
}
